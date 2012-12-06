package com.aiha.aiha_calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.aiha.aiha_calc.EquationList.EqnMenuItem;
import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGColors;
import com.larvalabs.svgandroid.SVGParser;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class EquationItemAdapter extends ArrayAdapter<EqnMenuItem>
{
	private FragmentActivity activity;
	private EquationList equationList;
	private ArrayList<EqnMenuItem> menuItems;

	public EquationItemAdapter(FragmentActivity activity, int textViewResourceId, ArrayList<EqnMenuItem> menuItems)
	{
		super(activity, textViewResourceId, menuItems);
		this.activity = activity;
		this.menuItems = menuItems;

	}

	public static class ViewHolder
	{
		public TextView eqn_number;
		public ImageView eqn_image;
	}

	@Override
	@TargetApi(11)
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View row = convertView;
		ViewHolder holder;
		if (row == null)
		{
			LayoutInflater vi = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = vi.inflate(R.layout.menu_list_grid, null);
			holder = new ViewHolder();
			
			if (android.os.Build.VERSION.RELEASE.startsWith("3.") ||
					  android.os.Build.VERSION.RELEASE.startsWith("4."))
				 {
					row.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
				 }
			//holder.eqn_number = (TextView) row.findViewById(R.id.number);

			holder.eqn_image = (ImageView) row.findViewById(R.id.image);

			row.setTag(holder);
		}
		else
			holder = (ViewHolder) row.getTag();

		// final EqnMenuItem menuitem = menuItems.get(position);
		EqnMenuItem menuitem = menuItems.get(position);
		if (menuitem != null)
		{
			//holder.eqn_number.setText(Integer.toString(menuitem.number));

			// holder.eqn_image.setText("img=" + menuitem.graphic_name);
			 
			//int svg_resid = activity.getResources().getIdentifier("aiha_tag_white" ,"drawable" ,activity.getPackageName());
			
			SVG svg = SVGParser.getSVGFromResource(activity.getResources(), menuitem.graphic_id, 0xff000000, 0xffffffff);

			holder.eqn_image.setImageDrawable(svg.createPictureDrawable());

		}
		return row;
	}

	/*@Override
	 * public View getView(int position, View convertView, ViewGroup parent)
	 * {
	 * // TODO fix getView
	 * //Auto-generated method stub
	 * //return super.getView(position, convertView, parent);
	 * 
	 * View row = convertView;
	 * 
	 * if (row == null)
	 * {
	 * LayoutInflater inflater = getLayoutInflater();
	 * row = inflater.inflate(R.layout.row, parent, false);
	 * }
	 * 
	 * TextView label = (TextView) row.findViewById(R.id.weekofday);
	 * label.setText(month[position]);
	 * ImageView icon = (ImageView) row.findViewById(R.id.icon);
	 * 
	 * if (month[position] == "December")
	 * {
	 * icon.setImageResource(R.drawable.icon);
	 * }
	 * else
	 * {
	 * icon.setImageResource(R.drawable.icongray);
	 * }
	 * 
	 * return row;
	 * } */

}
