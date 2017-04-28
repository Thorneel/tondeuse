package exercice.xebia.tondeuse;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

import exercice.xebia.tondeuse.infrastructure.LecteurDeFichier;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class LectureDuFichierDeCommandesTest {
	
	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	@Test
	@Parameters({"5 5, 1 2 N, GAGAGAGAA, 3 3 E, AADAADADDA"})
	public void DevraitCreerPelouseEtTondeusesDApresLeContenuDuFichierDeCommandes(String[] tableau_de_contenu_du_fichier_d_entree) throws IOException {
		
		String contenu_du_fichier_d_entree = "";
		for (int i = 0; i < tableau_de_contenu_du_fichier_d_entree.length; i++){
			
			contenu_du_fichier_d_entree += tableau_de_contenu_du_fichier_d_entree[i];
			
			if (i < tableau_de_contenu_du_fichier_d_entree.length - 1) {
				contenu_du_fichier_d_entree += System.lineSeparator();
			}
			
		}
		
		final File fichier_de_commandes_temporaire = tempFolder.newFile("fichier_de_commandes.txt");
		BufferedWriter buffered_writer = new BufferedWriter(new FileWriter(fichier_de_commandes_temporaire));
		buffered_writer.write(contenu_du_fichier_d_entree);
		buffered_writer.close();
		
		LecteurDeFichier lecteurDeFichier = new LecteurDeFichier(fichier_de_commandes_temporaire.getAbsolutePath());
		assertArrayEquals(tableau_de_contenu_du_fichier_d_entree, lecteurDeFichier.getTableauDesLignesDuFichier());
	}

}
