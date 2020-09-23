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
package org.eclipse.efm.ecore.formalml.infrastructure.impl;

import java.util.Collection;

import org.eclipse.efm.ecore.formalml.datatype.DataType;

import org.eclipse.efm.ecore.formalml.infrastructure.Buffer;
import org.eclipse.efm.ecore.formalml.infrastructure.Channel;
import org.eclipse.efm.ecore.formalml.infrastructure.Function;
import org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage;
import org.eclipse.efm.ecore.formalml.infrastructure.Parameter;
import org.eclipse.efm.ecore.formalml.infrastructure.Port;
import org.eclipse.efm.ecore.formalml.infrastructure.PropertyPart;
import org.eclipse.efm.ecore.formalml.infrastructure.Signal;
import org.eclipse.efm.ecore.formalml.infrastructure.Variable;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.PropertyPartImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.PropertyPartImpl#getTypedef <em>Typedef</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.PropertyPartImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.PropertyPartImpl#getChannel <em>Channel</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.PropertyPartImpl#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.PropertyPartImpl#getSignal <em>Signal</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.PropertyPartImpl#getBuffer <em>Buffer</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.PropertyPartImpl#getFunction <em>Function</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyPartImpl extends MinimalEObjectImpl.Container implements PropertyPart {
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
	 * The cached value of the '{@link #getTypedef() <em>Typedef</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedef()
	 * @generated
	 * @ordered
	 */
	protected EList<DataType> typedef;

	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> variable;

	/**
	 * The cached value of the '{@link #getChannel() <em>Channel</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannel()
	 * @generated
	 * @ordered
	 */
	protected EList<Channel> channel;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> port;

	/**
	 * The cached value of the '{@link #getSignal() <em>Signal</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignal()
	 * @generated
	 * @ordered
	 */
	protected EList<Signal> signal;

	/**
	 * The cached value of the '{@link #getBuffer() <em>Buffer</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuffer()
	 * @generated
	 * @ordered
	 */
	protected EList<Buffer> buffer;

	/**
	 * The cached value of the '{@link #getFunction() <em>Function</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunction()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> function;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InfrastructurePackage.Literals.PROPERTY_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Parameter> getParameter() {
		if (parameter == null) {
			parameter = new EObjectContainmentEList<Parameter>(Parameter.class, this, InfrastructurePackage.PROPERTY_PART__PARAMETER);
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataType> getTypedef() {
		if (typedef == null) {
			typedef = new EObjectContainmentEList<DataType>(DataType.class, this, InfrastructurePackage.PROPERTY_PART__TYPEDEF);
		}
		return typedef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Variable> getVariable() {
		if (variable == null) {
			variable = new EObjectContainmentEList<Variable>(Variable.class, this, InfrastructurePackage.PROPERTY_PART__VARIABLE);
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Channel> getChannel() {
		if (channel == null) {
			channel = new EObjectContainmentEList<Channel>(Channel.class, this, InfrastructurePackage.PROPERTY_PART__CHANNEL);
		}
		return channel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Port> getPort() {
		if (port == null) {
			port = new EObjectContainmentEList<Port>(Port.class, this, InfrastructurePackage.PROPERTY_PART__PORT);
		}
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Signal> getSignal() {
		if (signal == null) {
			signal = new EObjectContainmentEList<Signal>(Signal.class, this, InfrastructurePackage.PROPERTY_PART__SIGNAL);
		}
		return signal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Buffer> getBuffer() {
		if (buffer == null) {
			buffer = new EObjectContainmentEList<Buffer>(Buffer.class, this, InfrastructurePackage.PROPERTY_PART__BUFFER);
		}
		return buffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Function> getFunction() {
		if (function == null) {
			function = new EObjectContainmentEList<Function>(Function.class, this, InfrastructurePackage.PROPERTY_PART__FUNCTION);
		}
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InfrastructurePackage.PROPERTY_PART__PARAMETER:
				return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.PROPERTY_PART__TYPEDEF:
				return ((InternalEList<?>)getTypedef()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.PROPERTY_PART__VARIABLE:
				return ((InternalEList<?>)getVariable()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.PROPERTY_PART__CHANNEL:
				return ((InternalEList<?>)getChannel()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.PROPERTY_PART__PORT:
				return ((InternalEList<?>)getPort()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.PROPERTY_PART__SIGNAL:
				return ((InternalEList<?>)getSignal()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.PROPERTY_PART__BUFFER:
				return ((InternalEList<?>)getBuffer()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.PROPERTY_PART__FUNCTION:
				return ((InternalEList<?>)getFunction()).basicRemove(otherEnd, msgs);
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
			case InfrastructurePackage.PROPERTY_PART__PARAMETER:
				return getParameter();
			case InfrastructurePackage.PROPERTY_PART__TYPEDEF:
				return getTypedef();
			case InfrastructurePackage.PROPERTY_PART__VARIABLE:
				return getVariable();
			case InfrastructurePackage.PROPERTY_PART__CHANNEL:
				return getChannel();
			case InfrastructurePackage.PROPERTY_PART__PORT:
				return getPort();
			case InfrastructurePackage.PROPERTY_PART__SIGNAL:
				return getSignal();
			case InfrastructurePackage.PROPERTY_PART__BUFFER:
				return getBuffer();
			case InfrastructurePackage.PROPERTY_PART__FUNCTION:
				return getFunction();
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
			case InfrastructurePackage.PROPERTY_PART__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends Parameter>)newValue);
				return;
			case InfrastructurePackage.PROPERTY_PART__TYPEDEF:
				getTypedef().clear();
				getTypedef().addAll((Collection<? extends DataType>)newValue);
				return;
			case InfrastructurePackage.PROPERTY_PART__VARIABLE:
				getVariable().clear();
				getVariable().addAll((Collection<? extends Variable>)newValue);
				return;
			case InfrastructurePackage.PROPERTY_PART__CHANNEL:
				getChannel().clear();
				getChannel().addAll((Collection<? extends Channel>)newValue);
				return;
			case InfrastructurePackage.PROPERTY_PART__PORT:
				getPort().clear();
				getPort().addAll((Collection<? extends Port>)newValue);
				return;
			case InfrastructurePackage.PROPERTY_PART__SIGNAL:
				getSignal().clear();
				getSignal().addAll((Collection<? extends Signal>)newValue);
				return;
			case InfrastructurePackage.PROPERTY_PART__BUFFER:
				getBuffer().clear();
				getBuffer().addAll((Collection<? extends Buffer>)newValue);
				return;
			case InfrastructurePackage.PROPERTY_PART__FUNCTION:
				getFunction().clear();
				getFunction().addAll((Collection<? extends Function>)newValue);
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
			case InfrastructurePackage.PROPERTY_PART__PARAMETER:
				getParameter().clear();
				return;
			case InfrastructurePackage.PROPERTY_PART__TYPEDEF:
				getTypedef().clear();
				return;
			case InfrastructurePackage.PROPERTY_PART__VARIABLE:
				getVariable().clear();
				return;
			case InfrastructurePackage.PROPERTY_PART__CHANNEL:
				getChannel().clear();
				return;
			case InfrastructurePackage.PROPERTY_PART__PORT:
				getPort().clear();
				return;
			case InfrastructurePackage.PROPERTY_PART__SIGNAL:
				getSignal().clear();
				return;
			case InfrastructurePackage.PROPERTY_PART__BUFFER:
				getBuffer().clear();
				return;
			case InfrastructurePackage.PROPERTY_PART__FUNCTION:
				getFunction().clear();
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
			case InfrastructurePackage.PROPERTY_PART__PARAMETER:
				return parameter != null && !parameter.isEmpty();
			case InfrastructurePackage.PROPERTY_PART__TYPEDEF:
				return typedef != null && !typedef.isEmpty();
			case InfrastructurePackage.PROPERTY_PART__VARIABLE:
				return variable != null && !variable.isEmpty();
			case InfrastructurePackage.PROPERTY_PART__CHANNEL:
				return channel != null && !channel.isEmpty();
			case InfrastructurePackage.PROPERTY_PART__PORT:
				return port != null && !port.isEmpty();
			case InfrastructurePackage.PROPERTY_PART__SIGNAL:
				return signal != null && !signal.isEmpty();
			case InfrastructurePackage.PROPERTY_PART__BUFFER:
				return buffer != null && !buffer.isEmpty();
			case InfrastructurePackage.PROPERTY_PART__FUNCTION:
				return function != null && !function.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PropertyPartImpl
