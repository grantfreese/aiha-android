package com.example.asb_test;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.ActionBar;

public class MainActivity extends SherlockFragmentActivity implements ActionBar.TabListener
{

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		// getSupportActionBar().setDisplayUseLogoEnabled(false);
		// getSupportActionBar().setDisplayShowTitleEnabled(true);
		// getSupportActionBar().setDisplayShowHomeEnabled(true);
		// getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		ActionBar.Tab newTab0 = getSupportActionBar().newTab();
		newTab0.setText("AIHA");

		ActionBar.Tab newTab1 = getSupportActionBar().newTab();
		newTab1.setText("Noise");

		ActionBar.Tab newTab2 = getSupportActionBar().newTab();
		newTab2.setText("Heat Stress");

		ActionBar.Tab newTab3 = getSupportActionBar().newTab();
		newTab3.setText("Ventilation");

		ActionBar.Tab newTab4 = getSupportActionBar().newTab();
		newTab4.setText("Exposure Assessment");

		ActionBar.Tab newTab5 = getSupportActionBar().newTab();
		newTab5.setText("Unit Conversion");

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
