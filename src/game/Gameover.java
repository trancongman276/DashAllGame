//package game;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//
//import gfx.Asset;
//import main.DrawGame;
//
//public class Gameover extends State{
//
//	public Gameover() {
//		// TODO Auto-generated constructor stub
//		
//	}
//
//	@Override
//	public void update() {
//		// TODO Auto-generated method stub
//		if(DrawGame.mousemanager.isIsclicked()==true){
//			DrawGame.mousemanager.setIsclicked(false);
//			DrawGame.getgameloader().setGame(new Game(1));
//			GameLoader.setN(1);
//		}
//	}
//
//	@Override
//	public void render(Graphics g) {
//		// TODO Auto-generated method stub
//		
//		g.drawImage(Asset.lose, 0, 0, null);
//		g.setFont(new Font("TimesRoman",Font.PLAIN, 200));
//		g.setColor(new Color(255,0,0));
//		g.drawString(Integer.toString(GameLoader.getN()), 100, 200);
//	}
//
//	@Override
//	public void replace() {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
