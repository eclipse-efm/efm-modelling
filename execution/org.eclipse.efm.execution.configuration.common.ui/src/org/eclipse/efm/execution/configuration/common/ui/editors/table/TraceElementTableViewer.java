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
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.window.Window;
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

	final private Image IMG_ELCL16_CHECKED =
			ImageResources.getImage(ImageResources.IMG_ELCL16_CHECKED);

	final private Image IMG_ELCL16_UNCHECKED =
			ImageResources.getImage(ImageResources.IMG_ELCL16_UNCHECKED);

	final private Image IMG_ELCL16_ADD =
			ImageResources.getImage(ImageResources.IMG_ELCL16_ADD);

//	final private Image IMG_ELCL16_INFO =
//			ImageResources.getImage(ImageResources.IMG_ELCL16_INFO);

	final private Image IMG_ELCL16_QUICKASSIST =
			ImageResources.getImage(ImageResources.IMG_ELCL16_QUICKASSIST);

	private Composite fTableComposite;

	private TableViewer fTableViewer;

	private final TraceElementTableConfigProvider fTableConfig;

	private int SELECTION_COLUMN_INDEX;
	private int NATURE_COLUMN_INDEX;
	private int VALUE_COLUMN_INDEX;

	public static final String ADD_NEW_ELEMENT = "Add new element";


