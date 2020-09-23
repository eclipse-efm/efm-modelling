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
package org.eclipse.efm.ecore.formalml.specification;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xlia Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efm.ecore.formalml.specification.XliaSection#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efm.ecore.formalml.specification.SpecificationPackage#getXliaSection()
 * @model
 * @generated
 */
public interface XliaSection extends XliaNamedElement {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.efm.ecore.formalml.specification.XliaAttribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see org.eclipse.efm.ecore.formalml.specification.SpecificationPackage#getXliaSection_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<XliaAttribute> getElements();

} // XliaSection
