package com.knightasterial.geniusproject.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.knightasterial.geniusproject.GeniusProject;
import com.knightasterial.geniusproject.common.util.GameConstants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.width = GameConstants.WINDOW_WIDTH;
		config.height = GameConstants.WINDOW_HEIGHT;
		
		new LwjglApplication(new GeniusProject(), config);
	}
}
