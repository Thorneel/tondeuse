/**
 * 
 */
package exercice.xebia.tondeuse;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import junitparams.JUnitParamsRunner;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class AppTest {

    private final static PrintStream sortie_par_defaut_vers_la_console = System.out;
    private final static ByteArrayOutputStream output = new ByteArrayOutputStream();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
        System.setOut(new PrintStream(output, true, "UTF-8"));
	}

	@Test
	public void testDeLaBoucleMainAvecLeFichierDExemple() throws IOException {
		App.main(null);
		String string_de_resultats = "1 3 N" + System.lineSeparator() + "5 1 E" + System.lineSeparator();
		assertEquals(string_de_resultats, output.toString());
	}
	
	@AfterClass
    public static void tearDownAfterClass() {
        System.setOut(sortie_par_defaut_vers_la_console);
    }

}
