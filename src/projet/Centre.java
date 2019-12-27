package projet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Centre extends ZoneCommune {
	public Centre() {
		super();
		
	}
	public boolean ContientPremier() { //on verifie si le centre contient la tuile premier joueur
		for(Tuile t:liste)
			if (t instanceof TuilePremier ) {
				return true;
			}
		return false;
	}

	
}
