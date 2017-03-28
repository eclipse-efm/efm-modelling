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
package org.eclipse.efm.core.workflow.coverage;

import org.eclipse.efm.core.workflow.CoverageWorker;

import org.eclipse.efm.core.workflow.common.CheckingScopeKind;
import org.eclipse.efm.core.workflow.common.TraceSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Coverage Worker</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#getCheckingScope <em>Checking Scope</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#isOrderedTrace <em>Ordered Trace</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#isHitConsecutive <em>Hit Consecutive</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#isHitFolding <em>Hit Folding</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#isHitMax <em>Hit Max</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#isHitLucky <em>Hit Lucky</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#getJumpHeight <em>Jump Height</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#getJumpTrialsLimit <em>Jump Trials Limit</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#getHitCount <em>Hit Count</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#getJumpCount <em>Jump Count</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#isJumpSlice <em>Jump Slice</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#getBehavior <em>Behavior</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.core.workflow.coverage.CoveragePackage#getBehaviorCoverageWorker()
 * @model
 * @generated
 */
public interface BehaviorCoverageWorker extends CoverageWorker {
	/**
	 * Returns the value of the '<em><b>Checking Scope</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.efm.core.workflow.common.CheckingScopeKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checking Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checking Scope</em>' attribute.
	 * @see org.eclipse.efm.core.workflow.common.CheckingScopeKind
	 * @see #setCheckingScope(CheckingScopeKind)
	 * @see org.eclipse.efm.core.workflow.coverage.CoveragePackage#getBehaviorCoverageWorker_CheckingScope()
	 * @model
	 * @generated
	 */
	CheckingScopeKind getCheckingScope();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#getCheckingScope <em>Checking Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Checking Scope</em>' attribute.
	 * @see org.eclipse.efm.core.workflow.common.CheckingScopeKind
	 * @see #getCheckingScope()
	 * @generated
	 */
	void setCheckingScope(CheckingScopeKind value);

	/**
	 * Returns the value of the '<em><b>Ordered Trace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ordered Trace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ordered Trace</em>' attribute.
	 * @see #setOrderedTrace(boolean)
	 * @see org.eclipse.efm.core.workflow.coverage.CoveragePackage#getBehaviorCoverageWorker_OrderedTrace()
	 * @model
	 * @generated
	 */
	boolean isOrderedTrace();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#isOrderedTrace <em>Ordered Trace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ordered Trace</em>' attribute.
	 * @see #isOrderedTrace()
	 * @generated
	 */
	void setOrderedTrace(boolean value);

	/**
	 * Returns the value of the '<em><b>Hit Consecutive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hit Consecutive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hit Consecutive</em>' attribute.
	 * @see #setHitConsecutive(boolean)
	 * @see org.eclipse.efm.core.workflow.coverage.CoveragePackage#getBehaviorCoverageWorker_HitConsecutive()
	 * @model
	 * @generated
	 */
	boolean isHitConsecutive();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#isHitConsecutive <em>Hit Consecutive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hit Consecutive</em>' attribute.
	 * @see #isHitConsecutive()
	 * @generated
	 */
	void setHitConsecutive(boolean value);

	/**
	 * Returns the value of the '<em><b>Hit Folding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hit Folding</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hit Folding</em>' attribute.
	 * @see #setHitFolding(boolean)
	 * @see org.eclipse.efm.core.workflow.coverage.CoveragePackage#getBehaviorCoverageWorker_HitFolding()
	 * @model
	 * @generated
	 */
	boolean isHitFolding();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#isHitFolding <em>Hit Folding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hit Folding</em>' attribute.
	 * @see #isHitFolding()
	 * @generated
	 */
	void setHitFolding(boolean value);

	/**
	 * Returns the value of the '<em><b>Hit Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hit Max</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hit Max</em>' attribute.
	 * @see #setHitMax(boolean)
	 * @see org.eclipse.efm.core.workflow.coverage.CoveragePackage#getBehaviorCoverageWorker_HitMax()
	 * @model
	 * @generated
	 */
	boolean isHitMax();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#isHitMax <em>Hit Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hit Max</em>' attribute.
	 * @see #isHitMax()
	 * @generated
	 */
	void setHitMax(boolean value);

