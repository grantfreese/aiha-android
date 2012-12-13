package com.aiha.aiha_calc;

import java.lang.reflect.Method;

public class Conversions {
	
	Method[] conversionMethods;
	
	public static double convertPPMToMMG(double mg, double ppm)
	{
		double convertedValue;
		convertedValue = mg*ppm;
		convertedValue = convertedValue / 24.45;
		return convertedValue;
	}

	public static double getOELinPPM(double oel, double mg)
	{
		double convertedValue;
		convertedValue = 24.45*oel;
		convertedValue = convertedValue / mg;
		return convertedValue;
	}

	// ********* Volume Conversions ********* 
	
	public static double ftToCm(double ft)
	{
		double convertedValue;
		convertedValue = 28300.0*ft;
		return convertedValue;
	}
	
	public static double ftToL(double ft)
	{
		double convertedValue;
		convertedValue = 28.3*ft;
		return convertedValue;
	}

	public static double ftCubedToMCubed(double ft)
	{
		double convertedValue;
		convertedValue = 0.0283*ft;
		return convertedValue;
	}
	
	public static double cmToFt(double cm)
	{
		double convertedValue;
		convertedValue = cm / 28300.0;
		return convertedValue;
	}
	
	public static double litersToFt(double liters)
	{
		double convertedValue;
		convertedValue = liters / 28.3;
		return convertedValue;
	}

	public static double metersCubedToFtCubed(double meters)
	{
		double convertedValue;
		convertedValue = meters / 0.0283;
		return convertedValue;
	}

	public static double inchCubedToCm(double inch)
	{
		double convertedValue;
		convertedValue = inch * 16.4;
		return convertedValue;
	}
	
	public static double CmToInch(double cm)
	{
		double convertedValue;
		convertedValue = cm / 16.4;
		return convertedValue;
	}

	public static double ftToGallons(double ft)
	{
		double convertedValue;
		convertedValue = 7.481 * ft;
		return convertedValue;
	}
	
	public static double gallonsToFt(double gallons)
	{
		double convertedValue;
		convertedValue = gallons / 7.481;
		return convertedValue;
	}
	
	public static double litersToQuart(double liters)
	{
		double convertedValue;
		convertedValue = liters * 1.0566;
		return convertedValue;
	}

	public static double quartToL(double quart)
	{
		double convertedValue;
		convertedValue = quart / 1.0566;
		return convertedValue;
	}
	
	public static Double[] convertVolume(int index, double val){
		
		Double[] d = new Double[5];
		double baseValue = 0.0; // always in ft^3
		
		switch(index){
		case 0: baseValue = val; //ft^3
			break;
		case 1: baseValue = cmToFt(val); //cm^3
			break;
		case 2: baseValue = inchtoCm(val);
				baseValue = cmToFt(baseValue);//inches^3
			break;
		case 3: baseValue = litersToFt(val);//liters
			break;
		case 4: baseValue = quartToL(val);
				baseValue = litersToFt(val);//quarts
			break;
		}
		
		d[0] = baseValue;
		d[1] = ftToCm(baseValue);
		d[2] = CmToInch(d[1]);
		d[3] = ftToL(baseValue);
		d[4] = litersToQuart(d[3]);
		
		return d;
	}
	
	// ********* Mass Conversions ********* 
	public static double lbToGrams(double lb)
	{
		double convertedValue;
		convertedValue = lb * 453.6;
		return convertedValue;
	}	

	public static double gramsToLb(double grams)
	{
		double convertedValue;
		convertedValue = grams / 453.6;
		return convertedValue;
	}	

	public static double gramsToGrains(double grams)
	{
		double convertedValue;
		convertedValue = grams * 15.43;
		return convertedValue;
	}
	
	public static double grainsToGrams(double grains)
	{
		double convertedValue;
		convertedValue = grains / 15.43;
		return convertedValue;
	}

	public static double ounceToGram(double ounce)
	{
		double convertedValue;
		convertedValue = ounce * 28.35;
		return convertedValue;
	}

	public static double gramsToOunce(double grams)
	{
		double convertedValue;
		convertedValue = grams / 28.35;
		return convertedValue;
	}
	
