package Logica;
import java.util.LinkedList;

import Recursos.Bomba;
import Recursos.Enemigo;
import Recursos.Pared;

public class ManejadorBombas {

	private Juego game = Juego.getJuego();
	
	public ManejadorBombas() {}

	public void eliminarBomba() {
		Bomba bomba = game.getJugador().eliminarBomba();
		if (bomba != null) {
			int fila = bomba.getFila();
			int col = bomba.getCol();
			game.getGrilla().getCelda(fila, col).setearImagenOg();
			explotarEntidades(bomba);
		}
	}

	public void ponerBomba() {
		Bomba bomba = game.getJugador().ponerBomba();
		if (bomba != null)
			game.getGrilla().setBomba(bomba);
	}
	
	private synchronized void explotarEntidades(Bomba b) {
		int filaE;
		int colE;
		int minFila = b.getFila() - b.getRadio();
		int maxFila = b.getFila() + b.getRadio();
		int minCol = b.getCol() - b.getRadio();
		int maxCol = b.getCol() + b.getRadio();
		LinkedList<Enemigo> enemigos = (LinkedList<Enemigo>) game.getEnemigos().clone();
		if(minFila >= 0 && maxFila < 15 && minCol >= 0 && maxCol < 27) {
			for(Enemigo e: enemigos) {
				filaE = e.getFil();
				colE = e.getCol();
				if(filaE >= minFila && filaE <= maxFila && colE == b.getCol() || 
						colE <= maxCol && colE >= minCol && filaE == b.getFila()) {
					game.eliminarEnemigo(e);
				}
			}
			
			filaE = game.getJugador().getFil();
			colE = game.getJugador().getCol();
			if (filaE >= minFila && filaE <= maxFila && colE == b.getCol() || 
					colE <= maxCol && colE >= minCol && filaE == b.getFila())  {
				game.gameOver();
			}
			
		
			for (int i = minFila; i<=maxFila; i++) {
				game.getGrilla().getCelda(i, b.getCol()).explotar();
			}
			
			
			for (int j = minCol; j <= maxCol; j++) {
				game.getGrilla().getCelda(b.getFila(), j).explotar();
			}
		}
	}
}
