package gfx;

import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Display {
	private JFrame jframe;
	private Canvas canvas;
	private int width, height;
	private String title;

	public Display(String title, int width, int height) {
		this.title = title;
		this.height = height;
		this.width = width;
		show();
	}

	private void show() {

		jframe = new JFrame(title);
		jframe.setTitle(title);
		jframe.setResizable(false);
		jframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jframe.setUndecorated(true);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		jframe.add(canvas);
		jframe.pack();
		
		BufferedImage cursorimg = new BufferedImage(16,16,BufferedImage.TYPE_INT_ARGB);
		Cursor blank = Toolkit.getDefaultToolkit().createCustomCursor(cursorimg,
				new Point(0,0), "Blank cursor");
		
		jframe.setCursor(blank);
	}

	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return jframe;
	}
}