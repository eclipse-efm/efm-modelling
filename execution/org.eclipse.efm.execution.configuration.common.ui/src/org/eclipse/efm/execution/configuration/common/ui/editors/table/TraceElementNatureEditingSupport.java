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

import java.util.ArrayList;

import org.eclipse.efm.execution.core.workflow.common.TraceElement;
import org.eclipse.efm.execution.core.workflow.common.TraceElementKind;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableItem;

public class TraceElementNatureEditingSupport extends EditingSupport {

	private final TraceElementTableViewer fTraceElementTableViewer;

	private final TableViewer fTableViewer;

	private final TraceElementTableConfigProvider fTableConfig;

	private final boolean isUniqueNatureSet;

	private final ComboBoxCellEditor fCellEditor;

	private ArrayList<TraceElementKind> fUsedTraceNatures;
	private ArrayList<TraceElementKind> fUnusedTraceNatures;

	private TraceElementKind[] fValidTraceNatures;
	private String[] fValidNatures;


	public TraceElementNatureEditingSupport(TraceElementTableViewer traceElementTableViewer) {
		super(traceElementTableViewer.getTableViewer());

		this.fTraceElementTableViewer = traceElementTableViewer;

		this.fTableViewer = traceElementTableViewer.getTableViewer();

		this.fTableConfig = fTraceElementTableViewer.getTableConfig();

		isUniqueNatureSet = this.fTableConfig.UNIQUE_NATUTRE_SET;

		fValidTraceNatures = fTableConfig.VALID_TRACE_NATURES;
		fValidNatures = fTableConfig.VALID_NATURES;

		this.fCellEditor = new ComboBoxCellEditor(
				fTableViewer.getTable(), fValidNatures, SWT.READ_ONLY);

		fUsedTraceNatures = new ArrayList<TraceElementKind>();
		fUnusedTraceNatures = new ArrayList<TraceElementKind>();
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		TraceElement traceElement = (TraceElement) element;
		switch( traceElement.getNature() ) {
		case TIPS:
			return null;
		default:
			if( isUniqueNatureSet ) {
				updateValidNatures();
				fCellEditor.setItems( fValidNatures );
			}

			return fCellEditor;
		}
	}


	private void updateValidNatures() {
		fUsedTraceNatures.clear();
		for( TableItem tableItem : fTableViewer.getTable().getItems() ) {
			if( tableItem.getData() instanceof TraceElement ) {
				fUsedTraceNatures.add(
						((TraceElement) tableItem.getData()).getNature());
			}
		}

		fUnusedTraceNatures.clear();

		for (int offset = 0; offset < fTableConfig.VALID_NATURES.length; offset++) {
			fUnusedTraceNatures.add( fTableConfig.VALID_TRACE_NATURES[offset] );
		}

		fUnusedTraceNatures.removeAll( fUsedTraceNatures );

		fValidTraceNatures = new TraceElementKind[ fUnusedTraceNatures.size() ];
		fValidNatures = new String[ fUnusedTraceNatures.size() ];

		for( int offset = (fValidNatures.length - 1) ; offset >= 0 ; --offset) {
			fValidTraceNatures[offset] = fUnusedTraceNatures.get( offset );
			fValidNatures[offset] = fValidTraceNatures[offset].getLiteral();
		}
	}


	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		TraceElementKind nature = ((TraceElement) element).getNature();

		for (int offset = 0; offset < fValidTraceNatures.length; offset++) {
			if( fValidTraceNatures[offset] == nature ) {
				return offset;
			}
		}

		return 0;
	}

	@Override
	protected void setValue(Object element, Object userInputValue) {
		int offset = (Integer) userInputValue;
		if( (offset < 0) || (offset >= fValidTraceNatures.length) ) {
			offset = 0;
		}

		TraceElement traceElement = (TraceElement) element;

		switch( traceElement.getNature() ) {
		case TIPS:
			break;
		case UNDEFINED:
			if( ! TraceElementTableViewer.ADD_NEW_ELEMENT.equals(
					traceElement.getValue()) )
			{
				traceElement.setValue( fValidNatures[ offset ] + "_new" );
			}

			fTraceElementTableViewer.addNewElementItemForDoubleClick();

			//!NO BREAK!
		default:
			traceElement.setNature( fValidTraceNatures[ offset ] );
			break;
		}

		fTableViewer.update(element, null);
	}

}
