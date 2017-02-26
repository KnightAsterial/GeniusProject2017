package com.knightasterial.geniusproject.common.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.utils.Disposable;
import com.knightasterial.geniusproject.common.util.GameConstants;

public class PlayerEntity implements IEntity, Disposable{

	float xCoord;
	float yCoord;
	float lowerLeftX;
	float lowerLeftY;
	Texture image;
	float rotation;
	Circle hitbox;
	double health;
	int radius = 16;
	
	public PlayerEntity(){
		xCoord = GameConstants.WINDOW_WIDTH/2;
		yCoord = GameConstants.WINDOW_HEIGHT/2;
		rotation = 0;
		lowerLeftX = xCoord-radius;
		lowerLeftY = yCoord-radius;
		image = new Texture(Gdx.files.internal("entities/tempPlayer.png"));
		hitbox = new Circle(lowerLeftX, lowerLeftY, radius);
		health = GameConstants.BASE_PLAYER_HEALTH;
	}
	
	@Override
	public float getX() {
		return xCoord;
	}

	@Override
	public void setX(float xCoord) {
		this.xCoord = xCoord;
		lowerLeftX = xCoord-radius;
	}

	@Override
	public float getY() {
		return yCoord;
	}

	@Override
	public void setY(float yCoord) {
		this.yCoord = yCoord;
		lowerLeftY = yCoord-radius;
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
		return hitbox;
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
	}

	@Override
	public float getLowerLeftX() {
		return lowerLeftX;
	}

	@Override
	public void setLowerLeftX(float lowerLeftX) {
		this.lowerLeftX = lowerLeftX;
		xCoord = lowerLeftX+radius;
	}

	@Override
	public float getLowerLeftY() {
		return lowerLeftY;
	}

	@Override
	public void setLowerLeftY(float lowerLeftY) {
		this.lowerLeftY = lowerLeftY;
		xCoord = lowerLeftY+radius;
	}

}
