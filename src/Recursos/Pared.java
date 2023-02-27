package Recursos;

public class Pared extends Celda{
	
	protected PowerUp powerUp;
	
	public Pared(int fil, int col) {
		super(fil, col);
		setImagen("/Images/pared.png");
		powerUp = null;
	}

	public PowerUp getPowerUp() {
		return powerUp;
	}

	public void setPowerUp(PowerUp powerUp) {
		this.powerUp = powerUp;
	}

	@Override
	public void accept(Bomba b) {}

	@Override
	public void setearImagenOg() {
		setImagen("/Images/pared.png");
		this.repaint();
	}

}
