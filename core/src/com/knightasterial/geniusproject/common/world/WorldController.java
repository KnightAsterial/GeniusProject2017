package com.knightasterial.geniusproject.common.world;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.knightasterial.geniusproject.common.entities.BaseZombieEntity;
import com.knightasterial.geniusproject.common.entities.PlayerEntity;
import com.knightasterial.geniusproject.common.util.GameConstants;

public class WorldController {
	
	public PlayerEntity player;
	public List<BaseZombieEntity> zombieList = new ArrayList<BaseZombieEntity>();
	
	public WorldController(){
		init();
	}
	
	private void init(){
		player = new PlayerEntity();
	}
	
	public void update(float delta){
		//PLAYER MOVEMENT
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
		//SPAWN ZOMBIES
		if (Gdx.input.justTouched()){
			zombieList.add(new BaseZombieEntity(Gdx.input.getX(), GameConstants.WINDOW_HEIGHT - Gdx.input.getY(), 0f));
		}
		
		
		//ZOMBIE MOVEMENT
		
		
		

	}

}
