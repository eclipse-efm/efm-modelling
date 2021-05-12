/*****************************************************************************
* Copyright (c) 2021 CEA LIST.
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
package org.eclipse.efm.formalml.plantuml;

import java.util.Map;
import java.util.UUID;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.efm.formalml.plantuml"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}


    private final BiMap<UUID, EObject> elementsMap = HashBiMap.create();

    private synchronized EObject get(final UUID uuid) {
        return elementsMap.get(uuid);
    }

    private synchronized UUID register(final EObject eObj) {
        final Map<EObject, UUID> map = elementsMap.inverse();
        UUID uuid = map.get(eObj);
        if (uuid != null) return uuid;
        uuid = UUID.randomUUID();
        elementsMap.put(uuid, eObj);
        return uuid;
    }

    public static EObject findEObject(final UUID uuid) {
        return getDefault().get(uuid);
    }

    public static UUID registerEObject(final EObject eObj) {
        return getDefault().register(eObj);
    }


}
