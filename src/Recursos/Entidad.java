package Recursos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.ColisionChecker;
import Logica.Juego;


public abstract class Entidad extends JLabel{
	
	protected Juego game = Juego.getJuego();
	protected int speed;
	protected int x,y;
	protected int dir;
	protected int spriteCounter;
	protected int spriteNum;
	protected boolean colisionOn;
	protected boolean viva;


	public Entidad() {
		viva = true;
		spriteCounter = 0;
		spriteNum = 1;
		colisionOn = false;
		dir = 0;
		speed = 4;
	}
	
	protected void contarSprite() {
		spriteCounter++;
		if (spriteCounter > 5) {
			if (spriteNum == 1)
				spriteNum = 2;
			else if (spriteNum == 2)
				spriteNum = 1;
			spriteCounter = 0;
		}
	}

	public void mover(int m, ColisionChecker cChecker) {}//hacer abstracto??

	public void setImagen(String ruta) {
		this.setIcon(new ImageIcon(Pared.class.getResource(ruta)));
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public int getFil() {
		return (y + 20) / 48;
	}
	
	public int getCol() {
		return (x + 20) / 48;
	}

	public int getDireccion() {
		return dir;
	}
	
	public int getVelocidad() {
		return speed;
	}

	public void setColisionOn(boolean b) {
		colisionOn = b;
	}

	public void morir() {}

}
