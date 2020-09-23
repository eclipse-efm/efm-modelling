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
 *  - Initial API and Implementation
 *******************************************************************************/
package org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.xlia;

import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.efm.ecore.formalml.specification.XliaModel;
import org.eclipse.efm.formalml.ecore.factory.XLIAGenerator;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccActor;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccSystem;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.util.PrettyPrintWriter;

public class Generator {

	public static final String EFM_FOLDER     = "efm";

	public static final String XLIA_EXTENSION = "xlia";


	public static XliaModel moccAst2xlia(final MoccSystem moccSystem,
			final boolean conformance, final boolean traceGeneration)
	{
		if ( moccSystem != null ) {
			// Transform MoCC AST to xLIA Model
			final MoCC2XLIA mocc2xlia =
					new MoCC2XLIA(conformance, traceGeneration);

			return mocc2xlia.transformSystem(moccSystem);
		}

		return null;
	}


	public static void transformModel(
			final IPath path, final MoccSystem moccSystem)
	{
		final MoCC2XLIA mocc2xlia = new MoCC2XLIA(false, false);

		final XliaModel xliaModel = mocc2xlia.transformSystem(moccSystem);

		final IPath filePath =
				path.append(moccSystem.getName()).addFileExtension("xlia");

		if( xliaModel != null ) {
			write(filePath, moccSystem, xliaModel);
		}
		else {
			write(filePath, moccSystem);
		}
	}

	public static void write(final IPath path,
			final MoccSystem moccSystem, final XliaModel xliaModel)
	{
		try {
			final FileWriter fileWriter = new FileWriter( path.toOSString() );

			final PrettyPrintWriter ppwr = new PrettyPrintWriter(fileWriter);

			final CharSequence strXLIA =
					XLIAGenerator.generateModel(xliaModel);

			// MoCC ABSTRACT
			ppwr.appendEol_Eol("/*");
			moccSystem.toAbstract(ppwr);
			ppwr.appendEol_Eol2("*/");

			// XLIA
			ppwr.append(strXLIA.toString());

			// MoCC
			ppwr.appendEol_Eol("/*");
			moccSystem.toWriter(ppwr);
			ppwr.appendEol_Eol("*/");

			ppwr.close();

		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public static void write(final IPath path, final MoccSystem moccSystem)
	{
		try {
			final FileWriter fileWriter = new FileWriter( path.toOSString() );

			final PrettyPrintWriter ppwr = new PrettyPrintWriter(fileWriter);

			ppwr.appendEol_Eol("/*")
				.appendEol("==> INCONSISTENT MoccSystem <==");

			moccSystem.toAbstract(ppwr).appendEol();

			if( moccSystem.FEATURE != null ) {
				for( final MoccActor actor : moccSystem.getActor() ) {
					if( (actor.FEATURE != null) && (! actor.FEATURE.consistency) ) {
						ppwr.append(moccSystem.FEATURE.inconsistencyReason(actor))
							.appendTab(" actor ")
							.append(actor.getName()).appendEol(" {")
							.appendTab2("frequency = ")
								.appendEol(actor.getFrequency())
							.appendTab2("phase = ")
								.appendEol(actor.getPhase())
							.appendTab2("repetition = ")
								.appendEol(actor.FEATURE.repetition)
							.appendEol('}');
					}
				}
			}
			ppwr.appendEol();

			moccSystem.toWriter(ppwr).appendEol_Eol("*/");

			ppwr.close();

		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Refresh the Resource Navigator view
	 */
	public static void doRefreshWorkspace(final IResource resource, final boolean forced) {
		try {
			if( resource != null ) {
				resource.getProject().refreshLocal(
    					IResource.DEPTH_INFINITE, new NullProgressMonitor());
			}
			else if( forced ) {
				ResourcesPlugin.getWorkspace().getRoot().refreshLocal(
						IResource.DEPTH_INFINITE, new NullProgressMonitor());
			}
		}
		catch(final CoreException e) {
			e.printStackTrace();
		}
	}

}
