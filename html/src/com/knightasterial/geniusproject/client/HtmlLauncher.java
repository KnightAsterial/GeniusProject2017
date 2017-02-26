package com.knightasterial.geniusproject.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.knightasterial.geniusproject.GeniusProject;
import com.knightasterial.geniusproject.common.util.GameConstants;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
        }

        @Override
        public ApplicationListener createApplicationListener () {
                return new GeniusProject();
        }
}