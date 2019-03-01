/*****************************************************************************
 * Copyright (c) 2015, 2016 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   J�r�mie Tatibouet (CEA LIST)
 *
 *****************************************************************************/

package org.eclipse.efm.papyrus.view.property.concretesyntax.sheet.tooling;

import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;

public class StyledTextWithUndoRedo extends StyledText {

	public StyledTextWithUndoRedo(final Composite parent, final int style) {
		super(parent, style);
	}

	@Override
	public void replaceTextRange(final int start, final int length, final String text) {
		final int contentLength = getCharCount();
		final int end = start + length;
		if( (start <= end) && (start >= 0) && (end <= contentLength) ) {
			super.replaceTextRange(start, length, text);
		}
	}

	@Override
	public void redrawRange(final int start, final int length, final boolean clearBackground) {
		final int end = start + length;
		final int contentLength = getContent().getCharCount();
		if( (start <= end) && (start >= 0) && (end <= contentLength) ) {
			super.redrawRange(start, length, clearBackground);
		}
	}

	@Override
	public Rectangle getTextBounds(final int start, final int end) {
		final int contentLength = getCharCount();
		if( (start < 0) || (start >= contentLength) ||
			(end   < 0) || (end   >= contentLength) || (start > end) ) {
			return new Rectangle(0, 0, 0, 0);
		}
		else {
			return super.getTextBounds(start, end);
		}
	}

	@Override
	public void replaceStyleRanges(final int start, final int length, final StyleRange[] ranges) {
		try{
			super.replaceStyleRanges(start, length, ranges);
		}
		catch( final IllegalArgumentException e ){
			//!! NOTHING
		}
	}
}
