/**
 * ****************************************************************************
 * Copyright (c) 2017 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Boutheina BANNOUR (CEA LIST) boutheina.bannour@gmail.com
 *  - Initial API and implementation
 * ****************************************************************************/
package org.eclipse.efm.tutorial.thermostat.system;

public class Equipement {
	
	Channel<Integer> dt;
	Channel<Integer> amount;
	Channel<Integer> error;
	int x;

	public Equipement(Channel<Integer> dt, Channel<Integer> amount,
			Channel<Integer> error) {
		super();
		this.dt = dt;
		this.amount = amount;
		this.error = error;
	}
	
	
	
}
