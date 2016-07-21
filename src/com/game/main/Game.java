package com.game.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1550691097823471818L;
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	
	private Thread thread;
	private boolean running = false;
	private Spawner spawner;
	private Handler handler;
	private Random r;
	private HUD hud;
	private Menu menu;
	
	public enum STATE{
		Menu,
		Game,
		End,
	};
	
	public STATE gameState = STATE.Menu;
	
	public Game(){
		handler = new Handler();
		hud = new HUD();
		menu = new Menu(this, handler, hud);
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		
		new Window(WIDTH, HEIGHT, "Blocks!", this);

		spawner = new Spawner(handler, hud);
		r = new Random();

		if (gameState == STATE.Game){
			handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));	
		}
		
		handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
		handler.addObject(new Enemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.Enemy, handler));
		
		
			
	}

		
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
		running = true;
		
	}
	
	public synchronized void stop(){
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		// The game loop
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running){
			long now= System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
				
			}
			
			if (running){
				render();
			}
			frames++;
		}
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		stop();
	}
	
	private void tick(){
		handler.tick();
		
		
		if (gameState == STATE.Game){
			hud.tick();
			spawner.tick();
			
			if (HUD.HEALTH <= 0){
				HUD.HEALTH = 100;
				gameState = STATE.End;
				handler.clearEnemies();

			}
		}
		else if (gameState == STATE.Menu || gameState == STATE.End){
			menu.tick();
		}
		
	}
	
	private void render(){
		// Rendering the screen
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics gameBox = bs.getDrawGraphics();
		
		gameBox.setColor(Color.black);
		gameBox.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(gameBox);
		
		if (gameState == STATE.Game){
			hud.render(gameBox);
			
		}
		else if (gameState == STATE.Menu || gameState == STATE.End){
			menu.render(gameBox);
		}
		
		gameBox.dispose();
		bs.show();

		
	}
	
	public static float clamp(int var, int min, int max){
		if (var >= max){
			return var = max;
		}else if (var <= min){
			return var = min;
		}else{
			return var;
		}
	}
	
	public static void main(String[] args){
		new Game();
		
	}

}
