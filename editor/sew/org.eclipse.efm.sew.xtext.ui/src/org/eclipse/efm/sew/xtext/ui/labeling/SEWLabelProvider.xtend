/*****************************************************************************
* Copyright (c) 2012 CEA LIST.
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
package org.eclipse.efm.sew.xtext.ui.labeling

import com.google.inject.Inject
import org.eclipse.efm.ecore.sew.SEWorkflow
import org.eclipse.efm.ecore.sew.WAttribute
import org.eclipse.efm.ecore.sew.WObject
import org.eclipse.efm.ecore.sew.WSection
import org.eclipse.efm.ecore.sew.expression.Expression
import org.eclipse.efm.ecore.sew.expression.LiteralArrayValue
import org.eclipse.efm.ecore.sew.expression.LiteralBooleanValue
import org.eclipse.efm.ecore.sew.expression.LiteralCharacterValue
import org.eclipse.efm.ecore.sew.expression.LiteralFloatValue
import org.eclipse.efm.ecore.sew.expression.LiteralIntegerValue
import org.eclipse.efm.ecore.sew.expression.LiteralNullValue
import org.eclipse.efm.ecore.sew.expression.LiteralRationalValue
import org.eclipse.efm.ecore.sew.expression.LiteralRealValue
import org.eclipse.efm.ecore.sew.expression.LiteralReferenceValue
import org.eclipse.efm.ecore.sew.expression.LiteralStringValue
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider
import org.eclipse.jface.viewers.StyledString
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider
import org.eclipse.efm.ecore.sew.expression.LiteralObjectReference

/**
 * Provides labels for EObjects.
 *
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 */
class SEWLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	// Labels and icons can be computed like this:

