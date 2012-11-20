package com.aiha.aiha_calc;

public class eqn_Ventilation
{

	// volumeOfDisplacedAir.svg (now eqn_vent_00)
	// oxygenLevelOfRoom.svg (now eqn_vent_01)
	// oxygenDeficiencyFormulaOne
	public static double eqn_vent_01(double cryogen, double density, double mw,
			double roomVolume)
	{
		// Part 1.
		// Volume of displace air (ft3) = (liters of cryogen)*(103
		// cm/liter)*(density of inert gas)*(1 mole/MW of gas)*(24.25
		// liters/mole)*(1 ft3/28.31 liters)

		double power, mol, displacedAir, oxygenLevel, finalAns;
		power = Math.pow(10.0, 23.0);
		mol = (6.02214179) * power;
		displacedAir = cryogen * (10.0 * 10.0 * 10.0) * density * (1 / mw)
				* (24.25 / mol) * (1.0 / 28.31);

		// Part 2.
		// %Oxygen in room = ((20.9%)*(room volume - volume of displaced air)) /
		// room volume.
		oxygenLevel = .209 * (roomVolume - displacedAir);

		finalAns = (oxygenLevel / roomVolume);
		return finalAns;
	}

	// roomAirChanges
	public static double eqn_vent_02(double qVal, double volume)
	{
		double part1;
		part1 = ((60.0 * qVal) / volume);
		return part1;
	}

	// totalPressure
	public static double eqn_vent_03(double vp, double sp)
	{
		double part1;
		part1 = vp + sp;
		return part1;
	}

	// flowRateAdjustmentFormulaOne
	public static double eqn_vent_04(double Qind, double Pc, double Ts,
			double Ps, double Tc)
	{

		double part1, part2, finalanswer;
		part1 = ((Pc * Ts) / (Ps * Tc));
		part2 = Math.sqrt(part1);
		finalanswer = Qind * part2;
		return finalanswer;
	}

	// velocity
	public static double eqn_vent_05(double vp)
	{
		double part1;
		part1 = 4005.0 * Math.sqrt(vp);

		return part1;
	}

	// hoodStaticPressure
	public static double eqn_vent_06(double VPd, double he)
	{
		double part1;
		part1 = VPd + he;
		part1 = Math.abs(part1);

		return part1;
	}

	// e cannot be represented as e, have to be a finite, tangible number
	// dilutionVentilationBasedOnRoomAirChanges
	public static double eqn_vent_07(double G, double Q, double t, double N)
	{
		final double e = 2.71828183;

		double part1, retVal;
		part1 = (G / Q);
		retVal = -(N * (t / 60.0));
		retVal = Math.pow(e, retVal);
		retVal = 1 - retVal;
		retVal = part1 * retVal * Math.pow(10.0, 6.0);

		return retVal;
	}

	// dilationToControlEvaporationFormula
	public static double eqn_vent_08(double SG, double ER, double K, double MW,
			double C)
	{
		double retVal;
		retVal = 403.0 * SG * ER * K * Math.pow(10.0, 6.0);
		retVal = retVal / (MW * C);
		return retVal;
	}

	// fanLawsFormula
	public static double eqn_vent_09(double SPout, double SPin, double VPin)
	{
		double retVal;
		retVal = (SPout - SPin) - VPin;
		return retVal;
	}

	// fanTotalPressure
	public static double eqn_vent_10(double TPout, double TPin)
	{
		double part1;
		part1 = TPout - TPin;
		return part1;
	}

	// fanLawsFormulaFiveVar
	public static double eqn_vent_11(double size1, double size2, double RPM1,
			double RPM2, double Q)
	{
		double retVal;
		retVal = (size2 / size1);
		retVal = Math.pow(retVal, 3.0);
		retVal = Q * retVal * (RPM1 / RPM2);

		return retVal;
	}
}
