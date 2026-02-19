package testsFonctionnels;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Botte;
import cartes.Carte;
import cartes.JeuDeCartes;
import cartes.Type;
import jeu.Sabot;

public class TestSabot {
	
	public static void main(String[] args) {
		new TestSabot();
	}

	public TestSabot() {
		JeuDeCartes jeu = new JeuDeCartes();
		Sabot sabot = new Sabot(jeu.donnerCartes());
		
		// a)
//		try {
//			while(!sabot.estVide()) {
//				StringBuilder sb = new StringBuilder("je pioche ");
//				sb.append(sabot.piocher().toString());
//				System.out.println(sb.toString());
//			}	
//		} catch(IllegalStateException | ConcurrentModificationException | NoSuchElementException e) {
//			System.out.println(e);
//		}
//		
		
		// b)
		Iterator<Carte> iterateur = sabot.iterator();
		
		try {
			// c) (doit lever une exception)
//			sabot.piocher();
			while(!sabot.estVide()) {
				StringBuilder sb = new StringBuilder("je pioche ");
				sb.append(iterateur.next().toString());
				iterateur.remove();
				System.out.println(sb.toString());
				
				// c) (doit lever une exception)
//				sabot.piocher();
				
				// c) (doit lever une exception)
				sabot.ajouterCarte(new Botte(Type.ACCIDENT));
			}
		} catch(IllegalStateException | ConcurrentModificationException | NoSuchElementException e) {
			System.out.println(e);
		}
	}

}
