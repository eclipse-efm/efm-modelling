/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Erwan Mahe (CEA LIST) erwan.mahe@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.papyrus.wizard.newproject;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelsReader;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.ui.extension.commands.IModelCreationCommand;
import org.eclipse.papyrus.uml.diagram.common.commands.CreateUMLModelCommand;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.papyrus.uml.tools.model.UmlUtils;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;



public class NewEFMprojectWizard extends BasicNewProjectResourceWizard implements INewWizard {

	private String WIZARD_NAME = "From Scratch EFM Project Wizard";
	private String WIZARD_DESC = "This wizard creates a new Eclipse Formal Modeling Project.";
	
    private WizardNewProjectCreationPage project_page;
    private WizardNewEFMmodelCreationPage model_page;

	public NewEFMprojectWizard() {
		setWindowTitle("EFM New Project");
	}


	public void addPages() {
		project_page = new WizardNewProjectCreationPage(WIZARD_NAME);
		project_page.setTitle(WIZARD_NAME);
		project_page.setDescription(WIZARD_DESC + "\nPlease enter a project name.");
        addPage(project_page);
        
        model_page = new WizardNewEFMmodelCreationPage();
        addPage(model_page);
	}


	public boolean performFinish() {
		return performFinish_RecordingCommand();
	}
	
	public boolean performFinish_RecordingCommand() {
		final ModelSet modelSet = new ModelSet();
		
		create_project_and_papyrus_model(modelSet);
		
		TransactionalEditingDomain editingDomain = modelSet.getTransactionalEditingDomain();
		
		final UmlModel umlModel = UmlUtils.getUmlModel(modelSet);
		
		RecordingCommand command = new RecordingCommand(editingDomain) {
			public void doExecute() {
				
				try {
					EObject rootNode = umlModel.lookupRoot();

					org.eclipse.uml2.uml.Package rootPackage = PackageUtil.getRootPackage((Element) rootNode);
					rootPackage.setName(model_page.getRootNodeName());
					modelSet.save(new NullProgressMonitor());
					
					URI profileURI = URI.createURI("platform:/plugin/org.eclipse.efm.formalml/resources/profile/FormalML.profile.uml");
					Profile EFM_profile = (Profile) PackageUtil.loadPackage(profileURI, rootPackage.eResource().getResourceSet());
					
					rootPackage.applyProfile(EFM_profile);
					modelSet.save(new NullProgressMonitor());
				} catch (Exception e) {
					e.printStackTrace();
					System.err.print("================================="+ "\n");
					System.err.print(e.toString());
					System.err.print("================================="+ "\n");
				}

			}
		};
		editingDomain.getCommandStack().execute(command);

		return true;
	}

	private void create_project_and_papyrus_model(ModelSet modelSet) {
		IProjectDescription desc = ResourcesPlugin.getWorkspace().newProjectDescription(project_page.getProjectName());

		IProject project = project_page.getProjectHandle();
		try {
			project.create(desc, new NullProgressMonitor());
			project.open(new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			System.err.print("=================================\n");
			System.err.print(e.toString());
			System.err.print("=================================\n");
		}
		
		String modelFilePath = project.getFullPath().toString() + "/" + model_page.getModelFileName();
		URI modelPResURI =  URI.createPlatformResourceURI(modelFilePath, true);
		
		try {
			createPapyrusModel(modelPResURI, modelSet);
		} catch (ServiceException | IOException e) {
			e.printStackTrace();
			System.err.print("=================================\n");
			System.err.print(e.toString());
			System.err.print("=================================\n");
		}
	}
	
	private void createPapyrusModel(URI modelPResURI, ModelSet modelSet) throws ServiceException, IOException {
		ModelsReader reader = new ModelsReader(); //Standard ModelsReader for Di + UML + Notation
		reader.readModel(modelSet);

		modelSet.createModels(modelPResURI); //Use an EMF URI instead of an Eclipse IFile
		ServicesRegistry registry = new ExtensionServicesRegistry(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);
		try {
			registry.add(ModelSet.class, Integer.MAX_VALUE, modelSet);
			registry.startRegistry();
		} catch (ServiceException e) {
			e.printStackTrace();
			System.err.print("================================="+ "\n");
			System.err.print(e.toString());
			System.err.print("================================="+ "\n");
		}

		IModelCreationCommand creationCommand = new CreateUMLModelCommand();
		creationCommand.createModel(modelSet);
		modelSet.save(new NullProgressMonitor());
	}
	
	private void throwCoreException(String message) throws CoreException {
		IStatus status =
			new Status(IStatus.ERROR, "org.eclipse.efm.ui.wizard.newproject", IStatus.OK, message, null);
		throw new CoreException(status);
	}


}