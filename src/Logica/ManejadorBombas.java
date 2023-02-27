package Logica;
import java.util.LinkedList;

import Recursos.Bomba;
import Recursos.Enemigo;
import Recursos.Pared;

public class ManejadorBombas {

	private Juego game= Juego.getJuego();
	
	public ManejadorBombas() {}

	public void eliminarBomba() {
		Bomba b = game.getJugador().eliminarBomba();
		if(b!=null) {
			int i = b.getFila();
			int j= b.getCol();
			game.getGrilla().getCelda(i,j).setearImagenOg();
			explotarEntidades(b);
		}
	}
	

	public void ponerBomba() {
		Bomba b = game.getJugador().ponerBomba();
		if(b!=null)
			game.getGrilla().setBomba(b);
	}
	
	private synchronized void explotarEntidades(Bomba b) {
		int filaE;
		int colE;
		int minFila =b.getFila()-b.getRadio();
		int maxFila =b.getFila()+b.getRadio();
		int minCol =b.getCol()-b.getRadio();
		int maxCol =b.getCol()+b.getRadio();
		LinkedList<Enemigo> enemigos = (LinkedList<Enemigo>) game.getEnemigos().clone();
		if(minFila>=0 && maxFila<15 && minCol>=0 && maxCol<27) {
			for(Enemigo e: enemigos) {
				filaE = e.getFil();
				colE = e.getCol();
				if(filaE>=minFila && filaE<=maxFila && colE == b.getCol() || 
						colE<=maxCol && colE>=minCol && filaE == b.getFila()) {
					game.eliminarEnemigo(e);
				}
			}
			
			filaE = game.getJugador().getFil();
			colE =game.getJugador().getCol();
			if(filaE>=minFila && filaE<=maxFila && colE == b.getCol() || 
					colE<=maxCol && colE>=minCol && filaE == b.getFila())  {
				game.gameOver();
			}
			
		
			for(int i =minFila; i<=maxFila; i++) {
				game.getGrilla().getCelda(i, b.getCol()).explotar();
			}
			
			
			for(int j =minCol; j<=maxCol; j++) {
				game.getGrilla().getCelda(b.getFila(),j).explotar();
			}
		}
	}
}
