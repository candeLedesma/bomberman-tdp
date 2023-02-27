package Logica;

public class HiloEnemigos extends Thread{
	
	private Juego game = Juego.getJuego();

	public HiloEnemigos() {}
	
	public void run() {
		while (game.noTermino()) {
			try {
				Thread.sleep(80);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			game.moverEnemigos();
			
		}
	}

}
