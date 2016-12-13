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
package org.eclipse.efm.ecore.formalml.infrastructure.impl;

import java.util.Collection;

import org.eclipse.efm.ecore.formalml.common.impl.NamedElementImpl;

import org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage;
import org.eclipse.efm.ecore.formalml.infrastructure.Parameter;
import org.eclipse.efm.ecore.formalml.infrastructure.ParameterSet;
import org.eclipse.efm.ecore.formalml.infrastructure.Routine;

import org.eclipse.efm.ecore.formalml.statement.BlockStatement;

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
 * An implementation of the model object '<em><b>Routine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.RoutineImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.RoutineImpl#getBodyBlock <em>Body Block</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.RoutineImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.RoutineImpl#getCodomain <em>Codomain</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RoutineImpl extends NamedElementImpl implements Routine {
	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameter;

	/**
	 * The cached value of the '{@link #getBodyBlock() <em>Body Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyBlock()
	 * @generated
	 * @ordered
	 */
	protected BlockStatement bodyBlock;

	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected ParameterSet domain;

	/**
	 * The cached value of the '{@link #getCodomain() <em>Codomain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCodomain()
	 * @generated
	 * @ordered
	 */
	protected ParameterSet codomain;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoutineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InfrastructurePackage.Literals.ROUTINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameter() {
		if (parameter == null) {
			parameter = new EObjectContainmentEList<Parameter>(Parameter.class, this, InfrastructurePackage.ROUTINE__PARAMETER);
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockStatement getBodyBlock() {
		return bodyBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBodyBlock(BlockStatement newBodyBlock, NotificationChain msgs) {
		BlockStatement oldBodyBlock = bodyBlock;
		bodyBlock = newBodyBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.ROUTINE__BODY_BLOCK, oldBodyBlock, newBodyBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyBlock(BlockStatement newBodyBlock) {
		if (newBodyBlock != bodyBlock) {
			NotificationChain msgs = null;
			if (bodyBlock != null)
				msgs = ((InternalEObject)bodyBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.ROUTINE__BODY_BLOCK, null, msgs);
			if (newBodyBlock != null)
				msgs = ((InternalEObject)newBodyBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.ROUTINE__BODY_BLOCK, null, msgs);
			msgs = basicSetBodyBlock(newBodyBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.ROUTINE__BODY_BLOCK, newBodyBlock, newBodyBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterSet getDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDomain(ParameterSet newDomain, NotificationChain msgs) {
		ParameterSet oldDomain = domain;
		domain = newDomain;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.ROUTINE__DOMAIN, oldDomain, newDomain);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomain(ParameterSet newDomain) {
		if (newDomain != domain) {
			NotificationChain msgs = null;
			if (domain != null)
				msgs = ((InternalEObject)domain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.ROUTINE__DOMAIN, null, msgs);
			if (newDomain != null)
				msgs = ((InternalEObject)newDomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.ROUTINE__DOMAIN, null, msgs);
			msgs = basicSetDomain(newDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.ROUTINE__DOMAIN, newDomain, newDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterSet getCodomain() {
		return codomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCodomain(ParameterSet newCodomain, NotificationChain msgs) {
		ParameterSet oldCodomain = codomain;
		codomain = newCodomain;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.ROUTINE__CODOMAIN, oldCodomain, newCodomain);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCodomain(ParameterSet newCodomain) {
		if (newCodomain != codomain) {
			NotificationChain msgs = null;
			if (codomain != null)
				msgs = ((InternalEObject)codomain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.ROUTINE__CODOMAIN, null, msgs);
			if (newCodomain != null)
				msgs = ((InternalEObject)newCodomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.ROUTINE__CODOMAIN, null, msgs);
			msgs = basicSetCodomain(newCodomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.ROUTINE__CODOMAIN, newCodomain, newCodomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InfrastructurePackage.ROUTINE__PARAMETER:
				return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.ROUTINE__BODY_BLOCK:
				return basicSetBodyBlock(null, msgs);
			case InfrastructurePackage.ROUTINE__DOMAIN:
				return basicSetDomain(null, msgs);
			case InfrastructurePackage.ROUTINE__CODOMAIN:
				return basicSetCodomain(null, msgs);
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
			case InfrastructurePackage.ROUTINE__PARAMETER:
				return getParameter();
			case InfrastructurePackage.ROUTINE__BODY_BLOCK:
				return getBodyBlock();
			case InfrastructurePackage.ROUTINE__DOMAIN:
				return getDomain();
			case InfrastructurePackage.ROUTINE__CODOMAIN:
				return getCodomain();
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
			case InfrastructurePackage.ROUTINE__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends Parameter>)newValue);
				return;
			case InfrastructurePackage.ROUTINE__BODY_BLOCK:
				setBodyBlock((BlockStatement)newValue);
				return;
			case InfrastructurePackage.ROUTINE__DOMAIN:
				setDomain((ParameterSet)newValue);
				return;
			case InfrastructurePackage.ROUTINE__CODOMAIN:
				setCodomain((ParameterSet)newValue);
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
			case InfrastructurePackage.ROUTINE__PARAMETER:
				getParameter().clear();
				return;
			case InfrastructurePackage.ROUTINE__BODY_BLOCK:
				setBodyBlock((BlockStatement)null);
				return;
			case InfrastructurePackage.ROUTINE__DOMAIN:
				setDomain((ParameterSet)null);
				return;
			case InfrastructurePackage.ROUTINE__CODOMAIN:
				setCodomain((ParameterSet)null);
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
			case InfrastructurePackage.ROUTINE__PARAMETER:
				return parameter != null && !parameter.isEmpty();
			case InfrastructurePackage.ROUTINE__BODY_BLOCK:
				return bodyBlock != null;
			case InfrastructurePackage.ROUTINE__DOMAIN:
				return domain != null;
			case InfrastructurePackage.ROUTINE__CODOMAIN:
				return codomain != null;
		}
		return super.eIsSet(featureID);
	}

} //RoutineImpl
