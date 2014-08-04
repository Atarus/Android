package com.CaseySinglehurst.gametest;

import java.util.Timer;
import java.util.TimerTask;

public class CrystalFactory {
	int level = 1, crystal = 0, storage = 0;
	
	CrystalFactory(int newStorage){
		storage = newStorage;
		
		Timer  timer = new Timer();
		TimerTask task = new TimerTask(){
			public void run(){
				addCrystal(1);
			}
		};
		
		timer.scheduleAtFixedRate(task,1000,1000);  
	}
	
	void addCrystal(int times){
		//crystal += (int)Math.round((50 + Math.exp(level)));
		
		int incrementValue = ((int)Math.round((50 + Math.exp(level)))*times);
		
		if ((crystal+incrementValue)<=storage){
			crystal+=incrementValue;
		} else if ((crystal+incrementValue) > storage){
			crystal = storage;
		} 
	}
	
	void updateFactory(int newStorage){
		storage = newStorage;
	}
}
