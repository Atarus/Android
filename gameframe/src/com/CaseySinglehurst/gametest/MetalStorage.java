package com.CaseySinglehurst.gametest;

public class MetalStorage {
	int level = 1, storage = 0, baseStorage = 10000;
	
	MetalStorage(){
		
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
