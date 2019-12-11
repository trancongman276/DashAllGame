package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gfx.Asset;
import gfx.Resize;
import main.DrawGame;
import objects.Exit;
import objects.Enemy;

public class Game extends State{
	
	private List<Enemy> enemies;
	private Random rnd;
	private int x,y,s=1,n;
	private Exit exit;
	
	public Game(int n)
	{
		this.n=n;
		exit = new Exit();
		enemies = new ArrayList<>();
		rnd = new Random();
		for(int i=0;i<n;i++) {
			x=0;
			y=0;
			while(x==0) x = rnd.nextInt(3)-1;
			while(y==0) y = rnd.nextInt(3)-1;
			
			enemies.add(new Enemy(rnd.nextInt((int)(1920*Resize.x)),
					rnd.nextInt((int)(1080*Resize.y)),
					x,y,s));
		}
		GameLoader.setN(n);
	}
	
	public void update() {
		enemies.forEach(a -> {
			a.update();
			});
		exit.update();
	}
	
	public void render(Graphics g) {
		enemies.forEach(a -> {
			a.render(g);
			});
		exit.render(g);
	}
	
	public void replace() {
		s++;
		enemies.forEach(a -> a.rePlace());
		for(int i=0;i<10;i++) {
			x=0;
			y=0;
			while(x==0) x = rnd.nextInt(3)-1;
			while(y==0) y = rnd.nextInt(3)-1;
			
			enemies.add(new Enemy(rnd.nextInt((int)(1920*Resize.x)),
					rnd.nextInt((int)(1080*Resize.y)),
					x,y,s));
		}
		System.out.println("game "+s);
		System.out.println("ene "+enemies.get(1).getSpeed());
		n+=10;
		GameLoader.setN(n);
	}

}
