package com.CaseySinglehurst.gametest;

import java.util.Timer;
import java.util.TimerTask;

public class PopulationFactory {
	int level = 1, population = 0, storage = 0;
	
	PopulationFactory(int newStorage){
		storage = newStorage;
		
		Timer  timer = new Timer();
		TimerTask task = new TimerTask(){
			public void run(){
				addPopulation(1);
			}
		};
		
		timer.scheduleAtFixedRate(task,1000,1000);  
	}
	
	void addPopulation(int times){
		//population += (int)Math.round((10 + Math.exp(level)));
		
		int incrementValue = ((int)Math.round((1 + Math.exp(level)))*times);
		
		if ((population+incrementValue)<=storage){
			population+=incrementValue;
		} else if ((population+incrementValue) > storage){
			population = storage;
		} 
	}
	
	void updateFactory(int newStorage){
		storage = newStorage;
	}
}
