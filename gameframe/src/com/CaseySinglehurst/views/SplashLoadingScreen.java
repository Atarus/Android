package com.CaseySinglehurst.views;

import java.util.List;

import com.CaseySinglehurst.framework.Game;
import com.CaseySinglehurst.framework.Graphics;
import com.CaseySinglehurst.framework.Screen;
import com.CaseySinglehurst.framework.Graphics.ImageFormat;
import com.CaseySinglehurst.framework.Input.TouchEvent;
import com.CaseySinglehurst.gametest.Assets;

public class SplashLoadingScreen extends Screen {
    public SplashLoadingScreen(Game game) {
        super(game);
    }

    @Override
    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.Splashscreen= g.newImage("Splashscreen.png", ImageFormat.ARGB8888);
        
        game.setScreen(new LoadingScreen(game));

    }

    @Override
    public void paint(float deltaTime) {

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