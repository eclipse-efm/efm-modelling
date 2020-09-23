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

import org.eclipse.efm.ecore.formalml.common.impl.ClassifierDefinitionImpl;

import org.eclipse.efm.ecore.formalml.datatype.DataType;

import org.eclipse.efm.ecore.formalml.infrastructure.Behavior;
import org.eclipse.efm.ecore.formalml.infrastructure.Buffer;
import org.eclipse.efm.ecore.formalml.infrastructure.Channel;
import org.eclipse.efm.ecore.formalml.infrastructure.DesignKind;
import org.eclipse.efm.ecore.formalml.infrastructure.Function;
import org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage;
import org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine;
import org.eclipse.efm.ecore.formalml.infrastructure.Machine;
import org.eclipse.efm.ecore.formalml.infrastructure.Port;
import org.eclipse.efm.ecore.formalml.infrastructure.Procedure;
import org.eclipse.efm.ecore.formalml.infrastructure.Routine;
import org.eclipse.efm.ecore.formalml.infrastructure.Signal;
import org.eclipse.efm.ecore.formalml.infrastructure.Variable;

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
 * An implementation of the model object '<em><b>Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl#isInput_enabled <em>Input enabled</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl#isTimed <em>Timed</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl#isDense_timed <em>Dense timed</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl#isDiscrete_timed <em>Discrete timed</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl#isUnsafe <em>Unsafe</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl#getDesign <em>Design</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl#isLifeline <em>Lifeline</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl#getTypedef <em>Typedef</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl#getChannel <em>Channel</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl#getSignal <em>Signal</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl#getBuffer <em>Buffer</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl#getRoutine <em>Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl#getProcedure <em>Procedure</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl#getMachine <em>Machine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl#getInstance <em>Instance</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.impl.MachineImpl#getMain <em>Main</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MachineImpl extends ClassifierDefinitionImpl implements Machine {
	/**
	 * The default value of the '{@link #isInput_enabled() <em>Input enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInput_enabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INPUT_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInput_enabled() <em>Input enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInput_enabled()
	 * @generated
	 * @ordered
	 */
	protected boolean input_enabled = INPUT_ENABLED_EDEFAULT;

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
	 * The default value of the '{@link #isDense_timed() <em>Dense timed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDense_timed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DENSE_TIMED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDense_timed() <em>Dense timed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDense_timed()
	 * @generated
	 * @ordered
	 */
	protected boolean dense_timed = DENSE_TIMED_EDEFAULT;

	/**
	 * The default value of the '{@link #isDiscrete_timed() <em>Discrete timed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDiscrete_timed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISCRETE_TIMED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDiscrete_timed() <em>Discrete timed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDiscrete_timed()
	 * @generated
	 * @ordered
	 */
	protected boolean discrete_timed = DISCRETE_TIMED_EDEFAULT;

	/**
	 * The default value of the '{@link #isUnsafe() <em>Unsafe</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnsafe()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UNSAFE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUnsafe() <em>Unsafe</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnsafe()
	 * @generated
	 * @ordered
	 */
	protected boolean unsafe = UNSAFE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDesign() <em>Design</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesign()
	 * @generated
	 * @ordered
	 */
	protected static final DesignKind DESIGN_EDEFAULT = DesignKind.PROTOTYPE;

	/**
	 * The cached value of the '{@link #getDesign() <em>Design</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesign()
	 * @generated
	 * @ordered
	 */
	protected DesignKind design = DESIGN_EDEFAULT;

	/**
	 * The default value of the '{@link #isLifeline() <em>Lifeline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLifeline()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LIFELINE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLifeline() <em>Lifeline</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLifeline()
	 * @generated
	 * @ordered
	 */
	protected boolean lifeline = LIFELINE_EDEFAULT;

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
	 * The cached value of the '{@link #getRoutine() <em>Routine</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutine()
	 * @generated
	 * @ordered
	 */
	protected EList<Routine> routine;

	/**
	 * The cached value of the '{@link #getProcedure() <em>Procedure</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcedure()
	 * @generated
	 * @ordered
	 */
	protected EList<Procedure> procedure;

	/**
	 * The cached value of the '{@link #getMachine() <em>Machine</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachine()
	 * @generated
	 * @ordered
	 */
	protected EList<Machine> machine;

	/**
	 * The cached value of the '{@link #getInstance() <em>Instance</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstance()
	 * @generated
	 * @ordered
	 */
	protected EList<InstanceMachine> instance;

	/**
	 * The cached value of the '{@link #getBehavior() <em>Behavior</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavior()
	 * @generated
	 * @ordered
	 */
	protected EList<Behavior> behavior;

	/**
	 * The cached value of the '{@link #getMain() <em>Main</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMain()
	 * @generated
	 * @ordered
	 */
	protected Behavior main;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MachineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InfrastructurePackage.Literals.MACHINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isInput_enabled() {
		return input_enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInput_enabled(boolean newInput_enabled) {
		boolean oldInput_enabled = input_enabled;
		input_enabled = newInput_enabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MACHINE__INPUT_ENABLED, oldInput_enabled, input_enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isTimed() {
		return timed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimed(boolean newTimed) {
		boolean oldTimed = timed;
		timed = newTimed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MACHINE__TIMED, oldTimed, timed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDense_timed() {
		return dense_timed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDense_timed(boolean newDense_timed) {
		boolean oldDense_timed = dense_timed;
		dense_timed = newDense_timed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MACHINE__DENSE_TIMED, oldDense_timed, dense_timed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDiscrete_timed() {
		return discrete_timed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDiscrete_timed(boolean newDiscrete_timed) {
		boolean oldDiscrete_timed = discrete_timed;
		discrete_timed = newDiscrete_timed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MACHINE__DISCRETE_TIMED, oldDiscrete_timed, discrete_timed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isUnsafe() {
		return unsafe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUnsafe(boolean newUnsafe) {
		boolean oldUnsafe = unsafe;
		unsafe = newUnsafe;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MACHINE__UNSAFE, oldUnsafe, unsafe));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DesignKind getDesign() {
		return design;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDesign(DesignKind newDesign) {
		DesignKind oldDesign = design;
		design = newDesign == null ? DESIGN_EDEFAULT : newDesign;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MACHINE__DESIGN, oldDesign, design));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isLifeline() {
		return lifeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLifeline(boolean newLifeline) {
		boolean oldLifeline = lifeline;
		lifeline = newLifeline;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MACHINE__LIFELINE, oldLifeline, lifeline));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataType> getTypedef() {
		if (typedef == null) {
			typedef = new EObjectContainmentEList<DataType>(DataType.class, this, InfrastructurePackage.MACHINE__TYPEDEF);
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
			variable = new EObjectContainmentEList<Variable>(Variable.class, this, InfrastructurePackage.MACHINE__VARIABLE);
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
			channel = new EObjectContainmentEList<Channel>(Channel.class, this, InfrastructurePackage.MACHINE__CHANNEL);
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
			port = new EObjectContainmentEList<Port>(Port.class, this, InfrastructurePackage.MACHINE__PORT);
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
			signal = new EObjectContainmentEList<Signal>(Signal.class, this, InfrastructurePackage.MACHINE__SIGNAL);
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
			buffer = new EObjectContainmentEList<Buffer>(Buffer.class, this, InfrastructurePackage.MACHINE__BUFFER);
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
			function = new EObjectContainmentEList<Function>(Function.class, this, InfrastructurePackage.MACHINE__FUNCTION);
		}
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Routine> getRoutine() {
		if (routine == null) {
			routine = new EObjectContainmentEList<Routine>(Routine.class, this, InfrastructurePackage.MACHINE__ROUTINE);
		}
		return routine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Procedure> getProcedure() {
		if (procedure == null) {
			procedure = new EObjectContainmentEList<Procedure>(Procedure.class, this, InfrastructurePackage.MACHINE__PROCEDURE);
		}
		return procedure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Machine> getMachine() {
		if (machine == null) {
			machine = new EObjectContainmentEList<Machine>(Machine.class, this, InfrastructurePackage.MACHINE__MACHINE);
		}
		return machine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<InstanceMachine> getInstance() {
		if (instance == null) {
			instance = new EObjectContainmentEList<InstanceMachine>(InstanceMachine.class, this, InfrastructurePackage.MACHINE__INSTANCE);
		}
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Behavior> getBehavior() {
		if (behavior == null) {
			behavior = new EObjectContainmentEList<Behavior>(Behavior.class, this, InfrastructurePackage.MACHINE__BEHAVIOR);
		}
		return behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Behavior getMain() {
		return main;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMain(Behavior newMain, NotificationChain msgs) {
		Behavior oldMain = main;
		main = newMain;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MACHINE__MAIN, oldMain, newMain);
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
	public void setMain(Behavior newMain) {
		if (newMain != main) {
			NotificationChain msgs = null;
			if (main != null)
				msgs = ((InternalEObject)main).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MACHINE__MAIN, null, msgs);
			if (newMain != null)
				msgs = ((InternalEObject)newMain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MACHINE__MAIN, null, msgs);
			msgs = basicSetMain(newMain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.MACHINE__MAIN, newMain, newMain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InfrastructurePackage.MACHINE__TYPEDEF:
				return ((InternalEList<?>)getTypedef()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.MACHINE__VARIABLE:
				return ((InternalEList<?>)getVariable()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.MACHINE__CHANNEL:
				return ((InternalEList<?>)getChannel()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.MACHINE__PORT:
				return ((InternalEList<?>)getPort()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.MACHINE__SIGNAL:
				return ((InternalEList<?>)getSignal()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.MACHINE__BUFFER:
				return ((InternalEList<?>)getBuffer()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.MACHINE__FUNCTION:
				return ((InternalEList<?>)getFunction()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.MACHINE__ROUTINE:
				return ((InternalEList<?>)getRoutine()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.MACHINE__PROCEDURE:
				return ((InternalEList<?>)getProcedure()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.MACHINE__MACHINE:
				return ((InternalEList<?>)getMachine()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.MACHINE__INSTANCE:
				return ((InternalEList<?>)getInstance()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.MACHINE__BEHAVIOR:
				return ((InternalEList<?>)getBehavior()).basicRemove(otherEnd, msgs);
			case InfrastructurePackage.MACHINE__MAIN:
				return basicSetMain(null, msgs);
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
			case InfrastructurePackage.MACHINE__INPUT_ENABLED:
				return isInput_enabled();
			case InfrastructurePackage.MACHINE__TIMED:
				return isTimed();
			case InfrastructurePackage.MACHINE__DENSE_TIMED:
				return isDense_timed();
			case InfrastructurePackage.MACHINE__DISCRETE_TIMED:
				return isDiscrete_timed();
			case InfrastructurePackage.MACHINE__UNSAFE:
				return isUnsafe();
			case InfrastructurePackage.MACHINE__DESIGN:
				return getDesign();
			case InfrastructurePackage.MACHINE__LIFELINE:
				return isLifeline();
			case InfrastructurePackage.MACHINE__TYPEDEF:
				return getTypedef();
			case InfrastructurePackage.MACHINE__VARIABLE:
				return getVariable();
			case InfrastructurePackage.MACHINE__CHANNEL:
				return getChannel();
			case InfrastructurePackage.MACHINE__PORT:
				return getPort();
			case InfrastructurePackage.MACHINE__SIGNAL:
				return getSignal();
			case InfrastructurePackage.MACHINE__BUFFER:
				return getBuffer();
			case InfrastructurePackage.MACHINE__FUNCTION:
				return getFunction();
			case InfrastructurePackage.MACHINE__ROUTINE:
				return getRoutine();
			case InfrastructurePackage.MACHINE__PROCEDURE:
				return getProcedure();
			case InfrastructurePackage.MACHINE__MACHINE:
				return getMachine();
			case InfrastructurePackage.MACHINE__INSTANCE:
				return getInstance();
			case InfrastructurePackage.MACHINE__BEHAVIOR:
				return getBehavior();
			case InfrastructurePackage.MACHINE__MAIN:
				return getMain();
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
			case InfrastructurePackage.MACHINE__INPUT_ENABLED:
				setInput_enabled((Boolean)newValue);
				return;
			case InfrastructurePackage.MACHINE__TIMED:
				setTimed((Boolean)newValue);
				return;
			case InfrastructurePackage.MACHINE__DENSE_TIMED:
				setDense_timed((Boolean)newValue);
				return;
			case InfrastructurePackage.MACHINE__DISCRETE_TIMED:
				setDiscrete_timed((Boolean)newValue);
				return;
			case InfrastructurePackage.MACHINE__UNSAFE:
				setUnsafe((Boolean)newValue);
				return;
			case InfrastructurePackage.MACHINE__DESIGN:
				setDesign((DesignKind)newValue);
				return;
			case InfrastructurePackage.MACHINE__LIFELINE:
				setLifeline((Boolean)newValue);
				return;
			case InfrastructurePackage.MACHINE__TYPEDEF:
				getTypedef().clear();
				getTypedef().addAll((Collection<? extends DataType>)newValue);
				return;
			case InfrastructurePackage.MACHINE__VARIABLE:
				getVariable().clear();
				getVariable().addAll((Collection<? extends Variable>)newValue);
				return;
			case InfrastructurePackage.MACHINE__CHANNEL:
				getChannel().clear();
				getChannel().addAll((Collection<? extends Channel>)newValue);
				return;
			case InfrastructurePackage.MACHINE__PORT:
				getPort().clear();
				getPort().addAll((Collection<? extends Port>)newValue);
				return;
			case InfrastructurePackage.MACHINE__SIGNAL:
				getSignal().clear();
				getSignal().addAll((Collection<? extends Signal>)newValue);
				return;
			case InfrastructurePackage.MACHINE__BUFFER:
				getBuffer().clear();
				getBuffer().addAll((Collection<? extends Buffer>)newValue);
				return;
			case InfrastructurePackage.MACHINE__FUNCTION:
				getFunction().clear();
				getFunction().addAll((Collection<? extends Function>)newValue);
				return;
			case InfrastructurePackage.MACHINE__ROUTINE:
				getRoutine().clear();
				getRoutine().addAll((Collection<? extends Routine>)newValue);
				return;
			case InfrastructurePackage.MACHINE__PROCEDURE:
				getProcedure().clear();
				getProcedure().addAll((Collection<? extends Procedure>)newValue);
				return;
			case InfrastructurePackage.MACHINE__MACHINE:
				getMachine().clear();
				getMachine().addAll((Collection<? extends Machine>)newValue);
				return;
			case InfrastructurePackage.MACHINE__INSTANCE:
				getInstance().clear();
				getInstance().addAll((Collection<? extends InstanceMachine>)newValue);
				return;
			case InfrastructurePackage.MACHINE__BEHAVIOR:
				getBehavior().clear();
				getBehavior().addAll((Collection<? extends Behavior>)newValue);
				return;
			case InfrastructurePackage.MACHINE__MAIN:
				setMain((Behavior)newValue);
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
			case InfrastructurePackage.MACHINE__INPUT_ENABLED:
				setInput_enabled(INPUT_ENABLED_EDEFAULT);
				return;
			case InfrastructurePackage.MACHINE__TIMED:
				setTimed(TIMED_EDEFAULT);
				return;
			case InfrastructurePackage.MACHINE__DENSE_TIMED:
				setDense_timed(DENSE_TIMED_EDEFAULT);
				return;
			case InfrastructurePackage.MACHINE__DISCRETE_TIMED:
				setDiscrete_timed(DISCRETE_TIMED_EDEFAULT);
				return;
			case InfrastructurePackage.MACHINE__UNSAFE:
				setUnsafe(UNSAFE_EDEFAULT);
				return;
			case InfrastructurePackage.MACHINE__DESIGN:
				setDesign(DESIGN_EDEFAULT);
				return;
			case InfrastructurePackage.MACHINE__LIFELINE:
				setLifeline(LIFELINE_EDEFAULT);
				return;
			case InfrastructurePackage.MACHINE__TYPEDEF:
				getTypedef().clear();
				return;
			case InfrastructurePackage.MACHINE__VARIABLE:
				getVariable().clear();
				return;
			case InfrastructurePackage.MACHINE__CHANNEL:
				getChannel().clear();
				return;
			case InfrastructurePackage.MACHINE__PORT:
				getPort().clear();
				return;
			case InfrastructurePackage.MACHINE__SIGNAL:
				getSignal().clear();
				return;
			case InfrastructurePackage.MACHINE__BUFFER:
				getBuffer().clear();
				return;
			case InfrastructurePackage.MACHINE__FUNCTION:
				getFunction().clear();
				return;
			case InfrastructurePackage.MACHINE__ROUTINE:
				getRoutine().clear();
				return;
			case InfrastructurePackage.MACHINE__PROCEDURE:
				getProcedure().clear();
				return;
			case InfrastructurePackage.MACHINE__MACHINE:
				getMachine().clear();
				return;
			case InfrastructurePackage.MACHINE__INSTANCE:
				getInstance().clear();
				return;
			case InfrastructurePackage.MACHINE__BEHAVIOR:
				getBehavior().clear();
				return;
			case InfrastructurePackage.MACHINE__MAIN:
				setMain((Behavior)null);
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
			case InfrastructurePackage.MACHINE__INPUT_ENABLED:
				return input_enabled != INPUT_ENABLED_EDEFAULT;
			case InfrastructurePackage.MACHINE__TIMED:
				return timed != TIMED_EDEFAULT;
			case InfrastructurePackage.MACHINE__DENSE_TIMED:
				return dense_timed != DENSE_TIMED_EDEFAULT;
			case InfrastructurePackage.MACHINE__DISCRETE_TIMED:
				return discrete_timed != DISCRETE_TIMED_EDEFAULT;
			case InfrastructurePackage.MACHINE__UNSAFE:
				return unsafe != UNSAFE_EDEFAULT;
			case InfrastructurePackage.MACHINE__DESIGN:
				return design != DESIGN_EDEFAULT;
			case InfrastructurePackage.MACHINE__LIFELINE:
				return lifeline != LIFELINE_EDEFAULT;
			case InfrastructurePackage.MACHINE__TYPEDEF:
				return typedef != null && !typedef.isEmpty();
			case InfrastructurePackage.MACHINE__VARIABLE:
				return variable != null && !variable.isEmpty();
			case InfrastructurePackage.MACHINE__CHANNEL:
				return channel != null && !channel.isEmpty();
			case InfrastructurePackage.MACHINE__PORT:
				return port != null && !port.isEmpty();
			case InfrastructurePackage.MACHINE__SIGNAL:
				return signal != null && !signal.isEmpty();
			case InfrastructurePackage.MACHINE__BUFFER:
				return buffer != null && !buffer.isEmpty();
			case InfrastructurePackage.MACHINE__FUNCTION:
				return function != null && !function.isEmpty();
			case InfrastructurePackage.MACHINE__ROUTINE:
				return routine != null && !routine.isEmpty();
			case InfrastructurePackage.MACHINE__PROCEDURE:
				return procedure != null && !procedure.isEmpty();
			case InfrastructurePackage.MACHINE__MACHINE:
				return machine != null && !machine.isEmpty();
			case InfrastructurePackage.MACHINE__INSTANCE:
				return instance != null && !instance.isEmpty();
			case InfrastructurePackage.MACHINE__BEHAVIOR:
				return behavior != null && !behavior.isEmpty();
			case InfrastructurePackage.MACHINE__MAIN:
				return main != null;
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
		result.append(" (input_enabled: ");
		result.append(input_enabled);
		result.append(", timed: ");
		result.append(timed);
		result.append(", dense_timed: ");
		result.append(dense_timed);
		result.append(", discrete_timed: ");
		result.append(discrete_timed);
		result.append(", unsafe: ");
		result.append(unsafe);
		result.append(", design: ");
		result.append(design);
		result.append(", lifeline: ");
		result.append(lifeline);
		result.append(')');
		return result.toString();
	}

} //MachineImpl
