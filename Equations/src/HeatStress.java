
public class HeatStress {
	public static double wetBulbGlobeTempOutdoors(double tnwb_o, double tg_o, double tdb_o)
	{
		double temp;
		double tnwb = tnwb_o;
		double tg = tg_o;
		double tdb = tdb_o;
		
		temp = ((.7*tnwb) + (.2*tg) + (.1*tdb));
		
		return temp;
	}
	
	public static double wetBulbGlobeTempIndoors(double tnwb_o, double tg_o)
	{
		double temp;
		double tnwb = tnwb_o;
		double tg = tg_o;
		
		temp = ((.7*tnwb) + (.3*tg));
		
		return temp;
	}
	
	
	
}
