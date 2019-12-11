package game;

import java.util.ArrayList;
import java.util.Random;

import object.Candy;

public class MapReader {
	public final static int nbtype = 4;
	public final static int size = 10;
	public static int[][] map = new int[size][size];
	public static ArrayList<ArrayList> colls;
	public static Random rnd;
	
	public static void init() {
		rnd = new Random();
		colls = new ArrayList<>();
		for(int i=1;i<=size;i++) {
			colls.add(new ArrayList<Candy>());
			for(int j=1;j<=size;j++) {
				map[i-1][j-1] = rnd.nextInt(nbtype)+1;
				colls.get(i-1).add(new Candy((i-1)*Candy.sizex,
						(j-1)*Candy.sizey,map[i-1][j-1]));
			}
		}
		
//		for(int i=1;i<=size;i++) {
//			for(int j=1;j<=size;j++) {
//				System.out.print(map[i-1][j-1]+"\t");
//			}
//			System.out.println();
//		}
		
	}
}
