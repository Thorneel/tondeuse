/**
 * 
 */
package exercice.xebia.tondeuse;

import static org.junit.Assert.*;

import org.junit.Test;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class AppTest {

	
	/*@Test
	public void testMain() {
		//fail("Not yet implemented");
	}*/
	
	// TODO remplacer ce test de test pour tester les tests par un vrai test
	/**
	 * Test method for {@link exercice.xebia.tondeuse.App#addOne(int)}.
	 */
	@Test
	@Parameters({"-1", "0", "1", "2"})
	public void shouldAddOneToTheParameter(int i) {
		App app = new App();
		assertEquals(i+1, app.addOne(i));
	}

}
