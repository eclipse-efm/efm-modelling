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
package org.eclipse.efm.sew.xtext.ui.outline

import org.eclipse.efm.ecore.sew.WAttribute
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider

/**
 * Customization of the default outline structure.
 *
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#outline
 */
class SEWOutlineTreeProvider extends DefaultOutlineTreeProvider {

	def _isLeaf(WAttribute attribute) {
		true
		
//		val valueSpec = attribute.value
//		switch( valueSpec ) {
//			LiteralArrayValue: {
//				false
//			}
//			
//			Expression: {
//				(valueSpec.operand.size == 0)
//				|| (((valueSpec.operator == "-") || (valueSpec.operator == "+"))
//					&& (valueSpec.operand.size == 1)
//					&& (valueSpec.operand.get(0) instanceof LiteralExpressionValue)
//					)
//			}
//			
//			default: {
//				true
//			}
//		}
	}

}
