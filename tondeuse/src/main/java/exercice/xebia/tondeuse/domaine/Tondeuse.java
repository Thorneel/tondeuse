package exercice.xebia.tondeuse.domaine;

import java.util.LinkedList;

public class Tondeuse {

	final private TailleDePelouse tailleDePelouse;
	
	private int longitude;
	private int latitude;
	private char orientation;
	private String listeDesMouvements;
	private int indexDuProchainMouvement;
	
	public Tondeuse(int longitude, int latitude, char direction, TailleDePelouse tailleDePelouse, String listeDesMouvements) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.orientation = direction;
		this.tailleDePelouse = tailleDePelouse;
		this.listeDesMouvements = listeDesMouvements;
		this.indexDuProchainMouvement = 0;
		
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
	
	
	public void avancer() {
		
		switch (orientation) {
		case 'N':
			if (latitude < tailleDePelouse.getTailleNordSudY()) { 
				latitude++;
			}
			break;
		case 'S':
			if (latitude > 0) {
				latitude--;
			}
			break;
		case 'E':
			if (longitude < tailleDePelouse.getTailleEstOuestX()) { 
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

		if (indexDuProchainMouvement < listeDesMouvements.length()) {
			
			switch (listeDesMouvements.charAt(indexDuProchainMouvement)) {
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
			indexDuProchainMouvement++;
			
		}
		
	}

}
