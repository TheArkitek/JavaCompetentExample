package com.game.main;

import java.awt.Graphics;
import java.util.ArrayList;

public class Handler {
	// This will update and render ALL game objects in the world
	
	ArrayList<GameObject> object = new ArrayList<GameObject>();
	
	public void tick(){
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			tempObject.tick();
			
		}
		
	}
	
	public void render(Graphics g){
		for(int i = 0; i < object.size(); i++){
			GameObject drawObject = object.get(i);
			drawObject.render(g);
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
	public void clearEnemies(){
		for (int i = 0; i < object.size(); i++){
			GameObject remove = object.get(i);
			
			if (remove.getId() == ID.Player){
				object.clear();
				addObject(new Player((int)remove.getX(), (int)remove.getY(), ID.Player, this));
			}
		}
	}

}
