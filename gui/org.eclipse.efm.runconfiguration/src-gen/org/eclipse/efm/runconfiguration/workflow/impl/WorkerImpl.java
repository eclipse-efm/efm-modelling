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

import org.eclipse.efm.runconfiguration.workflow.Director;
import org.eclipse.efm.runconfiguration.workflow.Worker;
import org.eclipse.efm.runconfiguration.workflow.WorkflowPackage;
import org.eclipse.efm.runconfiguration.workflow.common.ConsoleLogFormat;
import org.eclipse.efm.runconfiguration.workflow.common.Manifest;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Worker</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.impl.WorkerImpl#getManifest <em>Manifest</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.impl.WorkerImpl#getDirector <em>Director</em>}</li>
 *   <li>{@link org.eclipse.efm.runconfiguration.workflow.impl.WorkerImpl#getConsole <em>Console</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WorkerImpl extends NamedObjectImpl implements Worker {
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
	 * The cached value of the '{@link #getDirector() <em>Director</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirector()
	 * @generated
	 * @ordered
	 */
	protected Director director;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.WORKER;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKER__MANIFEST, oldManifest, newManifest);
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
				msgs = ((InternalEObject)manifest).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKER__MANIFEST, null, msgs);
			if (newManifest != null)
				msgs = ((InternalEObject)newManifest).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKER__MANIFEST, null, msgs);
			msgs = basicSetManifest(newManifest, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKER__MANIFEST, newManifest, newManifest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Director getDirector() {
		if (director != null && director.eIsProxy()) {
			InternalEObject oldDirector = (InternalEObject)director;
			director = (Director)eResolveProxy(oldDirector);
			if (director != oldDirector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowPackage.WORKER__DIRECTOR, oldDirector, director));
			}
		}
		return director;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Director basicGetDirector() {
		return director;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirector(Director newDirector) {
		Director oldDirector = director;
		director = newDirector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKER__DIRECTOR, oldDirector, director));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKER__CONSOLE, oldConsole, newConsole);
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
				msgs = ((InternalEObject)console).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKER__CONSOLE, null, msgs);
			if (newConsole != null)
				msgs = ((InternalEObject)newConsole).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.WORKER__CONSOLE, null, msgs);
			msgs = basicSetConsole(newConsole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.WORKER__CONSOLE, newConsole, newConsole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowPackage.WORKER__MANIFEST:
				return basicSetManifest(null, msgs);
			case WorkflowPackage.WORKER__CONSOLE:
				return basicSetConsole(null, msgs);
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
			case WorkflowPackage.WORKER__MANIFEST:
				return getManifest();
			case WorkflowPackage.WORKER__DIRECTOR:
				if (resolve) return getDirector();
				return basicGetDirector();
			case WorkflowPackage.WORKER__CONSOLE:
				return getConsole();
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
			case WorkflowPackage.WORKER__MANIFEST:
				setManifest((Manifest)newValue);
				return;
			case WorkflowPackage.WORKER__DIRECTOR:
				setDirector((Director)newValue);
				return;
			case WorkflowPackage.WORKER__CONSOLE:
				setConsole((ConsoleLogFormat)newValue);
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
			case WorkflowPackage.WORKER__MANIFEST:
				setManifest((Manifest)null);
				return;
			case WorkflowPackage.WORKER__DIRECTOR:
				setDirector((Director)null);
				return;
			case WorkflowPackage.WORKER__CONSOLE:
				setConsole((ConsoleLogFormat)null);
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
			case WorkflowPackage.WORKER__MANIFEST:
				return manifest != null;
			case WorkflowPackage.WORKER__DIRECTOR:
				return director != null;
			case WorkflowPackage.WORKER__CONSOLE:
				return console != null;
		}
		return super.eIsSet(featureID);
	}

} //WorkerImpl
