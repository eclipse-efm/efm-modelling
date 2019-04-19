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
package org.eclipse.efm.execution.core.workflow.serializer;

import org.eclipse.efm.execution.core.workflow.WorkflowPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.efm.execution.core.workflow.serializer.SerializerFactory
 * @model kind="package"
 * @generated
 */
public interface SerializerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "serializer";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/efm/Workflow/Serializer";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Serializer";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SerializerPackage eINSTANCE = org.eclipse.efm.execution.core.workflow.serializer.impl.SerializerPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.serializer.impl.ModelGraphicSerializerWorkerImpl <em>Model Graphic Serializer Worker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.ModelGraphicSerializerWorkerImpl
	 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SerializerPackageImpl#getModelGraphicSerializerWorker()
	 * @generated
	 */
	int MODEL_GRAPHIC_SERIALIZER_WORKER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHIC_SERIALIZER_WORKER__NAME = WorkflowPackage.SERIALIZER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHIC_SERIALIZER_WORKER__DESCRIPTION = WorkflowPackage.SERIALIZER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHIC_SERIALIZER_WORKER__COMMENT = WorkflowPackage.SERIALIZER__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHIC_SERIALIZER_WORKER__MANIFEST = WorkflowPackage.SERIALIZER__MANIFEST;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHIC_SERIALIZER_WORKER__DIRECTOR = WorkflowPackage.SERIALIZER__DIRECTOR;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHIC_SERIALIZER_WORKER__CONSOLE = WorkflowPackage.SERIALIZER__CONSOLE;

	/**
	 * The feature id for the '<em><b>Format</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHIC_SERIALIZER_WORKER__FORMAT = WorkflowPackage.SERIALIZER__FORMAT;

	/**
	 * The feature id for the '<em><b>CSS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHIC_SERIALIZER_WORKER__CSS = WorkflowPackage.SERIALIZER__CSS;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHIC_SERIALIZER_WORKER__TRACE = WorkflowPackage.SERIALIZER__TRACE;

	/**
	 * The feature id for the '<em><b>Folder Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHIC_SERIALIZER_WORKER__FOLDER_NAME = WorkflowPackage.SERIALIZER__FOLDER_NAME;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHIC_SERIALIZER_WORKER__FILE_NAME = WorkflowPackage.SERIALIZER__FILE_NAME;

	/**
	 * The feature id for the '<em><b>Enabled Normalization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHIC_SERIALIZER_WORKER__ENABLED_NORMALIZATION = WorkflowPackage.SERIALIZER__ENABLED_NORMALIZATION;

	/**
	 * The feature id for the '<em><b>Enabled Initial Values Printing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHIC_SERIALIZER_WORKER__ENABLED_INITIAL_VALUES_PRINTING = WorkflowPackage.SERIALIZER__ENABLED_INITIAL_VALUES_PRINTING;

	/**
	 * The feature id for the '<em><b>Enabled Lifelines Printing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHIC_SERIALIZER_WORKER__ENABLED_LIFELINES_PRINTING = WorkflowPackage.SERIALIZER__ENABLED_LIFELINES_PRINTING;

	/**
	 * The feature id for the '<em><b>Enabled Modified Data Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHIC_SERIALIZER_WORKER__ENABLED_MODIFIED_DATA_SELECTION = WorkflowPackage.SERIALIZER__ENABLED_MODIFIED_DATA_SELECTION;

	/**
	 * The number of structural features of the '<em>Model Graphic Serializer Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHIC_SERIALIZER_WORKER_FEATURE_COUNT = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Model Graphic Serializer Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHIC_SERIALIZER_WORKER_OPERATION_COUNT = WorkflowPackage.SERIALIZER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.serializer.impl.ModelGraphvizSerializerWorkerImpl <em>Model Graphviz Serializer Worker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.ModelGraphvizSerializerWorkerImpl
	 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SerializerPackageImpl#getModelGraphvizSerializerWorker()
	 * @generated
	 */
	int MODEL_GRAPHVIZ_SERIALIZER_WORKER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHVIZ_SERIALIZER_WORKER__NAME = WorkflowPackage.SERIALIZER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHVIZ_SERIALIZER_WORKER__DESCRIPTION = WorkflowPackage.SERIALIZER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHVIZ_SERIALIZER_WORKER__COMMENT = WorkflowPackage.SERIALIZER__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHVIZ_SERIALIZER_WORKER__MANIFEST = WorkflowPackage.SERIALIZER__MANIFEST;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHVIZ_SERIALIZER_WORKER__DIRECTOR = WorkflowPackage.SERIALIZER__DIRECTOR;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHVIZ_SERIALIZER_WORKER__CONSOLE = WorkflowPackage.SERIALIZER__CONSOLE;

	/**
	 * The feature id for the '<em><b>Format</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHVIZ_SERIALIZER_WORKER__FORMAT = WorkflowPackage.SERIALIZER__FORMAT;

	/**
	 * The feature id for the '<em><b>CSS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHVIZ_SERIALIZER_WORKER__CSS = WorkflowPackage.SERIALIZER__CSS;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHVIZ_SERIALIZER_WORKER__TRACE = WorkflowPackage.SERIALIZER__TRACE;

	/**
	 * The feature id for the '<em><b>Folder Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHVIZ_SERIALIZER_WORKER__FOLDER_NAME = WorkflowPackage.SERIALIZER__FOLDER_NAME;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHVIZ_SERIALIZER_WORKER__FILE_NAME = WorkflowPackage.SERIALIZER__FILE_NAME;

	/**
	 * The feature id for the '<em><b>Enabled Normalization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHVIZ_SERIALIZER_WORKER__ENABLED_NORMALIZATION = WorkflowPackage.SERIALIZER__ENABLED_NORMALIZATION;

	/**
	 * The feature id for the '<em><b>Enabled Initial Values Printing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHVIZ_SERIALIZER_WORKER__ENABLED_INITIAL_VALUES_PRINTING = WorkflowPackage.SERIALIZER__ENABLED_INITIAL_VALUES_PRINTING;

	/**
	 * The feature id for the '<em><b>Enabled Lifelines Printing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHVIZ_SERIALIZER_WORKER__ENABLED_LIFELINES_PRINTING = WorkflowPackage.SERIALIZER__ENABLED_LIFELINES_PRINTING;

	/**
	 * The feature id for the '<em><b>Enabled Modified Data Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHVIZ_SERIALIZER_WORKER__ENABLED_MODIFIED_DATA_SELECTION = WorkflowPackage.SERIALIZER__ENABLED_MODIFIED_DATA_SELECTION;

	/**
	 * The number of structural features of the '<em>Model Graphviz Serializer Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHVIZ_SERIALIZER_WORKER_FEATURE_COUNT = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Model Graphviz Serializer Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_GRAPHVIZ_SERIALIZER_WORKER_OPERATION_COUNT = WorkflowPackage.SERIALIZER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.serializer.impl.SymbexGraphicSerializerWorkerImpl <em>Symbex Graphic Serializer Worker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SymbexGraphicSerializerWorkerImpl
	 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SerializerPackageImpl#getSymbexGraphicSerializerWorker()
	 * @generated
	 */
	int SYMBEX_GRAPHIC_SERIALIZER_WORKER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPHIC_SERIALIZER_WORKER__NAME = WorkflowPackage.SERIALIZER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPHIC_SERIALIZER_WORKER__DESCRIPTION = WorkflowPackage.SERIALIZER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPHIC_SERIALIZER_WORKER__COMMENT = WorkflowPackage.SERIALIZER__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPHIC_SERIALIZER_WORKER__MANIFEST = WorkflowPackage.SERIALIZER__MANIFEST;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPHIC_SERIALIZER_WORKER__DIRECTOR = WorkflowPackage.SERIALIZER__DIRECTOR;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPHIC_SERIALIZER_WORKER__CONSOLE = WorkflowPackage.SERIALIZER__CONSOLE;

	/**
	 * The feature id for the '<em><b>Format</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPHIC_SERIALIZER_WORKER__FORMAT = WorkflowPackage.SERIALIZER__FORMAT;

	/**
	 * The feature id for the '<em><b>CSS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPHIC_SERIALIZER_WORKER__CSS = WorkflowPackage.SERIALIZER__CSS;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPHIC_SERIALIZER_WORKER__TRACE = WorkflowPackage.SERIALIZER__TRACE;

	/**
	 * The feature id for the '<em><b>Folder Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPHIC_SERIALIZER_WORKER__FOLDER_NAME = WorkflowPackage.SERIALIZER__FOLDER_NAME;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPHIC_SERIALIZER_WORKER__FILE_NAME = WorkflowPackage.SERIALIZER__FILE_NAME;

	/**
	 * The feature id for the '<em><b>Enabled Normalization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPHIC_SERIALIZER_WORKER__ENABLED_NORMALIZATION = WorkflowPackage.SERIALIZER__ENABLED_NORMALIZATION;

	/**
	 * The feature id for the '<em><b>Enabled Initial Values Printing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPHIC_SERIALIZER_WORKER__ENABLED_INITIAL_VALUES_PRINTING = WorkflowPackage.SERIALIZER__ENABLED_INITIAL_VALUES_PRINTING;

	/**
	 * The feature id for the '<em><b>Enabled Lifelines Printing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPHIC_SERIALIZER_WORKER__ENABLED_LIFELINES_PRINTING = WorkflowPackage.SERIALIZER__ENABLED_LIFELINES_PRINTING;

	/**
	 * The feature id for the '<em><b>Enabled Modified Data Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPHIC_SERIALIZER_WORKER__ENABLED_MODIFIED_DATA_SELECTION = WorkflowPackage.SERIALIZER__ENABLED_MODIFIED_DATA_SELECTION;

	/**
	 * The number of structural features of the '<em>Symbex Graphic Serializer Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPHIC_SERIALIZER_WORKER_FEATURE_COUNT = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Symbex Graphic Serializer Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPHIC_SERIALIZER_WORKER_OPERATION_COUNT = WorkflowPackage.SERIALIZER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.serializer.impl.SymbexGraphVizSerializerWorkerImpl <em>Symbex Graph Viz Serializer Worker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SymbexGraphVizSerializerWorkerImpl
	 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SerializerPackageImpl#getSymbexGraphVizSerializerWorker()
	 * @generated
	 */
	int SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER__NAME = WorkflowPackage.SERIALIZER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER__DESCRIPTION = WorkflowPackage.SERIALIZER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER__COMMENT = WorkflowPackage.SERIALIZER__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER__MANIFEST = WorkflowPackage.SERIALIZER__MANIFEST;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER__DIRECTOR = WorkflowPackage.SERIALIZER__DIRECTOR;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER__CONSOLE = WorkflowPackage.SERIALIZER__CONSOLE;

	/**
	 * The feature id for the '<em><b>Format</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER__FORMAT = WorkflowPackage.SERIALIZER__FORMAT;

	/**
	 * The feature id for the '<em><b>CSS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER__CSS = WorkflowPackage.SERIALIZER__CSS;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER__TRACE = WorkflowPackage.SERIALIZER__TRACE;

	/**
	 * The feature id for the '<em><b>Folder Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER__FOLDER_NAME = WorkflowPackage.SERIALIZER__FOLDER_NAME;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER__FILE_NAME = WorkflowPackage.SERIALIZER__FILE_NAME;

	/**
	 * The feature id for the '<em><b>Enabled Normalization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER__ENABLED_NORMALIZATION = WorkflowPackage.SERIALIZER__ENABLED_NORMALIZATION;

	/**
	 * The feature id for the '<em><b>Enabled Initial Values Printing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER__ENABLED_INITIAL_VALUES_PRINTING = WorkflowPackage.SERIALIZER__ENABLED_INITIAL_VALUES_PRINTING;

	/**
	 * The feature id for the '<em><b>Enabled Lifelines Printing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER__ENABLED_LIFELINES_PRINTING = WorkflowPackage.SERIALIZER__ENABLED_LIFELINES_PRINTING;

	/**
	 * The feature id for the '<em><b>Enabled Modified Data Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER__ENABLED_MODIFIED_DATA_SELECTION = WorkflowPackage.SERIALIZER__ENABLED_MODIFIED_DATA_SELECTION;

	/**
	 * The number of structural features of the '<em>Symbex Graph Viz Serializer Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER_FEATURE_COUNT = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Symbex Graph Viz Serializer Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER_OPERATION_COUNT = WorkflowPackage.SERIALIZER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.serializer.impl.BasicTraceSerializerImpl <em>Basic Trace Serializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.BasicTraceSerializerImpl
	 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SerializerPackageImpl#getBasicTraceSerializer()
	 * @generated
	 */
	int BASIC_TRACE_SERIALIZER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_TRACE_SERIALIZER__NAME = WorkflowPackage.SERIALIZER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_TRACE_SERIALIZER__DESCRIPTION = WorkflowPackage.SERIALIZER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_TRACE_SERIALIZER__COMMENT = WorkflowPackage.SERIALIZER__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_TRACE_SERIALIZER__MANIFEST = WorkflowPackage.SERIALIZER__MANIFEST;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_TRACE_SERIALIZER__DIRECTOR = WorkflowPackage.SERIALIZER__DIRECTOR;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_TRACE_SERIALIZER__CONSOLE = WorkflowPackage.SERIALIZER__CONSOLE;

	/**
	 * The feature id for the '<em><b>Format</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_TRACE_SERIALIZER__FORMAT = WorkflowPackage.SERIALIZER__FORMAT;

	/**
	 * The feature id for the '<em><b>CSS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_TRACE_SERIALIZER__CSS = WorkflowPackage.SERIALIZER__CSS;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_TRACE_SERIALIZER__TRACE = WorkflowPackage.SERIALIZER__TRACE;

	/**
	 * The feature id for the '<em><b>Folder Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_TRACE_SERIALIZER__FOLDER_NAME = WorkflowPackage.SERIALIZER__FOLDER_NAME;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_TRACE_SERIALIZER__FILE_NAME = WorkflowPackage.SERIALIZER__FILE_NAME;

	/**
	 * The feature id for the '<em><b>Enabled Normalization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_TRACE_SERIALIZER__ENABLED_NORMALIZATION = WorkflowPackage.SERIALIZER__ENABLED_NORMALIZATION;

	/**
	 * The feature id for the '<em><b>Enabled Initial Values Printing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_TRACE_SERIALIZER__ENABLED_INITIAL_VALUES_PRINTING = WorkflowPackage.SERIALIZER__ENABLED_INITIAL_VALUES_PRINTING;

	/**
	 * The feature id for the '<em><b>Enabled Lifelines Printing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_TRACE_SERIALIZER__ENABLED_LIFELINES_PRINTING = WorkflowPackage.SERIALIZER__ENABLED_LIFELINES_PRINTING;

	/**
	 * The feature id for the '<em><b>Enabled Modified Data Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_TRACE_SERIALIZER__ENABLED_MODIFIED_DATA_SELECTION = WorkflowPackage.SERIALIZER__ENABLED_MODIFIED_DATA_SELECTION;

	/**
	 * The number of structural features of the '<em>Basic Trace Serializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_TRACE_SERIALIZER_FEATURE_COUNT = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Basic Trace Serializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_TRACE_SERIALIZER_OPERATION_COUNT = WorkflowPackage.SERIALIZER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.serializer.impl.TTCNTraceSerializerImpl <em>TTCN Trace Serializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.TTCNTraceSerializerImpl
	 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SerializerPackageImpl#getTTCNTraceSerializer()
	 * @generated
	 */
	int TTCN_TRACE_SERIALIZER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__NAME = WorkflowPackage.SERIALIZER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__DESCRIPTION = WorkflowPackage.SERIALIZER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__COMMENT = WorkflowPackage.SERIALIZER__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__MANIFEST = WorkflowPackage.SERIALIZER__MANIFEST;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__DIRECTOR = WorkflowPackage.SERIALIZER__DIRECTOR;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__CONSOLE = WorkflowPackage.SERIALIZER__CONSOLE;

	/**
	 * The feature id for the '<em><b>Format</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__FORMAT = WorkflowPackage.SERIALIZER__FORMAT;

	/**
	 * The feature id for the '<em><b>CSS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__CSS = WorkflowPackage.SERIALIZER__CSS;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__TRACE = WorkflowPackage.SERIALIZER__TRACE;

	/**
	 * The feature id for the '<em><b>Folder Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__FOLDER_NAME = WorkflowPackage.SERIALIZER__FOLDER_NAME;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__FILE_NAME = WorkflowPackage.SERIALIZER__FILE_NAME;

	/**
	 * The feature id for the '<em><b>Enabled Normalization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__ENABLED_NORMALIZATION = WorkflowPackage.SERIALIZER__ENABLED_NORMALIZATION;

	/**
	 * The feature id for the '<em><b>Enabled Initial Values Printing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__ENABLED_INITIAL_VALUES_PRINTING = WorkflowPackage.SERIALIZER__ENABLED_INITIAL_VALUES_PRINTING;

	/**
	 * The feature id for the '<em><b>Enabled Lifelines Printing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__ENABLED_LIFELINES_PRINTING = WorkflowPackage.SERIALIZER__ENABLED_LIFELINES_PRINTING;

	/**
	 * The feature id for the '<em><b>Enabled Modified Data Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__ENABLED_MODIFIED_DATA_SELECTION = WorkflowPackage.SERIALIZER__ENABLED_MODIFIED_DATA_SELECTION;

	/**
	 * The feature id for the '<em><b>Enabled Customization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__ENABLED_CUSTOMIZATION = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enabled Adapters</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__ENABLED_ADAPTERS = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Control Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__CONTROL_MODULE_NAME = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Declarations Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__DECLARATIONS_MODULE_NAME = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Templates Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__TEMPLATES_MODULE_NAME = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Testcases Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__TESTCASES_MODULE_NAME = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Testcases Starting Wrapper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__TESTCASES_STARTING_WRAPPER = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Testcases Ending Wrapper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__TESTCASES_ENDING_WRAPPER = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Testcases Sending Wrapper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__TESTCASES_SENDING_WRAPPER = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Testcases Receiving Wrapper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__TESTCASES_RECEIVING_WRAPPER = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Adaptation Module Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__ADAPTATION_MODULE_NAME = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Adaptation Utils Impl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__ADAPTATION_UTILS_IMPL = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Adaptation Starting Ending Impl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__ADAPTATION_STARTING_ENDING_IMPL = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Adaptation Sending Impl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__ADAPTATION_SENDING_IMPL = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Adaptation Receiving Impl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER__ADAPTATION_RECEIVING_IMPL = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 14;

	/**
	 * The number of structural features of the '<em>TTCN Trace Serializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER_FEATURE_COUNT = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 15;

	/**
	 * The number of operations of the '<em>TTCN Trace Serializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTCN_TRACE_SERIALIZER_OPERATION_COUNT = WorkflowPackage.SERIALIZER_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.serializer.impl.SymbexSequenceDiagramSerializerWorkerImpl <em>Symbex Sequence Diagram Serializer Worker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SymbexSequenceDiagramSerializerWorkerImpl
	 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SerializerPackageImpl#getSymbexSequenceDiagramSerializerWorker()
	 * @generated
	 */
	int SYMBEX_SEQUENCE_DIAGRAM_SERIALIZER_WORKER = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_SEQUENCE_DIAGRAM_SERIALIZER_WORKER__NAME = WorkflowPackage.SERIALIZER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_SEQUENCE_DIAGRAM_SERIALIZER_WORKER__DESCRIPTION = WorkflowPackage.SERIALIZER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_SEQUENCE_DIAGRAM_SERIALIZER_WORKER__COMMENT = WorkflowPackage.SERIALIZER__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_SEQUENCE_DIAGRAM_SERIALIZER_WORKER__MANIFEST = WorkflowPackage.SERIALIZER__MANIFEST;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_SEQUENCE_DIAGRAM_SERIALIZER_WORKER__DIRECTOR = WorkflowPackage.SERIALIZER__DIRECTOR;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_SEQUENCE_DIAGRAM_SERIALIZER_WORKER__CONSOLE = WorkflowPackage.SERIALIZER__CONSOLE;

	/**
	 * The feature id for the '<em><b>Format</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_SEQUENCE_DIAGRAM_SERIALIZER_WORKER__FORMAT = WorkflowPackage.SERIALIZER__FORMAT;

	/**
	 * The feature id for the '<em><b>CSS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_SEQUENCE_DIAGRAM_SERIALIZER_WORKER__CSS = WorkflowPackage.SERIALIZER__CSS;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_SEQUENCE_DIAGRAM_SERIALIZER_WORKER__TRACE = WorkflowPackage.SERIALIZER__TRACE;

	/**
	 * The feature id for the '<em><b>Folder Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_SEQUENCE_DIAGRAM_SERIALIZER_WORKER__FOLDER_NAME = WorkflowPackage.SERIALIZER__FOLDER_NAME;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_SEQUENCE_DIAGRAM_SERIALIZER_WORKER__FILE_NAME = WorkflowPackage.SERIALIZER__FILE_NAME;

	/**
	 * The feature id for the '<em><b>Enabled Normalization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_SEQUENCE_DIAGRAM_SERIALIZER_WORKER__ENABLED_NORMALIZATION = WorkflowPackage.SERIALIZER__ENABLED_NORMALIZATION;

	/**
	 * The feature id for the '<em><b>Enabled Initial Values Printing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_SEQUENCE_DIAGRAM_SERIALIZER_WORKER__ENABLED_INITIAL_VALUES_PRINTING = WorkflowPackage.SERIALIZER__ENABLED_INITIAL_VALUES_PRINTING;

	/**
	 * The feature id for the '<em><b>Enabled Lifelines Printing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_SEQUENCE_DIAGRAM_SERIALIZER_WORKER__ENABLED_LIFELINES_PRINTING = WorkflowPackage.SERIALIZER__ENABLED_LIFELINES_PRINTING;

	/**
	 * The feature id for the '<em><b>Enabled Modified Data Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_SEQUENCE_DIAGRAM_SERIALIZER_WORKER__ENABLED_MODIFIED_DATA_SELECTION = WorkflowPackage.SERIALIZER__ENABLED_MODIFIED_DATA_SELECTION;

	/**
	 * The number of structural features of the '<em>Symbex Sequence Diagram Serializer Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_SEQUENCE_DIAGRAM_SERIALIZER_WORKER_FEATURE_COUNT = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Symbex Sequence Diagram Serializer Worker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBEX_SEQUENCE_DIAGRAM_SERIALIZER_WORKER_OPERATION_COUNT = WorkflowPackage.SERIALIZER_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.efm.execution.core.workflow.serializer.impl.SequenceDiagramTraceSerializerImpl <em>Sequence Diagram Trace Serializer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SequenceDiagramTraceSerializerImpl
	 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SerializerPackageImpl#getSequenceDiagramTraceSerializer()
	 * @generated
	 */
	int SEQUENCE_DIAGRAM_TRACE_SERIALIZER = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM_TRACE_SERIALIZER__NAME = WorkflowPackage.SERIALIZER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM_TRACE_SERIALIZER__DESCRIPTION = WorkflowPackage.SERIALIZER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM_TRACE_SERIALIZER__COMMENT = WorkflowPackage.SERIALIZER__COMMENT;

	/**
	 * The feature id for the '<em><b>Manifest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM_TRACE_SERIALIZER__MANIFEST = WorkflowPackage.SERIALIZER__MANIFEST;

	/**
	 * The feature id for the '<em><b>Director</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM_TRACE_SERIALIZER__DIRECTOR = WorkflowPackage.SERIALIZER__DIRECTOR;

	/**
	 * The feature id for the '<em><b>Console</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM_TRACE_SERIALIZER__CONSOLE = WorkflowPackage.SERIALIZER__CONSOLE;

	/**
	 * The feature id for the '<em><b>Format</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM_TRACE_SERIALIZER__FORMAT = WorkflowPackage.SERIALIZER__FORMAT;

	/**
	 * The feature id for the '<em><b>CSS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM_TRACE_SERIALIZER__CSS = WorkflowPackage.SERIALIZER__CSS;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM_TRACE_SERIALIZER__TRACE = WorkflowPackage.SERIALIZER__TRACE;

	/**
	 * The feature id for the '<em><b>Folder Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM_TRACE_SERIALIZER__FOLDER_NAME = WorkflowPackage.SERIALIZER__FOLDER_NAME;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM_TRACE_SERIALIZER__FILE_NAME = WorkflowPackage.SERIALIZER__FILE_NAME;

	/**
	 * The feature id for the '<em><b>Enabled Normalization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM_TRACE_SERIALIZER__ENABLED_NORMALIZATION = WorkflowPackage.SERIALIZER__ENABLED_NORMALIZATION;

	/**
	 * The feature id for the '<em><b>Enabled Initial Values Printing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM_TRACE_SERIALIZER__ENABLED_INITIAL_VALUES_PRINTING = WorkflowPackage.SERIALIZER__ENABLED_INITIAL_VALUES_PRINTING;

	/**
	 * The feature id for the '<em><b>Enabled Lifelines Printing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM_TRACE_SERIALIZER__ENABLED_LIFELINES_PRINTING = WorkflowPackage.SERIALIZER__ENABLED_LIFELINES_PRINTING;

	/**
	 * The feature id for the '<em><b>Enabled Modified Data Selection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM_TRACE_SERIALIZER__ENABLED_MODIFIED_DATA_SELECTION = WorkflowPackage.SERIALIZER__ENABLED_MODIFIED_DATA_SELECTION;

	/**
	 * The number of structural features of the '<em>Sequence Diagram Trace Serializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM_TRACE_SERIALIZER_FEATURE_COUNT = WorkflowPackage.SERIALIZER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sequence Diagram Trace Serializer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM_TRACE_SERIALIZER_OPERATION_COUNT = WorkflowPackage.SERIALIZER_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.serializer.ModelGraphicSerializerWorker <em>Model Graphic Serializer Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Graphic Serializer Worker</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.ModelGraphicSerializerWorker
	 * @generated
	 */
	EClass getModelGraphicSerializerWorker();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.serializer.ModelGraphvizSerializerWorker <em>Model Graphviz Serializer Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Graphviz Serializer Worker</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.ModelGraphvizSerializerWorker
	 * @generated
	 */
	EClass getModelGraphvizSerializerWorker();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.serializer.SymbexGraphicSerializerWorker <em>Symbex Graphic Serializer Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Symbex Graphic Serializer Worker</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.SymbexGraphicSerializerWorker
	 * @generated
	 */
	EClass getSymbexGraphicSerializerWorker();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.serializer.SymbexGraphVizSerializerWorker <em>Symbex Graph Viz Serializer Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Symbex Graph Viz Serializer Worker</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.SymbexGraphVizSerializerWorker
	 * @generated
	 */
	EClass getSymbexGraphVizSerializerWorker();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.serializer.BasicTraceSerializer <em>Basic Trace Serializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Trace Serializer</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.BasicTraceSerializer
	 * @generated
	 */
	EClass getBasicTraceSerializer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer <em>TTCN Trace Serializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TTCN Trace Serializer</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer
	 * @generated
	 */
	EClass getTTCNTraceSerializer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#isEnabledCustomization <em>Enabled Customization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Customization</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#isEnabledCustomization()
	 * @see #getTTCNTraceSerializer()
	 * @generated
	 */
	EAttribute getTTCNTraceSerializer_EnabledCustomization();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#isEnabledAdapters <em>Enabled Adapters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled Adapters</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#isEnabledAdapters()
	 * @see #getTTCNTraceSerializer()
	 * @generated
	 */
	EAttribute getTTCNTraceSerializer_EnabledAdapters();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getControlModuleName <em>Control Module Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Control Module Name</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getControlModuleName()
	 * @see #getTTCNTraceSerializer()
	 * @generated
	 */
	EAttribute getTTCNTraceSerializer_ControlModuleName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getDeclarationsModuleName <em>Declarations Module Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Declarations Module Name</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getDeclarationsModuleName()
	 * @see #getTTCNTraceSerializer()
	 * @generated
	 */
	EAttribute getTTCNTraceSerializer_DeclarationsModuleName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getTemplatesModuleName <em>Templates Module Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Templates Module Name</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getTemplatesModuleName()
	 * @see #getTTCNTraceSerializer()
	 * @generated
	 */
	EAttribute getTTCNTraceSerializer_TemplatesModuleName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getTestcasesModuleName <em>Testcases Module Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Testcases Module Name</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getTestcasesModuleName()
	 * @see #getTTCNTraceSerializer()
	 * @generated
	 */
	EAttribute getTTCNTraceSerializer_TestcasesModuleName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getTestcasesStartingWrapper <em>Testcases Starting Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Testcases Starting Wrapper</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getTestcasesStartingWrapper()
	 * @see #getTTCNTraceSerializer()
	 * @generated
	 */
	EAttribute getTTCNTraceSerializer_TestcasesStartingWrapper();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getTestcasesEndingWrapper <em>Testcases Ending Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Testcases Ending Wrapper</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getTestcasesEndingWrapper()
	 * @see #getTTCNTraceSerializer()
	 * @generated
	 */
	EAttribute getTTCNTraceSerializer_TestcasesEndingWrapper();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getTestcasesSendingWrapper <em>Testcases Sending Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Testcases Sending Wrapper</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getTestcasesSendingWrapper()
	 * @see #getTTCNTraceSerializer()
	 * @generated
	 */
	EAttribute getTTCNTraceSerializer_TestcasesSendingWrapper();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getTestcasesReceivingWrapper <em>Testcases Receiving Wrapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Testcases Receiving Wrapper</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getTestcasesReceivingWrapper()
	 * @see #getTTCNTraceSerializer()
	 * @generated
	 */
	EAttribute getTTCNTraceSerializer_TestcasesReceivingWrapper();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getAdaptationModuleName <em>Adaptation Module Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Adaptation Module Name</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getAdaptationModuleName()
	 * @see #getTTCNTraceSerializer()
	 * @generated
	 */
	EAttribute getTTCNTraceSerializer_AdaptationModuleName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getAdaptationUtilsImpl <em>Adaptation Utils Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Adaptation Utils Impl</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getAdaptationUtilsImpl()
	 * @see #getTTCNTraceSerializer()
	 * @generated
	 */
	EAttribute getTTCNTraceSerializer_AdaptationUtilsImpl();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getAdaptationStartingEndingImpl <em>Adaptation Starting Ending Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Adaptation Starting Ending Impl</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getAdaptationStartingEndingImpl()
	 * @see #getTTCNTraceSerializer()
	 * @generated
	 */
	EAttribute getTTCNTraceSerializer_AdaptationStartingEndingImpl();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getAdaptationSendingImpl <em>Adaptation Sending Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Adaptation Sending Impl</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getAdaptationSendingImpl()
	 * @see #getTTCNTraceSerializer()
	 * @generated
	 */
	EAttribute getTTCNTraceSerializer_AdaptationSendingImpl();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getAdaptationReceivingImpl <em>Adaptation Receiving Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Adaptation Receiving Impl</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.TTCNTraceSerializer#getAdaptationReceivingImpl()
	 * @see #getTTCNTraceSerializer()
	 * @generated
	 */
	EAttribute getTTCNTraceSerializer_AdaptationReceivingImpl();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.serializer.SymbexSequenceDiagramSerializerWorker <em>Symbex Sequence Diagram Serializer Worker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Symbex Sequence Diagram Serializer Worker</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.SymbexSequenceDiagramSerializerWorker
	 * @generated
	 */
	EClass getSymbexSequenceDiagramSerializerWorker();

	/**
	 * Returns the meta object for class '{@link org.eclipse.efm.execution.core.workflow.serializer.SequenceDiagramTraceSerializer <em>Sequence Diagram Trace Serializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Diagram Trace Serializer</em>'.
	 * @see org.eclipse.efm.execution.core.workflow.serializer.SequenceDiagramTraceSerializer
	 * @generated
	 */
	EClass getSequenceDiagramTraceSerializer();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SerializerFactory getSerializerFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.serializer.impl.ModelGraphicSerializerWorkerImpl <em>Model Graphic Serializer Worker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.ModelGraphicSerializerWorkerImpl
		 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SerializerPackageImpl#getModelGraphicSerializerWorker()
		 * @generated
		 */
		EClass MODEL_GRAPHIC_SERIALIZER_WORKER = eINSTANCE.getModelGraphicSerializerWorker();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.serializer.impl.ModelGraphvizSerializerWorkerImpl <em>Model Graphviz Serializer Worker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.ModelGraphvizSerializerWorkerImpl
		 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SerializerPackageImpl#getModelGraphvizSerializerWorker()
		 * @generated
		 */
		EClass MODEL_GRAPHVIZ_SERIALIZER_WORKER = eINSTANCE.getModelGraphvizSerializerWorker();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.serializer.impl.SymbexGraphicSerializerWorkerImpl <em>Symbex Graphic Serializer Worker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SymbexGraphicSerializerWorkerImpl
		 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SerializerPackageImpl#getSymbexGraphicSerializerWorker()
		 * @generated
		 */
		EClass SYMBEX_GRAPHIC_SERIALIZER_WORKER = eINSTANCE.getSymbexGraphicSerializerWorker();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.serializer.impl.SymbexGraphVizSerializerWorkerImpl <em>Symbex Graph Viz Serializer Worker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SymbexGraphVizSerializerWorkerImpl
		 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SerializerPackageImpl#getSymbexGraphVizSerializerWorker()
		 * @generated
		 */
		EClass SYMBEX_GRAPH_VIZ_SERIALIZER_WORKER = eINSTANCE.getSymbexGraphVizSerializerWorker();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.serializer.impl.BasicTraceSerializerImpl <em>Basic Trace Serializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.BasicTraceSerializerImpl
		 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SerializerPackageImpl#getBasicTraceSerializer()
		 * @generated
		 */
		EClass BASIC_TRACE_SERIALIZER = eINSTANCE.getBasicTraceSerializer();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.serializer.impl.TTCNTraceSerializerImpl <em>TTCN Trace Serializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.TTCNTraceSerializerImpl
		 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SerializerPackageImpl#getTTCNTraceSerializer()
		 * @generated
		 */
		EClass TTCN_TRACE_SERIALIZER = eINSTANCE.getTTCNTraceSerializer();

		/**
		 * The meta object literal for the '<em><b>Enabled Customization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTCN_TRACE_SERIALIZER__ENABLED_CUSTOMIZATION = eINSTANCE.getTTCNTraceSerializer_EnabledCustomization();

		/**
		 * The meta object literal for the '<em><b>Enabled Adapters</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTCN_TRACE_SERIALIZER__ENABLED_ADAPTERS = eINSTANCE.getTTCNTraceSerializer_EnabledAdapters();

		/**
		 * The meta object literal for the '<em><b>Control Module Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTCN_TRACE_SERIALIZER__CONTROL_MODULE_NAME = eINSTANCE.getTTCNTraceSerializer_ControlModuleName();

		/**
		 * The meta object literal for the '<em><b>Declarations Module Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTCN_TRACE_SERIALIZER__DECLARATIONS_MODULE_NAME = eINSTANCE.getTTCNTraceSerializer_DeclarationsModuleName();

		/**
		 * The meta object literal for the '<em><b>Templates Module Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTCN_TRACE_SERIALIZER__TEMPLATES_MODULE_NAME = eINSTANCE.getTTCNTraceSerializer_TemplatesModuleName();

		/**
		 * The meta object literal for the '<em><b>Testcases Module Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTCN_TRACE_SERIALIZER__TESTCASES_MODULE_NAME = eINSTANCE.getTTCNTraceSerializer_TestcasesModuleName();

		/**
		 * The meta object literal for the '<em><b>Testcases Starting Wrapper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTCN_TRACE_SERIALIZER__TESTCASES_STARTING_WRAPPER = eINSTANCE.getTTCNTraceSerializer_TestcasesStartingWrapper();

		/**
		 * The meta object literal for the '<em><b>Testcases Ending Wrapper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTCN_TRACE_SERIALIZER__TESTCASES_ENDING_WRAPPER = eINSTANCE.getTTCNTraceSerializer_TestcasesEndingWrapper();

		/**
		 * The meta object literal for the '<em><b>Testcases Sending Wrapper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTCN_TRACE_SERIALIZER__TESTCASES_SENDING_WRAPPER = eINSTANCE.getTTCNTraceSerializer_TestcasesSendingWrapper();

		/**
		 * The meta object literal for the '<em><b>Testcases Receiving Wrapper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTCN_TRACE_SERIALIZER__TESTCASES_RECEIVING_WRAPPER = eINSTANCE.getTTCNTraceSerializer_TestcasesReceivingWrapper();

		/**
		 * The meta object literal for the '<em><b>Adaptation Module Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTCN_TRACE_SERIALIZER__ADAPTATION_MODULE_NAME = eINSTANCE.getTTCNTraceSerializer_AdaptationModuleName();

		/**
		 * The meta object literal for the '<em><b>Adaptation Utils Impl</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTCN_TRACE_SERIALIZER__ADAPTATION_UTILS_IMPL = eINSTANCE.getTTCNTraceSerializer_AdaptationUtilsImpl();

		/**
		 * The meta object literal for the '<em><b>Adaptation Starting Ending Impl</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTCN_TRACE_SERIALIZER__ADAPTATION_STARTING_ENDING_IMPL = eINSTANCE.getTTCNTraceSerializer_AdaptationStartingEndingImpl();

		/**
		 * The meta object literal for the '<em><b>Adaptation Sending Impl</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTCN_TRACE_SERIALIZER__ADAPTATION_SENDING_IMPL = eINSTANCE.getTTCNTraceSerializer_AdaptationSendingImpl();

		/**
		 * The meta object literal for the '<em><b>Adaptation Receiving Impl</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTCN_TRACE_SERIALIZER__ADAPTATION_RECEIVING_IMPL = eINSTANCE.getTTCNTraceSerializer_AdaptationReceivingImpl();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.serializer.impl.SymbexSequenceDiagramSerializerWorkerImpl <em>Symbex Sequence Diagram Serializer Worker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SymbexSequenceDiagramSerializerWorkerImpl
		 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SerializerPackageImpl#getSymbexSequenceDiagramSerializerWorker()
		 * @generated
		 */
		EClass SYMBEX_SEQUENCE_DIAGRAM_SERIALIZER_WORKER = eINSTANCE.getSymbexSequenceDiagramSerializerWorker();

		/**
		 * The meta object literal for the '{@link org.eclipse.efm.execution.core.workflow.serializer.impl.SequenceDiagramTraceSerializerImpl <em>Sequence Diagram Trace Serializer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SequenceDiagramTraceSerializerImpl
		 * @see org.eclipse.efm.execution.core.workflow.serializer.impl.SerializerPackageImpl#getSequenceDiagramTraceSerializer()
		 * @generated
		 */
		EClass SEQUENCE_DIAGRAM_TRACE_SERIALIZER = eINSTANCE.getSequenceDiagramTraceSerializer();

	}

} //SerializerPackage
