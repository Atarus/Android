package com.CaseySinglehurst.gametest;

import java.util.Timer;
import java.util.TimerTask;

public class PopulationFactory {
	int level = 1, population = 0;
	
	PopulationFactory(){
		
		Timer  timer = new Timer();
		TimerTask task = new TimerTask(){
			public void run(){
				addPopulation();
			}
		};
		
		timer.scheduleAtFixedRate(task,1000,1000);  
	}
	
	void addPopulation(){
		population += (int)Math.round((10 + Math.exp(level)));
	}
	
}
