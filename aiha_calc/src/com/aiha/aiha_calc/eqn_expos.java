package com.aiha.aiha_calc;

import java.lang.reflect.Method;
import java.text.DecimalFormat;

public class eqn_expos
{
	Method[] equationMethods;

	// silicaRespirableFraction
	static DecimalFormat df = new DecimalFormat("0.00");
	// silicaRespirableFraction
	public static double eqn_expos_01(double qrtz, double crist, double trid)
	{
		df.setMaximumFractionDigits(2);
		double part1;
		part1 = (qrtz + (crist * 2.0) + (trid * 2.0) + 2.0);
		part1 = (10.0 / part1);
		return Double.valueOf(df.format(part1));
	}

	// silicaTotalDust
	public static double eqn_expos_02(double qrtz, double crist, double trid)
	{
		df.setMaximumFractionDigits(2);
		double part1;
		part1 = (qrtz + (crist * 2.0) + (trid * 2.0) + 2.0);
		part1 = (30.0 / part1);
		return Double.valueOf(df.format(part1));
	}

	// Multivariable functionality, possiblity have the user entire in N as the
	// number of pairs
	// they want to use
	// Then generate the N number of pairs of input boxes
	// Then call this function taking in N, the N pairs of input.
	// OELofMixtureMultiVar
	public static double eqn_expos_03(double c1, double t1, double c2, double t2)
	{
		df.setMaximumFractionDigits(2);
		double part1;
		if (c2 == 0.0 || t2 == 0.0)
			part1 = ((c1 / t1));
		else
			part1 = ((c1 / t1) + (c2 / t2));

		return Double.valueOf(df.format(part1));
	}
	
	public eqn_expos(){
		equationMethods = new Method[3];
		
		try {
			equationMethods[0]= this.getClass().getMethod(
					"eqn_expos_01", Double.TYPE, Double.TYPE, Double.TYPE);
			
			equationMethods[1]= this.getClass().getMethod(
					"eqn_expos_02", Double.TYPE, Double.TYPE, Double.TYPE);
			
			equationMethods[2]= this.getClass().getMethod(
					"eqn_expos_03", Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE);
			
		} catch (NoSuchMethodException e) {
		} catch (SecurityException e) {
		} 
	}
	
	public Method getMethod(int index){
		
		return equationMethods[index-1];
	}
}
