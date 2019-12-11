package object;

import java.awt.Graphics;
import java.awt.Rectangle;

import algorithm.Main;
import game.MapReader;
import gfx.Resize;
import main.DrawGame;

public class Candy {
	public static final int sizex = (int) (100*Resize.x), sizey = (int) (100*Resize.y);
	private int x,y,type;
	private Rectangle bound;
	private boolean draw = false, onHolvering = false, once=true;
	
	public Candy(int _x, int _y, int _type) {
		x=_x;
		y=_y;
		type=_type;
		bound = new Rectangle(x,y,sizex,sizey);
	}
	
	public void move() {
		if(bound.contains(DrawGame.mousemanager.getX(),
				DrawGame.mousemanager.getY()) &&
				DrawGame.mousemanager.isIspressed() && once) {
//			System.out.println("x= "+x/sizex+"y= "+y/sizey);
			Main.chosing(x/sizex, y/sizey);
			draw = true;
			once = false;
			System.out.println("Candy:"+type+" AL:"+((Candy)MapReader.colls.get(x/sizex).get(y/sizey)).getType()
					+" Map:"+MapReader.map[x/sizex][y/sizey]);
		}
		if(!bound.contains(DrawGame.mousemanager.getX(),
				DrawGame.mousemanager.getY()) &&
				DrawGame.mousemanager.isIspressed() && !once) {
			once = true;
		}
		
		if(!bound.contains(DrawGame.mousemanager.getX(),
				DrawGame.mousemanager.getY()) && Main.moved && !DrawGame.mousemanager.isIspressed()) {
			draw =false;
			once = true;
		}
		
		if(bound.contains(DrawGame.mousemanager.getX(),
				DrawGame.mousemanager.getY()))
			onHolvering = true;
		else onHolvering = false;
	}
	
	public void update() {
		move();
		bound.setBounds(x,y,sizex,sizey);
	}
	
	public void render(Graphics g) {
		if(draw) {
			g.drawRect(x, y, sizex, sizex);
		}
		if(onHolvering)
			g.drawRect(x, y, sizex, sizey);
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getType() {
		return type;
	}
	
}
