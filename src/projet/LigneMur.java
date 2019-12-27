package projet;

public class LigneMur extends ZonePrv{
	public LigneMur() {
		super(5);
	}
	public Tuile getTuile(int i) {
		return liste.get(i);
	}
	public boolean put(Tuile t) {
		if(!estPleine()) {
			super.put(t);
			return true;
		}
		return false;
	}
	

}
