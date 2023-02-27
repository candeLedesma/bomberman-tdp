package Logica;

import java.util.LinkedList;

import GUI.Ventana;
import Recursos.Bomba;
import Recursos.Celda;
import Recursos.Entidad;
import Recursos.Pared;
import Recursos.Transitable;


public class Grilla {

	private Juego juego = Juego.getJuego();
	private Celda grilla[][];
	private LinkedList<Pared> paredes;
	private Ventana window;
	
	
	/* Responsabilidades:
	 * poner paredes
	 * */
	
	public Grilla(LinkedList<Pared> paredes) {
		window = juego.getVentana();
		this.paredes = paredes;
		int filas = window.getFilas();
		int columnas = window.getColumnas();
		grilla = new Celda[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				grilla[i][j] = new Transitable(i, j);//seteo la grilla (comienza vacia)

			}
		}
		ponerParedes();
	}


	private void ponerParedes() {
		int fila;
		int col;
		for (Pared p: paredes) {
			fila = p.getFila();
			col = p.getCol();
			grilla[fila][col] = p;
			
		}
		
	}
	
	public Celda getCelda(int i, int j) {
		return grilla[i][j];
	}

	public void setBomba(Bomba b) {
		int i = b.getFila();
		int j = b.getCol();
		grilla[i][j].accept(b);//aceptar bomba
	}

	public LinkedList<Pared> getParedes() {
		return paredes;
	}
}
