package com.aiha.aiha_calc;

import java.util.ArrayList;
import java.lang.reflect.Method;

import android.content.Context;
import android.graphics.Color;

import com.aiha.aiha_calc.R;
import com.aiha.aiha_calc.EquationList.EqnMenuItem;
import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

public class EquationList
{
	private ArrayList<EqnMenuItem> tab_convert;
	private ArrayList<EqnMenuItem> tab_noise;
	private ArrayList<EqnMenuItem> tab_heat;
	private ArrayList<EqnMenuItem> tab_vent;
	private ArrayList<EqnMenuItem> tab_expos;
	private ArrayList<EqnMenuItem> tab_init_convert;	// dummy array used for conversion tab manipulation
	private ArrayList<EqnMenuItem> tab_oel;
	private ArrayList<EqnMenuItem> tab_concen;
	private ArrayList<EqnMenuItem> tab_flow;
	

	private eqn_heat heatObj;
	private eqn_noise noiseObj;
	private eqn_vent ventObj;
	private eqn_expos exposObj;
	private Conversions convObj;

	private static final int TAB_AIHA = 0;		// probably won't be used, but just in case..
	private static final int TAB_CONVERT = 1;	// probably won't be used, but just in case..
	private static final int TAB_NOISE = 2;
	private static final int TAB_HEAT = 3;
	private static final int TAB_VENT = 4;
	private static final int TAB_EXPOS = 5;
	private static final int TAB_INIT_CONVERT = 6;
	private static final int TAB_OEL = 7;
	private static final int TAB_CONCEN = 8;
	private static final int TAB_FLOW = 9;

