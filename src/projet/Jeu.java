package projet;

import java.util.Scanner;

public class Jeu {
	private Joueur[] joueurs;
	private Defausse defausse;
	private Fabrique[] fabriques;
	private Sac sac;
	private Centre centre;
	private Tuile pj;
	private int p=-1;
	private Scanner sc=new Scanner(System.in);
	public Jeu(int nb) {
		this.centre=new Centre();
		this.joueurs=new Joueur[nb];
		this.fabriques=new Fabrique[nb];
		this.defausse=new Defausse();
		this.pj=new TuilePremier();
		this.sac=new Sac();
		for(int i=0;i<nb;i++) {
			fabriques[i]=new Fabrique();
			System.out.println("entrez le nom du joueur "+(i+1) +" : ");
			joueurs[i]=new Joueur(sc.next());
			
		}
		System.out.println("la partie va commencer\n\n");
		preparation();
	}
	public void afficherPlateau() {
		for(Joueur j:joueurs)
			System.out.print(j);
	}
	public boolean checkColorCorrect(String scanned,int i) {
		String[] colors= {"noir","blanche","blanc","rouge","noire","bleu","bleue","jaune"};
		for(String s:colors)
			if (s.equals(scanned)&& fabriques[i].containsTuile(scanned)) return true;
		return false;
	}
	public boolean checkGame() {
		boolean b=true;
		for(Joueur j:joueurs) {
			b=b&& j.check();
		}
		return b;
	}
	public boolean fabriquesEmpty() {
		boolean b=true;
		for(Fabrique f:fabriques)
			b=b&&f.isEmpty();
		return b;
	}
	public void preparation() {
		System.out.println("phase de preparation");
		if(sacAndDefausseEmpty()) return;
		defausse.remplirSac(sac);
		centre.put(pj);
		for(Fabrique f:fabriques)
			f.remplir(sac);
		offre();
	}
	public boolean sacAndDefausseEmpty() {
		return sac.isEmpty()&& defausse.isEmpty();
	}
	public Boolean fabriqueCentreEmpty() {
		
		return fabriquesEmpty() && centre.isEmpty();
	}
	public void offre() {
		System.out.println("phase d'offre");
		if(p==-1)
			p=(int)Math.random()%joueurs.length;
		
		while(!fabriqueCentreEmpty()) {
			for(int i=p;i<joueurs.length;i++) {
				for(int j=0;j<fabriques.length;j++) {
					if(!fabriques[j].isEmpty())
						System.out.println("la fabrique "+(j+1)+" contient "+fabriques[j].toString());
				}
				if(!centre.isEmpty())
					System.out.println("le centre contient "+ centre.toString());
				afficherPlateau();
				System.out.println(("au tour de "+joueurs[i].getNom()+" ").toUpperCase());
				System.out.println("fabrique ou centre?(fabrique/centre)");
				if(sc.next().equals("fabrique") || centre.isEmpty()) {
					System.out.println("quelle fabrique ?");
					int f=sc.nextInt()-1;
					while(fabriques[f].isEmpty() ||( f>fabriques.length &&f<1)) {
						System.out.println("erreur choissiez une fabrique");
						f=sc.nextInt()-1;
					}
					System.out.println(("la fabrique "+(f+1)+" contient "+fabriques[f].toString()).toUpperCase());
					System.out.println("quelle couleur de tuile ?");
					String color=sc.next();
					while(!checkColorCorrect(color,f)) {
						System.out.println("erreur rechoisissez une couleur");
						color=sc.next();
					}
					System.out.println("les mettre dans le plancher ?(oui/non)");
					if(sc.next().equals("non")) {
						System.out.println("dans quelle ligne les mettre");
						int l=sc.nextInt()-1;
						while(joueurs[i].checkWall(l, color)) {
							System.out.println("mur contient deja cette couleur choisissez une autre ligne");
							l=sc.nextInt()-1;
						}
						joueurs[i].remplirLigne(l, fabriques[f].recupererTuiles(color, this.centre));
					}
					else
						joueurs[i].remplirPlancher(fabriques[f].recupererTuiles(color,this.centre), this.defausse);
				}
				else {
					System.out.println(("le centre contient "+ centre.toString()).toUpperCase());
					System.out.println("quelle couleur de tuile ?");
					String color=sc.next();
					if(centre.ContientPremier()) p=i;
					System.out.println("les mettre dans le plancher ?(oui/non) ");
					if(sc.next().equals("non")) {
						System.out.println("dans quelle ligne les mettre");
						int l=sc.nextInt()-1;
						while(joueurs[i].checkWall(l, color)) {
							System.out.println("mur contient deja cette couleur choisissez une autre ligne");
							l=sc.nextInt();
						}
						joueurs[i].remplirLigne(l, this.centre.recupererTuiles(color, this.centre));
					}
					else
						joueurs[i].remplirPlancher(this.centre.recupererTuiles(color,this.centre), this.defausse);
				}
				System.out.println("\n\n");
				if(i==joueurs.length-1) i=0;
			}
		}
		decoration();
	}
	public void decoration() {
		System.out.println("phase de decoration");
		for(Joueur j:joueurs) {
			j.decorer(defausse);
			System.out.println(j);
		}
		if(!checkGame()) {
			for(Joueur j:joueurs)
				j.calculerScore();
			System.out.println("fin de la partie");
		}
		else {
			System.out.println("nouvelle manche");
			preparation();
		}
	}
	
	

}
