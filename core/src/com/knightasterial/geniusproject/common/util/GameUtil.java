package com.knightasterial.geniusproject.common.util;

import java.util.List;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.knightasterial.geniusproject.common.entities.IEntity;
import com.knightasterial.geniusproject.common.entities.IZombie;
import com.knightasterial.geniusproject.common.weapons.AbstractGun;

public class GameUtil {
	
	/**
	 * Can object move without colliding into another object
	 * @param self instance of the IEntity moving
	 * @param position position of moving object
	 * @param direction destination to move in
	 * @param speed amount moved per second
	 * @param delta time since last move (in seconds)
	 * @param thingsToCollideWith list of things it shouldn't collide with
	 * @return if it can move without colliding
	 */
	public static boolean canMove(IEntity self, Vector2 position, Vector2 direction, float speed, float delta, List<IZombie> thingsToCollideWith){
		
		boolean result = true;
		Circle tempHitbox = new Circle();
		
		Vector2 tempDirection = new Vector2();
		tempDirection.set(direction);
		
		Vector2 newPosition = new Vector2();
		newPosition.set(position);
		
		newPosition.add( tempDirection.sub(position).nor().scl(speed*delta) );
		
		tempHitbox.set(newPosition, self.getHitbox().radius);
		
		for(IEntity entity : thingsToCollideWith){
			if (self.getX() != entity.getX() && self.getY() != entity.getY()){														//makes sure it doesn't test against itself
				if (tempHitbox.overlaps(entity.getHitbox())){
					result = false;
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * returns gun based on keypress, doesn't change the current gun if the desired gun is a NullWeapon (hasn't been set)
	 * @param currentGun variable holding user's current gun
	 * @param gunList list of available guns
	 * @param keyPressed the number of the key that was pressed(Keys.0 = 10) (NOT INDEX) 
	 * @return gun to switch to
	 */
	public static AbstractGun switchGun(AbstractGun currentGun, AbstractGun[] gunList, int keyPressed){
		if (keyPressed < 1){
			//does nothing
			return currentGun;
		}
		if (gunList[keyPressed-1].getName() != GameConstants.NULL_WEAPON_ID){
			//returns the gun to switch to
			return gunList[keyPressed-1];
		}
		else{
			//does nothing
			return currentGun;
		}
	}
	
}
