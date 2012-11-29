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

	private eqn_heat heatObj;
	private eqn_noise noiseObj;
	private eqn_vent ventObj;
	private eqn_expos exposObj;
	
	private static final int TAB_AIHA = 0;		//probably won't be used, but just in case..
	private static final int TAB_CONVERT = 1;	//probably won't be used, but just in case..
	private static final int TAB_NOISE = 2;
	private static final int TAB_HEAT = 3;
	private static final int TAB_VENT = 4;
	private static final int TAB_EXPOS = 5;

	EquationList()
	{
		tab_convert = new ArrayList<EqnMenuItem>();
		tab_noise = new ArrayList<EqnMenuItem>();
		tab_heat = new ArrayList<EqnMenuItem>();
		tab_vent = new ArrayList<EqnMenuItem>();
		tab_expos = new ArrayList<EqnMenuItem>();
		
		noiseObj = new eqn_noise();
		heatObj = new eqn_heat();
		ventObj = new eqn_vent();
		exposObj = new eqn_expos();
		

		// add menu items
		//index_number, image_name, count_var, 
		tab_convert.add(new EqnMenuItem(1, R.raw.eqn_expos_01, 3,
				new String[]{"qrtz", "", "crist", "", "trid", ""}, exposObj.getMethod(1)));
		/*
		tab_convert.add(new EqnMenuItem(1, R.raw.conv_volume));
		tab_convert.add(new EqnMenuItem(2, R.raw.conv_distance));
		tab_convert.add(new EqnMenuItem(3, R.raw.conv_pressure));
		tab_convert.add(new EqnMenuItem(4, R.raw.conv_mass));
		tab_convert.add(new EqnMenuItem(5, R.raw.conv_temperature));
		tab_convert.add(new EqnMenuItem(6, R.raw.conv_area));
		tab_convert.add(new EqnMenuItem(7, R.raw.conv_oem));
		tab_convert.add(new EqnMenuItem(8, R.raw.conv_concentration));
		tab_convert.add(new EqnMenuItem(9, R.raw.conv_flowrate));
		tab_convert.add(new EqnMenuItem(10, R.raw.conv_constants));
		*/
		
		// Noise /////////////////////////////////////////////////////
		tab_noise.add(new EqnMenuItem(1, R.raw.eqn_noise_01, 2, 
				new String[]{"N", "decibels", "SPLi", "decibels"},noiseObj.getMethod(1)));
		
		tab_noise.add(new EqnMenuItem(2, R.raw.eqn_noise_02, 1, 
				new String[]{"L", "decibels"}, noiseObj.getMethod(2)));

		tab_noise.add(new EqnMenuItem(3, R.raw.eqn_noise_03, 1, 
				new String[]{"L", "hours"}, noiseObj.getMethod(3)));
		
		tab_noise.add(new EqnMenuItem(4, R.raw.eqn_noise_04, 3, 
				new String[]{"I1", "watts/m2", "D1", "meters", "D2", "meters"}, noiseObj.getMethod(4)));
		
		tab_noise.add(new EqnMenuItem(5, R.raw.eqn_noise_05, 1, 
				new String[]{"%Dose", "%"}, noiseObj.getMethod(5)));
		
		// Heat //////////////////////////////////////////////////////
		tab_heat.add(new EqnMenuItem(1, R.raw.eqn_heat_01, 3,
				new String[]{"tnwb", "Degrees F", "tg", "Degrees F", "db", "Degrees F"}, heatObj.getMethod(1)));
		
		tab_heat.add(new EqnMenuItem(2, R.raw.eqn_heat_02, 2,
				new String[]{"tnwb", "Degrees F", "tg", "Degrees F"}, heatObj.getMethod(2)));
		
		// Ventilation ///////////////////////////////////////////////
		tab_vent.add(new EqnMenuItem(1, R.raw.eqn_vent_01, 4,
				new String[]{"gas", "liters", "density", "grams/cm3", "mw", "grams", "roomVolume", "feet3"},ventObj.getMethod(1)));
		
		tab_vent.add(new EqnMenuItem(2, R.raw.eqn_vent_02, 2,
				new String[]{"qVal", "cfm", "volume", "feet3"},ventObj.getMethod(2)));
		
		tab_vent.add(new EqnMenuItem(3, R.raw.eqn_vent_03, 2,
				new String[]{"VP", "", "SP", ""},ventObj.getMethod(3)));
		
		tab_vent.add(new EqnMenuItem(4, R.raw.eqn_vent_04, 5,
				new String[]{"Qind", "L/min", "Pc", "kPa", "Ts", "kPsa", "Ps", "", "Tc", ""},ventObj.getMethod(4)));
		
		tab_vent.add(new EqnMenuItem(5, R.raw.eqn_vent_05, 1,
				new String[]{"VP", "in. WC"},ventObj.getMethod(5)));
		
		tab_vent.add(new EqnMenuItem(6, R.raw.eqn_vent_06, 2,
				new String[]{"VPd", "in. WC", "he", "in. WC"},ventObj.getMethod(6)));
		
		tab_vent.add(new EqnMenuItem(7, R.raw.eqn_vent_07, 4,
				new String[]{"G", "cfm", "Q", "cfm", "t", "minutes", "N", "changes/hour"},ventObj.getMethod(7)));
		
		
		tab_vent.add(new EqnMenuItem(8, R.raw.eqn_vent_08, 5,
				new String[]{"SG", "", "ER", "pints/min", "K", "", "MW", "g", "C", "ppm"},ventObj.getMethod(8)));
		
		tab_vent.add(new EqnMenuItem(9, R.raw.eqn_vent_09, 3,
				new String[]{"SPout", "in. WC", "SPin", "in. WC", "VPin", "in. WC"},ventObj.getMethod(9)));
		
		tab_vent.add(new EqnMenuItem(10, R.raw.eqn_vent_10, 2,
				new String[]{"TPout", "in. WC", "TPin", "in. WC"},ventObj.getMethod(10)));
		
		tab_vent.add(new EqnMenuItem(11, R.raw.eqn_vent_11, 5,
				new String[]{"size1", "inches", "size2", "inches", "RPM1", "rpm", "RPM2", "rpm", "Q", "cfm"},ventObj.getMethod(11)));
		
		// Exposure //////////////////////////////////////////////////
		tab_expos.add(new EqnMenuItem(1, R.raw.eqn_expos_01, 3,
				new String[]{"qrtz", "%", "crist", "%", "trid", "%"},exposObj.getMethod(1)));
		
		tab_expos.add(new EqnMenuItem(2, R.raw.eqn_expos_02, 3,
				new String[]{"qrtz", "%", "crist", "%", "trid", "%"},exposObj.getMethod(2)));
		
		tab_expos.add(new EqnMenuItem(3, R.raw.eqn_expos_03, 4,
				new String[]{"C1", "ppm", "T1", "ppm", "C2", "ppm", "T2", "ppm"},exposObj.getMethod(3)));

	}

	public class EqnMenuItem
	{
		public int number;
		public int graphic_id;
		public int num_of_variables;
		public EqnUnits[] unitList;
		public Method eqnMethod;

		public EqnMenuItem(int number, int graphic_id, int num_of_variables, String[] units, Method eqnMethod)
		{
			this.number = number;
			// this.graphic_name = SVGParser.getSVGFromResource(c.getResources(), c.getResources().getIdentifier(graphic_name, "SVG", c.getPackageName()));
			this.graphic_id = graphic_id;
			this.num_of_variables = num_of_variables;
			this.eqnMethod = eqnMethod;
			unitList = new EqnUnits[units.length/2];
			
			for(int i = 0 ; i< unitList.length; i++){
				unitList[i] = new EqnUnits("variable", "unit");
			}
			
			int k = 0;
			for(int j = 0 ; j < units.length; j++){
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

	public ArrayList<EqnMenuItem> getEqns(int tab_number)
	{
		ArrayList<EqnMenuItem> menuItems;
		menuItems = null;

		switch (tab_number)
		{
		case TAB_AIHA:
			menuItems = null;	//change to tab_aiha later if needed (probably not)
			System.out.println("getVect using TAB_AIHA (null)");
			break;
		case TAB_CONVERT:
			menuItems = tab_convert;	//change to tab_convert later if needed
			System.out.println("getVect using TAB_CONVERT (null)");
			break;
		case TAB_NOISE:
			menuItems = tab_noise;
			System.out.println("getVect using TAB_NOISE");
			break;
		case TAB_HEAT:
			menuItems = tab_heat;
			System.out.println("getVect using TAB_HEAT");
			break;
		case TAB_VENT:
			menuItems = tab_vent;
			System.out.println("getVect using TAB_VENT");
			break;
		case TAB_EXPOS:
			menuItems = tab_expos;
			System.out.println("getVect using TAB_EXPOS");
			break;
		default:
			//should not occur
			break;

		}

		return menuItems;
	}
}
