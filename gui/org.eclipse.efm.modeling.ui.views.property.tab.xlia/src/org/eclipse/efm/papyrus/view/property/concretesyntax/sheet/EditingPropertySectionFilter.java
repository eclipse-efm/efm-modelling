/*****************************************************************************
 * Copyright (c) 2014, 2016 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *
 *****************************************************************************/
package org.eclipse.efm.papyrus.view.property.concretesyntax.sheet;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;

/**
 * This class constrains the availability of the embedded XLIA editor.
 *
 * The ALF editor must only be available when:
 * 1. The selection is a Class (not composite)
 * 2. The selection is an Association
 * 3. The selection is a Signal
 * 4. The selection is a Datatype
 * 5. The selection is an Enumeration
 * 6. The selection is a Package
 * 7. The selection is an Activity
 */
public class EditingPropertySectionFilter implements IFilter {

	/**
	 * @see org.eclipse.jface.viewers.IFilter#select(java.lang.Object)
	 *
	 * @param toTest
	 *
	 * @return accepted
	 */
	@Override
	public boolean select(Object toTest) {
		Element element = this.resolveSemanticElement(toTest);
		boolean accepted = false;
		if( (element != null) /*&&
			XliaIntegrationPreferencesUtil.isXliaSupportEnabled()*/ ) {
			accepted = this.isValidInput(element);
		}
		return accepted;
	}

	/**
	 * Check the given input and returns true if it is a valid input for the embedded ALF editor
	 * false otherwise
	 *
	 * @param element
	 *            an input element for ALF embedded editor
	 *
	 * @return true if element is accepted as an input false otherwise
	 */
	private boolean isValidInput(Element element) {
		/* 1. First constraint: the element must be modifiable (i.e. not read only) */
		if (! this.isModifiable(element)) {
			return false;
		}
		/* 2. It should be in the scope supported by the XLIA editor */
		if( (element instanceof StateMachine) ||
			(element instanceof Region      ) ||
			(element instanceof Vertex      ) ||
			(element instanceof Transition  ) )
		{
			return( true );
		}
		
		else if( (element instanceof Model   ) ||
				(element instanceof Class    ) ||
				(element instanceof Property ) ||
				(element instanceof Parameter) ||
				(element instanceof Operation) ||
				(element instanceof Signal   ) ||
				(element instanceof Connector) ||
				(element instanceof DataType ) ||
				(element instanceof Package  ) ||
				(element instanceof EnumerationLiteral ) )
		{
			return( true );
		}
		
		else if( (element instanceof Activity )
				|| (element instanceof ActivityNode )
				|| (element instanceof ActivityEdge ) )
		{
			return( true );
		}

		else if( (element instanceof InteractionFragment)
//			|| (element instanceof Interaction )
			|| (element instanceof Lifeline )
			|| (element instanceof Message )
//			|| (element instanceof MessageOccurrenceSpecification )
			|| (element instanceof Constraint)
			|| (element instanceof Gate )
//			|| (element instanceof InteractionOperand)
//			|| (element instanceof CombinedFragment)
//			|| (element instanceof ActionExecutionSpecification)
//			|| (element instanceof BehaviorExecutionSpecification )
			)
		{
			return( true );
		}

		return true;
	}

	private boolean isModifiable(Element element) {
		Resource resource = element.eResource();
		if (resource != null) {
			return( ! EMFHelper.isReadOnly(element) );
		}
		return false;
	}

	/**
	 * From a selection this methods tries to extract the underlying model element
	 *
	 * @param selectedElement
	 *            an object selected in the view (e.g., a class in a diagram)
	 *
	 * @return semanticElement
	 *         the model element that is under the graphical element (may be null)
	 */
	private Element resolveSemanticElement(Object selectedElement) {
		return UMLUtil.resolveUMLElement(selectedElement);
	}
}