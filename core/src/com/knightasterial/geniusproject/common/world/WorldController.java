package com.knightasterial.geniusproject.common.world;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.knightasterial.geniusproject.common.entities.BaseZombieEntity;
import com.knightasterial.geniusproject.common.entities.IZombie;
import com.knightasterial.geniusproject.common.entities.PlayerEntity;
import com.knightasterial.geniusproject.common.util.GameConstants;
import com.knightasterial.geniusproject.common.util.IOUtil;

public class WorldController {
	
	public PlayerEntity player;
	public List<IZombie> zombieList = new ArrayList<IZombie>();
	
	public WorldController(){
		init();
	}
	
	private void init(){
		player = new PlayerEntity();
	}
	
	public void update(float delta){

		//PLAYER MOVEMENT
		if (Gdx.input.isKeyPressed(Keys.W)){
			player.setY(player.getY()+GameConstants.BASE_PLAYER_SPEED*delta);
		}
		if (Gdx.input.isKeyPressed(Keys.S)){
			player.setY(player.getY()-GameConstants.BASE_PLAYER_SPEED*delta);
		}
		if (Gdx.input.isKeyPressed(Keys.D)){
			player.setX(player.getX()+GameConstants.BASE_PLAYER_SPEED*delta);
		}
		if (Gdx.input.isKeyPressed(Keys.A)){
			player.setX(player.getX()-GameConstants.BASE_PLAYER_SPEED*delta);
		}
		//SPAWN ZOMBIES
		if (Gdx.input.justTouched()){
			zombieList.add(new BaseZombieEntity(IOUtil.getMouseX(), IOUtil.getMouseY(), 0f));
		}
		
		
		//ZOMBIE MOVEMENT
		for (IZombie zombie : zombieList){
			zombie.moveTowards(player.getPosition(), delta, zombieList);
		}
		
		

	}

}
