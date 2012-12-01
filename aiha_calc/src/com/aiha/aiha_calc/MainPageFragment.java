package com.aiha.aiha_calc;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragment;
import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.annotation.TargetApi;
import android.graphics.Color;

public class MainPageFragment extends SherlockFragment
{

	@TargetApi(11)
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{

		View V = inflater.inflate(R.layout.test, container, false);
		ImageView imageView = (ImageView) V.findViewById(R.id.AIHAtestImage);
		// imageView.setBackgroundColor(Color.BLUE); // Set the background color
		SVG svg = SVGParser.getSVGFromResource(getResources(), R.raw.aiha_tag_white);
		imageView.setImageDrawable(svg.createPictureDrawable());
		
		if (android.os.Build.VERSION.RELEASE.startsWith("3.") ||
				  android.os.Build.VERSION.RELEASE.startsWith("4."))
			 {
				V.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
			 }
		
		return V;
	}

}// end class
