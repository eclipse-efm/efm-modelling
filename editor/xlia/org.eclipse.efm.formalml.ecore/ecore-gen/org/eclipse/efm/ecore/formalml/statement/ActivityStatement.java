/**
 * Copyright (c) 2020 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html\n\nContributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *  - Initial API and Implementation
 */
package org.eclipse.efm.ecore.formalml.statement;

import org.eclipse.efm.ecore.formalml.expression.Expression;
import org.eclipse.efm.ecore.formalml.expression.TupleExpression;
import org.eclipse.efm.ecore.formalml.infrastructure.SlotProperty;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.ActivityStatement#getOp <em>Op</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.ActivityStatement#getMachine <em>Machine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.ActivityStatement#getTuple <em>Tuple</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.statement.ActivityStatement#getSlot <em>Slot</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getActivityStatement()
 * @model
 * @generated
 */
public interface ActivityStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Op</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.efm.ecore.formalml.statement.ActivityStatementKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Op</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.statement.ActivityStatementKind
	 * @see #setOp(ActivityStatementKind)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getActivityStatement_Op()
	 * @model required="true"
	 * @generated
	 */
	ActivityStatementKind getOp();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.ActivityStatement#getOp <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.statement.ActivityStatementKind
	 * @see #getOp()
	 * @generated
	 */
	void setOp(ActivityStatementKind value);

	/**
	 * Returns the value of the '<em><b>Machine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine</em>' containment reference.
	 * @see #setMachine(Expression)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getActivityStatement_Machine()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getMachine();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.ActivityStatement#getMachine <em>Machine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Machine</em>' containment reference.
	 * @see #getMachine()
	 * @generated
	 */
	void setMachine(Expression value);

	/**
	 * Returns the value of the '<em><b>Tuple</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tuple</em>' containment reference.
	 * @see #setTuple(TupleExpression)
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getActivityStatement_Tuple()
	 * @model containment="true"
	 * @generated
	 */
	TupleExpression getTuple();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.statement.ActivityStatement#getTuple <em>Tuple</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tuple</em>' containment reference.
	 * @see #getTuple()
	 * @generated
	 */
	void setTuple(TupleExpression value);

	/**
	 * Returns the value of the '<em><b>Slot</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.SlotProperty}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slot</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.statement.StatementPackage#getActivityStatement_Slot()
	 * @model containment="true"
	 * @generated
	 */
	EList<SlotProperty> getSlot();

} // ActivityStatement
