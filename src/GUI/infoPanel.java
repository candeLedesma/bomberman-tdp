package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Audio.Sonido;

public class InfoPanel extends JPanel{
	
	private JLabel tiempo;
	private JLabel lblPuntaje;

	public InfoPanel(int ancho) {
		
		this.setBounds(0, 0, ancho, 75);
		this.setVisible(true);
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(null);
		
		tiempo = new JLabel("Time: ");
		tiempo.setFont(new Font("BOLD", Font.PLAIN, 18));
		tiempo.setBounds(10, 30, 100, 30);
		this.add(tiempo);
		
		lblPuntaje = new JLabel("Puntaje: 0");
		lblPuntaje.setFont(new Font("BOLD", Font.PLAIN, 18));
		lblPuntaje.setBounds(411, 32, 153, 27);
		this.add(lblPuntaje);
		
	}
	
	public void setLabelTiempo(int seg) {
		String tiempoActual = Integer.toString(seg);
		tiempo.setText("Time: " + tiempoActual);
	}
	
	public void setLabelPuntaje(int puntaje) {
		String puntajeActual = Integer.toString(puntaje);
		lblPuntaje.setText("Puntaje: " + puntajeActual);
	}
	

}
