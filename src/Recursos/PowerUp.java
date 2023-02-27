package Recursos;

import Logica.Juego;

public abstract class PowerUp {
	
	protected String ruta;
	protected Juego game= Juego.getJuego();

	public PowerUp() {
		ruta=" ";
	}

	public String getRuta() {
		return ruta;
	}

	public abstract void accept(Jugador j);
}
