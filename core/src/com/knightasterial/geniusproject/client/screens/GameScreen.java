package com.knightasterial.geniusproject.client.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.knightasterial.geniusproject.common.entities.IEntity;
import com.knightasterial.geniusproject.common.util.GameConstants;
import com.knightasterial.geniusproject.common.util.IOUtil;
import com.knightasterial.geniusproject.common.world.WorldController;

public class GameScreen implements Screen{
	
	Game mainClass;
	SpriteBatch batch;
	OrthographicCamera inGameCam;
	Texture test;
	WorldController worldController;
	ShapeRenderer sRender;
	
	public GameScreen(Game parentGame, WorldController worldController){
		mainClass = parentGame;
		this.worldController = worldController;
		
		//sets camera and spritebatch
		batch = new SpriteBatch();
		inGameCam = new OrthographicCamera();
		inGameCam.setToOrtho(false, GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
		
		test = new Texture(Gdx.files.internal("badlogic.jpg"));
		
		sRender = new ShapeRenderer();
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
		
		BitmapFont font = new BitmapFont();
		
		batch.begin();
		
		batch.draw(worldController.player.getImage(), worldController.player.getLowerLeftX(), worldController.player.getLowerLeftY());
		
		for (IEntity temp : worldController.zombieList){
			batch.draw(temp.getImage(), temp.getLowerLeftX(), temp.getLowerLeftY());
			
		}
		font.draw(batch, IOUtil.getMouseX() + " " + IOUtil.getMouseY(), 10, 10);
		
		batch.end();
		
		/*   TO SHOW HITBOXES
		sRender.setProjectionMatrix(inGameCam.combined);
		sRender.begin(ShapeType.Filled);
		sRender.setColor(Color.RED);
		for (IEntity temp : worldController.zombieList){
			sRender.circle(temp.getHitbox().x, temp.getHitbox().y, temp.getHitbox().radius);
			
		}
		
		sRender.end();
		*/
	}

	@Override
	public void resize(int width, int height) {
		inGameCam.setToOrtho(false, width, height);
		inGameCam.update();
		
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
