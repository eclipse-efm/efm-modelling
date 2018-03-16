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

import java.util.List;

import org.eclipse.efm.execution.core.workflow.common.TraceElementKind;

public class TraceElementTableConfigProvider {

	public final String STORE_KEY;

	public final List<String> DEFAULT_ATTRIBUTE_VALUE;

	public final String TITLE;

	public final String TOOLTIP_TEXT;

	public final boolean CHECKED_BOX_FOR_COLUMN_ZERO;

	public final String SELECTION_TITLE = " ";

	public final boolean UNIQUE_NATUTRE_SET;
	public final String NATURE_TITLE;
	public final String VALUE_TITLE;

	public final int SELECTION_WIDTH = 20;
	public final int NATURE_WIDTH;
	public final int VALUE_WIDTH;

	public final TraceElementKind[] VALID_TRACE_NATURES;

	public final TraceElementKind DEFAULT_TRACE_NATURE;

	public final String[] VALID_NATURES;

	public TraceElementTableConfigProvider(
			String storeKey, List<String> defaultAttributeValue,
			String title, String toolTipText, boolean checkedBoxForColumnZero,
			boolean isNatureUniqueSet, String natureTitle, int natureWidth,
			String valueTitle, int valueWidth, TraceElementKind[] validTraces,
			TraceElementKind deafaultTrace) {

		STORE_KEY = storeKey;
		DEFAULT_ATTRIBUTE_VALUE = defaultAttributeValue;

		TITLE = title;

		TOOLTIP_TEXT = toolTipText;

		CHECKED_BOX_FOR_COLUMN_ZERO = checkedBoxForColumnZero;

		UNIQUE_NATUTRE_SET = isNatureUniqueSet;
		NATURE_TITLE = natureTitle;
		VALUE_TITLE  = valueTitle;

		NATURE_WIDTH = natureWidth;
		VALUE_WIDTH  = valueWidth;

		VALID_TRACE_NATURES = validTraces;

		VALID_NATURES = new String[ validTraces.length ];
		for (int offset = 0; offset < validTraces.length; offset++) {
			VALID_NATURES[offset] = validTraces[offset].getLiteral();
		}

		DEFAULT_TRACE_NATURE = deafaultTrace;
	}

	public TraceElementTableConfigProvider(String storeKey,
			List<String> defaultAttributeValue, String title, String toolTipText,
			boolean checkedBoxForColumnZero, String natureTitle, int natureWidth,
			String valueTitle, int valueWidth, TraceElementKind[] validTraces,
			TraceElementKind deafaultTrace)
	{
		this(storeKey, defaultAttributeValue, title, toolTipText,
				checkedBoxForColumnZero, false, natureTitle, natureWidth,
				valueTitle, valueWidth, validTraces, TraceElementKind.TRANSITION);
	}


	public TraceElementTableConfigProvider(String storeKey,
			List<String> defaultAttributeValue, String title, String toolTipText,
			boolean checkedBoxForColumnZero, String natureTitle, int natureWidth,
			String valueTitle, int valueWidth, TraceElementKind[] validTraces)
	{
		this(storeKey, defaultAttributeValue, title, toolTipText,
				checkedBoxForColumnZero, false, natureTitle, natureWidth,
				valueTitle, valueWidth, validTraces, TraceElementKind.TRANSITION);
	}


	public static final TraceElementKind[] TRANSITION_TRACE_ELEMENT =
			new TraceElementKind[] {
					TraceElementKind.TRANSITION
			};


