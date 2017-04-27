package exercice.xebia.tondeuse;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.runner.RunWith;

import exercice.xebia.tondeuse.domaine.Pelouse;
import exercice.xebia.tondeuse.domaine.Tondeuse;

@RunWith(JUnitParamsRunner.class)
public class LireLesConditionsInitialesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Test
	@Parameters({"5, 6"})
	public void devraitCreerUnePelouseNonCarree(int tailleEstOuest, int tailleNordSud) {
		Pelouse pelouse = new Pelouse(tailleEstOuest, tailleNordSud);
		assertEquals(tailleEstOuest, pelouse.getTailleEstOuest());
		assertEquals(tailleNordSud, pelouse.getTailleNordSud());
	}
	
	@Test
	@Parameters({"1, 2, N"})
	public void devraitCreerUneTondeuse(int longitude, int latitude, char direction){
		Tondeuse tondeuse = new Tondeuse(longitude, latitude, direction);
		assertEquals(longitude, tondeuse.getLongitude());
		assertEquals(latitude, tondeuse.getLatitude());
		assertEquals(direction, tondeuse.getDirection());
	}
	
	@Test
	@Parameters({"1, 2, N"})
	public void devraitCreerUneTondeuseDansUnePelouseCarree(int longitude, int latitude, char direction) {
		Pelouse pelouse = new Pelouse(5, 5);
		pelouse.ajouterTondeuse(longitude, latitude, direction);
	}

}