	EquationList()
	{
		tab_convert = new ArrayList<EqnMenuItem>();
		tab_noise = new ArrayList<EqnMenuItem>();
		tab_heat = new ArrayList<EqnMenuItem>();
		tab_vent = new ArrayList<EqnMenuItem>();
		tab_expos = new ArrayList<EqnMenuItem>();
		tab_init_convert = new ArrayList<EqnMenuItem>();
		tab_oel = new ArrayList<EqnMenuItem>();
		tab_concen = new ArrayList<EqnMenuItem>();
		tab_flow = new ArrayList<EqnMenuItem>();

		noiseObj = new eqn_noise();
		heatObj = new eqn_heat();
		ventObj = new eqn_vent();
		exposObj = new eqn_expos();
		convObj = new Conversions();

		// Add menu items in tabs

		/*** Conversion *****************************************************************************/
	
		tab_convert.add(new EqnMenuItem(1, R.raw.eqn_conv_01, 5, new String[]{ "","cubic feet","","cubic cm", "","cubic inches", "", "liters","","quarts"}, "", convObj.getMethod(1))); //volume
		tab_convert.add(new EqnMenuItem(2, R.raw.eqn_conv_02, 5, new String[]{ "","feet","","inches", "","miles", "", "centimeters","","meters"},"", convObj.getMethod(2))); //distance
		tab_convert.add(new EqnMenuItem(3, R.raw.eqn_conv_03, 4, new String[]{ "","atm","","psi", "","mm Hg", "", "ft of water"},"", convObj.getMethod(3))); //pressure
		tab_convert.add(new EqnMenuItem(4, R.raw.eqn_conv_04, 5, new String[]{ "","pounds","","kilograms", "","grams", "", "grains", "", "ounces"},"", convObj.getMethod(4))); //mass
		tab_convert.add(new EqnMenuItem(5, R.raw.eqn_conv_05, 5, new String[]{ "","\u00B0Farenheit","","\u00B0Celsius", "","\u00B0Rankine", "", "\u00B0Kelvin", "", "\u00B0Reaumer"},"", convObj.getMethod(5))); //temperature
		tab_convert.add(new EqnMenuItem(6, R.raw.eqn_conv_06, 3, new String[]{"Radius", "inches", "Diameter", "inches", "Area", "inches sq."},"", convObj.getMethod(6))); //area
		tab_convert.add(new EqnMenuItem(7, R.raw.eqn_conv_07, -1, new String[]{},"", convObj.getMethod(13))); //OEL - contains sub menu
		tab_convert.add(new EqnMenuItem(8, R.raw.eqn_conv_08, -1, new String[]{},"", convObj.getMethod(13))); //concentration - contains sub menu
		tab_convert.add(new EqnMenuItem(9, R.raw.eqn_conv_09, -1, new String[]{},"", convObj.getMethod(13))); //flow rate - contains sub menu
		tab_convert.add(new EqnMenuItem(10, R.raw.eqn_conv_10, 0, new String[]{},"", convObj.getMethod(13))); //constants - has no method

		
		/*** Noise *****************************************************************************/
		//Removed on orders from the mentor
		//tab_noise.add(new EqnMenuItem(1, R.raw.eqn_noise_01, 2, new String[] { "N", "decibels", "SPLi", "decibels" }, noiseObj.getMethod(1)));
		
		tab_noise.add(new EqnMenuItem(3, R.raw.eqn_noise_03, 1, new String[] { "SPL", "hours" },"hours", noiseObj.getMethod(3)));
		tab_noise.add(new EqnMenuItem(4, R.raw.eqn_noise_04, 3, new String[] { "I1", "watts/m2", "D1", "meters", "D2", "meters" },"watts/m2", noiseObj.getMethod(4)));
		tab_noise.add(new EqnMenuItem(5, R.raw.eqn_noise_05, 1, new String[] { "Dose", "" },"decibels", noiseObj.getMethod(5)));
		tab_noise.add(new EqnMenuItem(2, R.raw.eqn_noise_02, 1, new String[] { "SPL", "decibels" },"hours", noiseObj.getMethod(2)));
		
		/*** Heat *****************************************************************************/
		tab_heat.add(new EqnMenuItem(1, R.raw.eqn_heat_01, 3, new String[] { "tnwb", "\u00B0F", "tg", "\u00B0F", "db", "\u00B0F" },"\u00B0F", heatObj.getMethod(1)));
		tab_heat.add(new EqnMenuItem(2, R.raw.eqn_heat_02, 2, new String[] { "tnwb", "\u00B0F", "tg", "\u00B0F" },"\u00B0F",heatObj.getMethod(2)));
		tab_heat.add(new EqnMenuItem(3, R.raw.eqn_heat_03, 0, new String[]{},"", heatObj.getMethod(3))); // Heat Stress Table
		
		/*** Vent *****************************************************************************/
		//Removed on orders from the mentor
		//tab_vent.add(new EqnMenuItem(1, R.raw.eqn_vent_01, 4, new String[] { "gas volume", "liters", "gas density", "grams/cm3", "gas MW", "grams", "roomVolume", "feet3" },"%", ventObj.getMethod(1)));
		
		tab_vent.add(new EqnMenuItem(2, R.raw.eqn_vent_02, 2, new String[] { "Q", "cfm", "Volume", "feet3" },"AC/hr", ventObj.getMethod(2)));
		tab_vent.add(new EqnMenuItem(3, R.raw.eqn_vent_03, 2, new String[] { "VP", "", "SP", "" },"", ventObj.getMethod(3)));
		tab_vent.add(new EqnMenuItem(4, R.raw.eqn_vent_04, 5, new String[] { "Qind", "L/min", "Pc", "kPa", "Ts", "\u00B0K", "Ps", "kPa", "Tc", "\u00B0K" },"L/min", ventObj.getMethod(4)));
		tab_vent.add(new EqnMenuItem(5, R.raw.eqn_vent_05, 1, new String[] { "VP", "in. WC" },"ft/min", ventObj.getMethod(5)));
		
		//Removed on orders from the mentor
		//tab_vent.add(new EqnMenuItem(6, R.raw.eqn_vent_06, 2, new String[] { "VPd", "in. WC", "he", "in. WC" }, ventObj.getMethod(6)));
		
		tab_vent.add(new EqnMenuItem(7, R.raw.eqn_vent_07, 4, new String[] { "G", "CFM", "Q", "CFM", "t", "minutes", "N", "air changes/hour" },"ppm", ventObj.getMethod(7)));
		tab_vent.add(new EqnMenuItem(8, R.raw.eqn_vent_08, 5, new String[] { "SG", "", "ER", "pints/min", "K", "", "MW", "g", "C", "ppm" },"ft3/min", ventObj.getMethod(8)));
		tab_vent.add(new EqnMenuItem(9, R.raw.eqn_vent_09, 3, new String[] { "SPout", "in. WC", "SPin", "in. WC", "VPin", "in. WC" },"in. WC", ventObj.getMethod(9)));
		tab_vent.add(new EqnMenuItem(10, R.raw.eqn_vent_10, 2, new String[] { "TPout", "in. WC", "TPin", "in. WC" },"in. WC", ventObj.getMethod(10)));
		tab_vent.add(new EqnMenuItem(11, R.raw.eqn_vent_11, 5, new String[] { "Q1", "CFM", "Size1", "Inches", "Size2", "Inches", "RPM1", "", "RPM2", "" }, "CFM",ventObj.getMethod(11)));

		/*** Exposure *****************************************************************************/
		tab_expos.add(new EqnMenuItem(1, R.raw.eqn_expos_01, 3, new String[] { "%qrtz", "", "%crist", "", "%trid", "" },"PEL", exposObj.getMethod(1)));
		tab_expos.add(new EqnMenuItem(2, R.raw.eqn_expos_02, 3, new String[] { "%qrtz", "", "%crist", "", "%trid", "" },"PEL", exposObj.getMethod(2)));
		tab_expos.add(new EqnMenuItem(3, R.raw.eqn_expos_03, 4, new String[] { "C1", "ppm", "OEL1", "ppm", "C2", "ppm", "OEL2", "ppm" },"", exposObj.getMethod(3)));
		tab_expos.add(new EqnMenuItem(4, R.raw.missing_twa, 4, new String[] { "Ca", "ppm", "Ta", "minutes", "Cb", "ppm", "Tb", "minutes" },"ppm", exposObj.getMethod(4)));
		
		/*** Initial Conversion *****************************************************************************/
		tab_init_convert.add(new EqnMenuItem(1, R.raw.eqn_conv_01, -1, new String[]{"",""}, "", convObj.getMethod(1))); //dummy array for the conversion list
		
		/*** OEL Conversions *****************************************************************************/
		tab_oel.add(new EqnMenuItem(1, R.raw.to_ppm, 2, new String[]{"mg","gram weight", "ppm", "OEL in ppm"}, "OEL(mg/m3)", convObj.getMethod(7)));
		tab_oel.add(new EqnMenuItem(2, R.raw.from_ppm, 2, new String[]{"OEL","gram weight", "mg","OEL in mg/m3"}, "OEL(ppm)", convObj.getMethod(8)));
		
		/*** Concentration Conversions *****************************************************************************/
		tab_concen.add(new EqnMenuItem(1, R.raw.eqn_concen_01, 2, new String[]{"","grain/cubic ft", "", "g/cubic m"}, "", convObj.getMethod(9)));
		tab_concen.add(new EqnMenuItem(2, R.raw.eqn_concen_02, 2, new String[]{"","mppcf","","particles/cm3"}, "", convObj.getMethod(10)));
		
		/*** Flow Rate Conversions *****************************************************************************/
		tab_flow.add(new EqnMenuItem(1, R.raw.eqn_flow_01, 3, new String[]{"","cubic m/s", "", "cubic ft/min", "", "cubic cm/s"}, "", convObj.getMethod(11)));
		tab_flow.add(new EqnMenuItem(2, R.raw.eqn_flow_02, 2, new String[]{"","cubic ft/hr", "", "liters/min"}, "", convObj.getMethod(12)));
	}

