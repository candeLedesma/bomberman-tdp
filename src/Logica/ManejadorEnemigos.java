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
		Random random = new Random();
		int max=75;
		int min = 0;
		int ran = random.nextInt(max + min) + min;
		Enemigo enem = null;
		if(ran>=0 && ran <= 25) {
			enem = factory.crearEnemigo1();
			enemigos.addLast(enem);
		}else if (ran>25 && ran <= 50) {
			enem = factory.crearEnemigo2();
			enemigos.addLast(factory.crearEnemigo2());
		}else{
			enem = factory.crearEnemigo3();
			enemigos.addLast(enem);
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
		
		if (celdaLibre(x,y)) {
			enem.setX(x);
			enem.setY(y);
		} else
			posicionRandom(enem);
	}
	
	private boolean celdaLibre(int x, int y) {
		int fila= y/48;
		int col = x/48;
		boolean libre=true;
		for(int i= fila-1; i<fila+1; i++) {
			for(int j=col-1; j<col+1; j++) {
				if (game.getJugador().getFil() ==i && game.getJugador().getCol() == j) {
					libre=false;
				}
			}
		}
		return libre;
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
