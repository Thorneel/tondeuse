package exercice.xebia.tondeuse.domaine;

import java.util.LinkedList;

public class Pelouse {
	private int tailleEstOuest;
	private int tailleNordSud;
	private LinkedList<Tondeuse> tableauDesTondeusesSurCettePelouse = new  LinkedList<Tondeuse>();

	public Pelouse(int tailleEstOuest, int tailleNordSud) {
		this.tailleEstOuest = tailleEstOuest;
		this.tailleNordSud = tailleNordSud;
	}

	public int getTailleEstOuest() {
		return tailleEstOuest;
	}

	public int getTailleNordSud() {
		return tailleNordSud;
	}

	public void ajouterTondeuse(int longitude, int latitude, char direction) {
		Tondeuse tondeuse = new Tondeuse(longitude, latitude, direction);
	}

}
