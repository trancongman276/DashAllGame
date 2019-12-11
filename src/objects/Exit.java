package objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import game.Game2;
import game.GameLoader;
import gfx.Resize;
import main.DrawGame;

public class Exit {
	private int x,y,t=0;
	private Random rnd;
	private Rectangle rec;
	
	public Exit() {
		rnd = new Random();
		replace();
		rec = new Rectangle(x,y,100,100);
	}
	public void replace() {
		x=(int) (rnd.nextInt(1920-100)*Resize.x);
		y=(int) (rnd.nextInt(1080-100)*Resize.y);
	}
	public void update() {
		if(rec.contains(DrawGame.mousemanager.getX(),
				DrawGame.mousemanager.getY())) {
			t++;
			if(t==100) {
//			GameLoader.setN(GameLoader.getN()+10);
//			DrawGame.getgameloader().setGame(new Game(GameLoader.getN()));
			DrawGame.getgameloader().getGame().replace();
			replace();
			rec.setBounds(x, y, 100, 100);
			}
		}
		else t=0;
	}
	
	public void render(Graphics g) {
		g.drawRect(x, y, 100, 100);
		if(rec.contains(DrawGame.mousemanager.getX(),
				DrawGame.mousemanager.getY())) {
			g.drawRect(x+100/2-t/2, y+100/2-t/2, t, t);
		}
	}
}
