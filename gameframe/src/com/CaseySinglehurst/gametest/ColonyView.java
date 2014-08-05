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
		
		//Initialise paint
		Paint paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setTextSize(50);
		
		//Draw Consistent Elements
		g.clearScreen(0);
		g.drawRect(0, 0, 50, screenHeight, Color.WHITE);
		
		//Draw Colony Grid
		int horizontalLines = screenHeight/50;
		int verticalLines = screenWidth/50;
		
		//Draw vertical lines
		for (int i = 0; i<verticalLines; i++){
			g.drawLine(i*100, 0, i*100, screenHeight, Color.BLUE);
		}
		
		//Draw horizontal lines
		for (int i = 0; i<horizontalLines; i++){
			g.drawLine(0, i*100, screenWidth, i*100, Color.BLUE);
			
			if (i == 5){
				g.drawString("Missing Line?", (screenWidth - 500), i*100, paint);
			}
		}
		
		g.drawString(("hLines: " + Integer.toString(horizontalLines)), (screenWidth - 500), 100, paint);
		g.drawString(("vLines: " + Integer.toString(verticalLines)), (screenWidth - 500), 200, paint);
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
}
