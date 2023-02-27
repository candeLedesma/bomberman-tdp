package Recursos;


public class Skate extends PowerUp{

	
	/*aumenta la velocidad*/
	public Skate() {
		super();
		ruta="/Images/skate.png";
	}
	
	public void accept(Jugador j) {
		j.visitarSkate(this);
	}
}
