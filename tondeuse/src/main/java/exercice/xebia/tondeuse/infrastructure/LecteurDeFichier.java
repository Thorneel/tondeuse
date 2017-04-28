package exercice.xebia.tondeuse.infrastructure;

import java.io.BufferedReader;
import java.util.ArrayList;

import java.io.FileReader;
import java.io.IOException;

public class LecteurDeFichier {

	public ArrayList<String> tableau_des_lignes_du_fichier = new ArrayList<String>();

	public LecteurDeFichier(String absolutePath) throws IOException {
		
		BufferedReader buffered_reader = new BufferedReader(new FileReader(absolutePath));
		
		String nouvelle_ligne = new String();
		while(buffered_reader.ready()){
			nouvelle_ligne = buffered_reader.readLine();
			tableau_des_lignes_du_fichier.add(nouvelle_ligne);
		}
		buffered_reader.close();
		
	}

	public String[] getTableauDesLignesDuFichier() {
		String[] string_de_reference_pour_retourner_un_tableau_de_string_plutot_qu_un_tableau_d_objet = {};
		return tableau_des_lignes_du_fichier.toArray(string_de_reference_pour_retourner_un_tableau_de_string_plutot_qu_un_tableau_d_objet);
	}

}
