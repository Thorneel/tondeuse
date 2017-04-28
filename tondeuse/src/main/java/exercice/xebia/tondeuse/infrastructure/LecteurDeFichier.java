package exercice.xebia.tondeuse.infrastructure;

import java.io.BufferedReader;
import java.util.ArrayList;

import exercice.xebia.tondeuse.ValeursDesCaracteresDeCommande;
import exercice.xebia.tondeuse.domaine.Pelouse;

import java.io.FileReader;
import java.io.IOException;

public class LecteurDeFichier {

	private ArrayList<String> tableau_des_lignes_du_fichier = new ArrayList<String>();
	private Pelouse pelouse;

	public LecteurDeFichier(String absolutePath) throws IOException {

		BufferedReader buffered_reader = new BufferedReader(new FileReader(absolutePath));

		String nouvelle_ligne = new String();

		nouvelle_ligne = buffered_reader.readLine();
		String[] tableau_taille = nouvelle_ligne.split(" ");
		int taille_est_ouest_x = Integer.parseInt(tableau_taille[0]);
		int taille_nord_sud_y = Integer.parseInt(tableau_taille[1]);
		pelouse = new Pelouse(taille_est_ouest_x, taille_nord_sud_y);

		tableau_des_lignes_du_fichier.add(nouvelle_ligne);

		String[] tableau_position_de_depart;
		int longitude;
		int latitude;
		char orientation;
		String liste_des_mouvements;

		while (buffered_reader.ready()) {
			nouvelle_ligne = buffered_reader.readLine();
			tableau_des_lignes_du_fichier.add(nouvelle_ligne);
			tableau_position_de_depart = nouvelle_ligne.split(" ");

			longitude = Integer.valueOf(tableau_position_de_depart[0]);
			latitude = Integer.valueOf(tableau_position_de_depart[1]);
			orientation = tableau_position_de_depart[2].charAt(0);

			liste_des_mouvements = buffered_reader.readLine();
			tableau_des_lignes_du_fichier.add(liste_des_mouvements);

			pelouse.ajouterTondeuse(longitude, latitude, orientation, liste_des_mouvements);
		}
		buffered_reader.close();

	}

	public String[] getTableauDesLignesDuFichier() {
		return tableau_des_lignes_du_fichier.toArray(
				ValeursDesCaracteresDeCommande.STRING_DE_REFERENCE_POUR_RETOURNER_UN_TABLEAU_DE_STRING_PLUTOT_QU_UN_TABLEAU_D_OBJECT);
	}

	 public String[] getTableauPositionsDesTondeusesDeLaPelouse() {
		 return pelouse.getTableauPositionsDesTondeuses();
	 }

	public Pelouse getPelouse() {
		return pelouse;
	}

	public void effectuerTousLesMouvementsDesTondeusesDeLaPelouse() {
		pelouse.executerTousLesMouvementsRestantsDesTondeuses();
	}

}
