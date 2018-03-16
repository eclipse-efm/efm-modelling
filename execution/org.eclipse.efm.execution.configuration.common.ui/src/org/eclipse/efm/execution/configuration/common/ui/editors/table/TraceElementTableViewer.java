/*******************************************************************************
 * Copyright (c) 2016 CEA LIST
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr - initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.execution.configuration.common.ui.editors.table;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationProfile;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.core.workflow.common.TraceElement;
import org.eclipse.efm.execution.core.workflow.common.TraceElementCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.TraceElementKind;
import org.eclipse.efm.execution.core.workflow.common.TraceSpecificationCustomImpl;
import org.eclipse.efm.ui.utils.ImageResources;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;

public class TraceElementTableViewer {

	final private Image IMG_CHECKED =
			ImageResources.getImage(ImageResources.IMAGE__CHECKED_ICON);

	final private Image IMG_UNCHECKED =
			ImageResources.getImage(ImageResources.IMAGE__UNCHECKED_ICON);

	final private Image IMG_ADD =
			ImageResources.getImage(ImageResources.IMAGE__ADD_ELCL16_ICON);

//	final private Image IMG_INFO =
//			ImageResources.getImage(ImageResources.IMAGE__INFO_ELCL16_ICON);

	final private Image IMG_QUICKASSIST =
			ImageResources.getImage(ImageResources.IMAGE__QUICKASSIST_ELCL16_ICON);

	private Composite fTableComposite;

	private TableViewer fTableViewer;

	private final TraceElementTableConfigProvider fTableConfig;

	private int SELECTION_COLUMN_INDEX;
	private int NATURE_COLUMN_INDEX;
	private int VALUE_COLUMN_INDEX;

//	TableColumnLayout fTableColumnLayout;

	protected Action fAddAction;
	protected Action fCopyAction;
	protected Action fEditAction;
	protected Action fRemoveAction;
	protected Action fClearAction;
	protected Action fMovedDownAction;
	protected Action fMovedUpAction;


	protected final AbstractConfigurationProfile fConfigurationProfile;


	public TraceElementTableViewer(AbstractConfigurationProfile configurationProfile,
			Composite parent, int hspan, IWidgetToolkit widgetToolkit,
			final TraceElementTableConfigProvider tableConfig) {

		this.fConfigurationProfile = configurationProfile;

		this.fTableConfig = tableConfig;

		createControl(parent, hspan, widgetToolkit);
	}

	public Composite getControl() {
		return fTableComposite;
	}

	public TableViewer getTableViewer() {
		return fTableViewer;
	}

	public TraceElementTableConfigProvider getTableConfig() {
		return fTableConfig;
	}

	public void setInput(TraceElement[] traceElements)
	{
		fTableViewer.setInput(traceElements);

		addNewElementItemForDoubleClick();
	}

	public void setFocus() {
		fTableViewer.getControl().setFocus();
	}


	public void removeAll() {
		fTableViewer.getTable().removeAll();
	}



	public List<TraceElement> getTraceElements() {
		ArrayList<TraceElement> traceElements = new ArrayList<TraceElement>();

		for( TableItem tableItem : fTableViewer.getTable().getItems() ) {
			if( tableItem.getData() instanceof TraceElement ) {
				final TraceElement traceElement = (TraceElement) tableItem.getData();
				if( traceElement.getNature() != TraceElementKind.UNDEFINED ) {
					traceElements.add(traceElement);
				}
			}
		}

		return traceElements;
	}

	/**
	 * Create the TableViewer Control
	 * @param parent
	 * @param widgetToolkit
	 */
	protected void createControl(
			Composite parent, int hspan, IWidgetToolkit widgetToolkit) {
		Font font = parent.getFont();

		// Create table composite
		fTableComposite = widgetToolkit.createComposite(
				parent, font, 1, hspan, GridData.FILL_BOTH, 0, 0);

        ViewForm viewForm = widgetToolkit.createViewForm(
        		fTableComposite, SWT.FLAT | SWT.BORDER);

        viewForm.setToolTipText( fTableConfig.TOOLTIP_TEXT );

		Composite labelContainer = widgetToolkit.createComposite(
				viewForm, font, 1, 1, GridData.FILL_BOTH, 5, 5);
        widgetToolkit.createLabel(labelContainer, fTableConfig.TITLE, 1);
        viewForm.setTopLeft(labelContainer);

        ToolBarManager toolBarManager= new ToolBarManager(SWT.FLAT);
        ToolBar toolBar = toolBarManager.createControl(viewForm);
        toolBar.setBackground(parent.getBackground());
        viewForm.setTopRight(toolBar);

		createToolbarActions(toolBarManager);

		Composite viewFormContents = widgetToolkit.createComposite(
				viewForm, SWT.FLAT, font, 1, 1, GridData.FILL_BOTH, 5, 5);

		createTableViewer(viewFormContents, widgetToolkit);

        viewForm.setContent(viewFormContents);
	}


	/**
	 * Creates all of the actions for the toolbar
	 */
	protected void createToolbarActions(ToolBarManager tmanager) {
		tmanager.add(getAddAction());
		tmanager.add(getCopyAction());
		tmanager.add(getEditAction());
		tmanager.add(new Separator());
		tmanager.add(getRemoveAction());
		tmanager.add(getClearAction());
		tmanager.add(new Separator());
		tmanager.add(getMovedUpAction());
		tmanager.add(getMovedDownAction());
		tmanager.update(true);
	}


	protected void createTableViewer(
			Composite tableContainer, IWidgetToolkit widgetToolkit) {

//		fTableColumnLayout = new TableColumnLayout(true);
//		tableComposite.setLayout(fTableColumnLayout);

		// Create table
		fTableViewer = new TableViewer(tableContainer, SWT.BORDER |
				SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI | SWT.FULL_SELECTION);

//!!		addMoveableRowSupport();

		// create Columns
		createColumns(tableContainer, tableContainer.getFont());

		final Table table = fTableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		int desiredHeight = table.getItemHeight() * 5 + table.getHeaderHeight();
//		if (tableContainer.getLayout() == null) { // <---
			table.setSize(200,desiredHeight);
//		} else {
//			table.setLayoutData(new GridData(200, desiredHeight)); // assumes GridLayout
//		}


		// make the selection available to other views
//		getSite().setSelectionProvider(fTableViewer);
		// set the sorter for the table

		// define layout for the TableViewer
		GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, true, 2, 1);
		fTableViewer.getControl().setLayoutData(gridData);

		fTableViewer.getControl().setToolTipText(fTableConfig.TOOLTIP_TEXT);

