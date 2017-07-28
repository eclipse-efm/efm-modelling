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

public class Thermostat implements Runnable{
	
	int Tmax = 20 ;
	int Tmin = 25;
	int t;
	
	Channel<Integer> sens;
	Channel<Integer> screen;
	Channel<Integer> dt;
	Channel<Integer> amount;
	Channel<Integer> error;
	//private int y;
	
	public Thermostat(Channel<Integer> sens, Channel<Integer> screen, Channel<Integer> dt,
			Channel<Integer> amount, Channel<Integer> error) {
		super();
		this.sens = sens;
		this.screen = screen;
		this.dt = dt;
		this.amount = amount;
		this.error = error;
	}	
		
	public void run(){
		
		t = sens.receive();
		
		if (t < Tmin) {
			dt.send(t);
			System.out.println("dt!"+t+"\n");
			
		} else {

		}
		boolean equipNotDone = true;
		while (equipNotDone){
			try {
				Thread.sleep (10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//y = amount.receive();
			
		}
		
		
		
		
	}
}
