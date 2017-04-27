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
	public void devraitCreerUnePelouseNonCarree(int taille_est_ouest_x, int taille_nord_sud_y) {
		
		Pelouse pelouse = new Pelouse(taille_est_ouest_x, taille_nord_sud_y);
		TailleDePelouse TailleDePelouse = pelouse.gettaille_de_pelouse();
		assertEquals(taille_est_ouest_x, TailleDePelouse.gettaille_est_ouest_x());
		assertEquals(taille_nord_sud_y, TailleDePelouse.gettaille_nord_sud_y());
		
	}
	
	@Test
	@Parameters({"1, 2, N"})
	public void devraitCreerUneTondeuse(int longitude, int latitude, char orientation){
		
		TailleDePelouse TailleDePelouse = new TailleDePelouse(5, 5);
		Tondeuse tondeuse = new Tondeuse(longitude, latitude, orientation, TailleDePelouse, "");
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
