package GUI;

import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Recursos.Celda;
import Recursos.Enemigo;
import Recursos.Entidad;

public class JugadorPanel extends JPanel {
	
	public JugadorPanel(int ancho, int alto) {
		this.setBounds(0, 75, ancho, alto);
		this.setOpaque(false);
		this.setLayout(null);
	}
	
	public void update(Entidad ent) {
		JLabel label = ent;
		label.setBounds(ent.getX(), ent.getY(), 48, 48);//ancho,alto,tilesize,tilesize
		this.add(label);
		this.setComponentZOrder(label, 0);	
		this.repaint();
	}
	
	public void setearBomba(Celda c) {
		JLabel label = c;
		label.setBounds(c.obtenerX() + 5, c.obtenerY(), 48, 48);
		this.add(c);
	}
	
	public void eliminarBomba(Celda c) {
		this.remove(c);
	}

	public void eliminarEntidad(Entidad entidad) {
		this.remove(entidad);
		
	}

	public void eliminarEnemigos(LinkedList<Enemigo> enemigos) {
		for (Enemigo e: enemigos) {
			this.remove(e);
		}
		
	}
	

}