	public class EqnMenuItem
	{
		public int number;
		public int graphic_id;
		public int num_of_variables;
		public String resultUnit;
		public EqnUnits[] unitList;
		public Method eqnMethod;

		public EqnMenuItem(int number, int graphic_id, int num_of_variables, String[] units, String result, Method eqnMethod)
		{
			this.number = number;
			// this.graphic_name = SVGParser.getSVGFromResource(c.getResources(), c.getResources().getIdentifier(graphic_name, "SVG", c.getPackageName()));
			this.graphic_id = graphic_id;
			this.num_of_variables = num_of_variables;
			this.eqnMethod = eqnMethod;
			this.resultUnit = result;
			unitList = new EqnUnits[units.length / 2];

			for (int i = 0; i < unitList.length; i++)
			{
				unitList[i] = new EqnUnits("variable", "unit");
			}

			int k = 0;
			for (int j = 0; j < units.length; j++)
			{
				unitList[k].variable = units[j];
				j++;
				unitList[k].unit = units[j];
				k++;
			}
		}
	}

	public class EqnUnits
	{
		public String variable, unit;

		public EqnUnits(String variable, String unit)
		{
			this.variable = variable;
			this.unit = unit;
		}
	}

	//TODO: remove debug prints
	public ArrayList<EqnMenuItem> getEqns(int tab_number)
	{
		ArrayList<EqnMenuItem> menuItems;
		menuItems = null;

		switch (tab_number)
		{
		case TAB_AIHA:
			menuItems = null;	// change to tab_aiha later if needed (probably not)
			break;
		case TAB_CONVERT:
			menuItems = tab_convert;// change to tab_convert later if needed
			break;
		case TAB_NOISE:
			menuItems = tab_noise;
			break;
		case TAB_HEAT:
			menuItems = tab_heat;
			break;
		case TAB_VENT:
			menuItems = tab_vent;
			break;
		case TAB_EXPOS:
			menuItems = tab_expos;
			break;
		case TAB_INIT_CONVERT:
			menuItems = tab_init_convert;
			break;
		case TAB_OEL:
			menuItems = tab_oel;
			break;
		case TAB_CONCEN:
			menuItems = tab_concen;
			break;
		case TAB_FLOW:
			menuItems = tab_flow;
			break;
		default:
			// should not occur
			break;

		}

		return menuItems;
	}
}
