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
package org.eclipse.efm.core.workflow.common.impl;

import org.eclipse.efm.core.workflow.common.CommonPackage;
import org.eclipse.efm.core.workflow.common.Manifest;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Manifest</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.core.workflow.common.impl.ManifestImpl#isAutoconf <em>Autoconf</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.common.impl.ManifestImpl#isAutostart <em>Autostart</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ManifestImpl extends MinimalEObjectImpl.Container implements Manifest {
	/**
	 * The default value of the '{@link #isAutoconf() <em>Autoconf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutoconf()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTOCONF_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAutoconf() <em>Autoconf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutoconf()
	 * @generated
	 * @ordered
	 */
	protected boolean autoconf = AUTOCONF_EDEFAULT;

	/**
	 * The default value of the '{@link #isAutostart() <em>Autostart</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutostart()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTOSTART_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAutostart() <em>Autostart</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutostart()
	 * @generated
	 * @ordered
	 */
	protected boolean autostart = AUTOSTART_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ManifestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CommonPackage.Literals.MANIFEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAutoconf() {
		return autoconf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoconf(boolean newAutoconf) {
		boolean oldAutoconf = autoconf;
		autoconf = newAutoconf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.MANIFEST__AUTOCONF, oldAutoconf, autoconf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAutostart() {
		return autostart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutostart(boolean newAutostart) {
		boolean oldAutostart = autostart;
		autostart = newAutostart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.MANIFEST__AUTOSTART, oldAutostart, autostart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CommonPackage.MANIFEST__AUTOCONF:
				return isAutoconf();
			case CommonPackage.MANIFEST__AUTOSTART:
				return isAutostart();
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
			case CommonPackage.MANIFEST__AUTOCONF:
				setAutoconf((Boolean)newValue);
				return;
			case CommonPackage.MANIFEST__AUTOSTART:
				setAutostart((Boolean)newValue);
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
			case CommonPackage.MANIFEST__AUTOCONF:
				setAutoconf(AUTOCONF_EDEFAULT);
				return;
			case CommonPackage.MANIFEST__AUTOSTART:
				setAutostart(AUTOSTART_EDEFAULT);
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
			case CommonPackage.MANIFEST__AUTOCONF:
				return autoconf != AUTOCONF_EDEFAULT;
			case CommonPackage.MANIFEST__AUTOSTART:
				return autostart != AUTOSTART_EDEFAULT;
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
		result.append(" (autoconf: ");
		result.append(autoconf);
		result.append(", autostart: ");
		result.append(autostart);
		result.append(')');
		return result.toString();
	}

} //ManifestImpl
