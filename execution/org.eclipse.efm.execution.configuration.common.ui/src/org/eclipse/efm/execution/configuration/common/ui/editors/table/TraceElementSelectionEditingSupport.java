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
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;

public class TraceElementSelectionEditingSupport extends EditingSupport {

	private final TraceElementTableViewer fTraceElementTableViewer;

	private final TableViewer fTableViewer;

	private final CellEditor fCellEditor;

	public TraceElementSelectionEditingSupport(TraceElementTableViewer traceElementTableViewer) {
		super(traceElementTableViewer.getTableViewer());

		this.fTraceElementTableViewer = traceElementTableViewer;

		this.fTableViewer = traceElementTableViewer.getTableViewer();

		this.fCellEditor = new CheckboxCellEditor(
				fTableViewer.getTable(), SWT.CHECK | SWT.READ_ONLY);
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
		return ((TraceElement) element).isSelected();
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
			traceElement.setValue(
					fTraceElementTableViewer.getTableConfig().DEFAULT_TRACE_NATURE.getLiteral()
					+ "_new" );

			fTraceElementTableViewer.addNewElementItemForDoubleClick();
			break;
		default:
			traceElement.setSelected((Boolean) userInputValue);
			break;
		}

		fTableViewer.update(element, null);
	}

}
