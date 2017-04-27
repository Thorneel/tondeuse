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
	@Parameters({"1, 2, N, GAGAGAGAA, 1, 3, N"})
	public void test(int longitude, int latitude, char orientation, String listeDesMouvements, int longitude_attendue, int latitude_attendue, char orientation_attendue) {

		TailleDePelouse tailleDePelouse = new TailleDePelouse(5, 5);
		Tondeuse tondeuse = new Tondeuse(longitude, latitude, orientation, tailleDePelouse, listeDesMouvements);
		for ( int i = 0; i < listeDesMouvements.length(); i++ ) {
			tondeuse.executerMouvementSuivant();
		}
		assertEquals(1, tondeuse.getLongitude());
		assertEquals(3, tondeuse.getLatitude());
		assertEquals('N', tondeuse.getOrientation());
		
	}
	
}
