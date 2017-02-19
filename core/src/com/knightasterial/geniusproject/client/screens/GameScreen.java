package com.knightasterial.geniusproject.client.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.knightasterial.geniusproject.common.world.WorldController;

public class GameScreen implements Screen{
	
	Game mainClass;
	SpriteBatch batch;
	OrthographicCamera inGameCam;
	Texture test;
	WorldController worldController;
	
	public GameScreen(Game parentGame, WorldController worldController){
		mainClass = parentGame;
		this.worldController = worldController;
		
		//sets camera and spritebatch
		batch = new SpriteBatch();
		inGameCam = new OrthographicCamera();
		inGameCam.setToOrtho(false, 1000, 800);
		
		test = new Texture(Gdx.files.internal("badlogic.jpg"));
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		
		//UPDATES GAME LOGIC
		worldController.update(delta);
		
		//DOES ALL THE DRAWINGS AND STUFF
		inGameCam.update();
		batch.setProjectionMatrix(inGameCam.combined);
		
		batch.begin();
		
		batch.draw(worldController.player.getImage(), worldController.player.getX(), worldController.player.getY());
		
		batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		
		
	}

}
