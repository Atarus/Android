package com.CaseySinglehurst.gametest;

import com.CaseySinglehurst.framework.Screen;
import com.CaseySinglehurst.framework.implementation.AndroidGame;

public class GameClass extends AndroidGame {
    @Override
    public Screen getInitScreen() {
        return new LoadingScreen(this); 
    }
    @Override
    public void onBackPressed() {
    getCurrentScreen().backButton();
    }
}
