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
package org.eclipse.efm.runconfiguration.workflow.impl;

import java.util.Collection;

import org.eclipse.efm.runconfiguration.workflow.Director;
import org.eclipse.efm.runconfiguration.workflow.SupervisorWorker;
import org.eclipse.efm.runconfiguration.workflow.Worker;
import org.eclipse.efm.runconfiguration.workflow.Workflow;
import org.eclipse.efm.runconfiguration.workflow.WorkflowPackage;
import org.eclipse.efm.runconfiguration.workflow.common.ConsoleLogFormat;
import org.eclipse.efm.runconfiguration.workflow.common.DeveloperTuningOption;
import org.eclipse.efm.runconfiguration.workflow.common.Manifest;
import org.eclipse.efm.runconfiguration.workflow.common.Project;
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
 * An implementation of the model object '<em><b>Director</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.impl.DirectorImpl#getManifest <em>Manifest</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.impl.DirectorImpl#getWorkflow <em>Workflow</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.impl.DirectorImpl#getProject <em>Project</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.impl.DirectorImpl#getSupervisor <em>Supervisor</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.impl.DirectorImpl#getWorker <em>Worker</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.impl.DirectorImpl#getConsole <em>Console</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.impl.DirectorImpl#getDeveloperTuning <em>Developer Tuning</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DirectorImpl extends NamedObjectImpl implements Director {
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
	 * The cached value of the '{@link #getWorkflow() <em>Workflow</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorkflow()
	 * @generated
	 * @ordered
	 */
	protected Workflow workflow;

	/**
	 * The cached value of the '{@link #getProject() <em>Project</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProject()
	 * @generated
	 * @ordered
	 */
	protected Project project;

	/**
	 * The cached value of the '{@link #getSupervisor() <em>Supervisor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupervisor()
	 * @generated
	 * @ordered
	 */
	protected SupervisorWorker supervisor;

	/**
	 * The cached value of the '{@link #getWorker() <em>Worker</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWorker()
	 * @generated
	 * @ordered
	 */
	protected EList<Worker> worker;

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
	protected DirectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.DIRECTOR;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.DIRECTOR__MANIFEST, oldManifest, newManifest);
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
				msgs = ((InternalEObject)manifest).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.DIRECTOR__MANIFEST, null, msgs);
			if (newManifest != null)
				msgs = ((InternalEObject)newManifest).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.DIRECTOR__MANIFEST, null, msgs);
			msgs = basicSetManifest(newManifest, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.DIRECTOR__MANIFEST, newManifest, newManifest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Workflow getWorkflow() {
		if (workflow != null && workflow.eIsProxy()) {
			InternalEObject oldWorkflow = (InternalEObject)workflow;
			workflow = (Workflow)eResolveProxy(oldWorkflow);
			if (workflow != oldWorkflow) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowPackage.DIRECTOR__WORKFLOW, oldWorkflow, workflow));
			}
		}
		return workflow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Workflow basicGetWorkflow() {
		return workflow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorkflow(Workflow newWorkflow) {
		Workflow oldWorkflow = workflow;
		workflow = newWorkflow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.DIRECTOR__WORKFLOW, oldWorkflow, workflow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProject(Project newProject, NotificationChain msgs) {
		Project oldProject = project;
		project = newProject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.DIRECTOR__PROJECT, oldProject, newProject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProject(Project newProject) {
		if (newProject != project) {
			NotificationChain msgs = null;
			if (project != null)
				msgs = ((InternalEObject)project).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.DIRECTOR__PROJECT, null, msgs);
			if (newProject != null)
				msgs = ((InternalEObject)newProject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.DIRECTOR__PROJECT, null, msgs);
			msgs = basicSetProject(newProject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.DIRECTOR__PROJECT, newProject, newProject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SupervisorWorker getSupervisor() {
		return supervisor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSupervisor(SupervisorWorker newSupervisor, NotificationChain msgs) {
		SupervisorWorker oldSupervisor = supervisor;
		supervisor = newSupervisor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.DIRECTOR__SUPERVISOR, oldSupervisor, newSupervisor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSupervisor(SupervisorWorker newSupervisor) {
		if (newSupervisor != supervisor) {
			NotificationChain msgs = null;
			if (supervisor != null)
				msgs = ((InternalEObject)supervisor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.DIRECTOR__SUPERVISOR, null, msgs);
			if (newSupervisor != null)
				msgs = ((InternalEObject)newSupervisor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.DIRECTOR__SUPERVISOR, null, msgs);
			msgs = basicSetSupervisor(newSupervisor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.DIRECTOR__SUPERVISOR, newSupervisor, newSupervisor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Worker> getWorker() {
		if (worker == null) {
			worker = new EObjectContainmentEList<Worker>(Worker.class, this, WorkflowPackage.DIRECTOR__WORKER);
		}
		return worker;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.DIRECTOR__CONSOLE, oldConsole, newConsole);
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
				msgs = ((InternalEObject)console).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.DIRECTOR__CONSOLE, null, msgs);
			if (newConsole != null)
				msgs = ((InternalEObject)newConsole).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.DIRECTOR__CONSOLE, null, msgs);
			msgs = basicSetConsole(newConsole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.DIRECTOR__CONSOLE, newConsole, newConsole));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.DIRECTOR__DEVELOPER_TUNING, oldDeveloperTuning, newDeveloperTuning);
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
				msgs = ((InternalEObject)developerTuning).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.DIRECTOR__DEVELOPER_TUNING, null, msgs);
			if (newDeveloperTuning != null)
				msgs = ((InternalEObject)newDeveloperTuning).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.DIRECTOR__DEVELOPER_TUNING, null, msgs);
			msgs = basicSetDeveloperTuning(newDeveloperTuning, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.DIRECTOR__DEVELOPER_TUNING, newDeveloperTuning, newDeveloperTuning));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowPackage.DIRECTOR__MANIFEST:
				return basicSetManifest(null, msgs);
			case WorkflowPackage.DIRECTOR__PROJECT:
				return basicSetProject(null, msgs);
			case WorkflowPackage.DIRECTOR__SUPERVISOR:
				return basicSetSupervisor(null, msgs);
			case WorkflowPackage.DIRECTOR__WORKER:
				return ((InternalEList<?>)getWorker()).basicRemove(otherEnd, msgs);
			case WorkflowPackage.DIRECTOR__CONSOLE:
				return basicSetConsole(null, msgs);
			case WorkflowPackage.DIRECTOR__DEVELOPER_TUNING:
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
			case WorkflowPackage.DIRECTOR__MANIFEST:
				return getManifest();
			case WorkflowPackage.DIRECTOR__WORKFLOW:
				if (resolve) return getWorkflow();
				return basicGetWorkflow();
			case WorkflowPackage.DIRECTOR__PROJECT:
				return getProject();
			case WorkflowPackage.DIRECTOR__SUPERVISOR:
				return getSupervisor();
			case WorkflowPackage.DIRECTOR__WORKER:
				return getWorker();
			case WorkflowPackage.DIRECTOR__CONSOLE:
				return getConsole();
			case WorkflowPackage.DIRECTOR__DEVELOPER_TUNING:
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
			case WorkflowPackage.DIRECTOR__MANIFEST:
				setManifest((Manifest)newValue);
				return;
			case WorkflowPackage.DIRECTOR__WORKFLOW:
				setWorkflow((Workflow)newValue);
				return;
			case WorkflowPackage.DIRECTOR__PROJECT:
				setProject((Project)newValue);
				return;
			case WorkflowPackage.DIRECTOR__SUPERVISOR:
				setSupervisor((SupervisorWorker)newValue);
				return;
			case WorkflowPackage.DIRECTOR__WORKER:
				getWorker().clear();
				getWorker().addAll((Collection<? extends Worker>)newValue);
				return;
			case WorkflowPackage.DIRECTOR__CONSOLE:
				setConsole((ConsoleLogFormat)newValue);
				return;
			case WorkflowPackage.DIRECTOR__DEVELOPER_TUNING:
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
			case WorkflowPackage.DIRECTOR__MANIFEST:
				setManifest((Manifest)null);
				return;
			case WorkflowPackage.DIRECTOR__WORKFLOW:
				setWorkflow((Workflow)null);
				return;
			case WorkflowPackage.DIRECTOR__PROJECT:
				setProject((Project)null);
				return;
			case WorkflowPackage.DIRECTOR__SUPERVISOR:
				setSupervisor((SupervisorWorker)null);
				return;
			case WorkflowPackage.DIRECTOR__WORKER:
				getWorker().clear();
				return;
			case WorkflowPackage.DIRECTOR__CONSOLE:
				setConsole((ConsoleLogFormat)null);
				return;
			case WorkflowPackage.DIRECTOR__DEVELOPER_TUNING:
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
			case WorkflowPackage.DIRECTOR__MANIFEST:
				return manifest != null;
			case WorkflowPackage.DIRECTOR__WORKFLOW:
				return workflow != null;
			case WorkflowPackage.DIRECTOR__PROJECT:
				return project != null;
			case WorkflowPackage.DIRECTOR__SUPERVISOR:
				return supervisor != null;
			case WorkflowPackage.DIRECTOR__WORKER:
				return worker != null && !worker.isEmpty();
			case WorkflowPackage.DIRECTOR__CONSOLE:
				return console != null;
			case WorkflowPackage.DIRECTOR__DEVELOPER_TUNING:
				return developerTuning != null;
		}
		return super.eIsSet(featureID);
	}

} //DirectorImpl