//		// Set providers
		fTableViewer.setContentProvider(new ArrayContentProvider());
//		fTableViewer.setLabelProvider(new TraceElementLabelProvider());

//		fTableViewer.addDoubleClickListener(new IDoubleClickListener() {
//			@Override
//			public void doubleClick(DoubleClickEvent event) {
//					handleDoubleClickEvent(event);
//			}
//		});


//!!		// Double click for edit TraceElement value column
//		TableViewerFocusCellManager focusCellManager =
//				new TableViewerFocusCellManager(fTableViewer,
//						new FocusCellOwnerDrawHighlighter(fTableViewer));
//
//		ColumnViewerEditorActivationStrategy activationSupport =
//				new ColumnViewerEditorActivationStrategy(fTableViewer) {
//			@Override
//			protected boolean isEditorActivationEvent(ColumnViewerEditorActivationEvent event) {
//				final EventObject source = event.sourceEvent;
//				// Enable editor only with mouse double click for value column
//				if( event.eventType == ColumnViewerEditorActivationEvent.MOUSE_DOUBLE_CLICK_SELECTION ) {
//					if( (source instanceof MouseEvent) && (((MouseEvent)source).button == 3) ) {
//						return false;
//					}
//
//					return true;
//				}
//				else if( (source instanceof MouseEvent) && (((MouseEvent)source).button != 3)
//						&& (! isSelectedColumn(source, VALUE_COLUMN_INDEX)) ) {
//					return true;
//				}
//				return false;
//			}
//		};
//
//		TableViewerEditor.create(fTableViewer, focusCellManager, activationSupport,
//				ColumnViewerEditor.TABBING_HORIZONTAL |
//				ColumnViewerEditor.TABBING_MOVE_TO_ROW_NEIGHBOR |
//				ColumnViewerEditor.TABBING_VERTICAL |
//				ColumnViewerEditor.KEYBOARD_ACTIVATION);
	}


