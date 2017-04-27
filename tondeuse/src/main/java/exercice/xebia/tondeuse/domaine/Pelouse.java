package exercice.xebia.tondeuse.domaine;

import java.util.LinkedList;

public class Pelouse {
	
	final private TailleDePelouse tailleDePelouse;
	
	private LinkedList<Tondeuse> tableauDesTondeusesSurCettePelouse = new  LinkedList<Tondeuse>();

	public Pelouse(int tailleEstOuestX, int tailleNordSudY) {
		this.tailleDePelouse = new TailleDePelouse(tailleEstOuestX, tailleNordSudY);
	}

	public TailleDePelouse getTailleDePelouse() {
		return tailleDePelouse;
	}

	public Tondeuse ajouterTondeuse(int longitude, int latitude, char direction) {
		Tondeuse tondeuse = new Tondeuse(longitude, latitude, direction, this.tailleDePelouse);
		return tondeuse;
	}

}
