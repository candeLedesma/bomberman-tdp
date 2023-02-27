package Recursos;

import Logica.ColisionChecker;

public class Doria extends Enemigo{
	
	private String ruta1 ="/Images/doria4.0.png";
	private String ruta2 ="/Images/doria4.1.png";
	private String ruta3 ="/Images/doria4.2.png";
	private String ruta4 ="/Images/doria4.3.png";
	

	public Doria() {
		super();
		setImagen("/Images/doria4.0.png");
		speed=2;
		puntos=1000;
	}

	protected void cambiarSprite() {
		if(spriteNum==1)
			setImagen(ruta1);
		if(spriteNum==2)
			setImagen(ruta2);
		if(spriteNum==3)
			setImagen(ruta3);
	
		contarSprite();
	}
	
	
	protected void contarSprite() {
		spriteCounter++;
		if(spriteCounter>3) {
			if(spriteNum==1)
				spriteNum=2;
			else if(spriteNum==2)
				spriteNum=3;
			else if(spriteNum==3)
				spriteNum=4;
			else if(spriteNum==4)
				spriteNum=1;
			
			spriteCounter=0;
		}
	}

}
