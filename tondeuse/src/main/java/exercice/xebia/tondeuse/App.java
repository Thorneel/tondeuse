package exercice.xebia.tondeuse;

import java.io.File;
import java.io.IOException;

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
        System.out.println(fichier_de_commande.getAbsolutePath());
    	LecteurDeFichier lecteurDeFichier = new LecteurDeFichier(fichier_de_commande.getAbsolutePath());
    }

    // TODO enlever cette méthode qui était là seulement que ça fonctionne
	public int addOne(int i) {
		return i + 1;
	}
	
}