	public static Double[] convertMass(int index, double val){
		
		Double[] d = new Double[5];
		double baseValue = 0.0; // always in grams
		
		switch(index){
		case 0: baseValue = lbToGrams(val); //pounds
			break;
		case 1: baseValue = val * 1000.0; //kilograms
			break;
		case 2: baseValue = val; //grams
			break;
		case 3: baseValue = grainsToGrams(val); //grains
			break;
		case 4: baseValue = ounceToGram(val); //ounces
			break;
		}
		
		d[0] = gramsToLb(baseValue);
		d[1] = baseValue/1000.0;
		d[2] = baseValue;
		d[3] = gramsToGrains(baseValue);
		d[4] = gramsToOunce(baseValue);
		
		return d;
	}

	// ********* Flow Rate Conversions ********* 
	public static double msToFtm(double ms)
	{
		double convertedValue;
		convertedValue = ms * 2120.0;
		return convertedValue;
	}

	public static double ftmToMs(double ftm)
	{
		double convertedValue;
		convertedValue = ftm / 2120.0;
		return convertedValue;
	}

	public static double ftmToCps(double ftm)
	{
		double convertedValue;
		convertedValue = ftm * 16.4;
		return convertedValue;
	}
	
	public static double cpsToFtm(double cps)
	{
		double convertedValue;
		convertedValue = cps / 16.4;
		return convertedValue;
	}

	public static double fthToLMin(double fth)
	{
		double convertedValue;
		convertedValue = fth * 0.47;
		return convertedValue;
	}
	
	public static double lmToFth(double lm)
	{
		double convertedValue;
		convertedValue = lm / 0.47;
		return convertedValue;
	}

	// ********* Concentration Conversions ********* 
	public static double gToM(double g)
	{
		double convertedValue;
		convertedValue = g * 2.29;
		return convertedValue;
	}	
	
	public static double mToG(double m)
	{
		double convertedValue;
		convertedValue = m / 2.29;
		return convertedValue;
	}

	public static double mppcfToParticles(double mppcf)
	{
		double convertedValue;
		convertedValue = mppcf * 35.3;
		return convertedValue;
	}
	
	public static double particlesToMppcf(double particles)
	{
		double convertedValue;
		convertedValue = particles / 35.3;
		return convertedValue;
	}
	
	// ********* Temperature Conversions ********* 
	public static double fToC(double f)
	{
		double convertedValue;
		convertedValue = (f-32.0) * (5.0 / 9.0);
		return convertedValue;
	}
	
	public static double fToRe(double f)
	{
		double convertedValue;
		convertedValue = (f-32.0) * (4.0 / 9.0);
		return convertedValue;
	}

	public static double cToF(double c)
	{
		double convertedValue;
		convertedValue = (c*(9.0 / 5.0)) + 32.0;
		return convertedValue;
	}

	public static double raToF(double r)
	{
		double convertedValue;
		convertedValue = r - 460.0;
		return convertedValue;
	}
	
	public static double fToRa(double f)
	{
		double convertedValue;
		convertedValue = f + 460.0;
		return convertedValue;
	}
	
	public static double reToF(double r)
	{
		double convertedValue;
		convertedValue = (r*(9.0 / 4.0)) + 32.0;
		return convertedValue;
	}

	public static double kToC(double k)
	{
		double convertedValue;
		convertedValue = k - 273.0;
		return convertedValue;
	}
	
	public static double cToK(double c)
	{
		double convertedValue;
		convertedValue = c + 273.0;
		return convertedValue;
	}
	
	public static Double[] convertTemperature(int index, double val){
		Double[] d = new Double[5];
		double baseValue = 0.0; // always in F
		
		switch(index){
		case 0: baseValue = val; //F
			break;
		case 1: baseValue = cToF(val); //C
			break;
		case 2: baseValue = raToF(val); //Ra
			break;
		case 3: baseValue = kToC(val); //K
				baseValue = cToF(baseValue); 
			break;
		case 4: baseValue = reToF(val); //Re
			break;
		}
		
		d[0] = baseValue;
		d[1] = fToC(baseValue);
		d[2] = fToRa(baseValue);
		d[3] = cToK(d[1]);
		d[4] = fToRe(baseValue);
		
		return d;
	}
	// ********* Distance Conversions ********* 
	
	public static double inchtoCm(double inch)
	{
		double convertedValue;
		convertedValue = inch * 2.54;
		return convertedValue;
	}
	
	public static double cmToInch(double cm)
	{
		double convertedValue;
		convertedValue = cm / 2.54;
		return convertedValue;
	}
	
