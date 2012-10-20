import static org.junit.Assert.*;

import org.junit.Test;


public class HeatStressTest {

	final double EPSILON = 1E-2;

	@Test
	public void testWetBulbGlobeTempOutdoors() {
		assertEquals(45.70, HeatStress.wetBulbGlobeTempOutdoors(53, 25, 36), EPSILON);
	}

	@Test
	public void testWetBulbGlobeTempIndoors() {
		assertEquals(56.00, HeatStress.wetBulbGlobeTempIndoors(65, 35), EPSILON);
	}

}
