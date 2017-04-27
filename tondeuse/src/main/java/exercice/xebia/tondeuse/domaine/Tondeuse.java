package exercice.xebia.tondeuse.domaine;

import java.util.LinkedList;

public class Tondeuse {

	final private TailleDePelouse TailleDePelouse;

	private int longitude;
	private int latitude;
	private char orientation;
	private String liste_des_mouvements;
	private int index_du_prochain_mouvement;

	public Tondeuse(int longitude, int latitude, char direction, TailleDePelouse TailleDePelouse,
			String liste_des_mouvements) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.orientation = direction;
		this.TailleDePelouse = TailleDePelouse;
		this.liste_des_mouvements = liste_des_mouvements;
		this.index_du_prochain_mouvement = 0;

	}

	public int getLongitude() {
		return longitude;
	}

	public int getLatitude() {
		return latitude;
	}

	public char getOrientation() {
		return orientation;
	}
	
	
	@Override
	public String toString() {
		return "Tondeuse [TailleDePelouse=" + TailleDePelouse + ", longitude=" + longitude + ", latitude=" + latitude
				+ ", orientation=" + orientation + ", liste_des_mouvements=" + liste_des_mouvements
				+ ", index_du_prochain_mouvement=" + index_du_prochain_mouvement + "]";
	}
	

	public void avancer() {

		switch (orientation) {
		case 'N':
			if (latitude < TailleDePelouse.gettaille_nord_sud_y()) {
				latitude++;
			}
			break;
		case 'S':
			if (latitude > 0) {
				latitude--;
			}
			break;
		case 'E':
			if (longitude < TailleDePelouse.gettaille_est_ouest_x()) {
				longitude++;
			}
			break;
		case 'W':
			if (longitude > 0) {
				longitude--;
			}
			break;
		default:

		}
	}

	public void tournerVersLaDroite() {

		switch (orientation) {
		case 'N':
			orientation = 'E';
			break;
		case 'S':
			orientation = 'W';
			break;
		case 'E':
			orientation = 'S';
			break;
		case 'W':
			orientation = 'N';
			break;
		default:

		}
	}

	public void tournerVersLaGauche() {

		switch (orientation) {
		case 'N':
			orientation = 'W';
			break;
		case 'S':
			orientation = 'E';
			break;
		case 'E':
			orientation = 'N';
			break;
		case 'W':
			orientation = 'S';
			break;
		default:

		}
	}

	public void executerMouvementSuivant() {

		if (index_du_prochain_mouvement < liste_des_mouvements.length()) {

			switch (liste_des_mouvements.charAt(index_du_prochain_mouvement)) {
			case 'A':
				this.avancer();
				break;
			case 'D':
				this.tournerVersLaDroite();
				break;
			case 'G':
				this.tournerVersLaGauche();
				break;
			default:

			}
			index_du_prochain_mouvement++;

		}

	}

}
