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
 *  - Initial API and Implementation
 */
package org.eclipse.efm.ecore.formalml.expression.util;

import org.eclipse.efm.ecore.formalml.common.AbstractElement;

import org.eclipse.efm.ecore.formalml.expression.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionPackage
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
			public Adapter caseValueExpressionPrettyPrinter(ValueExpressionPrettyPrinter object) {
				return createValueExpressionPrettyPrinterAdapter();
			}
			@Override
			public Adapter caseValuePrintableExpression(ValuePrintableExpression object) {
				return createValuePrintableExpressionAdapter();
			}
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter caseLiteralExpression(LiteralExpression object) {
				return createLiteralExpressionAdapter();
			}
			@Override
			public Adapter caseLiteralBooleanExpression(LiteralBooleanExpression object) {
				return createLiteralBooleanExpressionAdapter();
			}
			@Override
			public Adapter caseLiteralIntegerExpression(LiteralIntegerExpression object) {
				return createLiteralIntegerExpressionAdapter();
			}
			@Override
			public Adapter caseLiteralRationalExpression(LiteralRationalExpression object) {
				return createLiteralRationalExpressionAdapter();
			}
			@Override
			public Adapter caseLiteralFloatExpression(LiteralFloatExpression object) {
				return createLiteralFloatExpressionAdapter();
			}
			@Override
			public Adapter caseLiteralRealExpression(LiteralRealExpression object) {
				return createLiteralRealExpressionAdapter();
			}
			@Override
			public Adapter caseLiteralCharacterExpression(LiteralCharacterExpression object) {
				return createLiteralCharacterExpressionAdapter();
			}
			@Override
			public Adapter caseLiteralStringExpression(LiteralStringExpression object) {
				return createLiteralStringExpressionAdapter();
			}
			@Override
			public Adapter caseLiteralCollectionExpression(LiteralCollectionExpression object) {
				return createLiteralCollectionExpressionAdapter();
			}
			@Override
			public Adapter caseLiteralNullExpression(LiteralNullExpression object) {
				return createLiteralNullExpressionAdapter();
			}
			@Override
			public Adapter caseLiteralReferenceExpression(LiteralReferenceExpression object) {
				return createLiteralReferenceExpressionAdapter();
			}
			@Override
			public Adapter caseLiteralReferenceElement(LiteralReferenceElement object) {
				return createLiteralReferenceElementAdapter();
			}
			@Override
			public Adapter caseLiteralThisExpression(LiteralThisExpression object) {
				return createLiteralThisExpressionAdapter();
			}
			@Override
			public Adapter caseLiteralSelfExpression(LiteralSelfExpression object) {
				return createLiteralSelfExpressionAdapter();
			}
			@Override
			public Adapter caseLiteralParentExpression(LiteralParentExpression object) {
				return createLiteralParentExpressionAdapter();
			}
			@Override
			public Adapter caseLiteralSuperExpression(LiteralSuperExpression object) {
				return createLiteralSuperExpressionAdapter();
			}
			@Override
			public Adapter caseLiteralSystemExpression(LiteralSystemExpression object) {
				return createLiteralSystemExpressionAdapter();
			}
			@Override
			public Adapter caseLiteralEnvExpression(LiteralEnvExpression object) {
				return createLiteralEnvExpressionAdapter();
			}
			@Override
			public Adapter caseLiteralTimeExpression(LiteralTimeExpression object) {
				return createLiteralTimeExpressionAdapter();
			}
			@Override
			public Adapter caseLiteralTimeDeltaExpression(LiteralTimeDeltaExpression object) {
				return createLiteralTimeDeltaExpressionAdapter();
			}
			@Override
			public Adapter caseLeftHandSideExpression(LeftHandSideExpression object) {
				return createLeftHandSideExpressionAdapter();
			}
			@Override
			public Adapter caseIncrementOrDecrementExpression(IncrementOrDecrementExpression object) {
				return createIncrementOrDecrementExpressionAdapter();
			}
			@Override
			public Adapter caseIncrementOrDecrementPrefixExpression(IncrementOrDecrementPrefixExpression object) {
				return createIncrementOrDecrementPrefixExpressionAdapter();
			}
			@Override
			public Adapter caseIncrementOrDecrementPostfixExpression(IncrementOrDecrementPostfixExpression object) {
				return createIncrementOrDecrementPostfixExpressionAdapter();
			}
			@Override
			public Adapter caseAssignmentExpression(AssignmentExpression object) {
				return createAssignmentExpressionAdapter();
			}
			@Override
			public Adapter caseNewfreshExpression(NewfreshExpression object) {
				return createNewfreshExpressionAdapter();
			}
			@Override
			public Adapter caseUnaryExpression(UnaryExpression object) {
				return createUnaryExpressionAdapter();
			}
			@Override
			public Adapter caseBitwiseUnaryExpression(BitwiseUnaryExpression object) {
				return createBitwiseUnaryExpressionAdapter();
			}
			@Override
			public Adapter caseLogicalUnaryExpression(LogicalUnaryExpression object) {
				return createLogicalUnaryExpressionAdapter();
			}
			@Override
			public Adapter caseCastExpression(CastExpression object) {
				return createCastExpressionAdapter();
			}
			@Override
			public Adapter caseArithmeticUnaryExpression(ArithmeticUnaryExpression object) {
				return createArithmeticUnaryExpressionAdapter();
			}
			@Override
			public Adapter caseBinaryExpression(BinaryExpression object) {
				return createBinaryExpressionAdapter();
			}
			@Override
			public Adapter caseEqualityBinaryExpression(EqualityBinaryExpression object) {
				return createEqualityBinaryExpressionAdapter();
			}
			@Override
			public Adapter caseRelationalBinaryExpression(RelationalBinaryExpression object) {
				return createRelationalBinaryExpressionAdapter();
			}
			@Override
			public Adapter caseRelationalTernaryExpression(RelationalTernaryExpression object) {
				return createRelationalTernaryExpressionAdapter();
			}
			@Override
			public Adapter caseConditionalTestExpression(ConditionalTestExpression object) {
				return createConditionalTestExpressionAdapter();
			}
			@Override
			public Adapter caseAssociativeExpression(AssociativeExpression object) {
				return createAssociativeExpressionAdapter();
			}
			@Override
			public Adapter caseArithmeticAssociativeExpression(ArithmeticAssociativeExpression object) {
				return createArithmeticAssociativeExpressionAdapter();
			}
			@Override
			public Adapter caseBitwiseAssociativeExpression(BitwiseAssociativeExpression object) {
				return createBitwiseAssociativeExpressionAdapter();
			}
			@Override
			public Adapter caseLogicalAssociativeExpression(LogicalAssociativeExpression object) {
				return createLogicalAssociativeExpressionAdapter();
			}
			@Override
			public Adapter caseInvokeExpression(InvokeExpression object) {
				return createInvokeExpressionAdapter();
			}
			@Override
			public Adapter caseNamedExpression(NamedExpression object) {
				return createNamedExpressionAdapter();
			}
			@Override
			public Adapter caseTupleExpression(TupleExpression object) {
				return createTupleExpressionAdapter();
			}
			@Override
			public Adapter caseMixTupleExpression(MixTupleExpression object) {
				return createMixTupleExpressionAdapter();
			}
			@Override
			public Adapter caseNamedTupleExpression(NamedTupleExpression object) {
				return createNamedTupleExpressionAdapter();
			}
			@Override
			public Adapter casePositionalTupleExpression(PositionalTupleExpression object) {
				return createPositionalTupleExpressionAdapter();
			}
			@Override
			public Adapter caseValueElementSpecification(ValueElementSpecification object) {
				return createValueElementSpecificationAdapter();
			}
			@Override
			public Adapter caseInstantiationExpression(InstantiationExpression object) {
				return createInstantiationExpressionAdapter();
			}
			@Override
			public Adapter caseExpressionAsBuffer(ExpressionAsBuffer object) {
				return createExpressionAsBufferAdapter();
			}
			@Override
			public Adapter caseExpressionAsChannel(ExpressionAsChannel object) {
				return createExpressionAsChannelAdapter();
			}
			@Override
			public Adapter caseExpressionAsMachine(ExpressionAsMachine object) {
				return createExpressionAsMachineAdapter();
			}
			@Override
			public Adapter caseExpressionAsPort(ExpressionAsPort object) {
				return createExpressionAsPortAdapter();
			}
			@Override
			public Adapter caseAbstractElement(AbstractElement object) {
				return createAbstractElementAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.ValueExpressionPrettyPrinter <em>Value Expression Pretty Printer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValueExpressionPrettyPrinter
	 * @generated
	 */
	public Adapter createValueExpressionPrettyPrinterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.ValuePrintableExpression <em>Value Printable Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValuePrintableExpression
	 * @generated
	 */
	public Adapter createValuePrintableExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralExpression <em>Literal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralExpression
	 * @generated
	 */
	public Adapter createLiteralExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralBooleanExpression <em>Literal Boolean Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralBooleanExpression
	 * @generated
	 */
	public Adapter createLiteralBooleanExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralIntegerExpression <em>Literal Integer Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralIntegerExpression
	 * @generated
	 */
	public Adapter createLiteralIntegerExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralRationalExpression <em>Literal Rational Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralRationalExpression
	 * @generated
	 */
	public Adapter createLiteralRationalExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralFloatExpression <em>Literal Float Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralFloatExpression
	 * @generated
	 */
	public Adapter createLiteralFloatExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralRealExpression <em>Literal Real Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralRealExpression
	 * @generated
	 */
	public Adapter createLiteralRealExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralCharacterExpression <em>Literal Character Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralCharacterExpression
	 * @generated
	 */
	public Adapter createLiteralCharacterExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralStringExpression <em>Literal String Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralStringExpression
	 * @generated
	 */
	public Adapter createLiteralStringExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralCollectionExpression <em>Literal Collection Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralCollectionExpression
	 * @generated
	 */
	public Adapter createLiteralCollectionExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralNullExpression <em>Literal Null Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralNullExpression
	 * @generated
	 */
	public Adapter createLiteralNullExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceExpression <em>Literal Reference Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralReferenceExpression
	 * @generated
	 */
	public Adapter createLiteralReferenceExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement <em>Literal Reference Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralReferenceElement
	 * @generated
	 */
	public Adapter createLiteralReferenceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralThisExpression <em>Literal This Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralThisExpression
	 * @generated
	 */
	public Adapter createLiteralThisExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralSelfExpression <em>Literal Self Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralSelfExpression
	 * @generated
	 */
	public Adapter createLiteralSelfExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralParentExpression <em>Literal Parent Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralParentExpression
	 * @generated
	 */
	public Adapter createLiteralParentExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralSuperExpression <em>Literal Super Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralSuperExpression
	 * @generated
	 */
	public Adapter createLiteralSuperExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralSystemExpression <em>Literal System Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralSystemExpression
	 * @generated
	 */
	public Adapter createLiteralSystemExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralEnvExpression <em>Literal Env Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralEnvExpression
	 * @generated
	 */
	public Adapter createLiteralEnvExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralTimeExpression <em>Literal Time Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralTimeExpression
	 * @generated
	 */
	public Adapter createLiteralTimeExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LiteralTimeDeltaExpression <em>Literal Time Delta Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LiteralTimeDeltaExpression
	 * @generated
	 */
	public Adapter createLiteralTimeDeltaExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LeftHandSideExpression <em>Left Hand Side Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LeftHandSideExpression
	 * @generated
	 */
	public Adapter createLeftHandSideExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementExpression <em>Increment Or Decrement Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementExpression
	 * @generated
	 */
	public Adapter createIncrementOrDecrementExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementPrefixExpression <em>Increment Or Decrement Prefix Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementPrefixExpression
	 * @generated
	 */
	public Adapter createIncrementOrDecrementPrefixExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementPostfixExpression <em>Increment Or Decrement Postfix Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.IncrementOrDecrementPostfixExpression
	 * @generated
	 */
	public Adapter createIncrementOrDecrementPostfixExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.AssignmentExpression <em>Assignment Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.AssignmentExpression
	 * @generated
	 */
	public Adapter createAssignmentExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.NewfreshExpression <em>Newfresh Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.NewfreshExpression
	 * @generated
	 */
	public Adapter createNewfreshExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.UnaryExpression <em>Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.UnaryExpression
	 * @generated
	 */
	public Adapter createUnaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.BitwiseUnaryExpression <em>Bitwise Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.BitwiseUnaryExpression
	 * @generated
	 */
	public Adapter createBitwiseUnaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LogicalUnaryExpression <em>Logical Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LogicalUnaryExpression
	 * @generated
	 */
	public Adapter createLogicalUnaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.CastExpression <em>Cast Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.CastExpression
	 * @generated
	 */
	public Adapter createCastExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.ArithmeticUnaryExpression <em>Arithmetic Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.ArithmeticUnaryExpression
	 * @generated
	 */
	public Adapter createArithmeticUnaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.BinaryExpression <em>Binary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.BinaryExpression
	 * @generated
	 */
	public Adapter createBinaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.EqualityBinaryExpression <em>Equality Binary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.EqualityBinaryExpression
	 * @generated
	 */
	public Adapter createEqualityBinaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.RelationalBinaryExpression <em>Relational Binary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.RelationalBinaryExpression
	 * @generated
	 */
	public Adapter createRelationalBinaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression <em>Relational Ternary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.RelationalTernaryExpression
	 * @generated
	 */
	public Adapter createRelationalTernaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression <em>Conditional Test Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.ConditionalTestExpression
	 * @generated
	 */
	public Adapter createConditionalTestExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.AssociativeExpression <em>Associative Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.AssociativeExpression
	 * @generated
	 */
	public Adapter createAssociativeExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.ArithmeticAssociativeExpression <em>Arithmetic Associative Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.ArithmeticAssociativeExpression
	 * @generated
	 */
	public Adapter createArithmeticAssociativeExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.BitwiseAssociativeExpression <em>Bitwise Associative Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.BitwiseAssociativeExpression
	 * @generated
	 */
	public Adapter createBitwiseAssociativeExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.LogicalAssociativeExpression <em>Logical Associative Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.LogicalAssociativeExpression
	 * @generated
	 */
	public Adapter createLogicalAssociativeExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.InvokeExpression <em>Invoke Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.InvokeExpression
	 * @generated
	 */
	public Adapter createInvokeExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.NamedExpression <em>Named Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.NamedExpression
	 * @generated
	 */
	public Adapter createNamedExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.TupleExpression <em>Tuple Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.TupleExpression
	 * @generated
	 */
	public Adapter createTupleExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.MixTupleExpression <em>Mix Tuple Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.MixTupleExpression
	 * @generated
	 */
	public Adapter createMixTupleExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.NamedTupleExpression <em>Named Tuple Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.NamedTupleExpression
	 * @generated
	 */
	public Adapter createNamedTupleExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.PositionalTupleExpression <em>Positional Tuple Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.PositionalTupleExpression
	 * @generated
	 */
	public Adapter createPositionalTupleExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification <em>Value Element Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification
	 * @generated
	 */
	public Adapter createValueElementSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.InstantiationExpression <em>Instantiation Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.InstantiationExpression
	 * @generated
	 */
	public Adapter createInstantiationExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.ExpressionAsBuffer <em>As Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionAsBuffer
	 * @generated
	 */
	public Adapter createExpressionAsBufferAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.ExpressionAsChannel <em>As Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionAsChannel
	 * @generated
	 */
	public Adapter createExpressionAsChannelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.ExpressionAsMachine <em>As Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionAsMachine
	 * @generated
	 */
	public Adapter createExpressionAsMachineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.expression.ExpressionAsPort <em>As Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.expression.ExpressionAsPort
	 * @generated
	 */
	public Adapter createExpressionAsPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efm.ecore.formalml.common.AbstractElement <em>Abstract Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efm.ecore.formalml.common.AbstractElement
	 * @generated
	 */
	public Adapter createAbstractElementAdapter() {
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
