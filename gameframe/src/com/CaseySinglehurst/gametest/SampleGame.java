package com.CaseySinglehurst.gametest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.util.Log;

import com.CaseySinglehurst.facilities.*;
import com.CaseySinglehurst.framework.Screen;
import com.CaseySinglehurst.framework.implementation.AndroidGame;
import com.CaseySinglehurst.views.SplashLoadingScreen;

public class SampleGame extends AndroidGame {

	public Settings s = new Settings();
	
	@Override
	public Screen getInitScreen() {
		// TODO Auto-generated method stub
		return new SplashLoadingScreen(this);
	}
}
 