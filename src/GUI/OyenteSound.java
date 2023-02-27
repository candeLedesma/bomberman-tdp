package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class OyenteSound implements ActionListener{
	
	private VentanaInicio ventana;
	
	public OyenteSound(VentanaInicio ventana) {
		this.ventana=ventana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(ventana.getSonido().isSonidoActivo()) {
			ventana.getSonido().stopSound();//clip.stop();
			ventana.getSonido().setSonidoActivo(false);//sonidoActivo=false;
			ventana.getBotonSonido().setIcon(new ImageIcon(Ventana.class.getResource("/Images/unmute.png")));
    	}else {
    		ventana.getSonido().startSound();//clip.start
    		ventana.getSonido().setSonidoActivo(true);//sonidoActivo=false;//sonidoActivo=true;
    		ventana.getBotonSonido().setIcon(new ImageIcon(Ventana.class.getResource("/Images/mute.png")));
    	}
		ventana.getBotonSonido().setBorder(null);
	}

}
