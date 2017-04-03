/**
 * Copyright (c) 2017 CEA LIST.
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
package org.eclipse.efm.modeling.formalml.impl;

import java.util.Collection;

import org.eclipse.efm.modeling.formalml.FormalMLPackage;
import org.eclipse.efm.modeling.formalml.Part;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.modeling.formalml.impl.PartImpl#getBaseProperty <em>Base Property</em>}</li>
 *   <li>{@link org.eclipse.efm.modeling.formalml.impl.PartImpl#getInstance <em>Instance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PartImpl extends MinimalEObjectImpl.Container implements Part {
	/**
	 * The cached value of the '{@link #getBaseProperty() <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseProperty()
	 * @generated
	 * @ordered
	 */
	protected Property baseProperty;

	/**
	 * The cached value of the '{@link #getInstance() <em>Instance</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstance()
	 * @generated
	 * @ordered
	 */
	protected EList<InstanceSpecification> instance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FormalMLPackage.Literals.PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getBaseProperty() {
		if (baseProperty != null && baseProperty.eIsProxy()) {
			InternalEObject oldBaseProperty = (InternalEObject)baseProperty;
			baseProperty = (Property)eResolveProxy(oldBaseProperty);
			if (baseProperty != oldBaseProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormalMLPackage.PART__BASE_PROPERTY, oldBaseProperty, baseProperty));
			}
		}
		return baseProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetBaseProperty() {
		return baseProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseProperty(Property newBaseProperty) {
		Property oldBaseProperty = baseProperty;
		baseProperty = newBaseProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, FormalMLPackage.PART__BASE_PROPERTY, oldBaseProperty, baseProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InstanceSpecification> getInstance() {
		if (instance == null) {
			instance = new EObjectResolvingEList<InstanceSpecification>(InstanceSpecification.class, this, FormalMLPackage.PART__INSTANCE);
		}
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceSpecification getInstance(String name) {
		return getInstance(name, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceSpecification getInstance(String name, boolean ignoreCase, EClass eClass) {
		instanceLoop: for (InstanceSpecification instance : getInstance()) {
			if (eClass != null && !eClass.isInstance(instance))
				continue instanceLoop;
			if (name != null && !(ignoreCase ? name.equalsIgnoreCase(instance.getName()) : name.equals(instance.getName())))
				continue instanceLoop;
			return instance;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FormalMLPackage.PART__BASE_PROPERTY:
				if (resolve) return getBaseProperty();
				return basicGetBaseProperty();
			case FormalMLPackage.PART__INSTANCE:
				return getInstance();
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
			case FormalMLPackage.PART__BASE_PROPERTY:
				setBaseProperty((Property)newValue);
				return;
			case FormalMLPackage.PART__INSTANCE:
				getInstance().clear();
				getInstance().addAll((Collection<? extends InstanceSpecification>)newValue);
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
			case FormalMLPackage.PART__BASE_PROPERTY:
				setBaseProperty((Property)null);
				return;
			case FormalMLPackage.PART__INSTANCE:
				getInstance().clear();
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
			case FormalMLPackage.PART__BASE_PROPERTY:
				return baseProperty != null;
			case FormalMLPackage.PART__INSTANCE:
				return instance != null && !instance.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PartImpl
