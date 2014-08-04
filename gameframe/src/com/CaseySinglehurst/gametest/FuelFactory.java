package com.CaseySinglehurst.gametest;

import java.util.Timer;
import java.util.TimerTask;

public class FuelFactory {
	int level = 1, fuel = 0, storage = 0;
	
	FuelFactory(int newStorage){
		storage = newStorage;
		
		Timer  timer = new Timer();
		TimerTask task = new TimerTask(){
			public void run(){
				addFuel(1);
			}
		};
		
		timer.scheduleAtFixedRate(task,1000,1000);  
	}
	
	void addFuel(int times){
		//fuel += (int)Math.round((10 + Math.exp(level)));
		
		int incrementValue = ((int)Math.round((10 + Math.exp(level)))*times);
		
		if ((fuel+incrementValue)<=storage){
			fuel+=incrementValue;
		} else if ((fuel+incrementValue) > storage){
			fuel = storage;
		} 
	}
	
	void updateFactory(int newStorage){
		storage = newStorage;
	}
	
}
