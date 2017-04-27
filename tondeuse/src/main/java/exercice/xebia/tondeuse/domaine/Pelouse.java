package exercice.xebia.tondeuse.domaine;

import java.util.ArrayList;

public class Pelouse {

	final private TailleDePelouse TailleDePelouse;

	private ArrayList<Tondeuse> liste_des_tondeuses_sur_cette_pelouse = new ArrayList<Tondeuse>();
	private int nombre_de_mouvements_restants = 0;

	public Pelouse(int taille_est_ouest_x, int taille_nord_sud_y) {
		this.TailleDePelouse = new TailleDePelouse(taille_est_ouest_x, taille_nord_sud_y);
	}

	public TailleDePelouse gettaille_de_pelouse() {
		return TailleDePelouse;
	}

	public Tondeuse ajouterTondeuse(int longitude, int latitude, char direction, String liste_des_mouvements) {
		Tondeuse tondeuse = new Tondeuse(longitude, latitude, direction, this.TailleDePelouse, liste_des_mouvements);
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

}
