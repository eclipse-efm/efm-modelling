/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.core.workflow;

/**
 * Defines the constants available for client use.
 * <p>
 * This interface is not intended to be extended or implemented by clients.
 * </p>
 * inspired by org.eclipse.core.externaltools.internal.IExternalToolConstants
 */
public interface ToolConstants {

	/**
	 * Constant for the empty {@link String}
	 *
	 * @since org.eclipse.efm.runconfiguration 1.0.100
	 */
	public static final String EMPTY_STRING = ""; //$NON-NLS-1$

	/**
	 * Plug-in identifier for Diversity SDK Common UI (value <code>org.eclipse.efm.runconfiguration.ui</code>).
	 */
	public static final String UI_PLUGIN_ID = "org.eclipse.efm.runconfiguration.ui"; //$NON-NLS-1$;

	/**
	 * Plug-in identifier for Diversity SDK Common (value <code>org.eclipse.efm.runconfiguration</code>).
	 */
	public static final String PLUGIN_ID = "org.eclipse.efm.runconfiguration"; //$NON-NLS-1$;




	// The Diversity install location
	public static final String ATTR_DIVERSITY_INSTALLATION_LOCATION =
			UI_PLUGIN_ID + ".ATTR_DIVERSITY_INSTALLATION_LOCATION";

	// The Abstract Virtual Machine executable location
	public static final String ATTR_DIVERSITY_AVM_EXECUTABLE_LOCATION =
			UI_PLUGIN_ID + ".ATTR_DIVERSITY_AVM_EXECUTABLE_LOCATION";

	public static final String ATTR_DIVERSITY_AVM_EXECUTABLE_VERSION =
			UI_PLUGIN_ID + ".ATTR_DIVERSITY_AVM_EXECUTABLE_VERSION";

	// The Diversity graph viewer location
	public static final String ATTR_DIVERSITY_GRAPH_VIEWER_LOCATION =
			UI_PLUGIN_ID + ".ATTR_DIVERSITY_GRAPH_VIEWER_LOCATION";

	/**
	 * String attribute identifying the location of an external. Default value
	 * is <code>null</code>. Encoding is tool specific.
	 */
	public static final String ATTR_LAUNCH_AVM_LOCATION_USED_DEFAULT =
			UI_PLUGIN_ID + ".ATTR_LAUNCH_AVM_LOCATION_USED_DEFAULT"; //$NON-NLS-1$

	public static final String ATTR_LAUNCH_AVM_LOCATION =
			UI_PLUGIN_ID + ".ATTR_LAUNCH_AVM_LOCATION"; //$NON-NLS-1$

	public static final String ATTR_LAUNCH_AVM_LOCATION_HISTORY =
			UI_PLUGIN_ID + ".ATTR_LAUNCH_AVM_LOCATION_HISTORY"; //$NON-NLS-1$


	public static final String ATTR_LAUNCH_PROJECT_IS_USED =
			UI_PLUGIN_ID + ".ATTR_LAUNCH_PROJECT_IS_USED"; //$NON-NLS-1$



	public static final String PREF_EXPERT_MODE =
			UI_PLUGIN_ID + ".PREF_EXPERT_MODE";

	public static final String PREF_INCUBATION_MODE =
			UI_PLUGIN_ID + ".PREF_INCUBATION_MODE";

	public static final String PREF_DEBUG_OPTIONS =
			UI_PLUGIN_ID + ".PREF_DEBUG_OPTIONS";

	public static final String PREF_SYMBEX_DEVELOPER_MODE =
			UI_PLUGIN_ID + ".PREF_SYMBEX_DEVELOPER_MODE";

	public static final String PREF_CONSOLE_VIEW =
			UI_PLUGIN_ID + ".PREF_CONSOLE_VIEW";

