package Recursos;

public class FireUp extends PowerUp {

	/*activarInmunidad a las bombas*/
	public FireUp() {
		super();
		ruta = "/Images/fireUp.png";
	}

	@Override
	public void accept(Jugador j) {
		j.visitarFireUp(this);
	}
}
