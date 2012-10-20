import static org.junit.Assert.*;

import org.junit.Test;


public class ExposureAssessmentTest {

	final double EPSILON = 1E-2;
	
	@Test
	public void testSilicaRespirableFraction() {
		assertEquals(.11, ExposureAssessment.silicaRespirableFraction(52, 5, 15), EPSILON);
	}

	@Test
	public void testSilicaTotalDust() {
		assertEquals(.21, ExposureAssessment.silicaTotalDust(95,17,5), EPSILON);
	}

	@Test
	public void testOELofMixtureMultiVar() {
		assertEquals(1.89, ExposureAssessment.OELofMixtureMultiVar(56, 80, 43, 36), EPSILON);
	}

}
