
public class Conversions {
	
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
	
	public static double grainsToGrams(double grams)
	{
		double convertedValue;
		convertedValue = grams / 15.43;
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

	public static double cToF(double c)
	{
		double convertedValue;
		convertedValue = (c*(9.0 / 5.0)) + 32.0;
		return convertedValue;
	}

	public static double rToF(double r)
	{
		double convertedValue;
		convertedValue = r - 460.0;
		return convertedValue;
	}
	
	public static double fToR(double f)
	{
		double convertedValue;
		convertedValue = f + 460.0;
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
}
