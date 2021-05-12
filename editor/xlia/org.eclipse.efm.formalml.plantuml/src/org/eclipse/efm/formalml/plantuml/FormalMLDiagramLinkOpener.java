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

import java.util.UUID;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.XtextEditor;

import net.sourceforge.plantuml.eclipse.utils.ILinkOpener;
import net.sourceforge.plantuml.eclipse.utils.LinkData;

public class FormalMLDiagramLinkOpener implements ILinkOpener {

    public static final String FML_PLINK_SCHEME = "pfml";

    private URI getURI(final LinkData link) {
        try {
            return URI.createURI(link.href);
        } catch (final IllegalArgumentException e) {
        }
        return null;
    }

    public static URI getEObjectLink(final EObject eObj) {
        final UUID uuid = Activator.registerEObject(eObj);
        if (uuid == null) return null;
        return URI.createGenericURI(FML_PLINK_SCHEME, uuid.toString(), null);
    }


    @Override
    public int supportsLink(final LinkData link) {
        final URI uri = getURI(link);
        if ((uri != null) && (FML_PLINK_SCHEME.equals(uri.scheme()))) {
            return CUSTOM_SUPPORT;
        }
        return NO_SUPPORT;
    }


    private IPath getPath(final EObject eObj) {
        final Resource r = eObj.eResource();
        if (r == null) return null;

        URI uri = r.getURI();
        uri = r.getResourceSet().getURIConverter().normalize(uri);
        final int size = uri.segmentCount();
        if ((size > 1)
            && ("platform".equals(uri.scheme()))
            && ("resource".equals(uri.segment(0)))) {
            final StringBuilder path = new StringBuilder();
            for (int i = 1; i < size; i++) {
                path.append('/');
                path.append(URI.decode(uri.segment(i)));
            }
            return new Path(path.toString());
        } else {
            return new Path(uri.devicePath());
        }
    }

    private EObject getEObject(final URI uri) {
        final String str = uri.opaquePart();
        if (str == null) return null;
        try {
            final UUID uuid = UUID.fromString(str);
            return Activator.findEObject(uuid);
        } catch (final IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public void openLink(final LinkData link) {
        final URI uri = getURI(link);
        if (uri == null) return;
        final EObject eObj = getEObject(uri);
        if (eObj == null) return;

        try {
            final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
            final IPath path = getPath(eObj);
            final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
            final IEditorPart editor = IDE.openEditor(page, file);
            if (editor instanceof XtextEditor) {
                final XtextEditor xeditor = (XtextEditor) editor;
                final ICompositeNode node = NodeModelUtils.getNode(eObj);
                xeditor.selectAndReveal(node.getOffset(), node.getLength());
            }
        } catch (final PartInitException e) {
        }
    }


}
