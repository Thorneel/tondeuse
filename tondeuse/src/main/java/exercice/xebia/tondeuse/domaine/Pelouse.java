package exercice.xebia.tondeuse.domaine;

import java.util.ArrayList;

public class Pelouse {

	final private TailleDePelouse TailleDePelouse;

	private ArrayList<Tondeuse> liste_des_tondeuses_sur_cette_pelouse = new ArrayList<Tondeuse>();

	public Pelouse(int taille_est_ouest_x, int taille_nord_sud_y) {
		this.TailleDePelouse = new TailleDePelouse(taille_est_ouest_x, taille_nord_sud_y);
	}

	public TailleDePelouse gettaille_de_pelouse() {
		return TailleDePelouse;
	}

	public Tondeuse ajouterTondeuse(int longitude, int latitude, char direction, String liste_des_mouvements) {
		Tondeuse tondeuse = new Tondeuse(longitude, latitude, direction, this.TailleDePelouse, liste_des_mouvements);
		liste_des_tondeuses_sur_cette_pelouse.add(tondeuse);
		return tondeuse;
	}

	public void executerMouvementSuivantPourChaqueTondeuse() {
		Tondeuse tondeuse_a_avancer;
		for (int i = 0; i < liste_des_tondeuses_sur_cette_pelouse.size(); i++) {

			tondeuse_a_avancer = liste_des_tondeuses_sur_cette_pelouse.get(i);
			tondeuse_a_avancer.executerMouvementSuivant();

		}
	}

}
