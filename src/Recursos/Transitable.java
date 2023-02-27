package Recursos;

public class Transitable extends Celda{
	
	public Transitable(int fil, int col) {
		super(fil, col);
		this.repaint();
	}

	@Override
	public void accept(Bomba b) {
		b.visitarTransitable(this);
		setImagen(b.getRuta());
		this.repaint();
	}

	@Override
	public void setearImagenOg() {
		this.setIcon(null);
		this.repaint();
	}
}
