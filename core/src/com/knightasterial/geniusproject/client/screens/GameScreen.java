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
import com.knightasterial.geniusproject.common.bullets.BasicBullet;
import com.knightasterial.geniusproject.common.entities.IEntity;
import com.knightasterial.geniusproject.common.util.GameConstants;
import com.knightasterial.geniusproject.common.world.WorldController;

public class GameScreen implements Screen{
	
	Game mainClass;
	SpriteBatch batch;
	OrthographicCamera inGameCam;
	Texture test;
	WorldController worldController;
	ShapeRenderer sRender;
	BitmapFont font;
	OrthographicCamera hudCam;
	
	public GameScreen(Game parentGame, WorldController worldController){
		mainClass = parentGame;
		this.worldController = worldController;
		
		//sets camera and spritebatch
		batch = new SpriteBatch();
		inGameCam = new OrthographicCamera();
		inGameCam.setToOrtho(false, GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
		
		//FOREVER AND ALWAYS SET TO CONSTANT WIDTH HEIGHT
		hudCam = new OrthographicCamera();
		hudCam.setToOrtho(false, GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
		
		test = new Texture(Gdx.files.internal("badlogic.jpg"));
		
		sRender = new ShapeRenderer();
		font = new BitmapFont(Gdx.files.internal("fonts/arial-15.fnt"),false);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		
		//UPDATES GAME LOGIC
		worldController.update(delta);
		
		//TO MAKE CAM FOLLOW PLAYER
		//inGameCam.position.set(worldController.player.getPosition(), 0); 
		
		//UPDATES CAMERA
		inGameCam.update();
		hudCam.update();
		
		
		
		//DRAW GAME
		batch.setProjectionMatrix(inGameCam.combined);
		batch.begin();
		
		batch.draw(worldController.player.getImage(), worldController.player.getLowerLeftX(), worldController.player.getLowerLeftY());
		
		for (IEntity temp : worldController.zombieList){
			batch.draw(temp.getImage(), temp.getLowerLeftX(), temp.getLowerLeftY());
			
		}
		
		for (BasicBullet bullet : worldController.bulletList){
			batch.draw(bullet.getImage(), bullet.getX(), bullet.getY(), 
					 0, 0, 40, 2, 												//width on screen
					 1, 1, bullet.getRotation(), 
					 0, 0, 40, 2, 												//coords from Texture
					 false, false);
		}
		
		
		
		batch.end();
		
		//DRAW HUD
		batch.setProjectionMatrix(hudCam.combined);
		batch.begin();
		font.draw(batch, "Current Gun: " + worldController.currentGun.getName(), 5,GameConstants.WINDOW_HEIGHT-5);
		font.draw(batch, "Current Ammo: " + worldController.currentGun.getDisplayText(), 5,GameConstants.WINDOW_HEIGHT-25);
		batch.end();
		

		sRender.setProjectionMatrix(inGameCam.combined);
		sRender.begin(ShapeType.Line);
		sRender.setColor(Color.RED);
		
		/*
		//draw zombie hitboxes
		for (IEntity temp : worldController.zombieList){
			sRender.circle(temp.getHitbox().x, temp.getHitbox().y, temp.getHitbox().radius);
			
		}
		//draw bullet hitboxes
		for (BasicBullet temp : worldController.bulletList){
			sRender.polygon(temp.getHitboxVertices());
		}
		*/
		
		/*
		sRender.circle(IOUtil.getMouseX(), IOUtil.getMouseY(), 2);
		
		*/
		sRender.end();

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
	
	public OrthographicCamera getInGameCam(){
		return inGameCam;
	}

}
