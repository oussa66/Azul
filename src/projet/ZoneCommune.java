package projet;

import java.util.ArrayList;
import java.util.List;

public class ZoneCommune extends Zone {
	public ZoneCommune() {
		super();
	}
	
	public List<Tuile> recupererTuiles(String couleur,Centre centre){
		List<Tuile> l1=new ArrayList<Tuile>(),l2=new ArrayList<Tuile>();
		for(int i=0;i<liste.size();i++ ) {
			
			if (liste.get(i).toString().equals(couleur)||liste.get(i).toString().equals("premier")) {
				l1.add(liste.get(i));
				System.out.println(l1.toString());
				liste.remove(i);
				i--;
				
			}
			else {
				l2.add(liste.get(i));
				
			}
		}
		if(this instanceof Fabrique)
			while(!this.isEmpty())
				centre.put(this.get());
		return l1;
	}

}
