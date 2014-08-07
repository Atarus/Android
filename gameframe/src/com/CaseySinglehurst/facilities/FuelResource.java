package com.CaseySinglehurst.facilities;

import java.util.Timer;
import java.util.TimerTask;

public class FuelResource {
	private final int baseLevel = 1, baseIncrease = 10, baseStorage = 10000;
	private int level = 1, fuel = 0, storageLevel = 0, storage = 0;
	
	FuelResource(){
		
		Timer  timer = new Timer();
		TimerTask task = new TimerTask(){
			public void run(){
				addFuel(1);
			}
		};
		
		timer.scheduleAtFixedRate(task,1000,1000);  
	}
	
	public FuelResource(int newLevel, int newFuel, int newStorageLevel, int newStorage){
		level = newLevel;
		fuel = newFuel;
		storageLevel = newStorageLevel;
		storage = newStorage;
		
		Timer  timer = new Timer();
		TimerTask task = new TimerTask(){
			public void run(){
				addFuel(1);
			}
		};
		
		timer.scheduleAtFixedRate(task,1000,1000);
	}
	
	public void addFuel(int times){
		//fuel += (int)Math.round((10 + Math.exp(level)));
		
		int incrementValue = ((int)Math.round((baseIncrease + Math.exp(level)))*times);
		
		if ((fuel+incrementValue)<=storage){
			fuel+=incrementValue;
		} else if ((fuel+incrementValue) > storage){
			fuel = storage;
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
	
	public int getFuel(){
		return fuel;
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
	
	public void setMetal(int newFuel){
		fuel = newFuel;
	}
	
	public void setStorageLevel(int newStorageLevel){
		storageLevel = newStorageLevel;
	}
	
	public void setStorage(int newStorage){
		storage = newStorage;
	}
	
}
