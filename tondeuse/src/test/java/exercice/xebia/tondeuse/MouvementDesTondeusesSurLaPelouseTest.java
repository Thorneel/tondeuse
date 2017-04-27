package exercice.xebia.tondeuse;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import exercice.xebia.tondeuse.domaine.Pelouse;
import exercice.xebia.tondeuse.domaine.TailleDePelouse;
import exercice.xebia.tondeuse.domaine.Tondeuse;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class MouvementDesTondeusesSurLaPelouseTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	@Parameters({ "1, 2, N, GAGAGAGAA, 1, 3, N" })
	public void devraitPasserLaliste_des_mouvementsALaTondeuseEtLuiFaireTousExecuterLUnApresLAutre(int longitude,
			int latitude, char orientation, String liste_des_mouvements, int longitude_attendue, int latitude_attendue,
			char orientation_attendue) {

		TailleDePelouse TailleDePelouse = new TailleDePelouse(5, 5);
		Tondeuse tondeuse = new Tondeuse(longitude, latitude, orientation, TailleDePelouse, liste_des_mouvements);
		for (int i = 0; i < liste_des_mouvements.length(); i++) {
			tondeuse.executerMouvementSuivant();
		}
		assertEquals(1, tondeuse.getLongitude());
		assertEquals(3, tondeuse.getLatitude());
		assertEquals('N', tondeuse.getOrientation());

	}

	@Test
	@Parameters({ "1, 2, N, GAGAGAGAA, 1, 3, N" })
	public void devraitIgnorerLesMouvementsOrdonnesUneFoisArriveAuBoutDeLaListe(int longitude, int latitude,
			char orientation, String liste_des_mouvements, int longitude_attendue, int latitude_attendue,
			char orientation_attendue) {

		TailleDePelouse TailleDePelouse = new TailleDePelouse(5, 5);
		Tondeuse tondeuse = new Tondeuse(longitude, latitude, orientation, TailleDePelouse, liste_des_mouvements);
		for (int i = 0; i <= liste_des_mouvements.length(); i++) {
			tondeuse.executerMouvementSuivant();
		}
		assertEquals(longitude_attendue, tondeuse.getLongitude());
		assertEquals(latitude_attendue, tondeuse.getLatitude());
		assertEquals(orientation_attendue, tondeuse.getOrientation());

	}

	@Test
	@Parameters({ "1, 2, N, GAGAGAGAA, 1, 3, N" })
	public void devraitExecuterLesMouvementsDUneTondeuseDeLaPelouseJusquACeQUelleAitTermineeSesMouvements(
			int longitude, int latitude, char orientation, String liste_des_mouvements, int longitude_attendue,
			int latitude_attendue, char orientation_attendue) {

		Pelouse pelouse = new Pelouse(5, 5);
		Tondeuse tondeuse = pelouse.ajouterTondeuse(longitude, latitude, orientation, liste_des_mouvements);
		for (int i = 0; i <= liste_des_mouvements.length(); i++) {
			pelouse.executerMouvementSuivantPourChaqueTondeuse();
		}
		assertEquals(longitude_attendue, tondeuse.getLongitude());
		assertEquals(latitude_attendue, tondeuse.getLatitude());
		assertEquals(orientation_attendue, tondeuse.getOrientation());

	}

}
