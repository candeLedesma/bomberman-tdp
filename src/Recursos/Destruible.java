package Recursos;

import Logica.Juego;

public class Destruible extends Pared{

	public Destruible(int fil, int col) {
		super(fil, col);
		setImagen("/Images/wall2.png");
	}

	public void explotar() {
		this.setIcon(null);
		Juego.getJuego().eliminarPared(this);
		ponerPowerUp();
	}
	
	public void ponerPowerUp() {
		if (powerUp != null) {
			setImagen(powerUp.getRuta());
			this.repaint();
		}
	}
	
	public void accept(Bomba b) {//esti borrar
		b.visitarDestruible(this);
		setImagen(b.getRuta());
		this.repaint();
	}
	

}
