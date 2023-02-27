package Logica;

import Recursos.Enemigo;
import Recursos.PowerUp;

public interface Factory {
	
	//ememigos
	public Enemigo crearEnemigo1();
	public Enemigo crearEnemigo2();
	public Enemigo crearEnemigo3();
	
	//powerups
	public PowerUp crearPowerUp1();
	public PowerUp crearPowerUp2();
}