//	TableColumnLayout fTableColumnLayout;

	protected Action fAddingAction;

	protected Action fAddAction;
	protected Action fCopyAction;
	protected Action fEditAction;
	protected Action fRemoveAction;
	protected Action fClearAction;
	protected Action fMovedDownAction;
	protected Action fMovedUpAction;


	protected final AbstractConfigurationProfile fConfigurationProfile;


	public TraceElementTableViewer(final AbstractConfigurationProfile configurationProfile,
			final Composite parent, final int hspan, final IWidgetToolkit widgetToolkit,
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

	public void setInput(final TraceElement[] traceElements)
	{
		fTableViewer.setInput(traceElements);

		addNewElementItemForDoubleClick();
	}

	public void removeAll() {
		fTableViewer.getTable().removeAll();
	}


	public List<TraceElement> getTraceElements() {
		final ArrayList<TraceElement> traceElements = new ArrayList<TraceElement>();

		for( final TableItem tableItem : fTableViewer.getTable().getItems() ) {
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
			final Composite parent, final int hspan, final IWidgetToolkit widgetToolkit) {
		final Font font = parent.getFont();

		// Create table composite
		fTableComposite = widgetToolkit.createComposite(
				parent, font, 1, hspan, GridData.FILL_BOTH, 0, 0);

        final ViewForm viewForm = widgetToolkit.createViewForm(
        		fTableComposite, SWT.FLAT | SWT.BORDER);

        viewForm.setToolTipText( fTableConfig.TOOLTIP_TEXT );

		final Composite labelContainer = widgetToolkit.createComposite(
				viewForm, font, 1, 1, GridData.FILL_BOTH, 5, 5);
        widgetToolkit.createLabel(labelContainer, fTableConfig.TITLE, 1);
        viewForm.setTopLeft(labelContainer);

        final ToolBarManager toolBarManager= new ToolBarManager(SWT.FLAT);
        final ToolBar toolBar = toolBarManager.createControl(viewForm);
        toolBar.setBackground(parent.getBackground());
        viewForm.setTopRight(toolBar);

		createToolbarActions(toolBarManager);

		final Composite viewFormContents = widgetToolkit.createComposite(
				viewForm, SWT.FLAT, font, 1, 1, GridData.FILL_BOTH, 5, 5);

		createTableViewer(viewFormContents, widgetToolkit);

        viewForm.setContent(viewFormContents);
	}


	/**
	 * Creates all of the actions for the toolbar
	 */
	protected void createToolbarActions(final ToolBarManager tmanager) {
		tmanager.add(getAddingAction());

		tmanager.add(new Separator());

		tmanager.add(getAddAction());
		tmanager.add(getCopyAction());
		tmanager.add(getEditAction());

		tmanager.add(new Separator());

		tmanager.add(getRemoveAction());

		tmanager.add(new Separator());

		tmanager.add(getClearAction());

		tmanager.add(new Separator());

		tmanager.add(getMovedUpAction());
		tmanager.add(getMovedDownAction());
		tmanager.update(true);
	}


	protected void createTableViewer(
			final Composite tableContainer, final IWidgetToolkit widgetToolkit) {

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


		// make the selection available to other views
//		getSite().setSelectionProvider(fTableViewer);
		// set the sorter for the table

		// define layout for the TableViewer
		final GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, true, 2, 1);
		gridData.heightHint = fTableConfig.MAX_HEIGHT_HINT;

		fTableViewer.getControl().setLayoutData(gridData);

		fTableViewer.getControl().setToolTipText(fTableConfig.TOOLTIP_TEXT);

//		// Set providers
		fTableViewer.setContentProvider(new ArrayContentProvider() {
			@Override
			public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
				super.inputChanged(viewer, oldInput, newInput);
			}
		} );
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
	private void createColumns(final Composite tableComposite, final Font font) {
		SELECTION_COLUMN_INDEX = -1;
		NATURE_COLUMN_INDEX = 0;
		VALUE_COLUMN_INDEX = 1;

		if( fTableConfig.CHECKED_BOX_FOR_COLUMN_ZERO ) {
			SELECTION_COLUMN_INDEX = 0;
			NATURE_COLUMN_INDEX = 1;
			VALUE_COLUMN_INDEX = 2;

			// column for the TraceElement Selection
			final TableViewerColumn viewerColumn = createTableViewerColumn(
					fTableConfig.SELECTION_TITLE, fTableConfig.SELECTION_WIDTH,
					false, SELECTION_COLUMN_INDEX);

			viewerColumn.setEditingSupport(
					new TraceElementSelectionEditingSupport(this));

			viewerColumn.setLabelProvider( new ColumnLabelProvider() {
				@Override
				public String getText(final Object element) {
					return null;
				}

				@Override
				public Image getImage(final Object element) {
					final TraceElement traceElement = (TraceElement) element;
					switch( traceElement.getNature() ) {
					case TIPS:
						return IMG_ELCL16_QUICKASSIST;
					case UNDEFINED:
						return IMG_ELCL16_ADD;

					default:
						if( traceElement.isSelected() ) {
							return IMG_ELCL16_CHECKED;
						}
						else {
							return IMG_ELCL16_UNCHECKED;
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
			public String getText(final Object element) {
				final TraceElement traceElement = (TraceElement) element;
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
			public void update(final ViewerCell cell) {
				final TraceElement traceElement = (TraceElement) (cell.getElement());
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
			final String title, final int bound, final boolean resizable, final int colNumber) {
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


	private void updateLaunchConfigurationDialog() {
		fConfigurationProfile.getConfigurationPage().propagateGUIupdate();
	}


	public int lastTablePosition() {
		final Table table = fTableViewer.getTable();

		int itemCount = table.getItemCount();
		if( itemCount > 0 ) {
			itemCount = itemCount - 1;
			final TraceElement lastTraceElement =
					(TraceElement) table.getItem(itemCount).getData();
			if( lastTraceElement.getNature() == TraceElementKind.UNDEFINED ) {
				itemCount = itemCount - 1;
			}
		}

		return itemCount;
	}

	public void addNewElementItemForDoubleClick() {
		fTableViewer.add(new TraceElementCustomImpl(
				TraceElementKind.UNDEFINED, ADD_NEW_ELEMENT));
	}

	private void addNewfreshElementItem(final TraceElement newTraceElement) {
		TraceElementKind nature = fTableConfig.DEFAULT_TRACE_NATURE;

		final TableItem[] tableItems = fTableViewer.getTable().getItems();
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
	protected Action getAddingAction() {
		if( fAddingAction == null ) {
			fAddingAction = new Action() {
				@Override
				public void run() {
					handleAddingAction();
				}
			};

			fAddingAction.setText("Adding");
			fAddingAction.setToolTipText("Adding many elements");
			fAddingAction.setImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMG_ELCL16_ADD));
			fAddingAction.setDisabledImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMG_ELCL16_ADD));
		}

		return fAddingAction;
	}

	protected void handleAddingAction() {
		final TraceElementAddingDialog addingDialog =
				new TraceElementAddingDialog(this, null, null);

		if( addingDialog.open() == Window.OK ) {
	        updateLaunchConfigurationDialog();
		}
	}


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
							ImageResources.IMG_ELCL16_LIST_ADD));
			fAddAction.setDisabledImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMG_DLCL16_LIST_ADD));
		}

		return fAddAction;
	}

	protected void handleAddAction() {
		final Table table = fTableViewer.getTable();

		final int selectionIndex = table.getSelectionIndex();

		if( selectionIndex >= 0 ) {
			TraceElement selTraceElement =
				(TraceElement) table.getItem(selectionIndex).getData();

			if( selTraceElement.getNature() != TraceElementKind.UNDEFINED ) {
				selTraceElement = null;
				for( final TableItem item : table.getItems() ) {
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
						TraceElementKind.UNDEFINED, ADD_NEW_ELEMENT));
			}

	        updateLaunchConfigurationDialog();
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
							ImageResources.IMG_ELCL16_COPY));
			fCopyAction.setDisabledImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMG_ELCL16_COPY));
		}

		return fCopyAction;
	}


	protected void handleCopyAction() {
		final Table table = fTableViewer.getTable();

		final int selectionIndex = table.getSelectionIndex();
//		System.out.println( "Add:>selectionIndex: " + selectionIndex );

		if( selectionIndex >= 0 ) {
			TraceElement selTraceElement =
				(TraceElement) table.getItem(selectionIndex).getData();

			if( selTraceElement.getNature() == TraceElementKind.UNDEFINED ) {
				addNewfreshElementItem(selTraceElement);
			}
			else {
				for( final TableItem selection : table.getSelection() ) {
					selTraceElement = (TraceElement) selection.getData();

					fTableViewer.insert(
							new TraceElementCustomImpl(selTraceElement),
							(selectionIndex + 1));
				}

		        updateLaunchConfigurationDialog();
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
							ImageResources.IMG_ELCL16_LIST_EDIT));
			fEditAction.setDisabledImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMG_DLCL16_LIST_EDIT));

			fEditAction.setEnabled(true);
		}

		return fEditAction;
	}

	protected void handleEditAction() {
		final Table table = fTableViewer.getTable();

		final int selectionIndex = table.getSelectionIndex();

		if( selectionIndex >= 0 ) {
			final TraceElement selTraceElement =
				(TraceElement) table.getItem(selectionIndex).getData();

			if( selTraceElement.getNature() != TraceElementKind.UNDEFINED ) {
				fTableViewer.editElement(selTraceElement, VALUE_COLUMN_INDEX);

		        updateLaunchConfigurationDialog();
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
							ImageResources.IMG_ELCL16_LIST_DELETE));
			fRemoveAction.setDisabledImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMG_DLCL16_LIST_DELETE));
		}

		return fRemoveAction;
	}

	protected void handleRemoveAction() {
		final Table table = fTableViewer.getTable();

		final int selectionIndex = table.getSelectionIndex();

		if( selectionIndex >= 0 ) {
			for( final TableItem selection : table.getSelection() ) {
				fTableViewer.remove( selection.getData() );
			}

	        updateLaunchConfigurationDialog();
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
							ImageResources.IMG_ELCL16_DELETE));
			fClearAction.setDisabledImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMG_DLCL16_DELETE));
		}

		return fClearAction;
	}

	protected void handleClearAction() {
//		for( TableItem item : fTableViewer.getTable().getItems() ) {
//			fTableViewer.remove( item.getData() );
//		}
		fTableViewer.getTable().removeAll();
		addNewElementItemForDoubleClick();

        updateLaunchConfigurationDialog();
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
							ImageResources.IMG_ELCL16_LIST_MOVE_UP));
			fMovedUpAction.setDisabledImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMG_DLCL16_LIST_MOVE_UP));
		}

		return fMovedUpAction;
	}

	protected void handleMovedUpAction() {
		final Table table = fTableViewer.getTable();

		final int selectionIndex = table.getSelectionIndex();
//		System.out.println( "MovedUp:>selectionIndex: " + selectionIndex );

		if( selectionIndex > 0 ) {
			final TraceElement selTraceElement =
				(TraceElement) table.getItem(selectionIndex).getData();

			fTableViewer.remove(selTraceElement);
			fTableViewer.insert(selTraceElement, (selectionIndex - 1));

			table.setSelection(selectionIndex - 1);

	        updateLaunchConfigurationDialog();
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
							ImageResources.IMG_ELCL16_LIST_MOVE_DOWN));
			fMovedDownAction.setDisabledImageDescriptor(
					ImageResources.getImageDescriptor(
							ImageResources.IMG_DLCL16_LIST_MOVE_DOWN));
		}

		return fMovedDownAction;
	}

	protected void handleMovedDownAction() {
		final Table table = fTableViewer.getTable();

		final int selectionIndex = table.getSelectionIndex();

		if( selectionIndex >= 0 ) {
			final TraceElement selTraceElement =
				(TraceElement) table.getItem(selectionIndex).getData();

			if( (selTraceElement.getNature() != TraceElementKind.UNDEFINED)
				&& (selectionIndex < (table.getItemCount() - 2)) ) {

				fTableViewer.remove(selTraceElement);
				fTableViewer.insert(selTraceElement, (selectionIndex + 1));

				table.setSelection(selectionIndex + 1);

		        updateLaunchConfigurationDialog();
			}
		}
	}


	/**
	 * Diversity Field Editor Configuration API
	 * @param configuration
	 */
	public void setDefaults(final ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				fTableConfig.STORE_KEY, fTableConfig.DEFAULT_ATTRIBUTE_VALUE);
	}

	public void initializeFrom(final ILaunchConfiguration configuration) {
		final TraceSpecificationCustomImpl traceSpecification =
				TraceSpecificationCustomImpl.create("trace",
						configuration, fTableConfig.STORE_KEY,
						fTableConfig.DEFAULT_ATTRIBUTE_VALUE,
						TraceElementKind.UNDEFINED);

		final Predicate<TraceElement> tracePredicate =
				te -> (te.getNature() == TraceElementKind.UNDEFINED);

		traceSpecification.getElement().removeIf(tracePredicate);

		TraceElement[] traceElements = new TraceElement[0];

		traceElements = new TraceElement[ traceSpecification.getElement().size() ];

		traceSpecification.getElement().toArray(traceElements);

		setInput(traceElements);
	}

	public void performApply(final ILaunchConfigurationWorkingCopy configuration) {
		final TraceSpecificationCustomImpl traceSpecification =
				new TraceSpecificationCustomImpl( getTraceElements() );

//		System.out.println( fTableConfig.STORE_KEY );
//		System.out.println( fTableConfig.TITLE );
//		System.out.println( traceSpecification.toString() );
//		System.out.println();

		configuration.setAttribute(
				fTableConfig.STORE_KEY, traceSpecification.toSEW());
	}

	public boolean isValid(final ILaunchConfiguration configuration) {
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
