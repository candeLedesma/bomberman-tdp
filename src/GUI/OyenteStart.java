package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class OyenteStart implements ActionListener {
	
	VentanaInicio inicio;

	public OyenteStart(VentanaInicio inicio) {
		this.inicio = inicio;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new Ventana();
		inicio.setVisible(false);
		JButton boton = inicio.getBoton();
		boton.setEnabled(false);
		inicio.remove(boton);
	}

}
