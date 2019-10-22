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

import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.core.workflow.common.TraceElementKind;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.swt.graphics.Font;

public class TraceElementTableConfigProvider
		implements IWorkflowConfigurationConstants {

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

	public final static int HEIGHT_HINT_ROW_10 = 200;
	public final static int HEIGHT_HINT_ROW_7  = 150;
	public final static int HEIGHT_HINT_ROW_5  = 100;

	public final int MAX_HEIGHT_HINT;

	public final TraceElementKind[] VALID_TRACE_NATURES;

	public final TraceElementKind DEFAULT_TRACE_NATURE;

	public final String[] VALID_NATURES;

	public TraceElementTableConfigProvider(
			final String storeKey, final List<String> defaultAttributeValue,
			final String title, final String toolTipText, final boolean checkedBoxForColumnZero,
			final boolean isNatureUniqueSet, final String natureTitle, final int natureWidth,
			final String valueTitle, final int valueWidth, final int heightHint,
			final TraceElementKind[] validTraces, final TraceElementKind deafaultTrace) {

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

		MAX_HEIGHT_HINT = heightHint;

		VALID_TRACE_NATURES = validTraces;

		VALID_NATURES = new String[ validTraces.length ];
		for (int offset = 0; offset < validTraces.length; offset++) {
			VALID_NATURES[offset] = validTraces[offset].getLiteral();
		}

		DEFAULT_TRACE_NATURE = deafaultTrace;
	}

	public TraceElementTableConfigProvider(final String storeKey,
			final List<String> defaultAttributeValue, final String title, final String toolTipText,
			final boolean checkedBoxForColumnZero, final String natureTitle, final int natureWidth,
			final String valueTitle, final int valueWidth, final int heightHint,
			final TraceElementKind[] validTraces, final TraceElementKind deafaultTrace)
	{
		this(storeKey, defaultAttributeValue, title, toolTipText,
				checkedBoxForColumnZero, false, natureTitle,
				natureWidth, valueTitle, valueWidth, heightHint,
				validTraces, TraceElementKind.TRANSITION);
	}


	public TraceElementTableConfigProvider(final String storeKey,
			final List<String> defaultAttributeValue, final String title,
			final String toolTipText, final boolean checkedBoxForColumnZero,
			final String natureTitle, final int natureWidth, final String valueTitle,
			final int valueWidth, final int heightHint, final TraceElementKind[] validTraces)
	{
		this(storeKey, defaultAttributeValue, title, toolTipText,
				checkedBoxForColumnZero, false, natureTitle,
				natureWidth, valueTitle, valueWidth, heightHint,
				validTraces, TraceElementKind.TRANSITION);
	}


	public static final TraceElementKind[] TRANSITION_TRACE_ELEMENT =
			new TraceElementKind[] {
					TraceElementKind.TRANSITION,
					TraceElementKind.STATE,
					TraceElementKind.STATEMACHINE
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
//!					TraceElementKind.DELTA,
//!					TraceElementKind.TIME,
//
//!					TraceElementKind.VARIABLE,
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
//!					TraceElementKind.RUNNABLE,
//					TraceElementKind.ROUTINE,
//					TraceElementKind.SYSTEM,
//
					TraceElementKind.CONDITION,
					TraceElementKind.DECISION,
					TraceElementKind.FORMULA,
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
//!					TraceElementKind.NODE_TRACE_RUN,
//					TraceElementKind.NODE_TRACE_IO,
			};


	public static final TraceElementKind[] SERIALIZER_TRACE_ELEMENT =
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

					TraceElementKind.META_TRACE,
					TraceElementKind.META_DEBUG,

//					TraceElementKind.LIFELINE,

					TraceElementKind.EXECUTION_CONTEXT_ID,

					TraceElementKind.NODE,
					TraceElementKind.NODE_LABEL,
					TraceElementKind.NODE_HEADER,
					TraceElementKind.NODE_DATA,
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
					TraceElementKind.EXECUTION_CONTEXT_ID,
					TraceElementKind.NODE,
					TraceElementKind.NODE_LABEL,
					TraceElementKind.NODE_HEADER,
					TraceElementKind.NODE_DATA,
					TraceElementKind.NODE_INFO,
					TraceElementKind.NODE_TRACE_RUN,
					TraceElementKind.NODE_TRACE_IO,
					TraceElementKind.META_TRACE,
					TraceElementKind.META_DEBUG,
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


	///////////////////////////////////////////////////////////////////////////
	// Transition Coverage Trace Specification
	///////////////////////////////////////////////////////////////////////////

	public static TraceElementTableConfigProvider getTransitionCoverage(final Font font) {
		final PixelConverter pixelConverter = new PixelConverter(font);

		return new TraceElementTableConfigProvider(
				ATTR_TRANSITION_COVERAGE_SELECTION, BEHAVIOR_INITIAL_SAMPLE,
				"&Transition selection", BEHAVIOR_DESCRIPTION, true,
				"Nature" , pixelConverter.convertWidthInCharsToPixels(16),
				"Element", pixelConverter.convertWidthInCharsToPixels(48),
				pixelConverter.convertHeightInCharsToPixels(7),//HEIGHT_HINT_ROW_7,
				TRANSITION_TRACE_ELEMENT, TraceElementKind.TRANSITION);
	}


	///////////////////////////////////////////////////////////////////////////
	// Behavior Selection Trace Specification
	///////////////////////////////////////////////////////////////////////////

	public static TraceElementTableConfigProvider getBehaviorSelection(final Font font) {
		final PixelConverter pixelConverter = new PixelConverter(font);

		return new TraceElementTableConfigProvider(
				ATTR_BEHAVIOR_ANALYSIS_ELEMENT_NAME_LIST, BEHAVIOR_INITIAL_SAMPLE,
				"&Trace Sequence", BEHAVIOR_DESCRIPTION, true,
				"Nature" , pixelConverter.convertWidthInCharsToPixels(16),
				"Element", pixelConverter.convertWidthInCharsToPixels(48),
				pixelConverter.convertHeightInCharsToPixels(7),//HEIGHT_HINT_ROW_7,
				BEHAVIOR_SELECTION_TRACE_ELEMENT, TraceElementKind.TRANSITION);
	}


	///////////////////////////////////////////////////////////////////////////
	// Test Offline Observable / Controllable
	///////////////////////////////////////////////////////////////////////////

	public static TraceElementTableConfigProvider getObservableTrace(final Font font) {
		final PixelConverter pixelConverter = new PixelConverter(font);

		return new TraceElementTableConfigProvider(
				ATTR_TEST_OFFLINE_OBSERVABLE_SPECIFICATION,
				DEFAULT_TEST_OFFLINE_OBSERVABLE_SPECIFICATION,
				"&Observable", "", true,
				"Nature" , pixelConverter.convertWidthInCharsToPixels(16),
				"Element", pixelConverter.convertWidthInCharsToPixels(48),
				pixelConverter.convertHeightInCharsToPixels(5),//HEIGHT_HINT_ROW_5,
				BEHAVIOR_SELECTION_TRACE_ELEMENT, TraceElementKind.VARIABLE);
	}

	public static TraceElementTableConfigProvider getControllableTrace(final Font font) {
		final PixelConverter pixelConverter = new PixelConverter(font);

		return new TraceElementTableConfigProvider(
				ATTR_TEST_OFFLINE_CONTROLLABLE_SPECIFICATION,
				DEFAULT_TEST_OFFLINE_CONTROLLABLE_SPECIFICATION,
				"&Controllable", "", true,
				"Nature" , pixelConverter.convertWidthInCharsToPixels(16),
				"Element", pixelConverter.convertWidthInCharsToPixels(48),
				pixelConverter.convertHeightInCharsToPixels(5),//HEIGHT_HINT_ROW_5,
				BEHAVIOR_SELECTION_TRACE_ELEMENT, TraceElementKind.VARIABLE);
	}


	///////////////////////////////////////////////////////////////////////////
	// Behavior Selection Trace Specification
	///////////////////////////////////////////////////////////////////////////

	public static TraceElementTableConfigProvider getInferenceSelection(final Font font) {
		final PixelConverter pixelConverter = new PixelConverter(font);

		return new TraceElementTableConfigProvider(
				ATTR_INFERENCE_ANALYSIS_ELEMENT_NAME_LIST, BEHAVIOR_INITIAL_SAMPLE,
				"&Trace Sequence", BEHAVIOR_DESCRIPTION, true,
				"Nature" , pixelConverter.convertWidthInCharsToPixels(16),
				"Element", pixelConverter.convertWidthInCharsToPixels(48),
				pixelConverter.convertHeightInCharsToPixels(7),//HEIGHT_HINT_ROW_7,
				BEHAVIOR_SELECTION_TRACE_ELEMENT, TraceElementKind.TRANSITION);
	}


	///////////////////////////////////////////////////////////////////////////
	// Ad'HocTest Generation Extension Trace / Format
	///////////////////////////////////////////////////////////////////////////

	public static TraceElementTableConfigProvider getTraceExtensionObjective(final Font font) {
		final PixelConverter pixelConverter = new PixelConverter(font);

		return new TraceElementTableConfigProvider(
				ATTR_TRACE_EXTENSION_OBJECTIVE, DEFAULT_TRACE_EXTENSION_OBJECTIVE,
				"Trace Ending with", BEHAVIOR_DESCRIPTION, true,
				"Nature" , pixelConverter.convertWidthInCharsToPixels(16),
				"Element", pixelConverter.convertWidthInCharsToPixels(48),
				pixelConverter.convertHeightInCharsToPixels(5),//HEIGHT_HINT_ROW_5,
				BEHAVIOR_SELECTION_TRACE_ELEMENT, TraceElementKind.TRANSITION);
	}

	public static TraceElementTableConfigProvider getTestGenerationTraceDetail(final Font font) {
		final PixelConverter pixelConverter = new PixelConverter(font);

		return new TraceElementTableConfigProvider(
				ATTR_BASIC_TRACE_DETAILS_ELEMENT_LIST,
				DEFAULT_BASIC_TRACE_DETAILS_ELEMENT_LIST,
				"&Detail", BEHAVIOR_DESCRIPTION, true,
				"Nature" , pixelConverter.convertWidthInCharsToPixels(16),
				"Element", pixelConverter.convertWidthInCharsToPixels(48),
				pixelConverter.convertHeightInCharsToPixels(5),//HEIGHT_HINT_ROW_5,
				SERIALIZER_TRACE_ELEMENT, TraceElementKind.TRANSITION);
	}

	public static TraceElementTableConfigProvider getTestGenenrationTraceFormat(final Font font) {
		final PixelConverter pixelConverter = new PixelConverter(font);

		return new TraceElementTableConfigProvider(
				ATTR_BASIC_TRACE_FORMAT_ELEMENT_LIST,
				DEFAULT_BASIC_TRACE_FORMAT_ELEMENT_LIST,
				"&Ad'Hoc Element Format for Tests",
				HELPER_TRACE_FORMAT_SPECIFICATION, false, true,
				"Nature" , pixelConverter.convertWidthInCharsToPixels(32),
				"Element", pixelConverter.convertWidthInCharsToPixels(48),
				pixelConverter.convertHeightInCharsToPixels(10),//HEIGHT_HINT_ROW_10,
				FORMAT_ELEMENT, TraceElementKind.RAW_ATTRIBUTE);
	}


	///////////////////////////////////////////////////////////////////////////
	// First Symbex Output Graphiz Trace / Format
	///////////////////////////////////////////////////////////////////////////

	public static TraceElementTableConfigProvider getFirstSymbexOutputGraphizTrace(final Font font) {
		final PixelConverter pixelConverter = new PixelConverter(font);

		return new TraceElementTableConfigProvider(
				ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC,
				DEFAULT_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC,
				"&Trace Filter", "", true,
				"Nature" , pixelConverter.convertWidthInCharsToPixels(16),
				"Element", pixelConverter.convertWidthInCharsToPixels(48),
				pixelConverter.convertHeightInCharsToPixels(7),//HEIGHT_HINT_ROW_7,
				SERIALIZER_TRACE_ELEMENT, TraceElementKind.VARIABLE);
	}

	public static TraceElementTableConfigProvider getFirstSymbexOutputGraphizFormat(final Font font) {
		final PixelConverter pixelConverter = new PixelConverter(font);

		return new TraceElementTableConfigProvider(
				ATTR_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC,
				DEFAULT_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC,
				"&Format", "", false, true,
				"Nature" , pixelConverter.convertWidthInCharsToPixels(32),
				"Element", pixelConverter.convertWidthInCharsToPixels(48),
				pixelConverter.convertHeightInCharsToPixels(10),//HEIGHT_HINT_ROW_10,
				FORMAT_ELEMENT, TraceElementKind.VARIABLE);
	}


	///////////////////////////////////////////////////////////////////////////
	// Second Symbex Output Graphiz Trace / Format
	///////////////////////////////////////////////////////////////////////////

	public static TraceElementTableConfigProvider getSecondSymbexOutputGraphizTrace(final Font font) {
		final PixelConverter pixelConverter = new PixelConverter(font);

		return new TraceElementTableConfigProvider(
				ATTR_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC,
				DEFAULT_FIRST_SYMBEX_OUTPUT_GRAPHVIZ_TRACE_SPEC,
				"&Extension Trace Filter", "", true,
				"Nature" , pixelConverter.convertWidthInCharsToPixels(16),
				"Element", pixelConverter.convertWidthInCharsToPixels(48),
				pixelConverter.convertHeightInCharsToPixels(5),//HEIGHT_HINT_ROW_5,
				SERIALIZER_TRACE_ELEMENT, TraceElementKind.VARIABLE);
	}


	public static TraceElementTableConfigProvider getSecondSymbexOutputGraphizFormat(final Font font) {
		final PixelConverter pixelConverter = new PixelConverter(font);

		return new TraceElementTableConfigProvider(
				ATTR_SECOND_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC,
				DEFAULT_SYMBEX_OUTPUT_GRAPHVIZ_FORMAT_SPEC,
				"&Extension Format", "", false, true,
				"Nature" , pixelConverter.convertWidthInCharsToPixels(24),
				"Element", pixelConverter.convertWidthInCharsToPixels(48),
				pixelConverter.convertHeightInCharsToPixels(10),//HEIGHT_HINT_ROW_10,
				FORMAT_ELEMENT, TraceElementKind.VARIABLE);
	}



}
