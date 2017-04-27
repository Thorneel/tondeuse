package exercice.xebia.tondeuse.domaine;

public class Tondeuse {

	private int longitude;
	private int latitude;
	private char direction;
	
	public Tondeuse(int longitude, int latitude, char direction) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.direction = direction;
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

}
