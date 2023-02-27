package Recursos;

public class Ballom extends Enemigo{
	
	private String ruta1= "/Images/Ballom.1.1.png";
	private String ruta2= "/Images/Ballom.1.2.png";
	private String ruta3= "/Images/Ballom.1.3.png";

	public Ballom() {
		super();
		setImagen(ruta1);
		speed=2;
		puntos=100;
	}
	
	protected void contarSprite() {
		spriteCounter++;
		if(spriteCounter>6) {
			if(spriteNum==1)
				spriteNum=2;
			else if(spriteNum==2)
				spriteNum=1;
			//else if(spriteNum==3)
				//spriteNum=1;
			
			spriteCounter=0;
		}
	}

	@Override
	protected void cambiarSprite() {
		if(spriteNum==1)
			setImagen(ruta1);
		if(spriteNum==2)
			setImagen(ruta2);
		if(spriteNum==3)
			setImagen(ruta3);
	
		contarSprite();
		
	}

	


}
