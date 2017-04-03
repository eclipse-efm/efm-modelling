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
package org.eclipse.efm.execution.launchconfiguration.job;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

public class SupervisorJob extends Job {

	private Process fJavaProcess;

	InputStream inputStream;
	InputStreamReader inputStreamReader;
	BufferedReader bufferedReader;


	public SupervisorJob(Process javaProcess) {
		super("SEW Supervisor");

		this.fJavaProcess = javaProcess;

		inputStream = javaProcess.getInputStream();
		inputStreamReader = new InputStreamReader(inputStream);
		bufferedReader = new BufferedReader(inputStreamReader);


		try {
			String traceLine = bufferedReader.readLine();
			System.out.println("!!!!!!!!!!!!!!!!!!!!!SupervisorJob!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println(traceLine); // ne change rien à la console ???????????
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {

//		try {
//			this.wait(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		System.err.println(" TERMINATE !!!" );

		String traceLine = null;

		try {
			while( true ) {
				if( bufferedReader.ready() ) {
					traceLine = bufferedReader.readLine();
					if( traceLine != null ) {
						if( traceLine.startsWith("@exit") ||
							traceLine.contains(":>bye") ) {
							break;
						}
						else {
							System.out.println(traceLine);
						}
					}
					else {
						break;
					}
				}

				else {
					try {
						fJavaProcess.exitValue();
						break;
					}
					catch( IllegalThreadStateException e ) {
						//!! NOTHING
					}
				}

				if( monitor.isCanceled() ) {
					fJavaProcess.destroy();

					System.out.println("\n***********************\n" +
							   	  "* EXECUTION ABORTED ! *\n" +
							   	  "***********************");

					return Status.CANCEL_STATUS;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return Status.OK_STATUS;
	}

}
