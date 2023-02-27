package Logica;

import java.awt.Rectangle;
import java.util.LinkedList;

import Recursos.Bomba;
import Recursos.Enemigo;
import Recursos.Entidad;
import Recursos.Jugador;
import Recursos.Pared;

public class ColisionChecker {
	
	private Juego game = Juego.getJuego();
	private LinkedList<Pared> powerups;
	
	
	public ColisionChecker() {}
	
	/* Responsabilidades:
	 * chequear colisiones de entidades con paredes y powerups
	 * */

	public void checkTile(Entidad entity, int dir) {
		checkColisionParedes(entity, dir);
		checkColisionPowerUps(entity);	
	}
	
	private void checkColisionPowerUps(Entidad entity) {
		
		int x = entity.getX();
		int y = entity.getY();

		switch(entity.getDireccion()) {
		case 1://abajo
			y += entity.getVelocidad();
		case 2: //izquierda
			x -= entity.getVelocidad();
		case 3: // arriba
			y -= entity.getVelocidad();
		case 4:
			x += entity.getVelocidad();
		}
			
		Rectangle rectangulo = new Rectangle(x + 10, y + 10, 20, 20);
		LinkedList<Pared> eliminar = new LinkedList<Pared>();
		
		for (Pared p: powerups) {
			if (rectangulo.intersects(p.getSolidArea())) {
				if (p.getPowerUp() != null) {
					p.getPowerUp().accept((Jugador) entity);
					p.setIcon(null);
					eliminar.addLast(p);
				}
			}
		}
		
		for (Pared p: eliminar) {
			powerups.remove(p);
			p.setPowerUp(null);
		}
		
	}

	private synchronized void checkColisionParedes(Entidad entity, int dir) {
		LinkedList<Pared> paredes=(LinkedList<Pared>) game.getGrilla().getParedes().clone();
		
		int x = entity.getX();
		int y = entity.getY();

		switch (dir){//direccion a donde me quiero mover
		case 1://abajo
			y += entity.getVelocidad();
		case 2: //izquierda
			x -= entity.getVelocidad();
		case 3: // arriba
			y -= entity.getVelocidad();
		case 4:
			x += entity.getVelocidad();
		}
			
		Rectangle rectangulo = new Rectangle(x + 5, y + 5, 30, 30);//x+5,y+5,28,28
		
		for (Pared p: paredes) {
			if (rectangulo.intersects(p.getSolidArea()) && dir == entity.getDireccion()) {
				entity.setColisionOn(true);
			}	
		}
	}

	public void setPowerUps(LinkedList<Pared> p) {
		powerups = p;
	}

	public void checkColisionPlayer(Enemigo enemigo, int mover) {
		Jugador entity = game.getJugador();
		int x = entity.getX();
		int y = entity.getY();
		Rectangle rectangulo = new Rectangle(x + 8, y + 8, 20, 20);
		if(rectangulo.intersects(enemigo.getSolidArea())) {
			game.gameOver();
		}
	}

	public void checkColisionEnemigo(Enemigo enemigo, int mover) {
		checkColisionParedes(enemigo, mover);
		checkColisionPlayer(enemigo, mover);
		checkColisionBomba(enemigo) ;
	}
	
	public void checkColisionBomba(Enemigo e) {
		 LinkedList<Bomba> bombas = game.getBombas();
		 for (Bomba b:bombas) {
			 if (b.getSolidArea().intersects(e.getSolidArea())) {
					e.setColisionOn(true);
				}
		 }
	}



}
