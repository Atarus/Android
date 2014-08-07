package com.CaseySinglehurst.facilities;

import java.util.Timer;
import java.util.TimerTask;

public class MetalResource {
	//Facility Value
	private final int facilityID = 1;
	//Base Values
	private final int baseLevel = 1, baseIncrease = 100, baseStorage = 10000;
	//Current Values
	private int level = 1, metal = 0, storageLevel = 0, storage = 0;
	//Built Value
	private boolean built = false;
	//Base costs (metal, crystal, fuel, population)
	private int[] baseCosts = {1000,1000,1000,1000};
	//Current costs (metal, crystal, fuel, population)
	private int[] costs = {0,0,0,0};
	//Location on the view where the facility is placed
	public int x = 3, y= 3;
	
	public MetalResource(){
		
		level = baseLevel;
		storageLevel = baseLevel;
		storage = baseStorage;
		
		Timer  timer = new Timer();
		TimerTask task = new TimerTask(){
			public void run(){
				addMetal(1);
			}
		};
		
		timer.scheduleAtFixedRate(task,1000,1000);  
		
	}	
	
	public MetalResource(int newLevel, int newMetal, int newStorageLevel, int newStorage){
		level = newLevel;
		metal = newMetal;
		storageLevel = newStorageLevel;
		storage = newStorage;
		
		Timer  timer = new Timer();
		TimerTask task = new TimerTask(){
			public void run(){
				addMetal(1);
			}
		};
		
		timer.scheduleAtFixedRate(task,1000,1000);
	}
	
	public void addMetal(int times){
		//metal += ((int)Math.round((100 + Math.exp(level)))*times);
		int incrementValue = ((int)Math.round((baseIncrease + Math.exp(level)))*times);
		
		if ((metal+incrementValue)<=storage){
			metal+=incrementValue;
		} else if ((metal+incrementValue) > storage){
			metal = storage;
		} 
		
	}
	
	public void update(){
		if (level > 0){
			built = true;
		}
		
		if (storage < baseStorage){
			storage = baseStorage;
		}
		
		//For development only
		if (storage > baseStorage){
			storage = baseStorage;
		}
		
		for (int i = 0; i<costs.length; i++){
			costs[i] = baseCosts[i] * level;
		}
	}
	
	public int getID(){
		return facilityID;
	}
	
	public int getLevel(){
		return level;
	}
	
	public int getMetal(){
		return metal;
	}
	
	public int getStorageLevel(){
		return storageLevel;
	}
	
	public int getStorage(){
		return storage;
	}
	
	public boolean isBuilt(){
		return built;
	}
	
	public void setLevel(int newLevel){
		level = newLevel;
	}
	
	public void setMetal(int newMetal){
		metal = newMetal;
	}
	
	public void setStorageLevel(int newStorageLevel){
		storageLevel = newStorageLevel;
	}
	
	public void setStorage(int newStorage){
		storage = newStorage;
	}
	
	public void setBuilt(boolean newBuilt){
		built = newBuilt;
	}
}
