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

public class Channel<Type> {
	Type v;
	String name;
	
	void send(Type t){
		
		this.v = t;
		
	}
	
	Type receive(){
		return v;
	}

}