	public static final String PREF_SPIDER_VIEW =
			UI_PLUGIN_ID + ".PREF_SPIDER_VIEW";



//	/**
//	 * Boolean attribute indicating if the user should be prompted for
//	 * arguments before running a tool. Default value is <code>false</code>.
//	 * THIS ATTRIBUTE IS NOT USED.
//	 */
//	public static final String ATTR_PROMPT_FOR_ARGUMENTS =
//			UI_PLUGIN_ID + ".ATTR_PROMPT_FOR_ARGUMENTS"; //$NON-NLS-1$
//
//	/**
//	 * String attribute identifying the scope of resources that should trigger an
//	 * external tool to run. Default value is <code>null</code>
//	 * indicating that the builder will be triggered for all changes.
//	 */
//	public static final String ATTR_BUILDER_SCOPE =
//			UI_PLUGIN_ID + ".ATTR_BUILD_SCOPE"; //$NON-NLS-1$
//
//	/**
//	 * String attribute containing an array of build kinds for which an
//	 * external tool builder should be run.
//	 */
//	public static final String ATTR_RUN_BUILD_KINDS =
//			UI_PLUGIN_ID + ".ATTR_RUN_BUILD_KINDS"; //$NON-NLS-1$
//
//	/**
//	 * Boolean attribute indicating if the console should be shown on external
//	 * tool output. Default value is <code>false</code>.
//	 */
//	public static final String ATTR_SHOW_CONSOLE =
//			UI_PLUGIN_ID + ".ATTR_SHOW_CONSOLE"; //$NON-NLS-1$

	/**
	 * String attribute containing the arguments that should be passed to the
	 * tool. Default value is <code>null</code>, and encoding is tool specific.
	 */
	public static final String ATTR_TOOL_ARGUMENTS =
			UI_PLUGIN_ID + ".ATTR_TOOL_ARGUMENTS"; //$NON-NLS-1$

	/**
	 * String attribute identifying the working directory of an external tool.
	 * Default value is <code>null</code>, which indicates a default working
	 * directory, which is tool specific.
	 */
	public static final String ATTR_WORKING_DIRECTORY =
			UI_PLUGIN_ID + ".ATTR_WORKING_DIRECTORY"; //$NON-NLS-1$

//	/**
//	 * String attribute identifying whether an external tool builder configuration
//	 * is enabled. The default value is <code>true</code>, which indicates
//	 * that the configuration will be executed as appropriate by the builder.
//	 */
//	public static final String ATTR_BUILDER_ENABLED =
//			UI_PLUGIN_ID + ".ATTR_BUILDER_ENABLED"; //$NON-NLS-1$
//
	/**
	 * Status code indicating an unexpected internal error.
	 */
	public static final int ERR_INTERNAL_ERROR = 150;

//	/**
//	 * String attribute identifying a non-external tool builder launch configuration that is disabled
//	 * The value is the name of the disabled builder.
//	 */
//	public static final String ATTR_DISABLED_BUILDER =
//			UI_PLUGIN_ID + ".ATTR_DISABLED_BUILDER";		 //$NON-NLS-1$
//
//	/**
//	 * boolean attribute identifying that an external tool builder has been configured for triggering
//	 * using the <code>ICommand.setBuilding(int)</code> mechanism
//	 * @since 3.1
//	 */
//	public static final String ATTR_TRIGGERS_CONFIGURED =
//			UI_PLUGIN_ID + ".ATTR_TRIGGERS_CONFIGURED";		 //$NON-NLS-1$
//
//	/**
//	 * String attribute identifying the build scope for a launch configuration.
//	 * <code>null</code> indicates the default workspace build.
//	 */
//	public static final String ATTR_BUILD_SCOPE =
//			UI_PLUGIN_ID + ".ATTR_LAUNCH_CONFIGURATION_BUILD_SCOPE"; //$NON-NLS-1$
//
//	/**
//	 * Attribute identifier specifying whether referenced projects should be
//	 * considered when computing the projects to build. Default value is
//	 * <code>true</code>.
//	 */
//	public static final String ATTR_INCLUDE_REFERENCED_PROJECTS =
//			UI_PLUGIN_ID + ".ATTR_INCLUDE_REFERENCED_PROJECTS"; //$NON-NLS-1$
}
