package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import game.GameLoader;
import gfx.Asset;
import gfx.Resize;
import main.DrawGame;

public class Enemy {

	private int x,y,dx,dy;
	private Rectangle bound;
	private int speed;
	private Random rnd;
	
	public Enemy(int x, int y, int dx, int dy,int speed) { //dx dy random -1 -> 1
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		bound = new Rectangle(x,y,Asset.meoteo.getWidth(),Asset.meoteo.getHeight());
		this.speed = speed;
		rnd = new Random();
	}
	
	public void update() {
//		if(DrawGame.getTick()/60 == -speed) {
		if ((dx<0 && speed>0) | (dx>0 && speed<0)) speed=-speed; x+=dx+speed;
		if ((dy<0 && speed>0) | (dy>0 && speed<0)) speed=-speed; y+=dy+speed;
		bound.setBounds(x,y,(int) (Asset.test.getWidth()*Resize.x),
				(int) (Asset.test.getHeight()*Resize.y));
		CheckCollide();
		
//		}
//		System.out.println("x = "+(1920*Resize.x)+"y = "+(1080*Resize.y));
	}
	
	public void render(Graphics g) {
		g.drawImage(Asset.meoteo, x+speed, y+speed, null);
		g.setColor(new Color(255,0,0));
		g.drawRect(x,y,(int) (Asset.test.getWidth()),
				(int) (Asset.test.getHeight()));
	}
	
	public void CheckCollide() {
		if(x<=0 | (x+Asset.meoteo.getWidth())>=1920*Resize.x) dx *=-1;
		if(y<=0 | (y+Asset.meoteo.getHeight())>=1080*Resize.y) dy *= -1;
		if(bound.contains(DrawGame.mousemanager.getX(),
				DrawGame.mousemanager.getY())) {
//			DrawGame.getgameloader().setGame(new Gameover());
		}
	}
	
	public void rePlace() {
		x = rnd.nextInt((int)(1920*Resize.x));
		y = rnd.nextInt((int)(1080*Resize.y));
		speed++;
	}
	
	public int getSpeed() {
		return speed;
	}
}