//	private boolean isSelectedColumn(EventObject event, int column) {
//		if( event instanceof MouseEvent ) {
//			final MouseEvent mouseEvent = (MouseEvent) event;
//			final Table table = fTableViewer.getTable();
//			final Point point = new Point(mouseEvent.x, mouseEvent.y);
//
//			final TableItem item = table.getItem(point);
//			if( item == null ) {
//				return false;
//			}
//			for( int offset = 0; offset < table.getColumnCount(); ++offset ) {
//				final Rectangle rect = item.getBounds(offset);
//				if( rect.contains(point) ) {
////					System.out.println("Item row " + table.indexOf(item) + " - colum " + offset);
//					return( column == offset );
//				}
//			}
//		}
//		return false;
//	}


	// create the columns for the table
	private void createColumns(final Composite tableComposite, Font font) {
		SELECTION_COLUMN_INDEX = -1;
		NATURE_COLUMN_INDEX = 0;
		VALUE_COLUMN_INDEX = 1;

		if( fTableConfig.CHECKED_BOX_FOR_COLUMN_ZERO ) {
			SELECTION_COLUMN_INDEX = 0;
			NATURE_COLUMN_INDEX = 1;
			VALUE_COLUMN_INDEX = 2;

			// column for the TraceElement Selection
			TableViewerColumn viewerColumn = createTableViewerColumn(
					fTableConfig.SELECTION_TITLE, fTableConfig.SELECTION_WIDTH,
					false, SELECTION_COLUMN_INDEX);

			viewerColumn.setEditingSupport(
					new TraceElementSelectionEditingSupport(this));

			viewerColumn.setLabelProvider( new ColumnLabelProvider() {
				@Override
				public String getText(Object element) {
					return null;
				}

				@Override
				public Image getImage(Object element) {
					TraceElement traceElement = (TraceElement) element;
					switch( traceElement.getNature() ) {
					case TIPS:
						return IMG_QUICKASSIST;
					case UNDEFINED:
						return IMG_ADD;

					default:
						if( traceElement.isSelected() ) {
							return IMG_CHECKED;
						}
						else {
							return IMG_UNCHECKED;
						}
					}
				}
			});
		}


		// first column is for the TraceElement Nature
		TableViewerColumn viewerColumn =
				createTableViewerColumn(fTableConfig.NATURE_TITLE,
						fTableConfig.NATURE_WIDTH, true, NATURE_COLUMN_INDEX);

		viewerColumn.setEditingSupport(
				new TraceElementNatureEditingSupport(this));

		viewerColumn.setLabelProvider( new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				TraceElement traceElement = (TraceElement) element;
				switch( traceElement.getNature() ) {
				case UNDEFINED:
					return "Set nature to";

				default:
					return traceElement.getNature().getLiteral();
				}
			}
		});


		// second column is for the TraceElement Value
		viewerColumn = createTableViewerColumn(fTableConfig.VALUE_TITLE,
				fTableConfig.VALUE_WIDTH, true, VALUE_COLUMN_INDEX);

		viewerColumn.setEditingSupport(new TraceElementValueEditingSupport(this));

		viewerColumn.setLabelProvider(new StyledCellLabelProvider() {
			@Override
			public void update(ViewerCell cell) {
				TraceElement traceElement = (TraceElement) (cell.getElement());
				cell.setText(traceElement.getValue().toString());
//				StyleRange myStyledRange =
//						new StyleRange(16, 2, null,
//								Display.getCurrent().getSystemColor(SWT.COLOR_YELLOW));
//				StyleRange[] range = { myStyledRange };
//				cell.setStyleRanges(range);
				super.update(cell);
			}
		});

