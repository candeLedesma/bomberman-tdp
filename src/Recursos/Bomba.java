package Recursos;

import java.awt.Rectangle;

import Audio.Sonido;
import Logica.VisitorBomba;

public class Bomba implements VisitorBomba{
	
	private int radio;
	private int fil;
	private int col;
	private String ruta ="/Images/bomba.png";
	private Rectangle solidArea;
	private int wait;
	private Sonido sound;

	public Bomba(int fil,int col) {
		this.fil = fil;
		this.col = col;
		radio = 1;
		int x = col * 48;
		int y = fil * 48;
		wait = 0;
		solidArea = new Rectangle(x + 5, y + 5, 40, 40);
	}
	
	private void explotar(Celda c) {
		for(Entidad e: c.getEntidades()) {
			e.morir();
		}
	}
	
	public int getRadio() {
		return radio;
	}

	public void incrementarRadio() {
		radio += 1;
	}

	@Override
	public void visitarTransitable(Transitable p) {
		explotar(p);
	}

	@Override
	public void visitarPared(Pared p) {}

	@Override
	public void visitarDestruible(Destruible p) {
		explotar(p);
	}

	public int getFila() {
		return fil;
	}
	
	public int getCol() {
		return col;
	}

	public String getRuta() {
		return ruta;
	}

	public Rectangle getSolidArea() {
		return solidArea;
	}

	public int getWait() {
		return wait;
	}

	public void setWait() {
		wait++;
		if (wait == 3) {
			sound = new Sonido("src/Audio/burning.wav");
			sound.activarSonido(2);
		}
	}
	
	public Sonido getSonido() {
		return sound;
	}

}
