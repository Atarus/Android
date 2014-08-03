package com.CaseySinglehurst.gametest;

import java.util.Timer;
import java.util.TimerTask;

public class MetalFactory {
	int level = 1, metal = 0;
	
	MetalFactory( ){
	
	
	
		 
	Timer  timer = new Timer();
	TimerTask task = new TimerTask(){
		public void run(){
			metaladd(1);
		}
	};
	
	
	 timer.scheduleAtFixedRate(task,1000,1000);  
	}	
	void metaladd(int times){
		 metal += ((int)Math.round((100 + Math.exp(level)))*times);
	}
	
	
}
