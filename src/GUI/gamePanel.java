package GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import Logica.Grilla;
import Logica.Juego;
import Recursos.Celda;

public class gamePanel extends JPanel implements KeyListener{

	private Juego juego= Juego.getJuego();
	private JPanel panelGrilla;
	private final int filas;//15
	private final int columnas;
	private final int tileSize = 48;
	private int screenWidth;
	private int screenHeight;
	
	
	public gamePanel(int filas,int columnas) {
		
		this.filas=filas;
		this.columnas=columnas;
		panelGrilla=  new JPanel();
		
		screenWidth = tileSize*columnas;
		screenHeight = tileSize*filas;
		
		
		this.setBounds(0,75,screenWidth,screenHeight);
		
		panelGrilla.setBounds(0,75,screenWidth,screenHeight);
		panelGrilla.setBackground(new Color(12,124,20));
		
		panelGrilla.setLayout(new GridLayout(filas,columnas,0,0));
		this.add(panelGrilla);
		panelGrilla.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		int mover=-1;
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			mover=0;
		else if(e.getKeyCode() == KeyEvent.VK_LEFT)
			mover=2;
	
		else if(e.getKeyCode() == KeyEvent.VK_UP)
			mover=3;

		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
			mover=1;
		else if(e.getKeyCode()== KeyEvent.VK_SPACE)
			mover=4;
		
		juego.mover(mover);
	}

	@Override
	public void keyReleased(KeyEvent e) {}
	

	public void initGrilla(Grilla grilla) {
		for(int i=0; i < filas; i++) {
			for(int j =0; j < columnas; j++) {
				panelGrilla.add(grilla.getCelda(i,j));
			}
		}

	}


	
}
