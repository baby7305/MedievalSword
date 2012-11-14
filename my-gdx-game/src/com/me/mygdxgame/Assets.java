package com.me.mygdxgame;

import java.util.Hashtable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	/** Textures **/
	static TextureAtlas atlas;
	static protected Hashtable<String, TextureRegion> inverses;
	
	public static Texture aux = new Texture(Gdx.files.internal("fonts/font.png"));
	
	public Assets() {
		load();
	}
	
	public void load() {
		atlas = new TextureAtlas(Gdx.files.internal("images/pack"));
		inverses = new Hashtable<String, TextureRegion>();
	}
	
	public static TextureRegion getTexture(String name) {
		return atlas.findRegion(name);
	}
	
	public static TextureRegion getFlipTexture(String name) {
		if( inverses.get( name ) == null ) {
			TextureRegion aux = new TextureRegion( atlas.findRegion(name) );
			aux.flip(true, false);
			
			inverses.put( name, aux );
		}
		
		return inverses.get( name );
	}
	
	public static TextureRegion getFrame(String name, int frame) {
		return atlas.findRegion(name, frame);
	}
	
	public static TextureRegion getFlipFrame(String name, int frame) {
		if( inverses.get( name ) == null ) {
			TextureRegion aux = new TextureRegion( atlas.findRegion(name, frame) );
			aux.flip(true, false);
			
			inverses.put( name + "_" + frame, aux );
		}
		
		return inverses.get( name + "_" + frame );
	}
	
	public static TextureRegion getFlip() {
		TextureRegion aux = atlas.findRegion("unit1");
		aux.flip(true, false);
		
		return aux;
	}
}
