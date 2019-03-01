/**
 * Copyright (c) 2018 CEA LIST.
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
package org.eclipse.efm.formalml.xtext.ui.hover

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider

class FormalMLEObjectDocumentationProvider implements IEObjectDocumentationProvider {
	
	override String getDocumentation(EObject element) {
		switch( element ) {
//		Machine:
//			return "This is a nice Machine with nice <b>markup</b> in the <i>documentation</i>"
			
		default: return null
		}
	}
	
}