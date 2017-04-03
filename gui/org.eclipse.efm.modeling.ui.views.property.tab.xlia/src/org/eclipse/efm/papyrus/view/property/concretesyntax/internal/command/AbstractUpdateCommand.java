/*****************************************************************************
* Copyright (c) 2016 CEA LIST.
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*****************************************************************************/
package org.eclipse.efm.papyrus.view.property.concretesyntax.internal.command;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.uml2.uml.Element;

public abstract class AbstractUpdateCommand extends RecordingCommand {

	protected static final String EMPTY = ""; //$NON-NLS-1$

	protected static final String ANY = "any"; //$NON-NLS-1$


	protected final String fNewEditedText;
	protected final String fOldEditedText;

	public AbstractUpdateCommand(Element context,
			String newEditedText, String oldEditedText) {
		super(TransactionUtil.getEditingDomain(context));

		fNewEditedText = newEditedText;
		fOldEditedText = oldEditedText;
	}


	/**
	 * Compile the description provided by the textual representation and merge
	 * them within the current model element
	 */
	@Override
	protected void doExecute() {
		try {
			if( compile() ) {
				if( merge() ) {
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected abstract boolean compile();

	protected abstract boolean merge();


	////////////////////////////////////////////////////////////////////////////
	// xLIA TEXT EXTRACTION UTILS
	////////////////////////////////////////////////////////////////////////////

	protected String extractXliaCode(String editedText,
			int fromIndex, String[] beginMarks, String[] endMarks) {
		int beginIndex = beginIndexOf(editedText, fromIndex, beginMarks);
		if( beginIndex >= fromIndex ) {
			int endIndex = endIndexOf(editedText, beginIndex, endMarks );

			if( endIndex > beginIndex ) {
				editedText = editedText.substring(beginIndex, endIndex);

				return( formatString( editedText ) );
			}
			else if( endIndex == beginIndex ) {
				return(  null );
			}
			else
			{
				endIndex = editedText.lastIndexOf('}');
				if( endIndex > beginIndex ) {
					editedText = editedText.substring(beginIndex, endIndex);

					return( formatString( editedText ) );
				}
			}
		}

		return( null );
	}

	protected int beginIndexOf(
			String editedText, int fromIndex, String[] beginMarks) {
		int endIndex = -1;

		for (String beginMark : beginMarks) {
			endIndex = editedText.indexOf(beginMark, fromIndex);
			if( endIndex >= fromIndex ) {
				int mark = endIndex + beginMark.length();
				if( beginMark.startsWith("//") ) {
//					Character.LINE_SEPARATOR;
					return( editedText.indexOf(
							'\n' /*System.lineSeparator()*/, mark) );
				}
				return( mark );
			}
		}

		return( -1 );
	}

	protected int endIndexOf(
			String editedText, int fromIndex, String[] endMarks) {
		int endIndex = -1;

		for (String endMark : endMarks) {
			endIndex = editedText.indexOf(endMark, fromIndex);
			if( endIndex >= fromIndex ) {
				return( endIndex );
			}
		}

		return( -1 );
	}


	protected String formatString(String editedText) {
//		editedText = editedText.trim();
//		return( editedText.isEmpty() ? null : editedText );

		final int textLength = editedText.length();

		int pos = 0;

		while( (pos < textLength) && (editedText.charAt(pos) != '\n') &&
				Character.isWhitespace( editedText.charAt(pos) ) ) {
			pos++;
		}

		if( pos == textLength ) {
			return( null );
		}

		int beginTab = pos;
		while( (pos < textLength) &&
				Character.isWhitespace( editedText.charAt(pos) ) ) {
			pos++;
		}

		if( pos == textLength ) {
			return( null );
		}
		else if( pos == beginTab ) {
			return( editedText.trim() );
		}

		String  strTab = editedText.substring(beginTab, pos);
		editedText = editedText.trim();

		editedText = editedText.replaceAll(strTab, "\n");

		return( editedText );
	}

}
