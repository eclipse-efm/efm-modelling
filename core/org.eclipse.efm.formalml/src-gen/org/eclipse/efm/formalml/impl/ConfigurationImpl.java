/**
 * Copyright (c) 2016 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 */
package org.eclipse.efm.formalml.impl;

import java.util.Collection;

import org.eclipse.efm.formalml.Configuration;
import org.eclipse.efm.formalml.formalmlPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.formalml.impl.ConfigurationImpl#getEnv <em>Env</em>}</li>
 *   <li>{@link org.eclipse.efm.formalml.impl.ConfigurationImpl#isTimed <em>Timed</em>}</li>
 *   <li>{@link org.eclipse.efm.formalml.impl.ConfigurationImpl#isInputEnabled <em>Input Enabled</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConfigurationImpl extends FormalBlockImpl implements Configuration {
	/**
	 * The cached value of the '{@link #getEnv() <em>Env</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnv()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> env;

	/**
	 * The default value of the '{@link #isTimed() <em>Timed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTimed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TIMED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTimed() <em>Timed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTimed()
	 * @generated
	 * @ordered
	 */
	protected boolean timed = TIMED_EDEFAULT;

	/**
	 * The default value of the '{@link #isInputEnabled() <em>Input Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInputEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INPUT_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInputEnabled() <em>Input Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInputEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean inputEnabled = INPUT_ENABLED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return formalmlPackage.Literals.CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getEnv() {
		if (env == null) {
			env = new EObjectResolvingEList<Property>(Property.class, this, formalmlPackage.CONFIGURATION__ENV);
		}
		return env;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getEnv(String name, Type type) {
		return getEnv(name, type, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getEnv(String name, Type type, boolean ignoreCase, EClass eClass) {
		envLoop: for (Property env : getEnv()) {
			if (eClass != null && !eClass.isInstance(env))
				continue envLoop;
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(env.getName()) : name.equals(env.getName())))
				continue envLoop;
			if (type != null && !type.equals(env.getType()))
				continue envLoop;
			return env;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTimed() {
		return timed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimed(boolean newTimed) {
		boolean oldTimed = timed;
		timed = newTimed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, formalmlPackage.CONFIGURATION__TIMED, oldTimed, timed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInputEnabled() {
		return inputEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputEnabled(boolean newInputEnabled) {
		boolean oldInputEnabled = inputEnabled;
		inputEnabled = newInputEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, formalmlPackage.CONFIGURATION__INPUT_ENABLED, oldInputEnabled, inputEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case formalmlPackage.CONFIGURATION__ENV:
				return getEnv();
			case formalmlPackage.CONFIGURATION__TIMED:
				return isTimed();
			case formalmlPackage.CONFIGURATION__INPUT_ENABLED:
				return isInputEnabled();
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
			case formalmlPackage.CONFIGURATION__ENV:
				getEnv().clear();
				getEnv().addAll((Collection<? extends Property>)newValue);
				return;
			case formalmlPackage.CONFIGURATION__TIMED:
				setTimed((Boolean)newValue);
				return;
			case formalmlPackage.CONFIGURATION__INPUT_ENABLED:
				setInputEnabled((Boolean)newValue);
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
			case formalmlPackage.CONFIGURATION__ENV:
				getEnv().clear();
				return;
			case formalmlPackage.CONFIGURATION__TIMED:
				setTimed(TIMED_EDEFAULT);
				return;
			case formalmlPackage.CONFIGURATION__INPUT_ENABLED:
				setInputEnabled(INPUT_ENABLED_EDEFAULT);
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
			case formalmlPackage.CONFIGURATION__ENV:
				return env != null && !env.isEmpty();
			case formalmlPackage.CONFIGURATION__TIMED:
				return timed != TIMED_EDEFAULT;
			case formalmlPackage.CONFIGURATION__INPUT_ENABLED:
				return inputEnabled != INPUT_ENABLED_EDEFAULT;
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
		result.append(" (timed: ");
		result.append(timed);
		result.append(", inputEnabled: ");
		result.append(inputEnabled);
		result.append(')');
		return result.toString();
	}

} //ConfigurationImpl
