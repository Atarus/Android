package com.CaseySinglehurst.facilities;

import java.util.Timer;
import java.util.TimerTask;

public class CrystalResource {
	private final int baseLevel = 1, baseIncrease = 50, baseStorage = 10000;
	private int level = 1, crystal = 0, storageLevel = 0, storage = 0;
	
	CrystalResource(){
		
		Timer  timer = new Timer();
		TimerTask task = new TimerTask(){
			public void run(){
				addCrystal(1);
			}
		};
		
		timer.scheduleAtFixedRate(task,1000,1000);  
	}
	
	public CrystalResource(int newLevel, int newCrystal, int newStorageLevel, int newStorage){
		level = newLevel;
		crystal = newCrystal;
		storageLevel = newStorageLevel;
		storage = newStorage;
		
		Timer  timer = new Timer();
		TimerTask task = new TimerTask(){
			public void run(){
				addCrystal(1);
			}
		};
		
		timer.scheduleAtFixedRate(task,1000,1000);
	}
	
	public void addCrystal(int times){
		//crystal += (int)Math.round((50 + Math.exp(level)));
		
		int incrementValue = ((int)Math.round((baseIncrease + Math.exp(level)))*times);
		
		if ((crystal+incrementValue)<=storage){
			crystal+=incrementValue;
		} else if ((crystal+incrementValue) > storage){
			crystal = storage;
		} 
	}
	
	public void update(){
		if (storage < baseStorage){
			storage = baseStorage;
		}
		
		//For development only
		if (storage > baseStorage){
			storage = baseStorage;
		}
	}
	
	public int getLevel(){
		return level;
	}
	
	public int getCrystal(){
		return crystal;
	}
	
	public int getStorageLevel(){
		return storageLevel;
	}
	
	public int getStorage(){
		return storage;
	}
	
	public void setLevel(int newLevel){
		level = newLevel;
	}
	
	public void setMetal(int newCrystal){
		crystal = newCrystal;
	}
	
	public void setStorageLevel(int newStorageLevel){
		storageLevel = newStorageLevel;
	}
	
	public void setStorage(int newStorage){
		storage = newStorage;
	}
}
