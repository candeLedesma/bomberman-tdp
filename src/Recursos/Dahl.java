package Recursos;


public class Dahl extends Enemigo{
	
	private String ruta1= "/Images/dahl2.0.png";
	private String ruta2= "/Images/dahl2.1.png";

	public Dahl() {
		super();
		setImagen("/Images/dahl2.0.png");
		speed=4;
		puntos=400;
	}

	@Override
	protected void cambiarSprite() {
		if(spriteNum==1)
			setImagen(ruta1);
		if(spriteNum==2)
			setImagen(ruta2);
	
		contarSprite();
		
	}

}
