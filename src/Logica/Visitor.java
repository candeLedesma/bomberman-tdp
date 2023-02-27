package Logica;

import Recursos.BombUp;
import Recursos.Enemigo;
import Recursos.FireUp;
import Recursos.Skate;

public interface Visitor {

	public void visitarSkate(Skate p);
	
	public void visitarFireUp(FireUp p);
	
	public void visitarBombUp(BombUp p);
	
	public void visitarEnemigo(Enemigo e);

}
