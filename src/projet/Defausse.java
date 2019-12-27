package projet;

public class Defausse extends ZoneJh{

	public Defausse() {
		super();
	}
	public void remplirSac(Sac sac) { // on remplit le sac depuis la defausse si le sac est vide
		if(sac.isEmpty())
			while(!this.isEmpty())
				sac.put(this.get());
	}
	
}
