package com.knightasterial.geniusproject.common.entities;

import java.util.List;

import com.badlogic.gdx.math.Vector2;

public interface IZombie extends IEntity{
	public void moveTowards(Vector2 destination, float delta, List<IZombie> thingsToCollideWith);
}
