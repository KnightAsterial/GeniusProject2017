package com.knightasterial.geniusproject.common.entities;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.knightasterial.geniusproject.common.util.GameConstants;
import com.knightasterial.geniusproject.common.util.GameUtil;

public class BaseZombieEntity implements IEntity, Disposable, IZombie{


	Texture image;
	float rotation;

	double health;
	
	
	int radius = 16;
	
	Vector2 position;
	
	float speed;
	
	int checksPerSide = 3;
	/**
	 * Angle to check on each side, in degrees
	 */
	int checkAngle = 30;	
	
	/**
	 * health =
	 * @param x initial X-coordinate
	 * @param y initial Y-coordinate
	 * @param rotation radians to face (on unit circle)
	 */
	public BaseZombieEntity(float x, float y, float rotation){
		position = new Vector2(x, y);

		this.rotation = rotation;
		image = new Texture(Gdx.files.internal("entities/tempBasicZombie.png"));
		
		health = GameConstants.BASE_BASIC_ZOMBIE_HEALTH;
		
		speed = GameConstants.BASE_BASIC_ZOMBIE_SPEED;
	}	
	
	public void moveTowards(Vector2 destination, float delta, List<IZombie> thingsToCollideWith){

		
		Vector2 temp = new Vector2();
		temp.set(destination);
		
		if (GameUtil.canMove(this, position, temp, speed, delta, thingsToCollideWith)) {
			position.add( temp.sub(position).nor().scl(speed*delta) );
        }
		else{
	        // Now try a bunch of similar angles
	        int currentCheck = 1;
	
	        while(currentCheck<=checksPerSide) {
	        	
	            // Try the offset of the left side
	        	temp.set(destination);
	        	temp.rotate(0-checkAngle*currentCheck);
	            if( GameUtil.canMove(this, position, temp, speed, delta, thingsToCollideWith) ) {
	            	position.add( temp.sub(position).nor().scl(speed*delta) );
	                break;
	            }
	            // Try the offset on the right side
	            temp.set(destination);
	            temp.rotate(checkAngle*currentCheck);
	            if( GameUtil.canMove(this, position, temp, speed, delta, thingsToCollideWith) ) {
	            	position.add( temp.sub(position).nor().scl(speed*delta) );
	                break;
	            }
	            // No move performed, try slightly further
	            currentCheck++;
	        }
		}
		
		//turns destination into a vector from position --> destination, then sets its length to the correct move amount for delta
		//position.add( temp.sub(position).nor().scl(speed*delta) );
		
	}

	//getters and setters... erggggggggggggg so long to write (but useful, sadly)
	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}
	
	public void setPosition(float x, float y){
		position = new Vector2(x, y);

	}
	
	@Override
	public float getX() {
		return position.x;
	}

	@Override
	public void setX(float xCoord) {
		position.set(xCoord, position.y);


	}

	@Override
	public float getY() {
		return position.y;
	}

	@Override
	public void setY(float yCoord) {
		position.set(position.x, yCoord);

	}

	@Override
	public void setImage(Texture image) {
		this.image = image;
	}

	@Override
	public Texture getImage() {
		return image;
	}

	@Override
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	@Override
	public float getRotation() {
		return rotation;
	}

	@Override
	public Circle getHitbox() {
		return new Circle(position.x, position.y, radius);
	}

	@Override
	public double getHealth() {
		return health;
	}

	@Override
	public void setHealth(double health) {
		this.health = health;
	}

	@Override
	public void dispose() {
		image.dispose();
		//System.out.println("Zombie disposed of");
	}

	@Override
	public float getLowerLeftX() {
		return position.x-radius;
		
	}

	@Override
	public void setLowerLeftX(float lowerLeftX) {

		position.set(lowerLeftX+radius, position.y);

	}

	@Override
	public float getLowerLeftY() {
		return position.y-radius;
	}

	@Override
	public void setLowerLeftY(float lowerLeftY) {
		position.set(position.x, lowerLeftY+radius);

	}

}
