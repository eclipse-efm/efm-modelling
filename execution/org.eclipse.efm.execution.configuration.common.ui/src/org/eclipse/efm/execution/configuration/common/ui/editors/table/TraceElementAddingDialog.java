/**
 * Copyright (c) 2018 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *   - Initial API and Implementation
 */
package org.eclipse.efm.execution.configuration.common.ui.editors.table;

import org.eclipse.efm.execution.core.workflow.common.TraceElement;
import org.eclipse.efm.execution.core.workflow.common.TraceElementCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.TraceElementKind;
import org.eclipse.efm.execution.core.workflow.common.TraceSpecificationCustomImpl;
import org.eclipse.efm.sew.xtext.ui.internal.XtextActivator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.util.Util;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;

import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class TraceElementAddingDialog extends PopupDialog {

	private static final String EMPTY_STRING = "";

	private final TraceElementTableViewer fTraceElementTableViewer;

	private final TableViewer fTableViewer;

//	private Text fTexField;
	private EmbeddedEditorModelAccess fEmbededEditorModelAccess;


	public TraceElementAddingDialog(TraceElementTableViewer traceElementTableViewer,
			String titleText, String infoText)
	{
		super(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				PopupDialog.INFOPOPUP_SHELLSTYLE | SWT.RESIZE,
				true /*takeFocusOnOpen*/, true /*persistSize*/,
				false /*persistLocation*/, false /*showDialogMenu*/,
				true /*showPersistActions*/, titleText, infoText);


		this.fTraceElementTableViewer = traceElementTableViewer;

		this.fTableViewer = traceElementTableViewer.getTableViewer();

//		this.fTexField = null;
		this.fEmbededEditorModelAccess = null;
	}


	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		boolean isWin32 = Util.isWindows();
		GridLayoutFactory.fillDefaults().extendedMargins(isWin32 ? 0 : 3, 3, 2, 2)
				.applyTo(composite);

//		fTexField = new Text(composite, SWT.BORDER | SWT.MULTI | SWT.WRAP |
//				/*SWT.H_SCROLL |*/ SWT.V_SCROLL);
//		GridData gd = new GridData(GridData.FILL_BOTH);
//		gd.horizontalIndent=PopupDialog.POPUP_HORIZONTALSPACING;
//		gd.verticalIndent=PopupDialog.POPUP_VERTICALSPACING;
//		gd.horizontalSpan = 2;
//		fTexField.setLayoutData(gd);
//
//		fTexField.setText( getClipBoard() );

		createEmbededXtextSEWEditor(composite);

		Button addingButton = new Button(parent, SWT.PUSH);;
		addingButton.setText("Adding Element...");
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		addingButton.setLayoutData(gd);
		addingButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				handleAddingTraceElement();

				TraceElementAddingDialog.this.close();
			}
		});

		return composite;
	}


	private void createEmbededXtextSEWEditor(Composite parent) {
		XtextActivator activator = XtextActivator.getInstance();
		Injector injector =
				activator.getInjector(XtextActivator.ORG_ECLIPSE_EFM_SEW_XTEXT_SEW);

		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);

		IEditedResourceProvider resourceProvider = new IEditedResourceProvider() {
			@Override
			public XtextResource createResource() {
				try {
					Resource resource = resourceSet.createResource(
							URI.createURI(".sew/workflow-trace-configuration.sew"));

					return (XtextResource) resource;
				} catch (Exception e) {
					return null;
				}
			}
		};

		EmbeddedEditorFactory factory = injector.getInstance(EmbeddedEditorFactory.class);

		EmbeddedEditor handle = factory.newEditor(resourceProvider).withParent(parent);

		fEmbededEditorModelAccess = handle.createPartialEditor(EMPTY_STRING, getClipBoard(), EMPTY_STRING, false);
	}


	private String getClipBoard() {
		Clipboard clipboard = new Clipboard(Display.getCurrent());

		TextTransfer textTransfer = TextTransfer.getInstance();

		String textData = (String) clipboard.getContents(textTransfer);

		clipboard.dispose();

		if( (textData != null) && (! textData.isEmpty()) ) {
			for ( TraceElementKind nature :
				fTraceElementTableViewer.getTableConfig().VALID_TRACE_NATURES ) {
				if( textData.contains(nature.getLiteral()) ) {
					return textData;
				}
			}

		}

		return EMPTY_STRING;
	}

	private void handleAddingTraceElement() {
//		String traceText = fTexField.getText();
		String traceText = fEmbededEditorModelAccess.getEditablePart();

		if( traceText != null ) {
			TraceSpecificationCustomImpl trace =
					TraceSpecificationCustomImpl.create("edited_trace", traceText,
							fTraceElementTableViewer.getTableConfig().DEFAULT_TRACE_NATURE);

			int selectionIndex = fTableViewer.getTable().getSelectionIndex();
			if( selectionIndex < 0 ) {
				selectionIndex = fTraceElementTableViewer.lastTablePosition();
			}

			for( TraceElement element : trace.getElement() ) {
				fTableViewer.insert(
						new TraceElementCustomImpl(element),
						++selectionIndex);
			}
		}
	}


	@Override
	protected void adjustBounds() {
		super.adjustBounds();
		Display display = Display.getCurrent();
		if( display == null ) {
			display = Display.getDefault();
		}
		Point point = display.getCursorLocation();
		getShell().setLocation(point.x, point.y + 21);
	}

	@Override
	protected Point getDefaultSize() {
		Rectangle tableBounds = fTableViewer.getTable().getBounds();

		return new Point(Math.min(tableBounds.width, 320), tableBounds.height);
	}

}
