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

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
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


	public static final IWorkspaceRoot WORKSPACE_ROOT =
			ResourcesPlugin.getWorkspace().getRoot();

	public static final IPath WORKSPACE_PATH = WORKSPACE_ROOT.getLocation();

	public static final String WORKSPACE_LOCATION = WORKSPACE_PATH.toString();


	public static final String PLATFORM_URI = WORKSPACE_LOCATION;

	public static final String URI_PREFIX   = "platform:/resource/";




	/**
	 * make root path relative to WORKSPACE_PATH or absolute
	 * @param path
	 * @return
	 */
	public static IPath makeRootRelativeToWorkspacePath(final IPath path) {
		if( WORKSPACE_PATH.isPrefixOf(path) ) {
			final IPath relativePath = path.makeRelativeTo(WORKSPACE_PATH);

			return relativePath;
		}

		return path;
	}

	/**
	 * make relative path
	 * @param path
	 * @return
	 */
	public static IPath makeRelativePath(final IPath path) {
		if( WORKSPACE_PATH.isPrefixOf(path) ) {
			final IPath relativePath = //WORKSPACE_PREFIX_PATH.append(
					path.makeRelativeTo(WORKSPACE_PATH);

			return relativePath;
		}

		return path;
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
		if( WORKSPACE_PATH.isPrefixOf(path) ) {
			final IPath relativePath = path.makeRelativeTo(WORKSPACE_PATH);

			final String relativeLocation = WORKSPACE_PREFIX + relativePath.toString();

			return relativeLocation;
		}

		return path.toString();
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
			|| WORKSPACE_SEGMENT.equals(locationPath.segment(0))
			|| (! WORKSPACE_PATH.isPrefixOf(locationPath)) )
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
	public static String makeAbsoluteLocation(final String location)
	{
		final IPath absolutePath = makeAbsolutePath(new Path(location));

//		String path = VariablesPlugin.getDefault().getStringVariableManager()
//				.performStringSubstitution(location, false);


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
			final ILaunchConfiguration configuration,
			final String storeKey, final String defaultLocation)
	{
		String location = null;
		try {
			location = configuration.getAttribute(storeKey, defaultLocation);
		}
		catch (final CoreException e) {
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
			final ILaunchConfiguration configuration,
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
			final ILaunchConfiguration configuration,
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
			final ILaunchConfigurationWorkingCopy configuration,
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
	public static String getModelBasename(final ILaunchConfiguration configuration) {
		final String modelPath = getRawLocation(configuration,
				ATTR_SPECIFICATION_MODEL_FILE_LOCATION, EMPTY_STRING);

		return( modelPath.isEmpty() ? EMPTY_STRING : basename(modelPath) );
	}

	/**
	 * make an URI location
	 * @param filePath
	 * @return
	 */
	public static String makeURI(final String fileLocation) {
		final IPath path = new Path(fileLocation);

		final IPath relativeLocation = path.makeRelativeTo(WORKSPACE_PATH);

		return URI_PREFIX + relativeLocation.toString();
	}


	public static IResource find(final IPath path) {
		return WORKSPACE_ROOT.findMember(path);
	}

}
