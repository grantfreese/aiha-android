package com.aiha.aiha_calc;

public class eqn_noise
{

	// addingSoundPressureLevels
	public static double eqn_noise_01(double N, double SPLi)
	{
		double sum = 0.0;
		for (int i = 0; i < N; i++)
		{
			double part1, part2;
			part1 = (SPLi / 10.0);
			part2 = Math.pow(10, part1);
			sum += part2;
		}

		sum = 10 * Math.log(sum);
		return sum;
	}

	// Something Wrong, apparently the image is wrong since it still shows as
	// 2*(Something)
	// Instead of 2^(something) - double check with Michael which is the
	// correct.
	// allowableExposureTime
	public static double eqn_noise_02(double SPL)
	{
		double part1;
		part1 = (SPL - 90) / 5;
		part1 = part1 * 2;
		// part1 = Math.pow(2,part1);
		part1 = 8 / part1;

		return part1;
	}

	// eightHourTWSof85dBa
	// eqn was named 85dBA Reached image
	public static double eqn_noise_03(double soundPressure)
	{
		double part1;
		part1 = (soundPressure - 85.0);
		part1 = part1 / 3;
		part1 = Math.pow(2, part1);
		part1 = 8 / part1;

		return part1;
	}

	// inverseSquareLaw
	public static double eqn_noise_04(double I1, double D1, double D2)
	{
		double part1;
		part1 = (D1 / D2);
		part1 *= part1;
		part1 = I1 * part1;
		return part1;
	}

	// percentDoseToTWA
	public static double eqn_noise_05(double percentDose)
	{
		double part1, part2;
		part1 = Math.log((percentDose / 100));
		part2 = (16.61 * part1);
		part2 = part2 + 90.0;

		return part2;

	}
}
