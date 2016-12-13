/*******************************************************************************
 * Copyright (c) 2016 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr - Initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.papyrus.wizard.newproject.newfile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.wizards.newresource.BasicNewFileResourceWizard;
import org.osgi.framework.Bundle;

/**
 * This is a sample new wizard. Its role is to create a new file
 * resource in the provided container. If the container resource
 * (a folder or a project) is selected in the workspace
 * when the wizard is opened, it will accept it as the target
 * container. The wizard creates one file with the extension
 * "xlia". If a sample multi-page editor (also available
 * as a template) is registered for the same extension, it will
 * be able to open it.
 */

public class NewFMLFileWizard extends BasicNewFileResourceWizard implements INewWizard {

    private WizardNewFileCreationPage mainPage;


	/**
	 * Constructor for NewXliaFileWizard.
	 */
	public NewFMLFileWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	/**
	 * Adding the page to the wizard.
	 */

	public void addPages() {
        mainPage = new WizardNewFileCreationPage("newFilePage1", getSelection());//$NON-NLS-1$
        mainPage.setTitle("XLIA File");
        mainPage.setDescription("This wizard creates a new "
        		+ "eXtensible Language For Interaction & Assembly file.");

        mainPage.setFileName("new_file");
        mainPage.setFileExtension("xlia");

        addPage(mainPage);
	}

	/**
	 * This method is called when 'Finish' button is pressed in
	 * the wizard. We will create an operation and run it
	 * using wizard as execution context.
	 */
	public boolean performFinish() {
		final IPath containerPath = mainPage.getContainerFullPath();
		final String fileName = mainPage.getFileName();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(containerPath, fileName, monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * The worker method. It will find the container, create the
	 * file if missing or just replace its contents, and open
	 * the editor on the newly created file.
	 */

	private void doFinish(
		IPath containerPath,
		String fileName,
		IProgressMonitor monitor)
		throws CoreException {
		// create a sample file
		monitor.beginTask("Creating " + fileName, 2);
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource resource = root.findMember(containerPath);
		if (!resource.exists() || !(resource instanceof IContainer)) {
			throwCoreException("Container \"" + containerPath + "\" does not exist.");
		}
		IContainer container = (IContainer) resource;

//		if( container.getFile(new Path(fileName)).exists() ) {
//			IPath path = new Path(fileName);
//			String extension = path.getFileExtension();
//			path = path.removeFileExtension();
//			String lastSegment = path.lastSegment();
//
//			for( int n = 0 ; container.getFile(path).exists() ; ++n ) {
//				path = path.removeLastSegments(1).
//						append( lastSegment + n).
//						addFileExtension(extension);
//			}
//
//			fileName = path.toString();
//		}

		final IFile file = container.getFile(new Path(fileName));
		try {
			InputStream stream = openContentStream();
			if (file.exists()) {
				file.setContents(stream, true, true, monitor);
			} else {
				file.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}
		monitor.worked(1);
		monitor.setTaskName("Opening file for editing...");
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page =
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, file, true);
				} catch (PartInitException e) {
				}
			}
		});
		monitor.worked(1);
	}

	/**
	 * We will initialize file contents with a sample text.
	 */
	private final String NEW_XLIA_FILE_CONTENT =
			  "@xlia< system , 1.0 >:\n"
			+ "\n"
			+ "system mySystem {\n"
			+ "@public:\n"
			+ "	type myEnum enum { OFF , ON }\n"
			+ "\n"
			+ "	port input myInputPort( myEnum );\n"
			+ "	port output myOutputPort( int );\n"
			+ "\n"
			+ "@behavior:\n"
			+ "	statemachine myStatemachine \"my state machine\" {\n"
			+ "	@private:\n"
			+ "		var integer n;\n"
			+ "		var myEnum trigger = OFF;\n"
			+ "\n"
			+ "	@region:\n"
			+ "		state< start > q0 \"my start state\" {\n"
			+ "			@enable{\n"
			+ "				n = 0;\n"
			+ "			}\n"
			+ "			transition t0 \"my simple transition\" {\n"
			+ "				input myInputPort( trigger );\n"
			+ "			} --> qChoice;\n"
			+ "		}\n"
			+ "\n"
			+ "		state< choice > qChoice \"my choice pseudostate\" {\n"
			+ "			transition t1 {\n"
			+ "				guard( trigger == ON );\n"
			+ "				output myOutputPort( 42 );\n"
			+ "			} --> q1;\n"
			+ "\n"
			+ "			transition< else > t2 \"my else transition\" --> q0;\n"
			+ "		}\n"
			+ "\n"
			+ "		state q1 \"my simple state\" {\n"
			+ "			transition t3 {\n"
			+ "				input myInputPort( trigger );\n"
			+ "				guard( trigger == OFF );\n"
			+ "				n = 1;\n"
			+ "			} --> qFinal;\n"
			+ "\n"
			+ "			transition< else > t4 \"my else transition\" --> q0;\n"
			+ "		}\n"
			+ "\n"
			+ "		state< final > qFinal \"my final state\";\n"
			+ "	}\n"
			+ "\n"
			+ "@com:\n"
			+ "	connect< env > {\n"
			+ "		input myInputPort;\n"
			+ "		output myOutputPort;\n"
			+ "	}\n"
			+ "}\n";


	private final String NEW_FILE_XLIA = "examples/new_file.xlia";

	private InputStream openContentStream() throws IOException {
		Bundle bundle = Platform.getBundle(
				org.eclipse.efm.papyrus.wizard.newproject.Activator.PLUGIN_ID);

		URL url = bundle.getEntry(NEW_FILE_XLIA);
		if( url != null ) {
			URL xliaTemplateURL = FileLocator.toFileURL(url);
			if( url != null ) {
				return( xliaTemplateURL.openStream() );
			}
		}

		return new ByteArrayInputStream(NEW_XLIA_FILE_CONTENT.getBytes());
	}

	private void throwCoreException(String message) throws CoreException {
		IStatus status =
			new Status(IStatus.ERROR, "org.eclipse.efm.papyrus.wizard.newproject", IStatus.OK, message, null);
		throw new CoreException(status);
	}

	/**
	 * We will accept the selection in the workbench to see if
	 * we can initialize from it.
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
    @Override
	protected void initializeDefaultPageImageDescriptor() {
    	super.initializeDefaultPageImageDescriptor();
//       ImageDescriptor desc = IDEWorkbenchPlugin.getIDEImageDescriptor("wizban/newfile_wiz.png");//$NON-NLS-1$
//	   setDefaultPageImageDescriptor(desc);
    }
}