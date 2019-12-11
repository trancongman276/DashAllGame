package main;

import sound.MusicPlayer;

public class Launcher {
	public static void main(String arg[]) {
		ThreadPool thred = new ThreadPool(2); 
		DrawGame game = new DrawGame("Name",1920,1080);
		MusicPlayer sound = new MusicPlayer("bgsound");
		thred.runTask(game);
		thred.runTask(sound);
		thred.join();
	}
}