	public static double mToFt(double m)
	{
		double convertedValue;
		convertedValue = m * 3.28;
		return convertedValue;
	}

	public static double ftToM(double ft)
	{
		double convertedValue;
		convertedValue = ft / 3.28;
		return convertedValue;
	}
	
	public static double mileToFt(double mile)
	{
		double convertedValue;
		convertedValue = mile * 5280.0;
		return convertedValue;
	}
	
	public static double mileToM(double mile)
	{
		double convertedValue;
		convertedValue = mile * 1600.0;
		return convertedValue;
	}

	public static double ftToMile(double ft)
	{
		double convertedValue;
		convertedValue = ft / 5280.0;
		return convertedValue;
	}

	public static double mToMile(double m)
	{
		double convertedValue;
		convertedValue = m / 1600.0;
		return convertedValue;
	}
	
	public static Double[] convertDistance(int index, double val){
		Double[] d = new Double[5];
		double baseValue = 0.0; // always in meters
		
		switch(index){
		case 0: baseValue = ftToM(val); // feet
			break;
		case 1: baseValue = inchtoCm(val) * 0.01; // inches
			break;
		case 2: baseValue = mileToM(val); // miles
			break;
		case 3: baseValue = val * 0.01; // centimeters
			break;
		case 4: baseValue = val; // meters
			break;
		}
		
		d[0] = mToFt(baseValue);
		d[1] = cmToInch(baseValue * 100.0);
		d[2] = mToMile(baseValue);
		d[3] = baseValue * 100.0;
		d[4] = baseValue;
		
		return d;
	}
	// ********* Pressure Conversions *********
	public static double atmToPsi(double atm)
	{
		double convertedValue;
		convertedValue = atm * 14.7;
		return convertedValue;
	}
	
	public static double atmToMmhg(double atm)
	{
		double convertedValue;
		convertedValue = atm * 760;
		return convertedValue;
	}

	public static double atmToFtWater(double atm)
	{
		double convertedValue;
		convertedValue = atm * 33.93;
		return convertedValue;
	}
	
	public static double psiToAtm(double psi)
	{
		double convertedValue;
		convertedValue = psi / 14.7;
		return convertedValue;
	}

	public static double mmHgToAtm(double mmhg)
	{
		double convertedValue;
		convertedValue = mmhg / 760.0;
		return convertedValue;
	}

	public static double ftWaterToAtm(double ft)
	{
		double convertedValue;
		convertedValue = ft / 33.93;
		return convertedValue;
	} 
	
	public static Double[] convertPressure(int index, double val){
		Double[] d = new Double[4];
		double baseValue = 0.0; // always in atm
		
		switch(index){
		case 0: baseValue = val; //atm
			break;
		case 1: baseValue = psiToAtm(val); //psi
			break;
		case 2: baseValue = mmHgToAtm(val);//mm Hg
			break;
		case 3: baseValue = ftWaterToAtm(val); //feet of water
			break;
		}
		
		d[0] = baseValue;
		d[1] = atmToPsi(baseValue);
		d[2] = atmToMmhg(baseValue);
		d[3] = atmToFtWater(baseValue);
	
		
		return d;
	}
	
	public void dummyMethod(){};
	
	public Conversions(){
		conversionMethods = new Method[10];
		try {
			conversionMethods[0]= this.getClass().getMethod(
					"convertVolume", Integer.TYPE, Double.TYPE); //volume
			
			conversionMethods[1]= this.getClass().getMethod(
					"convertDistance", Integer.TYPE, Double.TYPE); //distance
			
			conversionMethods[2]= this.getClass().getMethod(
					"convertPressure", Integer.TYPE, Double.TYPE); //pressure
			
			conversionMethods[3]= this.getClass().getMethod(
					"convertMass", Integer.TYPE, Double.TYPE); //mass
			
			conversionMethods[4]= this.getClass().getMethod(
					"convertTemperature", Integer.TYPE, Double.TYPE); //temperature
			
			conversionMethods[10]= this.getClass().getMethod(
					"dummyMethod", Integer.TYPE, Double.TYPE); //constants
			
		} catch (NoSuchMethodException e) {
		} catch (SecurityException e) {
		} 
	}
	
	public Method getMethod(int index){
		
		return conversionMethods[index-1];
	}
}
