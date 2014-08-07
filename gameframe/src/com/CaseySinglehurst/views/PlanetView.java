package com.CaseySinglehurst.views;

import java.util.List;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.CaseySinglehurst.facilities.*;
import com.CaseySinglehurst.framework.Game;
import com.CaseySinglehurst.framework.Graphics;
import com.CaseySinglehurst.framework.Screen;
import com.CaseySinglehurst.framework.Input.TouchEvent;
import com.CaseySinglehurst.gametest.Settings;

public class PlanetView extends Screen {
	
	public PlanetView(Game game, Screen lastView) {
		super(game);
		// TODO Auto-generated constructor stub
	}
	
	
	//Set time delay
	public static final int TIME_DELAY = 1000;
	
	//Initialise facilities
	private MetalResource m;
	private CrystalResource c;
	private FuelResource f;
	private PopulationResource p;
	
	//Initialise settings
	Settings settings = new Settings();
	
	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		Graphics g = game.getGraphics();
		int screenWidth = g.getWidth();
		int screenHeight = g.getHeight();
		
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		int len = touchEvents.size();
		
		for (int i = 0; i < len; i++) {
			Log.i("check event", "GameScreen: " + Integer.toString(i));
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
            	if (event.x > 50 && event.x < (screenWidth-50)){
            		if (event.y > (screenHeight/3) && event.y < screenHeight){
            			game.setScreen(new ColonyView(game));
            		}
            	}
                    
            }
        }
	}

	@Override
	public void paint(float deltaTime) {
		// TODO Auto-generated method stub
		
		//Create draw variables.
		float metalDraw = m.getMetal()/1000.0f;
		float crystalDraw = c.getCrystal()/1000.0f;
		float fuelDraw = f.getFuel()/1000.0f;
		float popDraw = p.getPopulation()/1000.0f;
		
		//Initialise graphics
		Graphics g = game.getGraphics();
		int screenWidth = g.getWidth();
		int screenHeight = g.getHeight();
		
		//Initialise paint
		Paint paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setTextSize(40);
		
		//Clear Screen
		g.clearScreen(0);
		
		//Draw UI
		g.drawRect(0,0,screenWidth,75,Color.DKGRAY);
		
		g.drawRect(100, 12, 50, 50, Color.RED);
		g.drawString((String.format("%.1f", metalDraw) + "k"), 175, 50, paint);
		g.drawRect(300, 12, 50, 50, Color.BLUE);
		g.drawString((String.format("%.1f", crystalDraw) + "k"), 375, 50, paint);
		g.drawRect(500, 12, 50, 50, Color.GREEN);
		g.drawString((String.format("%.1f", fuelDraw) + "k"), 575, 50, paint);
		g.drawRect(700, 12, 50, 50, Color.YELLOW);
		g.drawString((String.format("%.1f", popDraw) + "k"), 775, 50, paint);
		
		//Draw Sidebars
		g.drawRect(0, 0, 50, screenHeight, Color.WHITE);
		g.drawRect(screenWidth-50, 0, 50, screenHeight, Color.WHITE);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		Settings.setMetal(m);
		Settings.setCrystal(c);
		Settings.setFuel(f);
		Settings.setPopulation(p);
		
		Settings.save(game.getFileIO());
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		Settings.load(game.getFileIO());
		
		resumeMetal();
		resumeCrystal();
		resumeFuel();
		resumePopulation();
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void backButton() {
		// TODO Auto-generated method stub
	}
	public void onCreate() {
		
	
	}
	
	void resumeMetal(){
		m = new MetalResource(Settings.metalLevel, Settings.metal, Settings.metalStorageLevel, Settings.metalStorage);
		m.update();
		m.addMetal((int)Math.round(Settings.timeElapsed));
	}
	
	void resumeCrystal(){
		c = new CrystalResource(Settings.crystalLevel, Settings.crystal, Settings.crystalStorageLevel, Settings.crystalStorage);
		c.update();
		c.addCrystal((int)Math.round(Settings.timeElapsed));
	}
	
	void resumeFuel(){
		f = new FuelResource(Settings.fuelLevel, Settings.fuel, Settings.fuelStorageLevel, Settings.fuelStorage);
		f.update();
		f.addFuel((int)Math.round(Settings.timeElapsed));
	}
	
	void resumePopulation(){
		p = new PopulationResource(Settings.populationLevel, Settings.population, Settings.populationStorageLevel, Settings.populationStorage);
		p.update();
		p.addPopulation((int)Math.round(Settings.timeElapsed));
	}
	
}