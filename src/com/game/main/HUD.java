package com.game.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static double HEALTH = 100;
	private double greenValue = 255;
	
	private int score = 0;
	private int level = 1;
	
	public void tick(){
		//HEALTH--;
		
		HEALTH = Game.clamp((int) HEALTH, 0, 100);
		greenValue = Game.clamp((int) greenValue, 0, 255);
		
		greenValue = HEALTH * 2;
		
		score++;
	}
	
	public void render(Graphics HUD){
		HUD.setColor(Color.GRAY);
		HUD.fillRect(15, 15, 200, 32);
		
		HUD.setColor(new Color(75, (int) greenValue, 0));
		HUD.fillRect(15, 15, (int) (HEALTH * 2), 32);
		
		HUD.setColor(Color.WHITE);
		HUD.drawRect(15, 15, (int) (HEALTH * 2), 32);
		
		HUD.drawString("Score: " + score, 15, 64);
		HUD.drawString("Level: " + level, 15, 80);
	}
	
	public void setScore(int score){
		this.score = score;
	}
	
	public int getScore(){
		return score;
	}
	
	public void setLevel(int level){
		this.level = level;
	}
	
	public int getLevel(){
		return level;
	}


}
