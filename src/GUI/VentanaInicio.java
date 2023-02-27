package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Audio.Sonido;

public class VentanaInicio extends JFrame{
	
	private final int filas = 15;//15
	private final int columnas =27;//27
	private JPanel contentPane;
	private final int tileSize = 48;//
	private final int screenWidth = tileSize*columnas;
	private final int screenHeight = tileSize*filas;
	private JButton b;
	private Sonido sound;
	private JButton soundButton;

	public VentanaInicio() {
		setSize(new Dimension(screenWidth,screenHeight+100));//ancho,largo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Bomberman");	
		setVisible(true);
		this.setResizable(false);
		
		contentPane= new JPanel();
		contentPane.setSize(new Dimension(screenWidth,screenHeight+100));
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel fondo = new JLabel();
		fondo.setIcon(new ImageIcon(Ventana.class.getResource("/Images/start.png")));
		fondo.setBounds(0, 0, screenWidth, screenHeight+100);
		contentPane.add(fondo);
		
		ponerBoton();
		ponerBotonSonido();
	}
	

	
	private void ponerBotonSonido() {
		
		sound = new Sonido("src/Audio/stageTheme.wav");
		sound.activarSonido(1);
		
		soundButton = new JButton();
		soundButton.setIcon(new ImageIcon(Ventana.class.getResource("/Images/mute.png")));
		soundButton.setBorder(null);
		soundButton.setBounds(610,500,50,50);//x,y,ancho,alto
		contentPane.add(soundButton);
		contentPane.setComponentZOrder(soundButton,0);
		//soundButton.setVisible(true);
		OyenteSound oyenteS = new OyenteSound(this);
		soundButton.addActionListener(oyenteS);
		
	}
	
	
	public Sonido getSonido() {
		return sound;
	}

	public JButton getBotonSonido() {
		return soundButton;
	}

	public void stopMusic() {
		sound.stopSound();
	}

	private void ponerBoton() {
		b = new JButton();
		b.setIcon(new ImageIcon(Ventana.class.getResource("/Images/newgame.png")));
		b.setBorder(null);
		b.setBounds(580,400,100,50);//x,y,ancho,alto
		contentPane.add(b);
		contentPane.setComponentZOrder(b, 0);
		OyenteStart oyente = new OyenteStart(this);
		b.addActionListener(oyente);
	
	}

	public JButton getBoton() {
		return b;
		
	}
	

}
