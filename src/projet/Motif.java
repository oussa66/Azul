package projet;

public class Motif extends ZonePrv {

	
	public Motif(int taille) {
		super(taille);
		
	}
	public int taille() {
		return this.taille;
	}
	public boolean  put(Tuile t) { //place une tuile dans la ligne motif
		if (liste.size()<taille) {
			if(isEmpty() || liste.get(0).getClass()==t.getClass()&& !(t instanceof TuilePremier)) {
				 // verifie si la ligne vide ou contient une tuile de la meme couleur
				super.put(t);
				System.out.println("la liste est : "+liste.toString() +" et "+super.liste.toString()+" de taille"+super.liste.size());
				return true;
			}
			else {
				System.out.println("pas la meme couleur");
				return false;
			}
		}	
			System.out.println("ligne deja pleine "+liste.size()+" : taille : "+taille);
			return false;
	}
	public boolean remplirMur(LigneMur lm,Defausse defausse) {
		if (this.estPleine()) { //on remplit la ligne de mur correspendante avec une tuille
			lm.put(this.get()); //et on defausse les tuiles restantes
			while(!this.isEmpty())
				defausse.put(this.get());
			return true;
		}
		return false;
	}
	
	
}
