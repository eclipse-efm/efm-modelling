/**
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
 */
package org.eclipse.efm.ecore.formalml.expression.impl;

import java.util.Collection;

import org.eclipse.efm.ecore.formalml.expression.ExpressionPackage;
import org.eclipse.efm.ecore.formalml.expression.LiteralReferenceExpression;
import org.eclipse.efm.ecore.formalml.expression.LiteralReferenceSpecification;
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationScheme;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Literal Reference Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralReferenceSpecificationImpl#getExpected <em>Expected</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralReferenceSpecificationImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.LiteralReferenceSpecificationImpl#getElement <em>Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LiteralReferenceSpecificationImpl extends ExpressionImpl implements LiteralReferenceSpecification {
	/**
	 * The default value of the '{@link #getExpected() <em>Expected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpected()
	 * @generated
	 * @ordered
	 */
	protected static final ValueElementSpecificationScheme EXPECTED_EDEFAULT = ValueElementSpecificationScheme.ANY;

	/**
	 * The cached value of the '{@link #getExpected() <em>Expected</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpected()
	 * @generated
	 * @ordered
	 */
	protected ValueElementSpecificationScheme expected = EXPECTED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected EList<LiteralReferenceExpression> parent;

	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected LiteralReferenceExpression element;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LiteralReferenceSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.LITERAL_REFERENCE_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValueElementSpecificationScheme getExpected() {
		return expected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExpected(ValueElementSpecificationScheme newExpected) {
		ValueElementSpecificationScheme oldExpected = expected;
		expected = newExpected == null ? EXPECTED_EDEFAULT : newExpected;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.LITERAL_REFERENCE_SPECIFICATION__EXPECTED, oldExpected, expected));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<LiteralReferenceExpression> getParent() {
		if (parent == null) {
			parent = new EObjectContainmentEList<LiteralReferenceExpression>(LiteralReferenceExpression.class, this, ExpressionPackage.LITERAL_REFERENCE_SPECIFICATION__PARENT);
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LiteralReferenceExpression getElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElement(LiteralReferenceExpression newElement, NotificationChain msgs) {
		LiteralReferenceExpression oldElement = element;
		element = newElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.LITERAL_REFERENCE_SPECIFICATION__ELEMENT, oldElement, newElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElement(LiteralReferenceExpression newElement) {
		if (newElement != element) {
			NotificationChain msgs = null;
			if (element != null)
				msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.LITERAL_REFERENCE_SPECIFICATION__ELEMENT, null, msgs);
			if (newElement != null)
				msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.LITERAL_REFERENCE_SPECIFICATION__ELEMENT, null, msgs);
			msgs = basicSetElement(newElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.LITERAL_REFERENCE_SPECIFICATION__ELEMENT, newElement, newElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionPackage.LITERAL_REFERENCE_SPECIFICATION__PARENT:
				return ((InternalEList<?>)getParent()).basicRemove(otherEnd, msgs);
			case ExpressionPackage.LITERAL_REFERENCE_SPECIFICATION__ELEMENT:
				return basicSetElement(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionPackage.LITERAL_REFERENCE_SPECIFICATION__EXPECTED:
				return getExpected();
			case ExpressionPackage.LITERAL_REFERENCE_SPECIFICATION__PARENT:
				return getParent();
			case ExpressionPackage.LITERAL_REFERENCE_SPECIFICATION__ELEMENT:
				return getElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExpressionPackage.LITERAL_REFERENCE_SPECIFICATION__EXPECTED:
				setExpected((ValueElementSpecificationScheme)newValue);
				return;
			case ExpressionPackage.LITERAL_REFERENCE_SPECIFICATION__PARENT:
				getParent().clear();
				getParent().addAll((Collection<? extends LiteralReferenceExpression>)newValue);
				return;
			case ExpressionPackage.LITERAL_REFERENCE_SPECIFICATION__ELEMENT:
				setElement((LiteralReferenceExpression)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExpressionPackage.LITERAL_REFERENCE_SPECIFICATION__EXPECTED:
				setExpected(EXPECTED_EDEFAULT);
				return;
			case ExpressionPackage.LITERAL_REFERENCE_SPECIFICATION__PARENT:
				getParent().clear();
				return;
			case ExpressionPackage.LITERAL_REFERENCE_SPECIFICATION__ELEMENT:
				setElement((LiteralReferenceExpression)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExpressionPackage.LITERAL_REFERENCE_SPECIFICATION__EXPECTED:
				return expected != EXPECTED_EDEFAULT;
			case ExpressionPackage.LITERAL_REFERENCE_SPECIFICATION__PARENT:
				return parent != null && !parent.isEmpty();
			case ExpressionPackage.LITERAL_REFERENCE_SPECIFICATION__ELEMENT:
				return element != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (expected: ");
		result.append(expected);
		result.append(')');
		return result.toString();
	}

} //LiteralReferenceSpecificationImpl
