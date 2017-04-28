package exercice.xebia.tondeuse.domaine;

import java.util.ArrayList;

import exercice.xebia.tondeuse.ValeursDesCaracteresDeCommande;

public class Pelouse {

	final private TailleDePelouse taille_de_pelouse;

	private ArrayList<Tondeuse> liste_des_tondeuses_sur_cette_pelouse = new ArrayList<Tondeuse>();
	private int nombre_de_mouvements_restants = 0;

	public Pelouse(int taille_est_ouest_x, int taille_nord_sud_y) {
		this.taille_de_pelouse = new TailleDePelouse(taille_est_ouest_x, taille_nord_sud_y);
	}

	public TailleDePelouse getTailleDePelouse() {
		return taille_de_pelouse;
	}

	public Tondeuse ajouterTondeuse(int longitude, int latitude, char orientation, String liste_des_mouvements) {
		Tondeuse tondeuse = new Tondeuse(longitude, latitude, orientation, this.taille_de_pelouse, liste_des_mouvements);
		liste_des_tondeuses_sur_cette_pelouse.add(tondeuse);

		int nombre_de_mouvements_pour_cette_tondeuse = liste_des_mouvements.length();
		nombre_de_mouvements_restants = Math.max(nombre_de_mouvements_restants,
				nombre_de_mouvements_pour_cette_tondeuse);

		return tondeuse;
	}

	public void executerMouvementSuivantPourChaqueTondeuse() {
		for (Tondeuse tondeuse_a_avancer : liste_des_tondeuses_sur_cette_pelouse) {
			tondeuse_a_avancer.executerMouvementSuivant();
			nombre_de_mouvements_restants--;
		}
	}

	public void executerTousLesMouvementsRestantsDesTondeuses() {
		for (int i = nombre_de_mouvements_restants; i > 0; i--) {
			executerMouvementSuivantPourChaqueTondeuse();
		}

	}

	public String[] getTableauPositionsDesTondeuses() {
		ArrayList<String> tableau_position_des_tondeuses = new ArrayList<String>();
		String position;
		int longitude;
		int latitude;
		char orientation;
		
		for (Tondeuse tondeuse_dont_il_faut_la_position: liste_des_tondeuses_sur_cette_pelouse) {
			
			longitude = tondeuse_dont_il_faut_la_position.getLongitude();
			latitude = tondeuse_dont_il_faut_la_position.getLatitude();
			orientation = tondeuse_dont_il_faut_la_position.getOrientation();

			position = longitude + " " + latitude + " " + orientation;
			System.out.println(position);
			
			tableau_position_des_tondeuses.add(position);

		}
		
		return tableau_position_des_tondeuses.toArray(
				ValeursDesCaracteresDeCommande.STRING_DE_REFERENCE_POUR_RETOURNER_UN_TABLEAU_DE_STRING_PLUTOT_QU_UN_TABLEAU_D_OBJECT);
	}

}
