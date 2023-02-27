package Logica;

public class HiloJuego extends Thread{

	private Juego game= Juego.getJuego();

	 
	public HiloJuego() {
        game.getSegundos();
	}
	
	public void run() {
		int enemigos=0;
		while(game.getSegundos()>0 && game.noTermino()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			game.restarSegundos();
			enemigos++;
	
			game.getManejadorBombas().eliminarBomba();
	
			if(enemigos%15==0) {
				game.getManejadorEnemigos().crearEnemigo();
			}
		
		}
		game.restarSegundos();
		game.gameOver();
			
	}
		

}