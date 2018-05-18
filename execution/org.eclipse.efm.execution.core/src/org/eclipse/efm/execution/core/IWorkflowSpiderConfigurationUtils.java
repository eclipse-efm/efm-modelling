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

	public static final String SPIDER_TRACE_INIT_PREFIX = "<$spider";
	public static final String SPIDER_TRACE_STEP_PREFIX  = "$spider";
	public static final String SPIDER_TRACE_STOP_PREFIX  = ">$spider";

	public static final String TRACE_BEGIN_SEPARATOR     = "\\n";
	public static final String TRACE_END_SEPARATOR       = "\\n";



	public static final String SYMBEX_TRACE_BOUND_PREFIX = "step";
	public static final String SYMBEX_TRACE_STEP_PREFIX  = "step";
	public static final String SYMBEX_TRACE_STOP_PREFIX  = "stop";


	/**
	 *  Assumes for SUPERVISOR
	 * %1% --> symbex  eval number
	 * %2% --> context unique ID
	 * %3% --> context hight
	 * %4% --> context width
	 *
	 * %5% --> other Info from FAM
	 */
	public static final String DEFAULT_COVERAGE_TRACE_EVAL_FORMAT   =
			TRACE_BEGIN_SEPARATOR +
			"step:%1% , context:%2% , height:%3% , width:%4%%5%" +
			TRACE_END_SEPARATOR;

	public static final String DEFAULT_COVERAGE_TRACE_REPORT_FORMAT =
			TRACE_BEGIN_SEPARATOR +
			"stop:%1% , context:%2% , height:%3% , width:%4%%5%" +
			TRACE_END_SEPARATOR;


	public static final String DEFAULT_EXPLORATION_TRACE_EVAL_FORMAT   =
			TRACE_BEGIN_SEPARATOR +
			"step:%1% , context:%2% , height:%3% , width:%4%" +
			TRACE_END_SEPARATOR;

	public static final String DEFAULT_EXPLORATION_TRACE_REPORT_FORMAT =
			TRACE_BEGIN_SEPARATOR +
			"stop:%1% , context:%2% , height:%3% , width:%4%" +
			TRACE_END_SEPARATOR;


	// "\\n$init$spider(S:%1%,C:%2%,H:%3%,W:%4%)";
	public static final String DEFAULT_SPIDER_INIT_POSITION_FORMAT =
			TRACE_BEGIN_SEPARATOR   + SPIDER_TRACE_INIT_PREFIX +
			"(%1%:%2%:%3%:%4%)%5%" + TRACE_END_SEPARATOR;

	//"\\n$spider(S:%1%,C:%2%,H:%3%,W:%4%)"
	public static final String DEFAULT_SPIDER_STEP_POSITION_FORMAT =
			TRACE_BEGIN_SEPARATOR   + SPIDER_TRACE_STEP_PREFIX +
			"(%1%:%2%:%3%:%4%)%5%" + TRACE_END_SEPARATOR;

	//"\\n$stop$spider(S:%1%,C:%2%,H:%3%,W:%4%)"
	public static final String DEFAULT_SPIDER_STOP_POSITION_FORMAT =
			TRACE_BEGIN_SEPARATOR   + SPIDER_TRACE_STOP_PREFIX +
			"(%1%:%2%:%3%:%4%)%5%" + TRACE_END_SEPARATOR;


	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	// COVERAGE MODULE  -> OUTPUT FAM COVERAGE SPIDER INFORMATION
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////

	public static final String SPIDER_COVERAGE_PREFIX = "$cover"; // "$coverage"

	/**
	 *  Assumes for COVERAGE ANALYSIS MODULE
	 * %1% --> current coverage count
	 * %2% --> number of element to cover
	 */
	public static final String DEFAULT_COVERAGE_FORMAT = " - coverage: %1% / %2%";

	public static final String DEFAULT_COVERAGE_SPIDER_INIT_POSITION_FORMAT =
			SPIDER_COVERAGE_PREFIX + "(%1%:%2%)";

	public static final String DEFAULT_COVERAGE_SPIDER_STEP_POSITION_FORMAT =
			SPIDER_COVERAGE_PREFIX + "(%1%:%2%)";

	public static final String DEFAULT_COVERAGE_SPIDER_STOP_POSITION_FORMAT =
			SPIDER_COVERAGE_PREFIX + "(%1%:%2%)";


	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	// UTILS
	///////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////

	public static final String SPIDER_POSITIONS_SEPARATOR = "\\D+";
	public static final String OLD_POSITIONS_SEPARATOR = "[, ]*\\w+[:][ ]*|[,/ ]+";

	public default int[] spiderPositions(String spiderInformations) {
		String[] strPositions;

		final char firstChar = spiderInformations.charAt(0);
		if( (firstChar == '$') || (firstChar == '<') || (firstChar == '>') ) {
			strPositions = spiderInformations.split(SPIDER_POSITIONS_SEPARATOR);
		}
		else { //if (firstChar == 's')
			strPositions = spiderInformations.split(OLD_POSITIONS_SEPARATOR);
		}

		int[] positions = new int[strPositions.length - 1];

		for (int i = 1; i < strPositions.length; i++) {
			try {
				positions[i - 1] = Integer.parseInt(strPositions[i]);
			} catch(NumberFormatException e) {
				//!! NOTHING ELSE !!
				positions[i - 1] = 0;

				System.out.print( "spiderPosition< unexpected as number > : " );
				System.out.println( strPositions[i] );
			}
		}

		return( positions );
	}

}
