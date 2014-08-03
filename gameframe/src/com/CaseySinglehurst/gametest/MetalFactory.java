package com.CaseySinglehurst.gametest;

import java.util.Timer;
import java.util.TimerTask;

public class MetalFactory {
	int level = 1, metal = 0, storage = 0;
	
	MetalFactory(int newStorage){
		storage = newStorage;
		
		Timer  timer = new Timer();
		TimerTask task = new TimerTask(){
			public void run(){
				metalAdd(1);
			}
		};
		
		timer.scheduleAtFixedRate(task,1000,1000);  
		
	}	
	
	void metalAdd(int times){
		int incrementValue = ((int)Math.round((100 + Math.exp(level)))*times);
		
		if ((metal+incrementValue) > storage){
			metal = storage;
		} else if ((metal+incrementValue)<=storage){
			metal+=incrementValue;
		}
		
	}
	
	void update(int newStorage){
		storage = newStorage;
	}
}
