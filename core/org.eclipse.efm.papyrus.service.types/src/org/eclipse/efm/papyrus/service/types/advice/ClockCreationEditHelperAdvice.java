/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.eclipse.efm.papyrus.service.types.advice;


import java.util.Iterator;
import org.eclipse.efm.formalml.FormalBlock;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLUtil;

public class ClockCreationEditHelperAdvice extends AbstractEditHelperAdvice {


	private static final String CLOCK = "Clock";

	protected org.eclipse.gmf.runtime.common.core.command.ICommand getAfterConfigureCommand(final ConfigureRequest request) {

		EObject elementToConfig = request.getElementToConfigure();
		if (elementToConfig instanceof Property){
			Property propertyToConfig = (Property) elementToConfig;
			EObject parent = propertyToConfig.eContainer();
			if (parent instanceof Class){
				Class parentClass = (Class) parent;
				FormalBlock parentFormalBlock = UMLUtil.getStereotypeApplication(parentClass, FormalBlock.class);
				EList<Property> parentAttributes = parentClass.getAllAttributes();
				int maxCounter = 0;
				for (Iterator<Property> iterator = parentAttributes.iterator(); iterator.hasNext();) {
					Property property = iterator.next();
					if (property.getName()!= null && property.getName().startsWith(CLOCK)){
						String suffix = property.getName().substring(CLOCK.length());
						int counter;
						counter = Integer.parseInt(suffix);
						if (counter > maxCounter){

							maxCounter = counter;
						}

					}

				}
				propertyToConfig.setName(CLOCK+(maxCounter+1));
			}

		}



		return super.getAfterConfigureCommand(request);

	}

	@Override
	public boolean approveRequest(IEditCommandRequest request) {
		// TODO Auto-generated method stub

		if (request instanceof GetEditContextRequest){

			Object element = ((GetEditContextRequest) request).getEditContext();
			if (element instanceof Class){
				Class elementClass = (Class)element;


				 if (UMLUtil.getStereotypeApplication(elementClass, FormalBlock.class) != null) return true;

			}
			return false;
		}

		return super.approveRequest(request);
	}


}
