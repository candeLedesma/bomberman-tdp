package Logica;

import java.util.LinkedList;
import java.util.Random;
import Recursos.Enemigo;

public class ManejadorEnemigos {
	
	protected Juego game = Juego.getJuego();
	private LinkedList<Enemigo> enemigos;
	private Factory factory;
	private int dir;

	public ManejadorEnemigos(int nivel) {
		enemigos = new LinkedList<Enemigo> ();
		if (nivel == 1)
			factory = new Generador1();
		else if (nivel == 2) {
			factory = new Generador2();
			game.limpiar();
		}
	}
	
	public synchronized void crearEnemigo() {
		int max = 3;
		int min = 1;
		Random random = new Random();
		int nroRandom = random.nextInt(max + min) + min;
		Enemigo enem = null;
		switch (nroRandom) {
		case 1:
			enem = factory.crearEnemigo1();
			enemigos.addLast(enem);
			break;
			
		case 2: 
			enem = factory.crearEnemigo2();
			enemigos.addLast(factory.crearEnemigo2());
			break;
			
		case 3:
			enem = factory.crearEnemigo3();
			enemigos.addLast(enem);
			break;
		}
		if(enem != null)
			posicionRandom(enem);
		
	}

	private void posicionRandom(Enemigo enem) {
		int max = 6;
		int min = 1;
		Random random = new Random();
		int nroRandom = random.nextInt(max + min) + min;
		int x;
		int y;
		switch(nroRandom) {
		case 1:
			x = 5 * 48;//col*48
			y = 4 * 48;//fil*48
			break;
		case 2: 
			x = 5 * 48;//col*48
			y = 11 * 48;//fil*48
			break;
			
		case 3:
			x = 21 * 48;//col*48
			y = 5 * 48;//fil*48
			break;
		case 4:
			x = 21 * 48;//col*48
			y = 12 * 48;//fil*48
			break;
		case 5:
			x = 23 * 48;//col*48
			y = 15 * 48;//fil*48
			break;
		default:
			x = 11 * 48;//col*48
			y = 3 * 48;//fil*48
			break;
		}
		
		if (game.getJugador().getFil() != y/48 && game.getJugador().getCol() != x/48) {
			enem.setX(x);
			enem.setY(y);
		} else
			posicionRandom(enem);
	}


	public synchronized void moverEnemigos() {
		for (Enemigo e: ((LinkedList<Enemigo>)enemigos.clone())) {
			if (game.getSegundos() % 15 == 0)
				dir = dirRandom();
			e.mover(dir, game.getColisionChecker());
			game.getVentana().update(e);
		}
	}
	
	public int dirRandom() {
		int max = 4;
		int min = 0;
		Random random = new Random();
		return (random.nextInt(max + min) + min);
	}
	
	public LinkedList<Enemigo> getEnemigos() {
		return enemigos;
	}

	public void eliminarEnemigo(Enemigo entidad) {
		enemigos.remove(entidad);
		game.getVentana().eliminarEntidad(entidad);
	}
}
