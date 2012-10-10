public class ExposureAssessment {
	
	public static double silicaRespirableFraction(double qrtz, double crist, double trid)
	{
		double part1;
		part1 = (qrtz + (crist * 2.0) + (trid * 2.0) + 2.0);
		part1 = (10.0/part1);
		return part1;
	}

	public static double silicaTotalDust(double qrtz, double crist, double trid)
	{
	    
	    double part1;
	    part1 = (qrtz + (crist * 2.0) + (trid * 2.0) + 2.0);
	    part1 = (30.0 / part1);
	    return part1;
	}

	//Multivariable functionality, possiblity have the user entire in N as the number of pairs
	//they want to use
	//Then generate the N number of pairs of input boxes
	//Then call this function taking in N, the N pairs of input.
	public static double OELofMixtureMultiVar(double c1, double t1, double c2, double t2)
	{
		double part1;
	    if(c2 == 0.0 || t2 == 0.0)
	    	part1 =  ((c1/t1));
	    else
	    	part1 =  ((c1/t1)+(c2/t2));

	    return part1;
	}
}
