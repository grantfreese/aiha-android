package com.aiha.aiha_calc;

import java.lang.reflect.Method;
import java.text.DecimalFormat;

public class eqn_noise
{
	private Method[] equationMethods;
	static DecimalFormat df = new DecimalFormat("0.00");

	// addingSoundPressureLevels
	public static double eqn_noise_01(double N, double SPLi)
	{
		df.setMaximumFractionDigits(2);
		double sum = 0.0;
		for (int i = 0; i < N; i++)
		{
			double part1, part2;
			part1 = (SPLi / 10.0);
			part2 = Math.pow(10, part1);
			sum += part2;
		}

		sum = 10 * Math.log(sum);
		return Double.valueOf(df.format(sum));
	}

	// Something Wrong, apparently the image is wrong since it still shows as
	// 2*(Something)
	// Instead of 2^(something) - double check with Michael which is the
	// correct.
	// allowableExposureTime
	public static double eqn_noise_02(double SPL)
	{
		df.setMaximumFractionDigits(2);
		double part1;
		part1 = (SPL - 90) / 5;
		//part1 = part1 * 2;
		part1 = Math.pow(2,part1);
		part1 = 8 / part1;

		return Double.valueOf(df.format(part1));
	}

	// eightHourTWSof85dBa
	// eqn was named 85dBA Reached image
	public static double eqn_noise_03(double soundPressure)
	{
		df.setMaximumFractionDigits(2);
		double part1;
		part1 = (soundPressure - 85.0);
		part1 = part1 / 3;
		part1 = Math.pow(2, part1);
		part1 = 8 / part1;

		return Double.valueOf(df.format(part1));
	}

	// inverseSquareLaw
	public static double eqn_noise_04(double I1, double D1, double D2)
	{
		df.setMaximumFractionDigits(2);
		double part1;
		part1 = (D1 / D2);
		part1 *= part1;
		part1 = I1 * part1;
		return Double.valueOf(df.format(part1));
	}

	// percentDoseToTWA
	public static double eqn_noise_05(double percentDose)
	{
		df.setMaximumFractionDigits(2);
		double part1, part2;
		part1 = Math.log10((percentDose/100));
		part2 = (16.61*part1);
		part2 = part2+90.0;

		return Double.valueOf(df.format(part2));

	}
	
	public eqn_noise(){
		equationMethods = new Method[5];
		
		try {
			equationMethods[0]= this.getClass().getMethod(
					"eqn_noise_01", Double.TYPE, Double.TYPE);
			
			equationMethods[1]= this.getClass().getMethod(
					"eqn_noise_02", Double.TYPE);
			
			equationMethods[2]= this.getClass().getMethod(
					"eqn_noise_03", Double.TYPE);
			
			equationMethods[3]= this.getClass().getMethod(
					"eqn_noise_04", Double.TYPE, Double.TYPE, Double.TYPE);
			
			equationMethods[4]= this.getClass().getMethod(
					"eqn_noise_05", Double.TYPE);
			
		} catch (NoSuchMethodException e) {
		} catch (SecurityException e) {
		} 
	}
	
	public Method getMethod(int index){
		
		return equationMethods[index-1];
	}
}
