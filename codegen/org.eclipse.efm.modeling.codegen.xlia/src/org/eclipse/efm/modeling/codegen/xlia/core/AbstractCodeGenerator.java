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
package org.eclipse.efm.modeling.codegen.xlia.core;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.efm.modeling.codegen.xlia.util.SimpleLogger;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

public abstract class AbstractCodeGenerator {

	/**
	 * SCXMLCodeGenerator Supervisor
	 */
	protected MainCodeGenerator fSupervisor;

	/**
	 * LOGGER
	 */
	protected SimpleLogger LOGGER;

	/**
	 * Constructor
	 */
	public AbstractCodeGenerator() {
		super();

		fSupervisor = null;

		this.LOGGER = new SimpleLogger();
	}


	/**
	 * Constructor
	 * @param supervisor
	 */
	public AbstractCodeGenerator(MainCodeGenerator supervisor) {
		super();

		this.fSupervisor = supervisor;

		this.LOGGER = supervisor.LOGGER;
	}


	/**
	 *Init Util, LOGGER, ...
	 * @return false if initialization is failed
	 */
	public boolean reset() {
		return LOGGER.reset();
	}

	public void log(IStatus aStatus) {
		LOGGER.log(aStatus);
	}

	/**
	 * GETTER
	 * Reort Logger
	 */
	public SimpleLogger getReportLogger() {
		return LOGGER;
	}

	/**
	 * Error/warning reporting
	 */
	public void report() {
		LOGGER.report();
	}


	public void performTransformError(
			AbstractCodeGenerator context, Element element) {
		if( element instanceof NamedElement ) {
			LOGGER.error( ( new StringBuilder(context.getClass().getSimpleName()) )
				.append( ":> unexpected " )
				.append( element.getClass().getSimpleName() )
				.append( ' ' )
				.append( ((NamedElement)element).getQualifiedName() )
				.toString() );
		}
		else {
			LOGGER.error( ( new StringBuilder(context.getClass().getSimpleName()) )
				.append( ":> unexpected " )
				.append( element.getClass().getSimpleName() )
				.append( ' ' )
				.append( element.toString() )
				.toString() );
		}
	}


}
