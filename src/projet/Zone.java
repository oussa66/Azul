package projet;

import java.util.ArrayList;
import java.util.List;

public class Zone { // la classe mere de toutes les zones

	protected List<Tuile> liste; // contient une liste de tuiles  
	public Zone() {
		this.liste=new ArrayList<Tuile>();
	}
	public Tuile get() {
		return liste.remove((int)Math.random()%liste.size()); // on recupere une tuile au hasard et on l'enleve de la liste
	}
	public boolean put(Tuile tuile) {// on ajoute une tuile a la zone
		liste.add(tuile);
		return true;
	}
	public boolean isEmpty() { // verifie si c'est vide 
		return liste.isEmpty();
	}
	public String toString() { // affiche toutes les tuiles presentes 
		
		return liste.toString();
	}
	public boolean containsTuile(String color) {
		for(Tuile t:liste)
			if(t.toString().equals(color)) return true;
		return false;
	}
}
