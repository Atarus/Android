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
	public MetalStorage ms = new MetalStorage();
	public MetalFactory m = new MetalFactory(ms.storage);
	
	
	//Initialise settings
	public Settings s = new Settings();
	
	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		
		//Increment Resources
		ms.update();
		m.update(ms.storage);
	}

	@Override
	public void paint(float deltaTime) {
		// TODO Auto-generated method stub
		
		float metalDraw = m.metal/1000.0f;
		//metalDraw = (float) Math.round(metalDraw);
		
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
		g.drawString(("Storage: " + Integer.toString(ms.storage)), (screenWidth - 500), 200, paint );
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		Settings.metal = m.metal;
		Settings.metallevel = m.level;
		Settings.metalStorage = ms.storage;
		Settings.metalStorageLevel = ms.level;
		Settings.save(game.getFileIO());
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		Settings.load(game.getFileIO());
		m.metal = Settings.metal;
		m.level = Settings.metallevel;
		ms.storage = Settings.metalStorage;
		ms.level = Settings.metalStorageLevel;
		m.metalAdd((int)Math.round(Settings.timeelapsed));
		
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
}