package com.CaseySinglehurst.views;

import android.graphics.Bitmap;
import android.util.Log;

import com.CaseySinglehurst.framework.Game;
import com.CaseySinglehurst.framework.Graphics;
import com.CaseySinglehurst.framework.Image;
import com.CaseySinglehurst.framework.Graphics.ImageFormat;
import com.CaseySinglehurst.framework.Screen;
import com.CaseySinglehurst.gametest.Assets;


public class LoadingScreen extends Screen {
	int timer = 0;
    public LoadingScreen(Game game) {
        
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.Menuscreen= g.newImage("Menuscreen.jpg", ImageFormat.ARGB8888);
        Assets.Planet = g.newImage("planet.png", ImageFormat.ARGB8888);
        timer+=1;
        
        if (timer > 60){
        game.setScreen(new MainMenuScreen(game));
        }
    }

    @Override
    public void paint(float deltaTime) {
        Graphics g = game.getGraphics();
        //g.drawImage(Assets.Splashscreen, 0, 0);
       // g.drawImage(Assets.Splashscreen, 20, 20,120,120,800, 800);
        g.drawScaledImage(Assets.Splashscreen, 0, 0, g.getWidth(), g.getHeight(), 0, 0,
        		Assets.Splashscreen.getWidth(),Assets.Splashscreen.getHeight());
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