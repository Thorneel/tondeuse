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

import exercice.xebia.tondeuse.domaine.Pelouse;
import exercice.xebia.tondeuse.domaine.TailleDePelouse;
import exercice.xebia.tondeuse.infrastructure.LecteurDeFichier;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class LectureDuFichierDeCommandesTest {

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	private String remplirFichierTemporaire(String[] tableau_de_contenu_du_fichier_d_entree) throws IOException {

		String contenu_du_fichier_d_entree = "";
		for (int i = 0; i < tableau_de_contenu_du_fichier_d_entree.length; i++) {
			contenu_du_fichier_d_entree += tableau_de_contenu_du_fichier_d_entree[i];
			if (i < tableau_de_contenu_du_fichier_d_entree.length - 1) {
				contenu_du_fichier_d_entree += System.lineSeparator();
			}
		}
		final File fichier_de_commandes_temporaire = tempFolder.newFile("fichier_de_commandes.txt");
		BufferedWriter buffered_writer = new BufferedWriter(new FileWriter(fichier_de_commandes_temporaire));
		buffered_writer.write(contenu_du_fichier_d_entree);
		buffered_writer.close();
		return fichier_de_commandes_temporaire.getAbsolutePath();

	}

	@Test
	@Parameters({ "5 5, 1 2 N, GAGAGAGAA, 3 3 E, AADAADADDA" })
	public void DevraitRecevoirDansLeLecteurDeFichierLeContenuDuFichier(
			String[] tableau_de_contenu_du_fichier_d_entree) throws IOException {

		String chemin_absolu = remplirFichierTemporaire(tableau_de_contenu_du_fichier_d_entree);

		LecteurDeFichier lecteur_de_fichier = new LecteurDeFichier(chemin_absolu);
		assertArrayEquals(tableau_de_contenu_du_fichier_d_entree, lecteur_de_fichier.getTableauDesLignesDuFichier());
	}

	public Object parametresDeFichierDEntreeEtResultatsAttendusPourLireLeFichierCreerPelouseEtTondeusesEtEffectuerLesDeplacements() {

		String[] tableau_de_contenu_du_fichier_d_entree = { "5 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA" };
		int taille_est_ouest_x_attendue = 5;
		int taille_nord_sud_y_attendue = 5;
		String[] tableau_positions_des_tondeuses_attendues = { "1 3 N", "5 1 E" };

		return new Object[][] { { tableau_de_contenu_du_fichier_d_entree, taille_est_ouest_x_attendue,
				taille_nord_sud_y_attendue, tableau_positions_des_tondeuses_attendues } };
	}

	@Test
	@Parameters(method = "parametresDeFichierDEntreeEtResultatsAttendusPourLireLeFichierCreerPelouseEtTondeusesEtEffectuerLesDeplacements")
	public void devraitLireLeFichierCreerPelouseEtTondeusesEtEffectuerLesDeplacements(
			String[] tableau_de_contenu_du_fichier_d_entree, int taille_est_ouest_x_attendue,
			int taille_nord_sud_y_attendue, String[] tableau_positions_des_tondeuses_attendues) throws IOException {

		String chemin_absolu = remplirFichierTemporaire(tableau_de_contenu_du_fichier_d_entree);

		LecteurDeFichier lecteur_de_fichier = new LecteurDeFichier(chemin_absolu);
		Pelouse pelouse = lecteur_de_fichier.getPelouse();
		TailleDePelouse tailleDePelouse = pelouse.getTailleDePelouse();
		assertEquals(taille_est_ouest_x_attendue, tailleDePelouse.getTailleEstOuestX());
		assertEquals(taille_nord_sud_y_attendue, tailleDePelouse.getTailleNordSudY());

		lecteur_de_fichier.effectuerTousLesMouvementsDesTondeusesDeLaPelouse();

		String[] tableau_positions_des_tondeuses = lecteur_de_fichier.getTableauPositionsDesTondeusesDeLaPelouse();
		assertArrayEquals(tableau_positions_des_tondeuses_attendues, tableau_positions_des_tondeuses);
	}

}
