package algorithm;

import java.util.ArrayList;

import game.MapReader;
import main.DrawGame;
import object.Candy;

public class Main {
	private static int x,y,t;
	public static boolean choosing=false, moved =false;
	private static ArrayList<ArrayList> colls;
	private static int[][] map;
	private static Candy changing;
	private static boolean rmved=false, rmed=true,U,D,L,R;
	private static String st;
	
	public static void init() {
		colls = MapReader.colls;
		map = MapReader.map;
	}
	public static void chosing(int _x, int _y) {
		if(!choosing) { //not choosing any candy
			x =_x;
			y =_y;
//			System.out.println("Passed 1");
			choosing = true;
			moved = false;
			rmed = true;
		}
		else {
			if(Math.abs(_x-x)==1 || Math.abs(_y-y)==1
					&& (Math.abs(_x-x) - Math.abs(_y-y) !=0)) {
				
				changing = (Candy) colls.get(x).get(y);
				colls.get(x).set(y, (Candy) colls.get(_x).get(_y));
				colls.get(_x).set(_y, changing);
				
				t = map[x][y];
				map[x][y] = map[_x][_y];
				map[_x][_y] = t;
				moved = true;
				while(rmed) check();
				System.out.println("Passed");
			}
			choosing =false;
		}
		for(int i=0;i<MapReader.colls.size();i++) {
			for(int j=0;j<MapReader.colls.get(i).size();j++) {
				System.out.print(map[j][i]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("\n\n");
	}
	
	public static void check() {
		rmed =false;
		for(int i=0;i<MapReader.colls.size();i++) {
			for(int j=0;j<MapReader.colls.get(i).size();j++) {
				checkBean(i,j);
			}
		}
		if(st!="") rmadd();
	}
	
	private static void checkBean(int _x, int _y) {
//		System.out.println(_x + " " + _y);
		st += checkD(_x,_y,1,0);
//		System.out.println(_x + " " + _y);
		st += checkD(_x,_y,-1,0);
//		System.out.println(_x + " " + _y);
		st += checkD(_x,_y,0,1);
//		System.out.println(_x + " " + _y);
		st += checkD(_x,_y,0,-1);
//		System.out.println(_x + " " + _y);
		
//		st="";
	}
	
	private static void rmadd() {
		for(int i=0;i+1<st.length()-2;i+=2) {
			int _x=Character.getNumericValue(st.charAt(i));
			if(_x>=10) continue;
			int _y=Character.getNumericValue(st.charAt(i+1));
			if(_y>=10) continue;
			colls.get(_x).remove(_y);
			colls.get(_x).add(0,new Candy((_x)*Candy.sizex,
					0,MapReader.rnd.nextInt(MapReader.nbtype)));
		}
		
		for(int i=0;i<MapReader.colls.size();i++) {
			for(int j=0;j<MapReader.colls.get(i).size();j++) {
				((Candy) MapReader.colls.get(i).get(j)).setX((i)*Candy.sizex);
				((Candy) MapReader.colls.get(i).get(j)).setY((j)*Candy.sizey);
				map[i][j] = ((Candy) MapReader.colls.get(i).get(j)).getType();
			}
		}
		
	}
	
	private static void sortmap(int _x, int _y) {
		for(int i=_y;i>0;i--) {
				map[_x][i] = map[_x][i-1];
			}
	}
	
	private static String checkD(int _x,int _y,int dx,int dy) {
		String st="";
		int type = map[_x][_y];
		if(_x+dx>=0 && _x+dx<MapReader.size &&
				_y+dy>=0 && _y+dy<MapReader.size)
			if(map[_x+dx][_y+dy]==type) {
				rmed = true;
				st+=Integer.toString(_x+dx)+Integer.toString(_y+dy);
				if(_x+dx*2>=0 && _x+dx*2<MapReader.size &&
						_y+dy*2>=0 && _y+dy*2<MapReader.size)
					if(map[_x+dx*2][_y+dy*2]==type) 
						st+=Integer.toString(_x+dx*2)+Integer.toString(_y+dy*2);
			}
		return st;
	}
//		if(type == map[_x+2][_y+2] && type == map[_x+dx*2][_y+dy*2]) {
//			st+=Integer.toString(_x)+Integer.toString(_y);
//			st+=Integer.toString(_x+dx)+Integer.toString(_y+dy);
//			st+=Integer.toString(_x+dx*2)+Integer.toString(_y+dy*2);
//			
//			if(_x-dx>=0 && _y-dy>=0 && _x-dx<MapReader.size-2 && _y-dy<MapReader.size-2) {
//				if(map[_x-dx][_y-dy] == type) {
//					st+=Integer.toString(_x-dx)+Integer.toString(_y-dy);
//				
//					if(_x-dx*2>=0 && _y-dy*2>=0 && _x-dx*2<MapReader.size-1 && _y-dx*2<MapReader.size-1)
//						if(map[_x-dx*2][_y-dy*2]==type) st+=Integer.toString(_x-dx*2)+Integer.toString(_y-dy*2);
//				}
//			}
//			for(int i=0;i<MapReader.size;i++)
//				for(int j=0;j<MapReader.size;j++)
//					if(map[i][j]==map[_x][_y]) track[i][j]=true;
//			find(_x,_y);
//		}
//		if (st!="") {rmadd(st); System.out.println(st);}
//	}
	
	
}
