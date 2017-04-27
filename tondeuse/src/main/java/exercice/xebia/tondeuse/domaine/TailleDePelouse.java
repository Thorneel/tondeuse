package exercice.xebia.tondeuse.domaine;

public class TailleDePelouse {
	
	private final int tailleEstOuestX;
	private final int tailleNordSudY;

	public TailleDePelouse(int tailleEstOuestX, int tailleNordSudY) {
		this.tailleEstOuestX = tailleEstOuestX;
		this.tailleNordSudY = tailleNordSudY;
	}
	
	public int getTailleEstOuestX() {
		return tailleEstOuestX;
	}

	public int getTailleNordSudY() {
		return tailleNordSudY;
	}
	
}
