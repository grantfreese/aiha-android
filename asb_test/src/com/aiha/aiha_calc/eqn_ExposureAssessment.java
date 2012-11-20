package com.aiha.aiha_calc;

public class eqn_ExposureAssessment
{

	// silicaRespirableFraction
	public static double eqn_expos_01(double qrtz, double crist, double trid)
	{
		double part1;
		part1 = (qrtz + (crist * 2.0) + (trid * 2.0) + 2.0);
		part1 = (10.0 / part1);
		return part1;
	}

	// silicaTotalDust
	public static double eqn_expos_02(double qrtz, double crist, double trid)
	{

		double part1;
		part1 = (qrtz + (crist * 2.0) + (trid * 2.0) + 2.0);
		part1 = (30.0 / part1);
		return part1;
	}

	// Multivariable functionality, possiblity have the user entire in N as the
	// number of pairs
	// they want to use
	// Then generate the N number of pairs of input boxes
	// Then call this function taking in N, the N pairs of input.
	// OELofMixtureMultiVar
	public static double eqn_expos_03(double c1, double t1, double c2, double t2)
	{
		double part1;
		if (c2 == 0.0 || t2 == 0.0)
			part1 = ((c1 / t1));
		else
			part1 = ((c1 / t1) + (c2 / t2));

		return part1;
	}
}
