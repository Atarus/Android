package com.CaseySinglehurst.facilities;

import java.util.Timer;
import java.util.TimerTask;

public class PopulationResource {
	private final int baseLevel = 1, baseIncrease = 1, baseStorage = 10000;
	private int level = 1, population = 0, storageLevel = 0, storage = 0;
	
	PopulationResource(){
		
		Timer  timer = new Timer();
		TimerTask task = new TimerTask(){
			public void run(){
				addPopulation(1);
			}
		};
		
		timer.scheduleAtFixedRate(task,1000,1000);  
	}
	
	public PopulationResource(int newLevel, int newPopulation, int newStorageLevel, int newStorage){
		level = newLevel;
		population = newPopulation;
		storageLevel = newStorageLevel;
		storage = newStorage;
		
		Timer  timer = new Timer();
		TimerTask task = new TimerTask(){
			public void run(){
				addPopulation(1);
			}
		};
		
		timer.scheduleAtFixedRate(task,1000,1000);
	}
	
	public void addPopulation(int times){
		//population += (int)Math.round((10 + Math.exp(level)));
		
		int incrementValue = ((int)Math.round((baseIncrease + Math.exp(level)))*times);
		
		if ((population+incrementValue)<=storage){
			population+=incrementValue;
		} else if ((population+incrementValue) > storage){
			population = storage;
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
	
	public int getPopulation(){
		return population;
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
	
	public void setMetal(int newPopulation){
		population = newPopulation;
	}
	
	public void setStorageLevel(int newStorageLevel){
		storageLevel = newStorageLevel;
	}
	
	public void setStorage(int newStorage){
		storage = newStorage;
	}
}
