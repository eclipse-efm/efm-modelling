/*****************************************************************************
* Copyright (c) 2016 CEA LIST.
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*****************************************************************************/
package org.eclipse.efm.papyrus.view.property.concretesyntax.internal.job;

import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.efm.papyrus.view.property.concretesyntax.ActivatorXLIAProperties;
import org.eclipse.efm.papyrus.view.property.concretesyntax.sheet.EditingPropertySection;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.ServiceUtils;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;

public class ExecuteCommandJob extends Job {

	protected EditingPropertySection fPropertySection;

	protected ArrayList< Command > fTransactionalCommands;

	protected ArrayList< Command > fExecutedCommands;

	public ExecuteCommandJob(EditingPropertySection propertySection,
			Command command) {
		super("name");

		fPropertySection = propertySection;

		fTransactionalCommands = new ArrayList<Command>();
		fTransactionalCommands.add(command);

		fExecutedCommands = new ArrayList<Command>();
	}

	protected TransactionalEditingDomain getEditingDomain() {
		ServicesRegistry registry = null;
		try {
			registry = ServiceUtilsForResource.getInstance().getServiceRegistry(
					fPropertySection.getContextObject().eResource());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		TransactionalEditingDomain domain = null;
		if (registry != null) {
			try {
				domain = ServiceUtils.getInstance().getTransactionalEditingDomain(registry);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		return domain;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		monitor.beginTask("Propagate xLIA specification into the model", 4);

		this.fExecutedCommands.clear();

		IStatus jobStatus = Status.OK_STATUS;

		TransactionalEditingDomain domain = this.getEditingDomain();
//		if (domain != null) {
//			domain = fPropertySection.getTransactionalEditingDomain();
//		}

		if (domain != null) {
			/* Protect the resource in case of concurrent jobs */
			monitor.subTask("Prepare compilation");
			Resource resource = fPropertySection.getContextObject().eResource();
			monitor.worked(1);
			synchronized (resource) {
				/* 1. Do not listen to modifications that occur on the resource during compilation */
				resource.setTrackingModification(false);

				/* 2. Do compilation phase */
//				jobStatus = this.doCompilation(domain, monitor);

				/* 3. Save the textual representation within the model */
				if (monitor.isCanceled()) {
					return Status.CANCEL_STATUS;
				} else if (jobStatus.equals(Status.OK_STATUS)) {
					jobStatus = this.doExecuteCommand(domain, monitor);
				} else {
					return jobStatus;
				}

				/* 4. Restore the modification tracking */
				resource.setTrackingModification(true);
			}
		}
		monitor.done();
		return jobStatus;
	}

	/**
	 * Execute the save procedure
	 *
	 * @param domain
	 *            - the editing domain in which the modifications are done
	 * @param monitor
	 *            - the monitor used to report progress
	 * @return a status reporting the state of the job
	 */
	protected IStatus doExecuteCommand(
			TransactionalEditingDomain domain, IProgressMonitor monitor) {

		monitor.subTask("Merge specification");

		try {
			for(Command command : fTransactionalCommands) {
				domain.getCommandStack().execute(command);

				fExecutedCommands.add(command);

				monitor.worked(1);
			}
		}
		catch (Exception e) {
			return new Status(Status.ERROR, ActivatorXLIAProperties.PLUGIN_ID,
					"An unexpected error stopped the merging phase");
		}

		return Status.OK_STATUS;
	}



}
