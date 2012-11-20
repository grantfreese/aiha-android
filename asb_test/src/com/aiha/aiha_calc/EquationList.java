package com.aiha.aiha_calc;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

public class EquationList
{
	private ArrayList<EqnMenuItem> tab_convert;
	private ArrayList<EqnMenuItem> tab_noise;
	private ArrayList<EqnMenuItem> tab_heat;
	private ArrayList<EqnMenuItem> tab_vent;
	private ArrayList<EqnMenuItem> tab_expos;

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

		// add menu items
		//index_number, image_name, count_var, 
		
		tab_convert.add(new EqnMenuItem(1, "conv_volume"));
		tab_convert.add(new EqnMenuItem(2, "conv_distance"));
		tab_convert.add(new EqnMenuItem(3, "conv_pressure"));
		tab_convert.add(new EqnMenuItem(4, "conv_mass"));
		tab_convert.add(new EqnMenuItem(5, "conv_temperature"));
		tab_convert.add(new EqnMenuItem(6, "conv_area"));
		tab_convert.add(new EqnMenuItem(7, "conv_oem"));
		tab_convert.add(new EqnMenuItem(8, "conv_concentration"));
		tab_convert.add(new EqnMenuItem(9, "conv_flowrate"));
		tab_convert.add(new EqnMenuItem(10, "conv_constants"));
		
		tab_noise.add(new EqnMenuItem(1, "eqn_noise_01"));
		tab_noise.add(new EqnMenuItem(2, "eqn_noise_02"));
		tab_noise.add(new EqnMenuItem(3, "eqn_noise_03"));
		tab_noise.add(new EqnMenuItem(4, "eqn_noise_04"));
		tab_noise.add(new EqnMenuItem(5, "eqn_noise_05"));
		
		tab_heat.add(new EqnMenuItem(1, "eqn_heat_01"));
		tab_heat.add(new EqnMenuItem(2, "eqn_heat_02"));
		
		tab_vent.add(new EqnMenuItem(1, "eqn_vent_01"));
		tab_vent.add(new EqnMenuItem(2, "eqn_vent_02"));
		tab_vent.add(new EqnMenuItem(3, "eqn_vent_03"));
		tab_vent.add(new EqnMenuItem(4, "eqn_vent_04"));
		tab_vent.add(new EqnMenuItem(5, "eqn_vent_05"));
		tab_vent.add(new EqnMenuItem(6, "eqn_vent_06"));
		tab_vent.add(new EqnMenuItem(7, "eqn_vent_07"));
		tab_vent.add(new EqnMenuItem(8, "eqn_vent_08"));
		tab_vent.add(new EqnMenuItem(9, "eqn_vent_09"));
		tab_vent.add(new EqnMenuItem(10, "eqn_vent_10"));
		tab_vent.add(new EqnMenuItem(11, "eqn_vent_11"));
		
		tab_expos.add(new EqnMenuItem(1, "eqn_expos_01"));
		tab_expos.add(new EqnMenuItem(2, "eqn_expos_02"));
		tab_expos.add(new EqnMenuItem(3, "eqn_expos_03"));

	}

	public class EqnMenuItem
	{
		public int number;
		public String graphic_name;

		public EqnMenuItem(int number, String graphic_name)
		{
			this.number = number;
			// this.graphic_name = SVGParser.getSVGFromResource(c.getResources(), c.getResources().getIdentifier(graphic_name, "SVG", c.getPackageName()));
			this.graphic_name = graphic_name;
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