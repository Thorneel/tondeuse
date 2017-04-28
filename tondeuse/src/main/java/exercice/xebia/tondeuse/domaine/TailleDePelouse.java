package exercice.xebia.tondeuse.domaine;

public class TailleDePelouse {

	private final int taille_est_ouest_x;
	private final int taille_nord_sud_y;

	public TailleDePelouse(int taille_est_ouest_x, int taille_nord_sud_y) {
		this.taille_est_ouest_x = taille_est_ouest_x;
		this.taille_nord_sud_y = taille_nord_sud_y;
	}

	public int getTailleEstOuestX() {
		return taille_est_ouest_x;
	}

	public int getTailleNordSudY() {
		return taille_nord_sud_y;
	}

}
