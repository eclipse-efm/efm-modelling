/*******************************************************************************
 * Copyright (c) 2016 CEA LIST
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr - initial API and implementation
 *******************************************************************************/
package org.eclipse.efm.formalml.concretesyntax.m2t.util;

import java.util.ArrayList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.MessageDialog;

public class SimpleLogger {

	protected ArrayList<IStatus> fLogs;

//	protected static IStatus fDoneStatus = new LogStatus(IStatus.INFO, "Done.");

	protected int fErrorCount;
	protected int fWarningCount;
	protected int fInfoCount;
	protected int fCancelCount;
	protected int fOkCount;


	public SimpleLogger() {
		super();

		fLogs = new ArrayList<>();
	}


	public boolean reset() {
		fLogs.clear();

		return( true );
	}

	public boolean hasError() {
		return( fErrorCount > 0 );
	}

	public boolean hasWrarning() {
		return( fWarningCount > 0 );
	}

	public boolean hasInfo() {
		return( fInfoCount > 0 );
	}

	public boolean hasCancel() {
		return( fCancelCount > 0 );
	}

	public boolean hasOk() {
		return( fOkCount > 0 );
	}

	public int getMessageDialogKind() {
		if( fErrorCount > 0) {
			return MessageDialog.ERROR;
		}
		else if( fWarningCount > 0) {
			return MessageDialog.WARNING;
		}
		else if( fInfoCount > 0) {
			return MessageDialog.INFORMATION;
		}
		else if( fCancelCount > 0) {
			return MessageDialog.CANCEL;
		}
		else if( fOkCount > 0) {
			return MessageDialog.OK;
		}
		else {
			return MessageDialog.INFORMATION;
		}
	}


	public boolean equals(IStatus aStatus, IStatus bStatus) {		
		return( (aStatus.getSeverity() == bStatus.getSeverity())
				&& (aStatus.getMessage() != null)
				&& (bStatus.getMessage() != null)
				&& aStatus.getMessage().equals(bStatus.getMessage()) );
	}

	public boolean exists(IStatus aStatus) {
		for (IStatus iStatus : fLogs) {
			if( equals(aStatus, iStatus) ) {
				return( true );
			}
		}
		
		return( false );
	}

	public void log(IStatus aStatus) {
		if( exists(aStatus) ) {
			return;
		}
		
		switch( aStatus.getSeverity() ) {
			case IStatus.ERROR:
				fErrorCount += 1;
				break;

			case IStatus.WARNING:
				fWarningCount += 1;
				break;

			case IStatus.INFO:
				fInfoCount += 1;
				break;

			case IStatus.CANCEL:
				fCancelCount += 1;
				break;

			case IStatus.OK:
				fOkCount += 1;
				break;

			default:
				break;
		}

		fLogs.add(aStatus);
	}



	protected void format(StringBuffer buffer, IStatus aStatus) {
		buffer.append("[fml2cs] "); //$NON-NLS-1$

		switch( aStatus.getSeverity() ) {
			case IStatus.ERROR:
				buffer.append( String.format("%-8s", "ERROR") ); //$NON-NLS-1$
				break;

			case IStatus.WARNING:
				buffer.append( String.format("%-8s", "WARNING") ); //$NON-NLS-1$
				break;

			case IStatus.INFO:
				buffer.append( String.format("%-8s", "INFO") ); //$NON-NLS-1$
				break;

			case IStatus.CANCEL:
				buffer.append( String.format("%-8s", "CANCEL") ); //$NON-NLS-1$
				break;

			case IStatus.OK:
				buffer.append( String.format("%-8s", "OK") ); //$NON-NLS-1$
				break;

			default:
				buffer.append( String.format("%-8s", "SEVER:") ) //$NON-NLS-1$
					.append( aStatus.getSeverity() )
					.append(" ");
				break;
		}

		buffer.append("- ")
			.append(aStatus.getMessage());
	}

	protected String format(IStatus aStatus) {
		StringBuffer buffer = new StringBuffer();

		format(buffer, aStatus);

		return buffer.toString();
	}


	public String getReport() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("[fml2cs] "); //$NON-NLS-1$
		buffer.append( String.format("%-7s", "REPORT") ); //$NON-NLS-1$
		buffer.append("- ");

		buffer.append(fErrorCount).append(" error"); //$NON-NLS-1$
		buffer.append( (fErrorCount > 1) ? "s " : " "); //$NON-NLS-1$

		buffer.append(fWarningCount).append(" warning"); //$NON-NLS-1$
		buffer.append( (fWarningCount > 1) ? "s " : " "); //$NON-NLS-1$

		if( fInfoCount > 0 ) {
			buffer.append(fInfoCount).append(" info"); //$NON-NLS-1$
			buffer.append( (fInfoCount > 1) ? "s " : " "); //$NON-NLS-1$
		}
		if( (fCancelCount + fOkCount) > 0 ) {
			buffer.append(fCancelCount + fOkCount).append(" other"); //$NON-NLS-1$
			buffer.append( ((fCancelCount + fOkCount) > 1) ? "s " : " "); //$NON-NLS-1$
		}

		buffer.append('\n');

		if( fLogs.isEmpty() ) {
//			format(buffer, fDoneStatus);
			buffer.append("[fml2cs] "); //$NON-NLS-1$
			buffer.append( String.format("%-9s", "DONE") ); //$NON-NLS-1$
			buffer.append("- FIN");
			buffer.append('\n');
		}
		else {
			for (IStatus iStatus : fLogs) {
				format(buffer, iStatus);
				buffer.append('\n');
			}
		}

		return buffer.toString();
	}

	public void report() {
		if( fLogs.isEmpty() ) {
//			System.out.println( format(fDoneStatus) );
			System.out.print( "[fml2cs] " );
			System.out.println( String.format("%-8s", "DONE.") ); //$NON-NLS-1$
		}
		else {
			for (IStatus iStatus : fLogs) {
				System.out.println( format(iStatus) );
			}
		}
	}


	public void error(String message) {
		LogStatus status = new LogStatus(IStatus.ERROR, message);
		log( status );
	}

	public void warning(String message) {
		LogStatus status = new LogStatus(IStatus.WARNING, message);
		log( status );
	}

}
