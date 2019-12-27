package projet;

public class Test {

	public static void main(String[] args) {
		Joueur joueur= new Joueur("oussama");
		joueur.mur[0].put(new TuileBlanche());
		joueur.mur[0].put(new TuileBleue());
		joueur.mur[0].put(new TuileRouge());
		joueur.mur[1].put(new TuileRouge());
		joueur.mur[1].put(new TuileRouge());
		joueur.mur[2].put(new TuileRouge());
		joueur.mur[3].put(new TuileRouge());
		joueur.mur[4].put(new TuileBleue());
		joueur.mur[1].put(new TuileNoir());
		joueur.calculerScore();
		System.out.println(joueur);
		// TODO Auto-generated method stub

	}

}
