package GUI;

import javax.swing.*;

import Logica.Grilla;
import Logica.HiloEnemigos;
import Logica.HiloJuego;
import Logica.Juego;
import Recursos.Celda;
import Recursos.Enemigo;
import Recursos.Entidad;

import java.awt.Color;
import java.awt.Dimension;


public class Ventana extends JFrame{
	
	private Juego juego;
	private final int filas = 15;//15
	private final int columnas =27;//27
	private JPanel contentPane;
	private final int tileSize = 48;//
	private final int screenWidth = tileSize*columnas;
	private final int screenHeight = tileSize*filas;
	private gamePanel panelJuego;
	private infoPanel info;
	private jugadorPanel panelJugador;

	
	public Ventana() {
		setSize(new Dimension(screenWidth,screenHeight+100));//Width,Height
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Bomberman");	
		setVisible(true);
		this.setResizable(false);
		
		contentPane= new JPanel();
		contentPane.setSize(new Dimension(screenWidth,screenHeight+100));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ini();
		
	}

	public void ini() {
		
		contentPane.setBackground(Color.LIGHT_GRAY);
		info= new infoPanel(screenWidth);
		contentPane.add(info);
		
		panelJugador = new jugadorPanel(screenWidth,screenHeight+100);
		contentPane.add(panelJugador);
		contentPane.setComponentZOrder(panelJugador, 0);
		
		panelJuego= new gamePanel(filas,columnas);
		addKeyListener(panelJuego);
		contentPane.add(panelJuego);
		
		juego = Juego.getJuego();
		juego.iniciarJuego(this);
			
		HiloJuego hilo = new HiloJuego();
		hilo.start();
			
		HiloEnemigos hiloE = new HiloEnemigos();
		hiloE.start();

	}

	public int getTileSize() {
		return tileSize;
	}

	public int getFilas() {
		return filas;
	}
	
	public int getColumnas() {
		return columnas;
	}

	public void initGrilla(Grilla grilla) {
		panelJuego.initGrilla(grilla);
		
	}


	public void update(Entidad entidad) {
		panelJugador.update(entidad);
		
	}
	
	public gamePanel getPanel(){
		return panelJuego;}
	

	public void setearBomba(Celda celda) {
		panelJugador.setearBomba(celda);	
	}

	public void eliminarBomba(Celda celda) {
		panelJugador.eliminarBomba(celda);
	}

	public void limpiarGrilla() {
		this.remove(panelJuego);
		panelJuego= new gamePanel(filas,columnas);
		addKeyListener(panelJuego);
		contentPane.add(panelJuego);
		panelJugador.eliminarEntidad(juego.getJugador());
		panelJugador.eliminarEnemigos(juego.getEnemigos());
	}

	public void terminarJuego() {
		contentPane.remove(info);
		contentPane.remove(panelJuego);
		contentPane.remove(panelJugador);
		contentPane.setBackground(Color.BLACK);
		contentPane.repaint();
	}


	public void eliminarEntidad(Enemigo entidad) {
		panelJugador.eliminarEntidad(entidad);
		
	}

	public void actualizarLabelPuntaje(int puntaje) {
		info.setLabelPuntaje(puntaje);
	}
	
	public void setLabelTiempo(int cont) {
		info.setLabelTiempo(cont);
		
	}

	public void win() {
		terminarJuego();
		JLabel fondo = new JLabel();
		fondo.setIcon(new ImageIcon(Ventana.class.getResource("/Images/win.png")));
		fondo.setBounds(0, 0, screenWidth, screenHeight+100);
		contentPane.add(fondo);
		JLabel puntaje = new JLabel();
		puntaje.setText("Puntaje: "+juego.getPuntaje());
		puntaje.setBackground(Color.WHITE);
		puntaje.setBounds(680,450,100,50);
		contentPane.add(puntaje);
		contentPane.setComponentZOrder(puntaje, 0);
	}

	public void gameOver() {
		terminarJuego();
		JLabel fondo = new JLabel();
		fondo.setIcon(new ImageIcon(Ventana.class.getResource("/Images/gameover.png")));
		fondo.setBounds(450, 200, 450, 200);
		contentPane.add(fondo);
		contentPane.repaint();
	}


	
}