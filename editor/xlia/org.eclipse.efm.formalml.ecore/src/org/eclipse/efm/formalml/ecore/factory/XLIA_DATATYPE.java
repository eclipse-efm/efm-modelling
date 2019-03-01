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
package org.eclipse.efm.formalml.ecore.factory;

import org.eclipse.efm.ecore.formalml.datatype.CollectionKind;
import org.eclipse.efm.ecore.formalml.datatype.CollectionType;
import org.eclipse.efm.ecore.formalml.datatype.DataType;
import org.eclipse.efm.ecore.formalml.datatype.DataTypeReference;
import org.eclipse.efm.ecore.formalml.datatype.DatatypeFactory;
import org.eclipse.efm.ecore.formalml.datatype.EnumerationLiteral;
import org.eclipse.efm.ecore.formalml.datatype.EnumerationType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveBooleanType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceKind;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveInstanceType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveIntegerType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveRationalType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveStringType;
import org.eclipse.efm.ecore.formalml.datatype.PrimitiveType;
import org.eclipse.efm.ecore.formalml.infrastructure.Machine;

public class XLIA_DATATYPE {

	// DatatypeFactory FACTORY
	static DatatypeFactory FACTORY = DatatypeFactory.eINSTANCE;


	// PRIMITIVE
	public static PrimitiveBooleanType createBoolean() {
		return FACTORY.createPrimitiveBooleanType();
	}

	public static PrimitiveBooleanType createBoolean(final int size) {
		final PrimitiveBooleanType booleanArray = FACTORY.createPrimitiveBooleanType();

		booleanArray.setMultiplicity(XLIA_EXPRESSION.createInteger(size));

		return booleanArray;
	}

	public static PrimitiveIntegerType createInterger() {
		return FACTORY.createPrimitiveIntegerType();
	}

	public static PrimitiveRationalType createRational() {
		return FACTORY.createPrimitiveRationalType();
	}

	public static PrimitiveStringType createString() {
		return FACTORY.createPrimitiveStringType();
	}

	public static PrimitiveType createRationalOrInteger(final boolean isRational) {
		return( isRational ? createRational() : createInterger() );
	}


	// PRIMITIVE
	public static PrimitiveInstanceType createInstance(
			final PrimitiveInstanceKind instanceKind) {
		final PrimitiveInstanceType type = FACTORY.createPrimitiveInstanceType();
		type.setExpected(instanceKind);

		return type;
	}


	public static PrimitiveInstanceType createInstanceChannel() {
		return createInstance(PrimitiveInstanceKind.CHANNEL);
	}

	public static PrimitiveInstanceType createInstanceMachine() {
		return createInstance(PrimitiveInstanceKind.MACHINE);
	}

	public static PrimitiveInstanceType createInstancePort() {
		return createInstance(PrimitiveInstanceKind.PORT);
	}



	// COLLECTION
	public static CollectionType createCollection(
			final CollectionKind kind, final DataType dataType, final int size) {
		final CollectionType collection = FACTORY.createCollectionType();

		collection.setContainer( kind );

		collection.setSupport(dataType);

		collection.setSize( size );
		collection.setUnbounded( size < 0 );

		return collection;
	}

	public static CollectionType createCollection(
			final CollectionKind kind, final int size) {
		return createCollection(kind, null, size);
	}

	public static CollectionType createCollectionFifo(final int size) {
		return createCollection(CollectionKind.FIFO, size);
	}

	public static CollectionType createCollectionList(
			final DataType dataType, final int size) {
		return createCollection(CollectionKind.LIST, dataType, size);
	}

	public static CollectionType createCollectionSet(
			final DataType dataType, final int size) {
		return createCollection(CollectionKind.SET, dataType, size);
	}

	public static CollectionType createCollectionVector(
			final DataType dataType, final int size) {
		return createCollection(CollectionKind.VECTOR, dataType, size);
	}


	// ENUMERATION LITERAL
	public static EnumerationLiteral createEnumLiteral(final String literal) {
		final EnumerationLiteral enumLiteral = FACTORY.createEnumerationLiteral();

		enumLiteral.setName(literal);

		return enumLiteral;
	}

	public static EnumerationLiteral getEnumLiteral(
			final EnumerationType enumType, final String literal) {
		for( final EnumerationLiteral enumLiteral : enumType.getLiteral() ) {
			if( enumLiteral.getName().equals(literal) ) {
				return enumLiteral;
			}
		}

		return null;
	}

	// ENUMERATION
	public static EnumerationType createEnum(
			final String name, final String[] enumLiterals) {
		final EnumerationType enumType = FACTORY.createEnumerationType();

		enumType.setName(name);

		for (final String literal : enumLiterals) {
			enumType.getLiteral().add( createEnumLiteral(literal) );
		}

		return enumType;
	}

	public static EnumerationType addEnum(final Machine container,
			final String name, final String[] enumLiterals) {
		final EnumerationType enumType = createEnum(name, enumLiterals);

		container.getTypedef().add(enumType);

		return enumType;
	}

	public static void addEnumLiterals(
			final EnumerationType enumType, final String[] enumLiterals) {
		boolean isNotExist;
		for (final String literal : enumLiterals) {
			isNotExist = true;
			for( final EnumerationLiteral enumTypeLiteral : enumType.getLiteral() ) {
				if( enumTypeLiteral.getName().equals(literal) ) {
					isNotExist = false;
					break;
				}
			}

			if( isNotExist ) {
				enumType.getLiteral().add( createEnumLiteral(literal) );
			}
		}
	}


	// DATA TYPE REFERENCE
	public static DataTypeReference createReference(final DataType dataType) {
		final DataTypeReference reference = FACTORY.createDataTypeReference();

		reference.setTyperef(dataType);

		return reference;
	}

}
