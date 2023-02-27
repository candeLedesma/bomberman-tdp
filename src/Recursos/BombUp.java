package Recursos;

public class BombUp extends PowerUp{

	/*deja poner mas de una bomba a la vez*/
	public BombUp() {
		super();
		ruta="/Images/bombUp.png";
	}

	@Override
	public void accept(Jugador j) {
		j.visitarBombUp(this);
		
	}

}
