/*******************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alain Faivre (CEA LIST) alain.faivre@cea.fr - Initial Implementation (tab-based, inserted in Run Configurations dialog)
 *  Erwan Mahe (CEA LIST) erwan.mahe@cea.fr - New API (free-composite-based, no type assumptions on parent)
 *******************************************************************************/

package org.eclipse.efm.execution.configuration.common.ui.page.symbex;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.configuration.common.ui.api.AbstractConfigurationPage;
import org.eclipse.efm.execution.configuration.common.ui.api.ILaunchConfigurationGUIelement;
import org.eclipse.efm.execution.configuration.common.ui.api.IWidgetToolkit;
import org.eclipse.efm.execution.core.workflow.common.SolverKind;
import org.eclipse.efm.sew.xtext.ui.internal.XtextActivator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;

import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class SymbexOptionConfigurationPage extends AbstractConfigurationPage {

	private static final String[] TRACE_LEVEL_COMBO_ITEMS = new String[] {
			SolverKind.CVC4.getLiteral(),
			SolverKind.Z3.getLiteral(),
			SolverKind.YICES2.getLiteral()
	};

	private Combo fConstraintSolverCombo = null;

	private SolverKind fConstraintSolver = SolverKind.CVC4;


	private EmbeddedEditorModelAccess fEmbededEditorModelAccess;


	public SymbexOptionConfigurationPage(
			final ILaunchConfigurationGUIelement masterGUIelement) {
		super(masterGUIelement);
	}

	@Override
	public String getSectionTitle() {
		return "Symbex Tuning << INCUBATION >>";
	}

	@Override
	public String getSectionDescription() {
		return "Symbex Tuning page";
	}


	// ======================================================================================
	//                              Miscellaneous Handling
	// ======================================================================================

	private class TabListener extends SelectionAdapter implements ModifyListener {

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
		 */
		@Override
		public void modifyText(final ModifyEvent e) {
			propagateGUIupdate();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		@Override
		public void widgetSelected(final SelectionEvent e) {
			final Object source= e.getSource();

			if (source == fConstraintSolverCombo) {
				fConstraintSolver = SolverKind.get( fConstraintSolverCombo.getText() );
				if( fConstraintSolver == null ) {
					fConstraintSolver = SolverKind.CVC4;
				}
			}
		}
	}

	private final TabListener fListener= new TabListener();


	// ======================================================================================
	//                              Graphical Components Creation Methods
	// ======================================================================================

	@Override
	protected void createContent(final Composite parent, final IWidgetToolkit widgetToolkit)
	{
		createDeveloperTuningOptionsComponent(parent, widgetToolkit);

		createEmbededXtextSEWEditor(parent, widgetToolkit);
	}

	private void createDeveloperTuningOptionsComponent(
			final Composite parent, final IWidgetToolkit widgetToolkit)
	{
		final Group group = widgetToolkit.createGroup(parent,
				"Constraint Solver Options", 2, 2, GridData.FILL_HORIZONTAL);

		widgetToolkit.createLabel(group, "&Solver : ", 1);

		fConstraintSolverCombo = widgetToolkit.createCombo(group,
				SWT.DROP_DOWN | SWT.READ_ONLY, 1, TRACE_LEVEL_COMBO_ITEMS);

		fConstraintSolverCombo.addSelectionListener(fListener);
	}


	private void createEmbededXtextSEWEditor(
			final Composite parent, final IWidgetToolkit widgetToolkit) {
		final Group group  = widgetToolkit.createGroup(parent,
				"&Symbex Textual Options", 1, 1, GridData.FILL_BOTH);

		final XtextActivator activator = XtextActivator.getInstance();
		final Injector injector =
				activator.getInjector(XtextActivator.ORG_ECLIPSE_EFM_SEW_XTEXT_SEW);

		final XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);

		final IEditedResourceProvider resourceProvider = new IEditedResourceProvider() {
			@Override
			public XtextResource createResource() {
				try {
					final Resource resource = resourceSet.createResource(
							URI.createURI(".sew/workflow-symbex-options.sew"));

					return (XtextResource) resource;
				} catch (final Exception e) {
					return null;
				}
			}
		};

		final EmbeddedEditorFactory factory = injector.getInstance(EmbeddedEditorFactory.class);

		final EmbeddedEditor handle = factory.newEditor(resourceProvider).withParent(group);

		fEmbededEditorModelAccess = handle.createPartialEditor();
	}



	// ======================================================================================
	//                              Fields Values Management
	// ======================================================================================

	@Override
	public void setDefaultsImpl(final ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_SYMBEX_OPTION_CONSTRAINT_SOLVER, SolverKind.CVC4.getLiteral());

		configuration.setAttribute(
				ATTR_SYMBEX_OPTION_TEXTUAL_CONFIGURATION,
				DEFAULT_SYMBEX_OPTION_TEXTUAL_CONFIGURATION);
	}

	@Override
	public void initializeFromImpl(final ILaunchConfiguration configuration) {
		try {
			fConstraintSolver = SolverKind.get(
					configuration.getAttribute(
							ATTR_SYMBEX_OPTION_CONSTRAINT_SOLVER,
							SolverKind.CVC4.getLiteral()) );
		}
		catch (final CoreException e) {
			e.printStackTrace();

			fConstraintSolver = SolverKind.CVC4;
		}

		if( fConstraintSolver == null ) {
			fConstraintSolver = SolverKind.CVC4;
		}
		initializeConstraintSolver();

		String symbexTextualOptions;
		try {
			symbexTextualOptions = configuration.getAttribute(
					ATTR_SYMBEX_OPTION_TEXTUAL_CONFIGURATION,
					DEFAULT_SYMBEX_OPTION_TEXTUAL_CONFIGURATION);
		}
		catch( final CoreException e ) {
			e.printStackTrace();

			symbexTextualOptions = DEFAULT_SYMBEX_OPTION_TEXTUAL_CONFIGURATION;
		}
		if( (symbexTextualOptions == null) || symbexTextualOptions.isEmpty() ) {
			symbexTextualOptions = "";
		}

		fEmbededEditorModelAccess.updateModel(symbexTextualOptions);
	}


	private void initializeConstraintSolver() {
		switch ( fConstraintSolver ) {
			case CVC4:
				fConstraintSolverCombo.select(0);
				break;
			case Z3:
				fConstraintSolverCombo.select(1);
				break;
			case YICES2:
				fConstraintSolverCombo.select(2);
				break;
			default:
				fConstraintSolverCombo.select(0);
				break;
		}
	}

	@Override
	public void performApplyImpl(final ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				ATTR_SYMBEX_OPTION_CONSTRAINT_SOLVER, fConstraintSolver.getLiteral());

		final String symbexTextualOptions = fEmbededEditorModelAccess.getEditablePart();

		configuration.setAttribute(
				ATTR_SYMBEX_OPTION_TEXTUAL_CONFIGURATION, symbexTextualOptions);
	}


	// ======================================================================================
	//                              Fields Validation
	// ======================================================================================

	@Override
	public FieldValidationReturn areFieldsValidImpl(final ILaunchConfiguration launchConfig) {
		final String symbexTextualOptions = fEmbededEditorModelAccess.getEditablePart();

		final boolean isValid =
				(symbexTextualOptions != null) && (! symbexTextualOptions.isEmpty());

		return new FieldValidationReturn(isValid, null);
	}

}
