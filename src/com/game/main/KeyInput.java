package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	private Player player;
	
			
	public KeyInput(Handler handler){
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++){
			GameObject movePlayer = handler.object.get(i);
			
			if (movePlayer.getId() == ID.Player){
				//Key Events for player 1
				
					if (key == KeyEvent.VK_UP){
						movePlayer.setVelY(-5);
				}	else if (key == KeyEvent.VK_DOWN){
						movePlayer.setVelY(5);
			
				}	else if (key == KeyEvent.VK_LEFT){
						movePlayer.setVelX(-5);
				}	else if (key == KeyEvent.VK_RIGHT){
						movePlayer.setVelX(5);
				}
			}
		}
		
		
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++){
			GameObject movePlayer = handler.object.get(i);
			GameObject bullet = handler.object.get(i);
			
			if (movePlayer.getId() == ID.Player){
				//Key Events for player 1
				
					if (key == KeyEvent.VK_UP){
						movePlayer.setVelY(0);
				}	else if (key == KeyEvent.VK_DOWN){
						movePlayer.setVelY(0);
			
				}	else if (key == KeyEvent.VK_LEFT){
						movePlayer.setVelX(0);
				}	else if (key == KeyEvent.VK_RIGHT){
						movePlayer.setVelX(0);
				}
		

			}

			}
	}
	
	/*public void mousePressed(MouseEvent e){
		int click = e.getButton();
		// TODO: Get Mouse event working for bullets
		
		for (int i = 0; i < handler.object.size(); i++){
			GameObject fireProjectile = handler.object.get(i);
			
			if (fireProjectile.getId() == ID.Bullet){
				
				if (click == MouseEvent.MOUSE_PRESSED){
					fireProjectile.setVelX(8);
					fireProjectile.setVelY(8);
					
					
				}
			}
			
		}
	}*/
	}		


