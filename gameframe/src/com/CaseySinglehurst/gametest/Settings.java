package com.CaseySinglehurst.gametest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Calendar;

import com.CaseySinglehurst.framework.FileIO;

public class Settings {
    
    // Create variables that will hold the values you want to save in your game.
    // Default values:
    
    public static int metal = 0;
    public static int metalLevel = 0;
    public static int metalStorage = 0;
    public static int metalStorageLevel = 0;
    public static int crystal = 0;
    public static int crystalLevel = 0;
    public static int crystalStorage = 0;
    public static int crystalStorageLevel = 0;
    public static int fuel = 0;
    public static int fuelLevel = 0;
    public static int fuelStorage = 0;
    public static int fuelStorageLevel = 0;
    public static int population = 0;
    public static int populationLevel = 0;
    public static int populationStorage = 0;
    public static int populationStorageLevel = 0;
    
    public static long oldtime = System.currentTimeMillis(), newtime = System.currentTimeMillis(), timeelapsed;

   
    public static void save(FileIO files) {
        BufferedWriter out = null;
        try {
            
            // Writes a file called .savedata to the SD Card
            out = new BufferedWriter(new OutputStreamWriter(
                    files.writeFile(".savedata")));
            
            // Line by line ("\n" creates a new line), write the value of each variable to the file.
            out = writeMetal(out);
            out = writeCrystal(out);
            out = writeFuel(out);
            out = writePopulation(out);
           
            oldtime = System.currentTimeMillis();
            out.write(Long.toString(oldtime));
            
            
            
            
           // This section handles errors in file management!
            
        } catch (IOException e) {
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
            }
        }
    }
    
    public static void load(FileIO files) {
        BufferedReader in = null;
        try {
            // Reads file called Save Data
            in = new BufferedReader(new InputStreamReader(
                    files.readFile(".savedata")));

            // Loads values from the file and replaces default values.
            in = readMetal(in);
            in = readCrystal(in);
            in = readFuel(in);
            in = readPopulation(in);
            
            oldtime =   Long.parseLong(in.readLine());
            newtime = System.currentTimeMillis();
            timeelapsed = ((newtime - oldtime)/1000);
            
            
        } catch (IOException e) {
            // Catches errors. Default values are used.
        } catch (NumberFormatException e) {
            // Catches errors. Default values are used.
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
            }
        }
    }
    
    static BufferedWriter writeMetal(BufferedWriter metalOut){
    	try{
	    	metalOut.write(Integer.toString(metal));
	    	metalOut.write("\n");
	        
	    	metalOut.write(Integer.toString(metalLevel));
	    	metalOut.write("\n");
	        
	    	metalOut.write(Integer.toString(metalStorage));
	    	metalOut.write("\n");
	        
	    	metalOut.write(Integer.toString(metalStorageLevel));
	    	metalOut.write("\n");
    	}catch (IOException e) {}
        
    	return metalOut;
    }
    
    static BufferedWriter writeCrystal(BufferedWriter crystalOut){
    	try{
	    	crystalOut.write(Integer.toString(crystal));
	    	crystalOut.write("\n");
	        
	    	crystalOut.write(Integer.toString(crystalLevel));
	    	crystalOut.write("\n");
	        
	    	crystalOut.write(Integer.toString(crystalStorage));
	    	crystalOut.write("\n");
	        
	    	crystalOut.write(Integer.toString(crystalStorageLevel));
	    	crystalOut.write("\n");
    	}catch (IOException e) {}
    	
    	return crystalOut;
    }
    
    static BufferedWriter writeFuel(BufferedWriter fuelOut){
    	try{
    		fuelOut.write(Integer.toString(fuel));
    		fuelOut.write("\n");
	        
    		fuelOut.write(Integer.toString(fuelLevel));
    		fuelOut.write("\n");
	        
    		fuelOut.write(Integer.toString(fuelStorage));
    		fuelOut.write("\n");
	        
    		fuelOut.write(Integer.toString(fuelStorageLevel));
    		fuelOut.write("\n");
    	}catch (IOException e) {}
    	
    	return fuelOut;
    }
    
    static BufferedWriter writePopulation(BufferedWriter populationOut){
    	try{
    		populationOut.write(Integer.toString(population));
    		populationOut.write("\n");
	        
    		populationOut.write(Integer.toString(populationLevel));
    		populationOut.write("\n");
	        
    		populationOut.write(Integer.toString(populationStorage));
    		populationOut.write("\n");
	        
    		populationOut.write(Integer.toString(populationStorageLevel));
    		populationOut.write("\n");
    	}catch (IOException e) {}
    	
    	return populationOut;
    }
    
    static BufferedReader readMetal(BufferedReader metalIn){
    	try{
	    	metal = Integer.parseInt(metalIn.readLine());
	        metalLevel = Integer.parseInt(metalIn.readLine());
	        metalStorage = Integer.parseInt(metalIn.readLine());
	        metalStorageLevel = Integer.parseInt(metalIn.readLine());
    	} catch (IOException e){
    	} catch (NumberFormatException e){}
    	
    	return metalIn;
    }
    
    static BufferedReader readCrystal(BufferedReader crystalIn){
    	try{
	    	crystal = Integer.parseInt(crystalIn.readLine());
	    	crystalLevel = Integer.parseInt(crystalIn.readLine());
	    	crystalStorage = Integer.parseInt(crystalIn.readLine());
	    	crystalStorageLevel = Integer.parseInt(crystalIn.readLine());
    	} catch (IOException e){
    	} catch (NumberFormatException e){}
    	
    	return crystalIn;
    }
    
    static BufferedReader readFuel(BufferedReader fuelIn){
    	try{
	    	fuel = Integer.parseInt(fuelIn.readLine());
	    	fuelLevel = Integer.parseInt(fuelIn.readLine());
	    	fuelStorage = Integer.parseInt(fuelIn.readLine());
	    	fuelStorageLevel = Integer.parseInt(fuelIn.readLine());
    	} catch (IOException e){
    	} catch (NumberFormatException e){}
    	
    	return fuelIn;
    }
    
    static BufferedReader readPopulation(BufferedReader populationIn){
    	try{
	    	population = Integer.parseInt(populationIn.readLine());
	    	populationLevel = Integer.parseInt(populationIn.readLine());
	    	populationStorage = Integer.parseInt(populationIn.readLine());
	    	populationStorageLevel = Integer.parseInt(populationIn.readLine());
    	} catch (IOException e){
    	} catch (NumberFormatException e){}
    	
    	return populationIn;
    }

    static void setMetal(int newMetal, int newMetalLevel, int newMetalStorage, int newMetalStorageLevel){
    	metal = newMetal;
    	metalLevel = newMetalLevel;
    	metalStorage = newMetalStorage;
    	metalStorageLevel = newMetalStorageLevel;
    }

    static void setCrystal(int newCrystal, int newCrystalLevel, int newCrystalStorage, int newCrystalStorageLevel){
    	crystal = newCrystal;
    	crystalLevel = newCrystalLevel;
    	crystalStorage = newCrystalStorage;
    	crystalStorageLevel = newCrystalStorageLevel;
    }
    
    static void setFuel(int newFuel, int newFuelLevel, int newFuelStorage, int newFuelStorageLevel){
    	fuel = newFuel;
    	fuelLevel = newFuelLevel;
    	fuelStorage = newFuelStorage;
    	fuelStorageLevel = newFuelStorageLevel;
    }
    
    static void setPopulation(int newPopulation, int newPopulationLevel, int newPopulationStorage, int newPopulationStorageLevel){
    	population = newPopulation;
    	populationLevel = newPopulationLevel;
    	populationStorage = newPopulationStorage;
    	populationStorageLevel = newPopulationStorageLevel;
    }
}