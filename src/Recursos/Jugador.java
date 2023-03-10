package Recursos;

import java.util.Iterator;
import java.util.LinkedList;
import Logica.ColisionChecker;
import Logica.Juego;
import Logica.Visitor;

public class Jugador extends Entidad implements Visitor {
	
	private Juego game = Juego.getJuego();
	private String down1, down2, up1, up2, left1, left2, right1, right2;
	private LinkedList<Bomba> bombas;
	private int contBombas;
	private int maxBombas;
	private int puntaje;	
	private boolean inmune;
	private int wait;
	
	public Jugador() {
		super();
		down1 = "/Images/boy_down_1.png";
		up1 = "/Images/boy_up_1.png";
		left1 = "/Images/boy_left_1.png";
		right1 = "/Images/boy_right_1.png";
		down2 = "/Images/boy_down_2.png";
		up2 = "/Images/boy_up_2.png";
		left2 = "/Images/boy_left_2.png";
		right2 = "/Images/boy_right_2.png";
		setImagen(down1);
		colisionOn = false;
		speed = 4;
		contBombas = 0;
		maxBombas = 1;
		puntaje = 0;
		inmune=false;
		wait=0;
		x = 200;
		y = 50;
		bombas = new LinkedList<Bomba>();
	}
	
	public void mover(int m, ColisionChecker cChecker) {
		colisionOn = false;
		cChecker.checkTile(this, m);//COLISIONCHECKER
		
		//si colisionOn es false el jugador se puede mover
		if (!colisionOn) {
			switch(m) {
				case 0://derecha
					x += speed;
					if (spriteNum == 1)
						setImagen(right1);
					if (spriteNum==2)
						setImagen(right2);
					break;
				case 1://abajo
					y += speed;
					if (spriteNum == 1)
						setImagen(down1);
					if (spriteNum == 2)
						setImagen(down2);
					break;
				case 2://izquierda
					x -= speed;
					if (spriteNum == 1)
						setImagen(left1);
					if (spriteNum == 2)
						setImagen(left2);
					break;
				case 3://arriba
					y -= speed;
					if (spriteNum == 1)
						setImagen(up1);
					if (spriteNum == 2)
						setImagen(up2);
					break;
			}
			dir = m;//direccion actual
		}
		contarSprite();
	}
	
	public Bomba ponerBomba() {
		Bomba b = null;
			if (contBombas < maxBombas) {
				contBombas++;
				b = new Bomba(getFil(), getCol());
				bombas.addLast(b);
			}
		return b;
	}

	public LinkedList<Bomba> getBombas() {
		return bombas;
	}

	public Bomba eliminarBomba() {
		Bomba b = null;
		if (contBombas <= maxBombas && !bombas.isEmpty()) {
			Iterator<Bomba> it = bombas.iterator();
			while (it.hasNext()) {
				b = it.next();
				if (b.getWait() == 3) {
					bombas.remove(b);//saca de la lista
					contBombas--;
					return b;
				} else {
					b.setWait();//aumenta tiempo esp
				}
			}
		}
		return null;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public void visitarSkate(Skate p) {//aumentarVelocidad
		speed += 1;
	}

	@Override
	public void visitarFireUp(FireUp p) {//activarInmunidad
		inmune=true;
	}

	@Override
	public void visitarBombUp(BombUp p) {//aumentarBombas()
		maxBombas += 1;
	}

	public void visitarPuerta(Puerta puerta) {
		game.ponerPuerta();
	}

	public void visitarEnemigo(Enemigo e) {
		puntaje += e.getPuntos();
		game.actualizarPuntaje(puntaje);
	}

	//prueba nuevo powerUp
	public boolean isInmune() {
		return inmune;
	}

	public void desactivarInmunidad() {
		if(inmune) {
			if (wait == 15) {
				inmune=false;
				wait=0;
			}else
				wait++;
		}
	}

}
