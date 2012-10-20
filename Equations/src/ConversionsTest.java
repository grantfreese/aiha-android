import static org.junit.Assert.*;

import org.junit.Test;


public class ConversionsTest {
	final double EPSILON = 1E-2;
	@Test
	public void testConvertPPMToMMG() {
		assertEquals(1.84, Conversions.convertPPMToMMG(9, 5), EPSILON);
	}

	@Test
	public void testGetOELinPPM() {
		assertEquals(31.44, Conversions.getOELinPPM(9, 7), EPSILON);
	}

	@Test
	public void testFtToCm() {
		assertEquals(141500.0000, Conversions.ftToCm(5), EPSILON);
	}

	@Test
	public void testFtToL() {
		assertEquals(141.5843, Conversions.ftToL(5.00), EPSILON);
	}
//We don't have Meter cubed in our application.
	@Test
	public void testFtCubedToMCubed() {
		fail("Not yet implemented");
	}

	@Test
	public void testCmToFt() {
		assertEquals(5, Conversions.cmToFt(141500), EPSILON);
	}

	@Test
	public void testLitersToFt() {
		assertEquals(5, Conversions.litersToFt(141.5843), EPSILON);
	}
//Not in our application
	@Test
	public void testMetersCubedToFtCubed() {
		fail("Not yet implemented");
	}

	@Test
	public void testInchCubedToCm() {
		assertEquals(141500, Conversions.inchCubedToCm(8640), EPSILON);
	}

	@Test
	public void testCmToInch() {
		assertEquals(8640, Conversions.CmToInch(141500), EPSILON);
	}
//Not in our app.
	@Test
	public void testFtToGallons() {
		fail("Not yet implemented");
	}
//Not in our app.
	@Test
	public void testGallonsToFt() {
		fail("Not yet implemented");
	}

	@Test
	public void testLitersToQuart() {
		assertEquals(149.6104, Conversions.litersToQuart(141.5843), EPSILON);
	}

	@Test
	public void testQuartToL() {
		assertEquals(141.5843, Conversions.litersToQuart(149.6104), EPSILON);
	}
	
// Volume Conversions
	
	@Test
	public void testLbToGrams() {
		assertEquals(3628.7390, Conversions.lbToGrams(8), EPSILON);
	}

	@Test
	public void testGramsToLb() {
		assertEquals(8, Conversions.gramsToLb(3628.7390), EPSILON);
	}

	@Test
	public void testGramsToGrains() {
		assertEquals(56000, Conversions.gramsToGrains(3628.7390), EPSILON);
	}

	@Test
	public void testGrainsToGrams() {
		assertEquals(3628.7390, Conversions.grainsToGrams(56000), EPSILON);
	}

	@Test
	public void testOunceToGram() {
		assertEquals(3628.7390, Conversions.ounceToGram(128), EPSILON);
	}

	@Test
	public void testGramsToOunce() {
		assertEquals(128, Conversions.gramsToOunce(3628.7390), EPSILON);
	}

	//Flow Rate conversions
	@Test
	public void testMsToFtm() {
		assertEquals(10600, Conversions.msToFtm(5), EPSILON);
	}

	@Test
	public void testFtmToMs() {
		assertEquals(5, Conversions.ftmToMs(10600), EPSILON);
	}

	@Test
	public void testFtmToCps() {
		assertEquals(173840, Conversions.ftmToCps(5), EPSILON);
	}

	@Test
	public void testCpsToFtm() {
		assertEquals(10600, Conversions.cpsToFtm(173840), EPSILON);
	}

	@Test
	public void testFthToLMin() {
		assertEquals(2.35, Conversions.fthToLMin(5), EPSILON);
	}

	@Test
	public void testLmToFth() {
		assertEquals(5, Conversions.lmToFth(2.35), EPSILON);
	}

//Concentration Conversions
	@Test
	public void testGToM() {
		assertEquals(18.32, Conversions.gToM(8), EPSILON);
	}

	@Test
	public void testMToG() {
		assertEquals(8, Conversions.mToG(18.32), EPSILON);
	}

	@Test
	public void testMppcfToParticles() {
		assertEquals(1517.900, Conversions.mppcfToParticles(43), EPSILON);
	}

	@Test
	public void testParticlesToMppcf() {
		assertEquals(1517.900, Conversions.particlesToMppcf(43), EPSILON);
	}

//Temperature Conversions
	@Test
	public void testFToC() {
		assertEquals(29.44, Conversions.fToC(85), EPSILON);
	}

	@Test
	public void testCToF() {
		assertEquals(85, Conversions.cToF(29.44), EPSILON);
	}

	@Test
	public void testRToF() {
		assertEquals(85, Conversions.rToF(544.67), EPSILON);
	}

	@Test
	public void testFToR() {
		assertEquals(544.67, Conversions.fToR(85), EPSILON);
	}

	@Test
	public void testKToC() {
		assertEquals(29.44, Conversions.kToC(302.59), EPSILON);
	}

	@Test
	public void testCToK() {
		assertEquals(302.59, Conversions.cToK(29.44), EPSILON);
	}

//Distance Conversions
	@Test
	public void testInchtoCm() {
		assertEquals(91.44, Conversions.inchtoCm(36), EPSILON);
	}

	@Test
	public void testCmToInch1() {
		assertEquals(36, Conversions.cmToInch(91.44), EPSILON);
	}

	@Test
	public void testMToFt() {
		assertEquals(3, Conversions.mToFt(.9144), EPSILON);
	}

	@Test
	public void testFtToM() {
		assertEquals(.9144, Conversions.ftToM(3), EPSILON);
	}

	@Test
	public void testMileToFt() {
		assertEquals(3, Conversions.mileToFt(.0006), EPSILON);
	}

	@Test
	public void testMileToM() {
		assertEquals(.9144, Conversions.mileToM(.0006), EPSILON);
	}

	@Test
	public void testFtToMile() {
		assertEquals(.0006, Conversions.ftToMile(3), EPSILON);
	}

	@Test
	public void testMToMile() {
		assertEquals(.0006, Conversions.mToMile(.9144), EPSILON);
	}

//Pressure Conversions
	@Test
	public void testAtmToPsi() {
		assertEquals(514.5, Conversions.atmToPsi(35), EPSILON);
	}

	@Test
	public void testAtmToMmhg() {
		assertEquals(26600, Conversions.atmToMmhg(35), EPSILON);
	}

	@Test
	public void testAtmToFtWater() {
		assertEquals(14245, Conversions.atmToFtWater(35), EPSILON);
	}

	@Test
	public void testPsiToAtm() {
		assertEquals(35, Conversions.psiToAtm(514.5), EPSILON);
	}

	@Test
	public void testMmHgToAtm() {
		assertEquals(35, Conversions.mmHgToAtm(26600), EPSILON);
	}

	@Test
	public void testFtWaterToAtm() {
		assertEquals(35, (Conversions.ftWaterToAtm(14245)/12), EPSILON);
	}

}
