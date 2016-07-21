package com.game.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	
	// This is the master class for ALL game objects (Players, coins, monsters, items etc)
	
	protected float x;
	protected float y;
	protected ID id;
	protected float velX, velY;
	
	public float getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public void tick(){
		
	}
	
	public GameObject(int x, int y, ID id){
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract Rectangle getBounds();
	public abstract void render(Graphics g);
}
