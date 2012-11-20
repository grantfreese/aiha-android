package com.aiha.aiha_calc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
//import com.actionbarsherlock.sample.fragments.R;
//import com.actionbarsherlock.sample.fragments.FragmentStackSupport.CountingFragment;

public class ConvertFragment extends SherlockFragment
{
	int mNum;

	/**
	 * Create a new instance of CountingFragment, providing "num" as an
	 * argument.
	 */
	ConvertFragment newInstance(int num)
	{
		ConvertFragment f = new ConvertFragment();

		// Supply num input as an argument.
		//Bundle args = new Bundle();
		//args.putInt("num", num);
		//f.setArguments(args);

		return f;
	}

	/**
	 * When creating, retrieve this instance's number from its arguments.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//mNum = getArguments() != null ? getArguments().getInt("num") : 1;
	}

	/**
	 * The Fragment's UI is just a simple text view showing its instance number.
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View v = inflater.inflate(R.layout.hello_world, container, false);
		View tv = v.findViewById(R.id.text);
		((TextView) tv).setText("Fragment #" + mNum);
		tv.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.gallery_thumb));
		return v;
	}
}