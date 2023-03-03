package Logica;

import Recursos.Ballom;
import Recursos.BombUp;
import Recursos.Doria;
import Recursos.Enemigo;
import Recursos.FireUp;
import Recursos.Ovape;
import Recursos.PowerUp;


public class Generador2 implements Factory{
	
	public Generador2() {}

	@Override
	public Enemigo crearEnemigo1() {
		Enemigo enemigo = new Ballom();
		return enemigo;
	}

	@Override
	public Enemigo crearEnemigo2() {
		Enemigo enemigo = new Doria();
		return enemigo;
	}

	@Override
	public Enemigo crearEnemigo3() {
		Enemigo enemigo = new Ovape();
		return enemigo;
	}

	@Override
	public PowerUp crearPowerUp1() {
		PowerUp power = new FireUp();
		return power;
	}

	@Override
	public PowerUp crearPowerUp2() {
		BombUp power = new BombUp();
		return power;
	}

}