	public static final TraceElementKind[] BEHAVIOR_SELECTION_TRACE_ELEMENT =
			new TraceElementKind[] {
					TraceElementKind.TRANSITION,

					TraceElementKind.INPUT,
					TraceElementKind.OUTPUT,

					TraceElementKind.MACHINE,
					TraceElementKind.STATE,
					TraceElementKind.STATEMACHINE,

//					TraceElementKind.ASSIGN,
//
//!						TraceElementKind.DELTA,
//!						TraceElementKind.TIME,
//
//!						TraceElementKind.VARIABLE,
					TraceElementKind.NEWFRESH,

					TraceElementKind.COM,
					TraceElementKind.INOUT,

					TraceElementKind.INPUT_ENV,
					TraceElementKind.OUTPUT_ENV,
					TraceElementKind.INPUT_RDV,
					TraceElementKind.OUTPUT_RDV,
//					TraceElementKind.INPUT_BUFFER,
//					TraceElementKind.OUTPUT_BUFFER,
//					TraceElementKind.INPUT_VAR,
//					TraceElementKind.OUTPUT_VAR,

//					TraceElementKind.PORT,
//					TraceElementKind.SIGNAL,
//					TraceElementKind.MESSAGE,
//					TraceElementKind.CHANNEL,
//					TraceElementKind.BUFFER,
//
//!						TraceElementKind.RUNNABLE,
//					TraceElementKind.ROUTINE,
//					TraceElementKind.SYSTEM,
//
//!						TraceElementKind.CONDITION,
//!						TraceElementKind.DECISION,
//!						TraceElementKind.FORMULA,
//
//					TraceElementKind.PATH_CONDITION,
//					TraceElementKind.PATH_CONDITION_LEAF,
//
//					TraceElementKind.PATH_TIMED_CONDITION,
//					TraceElementKind.PATH_TIMED_CONDITION_LEAF,
//
//					TraceElementKind.NODE_CONDITION,
//					TraceElementKind.NODE_TIMED_CONDITION,
//					TraceElementKind.NODE_TIMED_CONDITION_LEAF,
//
//					TraceElementKind.LIFELINE,
//
//					TraceElementKind.NODE_DATA,
//					TraceElementKind.NODE_INFO,
//!						TraceElementKind.NODE_TRACE_RUN,
//					TraceElementKind.NODE_TRACE_IO,
			};


	public static final TraceElementKind[] GRAPHVIZ_TRACE_ELEMENT =
			new TraceElementKind[] {
					TraceElementKind.TRANSITION,

					TraceElementKind.INPUT,
					TraceElementKind.OUTPUT,

					TraceElementKind.MACHINE,
					TraceElementKind.STATE,
					TraceElementKind.STATEMACHINE,

					TraceElementKind.ASSIGN,

					TraceElementKind.DELTA,
					TraceElementKind.TIME,

					TraceElementKind.VARIABLE,
					TraceElementKind.NEWFRESH,

					TraceElementKind.COM,
					TraceElementKind.INOUT,

					TraceElementKind.INPUT_ENV,
					TraceElementKind.OUTPUT_ENV,
					TraceElementKind.INPUT_RDV,
					TraceElementKind.OUTPUT_RDV,
//					TraceElementKind.INPUT_BUFFER,
//					TraceElementKind.OUTPUT_BUFFER,
//					TraceElementKind.INPUT_VAR,
//					TraceElementKind.OUTPUT_VAR,

//					TraceElementKind.PORT,
//					TraceElementKind.SIGNAL,
//					TraceElementKind.MESSAGE,
//					TraceElementKind.CHANNEL,
					TraceElementKind.BUFFER,
//
//!					TraceElementKind.RUNNABLE,
					TraceElementKind.ROUTINE,
//					TraceElementKind.SYSTEM,

					TraceElementKind.CONDITION,
					TraceElementKind.DECISION,
					TraceElementKind.FORMULA,

					TraceElementKind.PATH_CONDITION,
					TraceElementKind.PATH_CONDITION_LEAF,

					TraceElementKind.PATH_TIMED_CONDITION,
					TraceElementKind.PATH_TIMED_CONDITION_LEAF,

					TraceElementKind.NODE_CONDITION,
					TraceElementKind.NODE_TIMED_CONDITION,
					TraceElementKind.NODE_TIMED_CONDITION_LEAF,

//					TraceElementKind.LIFELINE,

//					TraceElementKind.NODE_DATA,
//!					TraceElementKind.NODE_INFO,
//					TraceElementKind.NODE_TRACE_RUN,
//					TraceElementKind.NODE_TRACE_IO,

					TraceElementKind.STEP_HEADER,
					TraceElementKind.STEP_BEGIN,
					TraceElementKind.STEP_END
			};


