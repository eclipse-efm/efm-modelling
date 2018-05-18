/*****************************************************************************
* Copyright (c) 2016 CEA LIST.
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
*  - Initial API and implementation
*****************************************************************************/
package org.eclipse.efm.formalml.xtext

import org.eclipse.xtext.parser.DefaultEcoreElementFactory
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.conversion.ValueConverterException
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.efm.ecore.formalml.common.VisibilityKind
import org.eclipse.efm.ecore.formalml.datatype.DataType
import org.eclipse.efm.ecore.formalml.infrastructure.PropertyDefinition
import org.eclipse.efm.ecore.formalml.infrastructure.Parameter
import org.eclipse.efm.ecore.formalml.infrastructure.ParameterDirectionKind

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class FormalMLAstFactory  extends DefaultEcoreElementFactory {
		
//	@Inject extension FormalMLGrammarAccess
	
//	@Inject
//	private IQualifiedNameProvider nameProvider;

	
	override public void add(EObject object,
		String feature, Object value, String ruleName, INode node)
				throws ValueConverterException {

		super.add(object, feature, value, ruleName, node);

		if( ruleName === null ) {
			return;
		}
		else switch( value ) {
			Parameter: {
				if( ruleName.endsWith("Input") ) {
					value.direction = ParameterDirectionKind.IN
				}
				else if( ruleName.endsWith("Output") ) {
					value.direction = ParameterDirectionKind.OUT
				}
				else if( ruleName.endsWith("Inout") ) {
					value.direction = ParameterDirectionKind.INOUT
				}
				else if( ruleName.endsWith("Return") ) {
					value.direction = ParameterDirectionKind.RETURN
				}
				
//				if( ruleName.endsWith("ut") || ruleName.endsWith("rn") ) {
//					println(value.direction.literal + " " + value.eClass.name
//						+ " " + nameProvider.getFullyQualifiedName(value))
//				}
			}
			
			PropertyDefinition: {
				if( ruleName.endsWith("Public") ) {
					value.visibility = VisibilityKind.PUBLIC
				}
				else if( ruleName.endsWith("Protected") ) {
					value.visibility = VisibilityKind.PROTECTED
				}
				else if( ruleName.endsWith("Private") ) {
					value.visibility = VisibilityKind.PRIVATE
				}
					
//				println(value.visibility.literal + " " + value.eClass.name
//					+ " " + nameProvider.getFullyQualifiedName(value))
			}
			DataType:  {
				if( ruleName.endsWith("Public") ) {
					value.visibility = VisibilityKind.PUBLIC
				}
				else if( ruleName.endsWith("Protected") ) {
					value.visibility = VisibilityKind.PROTECTED
				}
				else if( ruleName.endsWith("Private") ) {
					value.visibility = VisibilityKind.PRIVATE
				}
					
//				println(value.visibility.literal + " " + value.eClass.name
//					+ " " + nameProvider.getFullyQualifiedName(value))
			}
			
//			Variable: {
//				switch( ruleName ) {
//					case grammar.name + ".VariablePublic": {
//						value.visibility = VisibilityKind.PUBLIC
//					}
//					case grammar.name + ".VariableProtected": {
//						value.visibility = VisibilityKind.PROTECTED
//					}
//					case grammar.name + ".VariablePrivate": {
//						value.visibility = VisibilityKind.PRIVATE
//					}
//				}
//			}
//			Port: {
//				switch( ruleName ) {
//					case grammar.name + ".PortPublic": {
//						value.visibility = VisibilityKind.PUBLIC
//					}
//					case grammar.name + ".PortProtected": {
//						value.visibility = VisibilityKind.PROTECTED
//					}
//					case grammar.name + ".PortPrivate": {
//						value.visibility = VisibilityKind.PRIVATE
//					}
//				}
//			}
//			Signal: {
//				switch( ruleName ) {
//					case grammar.name + ".SignalPublic": {
//						value.visibility = VisibilityKind.PUBLIC
//					}
//					case grammar.name + ".SignalProtected": {
//						value.visibility = VisibilityKind.PROTECTED
//					}
//					case grammar.name + ".SignalPrivate": {
//						value.visibility = VisibilityKind.PRIVATE
//					}
//				}
//			}
//			Buffer: {
//				switch( ruleName ) {
//					case grammar.name + ".BufferPublic": {
//						value.visibility = VisibilityKind.PUBLIC
//					}
//					case grammar.name + ".BufferProtected": {
//						value.visibility = VisibilityKind.PROTECTED
//					}
//					case grammar.name + ".BufferPrivate": {
//						value.visibility = VisibilityKind.PRIVATE
//					}
//				}
//			}
//			Channel: {
//				switch( ruleName ) {
//					case grammar.name + ".ChannelPublic": {
//						value.visibility = VisibilityKind.PUBLIC
//					}
//					case grammar.name + ".ChannelProtected": {
//						value.visibility = VisibilityKind.PROTECTED
//					}
//					case grammar.name + ".ChannelPrivate": {
//						value.visibility = VisibilityKind.PRIVATE
//					}
//				}
//			}
//			DataType: {
//				switch( ruleName ) {
//					case grammar.name + ".DataTypePublic": {
//						value.visibility = VisibilityKind.PUBLIC
//					}
//					case grammar.name + ".DataTypeProtected": {
//						value.visibility = VisibilityKind.PROTECTED
//					}
//					case grammar.name + ".DataTypePrivate": {
//						value.visibility = VisibilityKind.PRIVATE
//					}
//				}
//			}
		}
	}

//	override public void set(EObject object,
//		String feature, Object value, String ruleName, INode node)
//				throws ValueConverterException {
////		println("ruleName: " + ruleName)
////		println("\tfeature: " + feature)
//
//		super.set(object, feature, value, ruleName, node);
//		
//		if( object instanceof Variable ) {
//			val ruleVariablePublic = grammar.name + ".VariablePublic";
//			if( ruleVariablePublic.equals(ruleName) ) {
//				print("VariablePublic-->setAttribute for Variable")
//				println(object.name)
//			}
//		}
//	}
}
