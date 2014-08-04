package com.CaseySinglehurst.gametest;

public class FuelStorage {
int level = 1, storage = 0, baseStorage = 10000;
	
	FuelStorage(){
		
	}
	
	void update(){
		if (storage < baseStorage){
			storage = baseStorage;
		}
		
		//For development only
		if (storage > baseStorage){
			storage = baseStorage;
		}
	}
}
