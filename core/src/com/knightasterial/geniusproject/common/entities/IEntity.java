package com.knightasterial.geniusproject.common.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;

public interface IEntity {
	
	
	public float getX();
	
	public void setX(float xCoord);
	
	
	public float getY();
	
	public void setY(float yCoord);
	
	
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
}
