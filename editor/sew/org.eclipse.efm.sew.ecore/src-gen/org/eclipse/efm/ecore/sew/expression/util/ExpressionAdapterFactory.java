/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *   - Initial API and Implementation
 */
package org.eclipse.efm.ecore.sew.expression.util;

import org.eclipse.efm.ecore.sew.WValueSpecification;

import org.eclipse.efm.ecore.sew.expression.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.ecore.sew.expression.ExpressionPackage
 * @generated
 */
public class ExpressionAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExpressionPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ExpressionPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionSwitch<Adapter> modelSwitch =
		new ExpressionSwitch<Adapter>() {
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter caseLiteralExpressionValue(LiteralExpressionValue object) {
				return createLiteralExpressionValueAdapter();
			}
			@Override
			public Adapter caseLiteralArrayValue(LiteralArrayValue object) {
				return createLiteralArrayValueAdapter();
			}
			@Override
			public Adapter caseLiteralIntegerValue(LiteralIntegerValue object) {
				return createLiteralIntegerValueAdapter();
			}
			@Override
			public Adapter caseLiteralBooleanValue(LiteralBooleanValue object) {
				return createLiteralBooleanValueAdapter();
			}
			@Override
			public Adapter caseLiteralCharacterValue(LiteralCharacterValue object) {
				return createLiteralCharacterValueAdapter();
			}
			@Override
			public Adapter caseLiteralRationalValue(LiteralRationalValue object) {
				return createLiteralRationalValueAdapter();
			}
			@Override
			public Adapter caseLiteralStringValue(LiteralStringValue object) {
				return createLiteralStringValueAdapter();
			}
			@Override
			public Adapter caseLiteralNullValue(LiteralNullValue object) {
				return createLiteralNullValueAdapter();
			}
			@Override
			public Adapter caseLiteralFloatValue(LiteralFloatValue object) {
				return createLiteralFloatValueAdapter();
			}
			@Override
			public Adapter caseLiteralRealValue(LiteralRealValue object) {
				return createLiteralRealValueAdapter();
			}
			@Override
			public Adapter caseLiteralReferenceValue(LiteralReferenceValue object) {
				return createLiteralReferenceValueAdapter();
			}
			@Override
			public Adapter caseLiteralObjectReference(LiteralObjectReference object) {
				return createLiteralObjectReferenceAdapter();
			}
			@Override
			public Adapter caseLiteralThisInstance(LiteralThisInstance object) {
				return createLiteralThisInstanceAdapter();
			}
			@Override
			public Adapter caseLiteralSelfInstance(LiteralSelfInstance object) {
				return createLiteralSelfInstanceAdapter();
			}
			@Override
			public Adapter caseLiteralParentInstance(LiteralParentInstance object) {
				return createLiteralParentInstanceAdapter();
			}
			@Override
			public Adapter caseLiteralSuperInstance(LiteralSuperInstance object) {
				return createLiteralSuperInstanceAdapter();
			}
			@Override
			public Adapter caseLiteralSystemInstance(LiteralSystemInstance object) {
				return createLiteralSystemInstanceAdapter();
			}
			@Override
			public Adapter caseLiteralEnvInstance(LiteralEnvInstance object) {
				return createLiteralEnvInstanceAdapter();
			}
			@Override
			public Adapter caseLiteralTimeVariable(LiteralTimeVariable object) {
				return createLiteralTimeVariableAdapter();
			}
			@Override
			public Adapter caseLiteralTimeDeltaVariable(LiteralTimeDeltaVariable object) {
				return createLiteralTimeDeltaVariableAdapter();
			}
			@Override
			public Adapter caseWValueSpecification(WValueSpecification object) {
				return createWValueSpecificationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.expression.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.expression.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.expression.LiteralExpressionValue <em>Literal Expression Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralExpressionValue
	 * @generated
	 */
	public Adapter createLiteralExpressionValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.expression.LiteralArrayValue <em>Literal Array Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralArrayValue
	 * @generated
	 */
	public Adapter createLiteralArrayValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.expression.LiteralIntegerValue <em>Literal Integer Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralIntegerValue
	 * @generated
	 */
	public Adapter createLiteralIntegerValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.expression.LiteralBooleanValue <em>Literal Boolean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralBooleanValue
	 * @generated
	 */
	public Adapter createLiteralBooleanValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.expression.LiteralCharacterValue <em>Literal Character Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralCharacterValue
	 * @generated
	 */
	public Adapter createLiteralCharacterValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.expression.LiteralRationalValue <em>Literal Rational Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralRationalValue
	 * @generated
	 */
	public Adapter createLiteralRationalValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.expression.LiteralStringValue <em>Literal String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralStringValue
	 * @generated
	 */
	public Adapter createLiteralStringValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.expression.LiteralNullValue <em>Literal Null Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralNullValue
	 * @generated
	 */
	public Adapter createLiteralNullValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.expression.LiteralFloatValue <em>Literal Float Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralFloatValue
	 * @generated
	 */
	public Adapter createLiteralFloatValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.expression.LiteralRealValue <em>Literal Real Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralRealValue
	 * @generated
	 */
	public Adapter createLiteralRealValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.expression.LiteralReferenceValue <em>Literal Reference Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralReferenceValue
	 * @generated
	 */
	public Adapter createLiteralReferenceValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.expression.LiteralObjectReference <em>Literal Object Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralObjectReference
	 * @generated
	 */
	public Adapter createLiteralObjectReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.expression.LiteralThisInstance <em>Literal This Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralThisInstance
	 * @generated
	 */
	public Adapter createLiteralThisInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.expression.LiteralSelfInstance <em>Literal Self Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralSelfInstance
	 * @generated
	 */
	public Adapter createLiteralSelfInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.expression.LiteralParentInstance <em>Literal Parent Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralParentInstance
	 * @generated
	 */
	public Adapter createLiteralParentInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.expression.LiteralSuperInstance <em>Literal Super Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralSuperInstance
	 * @generated
	 */
	public Adapter createLiteralSuperInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.expression.LiteralSystemInstance <em>Literal System Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralSystemInstance
	 * @generated
	 */
	public Adapter createLiteralSystemInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.expression.LiteralEnvInstance <em>Literal Env Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralEnvInstance
	 * @generated
	 */
	public Adapter createLiteralEnvInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.expression.LiteralTimeVariable <em>Literal Time Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralTimeVariable
	 * @generated
	 */
	public Adapter createLiteralTimeVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.expression.LiteralTimeDeltaVariable <em>Literal Time Delta Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.expression.LiteralTimeDeltaVariable
	 * @generated
	 */
	public Adapter createLiteralTimeDeltaVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.sew.WValueSpecification <em>WValue Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.sew.WValueSpecification
	 * @generated
	 */
	public Adapter createWValueSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ExpressionAdapterFactory
