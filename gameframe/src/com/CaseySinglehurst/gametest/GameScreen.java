package com.CaseySinglehurst.gametest;

import android.graphics.Color;
import android.graphics.Paint;

import com.CaseySinglehurst.framework.Game;
import com.CaseySinglehurst.framework.Graphics;
import com.CaseySinglehurst.framework.Screen;

public class GameScreen extends Screen {

	public GameScreen(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}
	
	//Set time delay
	public static final int TIME_DELAY = 1000;
	
	//Initialise facilities
	public MetalStorage ms; //= new MetalStorage();
	public MetalFactory m; //= new MetalFactory(ms.storage);
	
	public CrystalStorage cs;
	public CrystalFactory c;
	
	public FuelStorage fs;
	public FuelFactory f;
	
	public PopulationStorage ps;
	public PopulationFactory p;
	
	//Initialise settings
	public Settings s = new Settings();
	
	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		
		//ms.update();
		//m.updateFactory(m.storage);
		
	}

	@Override
	public void paint(float deltaTime) {
		// TODO Auto-generated method stub
		
		//Create draw variables.
		float metalDraw = m.metal/1000.0f;
		float crystalDraw = c.crystal/1000.0f;
		float fuelDraw = f.fuel/1000.0f;
		float popDraw = p.population/1000.0f;
		
		//Initialise graphics
		Graphics g = game.getGraphics();
		int screenWidth = g.getWidth();
		int screenHeight = g.getHeight();
		
		//Initialise paint
		Paint paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setTextSize(50);
		
		//Draw
		g.clearScreen(0);
		g.drawRect(0, 0, 200, screenHeight, Color.WHITE);
		
		g.drawString(("Metal: " + String.format("%.1f", metalDraw) + "k"), (screenWidth - 500), 100, paint);
		g.drawString(("Crystal: " + String.format("%.1f", crystalDraw) + "k"), (screenWidth - 500), 200, paint);
		g.drawString(("Fuel: " + String.format("%.1f", fuelDraw) + "k"), (screenWidth - 500), 300, paint);
		g.drawString(("Pop: " + String.format("%.1f", popDraw) + "k"), (screenWidth - 500), 400, paint);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		Settings.setMetal(m.metal,m.level,ms.storage,ms.level);
		Settings.setCrystal(c.crystal,c.level,cs.storage,cs.level);
		Settings.setFuel(f.fuel,f.level,fs.storage,fs.level);
		Settings.setPopulation(p.population,p.level,ps.storage,ps.level);
		
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
		ms = new MetalStorage();
		m = new MetalFactory(ms.storage);
		
		ms.storage = Settings.metalStorage;
		ms.level = Settings.metalStorageLevel;
		m.metal = Settings.metal;
		m.level = Settings.metalLevel;
		
		ms.update();
		m.updateFactory(ms.storage);
		
		m.addMetal((int)Math.round(Settings.timeelapsed));
	}
	
	void resumeCrystal(){
		cs = new CrystalStorage();
		c = new CrystalFactory(cs.storage);
		
		cs.storage = Settings.crystalStorage;
		cs.level = Settings.crystalStorageLevel;
		c.crystal = Settings.crystal;
		c.level = Settings.crystalLevel;
		
		cs.update();
		c.updateFactory(cs.storage);
		
		c.addCrystal((int)Math.round(Settings.timeelapsed));
	}
	
	void resumeFuel(){
		fs = new FuelStorage();
		f = new FuelFactory(fs.storage);
		
		fs.storage = Settings.fuelStorage;
		fs.level = Settings.fuelStorageLevel;
		f.fuel = Settings.fuel;
		f.level = Settings.fuelLevel;
		
		fs.update();
		f.updateFactory(fs.storage);
		
		f.addFuel((int)Math.round(Settings.timeelapsed));
	}
	
	void resumePopulation(){
		ps = new PopulationStorage();
		p = new PopulationFactory(ps.storage);
		
		ps.storage = Settings.populationStorage;
		ps.level = Settings.populationStorageLevel;
		p.population = Settings.population;
		p.level = Settings.populationLevel;
		
		ps.update();
		p.updateFactory(ps.storage);
		
		p.addPopulation((int)Math.round(Settings.timeelapsed));
	}
}