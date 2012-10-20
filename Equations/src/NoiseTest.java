import static org.junit.Assert.*;

import org.junit.Test;


public class NoiseTest {
	
	final double EPSILON = 1E-2;
	
	//Check iOS Code which parameter goes with which variable in the equation function
	@Test
	public void testAddingSoundPressureLevels() {
		assertEquals(25.38, Noise.addingSoundPressureLevels(5,4), EPSILON);
	}

	@Test
	public void testAllowableExposureTime() {
		assertEquals(-.50, Noise.allowableExposureTime(50), EPSILON);
	}

	@Test
	public void testEightHourTWSof85dBa() {
		assertEquals(80.63, Noise.eightHourTWSof85dBa(75), EPSILON);
	}

	@Test
	public void testInverseSquareLaw() {
		assertEquals(9.03, Noise.inverseSquareLaw(52, 100, 240), EPSILON);
	}

	@Test
	public void testPercentDoseToTWA() {
		assertEquals(73.49, Noise.percentDoseToTWA(37), EPSILON);
	}

}
