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

import org.eclipse.jface.text.Region
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.parser.IParseResult
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.Pair
import org.eclipse.xtext.util.Tuples
import org.eclipse.jface.text.IRegion
import org.eclipse.emf.ecore.EObject

/** Inspired by {@link EObjectAtOffsetHelper} */
public class FormalMLKeywordAtOffsetHelper {
	
	def public Pair<EObject, IRegion> resolveKeywordAt(XtextResource resource, int offset) {
		val IParseResult parseResult = resource.getParseResult();
		if (parseResult !== null) {
			var ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(
					parseResult.getRootNode(), offset);
			if (leaf !== null && leaf.isHidden() && leaf.getOffset() == offset) {
				leaf = NodeModelUtils.findLeafNodeAtOffset(
						parseResult.getRootNode(), offset - 1);
			}
			if (leaf !== null && leaf.getGrammarElement() instanceof Keyword) {
				val keyword = leaf.getGrammarElement() as Keyword
				return Tuples.create(keyword,
						new Region(leaf.getOffset(), leaf.getLength()));
			}
		}
		return null;
	}
}
