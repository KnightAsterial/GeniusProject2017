package com.knightasterial.geniusproject.common.bullets;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

public class BasicBullet implements Disposable{
	Vector2 position;
	float speed;
	/**
	 * rotation of bullet in degrees
	 */
	float rotation;
	Texture image;
	Vector2 flightPath;
	Random rand;
	Polygon hitbox;
	float damage;
	boolean canDamage;
	
	/**
	 * Class holding a bullet 
	 * @param startPosition where the bullet originates
	 * @param clickLocation where the bullet should travel towards
	 * @param speed speed of bullet movement
	 * @param inaccuracy inaccuracy/spread of the bullet in degrees
	 * @param damage the amount of damage the bullet does
	 */
	public BasicBullet(Vector2 startPosition, Vector2 clickLocation, float speed, float inaccuracy, float damage){

		this.damage = damage;
		
		position = new Vector2().set(startPosition);
		this.speed = speed;
		
		flightPath = new Vector2().set(clickLocation).sub(startPosition).nor();
		
		Random rand = new Random();
		if (rand.nextInt() % 2 == 0){
			flightPath.rotate(rand.nextInt( (int)(inaccuracy/2+1) ));
		}
		else{
			flightPath.rotate(0-rand.nextInt( (int)(inaccuracy/2+1) ));
		}
		
		rotation = flightPath.angle();
		
		image = new Texture(Gdx.files.internal("bullets/tempBullet.png"));
		
		hitbox = createHitbox(position);
		
		canDamage = true;
	}
	
	public void move(float delta){
		Vector2 temp = new Vector2().set(flightPath);
		position.add(temp.scl(speed*delta));
		
		//updates hitbox
		hitbox = createHitbox(position);
	}
	
	public Polygon createHitbox(Vector2 position){
		Polygon tempPolygon;
		float[] hitboxVertices = {position.x, position.y, position.x+40, position.y, position.x+40, position.y+2, position.x, position.y+2};
		tempPolygon = new Polygon(hitboxVertices);
		tempPolygon.setOrigin(position.x, position.y);
		tempPolygon.rotate(rotation);
		
		return tempPolygon;
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	public float getX() {
		return position.x;
	}
	public void setX(float xCoord) {
		position.set(xCoord, position.y);
	}
	public float getY() {
		return position.y;
	}
	public void setY(float yCoord) {
		position.set(position.x, yCoord);
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public float getRotation() {
		return rotation;
	}
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
	public Texture getImage() {
		return image;
	}
	public void setImage(Texture image) {
		this.image = image;
	}
	public Vector2 getFlightPath() {
		return flightPath;
	}
	public void setFlightPath(Vector2 flightPath) {
		this.flightPath = flightPath;
	}

	public Polygon getHitbox() {
		return hitbox;
	}

	public void setHitbox(Polygon hitbox) {
		this.hitbox = hitbox;
	}
	public float[] getHitboxVertices(){
		return hitbox.getTransformedVertices();
	}

	public float getDamage() {
		return damage;
	}

	public void setDamage(float damage) {
		this.damage = damage;
	}

	public boolean canDamage() {
		return canDamage;
	}

	public void setCanDamage(boolean canDamage) {
		this.canDamage = canDamage;
	}

	@Override
	public void dispose() {
		image.dispose();
		//System.out.println("Bullet disposed of");
	}
}
