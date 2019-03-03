package model;

/**
 * @author hakka
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ValuuttaTest {

	private Valuutta valuutta;
	private final static double DELTA = 0.001;

	@Before
	public void setUp() {
		valuutta = new Valuutta("Euroopan euro", 1.0);
	}

	@Test
	public void testValuutta() {
		try {
			 valuutta = new Valuutta("Euroopan euro", 1.0);
		} catch (Exception e) {
			fail("Valuutta-olion luonti ei onnistunut");
		}
	}

	@Test
	public void testGetNimi() {
		assertEquals("Valuutan nimi väärin", "Euroopan euro", valuutta.getNimi());
	}

	@Test
	public void testGetVaihtokurssi() {
		assertEquals("Valuutan vaihtoarvo väärin", 1.0, valuutta.getVaihtokurssi(), DELTA);
	}

	@Test
	public void testSetVaihtokurssi() {
		valuutta.setVaihtokurssi(1.01);
		assertEquals("Valuutan vaihtokurssin asetus väärin", 1.01, valuutta.getVaihtokurssi(), DELTA);
	}

}
