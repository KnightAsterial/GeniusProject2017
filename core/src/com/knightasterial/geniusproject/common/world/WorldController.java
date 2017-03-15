package com.knightasterial.geniusproject.common.world;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.knightasterial.geniusproject.common.bullets.BasicBullet;
import com.knightasterial.geniusproject.common.entities.BaseZombieEntity;
import com.knightasterial.geniusproject.common.entities.IZombie;
import com.knightasterial.geniusproject.common.entities.PlayerEntity;
import com.knightasterial.geniusproject.common.util.GameConstants;
import com.knightasterial.geniusproject.common.util.IOUtil;
import com.knightasterial.geniusproject.common.util.MathUtil;
import com.knightasterial.geniusproject.common.weapons.AbstractGun;
import com.knightasterial.geniusproject.common.weapons.ColtRevolver;

public class WorldController {
	
	public PlayerEntity player;
	public OrthographicCamera inGameCam = new OrthographicCamera();
	public List<IZombie> zombieList = new ArrayList<IZombie>();
	public List<BasicBullet> bulletList = new ArrayList<BasicBullet>();
	public List<AbstractGun> gunList = new ArrayList<AbstractGun>();
	public AbstractGun currentGun;
	
	private BasicBullet tempBullet;
	private IZombie tempZombie;
	private Vector2 tempVector2 = new Vector2();
	
	
	public WorldController(){
		init();
	}
	
	private void init(){
		player = new PlayerEntity();
		gunList.add(new ColtRevolver());
		currentGun = gunList.get(0);
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
		
		//SPAWN bullets
		if (Gdx.input.isTouched()){
			currentGun.fire(player, bulletList, inGameCam);
		}
		if (Gdx.input.isKeyJustPressed(Keys.R)){
			currentGun.reload();
		}
	
		
		//iterator for bullet logic
		Iterator<BasicBullet> bulletIter = bulletList.iterator();
		while (bulletIter.hasNext()){
			tempBullet = bulletIter.next();
			
			//if bullet distance from player is greater than the diagonal of the window (meaning if it is off the screen)
			if (tempBullet.getPosition().dst(player.getPosition()) > Math.sqrt(  Math.pow(Gdx.graphics.getWidth(), 2) + Math.pow(Gdx.graphics.getHeight(), 2)  )){
				tempBullet.dispose();
				bulletIter.remove();
			}
			
			//if bullet has already hit a thing (cannot damage)
			if (!tempBullet.canDamage()){
				tempBullet.dispose();
				bulletIter.remove();
			}
			

			for (IZombie zombieToHit : zombieList){
				if (!tempBullet.canDamage()){
					break;
				}
				else{
					if (MathUtil.overlaps(tempBullet.getHitbox(), zombieToHit.getHitbox(), tempVector2)){
						zombieToHit.setHealth(zombieToHit.getHealth() - tempBullet.getDamage());
						tempBullet.setCanDamage(false);
					}
				}
			}

			//if bullet hits zombie, 
			
			
		}
		
		Iterator<IZombie> zombieIter = zombieList.iterator();
		while (zombieIter.hasNext()){
			tempZombie = zombieIter.next();
			if(tempZombie.getHealth() <= 0){
				tempZombie.dispose();
				zombieIter.remove();
			}
		}
		
		
		
		//ZOMBIE MOVEMENT
		for (IZombie zombie : zombieList){
			zombie.moveTowards(player.getPosition(), delta, zombieList);
		}

		if (Gdx.input.isKeyJustPressed(Keys.X)){
			zombieList.add(new BaseZombieEntity(IOUtil.getMouseX(inGameCam), IOUtil.getMouseY(inGameCam), 0f));
		}
		
		//BULLET MOVEMENT
		for(BasicBullet bullet : bulletList){
			bullet.move(delta);
		}
		

	}
	
	public void setInGameCamera(OrthographicCamera cam){
		inGameCam = cam;
	}
	
	

}
