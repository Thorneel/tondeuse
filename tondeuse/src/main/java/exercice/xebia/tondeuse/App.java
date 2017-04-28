package exercice.xebia.tondeuse;

import java.io.File;
import java.io.IOException;

import exercice.xebia.tondeuse.infrastructure.AfficheurDeResultats;
import exercice.xebia.tondeuse.infrastructure.LecteurDeFichier;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args ) throws IOException
    {
    	File fichier_de_commande = new File("fichiersDeCommande/fichier_de_commande.txt");
    	
    	LecteurDeFichier lecteur_de_fichier = new LecteurDeFichier(fichier_de_commande.getAbsolutePath());
    	lecteur_de_fichier.effectuerTousLesMouvementsDesTondeusesDeLaPelouse();
    	String[] tableau_de_resultats = lecteur_de_fichier.getTableauPositionsDesTondeusesDeLaPelouse();
		
		AfficheurDeResultats afficheur_de_resultats = new AfficheurDeResultats(tableau_de_resultats);
		afficheur_de_resultats.afficherLesResultats();
    }
	
}
