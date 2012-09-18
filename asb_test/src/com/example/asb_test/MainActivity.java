package com.example.asb_test;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.ImageView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.ActionBar;
import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

public class MainActivity extends SherlockFragmentActivity implements ActionBar.TabListener
{
	public static int THEME = R.style.Theme_Aiha_Light;
	

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		setTheme(THEME);
		
		super.onCreate(savedInstanceState);
		

		//configure actionbar to hide logo and use tabs
		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		getSupportActionBar().setDisplayUseLogoEnabled(false);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		getSupportActionBar().setDisplayShowHomeEnabled(false);
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);

		//create tabs for actionbar
		ActionBar.Tab newTab0 = getSupportActionBar().newTab().setText("AIHA");
		ActionBar.Tab newTab1 = getSupportActionBar().newTab().setText("Convert");
		ActionBar.Tab newTab2 = getSupportActionBar().newTab().setText("Noise");
		ActionBar.Tab newTab3 = getSupportActionBar().newTab().setText("Heat");
		ActionBar.Tab newTab4 = getSupportActionBar().newTab().setText("Ventilation");
		ActionBar.Tab newTab5 = getSupportActionBar().newTab().setText("Exposure");
		
		newTab0.setTabListener(this);
		newTab1.setTabListener(this);
		newTab2.setTabListener(this);
		newTab3.setTabListener(this);
		newTab4.setTabListener(this);
		newTab5.setTabListener(this);

		getSupportActionBar().addTab(newTab0);
		getSupportActionBar().addTab(newTab1);
		getSupportActionBar().addTab(newTab2);
		getSupportActionBar().addTab(newTab3);
		getSupportActionBar().addTab(newTab4);
		getSupportActionBar().addTab(newTab5);
		
		//temporary: display AIHA image on home screen
		
        
        ImageView imageView = new ImageView(this);	// Create a new ImageView
        
        //imageView.setBackgroundColor(Color.RED);	// Set the background color to white
       
        SVG svg = SVGParser.getSVGFromResource(getResources(), R.raw.aiha_tag_white); // Parse the SVG file from the resource
        
        imageView.setImageDrawable(svg.createPictureDrawable());// Get a drawable from the parsed SVG and set it as the drawable for the ImageView
        
		setContentView(imageView);// Set the ImageView as the content view for the Activity
		
		
		
		

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft)
	{
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft)
	{
		toastText("tab " + String.valueOf(tab.getPosition()) + " clicked");
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft)
	{
	}

	private void toastText(String message)
	{
		Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
	}

}
