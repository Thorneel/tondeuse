package exercice.xebia.tondeuse.domaine;

public class Tondeuse {

	final private TailleDePelouse tailleDePelouse;
	
	private int longitude;
	private int latitude;
	private char direction;
	
	public Tondeuse(int longitude, int latitude, char direction, TailleDePelouse tailleDePelouse) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.direction = direction;
		this.tailleDePelouse = tailleDePelouse;
	}

	public int getLongitude() {
		return longitude;
	}

	public int getLatitude() {
		return latitude;
	}

	public char getDirection() {
		return direction;
	}

	public void avancerTondeuse() {
		switch (direction) {
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

}
