package jeu;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jeu {
    
    private Sabot sabot; 

    public Jeu() {
        JeuDeCartes jeuDeCartes = new JeuDeCartes();
        Carte[] tableauCartes = jeuDeCartes.donnerCartes();
        
        List<Carte> listeCartes = new ArrayList<>();
        
        Collections.addAll(listeCartes, tableauCartes); 
        
        listeCartes = GestionCartes.melanger(listeCartes); 
        
        this.sabot = new Sabot(listeCartes.toArray(new Carte[0])); 
    }
    
    public Sabot getSabot() {
        return sabot;
    }
}