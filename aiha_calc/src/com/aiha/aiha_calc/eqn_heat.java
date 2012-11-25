package com.aiha.aiha_calc;

import java.lang.reflect.Method;

public class eqn_heat
{
	private Method[] equationMethods;
	
	// wetBulbGlobeTempOutdoors
	public static double eqn_heat_01(double tnwb_o, double tg_o, double tdb_o)
	{
		double temp;
		double tnwb = tnwb_o;
		double tg = tg_o;
		double tdb = tdb_o;

		temp = ((.7 * tnwb) + (.2 * tg) + (.1 * tdb));

		return temp;
	}

	// wetBulbGlobeTempIndoors
	public static double eqn_heat_02(double tnwb_o, double tg_o)
	{
		double temp;
		double tnwb = tnwb_o;
		double tg = tg_o;

		temp = ((.7 * tnwb) + (.3 * tg));

		return temp;
	}

	public eqn_heat(){
		equationMethods = new Method[2];
		
		try {
			equationMethods[0]= this.getClass().getMethod(
					"eqn_heat_01", Double.TYPE, Double.TYPE, Double.TYPE);
			
			equationMethods[1]= this.getClass().getMethod(
					"eqn_heat_02", Double.TYPE, Double.TYPE);
			
		} catch (NoSuchMethodException e) {
		} catch (SecurityException e) {
		} 
	}
	
	public Method getMethod(int index){
		
		return equationMethods[index-1];
	}
}
