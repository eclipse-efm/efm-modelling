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
			"@sew< workflow , 1.0 >:";

	private static final String WORKFLOW_FOOTER =
			"//EOF of @sew< workflow , 1.0 >:";

	private static final String WORKFLOW_COMMENT =
			"Symbolic Execution Workflow\n" +
			"Diversity Tool Configuration\n" +
			"CEA - LIST";


	public WorkflowCustomImpl() {
		super();
	}

	public WorkflowCustomImpl(String name) {
		super();

		setName(name);
	}

	public WorkflowCustomImpl(String name, String description) {
		super();

		setName(name);
		setDescription(description);
	}


	public static WorkflowCustomImpl create(
			ILaunchConfiguration configuration, IPath rootPath) {

		WorkflowCustomImpl workflow = new WorkflowCustomImpl();

		workflow.setComment(WORKFLOW_COMMENT);

//		workflow.setManifest( ManifestCustomImpl.create(true) );


		WorkspaceCustomImpl workspace =
				WorkspaceCustomImpl.create(configuration, rootPath);

		workflow.setWorkspace(workspace);

		boolean enabledExtension;
		try {
			enabledExtension = configuration.getAttribute(
					ATTR_ENABLED_TRACE_EXTENSION, false);
		} catch( CoreException e ) {
			e.printStackTrace();

			enabledExtension = false;
		}

		// Main Execution Director
		DirectorCustomImpl director =
				DirectorCustomImpl.create(workflow,
						configuration, enabledExtension);

		String modelAnalysis;
		try {
			modelAnalysis = configuration.getAttribute(
					ATTR_SPECIFICATION_MODEL_ANALYSIS,
					ANALYSIS_PROFILE_MODEL_EXPLORATION);
		}
		catch (CoreException e) {
			e.printStackTrace();
			modelAnalysis = ANALYSIS_PROFILE_MODEL_EXPLORATION;
		}
		switch ( modelAnalysis ) {
			case ANALYSIS_PROFILE_MODEL_EXPLORATION: {
				director.setName( "exploration" );
				break;
			}
			case ANALYSIS_PROFILE_MODEL_COVERAGE_TRANSITION: {
				director.setName( "transition#coverage" );
				break;
			}
			case ANALYSIS_PROFILE_MODEL_COVERAGE_BEHAVIOR: {
				director.setName( "behavior#selection" );
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


		SymbexOption symbexOption = CommonFactory.eINSTANCE.createSymbexOption();
		workflow.setSymbexOption( symbexOption );


		String str;
		try {
			str = configuration.getAttribute(
					ATTR_CONSOLE_LOG_VERBOSE_LEVEL, "MINIMUM");
		}
		catch( CoreException e ) {
			e.printStackTrace();

			str = "MINIMUM";
		}
		ConsoleVerbosityKind verbose = ConsoleVerbosityKind.get( str );
		if( verbose == null ) {
			verbose = ConsoleVerbosityKind.MINIMUM;
		}

		ConsoleLogFormatCustomImpl console =
				ConsoleLogFormatCustomImpl.create(verbose);
		workflow.setConsole( console );


		ShellModeCustomImpl shellMode =
				ShellModeCustomImpl.create( configuration );
		workflow.setShellMode( shellMode );


		DeveloperTuningOptionCustomImpl devTuning =
				DeveloperTuningOptionCustomImpl.createWorkflow(configuration);

		workflow.setDeveloperTuning( devTuning );


		return( workflow );
	}


	public void toWriter(IPath filePath) {
		try {
			FileWriter buffer = new FileWriter( filePath.toOSString() );

			PrettyPrintWriter writer = new PrettyPrintWriter(buffer);

			toWriter( writer );

			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void toWriter(PrettyPrintWriter writer) {
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

		PrettyPrintWriter writer2 = writer.itab2();

		ManifestCustomImpl manifest = (ManifestCustomImpl) getManifest();
		if( manifest != null ) {
			manifest.toWriter(writer2);
		}

		((WorkspaceCustomImpl) getWorkspace()).toWriter( writer2 );

		if( ! getDirector().isEmpty() ) {
			for( Director director : getDirector() ) {
				((DirectorCustomImpl) director).toWriter( writer2 );
			}

//			str = getDirector().get(0).getName();
//			writer2.appendEolTab("moe = ")
//				.appendEol( (str != null) ? str : "'director'" );
		}

		SymbexOption symbexMode = getSymbexOption();
		if( symbexMode != null ) {
			writer.appendTab2Eol( "symbex 'option' [" );

			writer.appendTab3Eol( "separation_of_pc_disjunction = false" );
			writer.appendTab3Eol( "check_pathcondition_satisfiability = true" );

			writer.appendTab3Eol( "constraint_solver = 'CVC4'  // Z3");

			writer.appendTab2Eol( "] // end symbex" );
		}

		ConsoleLogFormatCustomImpl console =
				(ConsoleLogFormatCustomImpl) getConsole();
		if( console != null ) {
			console.toWriter( writer2 );
		}

		ShellModeCustomImpl shellMode = (ShellModeCustomImpl) getShellMode();
		if( shellMode != null ) {
			shellMode.toWriter( writer2 );
		}

		DeveloperTuningOptionCustomImpl devTuning =
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
