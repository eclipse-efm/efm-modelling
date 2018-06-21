/*******************************************************************************
 * Copyright (c) 2017 CEA LIST
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Imen BOUDHIBA (CEA LIST) imen.boudhiba@cea.fr - initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.modeling.codegen.xlia.datatype;

import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;

public class DataTypeFactory {

	///////////////////////////////////////////////////////////////////////////
	// TYPE
	///////////////////////////////////////////////////////////////////////////

	private static Type intType = null;
	public static Type integerType() {
		if( intType == null ) {
			intType = UMLFactory.eINSTANCE.createPrimitiveType();
			intType.setName("int");
		}

		return( intType );
	}

	private static Type boolType = null;
	public static Type booleanType() {
		if( boolType == null ) {
			boolType = UMLFactory.eINSTANCE.createPrimitiveType();
			boolType.setName("bool");
		}

		return( boolType );
	}

	private static Type stringType = null;
	public static Type stringType() {
		if( stringType == null ) {
			stringType = UMLFactory.eINSTANCE.createPrimitiveType();
			stringType.setName("string");
		}

		return( stringType );
	}


	private static Type fifoIntType = null;
	public static Type fifoIntType() {
		if( fifoIntType == null ) {
			fifoIntType = UMLFactory.eINSTANCE.createPrimitiveType();
			fifoIntType.setName("fifo<integer , *>");
		}

		return( fifoIntType );
	}

	public static Type fifoIntType(int size) {
		Type fifoIntType = UMLFactory.eINSTANCE.createPrimitiveType();
		fifoIntType.setName("fifo<integer , " + size + " >");

		return( fifoIntType );
	}


	public static Type fifoType(String typeName){//, int size) {
		Type fifoIntType = UMLFactory.eINSTANCE.createPrimitiveType();
		fifoIntType.setName("fifo<"+typeName + " >");
		//fifoIntType.setName("fifo<"+typeName + ", " + ((size > 0)? size : "*") + " >");

		return( fifoIntType );
	}

}
