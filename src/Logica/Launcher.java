package Logica;

import GUI.VentanaInicio;

public class Launcher {

	public static void main(String arg[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new VentanaInicio(); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
