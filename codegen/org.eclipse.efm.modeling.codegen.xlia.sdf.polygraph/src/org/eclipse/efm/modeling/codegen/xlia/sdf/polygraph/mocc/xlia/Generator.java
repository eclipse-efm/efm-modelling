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
import java.io.PrintWriter;
import java.util.Arrays;

import org.eclipse.core.runtime.IPath;
import org.eclipse.efm.ecore.formalml.XliaModel;
import org.eclipse.efm.formalml.ecore.factory.XLIAGenerator;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccActor;
import org.eclipse.efm.modeling.codegen.xlia.sdf.polygraph.mocc.ast.MoccSystem;

public class Generator {

	public static final String EFM_FOLDER     = "efm";

	public static final String XLIA_EXTENSION = "xlia";


//	public static MoccSystem activity2moccAst(final EObject selectedEObject)
//	{
//		if ( selectedEObject instanceof Activity ) {
//			final Activity selectedActivity = (Activity) selectedEObject;
//
//			// Transform UML to MoCC AST
//			final Uml2MoCC uml2Mocc = new Uml2MoCC(selectedActivity);
//			uml2Mocc.transform();
//
//			final MoccSystem moccSystem = uml2Mocc.getMoccSystem();
//
//			// Compute features of MoCC AST
//			moccSystem.computeFeatureStrict();
//
//			return moccSystem;
//		}
//
//		return null;
//	}

	public static XliaModel moccAst2xlia(final MoccSystem moccSystem)
	{
		if ( moccSystem != null ) {
			// Compute features of MoCC AST
			if( moccSystem.FEATURE == null ) {
				moccSystem.computeFeature();
			}

			// Transform MoCC AST to xLIA Model
			final MoCC2XLIA mocc2xlia = new MoCC2XLIA(moccSystem, true);
			mocc2xlia.transform();

			return mocc2xlia.xliaModel;
		}

		return null;
	}

//	public static void execute(
//			final IProject project, final EObject selectedEObject)
//	{
//		if ( project.exists()  ) {
//			// Transform UML to MoCC AST
//			final MoccSystem moccSystem = activity2moccAst(selectedEObject);
//
//			// Transform MoCC AST to xLIA Model
//			final XliaModel xliaModel = moccAst2xlia(moccSystem);
//
//			final IFolder folder = project.getFolder(EFM_FOLDER);
//			if (! folder.exists()) {
//				try {
//					folder.create(IResource.NONE, true, null);
//				} catch (final CoreException e) {
//					Activator.log.error(e);
//				}
//			}
//
//			final IPath pathXlia = folder.getLocation()
//					.append(moccSystem.getName()).addFileExtension(XLIA_EXTENSION);
//
//			Generator.execute(pathXlia, moccSystem, xliaModel);
//		}
//	}


	public static void execute(final IPath path,
			final MoccSystem moccSystem, final XliaModel xliaModel)
	{
		try {
			final FileWriter buffer = new FileWriter( path.toOSString() );
			final PrintWriter writer = new PrintWriter(buffer);

			final CharSequence strXLIA =
					XLIAGenerator.generateModel(xliaModel);

			writer.write(strXLIA.toString());

			writer.write("\n/*\n");

			writer.write(moccSystem.toString());
			writer.write("\n*/\n");

			writer.close();

		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public static void execute(final IPath path, final MoccSystem moccSystem)
	{
		try {
			final FileWriter buffer = new FileWriter( path.toOSString() );
			final PrintWriter writer = new PrintWriter(buffer);

			final StringBuilder sout = new StringBuilder();
			sout.append("\n/*\n")
				.append("==> INCONSISTENT MoccSystem <==\n");

			sout.append("system ").append(moccSystem.getName())
				.append(" {").append('\n')
				.append('\t').append("frequencies = " )
				.append(Arrays.toString(
						moccSystem.FEATURE.frequencies)).append('\n')
				.append('\t').append("tick = ")
					.append(moccSystem.FEATURE.tick_interval)
					.append('\n')
				.append('\t').append("period = ")
					.append(moccSystem.FEATURE.tick_period)
					.append('\n')
				.append('\t').append("repetition = ")
					.append(Arrays.toString(moccSystem.FEATURE.repetitions))
					.append('\n')
				.append('}').append('\n');

			for( final MoccActor actor : moccSystem.getActor() ) {
				if( ! actor.FEATURE.consistency ) {
					sout.append("Inconsistent actor ")
						.append(actor.getName()).append(" {").append('\n')
						.append('\t').append("frequency = ")
							.append(actor.getFrequency()).append('\n')
						.append('\t').append("phase = ")
							.append(actor.getPhase()).append('\n')
						.append('\t').append("repetition = ")
							.append(actor.FEATURE.repetition).append('\n')
						.append('}').append('\n');
				}
			}
			sout.append('\n');

			writer.write(sout.toString());

			writer.write(moccSystem.toString());
			writer.write("\n*/\n");

			writer.close();

		} catch (final IOException e) {
			e.printStackTrace();
		}
	}


}