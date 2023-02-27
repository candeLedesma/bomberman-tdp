package Recursos;

import Logica.ColisionChecker;

public class Ovape extends Enemigo{
	
	private String rutaDer = "/Images/ovapeDerecha.png";
	private String rutaIzq = "/Images/ovapeIzquierda.png";
	private String ruta1 = "/Images/ovape5.0.png";
	private String ruta2 = "/Images/ovape5.1.png";

	public Ovape() {
		super();
		setImagen("/Images/ovape5.0.png");
		speed = 4;
		puntos = 2000;
	}

	@Override
	protected void cambiarSprite() {
		if (spriteNum == 1)
			setImagen(ruta1);
		if (spriteNum == 2)
			setImagen(ruta2);
		if (spriteNum == 3)
			setImagen(rutaIzq);
		if (spriteNum == 4)
			setImagen(rutaDer);
		contarSprite();
	}

	public void mover(int m, ColisionChecker cChecker) {
		colisionOn = false;
		cChecker.checkColisionEnemigo(this, mover);
		
		if (!colisionOn) {
			switch(mover) {
				case 0://derecha
					x += speed;
					spriteNum = 4;
					break;
				case 1://abajo
					y += speed;
					break;
				case 2://izquierda
					x -= speed;
					spriteNum = 3;
					break;
				case 3://arriba
					y -= speed;
					break;
			}
			dir = mover;
			rectangulo.setBounds(x, y, 48, 48);
		} else {
			switch (mover) {
				case 2://izquierda
					x += speed;
					dir = 0;
					spriteNum = 4;
					break;
				case 3://arriba
					y += speed;
					dir = 1;
					break;
				case 0://derecha
					x -= speed;
					dir = 2;
					spriteNum = 3;
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
	
	protected void contarSprite() {
		spriteCounter++;
		if (spriteCounter >= 2) {
			if (spriteNum == 1)
				spriteNum = 2;
			else if (spriteNum == 2)
				spriteNum = 3;
			else 
				spriteNum = 1;
			
			spriteCounter = 0;
		}
	}

}


