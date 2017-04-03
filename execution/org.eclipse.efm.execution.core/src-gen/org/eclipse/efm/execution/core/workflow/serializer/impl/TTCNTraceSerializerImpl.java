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
package org.eclipse.efm.execution.core.workflow.serializer.impl;

import org.eclipse.efm.execution.core.workflow.impl.SerializerImpl;

import org.eclipse.efm.execution.core.workflow.serializer.SerializerPackage;
import org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TTCN Trace Serializer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.serializer.impl.TTCNTraceSerializerImpl#isEnabledCustomization <em>Enabled Customization</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.serializer.impl.TTCNTraceSerializerImpl#isEnabledAdapters <em>Enabled Adapters</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.serializer.impl.TTCNTraceSerializerImpl#getControlModuleName <em>Control Module Name</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.serializer.impl.TTCNTraceSerializerImpl#getDeclarationsModuleName <em>Declarations Module Name</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.serializer.impl.TTCNTraceSerializerImpl#getTemplatesModuleName <em>Templates Module Name</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.serializer.impl.TTCNTraceSerializerImpl#getTestcasesModuleName <em>Testcases Module Name</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.serializer.impl.TTCNTraceSerializerImpl#getTestcasesStartingWrapper <em>Testcases Starting Wrapper</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.serializer.impl.TTCNTraceSerializerImpl#getTestcasesEndingWrapper <em>Testcases Ending Wrapper</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.serializer.impl.TTCNTraceSerializerImpl#getTestcasesSendingWrapper <em>Testcases Sending Wrapper</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.serializer.impl.TTCNTraceSerializerImpl#getTestcasesReceivingWrapper <em>Testcases Receiving Wrapper</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.serializer.impl.TTCNTraceSerializerImpl#getAdaptationModuleName <em>Adaptation Module Name</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.serializer.impl.TTCNTraceSerializerImpl#getAdaptationUtilsImpl <em>Adaptation Utils Impl</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.serializer.impl.TTCNTraceSerializerImpl#getAdaptationStartingEndingImpl <em>Adaptation Starting Ending Impl</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.serializer.impl.TTCNTraceSerializerImpl#getAdaptationSendingImpl <em>Adaptation Sending Impl</em>}</li>
 *   <li>{@link org.eclipse.efm.execution.core.workflow.serializer.impl.TTCNTraceSerializerImpl#getAdaptationReceivingImpl <em>Adaptation Receiving Impl</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TTCNTraceSerializerImpl extends SerializerImpl implements TTCNTraceSerializer {
	/**
	 * The default value of the '{@link #isEnabledCustomization() <em>Enabled Customization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledCustomization()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_CUSTOMIZATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledCustomization() <em>Enabled Customization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledCustomization()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledCustomization = ENABLED_CUSTOMIZATION_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabledAdapters() <em>Enabled Adapters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledAdapters()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_ADAPTERS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnabledAdapters() <em>Enabled Adapters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabledAdapters()
	 * @generated
	 * @ordered
	 */
	protected boolean enabledAdapters = ENABLED_ADAPTERS_EDEFAULT;

	/**
	 * The default value of the '{@link #getControlModuleName() <em>Control Module Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlModuleName()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTROL_MODULE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getControlModuleName() <em>Control Module Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlModuleName()
	 * @generated
	 * @ordered
	 */
	protected String controlModuleName = CONTROL_MODULE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDeclarationsModuleName() <em>Declarations Module Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclarationsModuleName()
	 * @generated
	 * @ordered
	 */
	protected static final String DECLARATIONS_MODULE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDeclarationsModuleName() <em>Declarations Module Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclarationsModuleName()
	 * @generated
	 * @ordered
	 */
	protected String declarationsModuleName = DECLARATIONS_MODULE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTemplatesModuleName() <em>Templates Module Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplatesModuleName()
	 * @generated
	 * @ordered
	 */
	protected static final String TEMPLATES_MODULE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTemplatesModuleName() <em>Templates Module Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplatesModuleName()
	 * @generated
	 * @ordered
	 */
	protected String templatesModuleName = TEMPLATES_MODULE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTestcasesModuleName() <em>Testcases Module Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestcasesModuleName()
	 * @generated
	 * @ordered
	 */
	protected static final String TESTCASES_MODULE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTestcasesModuleName() <em>Testcases Module Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestcasesModuleName()
	 * @generated
	 * @ordered
	 */
	protected String testcasesModuleName = TESTCASES_MODULE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTestcasesStartingWrapper() <em>Testcases Starting Wrapper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestcasesStartingWrapper()
	 * @generated
	 * @ordered
	 */
	protected static final String TESTCASES_STARTING_WRAPPER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTestcasesStartingWrapper() <em>Testcases Starting Wrapper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestcasesStartingWrapper()
	 * @generated
	 * @ordered
	 */
	protected String testcasesStartingWrapper = TESTCASES_STARTING_WRAPPER_EDEFAULT;

	/**
	 * The default value of the '{@link #getTestcasesEndingWrapper() <em>Testcases Ending Wrapper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestcasesEndingWrapper()
	 * @generated
	 * @ordered
	 */
	protected static final String TESTCASES_ENDING_WRAPPER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTestcasesEndingWrapper() <em>Testcases Ending Wrapper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestcasesEndingWrapper()
	 * @generated
	 * @ordered
	 */
	protected String testcasesEndingWrapper = TESTCASES_ENDING_WRAPPER_EDEFAULT;

	/**
	 * The default value of the '{@link #getTestcasesSendingWrapper() <em>Testcases Sending Wrapper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestcasesSendingWrapper()
	 * @generated
	 * @ordered
	 */
	protected static final String TESTCASES_SENDING_WRAPPER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTestcasesSendingWrapper() <em>Testcases Sending Wrapper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestcasesSendingWrapper()
	 * @generated
	 * @ordered
	 */
	protected String testcasesSendingWrapper = TESTCASES_SENDING_WRAPPER_EDEFAULT;

	/**
	 * The default value of the '{@link #getTestcasesReceivingWrapper() <em>Testcases Receiving Wrapper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestcasesReceivingWrapper()
	 * @generated
	 * @ordered
	 */
	protected static final String TESTCASES_RECEIVING_WRAPPER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTestcasesReceivingWrapper() <em>Testcases Receiving Wrapper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestcasesReceivingWrapper()
	 * @generated
	 * @ordered
	 */
	protected String testcasesReceivingWrapper = TESTCASES_RECEIVING_WRAPPER_EDEFAULT;

	/**
	 * The default value of the '{@link #getAdaptationModuleName() <em>Adaptation Module Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdaptationModuleName()
	 * @generated
	 * @ordered
	 */
	protected static final String ADAPTATION_MODULE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdaptationModuleName() <em>Adaptation Module Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdaptationModuleName()
	 * @generated
	 * @ordered
	 */
	protected String adaptationModuleName = ADAPTATION_MODULE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getAdaptationUtilsImpl() <em>Adaptation Utils Impl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdaptationUtilsImpl()
	 * @generated
	 * @ordered
	 */
	protected static final String ADAPTATION_UTILS_IMPL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdaptationUtilsImpl() <em>Adaptation Utils Impl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdaptationUtilsImpl()
	 * @generated
	 * @ordered
	 */
	protected String adaptationUtilsImpl = ADAPTATION_UTILS_IMPL_EDEFAULT;

	/**
	 * The default value of the '{@link #getAdaptationStartingEndingImpl() <em>Adaptation Starting Ending Impl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdaptationStartingEndingImpl()
	 * @generated
	 * @ordered
	 */
	protected static final String ADAPTATION_STARTING_ENDING_IMPL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdaptationStartingEndingImpl() <em>Adaptation Starting Ending Impl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdaptationStartingEndingImpl()
	 * @generated
	 * @ordered
	 */
	protected String adaptationStartingEndingImpl = ADAPTATION_STARTING_ENDING_IMPL_EDEFAULT;

	/**
	 * The default value of the '{@link #getAdaptationSendingImpl() <em>Adaptation Sending Impl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdaptationSendingImpl()
	 * @generated
	 * @ordered
	 */
	protected static final String ADAPTATION_SENDING_IMPL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdaptationSendingImpl() <em>Adaptation Sending Impl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdaptationSendingImpl()
	 * @generated
	 * @ordered
	 */
	protected String adaptationSendingImpl = ADAPTATION_SENDING_IMPL_EDEFAULT;

	/**
	 * The default value of the '{@link #getAdaptationReceivingImpl() <em>Adaptation Receiving Impl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdaptationReceivingImpl()
	 * @generated
	 * @ordered
	 */
	protected static final String ADAPTATION_RECEIVING_IMPL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdaptationReceivingImpl() <em>Adaptation Receiving Impl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdaptationReceivingImpl()
	 * @generated
	 * @ordered
	 */
	protected String adaptationReceivingImpl = ADAPTATION_RECEIVING_IMPL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TTCNTraceSerializerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SerializerPackage.Literals.TTCN_TRACE_SERIALIZER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledCustomization() {
		return enabledCustomization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledCustomization(boolean newEnabledCustomization) {
		boolean oldEnabledCustomization = enabledCustomization;
		enabledCustomization = newEnabledCustomization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SerializerPackage.TTCN_TRACE_SERIALIZER__ENABLED_CUSTOMIZATION, oldEnabledCustomization, enabledCustomization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnabledAdapters() {
		return enabledAdapters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnabledAdapters(boolean newEnabledAdapters) {
		boolean oldEnabledAdapters = enabledAdapters;
		enabledAdapters = newEnabledAdapters;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SerializerPackage.TTCN_TRACE_SERIALIZER__ENABLED_ADAPTERS, oldEnabledAdapters, enabledAdapters));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getControlModuleName() {
		return controlModuleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlModuleName(String newControlModuleName) {
		String oldControlModuleName = controlModuleName;
		controlModuleName = newControlModuleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SerializerPackage.TTCN_TRACE_SERIALIZER__CONTROL_MODULE_NAME, oldControlModuleName, controlModuleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDeclarationsModuleName() {
		return declarationsModuleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclarationsModuleName(String newDeclarationsModuleName) {
		String oldDeclarationsModuleName = declarationsModuleName;
		declarationsModuleName = newDeclarationsModuleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SerializerPackage.TTCN_TRACE_SERIALIZER__DECLARATIONS_MODULE_NAME, oldDeclarationsModuleName, declarationsModuleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTemplatesModuleName() {
		return templatesModuleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplatesModuleName(String newTemplatesModuleName) {
		String oldTemplatesModuleName = templatesModuleName;
		templatesModuleName = newTemplatesModuleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SerializerPackage.TTCN_TRACE_SERIALIZER__TEMPLATES_MODULE_NAME, oldTemplatesModuleName, templatesModuleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTestcasesModuleName() {
		return testcasesModuleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestcasesModuleName(String newTestcasesModuleName) {
		String oldTestcasesModuleName = testcasesModuleName;
		testcasesModuleName = newTestcasesModuleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_MODULE_NAME, oldTestcasesModuleName, testcasesModuleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTestcasesStartingWrapper() {
		return testcasesStartingWrapper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestcasesStartingWrapper(String newTestcasesStartingWrapper) {
		String oldTestcasesStartingWrapper = testcasesStartingWrapper;
		testcasesStartingWrapper = newTestcasesStartingWrapper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_STARTING_WRAPPER, oldTestcasesStartingWrapper, testcasesStartingWrapper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTestcasesEndingWrapper() {
		return testcasesEndingWrapper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestcasesEndingWrapper(String newTestcasesEndingWrapper) {
		String oldTestcasesEndingWrapper = testcasesEndingWrapper;
		testcasesEndingWrapper = newTestcasesEndingWrapper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_ENDING_WRAPPER, oldTestcasesEndingWrapper, testcasesEndingWrapper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTestcasesSendingWrapper() {
		return testcasesSendingWrapper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestcasesSendingWrapper(String newTestcasesSendingWrapper) {
		String oldTestcasesSendingWrapper = testcasesSendingWrapper;
		testcasesSendingWrapper = newTestcasesSendingWrapper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_SENDING_WRAPPER, oldTestcasesSendingWrapper, testcasesSendingWrapper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTestcasesReceivingWrapper() {
		return testcasesReceivingWrapper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestcasesReceivingWrapper(String newTestcasesReceivingWrapper) {
		String oldTestcasesReceivingWrapper = testcasesReceivingWrapper;
		testcasesReceivingWrapper = newTestcasesReceivingWrapper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_RECEIVING_WRAPPER, oldTestcasesReceivingWrapper, testcasesReceivingWrapper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdaptationModuleName() {
		return adaptationModuleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdaptationModuleName(String newAdaptationModuleName) {
		String oldAdaptationModuleName = adaptationModuleName;
		adaptationModuleName = newAdaptationModuleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_MODULE_NAME, oldAdaptationModuleName, adaptationModuleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdaptationUtilsImpl() {
		return adaptationUtilsImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdaptationUtilsImpl(String newAdaptationUtilsImpl) {
		String oldAdaptationUtilsImpl = adaptationUtilsImpl;
		adaptationUtilsImpl = newAdaptationUtilsImpl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_UTILS_IMPL, oldAdaptationUtilsImpl, adaptationUtilsImpl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdaptationStartingEndingImpl() {
		return adaptationStartingEndingImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdaptationStartingEndingImpl(String newAdaptationStartingEndingImpl) {
		String oldAdaptationStartingEndingImpl = adaptationStartingEndingImpl;
		adaptationStartingEndingImpl = newAdaptationStartingEndingImpl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_STARTING_ENDING_IMPL, oldAdaptationStartingEndingImpl, adaptationStartingEndingImpl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdaptationSendingImpl() {
		return adaptationSendingImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdaptationSendingImpl(String newAdaptationSendingImpl) {
		String oldAdaptationSendingImpl = adaptationSendingImpl;
		adaptationSendingImpl = newAdaptationSendingImpl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_SENDING_IMPL, oldAdaptationSendingImpl, adaptationSendingImpl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdaptationReceivingImpl() {
		return adaptationReceivingImpl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdaptationReceivingImpl(String newAdaptationReceivingImpl) {
		String oldAdaptationReceivingImpl = adaptationReceivingImpl;
		adaptationReceivingImpl = newAdaptationReceivingImpl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_RECEIVING_IMPL, oldAdaptationReceivingImpl, adaptationReceivingImpl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ENABLED_CUSTOMIZATION:
				return isEnabledCustomization();
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ENABLED_ADAPTERS:
				return isEnabledAdapters();
			case SerializerPackage.TTCN_TRACE_SERIALIZER__CONTROL_MODULE_NAME:
				return getControlModuleName();
			case SerializerPackage.TTCN_TRACE_SERIALIZER__DECLARATIONS_MODULE_NAME:
				return getDeclarationsModuleName();
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TEMPLATES_MODULE_NAME:
				return getTemplatesModuleName();
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_MODULE_NAME:
				return getTestcasesModuleName();
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_STARTING_WRAPPER:
				return getTestcasesStartingWrapper();
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_ENDING_WRAPPER:
				return getTestcasesEndingWrapper();
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_SENDING_WRAPPER:
				return getTestcasesSendingWrapper();
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_RECEIVING_WRAPPER:
				return getTestcasesReceivingWrapper();
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_MODULE_NAME:
				return getAdaptationModuleName();
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_UTILS_IMPL:
				return getAdaptationUtilsImpl();
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_STARTING_ENDING_IMPL:
				return getAdaptationStartingEndingImpl();
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_SENDING_IMPL:
				return getAdaptationSendingImpl();
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_RECEIVING_IMPL:
				return getAdaptationReceivingImpl();
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
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ENABLED_CUSTOMIZATION:
				setEnabledCustomization((Boolean)newValue);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ENABLED_ADAPTERS:
				setEnabledAdapters((Boolean)newValue);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__CONTROL_MODULE_NAME:
				setControlModuleName((String)newValue);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__DECLARATIONS_MODULE_NAME:
				setDeclarationsModuleName((String)newValue);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TEMPLATES_MODULE_NAME:
				setTemplatesModuleName((String)newValue);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_MODULE_NAME:
				setTestcasesModuleName((String)newValue);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_STARTING_WRAPPER:
				setTestcasesStartingWrapper((String)newValue);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_ENDING_WRAPPER:
				setTestcasesEndingWrapper((String)newValue);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_SENDING_WRAPPER:
				setTestcasesSendingWrapper((String)newValue);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_RECEIVING_WRAPPER:
				setTestcasesReceivingWrapper((String)newValue);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_MODULE_NAME:
				setAdaptationModuleName((String)newValue);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_UTILS_IMPL:
				setAdaptationUtilsImpl((String)newValue);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_STARTING_ENDING_IMPL:
				setAdaptationStartingEndingImpl((String)newValue);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_SENDING_IMPL:
				setAdaptationSendingImpl((String)newValue);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_RECEIVING_IMPL:
				setAdaptationReceivingImpl((String)newValue);
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
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ENABLED_CUSTOMIZATION:
				setEnabledCustomization(ENABLED_CUSTOMIZATION_EDEFAULT);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ENABLED_ADAPTERS:
				setEnabledAdapters(ENABLED_ADAPTERS_EDEFAULT);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__CONTROL_MODULE_NAME:
				setControlModuleName(CONTROL_MODULE_NAME_EDEFAULT);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__DECLARATIONS_MODULE_NAME:
				setDeclarationsModuleName(DECLARATIONS_MODULE_NAME_EDEFAULT);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TEMPLATES_MODULE_NAME:
				setTemplatesModuleName(TEMPLATES_MODULE_NAME_EDEFAULT);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_MODULE_NAME:
				setTestcasesModuleName(TESTCASES_MODULE_NAME_EDEFAULT);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_STARTING_WRAPPER:
				setTestcasesStartingWrapper(TESTCASES_STARTING_WRAPPER_EDEFAULT);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_ENDING_WRAPPER:
				setTestcasesEndingWrapper(TESTCASES_ENDING_WRAPPER_EDEFAULT);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_SENDING_WRAPPER:
				setTestcasesSendingWrapper(TESTCASES_SENDING_WRAPPER_EDEFAULT);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_RECEIVING_WRAPPER:
				setTestcasesReceivingWrapper(TESTCASES_RECEIVING_WRAPPER_EDEFAULT);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_MODULE_NAME:
				setAdaptationModuleName(ADAPTATION_MODULE_NAME_EDEFAULT);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_UTILS_IMPL:
				setAdaptationUtilsImpl(ADAPTATION_UTILS_IMPL_EDEFAULT);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_STARTING_ENDING_IMPL:
				setAdaptationStartingEndingImpl(ADAPTATION_STARTING_ENDING_IMPL_EDEFAULT);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_SENDING_IMPL:
				setAdaptationSendingImpl(ADAPTATION_SENDING_IMPL_EDEFAULT);
				return;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_RECEIVING_IMPL:
				setAdaptationReceivingImpl(ADAPTATION_RECEIVING_IMPL_EDEFAULT);
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
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ENABLED_CUSTOMIZATION:
				return enabledCustomization != ENABLED_CUSTOMIZATION_EDEFAULT;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ENABLED_ADAPTERS:
				return enabledAdapters != ENABLED_ADAPTERS_EDEFAULT;
			case SerializerPackage.TTCN_TRACE_SERIALIZER__CONTROL_MODULE_NAME:
				return CONTROL_MODULE_NAME_EDEFAULT == null ? controlModuleName != null : !CONTROL_MODULE_NAME_EDEFAULT.equals(controlModuleName);
			case SerializerPackage.TTCN_TRACE_SERIALIZER__DECLARATIONS_MODULE_NAME:
				return DECLARATIONS_MODULE_NAME_EDEFAULT == null ? declarationsModuleName != null : !DECLARATIONS_MODULE_NAME_EDEFAULT.equals(declarationsModuleName);
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TEMPLATES_MODULE_NAME:
				return TEMPLATES_MODULE_NAME_EDEFAULT == null ? templatesModuleName != null : !TEMPLATES_MODULE_NAME_EDEFAULT.equals(templatesModuleName);
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_MODULE_NAME:
				return TESTCASES_MODULE_NAME_EDEFAULT == null ? testcasesModuleName != null : !TESTCASES_MODULE_NAME_EDEFAULT.equals(testcasesModuleName);
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_STARTING_WRAPPER:
				return TESTCASES_STARTING_WRAPPER_EDEFAULT == null ? testcasesStartingWrapper != null : !TESTCASES_STARTING_WRAPPER_EDEFAULT.equals(testcasesStartingWrapper);
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_ENDING_WRAPPER:
				return TESTCASES_ENDING_WRAPPER_EDEFAULT == null ? testcasesEndingWrapper != null : !TESTCASES_ENDING_WRAPPER_EDEFAULT.equals(testcasesEndingWrapper);
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_SENDING_WRAPPER:
				return TESTCASES_SENDING_WRAPPER_EDEFAULT == null ? testcasesSendingWrapper != null : !TESTCASES_SENDING_WRAPPER_EDEFAULT.equals(testcasesSendingWrapper);
			case SerializerPackage.TTCN_TRACE_SERIALIZER__TESTCASES_RECEIVING_WRAPPER:
				return TESTCASES_RECEIVING_WRAPPER_EDEFAULT == null ? testcasesReceivingWrapper != null : !TESTCASES_RECEIVING_WRAPPER_EDEFAULT.equals(testcasesReceivingWrapper);
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_MODULE_NAME:
				return ADAPTATION_MODULE_NAME_EDEFAULT == null ? adaptationModuleName != null : !ADAPTATION_MODULE_NAME_EDEFAULT.equals(adaptationModuleName);
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_UTILS_IMPL:
				return ADAPTATION_UTILS_IMPL_EDEFAULT == null ? adaptationUtilsImpl != null : !ADAPTATION_UTILS_IMPL_EDEFAULT.equals(adaptationUtilsImpl);
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_STARTING_ENDING_IMPL:
				return ADAPTATION_STARTING_ENDING_IMPL_EDEFAULT == null ? adaptationStartingEndingImpl != null : !ADAPTATION_STARTING_ENDING_IMPL_EDEFAULT.equals(adaptationStartingEndingImpl);
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_SENDING_IMPL:
				return ADAPTATION_SENDING_IMPL_EDEFAULT == null ? adaptationSendingImpl != null : !ADAPTATION_SENDING_IMPL_EDEFAULT.equals(adaptationSendingImpl);
			case SerializerPackage.TTCN_TRACE_SERIALIZER__ADAPTATION_RECEIVING_IMPL:
				return ADAPTATION_RECEIVING_IMPL_EDEFAULT == null ? adaptationReceivingImpl != null : !ADAPTATION_RECEIVING_IMPL_EDEFAULT.equals(adaptationReceivingImpl);
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (enabledCustomization: ");
		result.append(enabledCustomization);
		result.append(", enabledAdapters: ");
		result.append(enabledAdapters);
		result.append(", controlModuleName: ");
		result.append(controlModuleName);
		result.append(", declarationsModuleName: ");
		result.append(declarationsModuleName);
		result.append(", templatesModuleName: ");
		result.append(templatesModuleName);
		result.append(", testcasesModuleName: ");
		result.append(testcasesModuleName);
		result.append(", testcasesStartingWrapper: ");
		result.append(testcasesStartingWrapper);
		result.append(", testcasesEndingWrapper: ");
		result.append(testcasesEndingWrapper);
		result.append(", testcasesSendingWrapper: ");
		result.append(testcasesSendingWrapper);
		result.append(", testcasesReceivingWrapper: ");
		result.append(testcasesReceivingWrapper);
		result.append(", adaptationModuleName: ");
		result.append(adaptationModuleName);
		result.append(", adaptationUtilsImpl: ");
		result.append(adaptationUtilsImpl);
		result.append(", adaptationStartingEndingImpl: ");
		result.append(adaptationStartingEndingImpl);
		result.append(", adaptationSendingImpl: ");
		result.append(adaptationSendingImpl);
		result.append(", adaptationReceivingImpl: ");
		result.append(adaptationReceivingImpl);
		result.append(')');
		return result.toString();
	}

} //TTCNTraceSerializerImpl
