package model;

/**
 * @author hakka
 */
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

public class ValuuttakoneTest {

	private Valuuttakone valuuttakone = new Valuuttakone();
	private final double DELTA = 0.000001;

/****  Tehtävän 4 testi: poista kommenteista kun olet toteuttanut metodin getVaihtoehdot()
	@Test
	public void testGetVaihtoehdot() {
		String[] expected = { "Euroopan euro", "Ruotsin kruunu", "Norjan kruunu", "Yhdysvaltain dollari" };
		String[] vaihtoehdot = valuuttakone.getVaihtoehdot();

		Arrays.sort(vaihtoehdot); // binäärihaku vaatii järjestetyn taulukon
		for(String nimi : expected) {
				if (Arrays.binarySearch(vaihtoehdot, nimi) < 0) {
				fail("Valuutan nimi " + nimi + " puuttuu vaihtoehtolistasta");
			}
		}

		// Jos järjestys taulukossa sama kuin tehtävän kuvassa, niin voi verrata kokonaisia taulukoita
		// assertArrayEquals("Valuuttojen nimitaulu virheellinen", expected, vaihtoehdot);
	}
****/

	@Test
	public void testMuunna() {
		final int EUR = 0, SEK = 1, NOK = 2, USD = 3;
		int määrä = 100;

		String str = "Muunna " + määrä +" EUR "; // Euroopan euroista
		double EURExpected = 100.0;
		assertEquals(str + "-> EUR ei toimi oikein", EURExpected, valuuttakone.muunna(EUR, EUR,  määrä), DELTA);
		double SEKExpected = 947.80;
		assertEquals(str + "-> SEK ei toimi oikein", SEKExpected, valuuttakone.muunna(EUR, SEK,  määrä), DELTA);
		double NOKExpected = 890.18;
		assertEquals(str + "-> NOK ei toimi oikein", NOKExpected, valuuttakone.muunna(EUR, NOK,  määrä), DELTA);
		double USDExpected = 106.29;
		assertEquals(str + "-> USD ei toimi oikein", USDExpected, valuuttakone.muunna(EUR, USD,  määrä), DELTA);

		str = "Muunna " + määrä + " SEK"; // Ruotsin kruunuista
		EURExpected = 10.550749;
		assertEquals(str + "-> EUR ei toimi oikein", EURExpected, valuuttakone.muunna(SEK, EUR,  määrä), DELTA);
		USDExpected = 11.214391;
		assertEquals(str + "-> USD ei toimi oikein", USDExpected, valuuttakone.muunna(SEK, USD,  määrä), DELTA);
	}
}
