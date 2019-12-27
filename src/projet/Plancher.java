package projet;

import java.util.List;

public class Plancher extends ZonePrv {
	
	public Plancher() {
		super(6);
		;
	}
	public void putAll(List<Tuile> l,Defausse defausse) { // place une liste de tuiles dans le plancher
		for(int i=0;i<liste.size();i++ ) {
			
			if (this.estPleine()) {
				defausse.put(liste.get(i));
				liste.remove(i);
				i--;
				
			}
			else
				this.put(liste.get(i));
		}
	}
}