	/**
	 * Returns the value of the '<em><b>Hit Lucky</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hit Lucky</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hit Lucky</em>' attribute.
	 * @see #setHitLucky(boolean)
	 * @see org.eclipse.efm.core.workflow.coverage.CoveragePackage#getBehaviorCoverageWorker_HitLucky()
	 * @model
	 * @generated
	 */
	boolean isHitLucky();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#isHitLucky <em>Hit Lucky</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hit Lucky</em>' attribute.
	 * @see #isHitLucky()
	 * @generated
	 */
	void setHitLucky(boolean value);

	/**
	 * Returns the value of the '<em><b>Jump Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jump Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jump Height</em>' attribute.
	 * @see #setJumpHeight(int)
	 * @see org.eclipse.efm.core.workflow.coverage.CoveragePackage#getBehaviorCoverageWorker_JumpHeight()
	 * @model
	 * @generated
	 */
	int getJumpHeight();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#getJumpHeight <em>Jump Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jump Height</em>' attribute.
	 * @see #getJumpHeight()
	 * @generated
	 */
	void setJumpHeight(int value);

	/**
	 * Returns the value of the '<em><b>Jump Trials Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jump Trials Limit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jump Trials Limit</em>' attribute.
	 * @see #setJumpTrialsLimit(int)
	 * @see org.eclipse.efm.core.workflow.coverage.CoveragePackage#getBehaviorCoverageWorker_JumpTrialsLimit()
	 * @model
	 * @generated
	 */
	int getJumpTrialsLimit();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#getJumpTrialsLimit <em>Jump Trials Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jump Trials Limit</em>' attribute.
	 * @see #getJumpTrialsLimit()
	 * @generated
	 */
	void setJumpTrialsLimit(int value);

	/**
	 * Returns the value of the '<em><b>Hit Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hit Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hit Count</em>' attribute.
	 * @see #setHitCount(int)
	 * @see org.eclipse.efm.core.workflow.coverage.CoveragePackage#getBehaviorCoverageWorker_HitCount()
	 * @model
	 * @generated
	 */
	int getHitCount();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#getHitCount <em>Hit Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hit Count</em>' attribute.
	 * @see #getHitCount()
	 * @generated
	 */
	void setHitCount(int value);

	/**
	 * Returns the value of the '<em><b>Jump Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jump Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jump Count</em>' attribute.
	 * @see #setJumpCount(int)
	 * @see org.eclipse.efm.core.workflow.coverage.CoveragePackage#getBehaviorCoverageWorker_JumpCount()
	 * @model
	 * @generated
	 */
	int getJumpCount();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#getJumpCount <em>Jump Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jump Count</em>' attribute.
	 * @see #getJumpCount()
	 * @generated
	 */
	void setJumpCount(int value);

	/**
	 * Returns the value of the '<em><b>Jump Slice</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jump Slice</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jump Slice</em>' attribute.
	 * @see #setJumpSlice(boolean)
	 * @see org.eclipse.efm.core.workflow.coverage.CoveragePackage#getBehaviorCoverageWorker_JumpSlice()
	 * @model
	 * @generated
	 */
	boolean isJumpSlice();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#isJumpSlice <em>Jump Slice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jump Slice</em>' attribute.
	 * @see #isJumpSlice()
	 * @generated
	 */
	void setJumpSlice(boolean value);

	/**
	 * Returns the value of the '<em><b>Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior</em>' containment reference.
	 * @see #setBehavior(TraceSpecification)
	 * @see org.eclipse.efm.core.workflow.coverage.CoveragePackage#getBehaviorCoverageWorker_Behavior()
	 * @model containment="true"
	 * @generated
	 */
	TraceSpecification getBehavior();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.coverage.BehaviorCoverageWorker#getBehavior <em>Behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior</em>' containment reference.
	 * @see #getBehavior()
	 * @generated
	 */
	void setBehavior(TraceSpecification value);

} // BehaviorCoverageWorker
