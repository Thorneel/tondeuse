package exercice.xebia.tondeuse.domaine;

import java.util.ArrayList;

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
		Tondeuse tondeuse_a_avancer;
		for (int i = 0; i < liste_des_tondeuses_sur_cette_pelouse.size(); i++) {

			tondeuse_a_avancer = liste_des_tondeuses_sur_cette_pelouse.get(i);
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
		// TODO Auto-generated method stub
		ArrayList<String> tableau_position_des_tondeuses = new ArrayList<String>();

		Tondeuse tondeuse_dont_il_faut_la_position;
		String position;
		int longitude;
		int latitude;
		char orientation;
		System.out.println("getTableauPositionsDesTondeuses en cours d'execution");
		for (int i = 0; i < liste_des_tondeuses_sur_cette_pelouse.size(); i++) {

			tondeuse_dont_il_faut_la_position = liste_des_tondeuses_sur_cette_pelouse.get(i);
			
			longitude = tondeuse_dont_il_faut_la_position.getLongitude();
			latitude = tondeuse_dont_il_faut_la_position.getLatitude();
			orientation = tondeuse_dont_il_faut_la_position.getOrientation();

			position = longitude + " " + latitude + " " + orientation;
			System.out.println(position);
			
			tableau_position_des_tondeuses.add(position);

		}

		String[] string_de_reference_pour_retourner_un_tableau_de_string_plutot_qu_un_tableau_d_objet = {};
		return tableau_position_des_tondeuses.toArray(string_de_reference_pour_retourner_un_tableau_de_string_plutot_qu_un_tableau_d_objet);
	}

}