//		viewerColumn.setLabelProvider(new ColumnLabelProvider() {
//			@Override
//			public String getText(Object element) {
//				TraceElement traceElement = (TraceElement) element;
//				return traceElement.getValue().toString();
//			}
//		});


		// third column is for the selection facilities
//		viewerColumn = createTableViewerColumn(" ", 20, true, columnOffset + 2);
//
//		viewerColumn.setLabelProvider( new ColumnLabelProvider() {
//			@Override
//			public String getText(Object element) {
//				return null;
//			}
//		});
	}


	private TableViewerColumn createTableViewerColumn(
			String title, int bound, boolean resizable, final int colNumber) {
		final TableViewerColumn viewerColumn =
				new TableViewerColumn(fTableViewer, SWT.NONE);

		final TableColumn column = viewerColumn.getColumn();

		column.setText(title);
		column.setWidth(bound);

//		fTableColumnLayout.setColumnData(column, new ColumnWeightData(100, bound));

		column.setWidth(bound);
		column.setResizable(resizable);
		column.setMoveable(false);
		return viewerColumn;
	}


	public void addNewElementItemForDoubleClick() {
		fTableViewer.add(new TraceElementCustomImpl(
				TraceElementKind.UNDEFINED, "Add new element"));
	}

	private void addNewfreshElementItem(TraceElement newTraceElement) {
		TraceElementKind nature = fTableConfig.DEFAULT_TRACE_NATURE;

		TableItem[] tableItems = fTableViewer.getTable().getItems();
		for( int index = tableItems.length - 1 ; index >= 0 ; --index ) {
			final TraceElement traceElement =
					(TraceElement) tableItems[index].getData();

			switch( traceElement.getNature() ) {
			case TIPS:
			case UNDEFINED:
				break;

			default:
				nature = traceElement.getNature();
				index = -1;
				break;
			}
		}

		newTraceElement.setNature(nature);
		newTraceElement.setValue(nature.getLiteral() + "_new");

		addNewElementItemForDoubleClick();

		fTableViewer.update(newTraceElement, null);
	}


//	private void handleDoubleClickEvent(DoubleClickEvent event) {
//		if( event.getSelection().isEmpty() ) {
//			addNewElementItemForDoubleClick();
//		}
//		else {
//			if( event.getSelection() instanceof IStructuredSelection ) {
//				Object selection = ((IStructuredSelection) event.getSelection()).getFirstElement();
//				if( selection instanceof TraceElement ) {
//					TraceElement selTraceElement = (TraceElement) selection;
//					if( selTraceElement.getNature() == TraceElementKind.UNDEFINED ) {
//						addNewfreshElementItem(selTraceElement);
//					}
//				}
//			}
//
////			TableItem[] selection = fTableViewer.getTable().getSelection();
////			for( TableItem item : selection ) {
////				fTableViewer.add( item.getData() );
////
////				System.out.println("DoubleClick: " + item.getData());
////			}
//		}
//	}

