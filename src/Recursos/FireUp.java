package Recursos;

public class FireUp extends PowerUp{

	/*incrementa el radio de las bombas*/
	public FireUp() {
		super();
		ruta="/Images/fireUp.png";
	}

	@Override
	public void accept(Jugador j) {
		j.visitarFireUp(this);
		
	}



}
