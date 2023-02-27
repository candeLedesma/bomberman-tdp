package Logica;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

import Archivos.Archivo;
import Recursos.Destruible;
import Recursos.Pared;
import Recursos.PowerUp;
import Recursos.Puerta;

public class GeneradorNivel {
	
	private static String txt;
	private static Archivo nivelTxt;
	private static FileReader nivelFile;
	private final int filas;
	private final int columnas;
	private Factory f;
	private LinkedList<Pared> destruibles;
	
	/*Resoinsabilidades:
	 * traducir txt
	 * generar paredes
	 * generar powerups random
	 * */
	
	public GeneradorNivel(final int filas, final int columnas) {
		nivelTxt = new Archivo();
		this.filas=filas;
		this.columnas=columnas;
	}

	public LinkedList<Pared> dameNivel(int nivel) {
		if(nivel==1)
			f = new Generador1();
		else if(nivel==2) {
			f = new Generador2();
		}
		int caracter;
		LinkedList<Pared> paredes = new LinkedList<Pared>();
		destruibles =  new LinkedList<Pared>();
		txt = nivelTxt.getNombreNivel(nivel);
		Pared p = null;
		try {
			nivelFile = new FileReader(txt);
			caracter = nivelFile.read();
			for(int i=0; i<filas && caracter!=-1; i++) {
				for(int j=0; j<columnas; j++) {
					if(caracter == '+') {
						p = new Pared(i,j);
						paredes.addLast(p);
					}if(caracter == '*') {
						p = new Destruible(i,j);
						paredes.addLast(p);
						//poner powerup
						destruibles.addLast(p);
						
					}
					caracter= nivelFile.read();
				}
			}	
			nivelFile.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		generarPowerUps(destruibles);
		return paredes;
	}


	private void generarPowerUps(LinkedList<Pared> paredes) {
		int max = paredes.size();
		int min = 0;
		Random random = new Random();
		int nroRandom;
		Pared p;
		
		for(int i= 0; i<5; i++ ) {
			nroRandom = random.nextInt(max + min) + min;
			p = paredes.get(nroRandom);
			if(i==4) {
				p.setPowerUp(new Puerta());
				System.out.println("puerta en: "+p.getFila()+" "+p.getCol());
			}else {
				p.setPowerUp(powerUpRandom());
				System.out.println("powerUp en: "+p.getFila()+" "+p.getCol());
			}
		}
	}
	
	private PowerUp powerUpRandom() {
		int max = 2;
		int min = 1;
		Random random = new Random();
		int nroRandom = random.nextInt(max + min) + min;
		PowerUp p =null;
		switch (nroRandom) { 
		    case 1:
		    	p= f.crearPowerUp1();
		     break;
		    case 2:
		     	p= f.crearPowerUp2();
		     break;	
		}
		return p;
	}
	
	public LinkedList<Pared> getParedesDestruibles(){
		return destruibles;
	}


}