//	private void addMoveableRowSupport() {
//		Transfer[] transferTypes  = new Transfer[] { LocalSelectionTransfer.getTransfer() };
//
//		fTableViewer.addDragSupport(DND.DROP_MOVE | DND.DROP_COPY,
//				transferTypes , new DragSourceAdapter() {
//			@Override
//			public void dragSetData(DragSourceEvent event) {
//				// Get the selected items in the drag source
//				if(transferTypes[0].isSupportedType(event.dataType) ) {
//					TableItem[] selection = fTableViewer.getTable().getSelection();
//					for( TableItem item : selection ) {
//						System.out.println("drag: " + item.getData());
//
//						event.data = item.getData();
//					}
//				}
//			}
//		});
//
//		fTableViewer.addDropSupport(DND.DROP_MOVE | DND.DROP_COPY,
//				transferTypes , new ViewerDropAdapter(fTableViewer) {
//			@Override
//			public boolean validateDrop(Object target, int operation, TransferData transferType) {
//				return (target instanceof TraceElement);
//			}
//
//			@Override
//			public void drop(DropTargetEvent event) {
//				int location = this.determineLocation(event);
//				TraceElement target = (TraceElement) determineTarget(event);
//				String translatedLocation = "";
//				switch (location){
//				case 1 :
//					translatedLocation = "Dropped before the target: ";
//					break;
//				case 2 :
//					translatedLocation = "Dropped after the target: ";
//					break;
//				case 3 :
//					translatedLocation = "Dropped on the target: ";
//					break;
//				case 4 :
//					translatedLocation = "Dropped into nothing: ";
//					break;
//				}
//				System.out.print(translatedLocation);
//				System.out.println("the drop was done on the element: " + target );
//				super.drop(event);
//			}
//
//
//			@Override
//			public boolean performDrop(Object data) {
//				TableItem[] selection = fTableViewer.getTable().getSelection();
//				for( TableItem item : selection ) {
//					fTableViewer.add( item.getData() );
//
//					System.out.println("drop: " + item.getData());
//				}
//
//				return false;
//			}
//		});
//
//	}

	/**
	 * Responds to a list event action in the TraceElement table
	 */
	protected Action getAddAction() {
		if( fAddAction == null ) {
			fAddAction = new Action() {
				@Override
				public void run() {
					handleAddAction();
				}
			};

			fAddAction.setText("Add");
			fAddAction.setToolTipText("Add new element");
			fAddAction.setImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMAGE__LIST_ADD_ELCL16_ICON));
			fAddAction.setDisabledImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMAGE__LIST_ADD_DLCL16_ICON));
		}

		return fAddAction;
	}

	protected void handleAddAction() {
		int selectionIndex = fTableViewer.getTable().getSelectionIndex();

		if( selectionIndex >= 0 ) {
			TraceElement selTraceElement =
				(TraceElement) fTableViewer.getTable().getItem(selectionIndex).getData();

			if( selTraceElement.getNature() != TraceElementKind.UNDEFINED ) {
				selTraceElement = null;
				for( TableItem item : fTableViewer.getTable().getItems() ) {
					if( ((TraceElement) item.getData()).getNature() == TraceElementKind.UNDEFINED ) {
						selTraceElement = (TraceElement) item.getData();
					}
				}
			}
			if( selTraceElement != null ) {
				addNewfreshElementItem(selTraceElement);
			}
			else {
				fTableViewer.add(new TraceElementCustomImpl(
						TraceElementKind.UNDEFINED, "Add new element"));
			}
		}
	}


	protected Action getCopyAction() {
		if( fCopyAction == null ) {
			fCopyAction = new Action() {
				@Override
				public void run() {
					handleCopyAction();
				}
			};

			fCopyAction.setText("Copy");
			fCopyAction.setToolTipText("Copy selected elements");
			fCopyAction.setImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMAGE__COPY_ELCL16_ICON));
			fCopyAction.setDisabledImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMAGE__COPY_ELCL16_ICON));
		}

		return fCopyAction;
	}


	protected void handleCopyAction() {
		int selectionIndex = fTableViewer.getTable().getSelectionIndex();
//		System.out.println( "Add:>selectionIndex: " + selectionIndex );

		if( selectionIndex >= 0 ) {
			TraceElement selTraceElement =
				(TraceElement) fTableViewer.getTable().getItem(selectionIndex).getData();

			if( selTraceElement.getNature() == TraceElementKind.UNDEFINED ) {
				addNewfreshElementItem(selTraceElement);
			}
			else {
				for( TableItem selection : fTableViewer.getTable().getSelection() ) {
					selTraceElement = (TraceElement) selection.getData();

					fTableViewer.insert(
							new TraceElementCustomImpl(selTraceElement),
							(selectionIndex + 1));
				}

			}
		}
	}


	protected Action getEditAction() {
		if( fEditAction == null ) {
			fEditAction = new Action() {
				@Override
				public void run() {
					handleEditAction();
				}
			};

			fEditAction.setText("Edit");
			fEditAction.setToolTipText("Edit new element");
			fEditAction.setImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMAGE__LIST_EDIT_ELCL16_ICON));
			fEditAction.setDisabledImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMAGE__LIST_EDIT_DLCL16_ICON));

			fEditAction.setEnabled(true);
		}

		return fEditAction;
	}

	protected void handleEditAction() {
		int selectionIndex = fTableViewer.getTable().getSelectionIndex();

		if( selectionIndex >= 0 ) {
			TraceElement selTraceElement =
				(TraceElement) fTableViewer.getTable().getItem(selectionIndex).getData();

			if( selTraceElement.getNature() != TraceElementKind.UNDEFINED ) {
				fTableViewer.editElement(selTraceElement, VALUE_COLUMN_INDEX);
			}
		}
	}


	protected Action getRemoveAction() {
		if( fRemoveAction == null ) {
			fRemoveAction = new Action() {
				@Override
				public void run() {
					handleRemoveAction();
				}
			};

			fRemoveAction.setText("Remove");
			fRemoveAction.setToolTipText("Remove selected elements");
			fRemoveAction.setImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMAGE__LIST_DELETE_ELCL16_ICON));
			fRemoveAction.setDisabledImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMAGE__LIST_DELETE_DLCL16_ICON));
		}

		return fRemoveAction;
	}

	protected void handleRemoveAction() {
		int selectionIndex = fTableViewer.getTable().getSelectionIndex();

		if( selectionIndex >= 0 ) {
			for( TableItem selection : fTableViewer.getTable().getSelection() ) {
				fTableViewer.remove( selection.getData() );
			}
		}
	}

	protected Action getClearAction() {
		if( fClearAction == null ) {
			fClearAction = new Action() {
				@Override
				public void run() {
					handleClearAction();
				}
			};

			fClearAction.setText("RemoveAll");
			fClearAction.setToolTipText("Remove all elements");
			fClearAction.setImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMAGE__DELETE_ELCL16_ICON));
			fClearAction.setDisabledImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMAGE__DELETE_DLCL16_ICON));
		}

		return fClearAction;
	}

	protected void handleClearAction() {
//		for( TableItem item : fTableViewer.getTable().getItems() ) {
//			fTableViewer.remove( item.getData() );
//		}
		fTableViewer.getTable().removeAll();
		addNewElementItemForDoubleClick();
	}


	protected Action getMovedUpAction() {
		if( fMovedUpAction == null ) {
			fMovedUpAction = new Action() {
				@Override
				public void run() {
					handleMovedUpAction();
				}
			};

			fMovedUpAction.setText("MovedUp");
			fMovedUpAction.setToolTipText("MovedUp selected element");
			fMovedUpAction.setImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMAGE__LIST_MOVE_UP_ELCL16_ICON));
			fMovedUpAction.setDisabledImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMAGE__LIST_MOVE_UP_DLCL16_ICON));
		}

		return fMovedUpAction;
	}

	protected void handleMovedUpAction() {
		int selectionIndex = fTableViewer.getTable().getSelectionIndex();
//		System.out.println( "MovedUp:>selectionIndex: " + selectionIndex );

		if( selectionIndex > 0 ) {
			TraceElement selTraceElement =
				(TraceElement) fTableViewer.getTable().getItem(selectionIndex).getData();

			fTableViewer.remove(selTraceElement);
			fTableViewer.insert(selTraceElement, (selectionIndex - 1));

			fTableViewer.getTable().setSelection(selectionIndex - 1);
		}
	}


	protected Action getMovedDownAction() {
		if( fMovedDownAction == null ) {
			fMovedDownAction = new Action() {
				@Override
				public void run() {
					handleMovedDownAction();
				}
			};

			fMovedDownAction.setText("MovedDown");
			fMovedDownAction.setToolTipText("MovedDown selected element");
			fMovedDownAction.setImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMAGE__LIST_MOVE_DOWN_ELCL16_ICON));
			fMovedDownAction.setDisabledImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMAGE__LIST_MOVE_DOWN_DLCL16_ICON));
		}

		return fMovedDownAction;
	}

	protected void handleMovedDownAction() {
		int selectionIndex = fTableViewer.getTable().getSelectionIndex();

		if( selectionIndex >= 0 ) {
			TraceElement selTraceElement =
				(TraceElement) fTableViewer.getTable().getItem(selectionIndex).getData();

			if( (selTraceElement.getNature() != TraceElementKind.UNDEFINED)
				&& (selectionIndex < (fTableViewer.getTable().getItemCount() - 2)) ) {

				fTableViewer.remove(selTraceElement);
				fTableViewer.insert(selTraceElement, (selectionIndex + 1));

				fTableViewer.getTable().setSelection(selectionIndex + 1);
			}
		}
	}


	/**
	 * Diversity Field Editor Configuration API
	 * @param configuration
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				fTableConfig.STORE_KEY, fTableConfig.DEFAULT_ATTRIBUTE_VALUE);
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		TraceSpecificationCustomImpl traceSpecification =
				TraceSpecificationCustomImpl.create("trace",
						configuration, fTableConfig.STORE_KEY,
						fTableConfig.DEFAULT_ATTRIBUTE_VALUE,
						TraceElementKind.UNDEFINED);

		Predicate<TraceElement> tracePredicate =
				te -> (te.getNature() == TraceElementKind.UNDEFINED);

		traceSpecification.getElement().removeIf(tracePredicate);

		TraceElement[] traceElements = new TraceElement[0];

		traceElements = new TraceElement[ traceSpecification.getElement().size() ];

		traceSpecification.getElement().toArray(traceElements);

		setInput(traceElements);
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		final TraceSpecificationCustomImpl traceSpecification =
				new TraceSpecificationCustomImpl( getTraceElements() );

//		System.out.println( fTableConfig.STORE_KEY );
//		System.out.println( fTableConfig.TITLE );
//		System.out.println( traceSpecification.toString() );
//		System.out.println();

		configuration.setAttribute(
				fTableConfig.STORE_KEY, traceSpecification.toSEW());

	}

	public boolean isValid(ILaunchConfiguration configuration) {
		// Trace Sequence Validation
//		String[] tabString = new String[0];
////				fBehaviorSpecificationStringField.getStringValue().split(";\n");
//
//		String kind;
//		int pos;
//
//		for(String eltString : tabString) {
//			eltString = eltString.trim();
//
//			if( eltString.length() == 0 ) {
//				fConfigurationProfile.setErrorMessage("You must select at least one element");
//				return false;
//			}
//			else if( eltString.startsWith("//") ) {
//				//!! TIPS
//			}
//			else if( (pos = eltString.indexOf('=')) > 0 ) {
//				kind = eltString.substring(0, pos).trim();
////				object = eltString.substring(pos+1).trim();
//
//				if( kind.equals( "transition" ) ) {
//					// Check if the object is a transition and exists !
//				}
//				else if( kind.equals( "state" ) ) {
//					// Check if the object is a state and exists !
//				}
//
//				else if( kind.equals( "input" ) ) {
//					// Check if the object is an input port/signal and exists !
//				}
//				else if( kind.equals( "output" ) ) {
//					// Check if the object is an output port/signal and exists !
//				}
//
//				else if( kind.equals( "inout" ) ) {
//					// Check if the object is an inout port/signal and exists !
//				}
//				else if( kind.equals( "com" ) ) {
//					// Check if the object is a communicated port/signal and exists !
//				}
//
//				else {
//					fConfigurationProfile.setErrorMessage(
//						"The element \"" + eltString + "\" is not a valid element");
//
//					return false;
//				}
//			}
//			else {
//				fConfigurationProfile.setErrorMessage(
//					"The element \"" + eltString + "\" is not a valid element");
//				return false;
//			}
//		}

		return true;
	}

}
