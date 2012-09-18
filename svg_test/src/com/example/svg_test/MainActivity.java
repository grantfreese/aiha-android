package com.example.svg_test;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity
{

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		
        // Create a new ImageView
        ImageView imageView = new ImageView(this);
        
        // Set the background color to white
        imageView.setBackgroundColor(Color.WHITE);
        
        // Parse the SVG file from the resource
        SVG svg = SVGParser.getSVGFromResource(getResources(), R.raw.android);
        
        // Get a drawable from the parsed SVG and set it as the drawable for the ImageView
        imageView.setImageDrawable(svg.createPictureDrawable());
        
        // Set the ImageView as the content view for the Activity
        setContentView(imageView);
		
		//setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.activity_main, menu);
		

		
		return true;
	}
}
