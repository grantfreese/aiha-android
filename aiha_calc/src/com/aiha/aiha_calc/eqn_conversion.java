package com.aiha.aiha_calc;

public abstract class eqn_conversion
{
	// private data members
	private double base_number;
	private String input_unit;
	

	//public methods	
	public eqn_conversion(String input_unit, double base_number)
	{
		this.base_number = base_number;
		this.input_unit = input_unit;
	}
	
	public double get_unit(String unit)
	{
		//calculate output value
		double output_value = get_factor(unit) * base_number;
		return output_value;
	}
	
	//private classes
	public static double get_factor(String unit)
	{
		
		
		/***************
		 * base units list:
		 * 
		 * volume			- meters^3
		 * distance			- meters
		 * pressure			- Pa (pascal)
		 * mass				- grams
		 * temperature		- deg K
		 * area				- meters^2
		 * oem				- ???
		 * concentration	- mol/m^3 ???
		 * flowrate			- meters^3 / second
		 * constants		- N/A
		 */
		
		double multiplication_factor;
		
		//TODO: make map of multiplication factors 
		//ideally use a map class to map unit types to a multiplication modifier
		
		//multiplication factor * base_type = output unit
		//eg, factor_inch = 0.03937007874015748031496062992126
		// so 92 mm * factor_inch = 3.622 inch
		// or, 34 inch / factor_inch = 863.6mm
		
		
		multiplication_factor = 1; //temporary
		
		//return multiplication_factor
		return multiplication_factor;	
	}
	
	//nested classes
	public class conv_volume extends eqn_conversion
	{
		public conv_volume(String new_unit, double new_number)
		{
			super(new_unit, (get_factor(new_unit) * new_number));
		}
	}

	public class conv_distance extends eqn_conversion
	{
		public conv_distance(String new_unit, double new_number)
		{
			super(new_unit, (get_factor(new_unit) * new_number));
		}
	}

	public class conv_pressure extends eqn_conversion
	{
		public conv_pressure(String new_unit, double new_number)
		{
			super(new_unit, (get_factor(new_unit) * new_number));
		}
	}

	public class conv_mass extends eqn_conversion
	{
		public conv_mass(String new_unit, double new_number)
		{
			super(new_unit, (get_factor(new_unit) * new_number));
		}
	}

	public class conv_temperature extends eqn_conversion
	{
		public conv_temperature(String new_unit, double new_number)
		{
			super(new_unit, (get_factor(new_unit) * new_number));
		}
	}

	public class conv_area extends eqn_conversion
	{
		public conv_area(String new_unit, double new_number)
		{
			super(new_unit, (get_factor(new_unit) * new_number));
		}
	}

	public class conv_oem extends eqn_conversion
	{
		public conv_oem(String new_unit, double new_number)
		{
			super(new_unit, (get_factor(new_unit) * new_number));
		}
	}

	public class conv_concentration extends eqn_conversion
	{
		public conv_concentration(String new_unit, double new_number)
		{
			super(new_unit, (get_factor(new_unit) * new_number));
		}
	}

	public class conv_flowrate extends eqn_conversion
	{
		public conv_flowrate(String new_unit, double new_number)
		{
			super(new_unit, (get_factor(new_unit) * new_number));
		}
	}

	public class conv_constants extends eqn_conversion
	{
		public conv_constants(String new_unit, double new_number)
		{
			super(new_unit, (get_factor(new_unit) * new_number));
		}
	}

}
