package com.knightasterial.geniusproject.common.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public interface IEntity {
	
	
	public float getX();
	
	public void setX(float xCoord);
	
	
	public float getY();
	
	public void setY(float yCoord);
	
	public Vector2 getPosition();
	public void setPosition(Vector2 position);
	public void setPosition(float x, float y);
	
	
	public void setImage(Texture image);
	
	public Texture getImage();
	
	
	/**
	 * sets rotation
	 * @param rotation in radians (on unit circle)
	 */
	public void setRotation(float rotation);
	
	/**
	 * 
	 * @return rotation on unit circle, radians
	 */
	public float getRotation();
	
	
	public Circle getHitbox();
	
	
	public double getHealth();
	
	public void setHealth(double health);
	
	public void setLowerLeftX(float lowerLeftX);
	
	public float getLowerLeftX();
	
	public void setLowerLeftY(float lowerLeftY);
	
	public float getLowerLeftY();
	
}
