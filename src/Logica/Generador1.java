package Logica;

import Recursos.Ballom;
import Recursos.BombUp;
import Recursos.Dahl;
import Recursos.Enemigo;
import Recursos.Onil;
import Recursos.PowerUp;
import Recursos.Skate;

public class Generador1 implements Factory{

	public Generador1() {}

	@Override
	public Enemigo crearEnemigo1() {
		Enemigo enemigo = new Ballom();
		return enemigo;
	}

	@Override
	public Enemigo crearEnemigo2() {
		Enemigo enemigo = new Onil();
		return enemigo;
	}

	@Override
	public Enemigo crearEnemigo3() {
		Enemigo enemigo = new Dahl();
		return enemigo;
	}

	@Override
	public PowerUp crearPowerUp1() {
		PowerUp power = new BombUp();
		return power;
	}

	@Override
	public PowerUp crearPowerUp2() {
		PowerUp power = new Skate();
		return power;
	}

}
