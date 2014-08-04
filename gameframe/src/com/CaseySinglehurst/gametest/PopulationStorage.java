package com.CaseySinglehurst.gametest;

public class PopulationStorage {
	int level = 1, storage = 0, baseStorage = 10000;
	
	PopulationStorage(){
		
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
