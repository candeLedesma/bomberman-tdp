package Audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sonido {

	protected File file;
	protected AudioInputStream audioStream;
	protected Clip clip ;
	protected boolean sonidoActivo;
		
	public Sonido(String s) {
		file = new File(s);
		sonidoActivo=false;
		try {
			audioStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
		} catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
			e.printStackTrace();
		} 
	}
	
	public void activarSonido(int i) {
		clip.start();
		if(i==1)
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		sonidoActivo=true;
	}
	

	public boolean isSonidoActivo() {
		return sonidoActivo;
	}

	public void setSonidoActivo(boolean sonidoActivo) {
		this.sonidoActivo = sonidoActivo;
	}

	public void stopSound() {
		clip.stop();
		
	}

	public void startSound() {
		clip.start();
	}
	
	public void closeSound() {
		clip.close();
	}
	
	public void setSound(String s) {
		file = new File(s);
		sonidoActivo=false;
		try {
			audioStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
		} catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
			e.printStackTrace();
		} 
		
	}
	

}
