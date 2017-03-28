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
package org.eclipse.efm.core.workflow.serializer;

import org.eclipse.efm.core.workflow.Serializer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TTCN Trace Serializer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#isEnabledCustomization <em>Enabled Customization</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#isEnabledAdapters <em>Enabled Adapters</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getControlModuleName <em>Control Module Name</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getDeclarationsModuleName <em>Declarations Module Name</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getTemplatesModuleName <em>Templates Module Name</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getTestcasesModuleName <em>Testcases Module Name</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getTestcasesStartingWrapper <em>Testcases Starting Wrapper</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getTestcasesEndingWrapper <em>Testcases Ending Wrapper</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getTestcasesSendingWrapper <em>Testcases Sending Wrapper</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getTestcasesReceivingWrapper <em>Testcases Receiving Wrapper</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getAdaptationModuleName <em>Adaptation Module Name</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getAdaptationUtilsImpl <em>Adaptation Utils Impl</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getAdaptationStartingEndingImpl <em>Adaptation Starting Ending Impl</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getAdaptationSendingImpl <em>Adaptation Sending Impl</em>}</li>
 *   <li>{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getAdaptationReceivingImpl <em>Adaptation Receiving Impl</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.core.workflow.serializer.SerializerPackage#getTTCNTraceSerializer()
 * @model
 * @generated
 */
public interface TTCNTraceSerializer extends Serializer {
	/**
	 * Returns the value of the '<em><b>Enabled Customization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Customization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Customization</em>' attribute.
	 * @see #setEnabledCustomization(boolean)
	 * @see org.eclipse.efm.core.workflow.serializer.SerializerPackage#getTTCNTraceSerializer_EnabledCustomization()
	 * @model
	 * @generated
	 */
	boolean isEnabledCustomization();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#isEnabledCustomization <em>Enabled Customization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Customization</em>' attribute.
	 * @see #isEnabledCustomization()
	 * @generated
	 */
	void setEnabledCustomization(boolean value);

	/**
	 * Returns the value of the '<em><b>Enabled Adapters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled Adapters</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled Adapters</em>' attribute.
	 * @see #setEnabledAdapters(boolean)
	 * @see org.eclipse.efm.core.workflow.serializer.SerializerPackage#getTTCNTraceSerializer_EnabledAdapters()
	 * @model
	 * @generated
	 */
	boolean isEnabledAdapters();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#isEnabledAdapters <em>Enabled Adapters</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled Adapters</em>' attribute.
	 * @see #isEnabledAdapters()
	 * @generated
	 */
	void setEnabledAdapters(boolean value);

	/**
	 * Returns the value of the '<em><b>Control Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Control Module Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Control Module Name</em>' attribute.
	 * @see #setControlModuleName(String)
	 * @see org.eclipse.efm.core.workflow.serializer.SerializerPackage#getTTCNTraceSerializer_ControlModuleName()
	 * @model
	 * @generated
	 */
	String getControlModuleName();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getControlModuleName <em>Control Module Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control Module Name</em>' attribute.
	 * @see #getControlModuleName()
	 * @generated
	 */
	void setControlModuleName(String value);

	/**
	 * Returns the value of the '<em><b>Declarations Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declarations Module Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declarations Module Name</em>' attribute.
	 * @see #setDeclarationsModuleName(String)
	 * @see org.eclipse.efm.core.workflow.serializer.SerializerPackage#getTTCNTraceSerializer_DeclarationsModuleName()
	 * @model
	 * @generated
	 */
	String getDeclarationsModuleName();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getDeclarationsModuleName <em>Declarations Module Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declarations Module Name</em>' attribute.
	 * @see #getDeclarationsModuleName()
	 * @generated
	 */
	void setDeclarationsModuleName(String value);

	/**
	 * Returns the value of the '<em><b>Templates Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Templates Module Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Templates Module Name</em>' attribute.
	 * @see #setTemplatesModuleName(String)
	 * @see org.eclipse.efm.core.workflow.serializer.SerializerPackage#getTTCNTraceSerializer_TemplatesModuleName()
	 * @model
	 * @generated
	 */
	String getTemplatesModuleName();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getTemplatesModuleName <em>Templates Module Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Templates Module Name</em>' attribute.
	 * @see #getTemplatesModuleName()
	 * @generated
	 */
	void setTemplatesModuleName(String value);

	/**
	 * Returns the value of the '<em><b>Testcases Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Testcases Module Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Testcases Module Name</em>' attribute.
	 * @see #setTestcasesModuleName(String)
	 * @see org.eclipse.efm.core.workflow.serializer.SerializerPackage#getTTCNTraceSerializer_TestcasesModuleName()
	 * @model
	 * @generated
	 */
	String getTestcasesModuleName();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getTestcasesModuleName <em>Testcases Module Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Testcases Module Name</em>' attribute.
	 * @see #getTestcasesModuleName()
	 * @generated
	 */
	void setTestcasesModuleName(String value);

	/**
	 * Returns the value of the '<em><b>Testcases Starting Wrapper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Testcases Starting Wrapper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Testcases Starting Wrapper</em>' attribute.
	 * @see #setTestcasesStartingWrapper(String)
	 * @see org.eclipse.efm.core.workflow.serializer.SerializerPackage#getTTCNTraceSerializer_TestcasesStartingWrapper()
	 * @model
	 * @generated
	 */
	String getTestcasesStartingWrapper();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getTestcasesStartingWrapper <em>Testcases Starting Wrapper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Testcases Starting Wrapper</em>' attribute.
	 * @see #getTestcasesStartingWrapper()
	 * @generated
	 */
	void setTestcasesStartingWrapper(String value);

	/**
	 * Returns the value of the '<em><b>Testcases Ending Wrapper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Testcases Ending Wrapper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Testcases Ending Wrapper</em>' attribute.
	 * @see #setTestcasesEndingWrapper(String)
	 * @see org.eclipse.efm.core.workflow.serializer.SerializerPackage#getTTCNTraceSerializer_TestcasesEndingWrapper()
	 * @model
	 * @generated
	 */
	String getTestcasesEndingWrapper();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getTestcasesEndingWrapper <em>Testcases Ending Wrapper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Testcases Ending Wrapper</em>' attribute.
	 * @see #getTestcasesEndingWrapper()
	 * @generated
	 */
	void setTestcasesEndingWrapper(String value);

	/**
	 * Returns the value of the '<em><b>Testcases Sending Wrapper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Testcases Sending Wrapper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Testcases Sending Wrapper</em>' attribute.
	 * @see #setTestcasesSendingWrapper(String)
	 * @see org.eclipse.efm.core.workflow.serializer.SerializerPackage#getTTCNTraceSerializer_TestcasesSendingWrapper()
	 * @model
	 * @generated
	 */
	String getTestcasesSendingWrapper();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getTestcasesSendingWrapper <em>Testcases Sending Wrapper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Testcases Sending Wrapper</em>' attribute.
	 * @see #getTestcasesSendingWrapper()
	 * @generated
	 */
	void setTestcasesSendingWrapper(String value);

	/**
	 * Returns the value of the '<em><b>Testcases Receiving Wrapper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Testcases Receiving Wrapper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Testcases Receiving Wrapper</em>' attribute.
	 * @see #setTestcasesReceivingWrapper(String)
	 * @see org.eclipse.efm.core.workflow.serializer.SerializerPackage#getTTCNTraceSerializer_TestcasesReceivingWrapper()
	 * @model
	 * @generated
	 */
	String getTestcasesReceivingWrapper();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getTestcasesReceivingWrapper <em>Testcases Receiving Wrapper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Testcases Receiving Wrapper</em>' attribute.
	 * @see #getTestcasesReceivingWrapper()
	 * @generated
	 */
	void setTestcasesReceivingWrapper(String value);

	/**
	 * Returns the value of the '<em><b>Adaptation Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adaptation Module Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adaptation Module Name</em>' attribute.
	 * @see #setAdaptationModuleName(String)
	 * @see org.eclipse.efm.core.workflow.serializer.SerializerPackage#getTTCNTraceSerializer_AdaptationModuleName()
	 * @model
	 * @generated
	 */
	String getAdaptationModuleName();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getAdaptationModuleName <em>Adaptation Module Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adaptation Module Name</em>' attribute.
	 * @see #getAdaptationModuleName()
	 * @generated
	 */
	void setAdaptationModuleName(String value);

	/**
	 * Returns the value of the '<em><b>Adaptation Utils Impl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adaptation Utils Impl</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adaptation Utils Impl</em>' attribute.
	 * @see #setAdaptationUtilsImpl(String)
	 * @see org.eclipse.efm.core.workflow.serializer.SerializerPackage#getTTCNTraceSerializer_AdaptationUtilsImpl()
	 * @model
	 * @generated
	 */
	String getAdaptationUtilsImpl();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getAdaptationUtilsImpl <em>Adaptation Utils Impl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adaptation Utils Impl</em>' attribute.
	 * @see #getAdaptationUtilsImpl()
	 * @generated
	 */
	void setAdaptationUtilsImpl(String value);

	/**
	 * Returns the value of the '<em><b>Adaptation Starting Ending Impl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adaptation Starting Ending Impl</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adaptation Starting Ending Impl</em>' attribute.
	 * @see #setAdaptationStartingEndingImpl(String)
	 * @see org.eclipse.efm.core.workflow.serializer.SerializerPackage#getTTCNTraceSerializer_AdaptationStartingEndingImpl()
	 * @model
	 * @generated
	 */
	String getAdaptationStartingEndingImpl();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getAdaptationStartingEndingImpl <em>Adaptation Starting Ending Impl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adaptation Starting Ending Impl</em>' attribute.
	 * @see #getAdaptationStartingEndingImpl()
	 * @generated
	 */
	void setAdaptationStartingEndingImpl(String value);

	/**
	 * Returns the value of the '<em><b>Adaptation Sending Impl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adaptation Sending Impl</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adaptation Sending Impl</em>' attribute.
	 * @see #setAdaptationSendingImpl(String)
	 * @see org.eclipse.efm.core.workflow.serializer.SerializerPackage#getTTCNTraceSerializer_AdaptationSendingImpl()
	 * @model
	 * @generated
	 */
	String getAdaptationSendingImpl();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getAdaptationSendingImpl <em>Adaptation Sending Impl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adaptation Sending Impl</em>' attribute.
	 * @see #getAdaptationSendingImpl()
	 * @generated
	 */
	void setAdaptationSendingImpl(String value);

	/**
	 * Returns the value of the '<em><b>Adaptation Receiving Impl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Adaptation Receiving Impl</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Adaptation Receiving Impl</em>' attribute.
	 * @see #setAdaptationReceivingImpl(String)
	 * @see org.eclipse.efm.core.workflow.serializer.SerializerPackage#getTTCNTraceSerializer_AdaptationReceivingImpl()
	 * @model
	 * @generated
	 */
	String getAdaptationReceivingImpl();

	/**
	 * Sets the value of the '{@link org.eclipse.efm.core.workflow.serializer.TTCNTraceSerializer#getAdaptationReceivingImpl <em>Adaptation Receiving Impl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Adaptation Receiving Impl</em>' attribute.
	 * @see #getAdaptationReceivingImpl()
	 * @generated
	 */
	void setAdaptationReceivingImpl(String value);

} // TTCNTraceSerializer
