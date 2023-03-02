package Logica;
import java.util.LinkedList;
import GUI.Ventana;
import Recursos.Bomba;
import Recursos.Destruible;
import Recursos.Enemigo;
import Recursos.Jugador;
import Recursos.Pared;


public class Juego {
	private static Juego juego = new Juego();
	private int nivel;
	private Grilla grilla;
	private GeneradorNivel generador;
	private Ventana window;
	private Jugador jugador;
	private ColisionChecker cChecker;
	private ManejadorEnemigos mEnemigos;
	private ManejadorBombas mBombas;
	private int segundos;
	private int puntaje;
	private boolean termino;
	
	public static Juego getJuego() {
		return juego;
	}
	
	public void iniciarJuego(Ventana window) {
		this.window = window;
		int filas = window.getFilas();
		int columnas = window.getColumnas();
		termino = true;
		nivel = 1;
		puntaje = 0;
		generador = new GeneradorNivel(filas, columnas);
		nextLevel();
	}
	
	private void nextLevel() {
		mEnemigos = new ManejadorEnemigos(nivel);
		mBombas = new ManejadorBombas();
		
		if (nivel < 3) {
			segundos = 300;
			LinkedList<Pared> paredes = generador.getLevel(nivel);
			grilla = new Grilla(paredes);
			cChecker = new ColisionChecker();
			cChecker.setPowerUps(generador.getParedesDestruibles());
			jugador = new Jugador();
			if(nivel == 2)
				jugador.setSpeed(2);
			window.update(jugador);
			window.initGrilla(grilla);
		} else {
			win();
		}
	}

	public void limpiar() {
		window.limpiarGrilla();
	}

	public synchronized void gameOver() {
		termino = true;
		window.gameOver();
	}
	
	private synchronized void win() {
		termino = true;
		window.win();
	}

	public void initGrilla() {
		window.initGrilla(grilla);
	}
	
	public synchronized void mover(int mover) {
		if (mover != 4) {
			jugador.mover(mover, cChecker);
			window.update(jugador);
		} else
			mBombas.ponerBomba();
	}

	public LinkedList<Bomba> getBombas() {
		return (LinkedList<Bomba>) jugador.getBombas().clone();
	}
	
	public LinkedList<Pared> getParedesDestruibles() {
		return generador.getParedesDestruibles();
	}

	public Ventana getVentana() {
		return window;
	}

	public Grilla getGrilla() {
		return grilla;
	}

	
	public void ponerPuerta() {
		nivel++;
		nextLevel();
	}

	public Jugador getJugador() {
		return jugador;
	}

	public int getSegundos() {
		return segundos;
		
	}

	public void restarSegundos() {
		window.setLabelTiempo(segundos);
		segundos--;	
	}
	
	public void eliminarPared(Destruible destruible) {
		grilla.getParedes().remove(destruible);
		destruible.ponerPowerUp();
		
	}

	public void actualizarPuntaje(int p) {
		this.puntaje += p;
		window.actualizarLabelPuntaje(puntaje);	
	}

	public ManejadorEnemigos getManejadorEnemigos() {
		return mEnemigos;
	}

	public ColisionChecker getColisionChecker() {
		return cChecker;
	}

	public ManejadorBombas getManejadorBombas() {
		return mBombas;
	}

	public LinkedList<Enemigo> getEnemigos() {
		return mEnemigos.getEnemigos();
	}

	public void eliminarEnemigo(Enemigo e) {
		e.accept(jugador);
		window.eliminarEntidad(e);
		mEnemigos.getEnemigos().remove(e);
	}

	public void moverEnemigos() {
		mEnemigos.moverEnemigos();
	}

	public int getPuntaje() {
		return puntaje;
	}

	public boolean noTermino() {
		return termino;
	}

}
