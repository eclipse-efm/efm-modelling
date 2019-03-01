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

import org.eclipse.efm.execution.core.workflow.Serializer;
import org.eclipse.efm.execution.core.workflow.WorkflowPackage;

import org.eclipse.efm.execution.core.workflow.common.TraceSpecification;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Serializer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.impl.SerializerImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.impl.SerializerImpl#getCSS <em>CSS</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.impl.SerializerImpl#getTrace <em>Trace</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.impl.SerializerImpl#getFolderName <em>Folder Name</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.impl.SerializerImpl#getFileName <em>File Name</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.impl.SerializerImpl#isEnabledNormalization <em>Enabled Normalization</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.impl.SerializerImpl#isEnabledInitialValuesPrinting <em>Enabled Initial Values Printing</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.impl.SerializerImpl#isEnabledLifelinesPrinting <em>Enabled Lifelines Printing</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.impl.SerializerImpl#isEnabledModifiedDataSelection <em>Enabled Modified Data Selection</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SerializerImpl extends WorkerImpl implements Serializer {
	/**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected TraceSpecification format;

	/**
	 * The cached value of the '{@link #getCSS() <em>CSS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCSS()
	 * @generated
	 * @ordered
	 */
	protected TraceSpecification css;

	/**
	 * The cached value of the '{@link #getTrace() <em>Trace</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrace()
	 * @generated
	 * @ordered
	 */
	protected TraceSpecification trace;

	/**
	 * The default value of the '{@link #getFolderName() <em>Folder Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFolderName()
	 * @generated
	 * @ordered
	 */
	protected static final String FOLDER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFolderName() <em>Folder Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFolderName()
	 * @generated
	 * @ordered
	 */
	protected String folderName = FOLDER_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFileName() <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileName() <em>File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileName()
	 * @generated
	 * @ordered
	 */
	protected String fileName = FILE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledNormalization() <em>Enabled Normalization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledNormalization()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_NORMALIZATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledNormalization() <em>Enabled Normalization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledNormalization()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledNormalization = ENABLED_NORMALIZATION_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledInitialValuesPrinting() <em>Enabled Initial Values Printing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledInitialValuesPrinting()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_INITIAL_VALUES_PRINTING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledInitialValuesPrinting() <em>Enabled Initial Values Printing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledInitialValuesPrinting()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledInitialValuesPrinting = ENABLED_INITIAL_VALUES_PRINTING_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledLifelinesPrinting() <em>Enabled Lifelines Printing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledLifelinesPrinting()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_LIFELINES_PRINTING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledLifelinesPrinting() <em>Enabled Lifelines Printing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledLifelinesPrinting()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledLifelinesPrinting = ENABLED_LIFELINES_PRINTING_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledModifiedDataSelection() <em>Enabled Modified Data Selection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledModifiedDataSelection()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_MODIFIED_DATA_SELECTION_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabledModifiedDataSelection() <em>Enabled Modified Data Selection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledModifiedDataSelection()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledModifiedDataSelection = ENABLED_MODIFIED_DATA_SELECTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SerializerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.SERIALIZER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TraceSpecification getFormat() {
		return format;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFormat(TraceSpecification newFormat, NotificationChain msgs) {
		TraceSpecification oldFormat = format;
		format = newFormat;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.SERIALIZER__FORMAT, oldFormat, newFormat);
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
	public void setFormat(TraceSpecification newFormat) {
		if (newFormat != format) {
			NotificationChain msgs = null;
			if (format != null)
				msgs = ((InternalEObject)format).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.SERIALIZER__FORMAT, null, msgs);
			if (newFormat != null)
				msgs = ((InternalEObject)newFormat).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.SERIALIZER__FORMAT, null, msgs);
			msgs = basicSetFormat(newFormat, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.SERIALIZER__FORMAT, newFormat, newFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TraceSpecification getCSS() {
		return css;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCSS(TraceSpecification newCSS, NotificationChain msgs) {
		TraceSpecification oldCSS = css;
		css = newCSS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.SERIALIZER__CSS, oldCSS, newCSS);
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
	public void setCSS(TraceSpecification newCSS) {
		if (newCSS != css) {
			NotificationChain msgs = null;
			if (css != null)
				msgs = ((InternalEObject)css).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.SERIALIZER__CSS, null, msgs);
			if (newCSS != null)
				msgs = ((InternalEObject)newCSS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.SERIALIZER__CSS, null, msgs);
			msgs = basicSetCSS(newCSS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.SERIALIZER__CSS, newCSS, newCSS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TraceSpecification getTrace() {
		return trace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTrace(TraceSpecification newTrace, NotificationChain msgs) {
		TraceSpecification oldTrace = trace;
		trace = newTrace;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.SERIALIZER__TRACE, oldTrace, newTrace);
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
	public void setTrace(TraceSpecification newTrace) {
		if (newTrace != trace) {
			NotificationChain msgs = null;
			if (trace != null)
				msgs = ((InternalEObject)trace).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.SERIALIZER__TRACE, null, msgs);
			if (newTrace != null)
				msgs = ((InternalEObject)newTrace).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.SERIALIZER__TRACE, null, msgs);
			msgs = basicSetTrace(newTrace, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.SERIALIZER__TRACE, newTrace, newTrace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFolderName() {
		return folderName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFolderName(String newFolderName) {
		String oldFolderName = folderName;
		folderName = newFolderName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.SERIALIZER__FOLDER_NAME, oldFolderName, folderName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFileName() {
		return fileName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFileName(String newFileName) {
		String oldFileName = fileName;
		fileName = newFileName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.SERIALIZER__FILE_NAME, oldFileName, fileName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabledNormalization() {
		return enabledNormalization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabledNormalization(boolean newEnabledNormalization) {
		boolean oldEnabledNormalization = enabledNormalization;
		enabledNormalization = newEnabledNormalization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.SERIALIZER__ENABLED_NORMALIZATION, oldEnabledNormalization, enabledNormalization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabledInitialValuesPrinting() {
		return enabledInitialValuesPrinting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabledInitialValuesPrinting(boolean newEnabledInitialValuesPrinting) {
		boolean oldEnabledInitialValuesPrinting = enabledInitialValuesPrinting;
		enabledInitialValuesPrinting = newEnabledInitialValuesPrinting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.SERIALIZER__ENABLED_INITIAL_VALUES_PRINTING, oldEnabledInitialValuesPrinting, enabledInitialValuesPrinting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabledLifelinesPrinting() {
		return enabledLifelinesPrinting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabledLifelinesPrinting(boolean newEnabledLifelinesPrinting) {
		boolean oldEnabledLifelinesPrinting = enabledLifelinesPrinting;
		enabledLifelinesPrinting = newEnabledLifelinesPrinting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.SERIALIZER__ENABLED_LIFELINES_PRINTING, oldEnabledLifelinesPrinting, enabledLifelinesPrinting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabledModifiedDataSelection() {
		return enabledModifiedDataSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabledModifiedDataSelection(boolean newEnabledModifiedDataSelection) {
		boolean oldEnabledModifiedDataSelection = enabledModifiedDataSelection;
		enabledModifiedDataSelection = newEnabledModifiedDataSelection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.SERIALIZER__ENABLED_MODIFIED_DATA_SELECTION, oldEnabledModifiedDataSelection, enabledModifiedDataSelection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowPackage.SERIALIZER__FORMAT:
				return basicSetFormat(null, msgs);
			case WorkflowPackage.SERIALIZER__CSS:
				return basicSetCSS(null, msgs);
			case WorkflowPackage.SERIALIZER__TRACE:
				return basicSetTrace(null, msgs);
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
			case WorkflowPackage.SERIALIZER__FORMAT:
				return getFormat();
			case WorkflowPackage.SERIALIZER__CSS:
				return getCSS();
			case WorkflowPackage.SERIALIZER__TRACE:
				return getTrace();
			case WorkflowPackage.SERIALIZER__FOLDER_NAME:
				return getFolderName();
			case WorkflowPackage.SERIALIZER__FILE_NAME:
				return getFileName();
			case WorkflowPackage.SERIALIZER__ENABLED_NORMALIZATION:
				return isEnabledNormalization();
			case WorkflowPackage.SERIALIZER__ENABLED_INITIAL_VALUES_PRINTING:
				return isEnabledInitialValuesPrinting();
			case WorkflowPackage.SERIALIZER__ENABLED_LIFELINES_PRINTING:
				return isEnabledLifelinesPrinting();
			case WorkflowPackage.SERIALIZER__ENABLED_MODIFIED_DATA_SELECTION:
				return isEnabledModifiedDataSelection();
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
			case WorkflowPackage.SERIALIZER__FORMAT:
				setFormat((TraceSpecification)newValue);
				return;
			case WorkflowPackage.SERIALIZER__CSS:
				setCSS((TraceSpecification)newValue);
				return;
			case WorkflowPackage.SERIALIZER__TRACE:
				setTrace((TraceSpecification)newValue);
				return;
			case WorkflowPackage.SERIALIZER__FOLDER_NAME:
				setFolderName((String)newValue);
				return;
			case WorkflowPackage.SERIALIZER__FILE_NAME:
				setFileName((String)newValue);
				return;
			case WorkflowPackage.SERIALIZER__ENABLED_NORMALIZATION:
				setEnabledNormalization((Boolean)newValue);
				return;
			case WorkflowPackage.SERIALIZER__ENABLED_INITIAL_VALUES_PRINTING:
				setEnabledInitialValuesPrinting((Boolean)newValue);
				return;
			case WorkflowPackage.SERIALIZER__ENABLED_LIFELINES_PRINTING:
				setEnabledLifelinesPrinting((Boolean)newValue);
				return;
			case WorkflowPackage.SERIALIZER__ENABLED_MODIFIED_DATA_SELECTION:
				setEnabledModifiedDataSelection((Boolean)newValue);
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
			case WorkflowPackage.SERIALIZER__FORMAT:
				setFormat((TraceSpecification)null);
				return;
			case WorkflowPackage.SERIALIZER__CSS:
				setCSS((TraceSpecification)null);
				return;
			case WorkflowPackage.SERIALIZER__TRACE:
				setTrace((TraceSpecification)null);
				return;
			case WorkflowPackage.SERIALIZER__FOLDER_NAME:
				setFolderName(FOLDER_NAME_EDEFAULT);
				return;
			case WorkflowPackage.SERIALIZER__FILE_NAME:
				setFileName(FILE_NAME_EDEFAULT);
				return;
			case WorkflowPackage.SERIALIZER__ENABLED_NORMALIZATION:
				setEnabledNormalization(ENABLED_NORMALIZATION_EDEFAULT);
				return;
			case WorkflowPackage.SERIALIZER__ENABLED_INITIAL_VALUES_PRINTING:
				setEnabledInitialValuesPrinting(ENABLED_INITIAL_VALUES_PRINTING_EDEFAULT);
				return;
			case WorkflowPackage.SERIALIZER__ENABLED_LIFELINES_PRINTING:
				setEnabledLifelinesPrinting(ENABLED_LIFELINES_PRINTING_EDEFAULT);
				return;
			case WorkflowPackage.SERIALIZER__ENABLED_MODIFIED_DATA_SELECTION:
				setEnabledModifiedDataSelection(ENABLED_MODIFIED_DATA_SELECTION_EDEFAULT);
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
			case WorkflowPackage.SERIALIZER__FORMAT:
				return format != null;
			case WorkflowPackage.SERIALIZER__CSS:
				return css != null;
			case WorkflowPackage.SERIALIZER__TRACE:
				return trace != null;
			case WorkflowPackage.SERIALIZER__FOLDER_NAME:
				return FOLDER_NAME_EDEFAULT == null ? folderName != null : !FOLDER_NAME_EDEFAULT.equals(folderName);
			case WorkflowPackage.SERIALIZER__FILE_NAME:
				return FILE_NAME_EDEFAULT == null ? fileName != null : !FILE_NAME_EDEFAULT.equals(fileName);
			case WorkflowPackage.SERIALIZER__ENABLED_NORMALIZATION:
				return enabledNormalization != ENABLED_NORMALIZATION_EDEFAULT;
			case WorkflowPackage.SERIALIZER__ENABLED_INITIAL_VALUES_PRINTING:
				return enabledInitialValuesPrinting != ENABLED_INITIAL_VALUES_PRINTING_EDEFAULT;
			case WorkflowPackage.SERIALIZER__ENABLED_LIFELINES_PRINTING:
				return enabledLifelinesPrinting != ENABLED_LIFELINES_PRINTING_EDEFAULT;
			case WorkflowPackage.SERIALIZER__ENABLED_MODIFIED_DATA_SELECTION:
				return enabledModifiedDataSelection != ENABLED_MODIFIED_DATA_SELECTION_EDEFAULT;
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
		result.append(" (folderName: ");
		result.append(folderName);
		result.append(", fileName: ");
		result.append(fileName);
		result.append(", enabledNormalization: ");
		result.append(enabledNormalization);
		result.append(", enabledInitialValuesPrinting: ");
		result.append(enabledInitialValuesPrinting);
		result.append(", enabledLifelinesPrinting: ");
		result.append(enabledLifelinesPrinting);
		result.append(", enabledModifiedDataSelection: ");
		result.append(enabledModifiedDataSelection);
		result.append(')');
		return result.toString();
	}

} //SerializerImpl
