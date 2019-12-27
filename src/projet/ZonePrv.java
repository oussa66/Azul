package projet;

public class ZonePrv extends Zone {
	protected int taille;
	public ZonePrv(int taille) {
		super();
		this.taille=taille;
	}
	public boolean estPleine() {
		return liste.size()==taille;
	}

}
