package exercice.xebia.tondeuse.domaine;

public class Tondeuse {

	final private TailleDePelouse tailleDePelouse;
	
	private int longitude;
	private int latitude;
	private char orientation;
	
	public Tondeuse(int longitude, int latitude, char direction, TailleDePelouse tailleDePelouse) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.orientation = direction;
		this.tailleDePelouse = tailleDePelouse;
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

}
