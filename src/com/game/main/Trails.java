package com.game.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trails extends GameObject{
	
	private float trail = 1;
	
	Handler handler;
	private Color color;
	private int width, height;
	private float life;
	
	// Life can be a value between 0.01 and .1

	public Trails(int x, int y, ID id, Color color, int width, int height, float life, Handler handler) {
		super(x, y, id);
		this.color = color;
		this.handler = handler;
		this.width = width;
		this.height = height;
		this.life = life;
	}


	
	public void tick(){
		if(trail > life){
			trail -= life - 0.0001f;
		}else {
			handler.removeObject(this);
		}
		
	}
	


	
	public void render(Graphics g) {
		Graphics2D trail2D = (Graphics2D) g;
		
		trail2D.setComposite(makeTransparent(trail));
		g.setColor(color);
		g.fillRect((int)x, (int)y, width, height);
		
		trail2D.setComposite(makeTransparent(1));
		
	}
	
	private AlphaComposite makeTransparent(float trail){
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, trail));
	}
	
	public Rectangle getBounds() {
		return null;
	}
	
	
	

}
