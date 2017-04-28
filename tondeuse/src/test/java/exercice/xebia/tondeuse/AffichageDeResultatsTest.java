package exercice.xebia.tondeuse;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import exercice.xebia.tondeuse.infrastructure.AfficheurDeResultats;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class AffichageDeResultatsTest {

    private final static PrintStream sortie_par_defaut_vers_la_console = System.out;
    private final static ByteArrayOutputStream output = new ByteArrayOutputStream();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
        System.setOut(new PrintStream(output, true, "UTF-8"));
	}

	
	@Test
	@Parameters({ "1 3 N, 5 1 E" })
	public void devraitAfficherLeResultatFourniDansLaConsole(String[] tableau_de_resultats) {
		
		AfficheurDeResultats afficheur_de_resultats = new AfficheurDeResultats(tableau_de_resultats);
		
		//System.out.println(tableau_de_resultats[0]);
		//System.out.println(tableau_de_resultats[1]);
		
		afficheur_de_resultats.afficherLesResultats();
		
		String string_de_resultats = new String();
		for (String resultat_d_une_tondeuse: tableau_de_resultats) {
			string_de_resultats += resultat_d_une_tondeuse + System.lineSeparator();
		}
		
		
		assertEquals(string_de_resultats, output.toString());
	}
	
	
	@AfterClass
    public static void tearDownAfterClass() {
        System.setOut(sortie_par_defaut_vers_la_console);
    }

}
