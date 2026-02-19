package testsFonctionnels;

import cartes.JeuDeCartes;

public class TestJeuDeCartes {
	
	public static void main(String[] args) {
        new TestJeuDeCartes(); 
    }

	public TestJeuDeCartes() {
		JeuDeCartes jeu = new JeuDeCartes();
		System.out.println(jeu.affichageJeuDeCartes());
	}

}
