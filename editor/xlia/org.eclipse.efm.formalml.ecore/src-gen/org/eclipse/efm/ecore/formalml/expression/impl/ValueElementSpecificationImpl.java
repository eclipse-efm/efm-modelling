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
package org.eclipse.efm.ecore.formalml.expression.impl;

import org.eclipse.efm.ecore.formalml.common.NamedElement;

import org.eclipse.efm.ecore.formalml.expression.Expression;
import org.eclipse.efm.ecore.formalml.expression.ExpressionPackage;
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecification;
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationKind;
import org.eclipse.efm.ecore.formalml.expression.ValueElementSpecificationScheme;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Element Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.ValueElementSpecificationImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.ValueElementSpecificationImpl#getExpected <em>Expected</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.ValueElementSpecificationImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.ValueElementSpecificationImpl#getElement <em>Element</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.expression.impl.ValueElementSpecificationImpl#getArg <em>Arg</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValueElementSpecificationImpl extends ExpressionImpl implements ValueElementSpecification {
	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final ValueElementSpecificationKind KIND_EDEFAULT = ValueElementSpecificationKind.FIELD;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected ValueElementSpecificationKind kind = KIND_EDEFAULT;

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
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Expression target;

	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected NamedElement element;

	/**
	 * The cached value of the '{@link #getArg() <em>Arg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArg()
	 * @generated
	 * @ordered
	 */
	protected Expression arg;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValueElementSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.VALUE_ELEMENT_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueElementSpecificationKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(ValueElementSpecificationKind newKind) {
		ValueElementSpecificationKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueElementSpecificationScheme getExpected() {
		return expected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpected(ValueElementSpecificationScheme newExpected) {
		ValueElementSpecificationScheme oldExpected = expected;
		expected = newExpected == null ? EXPECTED_EDEFAULT : newExpected;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__EXPECTED, oldExpected, expected));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(Expression newTarget, NotificationChain msgs) {
		Expression oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Expression newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement getElement() {
		if (element != null && element.eIsProxy()) {
			InternalEObject oldElement = (InternalEObject)element;
			element = (NamedElement)eResolveProxy(oldElement);
			if (element != oldElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__ELEMENT, oldElement, element));
			}
		}
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement basicGetElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(NamedElement newElement) {
		NamedElement oldElement = element;
		element = newElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__ELEMENT, oldElement, element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getArg() {
		return arg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArg(Expression newArg, NotificationChain msgs) {
		Expression oldArg = arg;
		arg = newArg;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__ARG, oldArg, newArg);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArg(Expression newArg) {
		if (newArg != arg) {
			NotificationChain msgs = null;
			if (arg != null)
				msgs = ((InternalEObject)arg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__ARG, null, msgs);
			if (newArg != null)
				msgs = ((InternalEObject)newArg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__ARG, null, msgs);
			msgs = basicSetArg(newArg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__ARG, newArg, newArg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__TARGET:
				return basicSetTarget(null, msgs);
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__ARG:
				return basicSetArg(null, msgs);
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
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__KIND:
				return getKind();
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__EXPECTED:
				return getExpected();
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__TARGET:
				return getTarget();
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__ELEMENT:
				if (resolve) return getElement();
				return basicGetElement();
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__ARG:
				return getArg();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__KIND:
				setKind((ValueElementSpecificationKind)newValue);
				return;
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__EXPECTED:
				setExpected((ValueElementSpecificationScheme)newValue);
				return;
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__TARGET:
				setTarget((Expression)newValue);
				return;
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__ELEMENT:
				setElement((NamedElement)newValue);
				return;
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__ARG:
				setArg((Expression)newValue);
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
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__EXPECTED:
				setExpected(EXPECTED_EDEFAULT);
				return;
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__TARGET:
				setTarget((Expression)null);
				return;
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__ELEMENT:
				setElement((NamedElement)null);
				return;
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__ARG:
				setArg((Expression)null);
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
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__KIND:
				return kind != KIND_EDEFAULT;
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__EXPECTED:
				return expected != EXPECTED_EDEFAULT;
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__TARGET:
				return target != null;
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__ELEMENT:
				return element != null;
			case ExpressionPackage.VALUE_ELEMENT_SPECIFICATION__ARG:
				return arg != null;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (kind: ");
		result.append(kind);
		result.append(", expected: ");
		result.append(expected);
		result.append(')');
		return result.toString();
	}

} //ValueElementSpecificationImpl
