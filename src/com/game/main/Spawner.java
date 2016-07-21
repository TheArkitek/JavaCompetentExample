package com.game.main;

import java.util.Random;

import com.game.main.Game.STATE;

public class Spawner {
	
	private Game game;
	private Handler handler;
	private HUD hud;
	private int scoreKeep = 0;
	private Random r = new Random();
	
	public Spawner(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
		this.game = game;
	}
	
	public void tick(){
		scoreKeep++;

		
		if (scoreKeep >= 200){
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			
			if (hud.getLevel() == 2){
			handler.addObject(new Enemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.Enemy, handler));
			}
			if (hud.getLevel() == 3){
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
			}
			if (hud.getLevel() == 4){
				handler.addObject(new Enemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.Enemy, handler));
			}
			if (hud.getLevel() == 5){
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
			}
			if (hud.getLevel() == 6){
				handler.addObject(new Enemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.Enemy, handler));
			}
			else if (hud.getLevel() == 7){
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.FastEnemy, handler));
			}
			else if (hud.getLevel() == 10){
				handler.clearEnemies();
				handler.addObject(new Boss((Game.WIDTH/2)-48, -96, ID.Boss, handler));
			}

			
		}
			
		
	}

}
