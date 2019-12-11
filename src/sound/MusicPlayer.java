package sound;

import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

public class MusicPlayer implements Runnable{

	private ArrayList<String> musicls;
	
	public MusicPlayer(String... files) {
		musicls = new ArrayList<String>();
		for(String file: files) {
			musicls.add("./res/"+file+".wav");
		}
	}
	public void play(String filename) {
		try {
			File soundfile = new File(filename);
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundfile);
			AudioFormat format = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip clip = (Clip) AudioSystem.getLine(info);
			clip.open(ais);
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-10);
			clip.start();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		play(musicls.get(0));
		// TODO Auto-generated method stub
		
	}

}
