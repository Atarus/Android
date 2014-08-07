package com.CaseySinglehurst.views;

import java.util.List;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.CaseySinglehurst.facilities.CrystalResource;
import com.CaseySinglehurst.facilities.FuelResource;
import com.CaseySinglehurst.facilities.MetalResource;
import com.CaseySinglehurst.facilities.PopulationResource;
import com.CaseySinglehurst.framework.Game;
import com.CaseySinglehurst.framework.Graphics;
import com.CaseySinglehurst.framework.Screen;
import com.CaseySinglehurst.framework.Input.TouchEvent;
import com.CaseySinglehurst.gametest.Settings;

public class ColonyView extends Screen {

	public ColonyView(Game game){
		super(game);
	}
	
	Settings settings = new Settings();
	
	private MetalResource m;
	private CrystalResource c;
	private FuelResource f;
	private PopulationResource p;
	
	
	private final int mapSizeX = 10;
	private final int mapSizeY = 10;
	private final int mapSpace = 100;
	private int[] mapCoord = new int[2];
	private int[][] mapGrid;
	
	private boolean dragStart = false;
	private int[] dragStartCoords = new int[2];
	
	@Override
	public void update(float deltaTime){
		//Get screen info
		Graphics g = game.getGraphics();
		int screenWidth = g.getWidth();
		int screenHeight = g.getHeight();
		
		//Deal with touch events
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		int len = touchEvents.size();
		
		for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.x > 50 && event.x < screenWidth-50){
            	if (event.type == TouchEvent.TOUCH_DRAGGED) {
                	if (!dragStart){
                		dragStartCoords[0] = event.x;
                		dragStartCoords[1] = event.y;
                		dragStart = true;
                	} else {
                		mapCoord[0] += (event.x - dragStartCoords[0]);
                		mapCoord[1] += (event.y - dragStartCoords[1]);
                		dragStartCoords[0] = event.x;
                		dragStartCoords[1] = event.y;
                	}
                } else if (event.type == TouchEvent.TOUCH_UP){
                	dragStart = false;
                }
            }
        }
	}
	
	@Override
	public void paint(float deltaTime) {
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
		
		//Render Facilities
		renderFacilities(g,screenWidth,screenHeight);
		
		//Render Grid
		renderGrid(g,screenWidth,screenHeight);
		
		//Draw UI
		renderUI(g,paint, screenWidth, screenHeight);
		
		//Draw Sidebars
		renderLeftSidebar(g,paint, screenWidth, screenHeight);
		renderRightSidebar(g,paint, screenWidth, screenHeight);
		
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
		
		mapCoord[0] = game.getGraphics().getWidth()/2;
		mapCoord[1] = game.getGraphics().getHeight()/2;
		mapGridSetup();
	}
	
	@Override
	public void dispose() {
		
	}
	
	@Override
	public void backButton() {
		
	}
	
	private void renderUI(Graphics gra, Paint paintDraw, int viewWidth, int viewHeight){
		gra.drawRect(0,0,viewWidth,75,Color.DKGRAY);
		
		gra.drawRect(100, 12, 50, 50, Color.RED);
		renderResourceString(gra,m.getMetal(),175,50,paintDraw);
		gra.drawRect(300, 12, 50, 50, Color.BLUE);
		renderResourceString(gra,c.getCrystal(),375,50,paintDraw);
		gra.drawRect(500, 12, 50, 50, Color.GREEN);
		renderResourceString(gra,f.getFuel(),575,50,paintDraw);
		gra.drawRect(700, 12, 50, 50, Color.YELLOW);
		renderResourceString(gra,p.getPopulation(),775,50,paintDraw);
	}
	
	private void renderLeftSidebar(Graphics gra, Paint paintDraw, int viewWidth, int viewHeight){
		gra.drawRect(0, 0, 50, viewHeight, Color.WHITE);
	}
	
	private void renderRightSidebar(Graphics gra, Paint paintDraw, int viewWidth, int viewHeight){
		gra.drawRect(viewWidth-50, 0, 50, viewHeight, Color.WHITE);
	}
	
	private void renderGrid(Graphics gra, int viewWidth, int viewHeight){
		//Draw Colony Grid
		int gridWidth = mapSpace * mapSizeX;
		int gridHeight = mapSpace * mapSizeY;
		
		int cornerX = mapCoord[0] - (gridWidth/2);
		int cornerY = mapCoord[1] - (gridHeight/2);
		
		//Draw vertical lines
		for (int i = 0; i<mapSizeX+1; i++){
			gra.drawLine(cornerX+(i*mapSpace), cornerY, cornerX+(i*mapSpace), (cornerY+gridHeight), Color.BLUE);
		}
		
		//Draw horizontal lines
		for (int i = 0; i<mapSizeY+1; i++){
			gra.drawLine(cornerX, cornerY+(i*mapSpace), (cornerX+gridWidth), cornerY+(i*mapSpace), Color.BLUE);
		}
	}
	
	private void renderFacilities(Graphics gra, int viewWidth, int viewHeight){
		
		for (int i = 0; i<mapSizeX; i++){
			for (int j = 0; j<mapSizeY; j++){
				if (mapGrid[i][j] != 0){
					int facilityValue = mapGrid[i][j];
					
					switch (facilityValue){
						case 1: renderFacility(gra,viewWidth,viewHeight, m.isBuilt(), m.x, m.y); break;
					}
				}
			}
		}
	}
	
	private void renderFacility(Graphics graph, int vWidth, int vHeight, boolean checkBuilt, int fX, int fY){
		//if (checkBuilt){
			int gridCornerX = mapCoord[0]-((mapSpace*(mapSizeX))/2);
			int gridCornerY = mapCoord[1]-((mapSpace*(mapSizeY))/2);
		
			int cornerX = gridCornerX+(fX*mapSpace);
			int cornerY = gridCornerY+(fY*mapSpace);
			
			graph.drawRect(cornerX, cornerY, mapSpace, mapSpace, Color.WHITE);
		//}
		
	}
	
	private void renderResourceString(Graphics gra, int resourceValue, int xDraw, int yDraw, Paint paintDraw ){
		
		if (resourceValue < 1000){
			float resourceDraw = (float) resourceValue;
			gra.drawString(Float.toString(resourceDraw), xDraw, yDraw, paintDraw);
		} else if (resourceValue < 1000000){
			float resourceDraw = resourceValue/1000.0f;
			gra.drawString((String.format("%.1f", resourceDraw) + "K"), xDraw, yDraw, paintDraw);
		} else {
			float resourceDraw = resourceValue/1000000.0f;
			gra.drawString((String.format("%.1f", resourceDraw) + "M"), xDraw, yDraw, paintDraw);
		}
		
		
	}
	
	private void mapGridSetup(){
		mapGrid = new int[mapSizeX][mapSizeY];
		
		//Enter all the facilities into the grid
		mapGrid[m.x][m.y] = m.getID();
		//mapGrid[c.x][c.y] = c.getID();
		//mapGrid[f.x][f.y] = f.getID();
		//mapGrid[p.x][p.y] = p.getID();
	}

	private void resumeMetal(){
		m = new MetalResource(Settings.metalLevel, Settings.metal, Settings.metalStorageLevel, Settings.metalStorage);
		m.update();
		m.addMetal((int)Math.round(Settings.timeElapsed));
	}
	
	private void resumeCrystal(){
		c = new CrystalResource(Settings.crystalLevel, Settings.crystal, Settings.crystalStorageLevel, Settings.crystalStorage);
		c.update();
		c.addCrystal((int)Math.round(Settings.timeElapsed));
	}
	
	private void resumeFuel(){
		f = new FuelResource(Settings.fuelLevel, Settings.fuel, Settings.fuelStorageLevel, Settings.fuelStorage);
		f.update();
		f.addFuel((int)Math.round(Settings.timeElapsed));
	}
	
	private void resumePopulation(){
		p = new PopulationResource(Settings.populationLevel, Settings.population, Settings.populationStorageLevel, Settings.populationStorage);
		p.update();
		p.addPopulation((int)Math.round(Settings.timeElapsed));
	}

}
