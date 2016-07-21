package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject {
	
	Handler handler;
	


	public FastEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velY = 2;
		velX = 15;
		
	}
	
	
	
	public void tick(){
		x += velX;
		y += velY;
		
		if (y <= 0 || y >= Game.HEIGHT - 32){
			velY *= -1;
		}
		
		if (x <= 0 || x >= Game.WIDTH - 32){
			velX *= -1;
		}
		
		handler.addObject(new Trails((int)x, (int)y, ID.Trail, Color.CYAN, 32, 32, 0.1f, handler));
		
		collision();
	}
	
	public void collision(){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject collider = handler.object.get(i);
			
			if (collider.getId() == ID.Player){
				if (getBounds().intersects(collider.getBounds())){
					//Collision code here
					velX *= -1;
					velY *= -1;
					HUD.HEALTH -= 2;
				}
			}
		}
					
	}

	public void render(Graphics mob) {
		
		if (id == ID.FastEnemy){
			
			mob.setColor(Color.CYAN);
			mob.fillRect((int)x, (int)y, 16, 16);
			
			
		}
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	

	

}
