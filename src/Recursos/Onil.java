package Recursos;


public class Onil extends Enemigo{
	
	private String ruta1= "/Images/onil3.0.png";
	private String ruta2= "/Images/onil3.1.png";
	private String ruta3= "/Images/onil3.3.png";

	public Onil() {
		super();
		setImagen("/Images/onil3.0.png");
		speed=4;
		puntos=200;
	}
	
	protected void contarSprite() {
		spriteCounter++;
		if(spriteCounter>2) {
			if(spriteNum==1)
				spriteNum=2;
			else if(spriteNum==2)
				spriteNum=3;
			else if(spriteNum==3)
				spriteNum=1;
			
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
