package exercice.xebia.tondeuse.domaine;

import exercice.xebia.tondeuse.ValeursDesCaracteresDeCommande;

public class Tondeuse {

	final private TailleDePelouse taille_de_pelouse;

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
		this.taille_de_pelouse = TailleDePelouse;
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
		return "Tondeuse [taille_de_pelouse=" + taille_de_pelouse + ", longitude=" + longitude + ", latitude=" + latitude
				+ ", orientation=" + orientation + ", liste_des_mouvements=" + liste_des_mouvements
				+ ", index_du_prochain_mouvement=" + index_du_prochain_mouvement + "]";
	}
	

	public void avancer() {

		switch (orientation) {
		case ValeursDesCaracteresDeCommande.NORD:
			if (latitude < taille_de_pelouse.getTailleNordSudY()) {
				latitude++;
			}
			break;
		case ValeursDesCaracteresDeCommande.SUD:
			if (latitude > 0) {
				latitude--;
			}
			break;
		case ValeursDesCaracteresDeCommande.EST:
			if (longitude < taille_de_pelouse.getTailleEstOuestX()) {
				longitude++;
			}
			break;
		case ValeursDesCaracteresDeCommande.OUEST:
			if (longitude > 0) {
				longitude--;
			}
			break;
		default:

		}
	}

	public void tournerVersLaDroite() {

		switch (orientation) {
		case ValeursDesCaracteresDeCommande.NORD:
			orientation = ValeursDesCaracteresDeCommande.EST;
			break;
		case ValeursDesCaracteresDeCommande.SUD:
			orientation = ValeursDesCaracteresDeCommande.OUEST;
			break;
		case ValeursDesCaracteresDeCommande.EST:
			orientation = ValeursDesCaracteresDeCommande.SUD;
			break;
		case ValeursDesCaracteresDeCommande.OUEST:
			orientation = ValeursDesCaracteresDeCommande.NORD;
			break;
		default:

		}
	}

	public void tournerVersLaGauche() {

		switch (orientation) {
		case ValeursDesCaracteresDeCommande.NORD:
			orientation = ValeursDesCaracteresDeCommande.OUEST;
			break;
		case ValeursDesCaracteresDeCommande.SUD:
			orientation = ValeursDesCaracteresDeCommande.EST;
			break;
		case ValeursDesCaracteresDeCommande.EST:
			orientation = ValeursDesCaracteresDeCommande.NORD;
			break;
		case ValeursDesCaracteresDeCommande.OUEST:
			orientation = ValeursDesCaracteresDeCommande.SUD;
			break;
		default:

		}
	}

	public void executerMouvementSuivant() {

		if (index_du_prochain_mouvement < liste_des_mouvements.length()) {

			switch (liste_des_mouvements.charAt(index_du_prochain_mouvement)) {
			case ValeursDesCaracteresDeCommande.AVANT:
				this.avancer();
				break;
			case ValeursDesCaracteresDeCommande.DROITE:
				this.tournerVersLaDroite();
				break;
			case ValeursDesCaracteresDeCommande.GAUCHE:
				this.tournerVersLaGauche();
				break;
			default:

			}
			index_du_prochain_mouvement++;

		}

	}

}
