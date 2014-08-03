package com.CaseySinglehurst.gametest;

import java.util.Timer;
import java.util.TimerTask;

public class CrystalFactory {
	int level = 1, crystal = 0;
	
	CrystalFactory(){
		
		Timer  timer = new Timer();
		TimerTask task = new TimerTask(){
			public void run(){
				addCrystal();
			}
		};
		
		timer.scheduleAtFixedRate(task,1000,1000);  
	}
	
	void addCrystal(){
		crystal += (int)Math.round((50 + Math.exp(level)));
	}
}
