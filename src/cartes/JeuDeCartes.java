package cartes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JeuDeCartes {
	
	private Configuration[] typesDeCartes = {
		new Configuration(new Borne(25), 10),
		new Configuration(new Borne(50), 10),
		new Configuration(new Borne(75), 10),
		new Configuration(new Borne(100), 12),
		new Configuration(new Borne(200), 4),
		new Configuration(new Parade(Type.FEU), 14),
		new Configuration(new FinLimite(), 6),
		new Configuration(new Parade(Type.ESSENCE), 6),
		new Configuration(new Parade(Type.CREVAISON), 6),
		new Configuration(new Parade(Type.ACCIDENT), 6),
		new Configuration(new Attaque(Type.FEU), 5),
		new Configuration(new Attaque(Type.ESSENCE), 3),
		new Configuration(new Attaque(Type.CREVAISON), 3),
		new Configuration(new Attaque(Type.ACCIDENT), 3),
		new Configuration(new Botte(Type.FEU), 1),
		new Configuration(new Botte(Type.ESSENCE), 1),
		new Configuration(new Botte(Type.CREVAISON), 1),
		new Configuration(new Botte(Type.ACCIDENT), 1),
	};
	
	public Carte[] donnerCartes(){
		int nbCartes = 0;
		for(Configuration configuration : typesDeCartes) {
			nbCartes += configuration.nbExemplaires;
		}
		Carte[] cartes = new Carte[nbCartes];
		int index = 0;
		for(Configuration configuration : typesDeCartes) {
			for(int i = 0; i < configuration.nbExemplaires; i++) {
				cartes[index] = configuration.getCarte();
				index++;
			}
		}
		return cartes;
	}
	
	public boolean checkCount() {
	    Carte[] tableauPaquet = donnerCartes();
	    List<Carte> paquet = new ArrayList<>();
	    Collections.addAll(paquet, tableauPaquet); 
	    
	    for (Configuration config : typesDeCartes) {
	        int compteur = 0;
	        
	        for (Carte carteDuPaquet : paquet) {
	            if (carteDuPaquet.equals(config.getCarte())) {
	                compteur++;
	            }
	        }
	        
	        if (compteur != config.getNbExemplaires()) {
	            return false;
	        }
	    }
	    return true; 
	}

	public String affichageJeuDeCartes(){
		StringBuilder sb = new StringBuilder();
		for(Configuration c : typesDeCartes) {
			sb.append(c.getNbExemplaires());
			sb.append(" ");
			sb.append(c.getCarte().toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	private class Configuration {
		private Carte carte;
		private int nbExemplaires;
		
		private Configuration(Carte carte, int nbExemplaires) {
			this.carte = carte;
			this.nbExemplaires = nbExemplaires;
		}
		
		private Carte getCarte() {
			return this.carte;
		}

		private int getNbExemplaires() {
			return nbExemplaires;
		}
		
	}

}
