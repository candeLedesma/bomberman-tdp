package Logica;

import Recursos.Destruible;
import Recursos.Pared;
import Recursos.Transitable;

public interface VisitorBomba {

	public void visitarTransitable(Transitable p);
	
	public void visitarPared(Pared p);
	
	public void visitarDestruible(Destruible p);

}