	public static final TraceElementKind[] FORMAT_ELEMENT =
			new TraceElementKind[] {
//					TraceElementKind.UNDEFINED,
					TraceElementKind.CONDITION,
					TraceElementKind.DECISION,
					TraceElementKind.FORMULA,
					TraceElementKind.PATH_CONDITION,
					TraceElementKind.PATH_CONDITION_LEAF,
					TraceElementKind.PATH_TIMED_CONDITION,
					TraceElementKind.PATH_TIMED_CONDITION_LEAF,
					TraceElementKind.NODE_CONDITION,
					TraceElementKind.NODE_CONDITION_LEAF,
					TraceElementKind.NODE_TIMED_CONDITION,
					TraceElementKind.NODE_TIMED_CONDITION_LEAF,
					TraceElementKind.ASSIGN,
					TraceElementKind.DELTA,
					TraceElementKind.TIME,
					TraceElementKind.VARIABLE,
					TraceElementKind.NEWFRESH,
					TraceElementKind.COM,
					TraceElementKind.INOUT,
					TraceElementKind.INPUT,
					TraceElementKind.OUTPUT,
					TraceElementKind.INPUT_ENV,
					TraceElementKind.OUTPUT_ENV,
					TraceElementKind.INPUT_RDV,
					TraceElementKind.OUTPUT_RDV,
					TraceElementKind.INPUT_BUFFER,
					TraceElementKind.OUTPUT_BUFFER,
					TraceElementKind.INPUT_VAR,
					TraceElementKind.OUTPUT_VAR,
					TraceElementKind.PORT,
					TraceElementKind.SIGNAL,
					TraceElementKind.MESSAGE,
					TraceElementKind.CHANNEL,
					TraceElementKind.BUFFER,
					TraceElementKind.RUNNABLE,
					TraceElementKind.ROUTINE,
					TraceElementKind.TRANSITION,
					TraceElementKind.MACHINE,
					TraceElementKind.STATE,
					TraceElementKind.STATEMACHINE,
					TraceElementKind.SYSTEM,
					TraceElementKind.FILE_HEADER,
					TraceElementKind.FILE_BEGIN,
					TraceElementKind.FILE_END,
					TraceElementKind.TESTCASE_HEADER,
					TraceElementKind.TESTCASE_BEGIN,
					TraceElementKind.TESTCASE_END,
					TraceElementKind.INIT_HEADER,
					TraceElementKind.INIT_BEGIN,
					TraceElementKind.INIT_END,
					TraceElementKind.STEP_HEADER,
					TraceElementKind.STEP_BEGIN,
					TraceElementKind.STEP_END,
					TraceElementKind.COMMENT,
					TraceElementKind.SEPARATOR,
					TraceElementKind.NEWLINE,
					TraceElementKind.NEXT,
					TraceElementKind.LIFELINE,
					TraceElementKind.LIFELINE_HEADER,
					TraceElementKind.LIFELINE_BEGIN,
					TraceElementKind.LIFELINE_END,
					TraceElementKind.LIFELINE_ID,
					TraceElementKind.LIFELINE_STATE,
//					TraceElementKind.RAW_ATTRIBUTE,
					TraceElementKind.NODE_HEADER,
					TraceElementKind.NODE_DATA,
					TraceElementKind.NODE_INFO,
					TraceElementKind.NODE_TRACE_RUN,
					TraceElementKind.NODE_TRACE_IO,
					TraceElementKind.VALUE_PARAMETER_BEGIN,
					TraceElementKind.VALUE_PARAMETER_SEPARATOR,
					TraceElementKind.VALUE_PARAMETER_END,
					TraceElementKind.VALUE_ARRAY_BEGIN,
					TraceElementKind.VALUE_ARRAY_SEPARATOR,
					TraceElementKind.VALUE_ARRAY_END,
					TraceElementKind.VALUE_STRUCT_BEGIN,
					TraceElementKind.VALUE_STRUCT_SEPARATOR,
					TraceElementKind.VALUE_STRUCT_END
				};

}
