package de.rggd.rgg.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.objects.TextureMapObject;

public class CharacterRenderer {
	
	Texture texture;
	String url;
	TextureRegion sprite;

	
	//Texture Coordinates
	float u;
	float v;
	int aniInc = 0;
	
	//Position
	int x,y;
	
	//Speed
	int s = 1;
	
	TextureMapObject tmo;
	
	public CharacterRenderer(String url) {
		this.url = url;
	}
	// System Time for smooth animation
	private long last = System.currentTimeMillis();
	
	public TextureMapObject getTmo() {
		return tmo;
	}
	public void create() {
		texture = new Texture(url);
		u = 1/(texture.getWidth()/16f);
		v = 2/(texture.getHeight()/16f);
		sprite = new TextureRegion(texture, 0.0f,0.0f,u,v);
		x=y=5;
		tmo = new TextureMapObject(sprite);
		tmo.setX(x);
		tmo.setY(y);

	}
	/*
	* Update Sprite and Position if input key is pressed, 
	* animate every 100ms for smooth animation
	*/
	public void update() {
		if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
			y+=s;
			sprite.setRegion( 0.0f+aniInc*u,2*v,u+aniInc*u,3*v);;
			
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			y-=s;
			sprite.setRegion(0.0f+aniInc*u,0.0f,u+aniInc*u,v);
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			x-=s;
			sprite.setRegion(0.0f+aniInc*u,3*v,u+aniInc*u,4*v);
		}
		else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			x+=s;
			sprite.setRegion(0.0f+aniInc*u,v,u+aniInc*u,2*v);
			
		}if(System.currentTimeMillis()-last > 100) {
			aniInc = (aniInc+1)%4;
			last += 100;
		}
		tmo.setX(x);
		tmo.setY(y);
		tmo.setTextureRegion(sprite);
		
	}

	/*
	 * frees all resources is called in dispose method of Application
	 */
	public void dispose() {
		texture.dispose();
	}
		
}
