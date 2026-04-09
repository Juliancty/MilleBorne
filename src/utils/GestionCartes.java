package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {
	 private static Random random = new Random();
	
	private GestionCartes() {
		throw new IllegalStateException("Utility Class");
	}
	
	public static <T> T extraire(List<T> liste) {
        int indexAleatoire = random.nextInt(liste.size());
        return liste.remove(indexAleatoire);  
    }
	
	public static <T> T extraireIterator(List<T> liste) {        
        int indexAleatoire = random.nextInt(liste.size());
        
        ListIterator<T> it = liste.listIterator(indexAleatoire);
        T elementExtrait = it.next();
        it.remove();
        
        return elementExtrait;
    }
	
	public static <T> List<T> melanger(List<T> liste) {
        List<T> listeMelangee = new ArrayList<>();
        
        while (!liste.isEmpty()) {
            listeMelangee.add(extraire(liste));
        }
        
        return listeMelangee;
    }
	
	public static <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
		if(liste1.size() != liste2.size()) {
			return false;
		} else {
	        for (T element : liste1) {
	            if (Collections.frequency(liste1, element) != Collections.frequency(liste2, element)) {
	                return false;
	            }
	        }
		}
        return true;
    }
	
	public static <T> List<T> rassembler(List<T> liste) {
        List<T> listeRassemblee = new ArrayList<>();
        
        for (T element : liste) {
            if (!listeRassemblee.contains(element)) {
                int occurrences = Collections.frequency(liste, element);
                for (int i = 0; i < occurrences; i++) {
                    listeRassemblee.add(element);
                }
            }
        }
        return listeRassemblee;
    }
	
	public static <T> boolean verifierRassemblement(List<T> liste) {
        if (liste.isEmpty()) return true;

        ListIterator<T> it1 = liste.listIterator();
        T elementCourant = it1.next(); 

        while (it1.hasNext()) {
            T elementSuivant = it1.next();

            if (!elementCourant.equals(elementSuivant) && presenceDoublonPlusLoin(liste, it1.nextIndex(), elementCourant)) 
            	return false;
            
            elementCourant = elementSuivant;
        }
        
        return true;
    }

	private static <T> boolean presenceDoublonPlusLoin(List<T> liste, int indexDepart, T elementRecherche) {
        ListIterator<T> it2 = liste.listIterator(indexDepart); 
        while (it2.hasNext()) {
            if (elementRecherche.equals(it2.next())) {
                return true; 
            }
        }
        return false; 
    }

}
