package com.aiha.aiha_calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.aiha.aiha_calc.EquationList.EqnMenuItem;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
		public TextView item1;
		public TextView item2;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View row = convertView;
		ViewHolder holder;
		if (row == null)
		{
			LayoutInflater vi = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = vi.inflate(R.layout.menu_list_grid, null);
			holder = new ViewHolder();
			holder.item1 = (TextView) row.findViewById(R.id.number);
			holder.item2 = (TextView) row.findViewById(R.id.image);
			row.setTag(holder);
		}
		else
			holder = (ViewHolder) row.getTag();

		//final EqnMenuItem menuitem = menuItems.get(position);
		EqnMenuItem menuitem = menuItems.get(position);
		if (menuitem != null)
		{
			holder.item1.setText("num=" + Integer.toString(menuitem.number));
			holder.item2.setText("img=" + menuitem.graphic_name);
		}
		return row;
	}

	/*
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		// TODO fix getView 
		//Auto-generated method stub
		//return super.getView(position, convertView, parent);

		View row = convertView;

		if (row == null)
		{
			LayoutInflater inflater = getLayoutInflater();
			row = inflater.inflate(R.layout.row, parent, false);
		}

		TextView label = (TextView) row.findViewById(R.id.weekofday);
		label.setText(month[position]);
		ImageView icon = (ImageView) row.findViewById(R.id.icon);

		if (month[position] == "December")
		{
			icon.setImageResource(R.drawable.icon);
		}
		else
		{
			icon.setImageResource(R.drawable.icongray);
		}

		return row;
	}*/

}
