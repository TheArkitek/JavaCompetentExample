package com.game.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.game.main.Game.STATE;

public class Menu extends MouseAdapter {
	
	private Handler handler;
	private Game game;

	private Random r = new Random();
	private HUD hud;
	
	public Menu(Game game, Handler handler, HUD hud){
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}
	
	public void mousePressed(MouseEvent e){
		
		int mx = e.getX();
		int my = e.getY();
		
		if (mouseOver(mx, my, 210, 150, 200, 64)){
			game.gameState = STATE.Game;
			
		}
		
	}
	
	public void mouseReleased(MouseEvent e){
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if (mx > x && mx < x + width){
			if (my > y && my < y + height){
				return true;
			}
			else{
				return false;
			}
			
		}
		else{
			return false;
		}
	}
	
	
	public void render(Graphics menu){
		if (game.gameState == STATE.Menu){
			Font titleFnt = new Font("arial", 1, 50);
			Font fnt = new Font("arial", 1, 25);
			
			menu.setFont(titleFnt);
			menu.setColor(Color.WHITE);
			menu.drawString("BLOCKS!", 200, 75);
			
			menu.setFont(fnt);
			menu.setColor(Color.WHITE);
			menu.drawString("Play BLOCKS!", 225, 190);
			
			menu.setFont(fnt);
			menu.setColor(Color.WHITE);
			menu.drawString("Help", 150, 290);
			
			menu.setFont(fnt);
			menu.setColor(Color.WHITE);
			menu.drawString("Quit", 425, 290);
			
			
			
			
			

			menu.setColor(Color.WHITE);
			menu.drawRect(210, 150, 200, 64);
			
			menu.setColor(Color.WHITE);
			menu.drawRect(100, 250, 150, 64);
			
			menu.setColor(Color.WHITE);
			menu.drawRect(375, 250, 150, 64);
		}
		
		else if (game.gameState == STATE.End){
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);
			
			menu.setFont(fnt);
			menu.setColor(Color.WHITE);
			menu.drawString("Game Over", 190, 75);
			
			menu.setFont(fnt2);
			menu.setColor(Color.WHITE);
			menu.drawString("Your score was: " + hud.getScore(), 175, 350);
		}
		
	}
		
	public void GameOver(Graphics end){
		 
		
		
	}
	
	public void tick(){
		
	}

}
