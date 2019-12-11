package game;

import java.awt.Graphics;

public class GameLoader {
	private State state;
	private static int n=1;
	public GameLoader() {
		
	}
	
	public void update() {
		state.update();
	}
	
	public void render(Graphics g) {
		state.render(g);
	}

	public State getGame() {
		return state;
	}

	public void setGame(State state) {
		this.state = state;
	}

	public static int getN() {
		return n;
	}

	public static void setN(int n) {
		GameLoader.n = n;
	}
	
}
