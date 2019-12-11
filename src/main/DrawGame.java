package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import control.MouseManager;
import game.Game;
//import game.Game;
import game.Game2;
import game.GameLoader;
//import game.GameSelect;
//import game.SpaceShip;
import gfx.Asset;
import gfx.Display;
//import input.KeyManager;
//
import gfx.Resize;

public class DrawGame implements Runnable {

	
	private String Title;
	private int width, height;
	private static Display display;
	public static Thread thread;
	private BufferStrategy bs;
	private Graphics g;
	
	public static MouseManager mousemanager;
	private static GameLoader gameloader;
	private boolean running=false;
	
	private Game2 cc;
	private Game g1;
	private static int tick=0;
	
	public DrawGame(String Title, int width, int height) {
		this.Title = Title;
		this.height = height;
		this.width = width;
	}

	public void init() {
		Asset.init();
		display = new Display(Title, width, height);
		JFrame frame = display.getFrame();
		mousemanager = new MouseManager();
		frame.addMouseListener(mousemanager);
		display.getCanvas().addMouseListener(mousemanager);
		frame.addMouseMotionListener(mousemanager);
		display.getCanvas().addMouseMotionListener(mousemanager);
		gameloader = new GameLoader();
//		gameloader.setGame(new Game(GameLoader.getN()));
		
		cc=new Game2();
		g1 = new Game(100);
		gameloader.setGame(g1);
	}

	public void update() {
		gameloader.update();
//		System.out.println(mousemanager.getX()+ " " + mousemanager.getY());
	}

	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		g.drawImage(Asset.bg,0,0,null);
		gameloader.render(g);
		g.setColor(new Color(0,255,0));
		g.fillRect(mousemanager.getX(), mousemanager.getY(),
				(int) (Asset.test.getWidth()*Resize.x), (int) (Asset.test.getHeight()*Resize.y));
		
		
//		
		
		bs.show();
		g.dispose();
	}

	@Override
	public void run() {
		running = true;
		init();
		int fps = 60;
		double time_per_tick = 1000000000/fps;
		double delta = 0;
		long now;
		long last_time = System.nanoTime();
		int timer=0;

		
		while(running)
		{
			now = System.nanoTime();
			delta+=(now-last_time)/time_per_tick;
			timer+=(now-last_time);
			last_time=now;
			
			if(delta>=1) {
				update();
				render();
				tick++;
				delta--;
			}
			
			if(timer>=1000000000)
			{
				tick=0;
				timer=0;
			}
		}
		stop();
		
	}

	public synchronized void start() {
		if(!running) running = true;
		else return;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if(running) running =false;
		else return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static GameLoader getgameloader() {
		return gameloader;
	}
	
	public static int getTick() {
		return tick;
	}
}
