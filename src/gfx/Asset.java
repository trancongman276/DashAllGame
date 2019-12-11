package gfx;

import java.awt.image.BufferedImage;

public class Asset {
	
	public static BufferedImage test,meoteo,lose,bg;
	
	public static void init() {
		test = Resize.resize(ImageLoader.LoadImage("/test.png"));
		meoteo = Resize.resize(ImageLoader.LoadImage("/meoteo.png"));
		lose = Resize.resize(ImageLoader.LoadImage("/lose.png"));
		bg = Resize.resize(ImageLoader.LoadImage("/background.png"));
	}
}
