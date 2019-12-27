package projet;

import java.util.List;

public class Joueur {
	private int score;
	private String nom;
	private Plancher plancher;
	private Motif[] motifs;
	public LigneMur[] mur;

	public Joueur(String nom) {
		this.nom=nom;
		this.score=0;
		this.mur=new LigneMur[5];
		this.plancher=new Plancher();
		this.motifs=new Motif[5];
		for(int i=0;i<5;i++) {
			this.motifs[i]=new Motif(i+1);
			this.mur[i]=new LigneMur();
		}
	}
	public boolean check() {
		boolean b=true;
		for(LigneMur m:mur)
			b=b && !m.estPleine();
		return b;
	}
	public void remplirLigne(int ligne  ,List<Tuile> l) {
		for(Tuile t:l) {
			if(t instanceof TuilePremier) this.plancher.put(t);
			
			else if(!this.motifs[ligne].put(t)) this.plancher.put(t);
			
		}
	}
	public void remplirPlancher(List<Tuile> l ,Defausse defausse) {
		this.plancher.putAll(l, defausse);
	}
	public String getNom() {
		return this.nom;
	}
	
	public boolean checkWall(int i,String color) {
		return mur[i].containsTuile(color);
	}
	public String toString() {
		String s="PLATEAU DE "+ this.nom.toUpperCase()+"  avec un score de "+this.score+
				"\n-------MOTIFS-------\n";
		for(Motif m:motifs)
			s+=m+"\n";
		s+=" -------MUR-------\n";
		for(LigneMur lm:mur)
			s+=lm+"\n";
		s+="------plancher--------\n";
		s+=plancher+"\n";
		return s;
		
	}
	public void decorer(Defausse defausse) {
		for(int i=0;i<5;i++) {
			if (motifs[i].remplirMur(mur[i], defausse)) {
				this.score++;	
			}
		}
	}
	public void calculerScore() {
		calculerVAdja();calculerHAdja();calculerOcc();
		System.out.println("joueur "+ this.nom +" ,SCORE : "+this.score);
	}
	public void calculerVAdja() {
		for(int colonne=0;colonne<5;colonne++)
			for(int ligne=0;ligne<4;ligne++)
				if(colonne<mur[ligne].liste.size() && colonne<mur[ligne+1].liste.size() ) this.score+=2;
	}
	public void calculerHAdja() {
		for(int ligne=0;ligne<5;ligne++)
			 this.score+=2*this.mur[ligne].liste.size();
	}
	public void calculerOcc() {
		int n=0,scoreAdd=0;
		String[] couleurs= {"bleue","jaune","rouge","noir","blanche"};
		for(String couleur:couleurs) {
			for(LigneMur lm:mur) 
				if (lm.containsTuile(couleur)) n++;
			if(n==5) scoreAdd+=10;
		}
		this.score+=scoreAdd;
	}
}
