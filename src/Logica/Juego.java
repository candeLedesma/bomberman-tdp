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
	private Jugador player;
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
			LinkedList<Pared> paredes = generador.dameNivel(nivel);
			grilla = new Grilla(paredes);
			cChecker = new ColisionChecker();
			cChecker.setPowerUps(generador.getParedesDestruibles());
			player = new Jugador();
			if(nivel == 2)
				player.setSpeed(2);
			window.update(player);
			window.initGrilla(grilla);
		} else {
			win();
		}
	}

	public void limpiar() {
		window.limpiarGrilla();
	}

	public void gameOver() {
		window.gameOver();
		termino=true;
	}
	
	private void win() {
		window.win();
		termino = true;
	}

	public void initGrilla() {
		window.initGrilla(grilla);
	}
	
	public synchronized void mover(int mover) {
		if (mover != 4) {
			player.mover(mover, cChecker);
			window.update(player);
		} else
			mBombas.ponerBomba();
	}

	public LinkedList<Bomba> getBombas() {
		return (LinkedList<Bomba>) player.getBombas().clone();
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
		return player;
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
		// TODO Auto-generated method stub
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
		e.accept(player);
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
		// TODO Auto-generated method stub
		return termino;
	}

}
