/*****************************************************************************
* Copyright (c) 2012 CEA LIST.
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
*  - Initial API and implementation
*****************************************************************************/

package org.eclipse.efm.papyrus.view.property.concretesyntax.sheet;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.efm.formalml.xtext.ui.internal.XtextActivator;
import org.eclipse.efm.papyrus.view.property.concretesyntax.ActivatorXLIAProperties;
import org.eclipse.efm.papyrus.view.property.concretesyntax.internal.command.UpdateOperationCommand;
import org.eclipse.efm.papyrus.view.property.concretesyntax.internal.command.UpdateTransitionCommand;
import org.eclipse.efm.papyrus.view.property.concretesyntax.internal.job.ExecuteCommandJob;
import org.eclipse.efm.papyrus.view.property.concretesyntax.sheet.tooling.StyledTextWithUndoRedo;
import org.eclipse.efm.papyrus.view.property.concretesyntax.sheet.tooling.UndoStyledTextManager;
import org.eclipse.efm.papyrus.view.property.concretesyntax.sheet.tooling.listeners.EditorFocusListener;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.xtext.integration.StyledTextXtextAdapter;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.SubActionBars;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Injector;

/**
 * Property view contribution for the ALF editor
 */
public class EditingPropertySection extends
		AbstractModelerPropertySection implements IContextElementProvider {

	private FormToolkit toolkit;

	private Form form;

	String fRefreshEditedTextBakup;

	private StyledTextWithUndoRedo fStyledText;
	UndoStyledTextManager fUndoManager;


	SubActionBars fSubActionBars;
	Action fRevertAction;
	Action fCommitAction;

	public final String COMMIT_ACTION_DEFAULT_TEXT = "Commit";
	public final String COMMIT_ACTION_DEFAULT_DESCRIPTION = "Commit and Push to Model";

//	private Button commitButton;

	private StyledTextXtextAdapter styledTextAdapter;

	final private ContextElementAdapter contextElementAdapter = new ContextElementAdapter(this);

	protected boolean isUndo;

	protected boolean isRedo;

	private Injector xliaToolingInjector;

	private EObject previousEObject;

	private EditingPropertyCodeGenerator fCodeGenerator;

	public EditingPropertySection() {
		this.previousEObject = null;

		this.xliaToolingInjector = XtextActivator.getInstance().getInjector(
				XtextActivator.ORG_ECLIPSE_EFM_FORMALML_XTEXT_FORMALML);

		this.fCodeGenerator = new EditingPropertyCodeGenerator();
	}

	public StyledText getEditor() {
		return this.fStyledText;
	}


	protected boolean isEditableElement(EObject eObject) {
		return( (this.eObject instanceof Transition) ||
				(this.eObject instanceof Operation ) );
	}


	@Override
	public void refresh() {
		/* 1. Compute edit string */
		fRefreshEditedTextBakup = "/*Error: serialization could not be computed*/";

		if( this.eObject != null ) {
			this.fCodeGenerator.reset();

			fRefreshEditedTextBakup =
					this.fCodeGenerator.performTransform( this.eObject );
		}

		/* 2. Update adapters placed over the xtext resource */
		if( this.previousEObject != this.eObject ) {
			this.updateXtextAdapters(this.fStyledText);
			this.previousEObject = this.eObject;

			if( isEditableElement(this.eObject) ){
//				aboutToBeShown();
				String commitText = COMMIT_ACTION_DEFAULT_TEXT;
				String commitDescription = COMMIT_ACTION_DEFAULT_DESCRIPTION;
				if( this.eObject instanceof Transition ) {
					commitText ="Commit Transition";
					commitDescription ="Commit Transition(guard, tguard, effect)";
				}
				else if( this.eObject instanceof Operation ) {
					commitText = "Commit Operation";
					commitDescription = "Commit Operation Opaque xLIA behavior method";
				}
				fCommitAction.setText(commitText);
				fCommitAction.setToolTipText(commitDescription);

				fCommitAction.setEnabled(true);
				fRevertAction.setEnabled(true);
			}
			else {
//				aboutToBeHidden();
				fCommitAction.setText(COMMIT_ACTION_DEFAULT_TEXT);
				fCommitAction.setToolTipText(COMMIT_ACTION_DEFAULT_DESCRIPTION);

				fCommitAction.setEnabled(false);
				fRevertAction.setEnabled(false);
			}
			fSubActionBars.updateActionBars();
		}

		/* 3. Set up editor content (fStyledText) */
		this.fStyledText.setText(fRefreshEditedTextBakup);
		if (this.fStyledText != null) {
			this.fStyledText.setEditable(! isReadOnly());
		}
	}

	/**
	 * Provide the object that will be edited through the editor.
	 * The particular case is for an edited that is an operation.
	 * In this situation we return the implementation
	 * (i.e. an activity) of this operation.
	 * This way it is transparent for the user that when editing an
	 * operation it can modify both the signature and its implementation.
	 *
	 * @param edited
	 * 		  the object that is currently edited
	 *
	 * @return the real object that will be edited
	 */
	private Element getEditableObject(EObject edited){
		if( edited instanceof Transition ) {
			return (Transition)edited;
		}
		else if( edited instanceof Operation ) {
//			return ((Operation)edited).getMethods().get(0);
			return (Operation)edited;
		}
		return (Element)edited;
	}

	/**
	 * Provide the namespace of the element that is given as parameter
	 *
	 * @param element
	 * 		  the element currently edited
	 *
	 * @return a namespace
	 */
//	private Namespace getNamespace(Element element){
//		if(element!=null && element instanceof NamedElement){
//			Element edited = this.getEditableObject(element);
//			return ((NamedElement)edited).getNamespace();
//		}
//		return null;
//	}

	/**
	 * Associate a context in which the xtext resource containing an ALF model will be validated
	 *
	 * @param element
	 *        the element currently edited
	 */
	private void installValidationContextFor(Element element) {
		if (this.styledTextAdapter != null) {
			XtextResource resource = this.styledTextAdapter.
					getFakeResourceContext().getFakeResource();
			if (resource != null) {
//				ModelNamespaceFacade.getInstance().createValidationContext(
//						resource, this.getNamespace(element));
			}
		}
	}

	@Override
	public void aboutToBeHidden() {
		super.aboutToBeHidden();
		if (styledTextAdapter != null) {
			styledTextAdapter.getFakeResourceContext().getFakeResource().eAdapters()
					.remove(contextElementAdapter);
		}

	    fSubActionBars.deactivate();
	    fSubActionBars.updateActionBars();
	}



	@Override
	public void aboutToBeShown() {
		super.aboutToBeShown();

	    fSubActionBars.activate();
	    fSubActionBars.updateActionBars();
	}

	@Override
	public void dispose() {
		super.dispose();
		if (toolkit != null) {
			toolkit.dispose();
		}
	}

	@Override
	public final void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		toolkit = new FormToolkit(parent.getDisplay());
		toolkit.setBorderStyle(SWT.BORDER);
		super.createControls(parent, aTabbedPropertySheetPage);

		GridDataFactory.fillDefaults().grab(true, true).applyTo(parent);
		parent.setLayout(new GridLayout(1, true));
		form = toolkit.createForm(parent);
		toolkit.decorateFormHeading(form);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(form);
		form.getBody().setLayout(new GridLayout(1, false));

		createTextControl(form.getBody());

		createSubActionBars(parent, aTabbedPropertySheetPage);
	}

	protected void createSubActionBars(final Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		fSubActionBars = new SubActionBars(
				aTabbedPropertySheetPage.getSite().getActionBars() );

		createCommitAction(parent, aTabbedPropertySheetPage);

		createRevertAction(parent, aTabbedPropertySheetPage);
	}


	protected void createRevertAction(final Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		fRevertAction = new Action("Revert") {
			@Override
			public void run() {
				super.run();

				revertFromModel();
			}
		};

		fRevertAction.setToolTipText("Reset edited element text");

		fRevertAction.setImageDescriptor(ImageDescriptor.createFromFile(
				ActivatorXLIAProperties.class, "/resources/icons/revert.gif"));


		ActionContributionItem aci = new ActionContributionItem(fRevertAction);
		aci.setMode(ActionContributionItem.MODE_FORCE_TEXT);

	    fSubActionBars.getToolBarManager().add( aci );
	    fSubActionBars.getMenuManager().add( fRevertAction );
	}

	protected void revertFromModel() {
		refresh();
	}


	protected void createCommitAction(final Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		fCommitAction = new Action( COMMIT_ACTION_DEFAULT_TEXT ) {
			@Override
			public void run() {
				super.run();

				commitAndPushToModel();
			}
		};

		fCommitAction.setToolTipText(COMMIT_ACTION_DEFAULT_DESCRIPTION);

		fCommitAction.setImageDescriptor(ImageDescriptor.createFromFile(
//				ActivatorXLIAProperties.class, "/resources/icons/commit.png"));
				ActivatorXLIAProperties.class, "/resources/icons/push.png"));


		ActionContributionItem aci = new ActionContributionItem(fCommitAction);
		aci.setMode(ActionContributionItem.MODE_FORCE_TEXT);

	    fSubActionBars.getToolBarManager().add( aci );
	    fSubActionBars.getMenuManager().add( fCommitAction );
	}

	protected void commitAndPushToModel() {
		if( isEditableElement(this.eObject) ) {
			if( this.eObject instanceof Transition ) {
				commitAndPushTransitionToModel((Transition) this.eObject);
			}
			if( this.eObject instanceof Operation ) {
				commitAndPushOperationToModel((Operation) this.eObject);
			}
			else if( this.eObject instanceof NamedElement ) {
				System.out.println("TODO:> Commit and Push to Model: element " +
						((NamedElement) this.eObject).getName());
			}
			else {
				System.out.println("Unknown Commit and Push to Model ?");
			}
		}
	}

	public TransactionalEditingDomain getTransactionalEditingDomain() {
		return getEditingDomain();
	}

	protected void commitAndPushTransitionToModel(Transition transitionContext) {
		System.out.println("Commit and Push to Model: transition " +
				transitionContext.getName());

		final String editedtext = getEditor().getText();

		if( (editedtext != null) && (! editedtext.equals(fRefreshEditedTextBakup)) ) {

			UpdateTransitionCommand command = new UpdateTransitionCommand(
					transitionContext, editedtext, fRefreshEditedTextBakup);

			Job job = new ExecuteCommandJob(this, command);

//			job.addJobChangeListener(new JobChangeAdapter() {
//				@Override
//				public void done(IJobChangeEvent event) {
//					this.after();
//				}
//			});

			job.setPriority(Job.SHORT);
			job.schedule();
		}
		else {
			System.out.println("End Commit Transition without change !!!");
		}
	}


	protected void commitAndPushOperationToModel(Operation operationContext) {
		System.out.println("Commit and Push to Model: operation " +
				operationContext.getName());

		final String editedtext = getEditor().getText();

		if( (editedtext != null) && (! editedtext.equals(fRefreshEditedTextBakup)) ) {

			UpdateOperationCommand command = new UpdateOperationCommand(
					operationContext, editedtext, fRefreshEditedTextBakup);

			Job job = new ExecuteCommandJob(this, command);

//			job.addJobChangeListener(new JobChangeAdapter() {
//				@Override
//				public void done(IJobChangeEvent event) {
//					this.after();
//				}
//			});

			job.setPriority(Job.SHORT);
			job.schedule();
		}
		else {
			System.out.println("End Commit Operation without change !!!");
		}
	}

	protected void createTextControl(final Composite parent) {
		fStyledText = new StyledTextWithUndoRedo(parent,
				SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.WRAP);

		fStyledText.setAlwaysShowScrollBars(false);
		GridDataFactory.fillDefaults().grab(true, true).hint(parent.getSize())
				.applyTo(fStyledText);

		fUndoManager = new UndoStyledTextManager(fStyledText);

		fStyledText.addFocusListener(new EditorFocusListener(this));
	}

	protected void updateXtextAdapters(Control styledText) {
		if (styledTextAdapter != null) {
			styledTextAdapter.getFakeResourceContext().
				getFakeResource().eAdapters().remove(contextElementAdapter);
		}

		styledTextAdapter = new StyledTextXtextAdapter(this.xliaToolingInjector);
		styledTextAdapter.getFakeResourceContext().
			getFakeResource().eAdapters().add(contextElementAdapter);

		this.installValidationContextFor((Element)this.eObject);
		styledTextAdapter.adapt((StyledText) styledText);
	}

	public EObject getContextObject() {
		return this.getEditableObject(this.eObject);
	}

	@Override
	protected boolean isReadOnly() {
		EObject context = getContextObject();
		return (context == null) || EMFHelper.isReadOnly(context) ||
				super.isReadOnly() || (! isEditableElement(this.eObject));
	}
}