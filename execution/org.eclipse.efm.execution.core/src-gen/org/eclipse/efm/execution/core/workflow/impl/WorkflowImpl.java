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
package org.eclipse.efm.execution.core.workflow.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.efm.execution.core.workflow.Director;
import org.eclipse.efm.execution.core.workflow.Workflow;
import org.eclipse.efm.execution.core.workflow.WorkflowPackage;

import org.eclipse.efm.execution.core.workflow.common.ConsoleLogFormat;
import org.eclipse.efm.execution.core.workflow.common.DeveloperTuningOption;
import org.eclipse.efm.execution.core.workflow.common.Manifest;
import org.eclipse.efm.execution.core.workflow.common.ShellMode;
import org.eclipse.efm.execution.core.workflow.common.SymbexOption;
import org.eclipse.efm.execution.core.workflow.common.Workspace;

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
 * An implementation of the model object '<em><b>Workflow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.impl.WorkflowImpl#getManifest <em>Manifest</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.impl.WorkflowImpl#getWorkspace <em>Workspace</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.impl.WorkflowImpl#getDirector <em>Director</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.impl.WorkflowImpl#getSymbexOption <em>Symbex Option</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.impl.WorkflowImpl#getConsole <em>Console</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.impl.WorkflowImpl#getShellMode <em>Shell Mode</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.impl.WorkflowImpl#getDeveloperTuning <em>Developer Tuning</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WorkflowImpl extends NamedObjectImpl implements Workflow {
	/**
	 * The cached value of the '{@link #getManifest() <em>Manifest</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManifest()
	 * @generated
	 * @ordered
	 */
	protected Manifest manifest;

	/**
	 * The cached value of the '{@link #getWorkspace() <em>Workspace</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkspace()
	 * @generated
	 * @ordered
	 */
	protected Workspace workspace;

	/**
	 * The cached value of the '{@link #getDirector() <em>Director</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirector()
	 * @generated
	 * @ordered
	 */
	protected EList<Director> director;

	/**
	 * The cached value of the '{@link #getSymbexOption() <em>Symbex Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbexOption()
	 * @generated
	 * @ordered
	 */
	protected SymbexOption symbexOption;

	/**
	 * The cached value of the '{@link #getConsole() <em>Console</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConsole()
	 * @generated
	 * @ordered
	 */
	protected ConsoleLogFormat console;

	/**
	 * The cached value of the '{@link #getShellMode() <em>Shell Mode</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShellMode()
	 * @generated
	 * @ordered
	 */
	protected ShellMode shellMode;

	/**
	 * The cached value of the '{@link #getDeveloperTuning() <em>Developer Tuning</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeveloperTuning()
	 * @generated
	 * @ordered
	 */
	protected DeveloperTuningOption developerTuning;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkflowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.WORKFLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Manifest getManifest() {
		return manifest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetManifest(Manifest newManifest, NotificationChain msgs) {
		Manifest oldManifest = manifest;
		manifest = newManifest;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW__MANIFEST, oldManifest, newManifest);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManifest(Manifest newManifest) {
		if (newManifest != manifest) {
			NotificationChain msgs = null;
			if (manifest != null)
				msgs = ((InternalEObject)manifest).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW__MANIFEST, null, msgs);
			if (newManifest != null)
				msgs = ((InternalEObject)newManifest).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW__MANIFEST, null, msgs);
			msgs = basicSetManifest(newManifest, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW__MANIFEST, newManifest, newManifest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Workspace getWorkspace() {
		return workspace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWorkspace(Workspace newWorkspace, NotificationChain msgs) {
		Workspace oldWorkspace = workspace;
		workspace = newWorkspace;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW__WORKSPACE, oldWorkspace, newWorkspace);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkspace(Workspace newWorkspace) {
		if (newWorkspace != workspace) {
			NotificationChain msgs = null;
			if (workspace != null)
				msgs = ((InternalEObject)workspace).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW__WORKSPACE, null, msgs);
			if (newWorkspace != null)
				msgs = ((InternalEObject)newWorkspace).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW__WORKSPACE, null, msgs);
			msgs = basicSetWorkspace(newWorkspace, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW__WORKSPACE, newWorkspace, newWorkspace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<Director> getDirector() {
		if (director == null) {
			director = new EObjectContainmentEList<Director>(Director.class, this, WorkflowPackage.WORKFLOW__DIRECTOR);
		}
		return director;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SymbexOption getSymbexOption() {
		return symbexOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSymbexOption(SymbexOption newSymbexOption, NotificationChain msgs) {
		SymbexOption oldSymbexOption = symbexOption;
		symbexOption = newSymbexOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW__SYMBEX_OPTION, oldSymbexOption, newSymbexOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSymbexOption(SymbexOption newSymbexOption) {
		if (newSymbexOption != symbexOption) {
			NotificationChain msgs = null;
			if (symbexOption != null)
				msgs = ((InternalEObject)symbexOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW__SYMBEX_OPTION, null, msgs);
			if (newSymbexOption != null)
				msgs = ((InternalEObject)newSymbexOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW__SYMBEX_OPTION, null, msgs);
			msgs = basicSetSymbexOption(newSymbexOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW__SYMBEX_OPTION, newSymbexOption, newSymbexOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConsoleLogFormat getConsole() {
		return console;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConsole(ConsoleLogFormat newConsole, NotificationChain msgs) {
		ConsoleLogFormat oldConsole = console;
		console = newConsole;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW__CONSOLE, oldConsole, newConsole);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConsole(ConsoleLogFormat newConsole) {
		if (newConsole != console) {
			NotificationChain msgs = null;
			if (console != null)
				msgs = ((InternalEObject)console).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW__CONSOLE, null, msgs);
			if (newConsole != null)
				msgs = ((InternalEObject)newConsole).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW__CONSOLE, null, msgs);
			msgs = basicSetConsole(newConsole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW__CONSOLE, newConsole, newConsole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShellMode getShellMode() {
		return shellMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetShellMode(ShellMode newShellMode, NotificationChain msgs) {
		ShellMode oldShellMode = shellMode;
		shellMode = newShellMode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW__SHELL_MODE, oldShellMode, newShellMode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShellMode(ShellMode newShellMode) {
		if (newShellMode != shellMode) {
			NotificationChain msgs = null;
			if (shellMode != null)
				msgs = ((InternalEObject)shellMode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW__SHELL_MODE, null, msgs);
			if (newShellMode != null)
				msgs = ((InternalEObject)newShellMode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW__SHELL_MODE, null, msgs);
			msgs = basicSetShellMode(newShellMode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW__SHELL_MODE, newShellMode, newShellMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeveloperTuningOption getDeveloperTuning() {
		return developerTuning;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeveloperTuning(DeveloperTuningOption newDeveloperTuning, NotificationChain msgs) {
		DeveloperTuningOption oldDeveloperTuning = developerTuning;
		developerTuning = newDeveloperTuning;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW__DEVELOPER_TUNING, oldDeveloperTuning, newDeveloperTuning);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeveloperTuning(DeveloperTuningOption newDeveloperTuning) {
		if (newDeveloperTuning != developerTuning) {
			NotificationChain msgs = null;
			if (developerTuning != null)
				msgs = ((InternalEObject)developerTuning).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW__DEVELOPER_TUNING, null, msgs);
			if (newDeveloperTuning != null)
				msgs = ((InternalEObject)newDeveloperTuning).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKFLOW__DEVELOPER_TUNING, null, msgs);
			msgs = basicSetDeveloperTuning(newDeveloperTuning, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKFLOW__DEVELOPER_TUNING, newDeveloperTuning, newDeveloperTuning));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowPackage.WORKFLOW__MANIFEST:
				return basicSetManifest(null, msgs);
			case WorkflowPackage.WORKFLOW__WORKSPACE:
				return basicSetWorkspace(null, msgs);
			case WorkflowPackage.WORKFLOW__DIRECTOR:
				return ((InternalEList<?>)getDirector()).basicRemove(otherEnd, msgs);
			case WorkflowPackage.WORKFLOW__SYMBEX_OPTION:
				return basicSetSymbexOption(null, msgs);
			case WorkflowPackage.WORKFLOW__CONSOLE:
				return basicSetConsole(null, msgs);
			case WorkflowPackage.WORKFLOW__SHELL_MODE:
				return basicSetShellMode(null, msgs);
			case WorkflowPackage.WORKFLOW__DEVELOPER_TUNING:
				return basicSetDeveloperTuning(null, msgs);
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
			case WorkflowPackage.WORKFLOW__MANIFEST:
				return getManifest();
			case WorkflowPackage.WORKFLOW__WORKSPACE:
				return getWorkspace();
			case WorkflowPackage.WORKFLOW__DIRECTOR:
				return getDirector();
			case WorkflowPackage.WORKFLOW__SYMBEX_OPTION:
				return getSymbexOption();
			case WorkflowPackage.WORKFLOW__CONSOLE:
				return getConsole();
			case WorkflowPackage.WORKFLOW__SHELL_MODE:
				return getShellMode();
			case WorkflowPackage.WORKFLOW__DEVELOPER_TUNING:
				return getDeveloperTuning();
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
			case WorkflowPackage.WORKFLOW__MANIFEST:
				setManifest((Manifest)newValue);
				return;
			case WorkflowPackage.WORKFLOW__WORKSPACE:
				setWorkspace((Workspace)newValue);
				return;
			case WorkflowPackage.WORKFLOW__DIRECTOR:
				getDirector().clear();
				getDirector().addAll((Collection<? extends Director>)newValue);
				return;
			case WorkflowPackage.WORKFLOW__SYMBEX_OPTION:
				setSymbexOption((SymbexOption)newValue);
				return;
			case WorkflowPackage.WORKFLOW__CONSOLE:
				setConsole((ConsoleLogFormat)newValue);
				return;
			case WorkflowPackage.WORKFLOW__SHELL_MODE:
				setShellMode((ShellMode)newValue);
				return;
			case WorkflowPackage.WORKFLOW__DEVELOPER_TUNING:
				setDeveloperTuning((DeveloperTuningOption)newValue);
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
			case WorkflowPackage.WORKFLOW__MANIFEST:
				setManifest((Manifest)null);
				return;
			case WorkflowPackage.WORKFLOW__WORKSPACE:
				setWorkspace((Workspace)null);
				return;
			case WorkflowPackage.WORKFLOW__DIRECTOR:
				getDirector().clear();
				return;
			case WorkflowPackage.WORKFLOW__SYMBEX_OPTION:
				setSymbexOption((SymbexOption)null);
				return;
			case WorkflowPackage.WORKFLOW__CONSOLE:
				setConsole((ConsoleLogFormat)null);
				return;
			case WorkflowPackage.WORKFLOW__SHELL_MODE:
				setShellMode((ShellMode)null);
				return;
			case WorkflowPackage.WORKFLOW__DEVELOPER_TUNING:
				setDeveloperTuning((DeveloperTuningOption)null);
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
			case WorkflowPackage.WORKFLOW__MANIFEST:
				return manifest != null;
			case WorkflowPackage.WORKFLOW__WORKSPACE:
				return workspace != null;
			case WorkflowPackage.WORKFLOW__DIRECTOR:
				return director != null && !director.isEmpty();
			case WorkflowPackage.WORKFLOW__SYMBEX_OPTION:
				return symbexOption != null;
			case WorkflowPackage.WORKFLOW__CONSOLE:
				return console != null;
			case WorkflowPackage.WORKFLOW__SHELL_MODE:
				return shellMode != null;
			case WorkflowPackage.WORKFLOW__DEVELOPER_TUNING:
				return developerTuning != null;
		}
		return super.eIsSet(featureID);
	}

} //WorkflowImpl
