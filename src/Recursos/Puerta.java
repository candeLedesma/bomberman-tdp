package Recursos;

import Audio.Sonido;

public class Puerta extends PowerUp{
	
	private Sonido sound;

	public Puerta() {
		super();
		ruta = "/Images/puerta.png";
	}

	public void accept(Jugador j) {
		sound = new Sonido("src/Audio/dooropen.wav");
		sound.activarSonido(2);
		j.visitarPuerta(this);
		
	}

	public Sonido getSounido() {
		return sound;
	}
}
