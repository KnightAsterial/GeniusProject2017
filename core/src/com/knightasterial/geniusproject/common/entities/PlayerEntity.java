package com.knightasterial.geniusproject.common.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.knightasterial.geniusproject.common.util.GameConstants;

public class PlayerEntity implements IEntity{

	float xCoord;
	float yCoord;
	Texture image;
	float rotation;
	Circle hitbox;
	double health;
	
	public PlayerEntity(){
		xCoord = GameConstants.WINDOW_WIDTH/2;
		yCoord = GameConstants.WINDOW_HEIGHT/2;
		rotation = 0;
		image = new Texture(Gdx.files.internal("entities/tempPlayer.png"));
		hitbox = new Circle(xCoord, yCoord, 16);
		health = GameConstants.BASE_PLAYER_HEALTH;
	}
	
	@Override
	public float getX() {
		return xCoord;
	}

	@Override
	public void setX(float xCoord) {
		this.xCoord = xCoord;
	}

	@Override
	public float getY() {
		return yCoord;
	}

	@Override
	public void setY(float yCoord) {
		this.yCoord = yCoord;
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

}
