package cc_gfx;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import game.MapReader;
import gfx.Resize;
import gfx.ImageLoader;

public class CC_Asset {
	private static int[][] map;
	private final static int size = MapReader.size;
	
	public static ArrayList<BufferedImage> candyls;
	private static final int nbtype = MapReader.nbtype;
	public static void init() {
		candyls = new ArrayList<>();
		for(int i=1;i<=nbtype+1;i++) {
			candyls.add(Resize.resize((ImageLoader.LoadImage("/candies/c"+i+".png"))));
		}
//		candyls.add(Resize.resize((ImageLoader.LoadImage("/test.png"))));
	}

}
