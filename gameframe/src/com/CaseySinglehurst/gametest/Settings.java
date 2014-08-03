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
    public static int metallevel = 1;
    public static int metalStorage = 1000;
    public static int metalStorageLevel = 1;
    public static long oldtime = System.currentTimeMillis(), newtime = System.currentTimeMillis(), timeelapsed;

   
    public static void save(FileIO files) {
        BufferedWriter out = null;
        try {
            
            // Writes a file called .savedata to the SD Card
            out = new BufferedWriter(new OutputStreamWriter(
                    files.writeFile(".savedata")));
            
            // Line by line ("\n" creates a new line), write the value of each variable to the file.
            out.write(Integer.toString(metal));
            out.write("\n");
            
            out.write(Integer.toString(metallevel));
            out.write("\n");
            
            out.write(Integer.toString(metalStorage));
            out.write("\n");
            
            out.write(Integer.toString(metalStorageLevel));
            out.write("\n");
            
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
            metal = Integer.parseInt(in.readLine());
            metallevel = Integer.parseInt(in.readLine());
            metalStorage = Integer.parseInt(in.readLine());
            metalStorageLevel = Integer.parseInt(in.readLine());
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
    
    
   

}