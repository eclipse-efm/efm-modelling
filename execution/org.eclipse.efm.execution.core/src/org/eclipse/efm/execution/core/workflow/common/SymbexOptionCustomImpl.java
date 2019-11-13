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
package org.eclipse.efm.execution.core.workflow.common;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.core.util.PrettyPrintWriter;
import org.eclipse.efm.execution.core.workflow.common.impl.SymbexOptionImpl;

public class SymbexOptionCustomImpl extends SymbexOptionImpl
		implements IWorkflowConfigurationConstants {

	protected SymbexOptionCustomImpl() {
		super();
	}


	public boolean configureOption(final ILaunchConfiguration configuration) {
		return( true );
	}


	public static SymbexOptionCustomImpl create(
			final ILaunchConfiguration configuration) {

		final SymbexOptionCustomImpl symbexOption = new SymbexOptionCustomImpl();

		// Global Constraint Solver
		SolverKind constraintSolver = SolverKind.CVC4;
		try {
			constraintSolver = SolverKind.get(
					configuration.getAttribute(
							ATTR_SYMBEX_OPTION_CONSTRAINT_SOLVER,
							SolverKind.CVC4.getLiteral()) );
		}
		catch (final CoreException e) {
			e.printStackTrace();
		}

		if( constraintSolver == null ) {
			constraintSolver = SolverKind.CVC4;
		}
		symbexOption.setConstraintSolver(constraintSolver);


		// Symbex Textual Options
		String symbexTextualOptions = DEFAULT_SYMBEX_OPTION_TEXTUAL_CONFIGURATION;
		try {
			symbexTextualOptions = configuration.getAttribute(
					ATTR_SYMBEX_OPTION_TEXTUAL_CONFIGURATION,
					DEFAULT_SYMBEX_OPTION_TEXTUAL_CONFIGURATION);
		}
		catch( final CoreException e ) {
			e.printStackTrace();
		}
		if( (symbexTextualOptions == null) || symbexTextualOptions.isEmpty() ) {
			symbexTextualOptions = DEFAULT_SYMBEX_OPTION_TEXTUAL_CONFIGURATION;
		}

		symbexOption.setRawOptions(symbexTextualOptions);

		return( symbexOption );
	}


	public void toWriter(final PrettyPrintWriter writer) {
		writer.appendTabEol( "symbex 'option' [" );

		final String rawOptions = getRawOptions();
		if( (rawOptions != null) && (! rawOptions.isEmpty()) ) {
			final String[] linesOption = rawOptions.split("\n");
			for (final String option : linesOption) {
				writer.appendTab2Eol( option );
			}
		}
		else {
			writer.appendTab2Eol( "name_id_separator = \"_\"   // default \"#\"" );

			writer.appendTab2Eol( "newfresh_param_name_pid = false");

			writer.appendTab2Eol( "pretty_printer_var_name = true   // default false" );

			writer.appendTab2Eol( "time_name_id = '$time'" );
			writer.appendTab2Eol( "time_initial_value = 0" );

			writer.appendTab2Eol( "delta_name_id = '$delay'" );
			writer.appendTab2Eol( "delta_initial_value = 0"  );


			writer.appendTab2Eol( "node_condition_enabled = false   // default false" );

			writer.appendTab2Eol( "separation_of_pc_disjunction = false" );
//			writer.appendTab2Eol( "check_pathcondition_satisfiability = true" );
			writer.appendTab2Eol( "strongly_check_pathcondition_satisfiability = true" );

			writer.appendTab2Eol( "constraint_solver = 'CVC4'  // Z3" );
		}

		writer.appendTabEol( "] // end symbex" );
	}


}
