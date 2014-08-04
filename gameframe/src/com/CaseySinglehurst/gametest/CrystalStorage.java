package com.CaseySinglehurst.gametest;

public class CrystalStorage {
	int level = 1, storage = 0, baseStorage = 10000;
	
	CrystalStorage(){
		
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
