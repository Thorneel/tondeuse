package exercice.xebia.tondeuse;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.runner.RunWith;

import exercice.xebia.tondeuse.domaine.Pelouse;

@RunWith(JUnitParamsRunner.class)
public class LireLesConditionsInitialesTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Test
	@Parameters({"5, 6"})
	public void DevraitCreerUnePelouseNonCarree(int tailleEstOuest, int tailleNordSud) {
		Pelouse pelouse = new Pelouse(tailleEstOuest, tailleNordSud);
		assertEquals(5, pelouse.getTailleEstOuest());
		assertEquals(6, pelouse.getTailleNordSud());
	}
	
	@Test
	@Parameters({" 5, 5, 1, 2, N"})
	public void DevraitCreerUneTondeuse(int tailleEstOuest, int tailleNordSud, int longitude, int latitude, char direction) {
		Pelouse pelouse = new Pelouse(tailleEstOuest, tailleNordSud);
		pelouse.ajouterTondeuse(longitude, latitude, direction);
	}

}
