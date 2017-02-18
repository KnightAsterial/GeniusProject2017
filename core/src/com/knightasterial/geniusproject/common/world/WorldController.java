package com.knightasterial.geniusproject.common.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.knightasterial.geniusproject.common.entities.PlayerEntity;

public class WorldController {
	
	public PlayerEntity player;
	
	public WorldController(){
		init();
	}
	
	private void init(){
		player = new PlayerEntity();
	}
	
	public void update(float delta){
		if (Gdx.input.isKeyPressed(Keys.W)){
			player.setY(player.getY()+200*delta);
		}
		if (Gdx.input.isKeyPressed(Keys.S)){
			player.setY(player.getY()-200*delta);
		}
		if (Gdx.input.isKeyPressed(Keys.D)){
			player.setX(player.getX()+200*delta);
		}
		if (Gdx.input.isKeyPressed(Keys.A)){
			player.setX(player.getX()-200*delta);
		}

	}

}
