package exercice.xebia.tondeuse.infrastructure;

public class AfficheurDeResultats {
	
	private String[] tableau_de_resultats;

	public AfficheurDeResultats(String[] tableau_de_resultats) {
		this.tableau_de_resultats = tableau_de_resultats;
	}

	public void afficherLesResultats() {
		for (String resultat_d_une_tondeuse: tableau_de_resultats) {
			System.out.println(resultat_d_une_tondeuse);
		}
	}

}
