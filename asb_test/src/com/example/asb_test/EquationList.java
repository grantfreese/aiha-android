package com.example.asb_test;

import java.util.Vector;

import android.content.Context;
import android.graphics.Color;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

public class EquationList
{
	private Vector<EqnMenuItem> menuItems;

	private static final int TAB_CONVERT = 1; // probably won't be used, but just in case..
	private static final int TAB_NOISE = 2;
	private static final int TAB_HEAT = 3;
	private static final int TAB_VENT = 4;
	private static final int TAB_EXPOS = 5;

	EquationList()
	{
		menuItems = new Vector<EqnMenuItem>();

		// add menu items
		menuItems.add(new EqnMenuItem(TAB_NOISE, 1, "eqn_noise_01", Color.BLACK, Color.WHITE));
		menuItems.add(new EqnMenuItem(TAB_NOISE, 2, "eqn_noise_02", Color.BLACK, Color.WHITE));
		menuItems.add(new EqnMenuItem(TAB_NOISE, 3, "eqn_noise_03", Color.BLACK, Color.WHITE));
		menuItems.add(new EqnMenuItem(TAB_NOISE, 4, "eqn_noise_04", Color.BLACK, Color.WHITE));
		menuItems.add(new EqnMenuItem(TAB_NOISE, 5, "eqn_noise_05", Color.BLACK, Color.WHITE));

	}

	public class EqnMenuItem
	{
		public int tab;
		public int number;
		public String graphic_name;
		public int graphic_bg_color;
		public int graphic_fg_color;

		public EqnMenuItem(int tab, int number, String graphic_name, int graphic_bg_color, int graphic_fg_color)
		{
			this.tab = tab;
			this.number = number;
			//this.graphic_name = SVGParser.getSVGFromResource(c.getResources(), c.getResources().getIdentifier(graphic_name, "SVG", c.getPackageName()));
			this.graphic_name = graphic_name;
			this.graphic_bg_color = graphic_bg_color;
			this.graphic_fg_color = graphic_fg_color;
		}
	}
	
	public Vector<EqnMenuItem> getVect()
	{
		return menuItems;
	}
}
