package com.knightasterial.geniusproject;

import java.util.List;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.knightasterial.geniusproject.client.screens.GameScreen;
import com.knightasterial.geniusproject.common.world.WorldController;

public class GeniusProject extends Game {

	List<Screen> screensToDispose;
	WorldController worldController;
	GameScreen inGameScreen;
	
	@Override
	public void create () {
		worldController = new WorldController();
		inGameScreen = new GameScreen(this, worldController);
		setScreen(inGameScreen);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//renders the current set screen
		super.render();		
	}
	
	@Override
	public void resize(int width, int height){
		super.resize(width, height);
	}
	
	@Override
	public void pause(){
		super.pause();
	}
	
	@Override
	public void resume(){
		super.resume();
	}
	
	@Override
	public void dispose () {
		inGameScreen.dispose();
	}
}
