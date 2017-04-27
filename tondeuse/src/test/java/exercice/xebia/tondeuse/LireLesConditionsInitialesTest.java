package exercice.xebia.tondeuse;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.runner.RunWith;

import exercice.xebia.tondeuse.domaine.Pelouse;
import exercice.xebia.tondeuse.domaine.TailleDePelouse;
import exercice.xebia.tondeuse.domaine.Tondeuse;

@RunWith(JUnitParamsRunner.class)
public class LireLesConditionsInitialesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Test
	@Parameters({"5, 6"})
	public void devraitCreerUnePelouseNonCarree(int tailleEstOuestX, int tailleNordSudY) {
		
		Pelouse pelouse = new Pelouse(tailleEstOuestX, tailleNordSudY);
		TailleDePelouse tailleDePelouse = pelouse.getTailleDePelouse();
		assertEquals(tailleEstOuestX, tailleDePelouse.getTailleEstOuestX());
		assertEquals(tailleNordSudY, tailleDePelouse.getTailleNordSudY());
		
	}
	
	@Test
	@Parameters({"1, 2, N"})
	public void devraitCreerUneTondeuse(int longitude, int latitude, char orientation){
		
		TailleDePelouse tailleDePelouse = new TailleDePelouse(5, 5);
		Tondeuse tondeuse = new Tondeuse(longitude, latitude, orientation, tailleDePelouse, "");
		assertEquals(longitude, tondeuse.getLongitude());
		assertEquals(latitude, tondeuse.getLatitude());
		assertEquals(orientation, tondeuse.getOrientation());
		
	}
	
	@Test
	@Parameters({"1, 2, N"})
	public void devraitCreerUneTondeuseDansUnePelouseCarree(int longitude, int latitude, char orientation) {
		
		Pelouse pelouse = new Pelouse(5, 5);
		pelouse.ajouterTondeuse(longitude, latitude, orientation, "");
		
	}

}
