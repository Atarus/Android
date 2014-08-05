package com.CaseySinglehurst.gametest;

import java.util.List;

import android.util.Log;

import com.CaseySinglehurst.framework.Game;
import com.CaseySinglehurst.framework.Graphics;
import com.CaseySinglehurst.framework.Screen;
import com.CaseySinglehurst.framework.Input.TouchEvent;

public class MainMenuScreen extends Screen {
    public MainMenuScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        
        int len = touchEvents.size();

        Log.i("im in","hello");
        for (int i = 0; i < len; i++) {
        	Log.i("check event", "MainMenu: " + Integer.toString(i));
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                	g.clearScreen(0);
                    game.setScreen(new GameScreen(game));
            } else {
            	
            }
        }
    }

//    private boolean inBounds(TouchEvent event, int x, int y, int width,
//            int height) {
//        if (event.x > x && event.x < x + width - 1 && event.y > y
//                && event.y < y + height - 1)
//            return true;
//        else
//            return false;
//    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        g.clearScreen(255);
        g.drawImage(Assets.Menuscreen, 0, 0);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    	//Empty the event list from the splash screen.
    	List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void backButton() {
        android.os.Process.killProcess(android.os.Process.myPid());

    }
}
 