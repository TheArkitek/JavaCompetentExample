package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Projectile extends GameObject {
	
	Handler handler;
	
	Random r = new Random();
	


	public Projectile(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velY = 7;
		velX = (r.nextInt((5 - -5) + -5));
		
	}
	
	
	
	public void tick(){
		x += velX;
		y += velY;
		
		/*
		if (y <= 0 || y >= Game.HEIGHT - 32){
			velY *= -1;
		}
		
		if (x <= 0 || x >= Game.WIDTH - 32){
			velX *= -1;
		}
		*/
		
		if (y >= Game.HEIGHT){
			handler.removeObject(this);
		}
		handler.addObject(new Trails((int)x, (int)y, ID.Trail, Color.WHITE, 12, 12, 0.1f, handler));
		
		collision();
	}
	
	public void collision(){
		for(int i = 0; i < handler.object.size(); i++){
			GameObject collider = handler.object.get(i);
			
			if (collider.getId() == ID.Player){
				if (getBounds().intersects(collider.getBounds())){
					//Collision code here
					handler.removeObject(this);
					HUD.HEALTH -= 2;
				}
			}
		}
					
	}

	public void render(Graphics mob) {
		
		if (id == ID.Bullet){
			
			mob.setColor(Color.WHITE);
			mob.fillRect((int)x, (int)y, 12, 12);
			
			
		}
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 12, 12);
	}
	

	

}
