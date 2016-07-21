package com.game.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Boss extends GameObject {
	
	Handler handler;
	
	Random r = new Random();
	
	private int timer = 80;
	private int timerTwo = 50;


	public Boss(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		velY = 2;
		velX = 0;
		
	}
	
	
	
	public void tick(){
		x += velX;
		y += velY;
		
		if (timer <= 0){
			velY = 0;
		}
		else {
			timer--;
		}
		
		if (timer <= 0){
			timerTwo--;
		}
		if (timerTwo <= 0){
			if (velX == 0){
				velX = 2;
				}
			
			if (velX > 0){
				velX += .01f;
			}
			else if (velX < 0){
				velX -= .01f;
			}
			int spawn = r.nextInt(4);
			
			if (spawn == 0){
				handler.addObject(new Projectile((int)x+40, (int)y+40, ID.Bullet, handler));
			}
		}
		/*
		if (y <= 0 || y >= Game.HEIGHT - 32){
			velY *= -1;
		}
		*/
		if (x <= 0 || x >= Game.WIDTH - 32){
			velX *= -1;
		}
		

		

		
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
		
		if (id == ID.Boss){
			
			mob.setColor(Color.YELLOW);
			mob.fillRect((int)x, (int)y, 70, 70);
			
			
		}
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 70, 70);
	}
	

	

}
