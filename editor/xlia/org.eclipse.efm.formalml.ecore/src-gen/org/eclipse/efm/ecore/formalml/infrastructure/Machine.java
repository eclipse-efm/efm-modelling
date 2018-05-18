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
package org.eclipse.efm.ecore.formalml.infrastructure;

import org.eclipse.efm.ecore.formalml.common.ClassifierDefinition;

import org.eclipse.efm.ecore.formalml.datatype.DataType;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#isInput_enabled <em>Input enabled</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#isTimed <em>Timed</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#isDense_timed <em>Dense timed</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#isDiscrete_timed <em>Discrete timed</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#isUnsafe <em>Unsafe</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getDesign <em>Design</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getPropertyPart <em>Property Part</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getCompositePart <em>Composite Part</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getBehaviorPart <em>Behavior Part</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getMachine <em>Machine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getTypedef <em>Typedef</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getChannel <em>Channel</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getPort <em>Port</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getSignal <em>Signal</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getBuffer <em>Buffer</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getFunction <em>Function</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getRoutine <em>Routine</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getProcedure <em>Procedure</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getInstance <em>Instance</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getMain <em>Main</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine()
 * @model
 * @generated
 */
public interface Machine extends ClassifierDefinition {
	/**
	 * Returns the value of the '<em><b>Input enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input enabled</em>' attribute.
	 * @see #setInput_enabled(boolean)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_Input_enabled()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isInput_enabled();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#isInput_enabled <em>Input enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input enabled</em>' attribute.
	 * @see #isInput_enabled()
	 * @generated
	 */
	void setInput_enabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Timed</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timed</em>' attribute.
	 * @see #setTimed(boolean)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_Timed()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isTimed();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#isTimed <em>Timed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timed</em>' attribute.
	 * @see #isTimed()
	 * @generated
	 */
	void setTimed(boolean value);

	/**
	 * Returns the value of the '<em><b>Dense timed</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dense timed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dense timed</em>' attribute.
	 * @see #setDense_timed(boolean)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_Dense_timed()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isDense_timed();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#isDense_timed <em>Dense timed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dense timed</em>' attribute.
	 * @see #isDense_timed()
	 * @generated
	 */
	void setDense_timed(boolean value);

	/**
	 * Returns the value of the '<em><b>Discrete timed</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Discrete timed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Discrete timed</em>' attribute.
	 * @see #setDiscrete_timed(boolean)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_Discrete_timed()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isDiscrete_timed();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#isDiscrete_timed <em>Discrete timed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Discrete timed</em>' attribute.
	 * @see #isDiscrete_timed()
	 * @generated
	 */
	void setDiscrete_timed(boolean value);

	/**
	 * Returns the value of the '<em><b>Unsafe</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unsafe</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unsafe</em>' attribute.
	 * @see #setUnsafe(boolean)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_Unsafe()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isUnsafe();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#isUnsafe <em>Unsafe</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unsafe</em>' attribute.
	 * @see #isUnsafe()
	 * @generated
	 */
	void setUnsafe(boolean value);

	/**
	 * Returns the value of the '<em><b>Design</b></em>' attribute.
	 * The default value is <code>"prototype"</code>.
	 * The literals are from the enumeration {@link org.eclipse.efm.ecore.formalml.infrastructure.DesignKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Design</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Design</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.DesignKind
	 * @see #setDesign(DesignKind)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_Design()
	 * @model default="prototype" required="true"
	 * @generated
	 */
	DesignKind getDesign();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getDesign <em>Design</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Design</em>' attribute.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.DesignKind
	 * @see #getDesign()
	 * @generated
	 */
	void setDesign(DesignKind value);

	/**
	 * Returns the value of the '<em><b>Property Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Part</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Part</em>' containment reference.
	 * @see #setPropertyPart(PropertyPart)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_PropertyPart()
	 * @model containment="true"
	 * @generated
	 */
	PropertyPart getPropertyPart();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getPropertyPart <em>Property Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Part</em>' containment reference.
	 * @see #getPropertyPart()
	 * @generated
	 */
	void setPropertyPart(PropertyPart value);

	/**
	 * Returns the value of the '<em><b>Composite Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite Part</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Part</em>' containment reference.
	 * @see #setCompositePart(CompositePart)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_CompositePart()
	 * @model containment="true"
	 * @generated
	 */
	CompositePart getCompositePart();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getCompositePart <em>Composite Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite Part</em>' containment reference.
	 * @see #getCompositePart()
	 * @generated
	 */
	void setCompositePart(CompositePart value);

	/**
	 * Returns the value of the '<em><b>Behavior Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior Part</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior Part</em>' containment reference.
	 * @see #setBehaviorPart(BehaviorPart)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_BehaviorPart()
	 * @model containment="true"
	 * @generated
	 */
	BehaviorPart getBehaviorPart();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getBehaviorPart <em>Behavior Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior Part</em>' containment reference.
	 * @see #getBehaviorPart()
	 * @generated
	 */
	void setBehaviorPart(BehaviorPart value);

	/**
	 * Returns the value of the '<em><b>Machine</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Machine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machine</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_Machine()
	 * @model containment="true"
	 * @generated
	 */
	EList<Machine> getMachine();

	/**
	 * Returns the value of the '<em><b>Typedef</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.datatype.DataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Typedef</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Typedef</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_Typedef()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataType> getTypedef();

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_Variable()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getVariable();

	/**
	 * Returns the value of the '<em><b>Channel</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Channel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_Channel()
	 * @model containment="true"
	 * @generated
	 */
	EList<Channel> getChannel();

	/**
	 * Returns the value of the '<em><b>Port</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_Port()
	 * @model containment="true"
	 * @generated
	 */
	EList<Port> getPort();

	/**
	 * Returns the value of the '<em><b>Signal</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Signal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signal</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signal</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_Signal()
	 * @model containment="true"
	 * @generated
	 */
	EList<Signal> getSignal();

	/**
	 * Returns the value of the '<em><b>Buffer</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Buffer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Buffer</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_Buffer()
	 * @model containment="true"
	 * @generated
	 */
	EList<Buffer> getBuffer();

	/**
	 * Returns the value of the '<em><b>Function</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Function}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_Function()
	 * @model containment="true"
	 * @generated
	 */
	EList<Function> getFunction();

	/**
	 * Returns the value of the '<em><b>Routine</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Routine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Routine</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Routine</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_Routine()
	 * @model containment="true"
	 * @generated
	 */
	EList<Routine> getRoutine();

	/**
	 * Returns the value of the '<em><b>Procedure</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Procedure}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Procedure</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Procedure</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_Procedure()
	 * @model containment="true"
	 * @generated
	 */
	EList<Procedure> getProcedure();

	/**
	 * Returns the value of the '<em><b>Instance</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.InstanceMachine}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_Instance()
	 * @model containment="true"
	 * @generated
	 */
	EList<InstanceMachine> getInstance();

	/**
	 * Returns the value of the '<em><b>Behavior</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.infrastructure.Behavior}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_Behavior()
	 * @model containment="true"
	 * @generated
	 */
	EList<Behavior> getBehavior();

	/**
	 * Returns the value of the '<em><b>Main</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main</em>' containment reference.
	 * @see #setMain(Behavior)
	 * @see org.eclipse.efm.ecore.formalml.infrastructure.InfrastructurePackage#getMachine_Main()
	 * @model containment="true"
	 * @generated
	 */
	Behavior getMain();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.ecore.formalml.infrastructure.Machine#getMain <em>Main</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main</em>' containment reference.
	 * @see #getMain()
	 * @generated
	 */
	void setMain(Behavior value);

} // Machine
