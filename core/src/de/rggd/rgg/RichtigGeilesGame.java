package de.rggd.rgg;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.rggd.rgg.screen.WorldScreen;

/*
 * Main Game Class  
 */
public class RichtigGeilesGame extends Game {
	public static final int V_WIDTH = 600;
	public static final int V_HEIGHT = 480;
	public SpriteBatch batch;

	
	@Override
	
	public void create () {
		batch = new SpriteBatch();
		setScreen(new WorldScreen(this));
		
		
		
	}
	/*
	 * Updates gamestate before each render
	 */
	public void update() {
		
	}
	
	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {

	}
}
