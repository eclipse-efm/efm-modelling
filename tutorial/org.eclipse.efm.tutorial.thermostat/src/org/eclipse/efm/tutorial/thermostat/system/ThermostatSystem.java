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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import org.eclipse.efm.tutorial.thermostat.utils.Couple;

public class ThermostatSystem {
		
	static Channel<Integer> dt = new Channel<Integer>();
	static Channel<Integer> amount = new Channel<Integer>();
	static Channel<Integer> error = new Channel<Integer>();
	static Channel<Integer> sens = new Channel<Integer>();
	static Channel<Integer> screen = new Channel<Integer>();
	
	static Vector<Couple<Integer,Boolean>> inputTrace = new Vector<Couple<Integer,Boolean>>();
		
	
	static Thermostat therm = new Thermostat(sens,screen,dt,amount,error);
	static Equipement equip  = new Equipement(dt,amount,error);

	static int delay;
	static int t;

	static int Tmin = 20;
	static int Tmax = 25 ;
	static int HeatingDisplay = 1 ;
	static int CoolinggDisplay = 2 ;
	static int StandbyDisplay = 3 ;
	
	public enum Mode {
	    COOLING, HEATING, STANDBY	
    }
	static Mode mode = Mode.STANDBY;
	
	static FileReader inputTraceFile;
	
	static String inputTracePath;
	
	static String logdirName;
	
	static void readInputTrace(){
		
		
		
		
		try {
			//inputTraceFile = new FileReader("inputTrace/inputTrace.txt");
			inputTraceFile = new FileReader(inputTracePath);
		 
        BufferedReader br = new BufferedReader(inputTraceFile);
        String line;
			
			//System.out.println(line.toString());
			
			//long b = System.currentTimeMillis();
        	
	        while((line = br.readLine())!= null){
	        	if (line.startsWith("TRACE NUMBER")) continue;
	        	//String delims = "[?!]+";
	        	String delims = "=";
	        	String[] parts = line.split(delims);
	        	
	        	if (parts.length == 2){
	        		 //case of reading a delay
	        		inputTrace.add(new Couple<Integer, Boolean>(Integer.parseInt(parts[1].trim()),
        					false));
	        		
	        	}else{
	        		
	        		//case of reading an input value
	        		String strTMP = parts[0].trim();
	        		String[] parts1 = strTMP.split("\\(");
	        		
	        		String[] parts2 = parts1[1].split("\\)");
	        		
	        		inputTrace.add(new Couple<Integer, Boolean>(Integer.parseInt(parts2[0]),
        					true));
	        		
	        		
	        	}   	 	
	        }
	        
	        br.close();
		}catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NumberFormatException e2){
			
			System.out.println("Check the formatting of your input file..");
			
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 2)
			{
	
			inputTracePath = args[0]; // E.g. "inputTrace/inputTrace.txt"
			logdirName = args[1]; // E.g. "outputTrace";
		
			readInputTrace();
			
			(new File(logdirName)).mkdir();
			File logfile = new File(logdirName+"/mergeTrace.txt"); 			
				
				
				    FileWriter logwriter = null;
				    try {
				        logwriter = new FileWriter(logfile);
				        
				        if (inputTrace.size() != 0){ 
				        //System.out.printf("File is located at %s%n", logfile.getAbsolutePath());
				        	        
					        if (!inputTrace.firstElement().second()){
					        	
					        	logwriter.write("delta = "+inputTrace.firstElement().first()+"\n");
					        	inputTrace.remove(0);
					        }
							
					        for (Couple<Integer, Boolean> elemInputTrace : inputTrace) {
								
					        	if (elemInputTrace.second()){
					        		therm.sens.send(elemInputTrace.first());
					        		logwriter.write("INPUT sens("+elemInputTrace.first()+")\n");
					        		continue;
					        	}else{
					        		delay = elemInputTrace.first();
					        	}
								t = therm.sens.receive();
								
								//logwriter.write("1\n");
								
								if (t < Tmin && (mode == Mode.HEATING || mode == Mode.STANDBY)) {	
									
									mode = Mode.HEATING;
									
																	
									logwriter.write("delta = 1\n");
									delay = delay-1;
									//logwriter.write("OUTPUT screen("+mode+")\n");
									logwriter.write("OUTPUT screen("+"1"+")\n");
									
									if (delay >= 1){
									
										delay = delay-1;
									
										logwriter.write("delta = 1\n");
									
									
										
										therm.dt.send(Tmin-t);
										
										equip.x = equip.dt.receive();
										
										logwriter.write("OUTPUT dt("+(Tmin-t)+")\n");
										if (delay >= 2){
											logwriter.write("delta = 2\n");
											delay = delay-2;
											
											while (equip.x > 0){
												equip.x = equip.x-4;
												amount.send(4);
												logwriter.write("OUTPUT equip("+4+")\n");
												if (delay < 1){
													break;
												}
												logwriter.write("delta = 1\n");
												delay--;							
											}
										}
										
									}
									
									
								}	
								else{
									if (t > Tmax && (mode == Mode.COOLING || mode == Mode.STANDBY)) {	
										
										mode = Mode.COOLING;
										
										
										logwriter.write("delta = 1\n");
										delay = delay-1;
										//logwriter.write("OUTPUT screen("+mode+")\n");
										logwriter.write("OUTPUT screen("+"2"+")\n");
										
										if (delay >= 1){
											
											delay = delay-1;
											
											logwriter.write("delta = 1\n");
										
										
											
											therm.dt.send(Tmax-t);
											
											equip.x = equip.dt.receive();
										
											logwriter.write("OUTPUT dt("+(Tmax-t)+")\n");
											
											if (delay >= 2){
												logwriter.write("delta = 2\n");
												delay = delay-2;
												
												while (equip.x < 0){
													equip.x = equip.x+4;
													amount.send(-4);
													logwriter.write("OUTPUT equip("+-4+")\n");
													if (delay < 1){
														break;
													}
													logwriter.write("delta = 1\n");
													delay--;							
												}
											}
										}
										
									}else{ // case Tmin <= t <= Tmax
										
										if ((t > Tmin && mode == Mode.HEATING) || (t < Tmax && mode == Mode.COOLING)) {
											
											logwriter.write("delta = 1\n");
											delay--;
											logwriter.write("dt!0\n");
											if(delay < 2){
												logwriter.write("delta = 1\n");
											}else{
												logwriter.write("delta = 2\n");
												delay = delay-2;
											}
											logwriter.write("OUTPUT equip(0)\n");
											
											mode = Mode.STANDBY;
										}
									}
								}
								if (delay > 0){
									logwriter.write("delta = "+delay+"\n");
								} if (delay <= 0) {
									//continue;
									break;
								}
					        }
				        } 
				        
				        
				        
				    } catch (IOException e) {
				        e.printStackTrace(); // rather declare method with throws IOException and omit this catch.
				    } finally {
				        if (logwriter != null) try { logwriter.close(); } catch (IOException ignore) {}
				    }
		    
			
		}
		else
		{
			System.out.println("Wrong argument number.");
		}
	}
}
