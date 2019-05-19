/*******************************************************************************
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
 *******************************************************************************/
package org.eclipse.efm.execution.core;

public interface IWorkflowSpiderConfigurationUtils {

	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	// SUPERVISOR -> OUTPUT SYMBEX EVALUATION SPIDER INFORMATION
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////

	String SPIDER_TRACE_INIT_PREFIX = "<$spider";
	String SPIDER_TRACE_STEP_PREFIX  = "$spider";
	String SPIDER_TRACE_STOP_PREFIX  = ">$spider";

	String TRACE_BEGIN_SEPARATOR     = "\\n";
	String TRACE_END_SEPARATOR       = "\\n";



	String SYMBEX_TRACE_BOUND_PREFIX = "step";
	String SYMBEX_TRACE_STEP_PREFIX  = "step";
	String SYMBEX_TRACE_STOP_PREFIX  = "stop";

	String SYMBEX_EXIT_TAG      = "@exit";

	String SYMBEX_VERDICT_TAG   = "verdict:";
	String SYMBEX_VERDICT_FAIL  = "FAIL";
	String SYMBEX_VERDICT_PASS  = "PASS";

	String SYMBEX_COVERAGE_TAG  = "coverage:";
	String SYMBEX_GOAL_ACHIEVED = "GOAL ACHIEVED";


	/**
	 *  Assumes for SUPERVISOR
	 * %1% --> symbex  eval number
	 * %2% --> context unique ID
	 * %3% --> context hight
	 * %4% --> context width
	 *
	 * %5% --> other Info from FAM
	 */
	String DEFAULT_COVERAGE_TRACE_EVAL_FORMAT   =
			TRACE_BEGIN_SEPARATOR +
			"step:%1% , context:%2% , height:%3% , width:%4%%5%" +
			TRACE_END_SEPARATOR;

	String DEFAULT_COVERAGE_TRACE_REPORT_FORMAT =
			TRACE_BEGIN_SEPARATOR +
			"stop:%1% , context:%2% , height:%3% , width:%4%%5%" +
			TRACE_END_SEPARATOR;


	String DEFAULT_EXPLORATION_TRACE_EVAL_FORMAT   =
			TRACE_BEGIN_SEPARATOR +
			"step:%1% , context:%2% , height:%3% , width:%4%" +
			TRACE_END_SEPARATOR;

	String DEFAULT_EXPLORATION_TRACE_REPORT_FORMAT =
			TRACE_BEGIN_SEPARATOR +
			"stop:%1% , context:%2% , height:%3% , width:%4%" +
			TRACE_END_SEPARATOR;


	// "\\n$init$spider(S:%1%,C:%2%,H:%3%,W:%4%)";
	String DEFAULT_SPIDER_INIT_POSITION_FORMAT =
			TRACE_BEGIN_SEPARATOR   + SPIDER_TRACE_INIT_PREFIX +
			"(%1%:%2%:%3%:%4%)%5%" + TRACE_END_SEPARATOR;

	//"\\n$spider(S:%1%,C:%2%,H:%3%,W:%4%)"
	String DEFAULT_SPIDER_STEP_POSITION_FORMAT =
			TRACE_BEGIN_SEPARATOR   + SPIDER_TRACE_STEP_PREFIX +
			"(%1%:%2%:%3%:%4%)%5%" + TRACE_END_SEPARATOR;

	//"\\n$stop$spider(S:%1%,C:%2%,H:%3%,W:%4%)"
	String DEFAULT_SPIDER_STOP_POSITION_FORMAT =
			TRACE_BEGIN_SEPARATOR   + SPIDER_TRACE_STOP_PREFIX +
			"(%1%:%2%:%3%:%4%)%5%" + TRACE_END_SEPARATOR;


	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	// COVERAGE MODULE  -> OUTPUT FAM COVERAGE SPIDER INFORMATION
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////

	String SPIDER_COVERAGE_PREFIX = "$cover"; // "$coverage"

	/**
	 *  Assumes for COVERAGE ANALYSIS MODULE
	 * %1% --> current coverage count
	 * %2% --> number of element to cover
	 */
	String DEFAULT_COVERAGE_FORMAT = " - coverage: %1% / %2%";

	String DEFAULT_COVERAGE_SPIDER_INIT_POSITION_FORMAT =
			SPIDER_COVERAGE_PREFIX + "(%1%:%2%)";

	String DEFAULT_COVERAGE_SPIDER_STEP_POSITION_FORMAT =
			SPIDER_COVERAGE_PREFIX + "(%1%:%2%)";

	String DEFAULT_COVERAGE_SPIDER_STOP_POSITION_FORMAT =
			SPIDER_COVERAGE_PREFIX + "(%1%:%2%)";


	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	// UTILS
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////

	String SPIDER_POSITIONS_SEPARATOR = "\\D+";
	String OLD_POSITIONS_SEPARATOR = "[, ]*\\w+[:][ ]*|[,/ ]+";

	int[] RESCUE_POSITIONS = new int[] { 0 , 0 , 0 , 0 };

	default int[] spiderPositions(final String spiderInformations) {
		if( spiderInformations.length() < 2 ) {
			return RESCUE_POSITIONS;
		}
		else {
			String[] strPositions;

			final char firstChar = spiderInformations.charAt(0);
			if( (firstChar == '$') || (firstChar == '<') || (firstChar == '>') ) {
				strPositions = spiderInformations.split(SPIDER_POSITIONS_SEPARATOR);
			}
			else { //if (firstChar == 's')
				strPositions = spiderInformations.split(OLD_POSITIONS_SEPARATOR);
			}

			final int[] positions = new int[strPositions.length - 1];

			for (int i = 1; i < strPositions.length; i++) {
				try {
					positions[i - 1] = Integer.parseInt(strPositions[i]);
				} catch(final NumberFormatException e) {
					//!! NOTHING ELSE !!
					positions[i - 1] = 0;

					System.out.print( "spiderPosition< unexpected as number > : " );
					System.out.println( strPositions[i] );
				}
			}

			return( positions );
		}
	}

}
