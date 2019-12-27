package projet;

import java.util.Scanner;

public class Launcher {
	public static void launch() {
		Scanner sc=new Scanner(System.in);
		System.out.println("bienvenue, combien de joueurs?");
		new Jeu(sc.nextInt());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}

}
