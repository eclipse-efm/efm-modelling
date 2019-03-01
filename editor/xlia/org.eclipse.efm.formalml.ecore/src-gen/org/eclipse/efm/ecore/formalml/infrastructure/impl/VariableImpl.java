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
package org.eclipse.efm.ecore.formalml.infrastructure.impl;

import org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage;
import org.eclipse.efm.ecore.formalml.infrastructure.Routine;
import org.eclipse.efm.ecore.formalml.infrastructure.Variable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.VariableImpl#isConst <em>Const</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.VariableImpl#isReference <em>Reference</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.VariableImpl#isMacro <em>Macro</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.VariableImpl#getOnWriteAction <em>On Write Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableImpl extends PropertyDefinitionImpl implements Variable {
	/**
	 * The default value of the '{@link #isConst() <em>Const</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConst()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONST_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConst() <em>Const</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isConst()
	 * @generated
	 * @ordered
	 */
	protected boolean const_ = CONST_EDEFAULT;

	/**
	 * The default value of the '{@link #isReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReference()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REFERENCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReference()
	 * @generated
	 * @ordered
	 */
	protected boolean reference = REFERENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #isMacro() <em>Macro</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMacro()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MACRO_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMacro() <em>Macro</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMacro()
	 * @generated
	 * @ordered
	 */
	protected boolean macro = MACRO_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOnWriteAction() <em>On Write Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnWriteAction()
	 * @generated
	 * @ordered
	 */
	protected Routine onWriteAction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InfrastructurePackage.Literals.VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isConst() {
		return const_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConst(boolean newConst) {
		boolean oldConst = const_;
		const_ = newConst;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.VARIABLE__CONST, oldConst, const_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReference(boolean newReference) {
		boolean oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.VARIABLE__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isMacro() {
		return macro;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMacro(boolean newMacro) {
		boolean oldMacro = macro;
		macro = newMacro;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.VARIABLE__MACRO, oldMacro, macro));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Routine getOnWriteAction() {
		return onWriteAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnWriteAction(Routine newOnWriteAction, NotificationChain msgs) {
		Routine oldOnWriteAction = onWriteAction;
		onWriteAction = newOnWriteAction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.VARIABLE__ON_WRITE_ACTION, oldOnWriteAction, newOnWriteAction);
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
	public void setOnWriteAction(Routine newOnWriteAction) {
		if (newOnWriteAction != onWriteAction) {
			NotificationChain msgs = null;
			if (onWriteAction != null)
				msgs = ((InternalEObject)onWriteAction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.VARIABLE__ON_WRITE_ACTION, null, msgs);
			if (newOnWriteAction != null)
				msgs = ((InternalEObject)newOnWriteAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.VARIABLE__ON_WRITE_ACTION, null, msgs);
			msgs = basicSetOnWriteAction(newOnWriteAction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.VARIABLE__ON_WRITE_ACTION, newOnWriteAction, newOnWriteAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InfrastructurePackage.VARIABLE__ON_WRITE_ACTION:
				return basicSetOnWriteAction(null, msgs);
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
			case InfrastructurePackage.VARIABLE__CONST:
				return isConst();
			case InfrastructurePackage.VARIABLE__REFERENCE:
				return isReference();
			case InfrastructurePackage.VARIABLE__MACRO:
				return isMacro();
			case InfrastructurePackage.VARIABLE__ON_WRITE_ACTION:
				return getOnWriteAction();
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
			case InfrastructurePackage.VARIABLE__CONST:
				setConst((Boolean)newValue);
				return;
			case InfrastructurePackage.VARIABLE__REFERENCE:
				setReference((Boolean)newValue);
				return;
			case InfrastructurePackage.VARIABLE__MACRO:
				setMacro((Boolean)newValue);
				return;
			case InfrastructurePackage.VARIABLE__ON_WRITE_ACTION:
				setOnWriteAction((Routine)newValue);
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
			case InfrastructurePackage.VARIABLE__CONST:
				setConst(CONST_EDEFAULT);
				return;
			case InfrastructurePackage.VARIABLE__REFERENCE:
				setReference(REFERENCE_EDEFAULT);
				return;
			case InfrastructurePackage.VARIABLE__MACRO:
				setMacro(MACRO_EDEFAULT);
				return;
			case InfrastructurePackage.VARIABLE__ON_WRITE_ACTION:
				setOnWriteAction((Routine)null);
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
			case InfrastructurePackage.VARIABLE__CONST:
				return const_ != CONST_EDEFAULT;
			case InfrastructurePackage.VARIABLE__REFERENCE:
				return reference != REFERENCE_EDEFAULT;
			case InfrastructurePackage.VARIABLE__MACRO:
				return macro != MACRO_EDEFAULT;
			case InfrastructurePackage.VARIABLE__ON_WRITE_ACTION:
				return onWriteAction != null;
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
		result.append(" (const: ");
		result.append(const_);
		result.append(", reference: ");
		result.append(reference);
		result.append(", macro: ");
		result.append(macro);
		result.append(')');
		return result.toString();
	}

} //VariableImpl
