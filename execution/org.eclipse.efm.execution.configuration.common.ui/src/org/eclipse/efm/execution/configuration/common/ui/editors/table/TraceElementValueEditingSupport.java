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
package org.eclipse.efm.execution.configuration.common.ui.editors.table;

import org.eclipse.efm.execution.core.workflow.common.TraceElement;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

public class TraceElementValueEditingSupport extends EditingSupport {

	private final TraceElementTableViewer fTraceElementTableViewer;

	private final TableViewer fTableViewer;

	private final CellEditor fCellEditor;

	public TraceElementValueEditingSupport(TraceElementTableViewer traceElementTableViewer) {
		super(traceElementTableViewer.getTableViewer());

		this.fTraceElementTableViewer = traceElementTableViewer;

		this.fTableViewer = traceElementTableViewer.getTableViewer();

		this.fCellEditor = new TextCellEditor(fTableViewer.getTable());
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		TraceElement traceElement = (TraceElement) element;
		switch( traceElement.getNature() ) {
		case TIPS:
			return null;
		default:
			return fCellEditor;
		}
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		return ((TraceElement) element).getValue();
	}

	@Override
	protected void setValue(Object element, Object userInputValue) {
		TraceElement traceElement = (TraceElement) element;

		switch( traceElement.getNature() ) {
		case TIPS:
			break;
		case UNDEFINED:
			traceElement.setNature(
					fTraceElementTableViewer.getTableConfig().DEFAULT_TRACE_NATURE );

			fTraceElementTableViewer.addNewElementItemForDoubleClick();

			//!NO BREAK!
		default:
			final String newValue = String.valueOf(userInputValue);

			if( (traceElement.getValue() != userInputValue)
				&& (! traceElement.getValue().equals(newValue)) )
			{
				traceElement.setValue(String.valueOf(userInputValue));

				if( newValue.isEmpty() ) {
					traceElement.setValue( traceElement.getNature().getLiteral() + "_new" );
				}
				fTableViewer.update(element, null);
			}
			break;
		}
	}

}
