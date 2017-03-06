package com.knightasterial.geniusproject.common.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.knightasterial.geniusproject.common.util.GameConstants;

public class PlayerEntity implements IEntity, Disposable{

	Texture image;
	float rotation;

	double health;
	int radius = 16;
	Vector2 position;
	
	

	public PlayerEntity(){
		position = new Vector2(GameConstants.WINDOW_WIDTH/2, GameConstants.WINDOW_HEIGHT/2);
		rotation = 0;

		image = new Texture(Gdx.files.internal("entities/tempPlayer.png"));

		health = GameConstants.BASE_PLAYER_HEALTH;
	}
	
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
