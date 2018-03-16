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
package org.eclipse.efm.execution.core.util;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.efm.execution.core.IWorkflowConfigurationConstants;

public class WorkflowFileUtils implements IWorkflowConfigurationConstants {

	public static final String EMPTY_STRING = "";

	public static final String WORKSPACE_SEGMENT = "${workspace_loc}";

	public static final String WORKSPACE_PREFIX = WORKSPACE_SEGMENT + IPath.SEPARATOR;


	public static final Path WORKSPACE_PREFIX_PATH = new Path( "${workspace_loc}" );


	public static final IPath WORKSPACE_PATH =
			ResourcesPlugin.getWorkspace().getRoot().getLocation();

	public static final String WORKSPACE_LOCATION = WORKSPACE_PATH.toString();


	/**
	 * make relative path
	 * @param path
	 * @return
	 */
	public static IPath makeRelativePath(final IPath path) {
		final IPath relativePath = //WORKSPACE_PREFIX_PATH.append(
				path.makeRelativeTo(WORKSPACE_PATH);

		return relativePath;
	}

	/**
	 * make relative location
	 * @param referencePath
	 * @param location
	 * @return
	 */
	public static String makeRelativeParentLocation(
			final IPath referencePath, final String location)
	{
		final IPath parentPath = new Path(location).removeLastSegments(1);

		final IPath relativePath = parentPath.makeRelativeTo(referencePath);

		return (relativePath.segmentCount() > 0) ? relativePath.toString() : ".";
	}

	/**
	 * make relative location
	 * @param location
	 * @return
	 */
	public static String makeRelativeLocation(final IPath path)
	{
		final IPath relativePath = path.makeRelativeTo(WORKSPACE_PATH);

		final String relativeLocation = WORKSPACE_PREFIX + relativePath.toString();

		return relativeLocation;
	}

	/**
	 * make relative location
	 * @param location
	 * @return
	 */
	public static String makeRelativeLocation(final String location)
	{
		final IPath locationPath = new Path(location);
		if( (locationPath.segmentCount() == 0)
			|| WORKSPACE_SEGMENT.equals(locationPath.segment(0)))
		{
			return location;
		}
		else {
			final String relativeLocation = WORKSPACE_PREFIX
					+ locationPath.makeRelativeTo(WORKSPACE_PATH).toString();

			return relativeLocation;
		}
	}


	/**
	 * make absolute path
	 * @param path
	 * @return
	 */
	public static IPath makeAbsolutePath(final IPath path)
	{
		if( path.isAbsolute() ) {
			return path;
		}
		else if( path.segmentCount() > 0 )
		{
			if( WORKSPACE_SEGMENT.equals(path.segment(0)) )
			{
				final IPath absolutePath =
						WORKSPACE_PATH.append(path.removeFirstSegments(1));

				return absolutePath;
			}
			else {
				final IPath absolutePath = WORKSPACE_PATH.append(path);

				return absolutePath;
			}
		}

		return path;
	}

	/**
	 * make absolute location
	 * @param location
	 * @return
	 */
	public static String makeAbsoluteLocation(String location)
	{
		final IPath absolutePath = makeAbsolutePath(new Path(location));

		return absolutePath.toString();
	}


	/**
	 * Getter for raw location in configuration
	 * @param configuration
	 * @param storeKey
	 * @param defaultLocation
	 * @return
	 */
	public static String getRawLocation(
			ILaunchConfiguration configuration,
			final String storeKey, final String defaultLocation)
	{
		String location = null;
		try {
			location = configuration.getAttribute(storeKey, defaultLocation);
		}
		catch (CoreException e) {
			e.printStackTrace();

			location = null;
		}

		return (location != null) ? location : defaultLocation;
	}


	/**
	 * Getter for raw location in configuration
	 * @param configuration
	 * @param storeKey
	 * @return
	 */
	public static String getAbsoluteLocation(
			ILaunchConfiguration configuration,
			final String storeKey, final String defaultLocation)
	{
		final String location = makeAbsoluteLocation(
				getRawLocation(configuration, storeKey, defaultLocation));

		return( location );
	}

	/**
	 * Getter for raw location in configuration
	 * @param configuration
	 * @param storeKey
	 * @return
	 */
	public static String getRelativeLocation(
			ILaunchConfiguration configuration,
			final String storeKey, final String defaultLocation)
	{
		final String location = makeRelativeLocation(
				getRawLocation(configuration, storeKey, defaultLocation));

		return( location );
	}


	/**
	 * Setter for location in configuration
	 * @param configuration
	 * @param storeKey
	 * @param location
	 */
	public static void setRelativeLocation(
			ILaunchConfigurationWorkingCopy configuration,
			final String storeKey, final String location)
	{
		configuration.setAttribute(storeKey, makeRelativeLocation(location));
	}


	/**
	 * filename of the location
	 * @param location
	 * @return
	 */
	public static String filename(final String location) {
		final IPath path = new Path(location);

		return (path.segmentCount() > 0 )
				? path.lastSegment().toString()
				: "<no-filename>";
	}

	/**
	 * basename of the location
	 * @param location
	 * @return
	 */
	public static String basename(final String location) {
		final IPath path = new Path(location);

		return (path.segmentCount() > 0 )
				? path.removeFileExtension().lastSegment().toString()
				: "<no-basename>";
	}

	/**
	 * file location configuration attribute filename
	 * @param configuration
	 * @param storeKey
	 * @return
	 */
	public static String getModelBasename(ILaunchConfiguration configuration) {
		String modelPath = getRawLocation(configuration,
				ATTR_SPECIFICATION_MODEL_FILE_LOCATION, EMPTY_STRING);

		return( modelPath.isEmpty() ? EMPTY_STRING : basename(modelPath) );
	}

}
