package com.CaseySinglehurst.gametest;

import java.util.Timer;
import java.util.TimerTask;

public class FuelFactory {
	int level = 1, fuel = 0;
	
	FuelFactory(){
		
		Timer  timer = new Timer();
		TimerTask task = new TimerTask(){
			public void run(){
				addFuel();
			}
		};
		
		timer.scheduleAtFixedRate(task,1000,1000);  
	}
	
	void addFuel(){
		fuel += (int)Math.round((10 + Math.exp(level)));
	}
	
}
