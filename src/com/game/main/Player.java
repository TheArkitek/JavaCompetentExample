package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	Handler handler;
	

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		
		//velX = 1;
	}

	public void tick() {
		
		// Movement and position
		
		x += velX;
		y += velY;
		
		x = Game.clamp((int)x,  0, Game.WIDTH - 37);
		y = Game.clamp((int)y,  0, Game.HEIGHT - 60);
		
		collision();
	}
	
	public void collision(){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject collider = handler.object.get(i);
			
			if (collider.getId() == ID.Enemy){
				if (getBounds().intersects(collider.getBounds())){
					//Collision code here
					
				}
			}
		}
		
			
	}

	public void render(Graphics player) {
		
		// The characteristics of the Player
		
		if (id == ID.Player ){
			player.setColor(Color.BLUE);
			player.fillRect((int)x, (int)y, 32, 32);
		}
		
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}

}
