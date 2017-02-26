package com.knightasterial.geniusproject.common.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class IOUtil {
	public static int getMouseX(){
		return Gdx.input.getX();
	}
	/**
	 * Function for when origin is in the bottom left corner
	 * @return mouse Y-coordinate
	 */
	public static int getMouseY(){
		return ( Gdx.graphics.getHeight() - Gdx.input.getY() );
	}
	
	public static Vector2 getMouseVector(){
		return new Vector2( Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY() );
	}
}
