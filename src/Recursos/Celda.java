package Recursos;

import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public abstract class Celda extends JLabel{

	protected int fil;
	protected int col;
	protected int x;
	protected int y;
	protected Rectangle solidArea;
	protected LinkedList<Entidad> entidades;
	
	public Celda(int fil,int col) {
		this.fil=fil;
		this.col=col;
		x=col*48;
		y=fil*48;
		entidades= new LinkedList<Entidad>();
		solidArea= new Rectangle(x,y,48,48);
	}
	
	public LinkedList<Entidad> getEntidades(){
		return entidades;
	}
	
	public Rectangle getSolidArea() {
		return solidArea;
	}
	
	public int getFila() {
		return fil;
	}
	
	public int getCol() {
		return col;
	}

	public void setImagen(String ruta) {
		this.setIcon(new ImageIcon(Pared.class.getResource(ruta)));
	}
	
	public int obtenerX() {
		return x;
	}
	
	public int obtenerY() {
		return y;
	}
	
	public void explotar() {
		
	}

	public void setEntidad(Entidad e) {
		entidades.addLast(e);
		
	}

	public void sacarEntidad(Entidad e) {
		entidades.remove(e);
		
	}

	public void ponerPowerUp() {//???
		// TODO Auto-generated method stub
		
	}
	
	public abstract void accept(Bomba b);

	public abstract void setearImagenOg();
}
