/**
 * Copyright (c) 2017 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Boutheina Bannour (CEA LIST) boutheina.bannour@cea.fr
 *  - Initial API and Implementation
 */
package org.eclipse.efm.modeling.formalml.impl;

import java.util.Collection;

import org.eclipse.efm.modeling.formalml.Configuration;
import org.eclipse.efm.modeling.formalml.FormalMLPackage;

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
 *   <li>{@link org.eclipse.efm.modeling.formalml.impl.ConfigurationImpl#getEnvironment <em>Environment</em>}</li>
 *   <li>{@link org.eclipse.efm.modeling.formalml.impl.ConfigurationImpl#isTimed <em>Is Timed</em>}</li>
 *   <li>{@link org.eclipse.efm.modeling.formalml.impl.ConfigurationImpl#isInputEnabled <em>Is Input Enabled</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConfigurationImpl extends FormalBlockImpl implements Configuration {
	/**
	 * The cached value of the '{@link #getEnvironment() <em>Environment</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnvironment()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> environment;

	/**
	 * The default value of the '{@link #isTimed() <em>Is Timed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTimed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TIMED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTimed() <em>Is Timed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTimed()
	 * @generated
	 * @ordered
	 */
	protected boolean isTimed = IS_TIMED_EDEFAULT;

	/**
	 * The default value of the '{@link #isInputEnabled() <em>Is Input Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInputEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_INPUT_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInputEnabled() <em>Is Input Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInputEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean isInputEnabled = IS_INPUT_ENABLED_EDEFAULT;

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
		return FormalMLPackage.Literals.CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getEnvironment() {
		if (environment == null) {
			environment = new EObjectResolvingEList<Property>(Property.class, this, FormalMLPackage.CONFIGURATION__ENVIRONMENT);
		}
		return environment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getEnvironment(String name, Type type) {
		return getEnvironment(name, type, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getEnvironment(String name, Type type, boolean ignoreCase, EClass eClass) {
		environmentLoop: for (Property environment : getEnvironment()) {
			if (eClass != null && !eClass.isInstance(environment))
				continue environmentLoop;
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(environment.getName()) : name.equals(environment.getName())))
				continue environmentLoop;
			if (type != null && !type.equals(environment.getType()))
				continue environmentLoop;
			return environment;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTimed() {
		return isTimed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsTimed(boolean newIsTimed) {
		boolean oldIsTimed = isTimed;
		isTimed = newIsTimed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FormalMLPackage.CONFIGURATION__IS_TIMED, oldIsTimed, isTimed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInputEnabled() {
		return isInputEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsInputEnabled(boolean newIsInputEnabled) {
		boolean oldIsInputEnabled = isInputEnabled;
		isInputEnabled = newIsInputEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FormalMLPackage.CONFIGURATION__IS_INPUT_ENABLED, oldIsInputEnabled, isInputEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FormalMLPackage.CONFIGURATION__ENVIRONMENT:
				return getEnvironment();
			case FormalMLPackage.CONFIGURATION__IS_TIMED:
				return isTimed();
			case FormalMLPackage.CONFIGURATION__IS_INPUT_ENABLED:
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
			case FormalMLPackage.CONFIGURATION__ENVIRONMENT:
				getEnvironment().clear();
				getEnvironment().addAll((Collection<? extends Property>)newValue);
				return;
			case FormalMLPackage.CONFIGURATION__IS_TIMED:
				setIsTimed((Boolean)newValue);
				return;
			case FormalMLPackage.CONFIGURATION__IS_INPUT_ENABLED:
				setIsInputEnabled((Boolean)newValue);
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
			case FormalMLPackage.CONFIGURATION__ENVIRONMENT:
				getEnvironment().clear();
				return;
			case FormalMLPackage.CONFIGURATION__IS_TIMED:
				setIsTimed(IS_TIMED_EDEFAULT);
				return;
			case FormalMLPackage.CONFIGURATION__IS_INPUT_ENABLED:
				setIsInputEnabled(IS_INPUT_ENABLED_EDEFAULT);
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
			case FormalMLPackage.CONFIGURATION__ENVIRONMENT:
				return environment != null && !environment.isEmpty();
			case FormalMLPackage.CONFIGURATION__IS_TIMED:
				return isTimed != IS_TIMED_EDEFAULT;
			case FormalMLPackage.CONFIGURATION__IS_INPUT_ENABLED:
				return isInputEnabled != IS_INPUT_ENABLED_EDEFAULT;
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
		result.append(" (isTimed: ");
		result.append(isTimed);
		result.append(", isInputEnabled: ");
		result.append(isInputEnabled);
		result.append(')');
		return result.toString();
	}

} //ConfigurationImpl
