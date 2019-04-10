package de.rggd.rgg.screen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import de.rggd.rgg.RichtigGeilesGame;
import de.rggd.rgg.map.MapRenderer;

public class WorldScreen implements Screen{
	private RichtigGeilesGame game;
	private OrthographicCamera gamecam;
	private Viewport viewport;
	
	private TmxMapLoader maploader;
	private TiledMap map;
	private MapRenderer renderer;
	
	// box2d
	private World world;
	private Box2DDebugRenderer b2dr;
	
	
	public WorldScreen(RichtigGeilesGame game) {
		this.game = game;
		gamecam = new OrthographicCamera();
		viewport = new FitViewport(RichtigGeilesGame.V_WIDTH,RichtigGeilesGame.V_HEIGHT,gamecam);
		
		maploader = new TmxMapLoader();
		map = maploader.load("maps/tmx/map.tmx");
		renderer = new MapRenderer(map);
		gamecam.position.set(viewport.getWorldWidth()/2,viewport.getWorldHeight()/2,0);
		
		world = new World(new Vector2(0,0),true);
		b2dr = new Box2DDebugRenderer();
		
		BodyDef bdef = new BodyDef();
		PolygonShape shape = new PolygonShape();
		FixtureDef fdef = new FixtureDef();
		Body body;
		
		for(MapObject object : map.getLayers().get("Collision").getObjects().getByType(RectangleMapObject.class)) {
			Rectangle rect = ((RectangleMapObject) object).getRectangle();
			bdef.type = BodyDef.BodyType.StaticBody;
			bdef.position.set(rect.getX()+rect.getWidth()/2,rect.getY()+rect.getHeight()/2);
			
			body = world.createBody(bdef);
			
			shape.setAsBox(rect.getWidth()/2, rect.getHeight()/2);
			fdef.shape = shape;
			body.createFixture(fdef);
		}
	}
	
	public void update(float delta) {
		gamecam.update();
		renderer.setView(gamecam);
		
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		update(delta);
		renderer.render();
		game.batch.setProjectionMatrix(gamecam.combined);
		
		//b2d 
		b2dr.render(world, gamecam.combined);
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		viewport.update(width,height);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
