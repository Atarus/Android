package com.CaseySinglehurst.gametest;

import android.graphics.Color;
import android.graphics.Paint;

import com.CaseySinglehurst.framework.Game;
import com.CaseySinglehurst.framework.Graphics;
import com.CaseySinglehurst.framework.Screen;

public class ColonyView extends Screen {

	public ColonyView(Game game){
		super(game);
	}
	
	@Override
	public void update(float deltaTime){
		
	}
	
	@Override
	public void paint(float deltaTime) {
		//Initialise graphics
		Graphics g = game.getGraphics();
		int screenWidth = g.getWidth();
		int screenHeight = g.getHeight();
		g.clearScreen(0);
		
		//Initialise paint
		Paint paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setTextSize(50);
		
		//Draw screen
		renderGrid(g,screenWidth,screenHeight);
		
		//Draw Consistent Elements
		
		g.drawRect(0, 0, 50, screenHeight, Color.WHITE);
		
		
	}
	
	@Override
	public void pause() {
		
	}
	
	@Override
	public void resume() {
		
	}
	
	@Override
	public void dispose() {
		
	}
	
	@Override
	public void backButton() {
		
	}
	
	private void renderGrid(Graphics gra, int width, int height){
		//Draw Colony Grid
		int space = 100;
		int horizontalLines = height/space;
		int verticalLines = width/space + 1;
		
		
		//Draw vertical lines
		for (int i = 1; i<verticalLines; i++){
			gra.drawLine(i*space, 0, i*space, height, Color.BLUE);
		}
		
		//Draw horizontal lines
		for (int i = 1; i<horizontalLines; i++){
			gra.drawLine(0, i*space, width, i*space, Color.BLUE);
		}
	}
}
