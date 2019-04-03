package de.rggd.rgg;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import de.rggd.rgg.character.CharacterRenderer;
import de.rggd.rgg.map.MapRenderer;
/*
 * Main Game Class  
 */
public class RichtigGeilesGame extends ApplicationAdapter {

	MapRenderer renderer;
	OrthographicCamera camera;
	CharacterRenderer character;
	
	@Override
	
	public void create () {
		renderer = new MapRenderer( new TmxMapLoader().load("maps/tmx/map.tmx"));
		camera = new OrthographicCamera(Gdx.graphics.getHeight(),Gdx.graphics.getWidth());
		camera.setToOrtho(false,Gdx.graphics.getWidth()/1.0f, Gdx.graphics.getHeight()/1.0f);
		character = new CharacterRenderer("character/character.png");
		character.create();
		renderer.addCharacter(character);
		
		
	}
	/*
	 * Updates gamestate before each render
	 */
	public void update() {
		camera.update();
		character.update();
		renderer.setView(camera);
	}
	
	@Override
	public void render () {
		// Run update method before rendering
		update();
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.render();
	}
	
	@Override
	public void dispose () {
		character.dispose();
		renderer.dispose();
	}
}
