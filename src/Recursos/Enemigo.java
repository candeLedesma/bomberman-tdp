package Recursos;

import java.awt.Rectangle;
import java.util.Random;

import Logica.ColisionChecker;

public abstract class Enemigo extends Entidad{

	protected int puntos;
	protected int mover;
	protected Rectangle rectangulo;
	
	public Enemigo() {
		super();
		mover = dirRandom();
		x = 100;
		y = 50;
		rectangulo = new Rectangle(x + 10, y + 10, 20, 20);
	}
	
	public void mover(int m, ColisionChecker cChecker) {
		colisionOn = false;
		cChecker.checkColisionEnemigo(this, mover);
		
		if (!colisionOn) {
			switch(mover) {
				case 0://derecha
					x += speed;
				break;
				case 1://abajo
					y += speed;
					break;
				case 2://izquierda
					x -= speed;
					break;
				case 3://arriba
					y -= speed;
					break;
			}
			dir = mover;
			rectangulo.setBounds(x, y, 48, 48);
		} else {
			switch(mover) {
				case 2://izquierda
					x += speed;
					dir = 0;
					break;
				case 3://arriba
					y += speed;
					dir = 1;
					break;
				case 0://derecha
					x -= speed;
					dir = 2;
					break;
				case 1://abajo
					y -= speed;
					dir = 3;
					break;
			}
			mover = dirRandom();
			rectangulo.setBounds(x + 5, y + 5, 28, 28);
		}
		
		cambiarSprite();
	
	}
	
	protected abstract void cambiarSprite();

	public int dirRandom() {
		int max = 4;
		int min = 0;
		Random random = new Random();
		return  (random.nextInt(max + min) + min);
	}

	public Rectangle getSolidArea() {
		return rectangulo;
	}

	public int getPuntos() {
		return puntos;
	}
	
	public void accept(Jugador j) {
		j.visitarEnemigo(this);
		
	}
}
