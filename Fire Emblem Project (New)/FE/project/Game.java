package FE.project;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import FE.project.display.Display;
import FE.project.gfx.*;
import FE.project.state.*;
import FE.project.tiles.*;
import FE.project.input.KeyManager;


public class Game implements Runnable {
	
	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	// States
	private State gameState;
	private State battleState;
	private State menuState;
	
	// Input
	private KeyManager keyManager;
	
	// Camera
//	private GameCamera gameCamera;
	

	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
//		gameCamera = new GameCamera(this,0,0);
		
		gameState = new GameState(this);
		battleState = new BattleState(this);
		menuState = new MenuState(this);
		
		State.setState(menuState);
	}
	
	private void tick(){
		keyManager.tick();
		
		if (State.getState() != null)
			State.getState().tick();
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0,0,width,height);
		// Draw Map
		
		//Draw Cursor
		
		if (State.getState() != null)
			State.getState().render(g);
		
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if (timer >= 1000000000){
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
//	public GameCamera getGameCamera(){
//		return gameCamera;
//	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public synchronized void start(){
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void setState(State state){
		State.setState(state);
	}
	
	public State getGameState() {
		return gameState;
	}
	
	public State getMenuState(){
		return menuState;
	}
	
	public State getBattleState(){
		return battleState;
	}
}
