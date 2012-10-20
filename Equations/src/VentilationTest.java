import static org.junit.Assert.*;

import org.junit.Test;


public class VentilationTest {
	final double EPSILON = 1E-2;
	@Test
	public void testOxygenDeficiencyFormulaOne() {
		assertEquals(.21, Ventilation.oxygenDeficiencyFormulaOne(7, 6, 8, 10), EPSILON);
	}

	@Test
	public void testRoomAirChanges() {
		assertEquals(48.75, Ventilation.roomAirChanges(13, 16), EPSILON);
	}

	@Test
	public void testTotalPressure() {
		assertEquals(14.00, Ventilation.totalPressure(5, 9), EPSILON);
	}

	@Test
	public void testFlowRateAdjustmentFormulaOne() {
		assertEquals(6.12, Ventilation.flowRateAdjustmentFormulaOne(6, 5, 5, 3, 8), EPSILON);
	}

	@Test
	public void testVelocity() {
		assertEquals(12664.92, Ventilation.velocity(10), EPSILON);
	}

//Something wrong in this
	@Test
	public void testHoodStaticPressure() {
		assertEquals(17, Ventilation.hoodStaticPressure(15, -32), EPSILON);
	}

	@Test
	public void testDilutionVentilationBasedOnRoomAirChanges() {
		assertEquals(40308.13, Ventilation.dilutionVentilationBasedOnRoomAirChanges(5, 8, 4, 1), EPSILON);
	}

	@Test
	public void testDilationToControlEvaporationFormula() {
		assertEquals(186000000.00, Ventilation.dilationToControlEvaporationFormula(5, 3, 8, 20, 13), EPSILON);
	}

	@Test
	public void testFanLawsFormula() {
		assertEquals(-31.00, Ventilation.fanLawsFormula(64, 72, 23), EPSILON);
	}

	@Test
	public void testFanTotalPressure() {
		assertEquals(-11.00, Ventilation.fanTotalPressure(8, 19), EPSILON);
	}

	@Test
	public void testFanLawsFormulaFiveVar() {
		assertEquals(3, Ventilation.fanLawsFormulaFiveVar(1, 1, 2, 2, 3), EPSILON);
	}

}
