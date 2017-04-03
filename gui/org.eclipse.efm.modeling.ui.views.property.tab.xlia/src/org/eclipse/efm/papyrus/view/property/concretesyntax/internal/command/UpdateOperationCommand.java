/*****************************************************************************
* Copyright (c) 2016 CEA LIST.
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*****************************************************************************/
package org.eclipse.efm.papyrus.view.property.concretesyntax.internal.command;

import org.eclipse.efm.modeling.formalml.helpers.StereotypeUtil;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.UMLPackage;

public class UpdateOperationCommand extends AbstractUpdateCommand {

	protected Operation fOperationContext;

	public UpdateOperationCommand(Operation operationContext,
			String newEditedText, String oldEditedText) {
		super(operationContext, newEditedText, oldEditedText);

		fOperationContext = operationContext;
	}


	protected boolean compile() {
		if( this.fNewEditedText != null ) {
//			Model root = fOperationContext.getModel();
//			if( root != null ) {
//				return true;
//			}

			return true;
		}

		return false ;
	}

	protected boolean merge() {
		System.out.println("Begin doExecuteWithResult Operation !!!");

		// METHOD as BEHAVIOR
		String xliaBehavior = extractMethod(this.fNewEditedText);
		String oldBehavior  = extractMethod(this.fOldEditedText);
		if( (oldBehavior != xliaBehavior) && ( (oldBehavior == null) ||
				(! oldBehavior.equals(xliaBehavior))) ) {
			// remove/destroy old effect.

			if( ! fOperationContext.getMethods().isEmpty() ) {
				Behavior method = fOperationContext.getMethods().get(0);
				if( method instanceof OpaqueBehavior ) {
					OpaqueBehavior oBehavior = (OpaqueBehavior) method;

					oBehavior.getBodies().clear();

					oBehavior.getLanguages().add(
							StereotypeUtil.XLIA_LANGUAGE);

					if( xliaBehavior != null ) {
						oBehavior.getBodies().add( xliaBehavior );
					}
				}
			}
			else if( xliaBehavior != null ) {
				// Create the new behavior !
				org.eclipse.uml2.uml.Class behaviorContainer =
						fOperationContext.getClass_();

				if( behaviorContainer != null ) {
					OpaqueBehavior newMethodBehavior = (OpaqueBehavior)
							behaviorContainer.createOwnedBehavior(
							fOperationContext.getName() + "_xliaBehavior",
							UMLPackage.eINSTANCE.getOpaqueBehavior());

					newMethodBehavior.getLanguages().add(
							StereotypeUtil.XLIA_LANGUAGE);

					newMethodBehavior.getBodies().add( xliaBehavior );

					fOperationContext.getMethods().add( newMethodBehavior );
				}
			}
		}

		System.out.println("End Commit Operation !!!");

		return true;
	}


	////////////////////////////////////////////////////////////////////////////
	// xLIA TEXT EXTRACTION UTILS
	////////////////////////////////////////////////////////////////////////////

	private final String[] METHOD_BEGIN_MARK = { "//begin xlia::behavior method" , "{" };
	private final String[] METHOD_END_MARKS  = { "//end xlia::behavior method" };

	private String extractMethod(String editedText) {
		String xliaBehavior = "commit< effect xLIA textual behavior >";

		xliaBehavior = extractXliaCode(
				editedText, 0, METHOD_BEGIN_MARK, METHOD_END_MARKS);

		return( xliaBehavior );
	}


}
