/*****************************************************************************
* Copyright (c) 2012 CEA LIST.
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*  Arnault Lapitre (CEA LIST) arnault.lapitre@cea.fr
*  - Initial API and implementation
*****************************************************************************/
package org.eclipse.efm.sew.xtext

import org.eclipse.xtext.conversion.IValueConverterService
import org.eclipse.efm.sew.xtext.converter.AtIdentifierValueConverter

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class SEWRuntimeModule extends AbstractSEWRuntimeModule {

    override public Class<? extends IValueConverterService> bindIValueConverterService() {
        return AtIdentifierValueConverter;
    }
}
