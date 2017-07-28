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
package org.eclipse.efm.tutorial.thermostat.utils;
public class Couple<A, B> extends java.lang.Object {
		
		private A a;
		private B b;
		
		public Couple (A a0, B b0) {
		    a = a0;
		    b = b0;
		}
		
		public A first() {
		    return a;
		}
		
		public B second() {
		    return b;
		}
		
	    }