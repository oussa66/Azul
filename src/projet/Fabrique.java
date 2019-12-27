package projet;

import java.util.ArrayList;
import java.util.List;

public class Fabrique extends ZoneCommune {

	public Fabrique() {
		super();
	}
	public void remplir(Sac sac) { // on remplit la fabrique a partir du sac
		for(int i=0;i<4;i++) // on place quatre tuiles
			this.put(sac.get());
	}
	
}
