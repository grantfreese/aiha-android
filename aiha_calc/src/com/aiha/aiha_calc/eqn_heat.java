package com.aiha.aiha_calc;

public class eqn_heat
{
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

}
