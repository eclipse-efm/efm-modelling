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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;
import org.eclipse.efm.execution.core.util.PrettyPrintWriter;
import org.eclipse.efm.execution.core.workflow.common.CommonFactory;
import org.eclipse.efm.execution.core.workflow.common.Location;
import org.eclipse.efm.execution.core.workflow.common.impl.WorkspaceImpl;

public class WorkspaceCustomImpl extends WorkspaceImpl
		implements IWorkflowConfigurationConstants {

	protected WorkspaceCustomImpl() {
		super();
	}


	public static WorkspaceCustomImpl create(
			ILaunchConfiguration configuration, IPath workingPathPath) {
		WorkspaceCustomImpl workspace = new WorkspaceCustomImpl();

		Location location = CommonFactory.eINSTANCE.createLocation();

		location.setRoot( workingPathPath.toString() );

		String str;
		try {
			str = configuration.getAttribute(
				 ATTR_WORKSPACE_OUTPUT_FOLDER_NAME,
				DEFAULT_WORKSPACE_OUTPUT_FOLDER_NAME);
		}
		catch( CoreException e ) {
			e.printStackTrace();

			str = DEFAULT_WORKSPACE_OUTPUT_FOLDER_NAME;
		}
		if( (str == null) || str.isEmpty() ) {
			str = DEFAULT_WORKSPACE_OUTPUT_FOLDER_NAME;
		}
		location.setOutput( str );

		try {
			str = configuration.getAttribute(
					ATTR_WORKSPACE_LOG_FOLDER_NAME,
					DEFAULT_WORKSPACE_LOG_FOLDER_NAME);
		}
		catch( CoreException e ) {
			e.printStackTrace();

			str = DEFAULT_WORKSPACE_LOG_FOLDER_NAME;
		}
		if( (str == null) || str.isEmpty() ) {
			str = DEFAULT_WORKSPACE_LOG_FOLDER_NAME;
		}
		location.setLog( str );

		try {
			str = configuration.getAttribute(
					ATTR_WORKSPACE_DEBUG_FOLDER_NAME,
					DEFAULT_WORKSPACE_DEBUG_FOLDER_NAME);
		}
		catch( CoreException e ) {
			e.printStackTrace();

			str = DEFAULT_WORKSPACE_DEBUG_FOLDER_NAME;
		}
		if( (str == null) || str.isEmpty() ) {
			str = DEFAULT_WORKSPACE_DEBUG_FOLDER_NAME;
		}
		location.setDebug( str );


//		location.setSource(".");
//		location.setLog("log");

		workspace.setLocation(location);

		return( workspace );
	}


	public void toWriter(PrettyPrintWriter writer) {
		writer.appendTabEol("workspace [");

		Location location = getLocation();

		writer.appendTab2( "root   = \"" )
			.append( location.getRoot()   ).appendEol( "\"" );

		writer.appendTab2( "output = \"" )
			.append( location.getOutput() ).appendEol( "\"" );

		writer.appendTab2( "log    = \"" )
			.append( location.getLog()    ).appendEol( "\"" );

		writer.appendTab2( "debug  = \"" )
			.append( location.getDebug()  ).appendEol( "\"" );

		writer.appendTabEol( "] // end workspace" );
	}

}
