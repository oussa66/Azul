package projet;

import java.util.Collections;
import java.util.List;

public class Sac extends ZoneJh{
	
	public Sac() {
		super();
		for(int i=0;i<100;i++) { // on place 100 tuiles dans le sac 
			if(i>79)
				liste.add(new TuileBleue());
			else if(i>59) 
				liste.add(new TuileRouge());
			else if(i>39)
				liste.add(new TuileNoir());
			else if(i>19)
				liste.add(new TuileBlanche());
			else
				liste.add(new TuileJaune());
			}
		Collections.shuffle(liste); //on melange les tuiles
		}
	
	

}
