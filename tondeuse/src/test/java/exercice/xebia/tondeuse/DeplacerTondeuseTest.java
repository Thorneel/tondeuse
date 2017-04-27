package exercice.xebia.tondeuse;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import exercice.xebia.tondeuse.domaine.Tondeuse;

@RunWith(JUnitParamsRunner.class)
public class DeplacerTondeuseTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	@Parameters({
		"1, 2, N, 1, 3",
		"1, 2, S, 1, 1",
		"1, 2, E, 2, 2",
		"1, 2, W, 0, 2"
	})
	public void devraitAvancerLaTondeuse(int longitude, int latitude, char direction, int longitude_attendue, int latitude_attendue) {
		Tondeuse tondeuse = new Tondeuse(longitude, latitude, direction);
		tondeuse.avancerTondeuse();
		assertEquals(longitude_attendue, tondeuse.getLongitude());
		assertEquals(latitude_attendue, tondeuse.getLatitude());
		
	}

}
