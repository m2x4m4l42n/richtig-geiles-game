package de.rggd.rgg.map;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import de.rggd.rgg.character.CharacterRenderer;

public class MapRenderer extends OrthogonalTiledMapRenderer{
	public MapRenderer(TiledMap map) {
		super(map);
	}
	public void addCharacter(CharacterRenderer character) {
		getMap().getLayers().get("Objects").getObjects().add(character.getTmo());
		
	}
	@Override
	public void renderObject(MapObject object) {
		if(object instanceof TextureMapObject) {
			TextureMapObject textureObj = (TextureMapObject) object;
			batch.draw(textureObj.getTextureRegion(), textureObj.getX(), textureObj.getY());
	
	    }
    }
}
