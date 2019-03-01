/*******************************************************************************
 * Copyright (c) 2019 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
 *  - Initial API and Implementationon
 *******************************************************************************/
package org.eclipse.efm.modeling.codegen.xlia.util;

import org.eclipse.efm.modeling.codegen.xlia.core.MainCodeGenerator;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;

public class ModelUtils {

	protected MainCodeGenerator fSupervisor;


	Model xliaModel;
	Package Inference;
	Package DataTypes;
	Package Signals;
	Package Scheduler;

	Class System;

	public ModelUtils(MainCodeGenerator supervisor, String name) {

		super();

		this.fSupervisor = supervisor;

		this.xliaModel = UMLFactory.eINSTANCE.createModel();

		this.xliaModel.setName(name);
		this.Inference = this.xliaModel.createNestedPackage("InferenceUtils");
		this.DataTypes = this.xliaModel.createNestedPackage("DataTypes");
		this.Signals = this.xliaModel.createNestedPackage("Signals");
		this.Scheduler = this.xliaModel.createNestedPackage("Scheduler");

		this.System = this.xliaModel.createOwnedClass("System", false);
	}

	/**
	 * performTransform a Model element to a writer
	 * @param element
	 * @param writer
	 */
	public void performTransform(PrettyPrintWriter writer) {
		fSupervisor.fClassFactory.transformFormalModel(xliaModel, writer);
	}

	public void addDataType(DataType element) {

		DataType type = (DataType) this.DataTypes.createOwnedType(element.getName(), element.eClass());

		type.getRedefinedClassifiers().add(element);

//		this.DataTypes.getOwnedElements().add(element);
	}



}
