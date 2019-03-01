/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *   - Initial API and Implementation
 *******************************************************************************/
package org.eclipse.efm.execution.core.workflow;

import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.core.util.PrettyPrintWriter;
import org.eclipse.efm.execution.core.workflow.common.AnalysisProfileKind;
import org.eclipse.efm.execution.core.workflow.common.CommonFactory;
import org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormatCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.ConsoleVerbosityKind;
import org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOptionCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.ManifestCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.ShellModeCustomImpl;
import org.eclipse.efm.execution.core.workflow.common.SymbexOption;
import org.eclipse.efm.execution.core.workflow.impl.WorkflowImpl;

public class WorkflowCustomImpl extends WorkflowImpl
		implements IWorkflowConfigurationConstants {

	private static final String WORKFLOW_HEADER =
//			"@sew< workflow , version: 1.0 >:";
			"@sew< workflow , 1.0 >:";

	private static final String WORKFLOW_FOOTER =
			"//EOF of @sew< workflow , version: 1.0 >:";

	private static final String WORKFLOW_COMMENT =
			"Symbolic Execution Workflow\n" +
			"Diversity Tool Configuration\n" +
			"CEA - LIST";


	protected WorkflowCustomImpl() {
		super();
	}

	protected WorkflowCustomImpl(final String name) {
		super();

		setName(name);
	}

	protected WorkflowCustomImpl(final String name, final String description) {
		super();

		setName(name);
		setDescription(description);
	}


	public static WorkflowCustomImpl create(
			final ILaunchConfiguration configuration,
			final IPath projectRootPath, final IPath relativeLaunchPath) {

		final WorkflowCustomImpl workflow = new WorkflowCustomImpl();

		workflow.setComment(WORKFLOW_COMMENT);

//		workflow.setManifest( ManifestCustomImpl.create(true) );


		final WorkspaceCustomImpl workspace = WorkspaceCustomImpl.create(
				configuration, projectRootPath, relativeLaunchPath);

		workflow.setWorkspace(workspace);

		boolean enabledExtension;
		try {
			enabledExtension = configuration.getAttribute(
					ATTR_ENABLED_TRACE_EXTENSION, false);
		} catch( final CoreException e ) {
			e.printStackTrace();

			enabledExtension = false;
		}

		// Main Execution Director
		DirectorCustomImpl director =
				DirectorCustomImpl.create(workflow,
						configuration, projectRootPath, enabledExtension);

		AnalysisProfileKind modelAnalysisProfile =
				AnalysisProfileKind.ANALYSIS_EXPLORATION_PROFILE;
		try {
			final String strModelAnalysisProfile = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_ANALYSIS_PROFILE,
					AnalysisProfileKind.ANALYSIS_EXPLORATION_PROFILE.getLiteral());

	        modelAnalysisProfile = AnalysisProfileKind.get(strModelAnalysisProfile);
		}
		catch (final CoreException e) {
			e.printStackTrace();
			modelAnalysisProfile = AnalysisProfileKind.ANALYSIS_EXPLORATION_PROFILE;
		}
		switch ( modelAnalysisProfile ) {
			case ANALYSIS_EXPLORATION_PROFILE: {
				director.setName( "exploration" );
				break;
			}
			case ANALYSIS_TRANSITION_COVERAGE_PROFILE: {
				director.setName( "transition#coverage" );
				break;
			}
			case ANALYSIS_BEHAVIOR_SELECTION_PROFILE: {
				director.setName( "behavior#selection" );
				break;
			}
			case ANALYSIS_ACSL_GENERATION_PROFILE: {
				director.setName( "contracts#inference" );
				break;
			}
			case ANALYSIS_EXTRANEOUS_PROFILE: {
				director.setName( "extraneous#module" );
				break;
			}
			default: {
				director.setName( "offline#testing" );
				break;
			}
		}
		director.setDescription(
				"as main execution objective" );

		workflow.getDirector().add( director );

		// Second  Execution Director if enabled Extension
		if( enabledExtension ) {
			director = DirectorCustomImpl.createSecond(workflow, configuration);

			director.setName( "extension" );
			director.setDescription(
					"of execution for trace generation" );

			workflow.getDirector().add( director );
		}


		final SymbexOption symbexOption = CommonFactory.eINSTANCE.createSymbexOption();
		workflow.setSymbexOption( symbexOption );


		ConsoleVerbosityKind verbosity = null;
		try {
			verbosity = ConsoleVerbosityKind.get(
					configuration.getAttribute(
							ATTR_CONSOLE_LOG_VERBOSE_LEVEL,
							ConsoleVerbosityKind.MINIMUM.getLiteral()));
		}
		catch( final CoreException e ) {
			e.printStackTrace();
		}
		if( verbosity == null ) {
			verbosity = ConsoleVerbosityKind.MINIMUM;
		}

		final ConsoleLogFormatCustomImpl console =
				ConsoleLogFormatCustomImpl.create(verbosity);

		workflow.setConsole( console );


		final ShellModeCustomImpl shellMode =
				ShellModeCustomImpl.create( configuration );
		workflow.setShellMode( shellMode );


		final DeveloperTuningOptionCustomImpl devTuning =
				DeveloperTuningOptionCustomImpl.createWorkflow(configuration);

		workflow.setDeveloperTuning( devTuning );


		return( workflow );
	}


	public void toWriter(final IPath filePath) {
		try {
			final FileWriter buffer = new FileWriter( filePath.toOSString() );

			final PrettyPrintWriter writer = new PrettyPrintWriter(buffer);

			toWriter( writer );

			writer.close();
		}
		catch (final IOException e) {
			e.printStackTrace();
		}
	}


	public void toWriter(final PrettyPrintWriter writer) {
		writer.appendEol2( WORKFLOW_HEADER );

		writer.commentLine( getComment() );

		writer.appendTab( "workflow" );

		String str = getName();
		if( str != null ) {
			writer.append( ' ' ).append( str );
		}
		str = getDescription();
		if( str != null ) {
			writer.append( " \'" ).append( str ).append( "\'" );
		}

		writer.appendEol( " {" );

		final PrettyPrintWriter writer2 = writer.itab2();

		final ManifestCustomImpl manifest = (ManifestCustomImpl) getManifest();
		if( manifest != null ) {
			manifest.toWriter(writer2);
		}

		((WorkspaceCustomImpl) getWorkspace()).toWriter( writer2 );

		if( ! getDirector().isEmpty() ) {
			for( final Director director : getDirector() ) {
				((DirectorCustomImpl) director).toWriter( writer2 );
			}

//			str = getDirector().get(0).getName();
//			writer2.appendEolTab("moe = ")
//				.appendEol( (str != null) ? str : "'director'" );
		}

		final SymbexOption symbexMode = getSymbexOption();
		if( symbexMode != null ) {
			writer.appendTab2Eol( "symbex 'option' [" );

			writer.appendTab3Eol( "name_id_separator = \"_\"   // default \"#\"");

			writer.appendTab3Eol( "newfresh_param_name_pid = false");

			writer.appendTab3Eol( "pretty_printer_var_name = true   // default false");

			writer.appendTab3Eol( "time_name_id = '$time'" );
			writer.appendTab3Eol( "delta_name_id = '$delta'" );


			writer.appendTab3Eol( "node_condition_enabled = false   // default false");

			writer.appendTab3Eol( "separation_of_pc_disjunction = false" );
			writer.appendTab3Eol( "check_pathcondition_satisfiability = true" );

			writer.appendTab3Eol( "constraint_solver = 'CVC4'  // Z3");

			writer.appendTab2Eol( "] // end symbex" );
		}

		final ConsoleLogFormatCustomImpl console =
				(ConsoleLogFormatCustomImpl) getConsole();
		if( console != null ) {
			console.toWriter( writer2 );
		}

		final ShellModeCustomImpl shellMode = (ShellModeCustomImpl) getShellMode();
		if( shellMode != null ) {
			shellMode.toWriter( writer2 );
		}

		final DeveloperTuningOptionCustomImpl devTuning =
				(DeveloperTuningOptionCustomImpl) getDeveloperTuning();
		if( devTuning != null ) {
			devTuning.toWriter( writer2 );
		}

		writer.appendTabEol( "}" );


		writer.appendEol_Eol( WORKFLOW_FOOTER );

		writer.appendEol()
			.appendEol( "/*" )
			.appendEol( "# Grammar Reference" )
			.appendEol2( SYNTAX_TRACE_SPECIFICATION )
			.appendEol2( SYNTAX_TRACE_FORMAT_SPECIFICATION )
			.appendEol( "*/" );

	}
}