//	def text(Greeting ele) {
//		'A greeting to ' + ele.name
//	}
//
//	def image(Greeting ele) {
//		'Greeting.gif'
//	}


	def text(SEWorkflow workflow) {
		val str = new StyledString("SymbEx-Workflow")

		if( (workflow.type != null)
			&& (! workflow.type.toLowerCase().contains("workflow"))
			&& (workflow.type != "SEW") ) {
			str.append( new StyledString( " <" + workflow.type + ">",
				StyledString::DECORATIONS_STYLER ) )
		}

		if( workflow.name != null  ) {
			str.append( new StyledString( " " + workflow.name,
				StyledString::DECORATIONS_STYLER ) )
		}
		else if( workflow.description != null  ) {
			str.append( new StyledString( " " + workflow.description,
				StyledString::DECORATIONS_STYLER ) )
		}

		str
	}

	def image(SEWorkflow workflow) {
		"Folder.gif"
	}

	def text(WObject object) {
		val str = new StyledString()

		if( object.type != null  ) {
			str.append( new StyledString( " <" + object.type + ">" ) )
		}

		if( object.name != null  ) {
			str.append( new StyledString( " " + object.name,
				StyledString::DECORATIONS_STYLER ) )
		}
		else if( object.description != null  ) {
			str.append( new StyledString( " " + object.description,
				StyledString::DECORATIONS_STYLER ) )
		}
		else if( str.length == 0 ) {
			str.append( "WObject##untyped#unamed" );
		}
		
		str
	}

	def image(WObject object) {
		"Class.gif"
	}


	def text(WSection section) {
		if( section.name != null ) {
			if( section.name.startsWith("@") ) {
				section.name.substring(1)
			}
			else {
				section.name
			}
		}
		else {
			"WSection#unamed"
		}
	}

	def image(WSection section) {
		"stack.gif"
	}


	def text(WAttribute attribute) {
		val str = new StyledString()
		
		if( attribute.name != null ) {
			if( attribute.name.startsWith("@") ) {
				str.append( attribute.name.substring(1) )
			}
			else {
				str.append( attribute.name )
			}
		}
		else {
			str.append( "WAttribute#unamed" )
		}
		
		val valueSpec = attribute.value
		switch( valueSpec ) {
			LiteralIntegerValue: {
				str.append( new StyledString( " : " + valueSpec.value,
					StyledString::DECORATIONS_STYLER ) )
			}
			LiteralRationalValue: {
				str.append( new StyledString( " : " +
					valueSpec.numerator + "/" + valueSpec.denominator,
					StyledString::DECORATIONS_STYLER ) )
			}
			
			LiteralFloatValue: {
				str.append( new StyledString( " : " + valueSpec.value,
					StyledString::DECORATIONS_STYLER ) )
			}
			LiteralRealValue: {
				str.append( new StyledString( " : " + valueSpec.value,
					StyledString::DECORATIONS_STYLER ) )
			}
			
			LiteralCharacterValue: {
				str.append( new StyledString( " : '" + valueSpec.value + "'",
					StyledString::DECORATIONS_STYLER ) )
			}
			LiteralStringValue: {
				val printValue = valueSpec.value.replaceAll("\\R", "\\\\n")
				str.append( new StyledString( " : \"" + printValue + "\"",
					StyledString::DECORATIONS_STYLER ) )
			}
			
			LiteralObjectReference: {
				val objID =
					if( valueSpec.object.name != null ) { 
						valueSpec.object.name
					}
					else if( valueSpec.object.type != null ) {
						valueSpec.object.type
					}
					else {
						"<null>"
					}
					
				str.append( new StyledString( " : &" + objID,
					StyledString::DECORATIONS_STYLER ) )
			}
			
			LiteralReferenceValue: {
				str.append( new StyledString( " : " + valueSpec.symbol,
					StyledString::DECORATIONS_STYLER ) )
			}
			LiteralNullValue: {
				str.append( new StyledString( " : null<" + valueSpec.type + ">",
					StyledString::DECORATIONS_STYLER ) )
			}
			

			LiteralArrayValue: {
				str.append( new StyledString( " [ " +
					(if( valueSpec.values.size > 0 ) "... ]" else "]"),
					StyledString::DECORATIONS_STYLER ) )
			}
			
			Expression: {
				if( ((valueSpec.operator == "-") || (valueSpec.operator == "+"))
					&& (valueSpec.operand.size == 1) ){
						
					val operand = valueSpec.operand.get(0)
					switch( operand ) {
						LiteralIntegerValue: {
							str.append( new StyledString( " : " +
								valueSpec.operator + operand.value,
								StyledString::DECORATIONS_STYLER ) )
						}
						LiteralRationalValue: {
							str.append( new StyledString( " : " +
								valueSpec.operator +
								operand.numerator + "/" + operand.denominator,
								StyledString::DECORATIONS_STYLER ) )
						}
						
						LiteralFloatValue: {
							str.append( new StyledString( " : " +
								valueSpec.operator + operand.value,
								StyledString::DECORATIONS_STYLER ) )
						}
						LiteralRealValue: {
							str.append( new StyledString( " : " +
								valueSpec.operator + operand.value,
								StyledString::DECORATIONS_STYLER ) )
						}
												
						default: {
							//!! NOTHING
						}
					}
				}
				else {
					str.append( new StyledString( " : { " +
						valueSpec.operator +
						(if( valueSpec.operand.size > 0 ) " ..." else " }"),
						StyledString::DECORATIONS_STYLER ) )
					
				}
			}
			
			default: {
				//!! NOTHING
			}
		}
		
		str
	}

	def image(WAttribute attribute) {
		switch( attribute.value ) {
			LiteralBooleanValue: {
//				"LiteralBoolean.gif"
				if( ( attribute.value as LiteralBooleanValue ).value ) {
					"True.gif"
				}
				else {
					"False.gif"
				}
			}
			
			LiteralIntegerValue: {
				"LiteralInteger.gif"
			}
			LiteralRationalValue: {
				"LiteralInteger.gif"
			}
			
			LiteralFloatValue: {
				"LiteralReal.gif"
			}
			LiteralRealValue: {
				"LiteralReal.gif"
			}
			
			LiteralCharacterValue: {
				"LiteralString.gif"
			}
			LiteralStringValue: {
				"LiteralString.gif"
			}
			
			LiteralArrayValue: {
				"Constraint.gif"
			}
			
			LiteralReferenceValue: {
				"EnumerationLiteral.gif"
			}

			LiteralNullValue: {
				"Class.gif"
			}

			default: {
				"Expression.gif"
			}
		}
	}

}
