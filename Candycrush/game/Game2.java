package game;

import java.awt.Graphics;

import algorithm.Main;
import object.Candy;

public class Game2 extends State{

	public Game2() {
		cc_gfx.CC_Asset.init();
		MapReader.init();
		Main.init();
		Main.check();
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		for(int i=0;i<MapReader.colls.size();i++) {
			for(int j=0;j<MapReader.colls.get(i).size();j++) {
				((Candy) MapReader.colls.get(i).get(j)).update();
			}
		}
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		for(int i=0;i<MapReader.size;i++) {
			for(int j=0;j<MapReader.size;j++) {
				g.drawImage(cc_gfx.CC_Asset.candyls.get(MapReader.map[i][j]),
						i*Candy.sizex,
						j*Candy.sizey, null);
			}
		}
		
		for(int i=0;i<MapReader.colls.size();i++) {
			for(int j=0;j<MapReader.colls.get(i).size();j++) {
				((Candy) MapReader.colls.get(i).get(j)).render(g);
			}
		}
	}

	@Override
	public void replace() {
		// TODO Auto-generated method stub
		
	}

}
