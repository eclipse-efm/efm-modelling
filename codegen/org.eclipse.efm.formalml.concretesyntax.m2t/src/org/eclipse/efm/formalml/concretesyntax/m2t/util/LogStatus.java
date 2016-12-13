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

import org.eclipse.core.runtime.Status;
import org.eclipse.efm.formalml.concretesyntax.m2t.Activator;

public class LogStatus extends Status {

	/** Message buffer.
	 */
	public LogStatus(int severity, String message) {
		super(severity, Activator.PLUGIN_ID, message);
	}

}
