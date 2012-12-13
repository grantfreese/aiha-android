package com.aiha.aiha_calc;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TableRow.LayoutParams;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.SherlockListFragment;
import com.aiha.aiha_calc.EquationItemAdapter.ViewHolder;
import com.aiha.aiha_calc.EquationList;
import com.aiha.aiha_calc.EquationList.EqnMenuItem;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

/******************************************************************************
 * Class: FragmentLayoutSupport
 * 
 * 
 ******************************************************************************/
public class FragmentLayoutSupport extends SherlockFragmentActivity
{
	private static EquationList _equationList;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		if (_equationList == null)
		{
			_equationList = new EquationList(); // generates vector with menu data
		}

		setContentView(R.layout.fragment_layout_support);
	}

	/**************************************************************************
	 * Class: DetailsActivity
	 * 
	 * Fragment for small screens
	 **************************************************************************/
	public static class DetailsActivity extends SherlockFragmentActivity
	{

		DetailsFragment details;
		public static int THEME = R.style.Theme_Aiha_Light;

		@Override
		protected void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			setTheme(THEME);

			/*
			if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
			{
				// If the screen is now in landscape mode, we can show the
				// dialog in-line with the list so we don't need this activity.
				finish();
				return;
			}
			*/

			//hide actionbar in equation editor
			ActionBar bar = getSupportActionBar();			
			bar.hide();

			
			if (savedInstanceState == null)
			{
				// During initial setup, plug in the details fragment.
				details = new DetailsFragment();
				details.setArguments(getIntent().getExtras());
				getSupportFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
			}
		}
		

		
		
		public void calcButtonClick(View v)
		{
			details.calcButtonClick(v);
		}

		public void clearButtonClick(View v)
		{
			details.clearButtonClick(v);
		}
	}

	/**************************************************************************
	 * Class: ConvertListFragment
	 * 
	 * Top-level fragment showing list of conversion equations
	 **************************************************************************/
	public static class ConvertListFragment extends SherlockListFragment
	{
		boolean mDualPane;
		static boolean sublistSelected = false;
		int mCurCheckPosition = 0;
		final int FLOW_RATE = 9;
		String message = "hello!";

		EquationItemAdapter eqn_adapter_convert;
		EquationItemAdapter eqn_adapter_sublist;
		ArrayList<EqnMenuItem> list_convert;
		

		@Override
		public void onActivityCreated(Bundle savedInstanceState)
		{
			super.onActivityCreated(savedInstanceState);

			if (_equationList == null)
			{
				_equationList = new EquationList();
			}
			
			//TODO: obsolete?
			// stuff to get tab number
			int current_tab;
			SherlockFragmentActivity sherlockContext = getSherlockActivity();
			current_tab = sherlockContext.getSupportActionBar().getSelectedNavigationIndex();
			//TODO: obsolete?
			
			list_convert = _equationList.getEqns(1);

			// setListAdapter(new EquationItemAdapter(getActivity(), R.layout.menu_list_grid, list_temp) );
			// Populate list with our static array of titles.
			sublistSelected = false;
			if (list_convert != null)
			{
				eqn_adapter_convert = new EquationItemAdapter(getActivity(), R.layout.menu_list_grid, list_convert);
			}
			setListAdapter(eqn_adapter_convert);

			// Check to see if we have a frame in which to embed the details
			// fragment directly in the containing UI.
			View detailsFrame = getActivity().findViewById(R.id.details);
			mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

			if (savedInstanceState != null)
			{
				// Restore last state for checked position.
				mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
			}

			if (mDualPane)
			{
				System.out.println("ConvertListFragment mDualPane handler reached");
				
				// In dual-pane mode, the list view highlights the selected item.
				getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
				// Make sure our UI is in the correct state.
				showDetails(mCurCheckPosition);
			}
		}

		@Override
		public void onSaveInstanceState(Bundle outState)
		{
			super.onSaveInstanceState(outState);
			outState.putInt("curChoice", mCurCheckPosition);
		}

		@Override
		public void onListItemClick(ListView l, View v, int position, long id)
		{
			showDetails(position);
		}

		/**
		 * Helper function to show the details of a selected item, either by
		 * displaying a fragment in-place in the current UI, or starting a whole
		 * new activity in which it is displayed.
		 */
		void showDetails(int index)
		{
			mCurCheckPosition = index;

			if (mDualPane)
			{
				System.out.println("showDetails for mDualPane reached");
				// We can display everything in-place with fragments, so update
				// the list to highlight the selected item and show the data.
				getListView().setItemChecked(index, true);

				// Check what fragment is currently shown, replace if needed.
				DetailsFragment details = (DetailsFragment) getFragmentManager().findFragmentById(R.id.details);
				if (details == null || details.getShownIndex() != index)
				{
					// Make new fragment to show this selection.
					details = DetailsFragment.newInstance(index, 1);

					// Execute a transaction, replacing any existing fragment
					// with this one inside the frame.
					FragmentTransaction ft = getFragmentManager().beginTransaction();
					ft.replace(R.id.details, details);
					ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
					ft.commit();
				}

			}
			else
			{
				System.out.println("showDetails for !mDualPane reached");
				// Otherwise we need to launch a new activity to display
				// the dialog fragment with selected text.
				if(list_convert.get(index).num_of_variables == -1){
					
					
					int newList = list_convert.get(index).number;
					
					list_convert = _equationList.getEqns(2);
					eqn_adapter_convert = new EquationItemAdapter(getActivity(), R.layout.menu_list_grid, list_convert);
					
					//for(int i =0; i < list_convert.size(); i++){
					//	eqn_adapter_convert.add(list_convert.get(i));
					//}
					
					setListAdapter(eqn_adapter_convert);
					sublistSelected = true;
					eqn_adapter_convert.notifyDataSetChanged();
				
				}else{
					
					Intent intent = new Intent();
					intent.setClass(getActivity(), DetailsActivity.class);
					intent.putExtra("index", index);
					intent.putExtra("currentTab", 1);
					startActivity(intent);
				}
			}
		}
		
		public void backButtonPressed(){
			
			list_convert = _equationList.getEqns(1);
			eqn_adapter_convert.clear();
			
			System.out.println(list_convert.size());
			for(int i =0; i < list_convert.size(); i++){
				eqn_adapter_convert.add(list_convert.get(i));
			}
			
			setListAdapter(eqn_adapter_convert);
			System.out.println(message);
			sublistSelected = false;
			eqn_adapter_convert.notifyDataSetChanged();
		}
	}

	/**************************************************************************
	 * Class: NoiseListFragment
	 * 
	 * Top-level fragment showing list of noise equations
	 **************************************************************************/
	public static class NoiseListFragment extends SherlockListFragment
	{
		boolean mDualPane;
		int mCurCheckPosition = 0;

		EquationItemAdapter eqn_adapter_noise;
		ArrayList<EqnMenuItem> list_noise;

		@Override
		public void onActivityCreated(Bundle savedInstanceState)
		{
			super.onActivityCreated(savedInstanceState);

			if (_equationList == null)
			{
				_equationList = new EquationList();
			}

			// stuff to get tab number
			int current_tab;
			SherlockFragmentActivity sherlockContext = getSherlockActivity();
			current_tab = sherlockContext.getSupportActionBar().getSelectedNavigationIndex();

			list_noise = _equationList.getEqns(2);

			// setListAdapter(new EquationItemAdapter(getActivity(), R.layout.menu_list_grid, list_temp) );
			// Populate list with our static array of titles.
			if (list_noise != null)
			{
				eqn_adapter_noise = new EquationItemAdapter(getActivity(), R.layout.menu_list_grid, list_noise);
			}

			System.out.println("noise setListAdapter");
			setListAdapter(eqn_adapter_noise);

			// Check to see if we have a frame in which to embed the details
			// fragment directly in the containing UI.
			View detailsFrame = getActivity().findViewById(R.id.details);
			mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

			if (savedInstanceState != null)
			{
				// Restore last state for checked position.
				mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
			}

			if (mDualPane)
			{
				// In dual-pane mode, the list view highlights the selected item.
				// getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
				// Make sure our UI is in the correct state.
				// showDetails(mCurCheckPosition);
			}
		}

		@Override
		public void onSaveInstanceState(Bundle outState)
		{
			super.onSaveInstanceState(outState);
			outState.putInt("curChoice", mCurCheckPosition);
		}

		@Override
		public void onListItemClick(ListView l, View v, int position, long id)
		{
			showDetails(position);
		}

		/**
		 * Helper function to show the details of a selected item, either by
		 * displaying a fragment in-place in the current UI, or starting a whole
		 * new activity in which it is displayed.
		 */
		void showDetails(int index)
		{
			mCurCheckPosition = index;

			if (mDualPane)
			{
				// We can display everything in-place with fragments, so update
				// the list to highlight the selected item and show the data.
				getListView().setItemChecked(index, true);

				// Check what fragment is currently shown, replace if needed.
				DetailsFragment details = (DetailsFragment) getFragmentManager().findFragmentById(R.id.details);
				if (details == null || details.getShownIndex() != index)
				{
					// Make new fragment to show this selection.
					details = DetailsFragment.newInstance(index, 2);

					// Execute a transaction, replacing any existing fragment
					// with this one inside the frame.
					FragmentTransaction ft = getFragmentManager().beginTransaction();
					ft.replace(R.id.details, details);
					ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
					ft.commit();
				}

			}
			else
			{
				// Otherwise we need to launch a new activity to display
				// the dialog fragment with selected text.
				Intent intent = new Intent();
				intent.setClass(getActivity(), DetailsActivity.class);
				intent.putExtra("index", index);
				intent.putExtra("currentTab", 2);
				startActivity(intent);
			}
		}
	}

	/**************************************************************************
	 * Class: HeatListFragment
	 * 
	 * Top-level fragment showing list of heat equations
	 **************************************************************************/
	public static class HeatListFragment extends SherlockListFragment
	{
		boolean mDualPane;
		int mCurCheckPosition = 0;

		EquationItemAdapter eqn_adapter_heat;
		ArrayList<EqnMenuItem> list_heat;

		@Override
		public void onActivityCreated(Bundle savedInstanceState)
		{
			super.onActivityCreated(savedInstanceState);

			if (_equationList == null)
			{
				_equationList = new EquationList();
			}

			// stuff to get tab number
			int current_tab;
			SherlockFragmentActivity sherlockContext = getSherlockActivity();
			current_tab = sherlockContext.getSupportActionBar().getSelectedNavigationIndex();

			list_heat = _equationList.getEqns(3);

			// setListAdapter(new EquationItemAdapter(getActivity(), R.layout.menu_list_grid, list_temp) );
			// Populate list with our static array of titles.

			if (list_heat != null)
			{
				eqn_adapter_heat = new EquationItemAdapter(getActivity(), R.layout.menu_list_grid, list_heat);
			}

			System.out.println("heat setListAdapter");
			setListAdapter(eqn_adapter_heat);

			// Check to see if we have a frame in which to embed the details
			// fragment directly in the containing UI.
			View detailsFrame = getActivity().findViewById(R.id.details);
			mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

			if (savedInstanceState != null)
			{
				// Restore last state for checked position.
				mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
			}

			if (mDualPane)
			{
				// In dual-pane mode, the list view highlights the selected item.
				// getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
				// Make sure our UI is in the correct state.
				// showDetails(mCurCheckPosition);
			}
		}

		@Override
		public void onSaveInstanceState(Bundle outState)
		{
			super.onSaveInstanceState(outState);
			outState.putInt("curChoice", mCurCheckPosition);
		}

		@Override
		public void onListItemClick(ListView l, View v, int position, long id)
		{
			showDetails(position);
		}

		/**
		 * Helper function to show the details of a selected item, either by
		 * displaying a fragment in-place in the current UI, or starting a whole
		 * new activity in which it is displayed.
		 */
		void showDetails(int index)
		{
			mCurCheckPosition = index;

			if (mDualPane)
			{
				// We can display everything in-place with fragments, so update
				// the list to highlight the selected item and show the data.
				getListView().setItemChecked(index, true);

				// Check what fragment is currently shown, replace if needed.
				DetailsFragment details = (DetailsFragment) getFragmentManager().findFragmentById(R.id.details);
				if (details == null || details.getShownIndex() != index)
				{
					// Make new fragment to show this selection.
					details = DetailsFragment.newInstance(index, 3);

					// Execute a transaction, replacing any existing fragment
					// with this one inside the frame.
					FragmentTransaction ft = getFragmentManager().beginTransaction();
					ft.replace(R.id.details, details);
					ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
					ft.commit();
				}

			}
			else
			{
				// Otherwise we need to launch a new activity to display
				// the dialog fragment with selected text.
				Intent intent = new Intent();
				intent.setClass(getActivity(), DetailsActivity.class);
				intent.putExtra("index", index);
				intent.putExtra("currentTab", 3);
				startActivity(intent);
			}
		}
	}

	/**************************************************************************
	 * Class: VentListFragment
	 * 
	 * Top-level fragment showing list of vent equations
	 **************************************************************************/
	public static class VentListFragment extends SherlockListFragment
	{
		boolean mDualPane;
		int mCurCheckPosition = 0;

		EquationItemAdapter eqn_adapter_vent;
		ArrayList<EqnMenuItem> list_vent;

		@Override
		public void onActivityCreated(Bundle savedInstanceState)
		{
			super.onActivityCreated(savedInstanceState);

			if (_equationList == null)
			{
				_equationList = new EquationList();
			}

			// stuff to get tab number
			int current_tab;
			SherlockFragmentActivity sherlockContext = getSherlockActivity();
			current_tab = sherlockContext.getSupportActionBar().getSelectedNavigationIndex();

			list_vent = _equationList.getEqns(4);

			// setListAdapter(new EquationItemAdapter(getActivity(), R.layout.menu_list_grid, list_temp) );
			// Populate list with our static array of titles.

			if (list_vent != null)
			{
				eqn_adapter_vent = new EquationItemAdapter(getActivity(), R.layout.menu_list_grid, list_vent);
			}

			System.out.println("vent setListAdapter");
			setListAdapter(eqn_adapter_vent);

			// Check to see if we have a frame in which to embed the details
			// fragment directly in the containing UI.
			View detailsFrame = getActivity().findViewById(R.id.details);
			mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

			if (savedInstanceState != null)
			{
				// Restore last state for checked position.
				mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
			}

			if (mDualPane)
			{
				// In dual-pane mode, the list view highlights the selected item.
				// getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
				// Make sure our UI is in the correct state.
				// showDetails(mCurCheckPosition);
			}
		}

		@Override
		public void onSaveInstanceState(Bundle outState)
		{
			super.onSaveInstanceState(outState);
			outState.putInt("curChoice", mCurCheckPosition);
		}

		@Override
		public void onListItemClick(ListView l, View v, int position, long id)
		{
			showDetails(position);
		}

		/**
		 * Helper function to show the details of a selected item, either by
		 * displaying a fragment in-place in the current UI, or starting a whole
		 * new activity in which it is displayed.
		 */
		void showDetails(int index)
		{
			mCurCheckPosition = index;

			if (mDualPane)
			{
				// We can display everything in-place with fragments, so update
				// the list to highlight the selected item and show the data.
				getListView().setItemChecked(index, true);

				// Check what fragment is currently shown, replace if needed.
				DetailsFragment details = (DetailsFragment) getFragmentManager().findFragmentById(R.id.details);
				if (details == null || details.getShownIndex() != index)
				{
					// Make new fragment to show this selection.
					details = DetailsFragment.newInstance(index, 4);

					// Execute a transaction, replacing any existing fragment
					// with this one inside the frame.
					FragmentTransaction ft = getFragmentManager().beginTransaction();
					ft.replace(R.id.details, details);
					ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
					ft.commit();
				}

			}
			else
			{
				// Otherwise we need to launch a new activity to display
				// the dialog fragment with selected text.
				Intent intent = new Intent();
				intent.setClass(getActivity(), DetailsActivity.class);
				intent.putExtra("index", index);
				intent.putExtra("currentTab", 4);
				startActivity(intent);
			}
		}
	}

	/**************************************************************************
	 * Class: ExposListFragment
	 * 
	 * Top-level fragment showing list of exposure equations
	 **************************************************************************/
	public static class ExposListFragment extends SherlockListFragment
	{
		boolean mDualPane;
		int mCurCheckPosition = 0;

		EquationItemAdapter eqn_adapter_expos;
		ArrayList<EqnMenuItem> list_expos;

		@Override
		public void onActivityCreated(Bundle savedInstanceState)
		{
			super.onActivityCreated(savedInstanceState);

			if (_equationList == null)
			{
				_equationList = new EquationList();
			}

			// stuff to get tab number
			int current_tab;
			SherlockFragmentActivity sherlockContext = getSherlockActivity();
			current_tab = sherlockContext.getSupportActionBar().getSelectedNavigationIndex();

			list_expos = _equationList.getEqns(5);

			// setListAdapter(new EquationItemAdapter(getActivity(), R.layout.menu_list_grid, list_temp) );
			// Populate list with our static array of titles.

			if (list_expos != null)
			{
				eqn_adapter_expos = new EquationItemAdapter(getActivity(), R.layout.menu_list_grid, list_expos);
			}

			System.out.println("expos setListAdapter");
			setListAdapter(eqn_adapter_expos);

			// Check to see if we have a frame in which to embed the details
			// fragment directly in the containing UI.
			View detailsFrame = getActivity().findViewById(R.id.details);
			mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

			if (savedInstanceState != null)
			{
				// Restore last state for checked position.
				mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
			}

			if (mDualPane)
			{
				// In dual-pane mode, the list view highlights the selected item.
				// getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
				// Make sure our UI is in the correct state.
				// showDetails(mCurCheckPosition);
			}
		}

		@Override
		public void onSaveInstanceState(Bundle outState)
		{
			super.onSaveInstanceState(outState);
			outState.putInt("curChoice", mCurCheckPosition);
		}

		@Override
		public void onListItemClick(ListView l, View v, int position, long id)
		{
			showDetails(position);
		}

		/**
		 * Helper function to show the details of a selected item, either by
		 * displaying a fragment in-place in the current UI, or starting a whole
		 * new activity in which it is displayed.
		 */
		void showDetails(int index)
		{
			mCurCheckPosition = index;

			if (mDualPane)
			{
				// We can display everything in-place with fragments, so update
				// the list to highlight the selected item and show the data.
				getListView().setItemChecked(index, true);

				// Check what fragment is currently shown, replace if needed.
				DetailsFragment details = (DetailsFragment) getFragmentManager().findFragmentById(R.id.details);
				if (details == null || details.getShownIndex() != index)
				{
					// Make new fragment to show this selection.
					details = DetailsFragment.newInstance(index, 5);

					// Execute a transaction, replacing any existing fragment
					// with this one inside the frame.
					FragmentTransaction ft = getFragmentManager().beginTransaction();
					ft.replace(R.id.details, details);
					ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
					ft.commit();
				}

			}
			else
			{
				// Otherwise we need to launch a new activity to display
				// the dialog fragment with selected text.
				Intent intent = new Intent();
				intent.setClass(getActivity(), DetailsActivity.class);
				intent.putExtra("index", index);
				intent.putExtra("currentTab", 5);
				startActivity(intent);
			}
		}
	}

	/**************************************************************************
	 * Class: DetailsFragment
	 * 
	 * Shows fragment for selected item (single(?) view modes only)
	 ***************************************************************************/
	public static class DetailsFragment extends SherlockFragment
	{
		private int selection, tab;
		private EqnMenuItem emi;
		private EditText[] entries;
		private EditText result;
		private boolean honeycombPlus, conversion;
		
		public static DetailsFragment newInstance(int index, int currentTab)
		{
			DetailsFragment f = new DetailsFragment();

			// Supply index input as an argument.
			Bundle args = new Bundle();
			args.putInt("index", index);
			//args.putInt("currentTab", currentTab);
			f.setArguments(args);

			return f;
		}

		public int getShownIndex()
		{
			return getArguments().getInt("index", 0);
		}

		public void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			selection = getArguments().getInt("index");
			tab = getArguments().getInt("currentTab");
		}

		@TargetApi(11)
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
		{
			//not all layouts use this view
			if (container == null)
			{
				return null;
			}

			View V = inflater.inflate(R.layout.var_test, container, false);
			emi = _equationList.getEqns(tab).get(selection);
			int numberOfFields = emi.num_of_variables;
			entries = new EditText[emi.num_of_variables];
			result = (EditText) V.findViewById(R.id.editText1);
			honeycombPlus = false;
			conversion = false;
			
			ImageView imageView = (ImageView) V.findViewById(R.id.imageView1);
			SVG svg = SVGParser.getSVGFromResource(getResources(), emi.graphic_id);
			imageView.setImageDrawable(svg.createPictureDrawable());

			if (android.os.Build.VERSION.RELEASE.startsWith("3.") || android.os.Build.VERSION.RELEASE.startsWith("4."))
			{
				V.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
				honeycombPlus = true;
				result.setBackgroundColor(Color.WHITE);
			}
			
			if (tab == 1)
				conversion = true;
			
			// If num_of_variables = 0, this is a table //
			if (emi.num_of_variables == 0)
			{
				EditText et1 = (EditText) V.findViewById(R.id.editText1);
				Button bt1 = (Button) V.findViewById(R.id.button1);
				Button bt2 = (Button) V.findViewById(R.id.button2);
				et1.setVisibility(View.INVISIBLE);
				bt1.setVisibility(View.INVISIBLE);  // result bar and buttons are hidden //
				bt2.setVisibility(View.INVISIBLE);
				if(emi.number == 3)
					heatStressTable(V);
				else
					constantsTable(V);
				return V;
			}

			TableLayout tl = (TableLayout) V.findViewById(R.id.varTable);
			LayoutParams params = new TableRow.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f);


			// Creates a a text field, text box, and another text field for each variable in //
			// the equation, and adds them to the view. //
			for (int i = 0; i < numberOfFields; i++)
			{
				TableRow tr = new TableRow(V.getContext());
				tr.setWeightSum(3);
				tr.setGravity(Gravity.CENTER_HORIZONTAL);
				tr.setId(1000 + i);

				TextView tv1 = new TextView(V.getContext());
				tl.setColumnStretchable(0, true);
				tv1.setId(100 + i);
				tv1.setGravity(Gravity.RIGHT);
				tv1.setText(emi.unitList[i].variable + " ");
				tv1.setTextColor(Color.WHITE);
				tv1.setLayoutParams(params);
				tr.addView(tv1);

				EditText textbox1 = new EditText(V.getContext());
				tl.setColumnStretchable(1, true);
				textbox1.setId(10 + i);
				textbox1.setGravity(Gravity.RIGHT);
				textbox1.setLayoutParams(params);
				textbox1.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
				textbox1.setKeyListener(DigitsKeyListener.getInstance("0123456789.-"));
				if (honeycombPlus){
					textbox1.setBackgroundColor(Color.WHITE);
					tr.setPadding(0, 10, 0, 0);
				}
				entries[i] = textbox1;
				tr.addView(textbox1);

				TextView tv1f = new TextView(V.getContext());
				tl.setColumnStretchable(2, true);
				tv1f.setId(200 + i);
				tv1f.setText(" " + emi.unitList[i].unit);
				tv1f.setTextColor(Color.WHITE);
				tv1f.setLayoutParams(params);
				tr.addView(tv1f);

				tl.addView(tr);

			}

			return V;
		}

		public void calcButtonClick(View v)
		{

			Object[] params = new Object[emi.num_of_variables];
			Object convertEntry = new Object();
			boolean calculate = true, convert = true;
			int index = 0, entry = 0;

			if(!conversion){
					for (int i = 0; i < params.length; i++)
					{

						if (entries[i].getText().length() > 0)
						{
							try
							{
								params[i] = new Double(Double.parseDouble(entries[i].getText().toString()));
							} catch (NumberFormatException e)
							{}
						}
						else
						{
							calculate = false;
						}
					}
			
				
				if (calculate)
				{
					try
					{
						Object returnVal = emi.eqnMethod.invoke(this, params);
						Double rVal = (Double) returnVal;
						double d = rVal.doubleValue();
						String s = new DecimalFormat("#.##").format(d);
						result.setText(s);
					} catch (IllegalArgumentException e)
					{

						e.printStackTrace();
					} catch (IllegalAccessException e)
					{

						e.printStackTrace();
					} catch (InvocationTargetException e)
					{

						e.printStackTrace();
					}
				}
			}
			else{
				
				for (int i = 0; i < entries.length; i++)
				{

					if (entries[i].getText().length() > 0)
					{
						entry++;
						try
						{
							convertEntry = new Double(Double.parseDouble(entries[i].getText().toString()));
						} catch (NumberFormatException e)
						{}
						index = i;
					}
				}
				
				if (entry == 1)
				{
					try
					{
						Object[]returnVal =  (Object[]) emi.eqnMethod.invoke(this, index, convertEntry);
						Double[] rVal = (Double[]) returnVal;
						double[] d  = new double[rVal.length];
						for(int i=0; i< rVal.length; i++){
							d[i] = rVal[i].doubleValue();
						}
						
						for(int i=0; i< entries.length; i++){
							String s = new DecimalFormat("#.##").format(d[i]);
							entries[i].setText(s);
						}
						
						
					} catch (IllegalArgumentException e)
					{

						e.printStackTrace();
					} catch (IllegalAccessException e)
					{

						e.printStackTrace();
					} catch (InvocationTargetException e)
					{

						e.printStackTrace();
					}
				}
			}
		}

		public void clearButtonClick(View v)
		{
			result.setText("0");
			for (int i = 0; i < entries.length; i++)
			{
				entries[i].setText("");
			}
		}

		public View heatStressTable(View V)
		{
			TableLayout tl = (TableLayout) V.findViewById(R.id.varTable);
			LayoutParams params = new TableRow.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f);
			tl.setColumnStretchable(0, true);
			tl.setColumnStretchable(1, true);
			tl.setColumnStretchable(2, true);
			tl.setColumnStretchable(3, true);

			TableRow row0 = createTableRow(V, 1);
			createTableText("______Work Load**______", 1, params, V, row0);
			tl.addView(row0);

			TableRow row1 = createTableRow(V, 4);
			createTableText("Work/rest regimen", 0, params, V, row1);
			createTableText("Light", 1, params, V, row1);
			createTableText("Moderate", 1, params, V, row1);
			createTableText("Heavy", 1, params, V, row1);
			tl.addView(row1);

			TableRow rowA = createTableRow(V, 1);
			createTableText("", 1, params, V, rowA);
			tl.addView(rowA);

			TableRow row2 = createTableRow(V, 4);
			createTableText("Continuous Work", 0, params, V, row2);
			createTableText("30.0\u00b0C (86\u00b0F)", 1, params, V, row2);
			createTableText("26.7\u00b0C (80\u00b0F)", 1, params, V, row2);
			createTableText("25.0\u00b0C (77\u00b0F)", 1, params, V, row2);
			tl.addView(row2);

			TableRow rowB = createTableRow(V, 1);
			createTableText("", 1, params, V, rowB);
			tl.addView(rowB);

			TableRow row3 = createTableRow(V, 4);
			createTableText("75% Work, 25% Rest*", 0, params, V, row3);
			createTableText("30.6\u00b0C (87\u00b0F)", 1, params, V, row3);
			createTableText("28.0\u00b0C (82\u00b0F)", 1, params, V, row3);
			createTableText("25.9\u00b0C (78\u00b0F)", 1, params, V, row3);
			tl.addView(row3);

			TableRow rowC = createTableRow(V, 1);
			createTableText("", 1, params, V, rowC);
			tl.addView(rowC);

			TableRow row4 = createTableRow(V, 4);
			createTableText("50% Work, 50% Rest*", 0, params, V, row4);
			createTableText("31.4\u00b0C (89\u00b0F)", 1, params, V, row4);
			createTableText("29.4\u00b0C (85\u00b0F)", 1, params, V, row4);
			createTableText("27.9\u00b0C (82\u00b0F)", 1, params, V, row4);
			tl.addView(row4);

			TableRow rowD = createTableRow(V, 1);
			createTableText("", 1, params, V, rowD);
			tl.addView(rowD);

			TableRow row5 = createTableRow(V, 4);
			createTableText("25% Work, 75% Rest*", 0, params, V, row5);
			createTableText("32.2\u00b0C (90\u00b0F)", 1, params, V, row5);
			createTableText("31.1\u00b0C (88\u00b0F)", 1, params, V, row5);
			createTableText("30.0\u00b0C (86\u00b0F)", 1, params, V, row5);
			tl.addView(row5);

			TableRow rowE = createTableRow(V, 1);
			createTableText("", 1, params, V, rowE);
			tl.addView(rowE);

			TableRow rowF = createTableRow(V, 1);
			createTableText("*Each Hour", 1, params, V, rowF);
			tl.addView(rowF);

			TableRow rowG = createTableRow(V, 1);
			createTableText("**Values in \u00b0C and \u00b0F, WBGT", 1, params, V, rowG);
			tl.addView(rowG);

			return V;
		}
		
		public View constantsTable(View V)
		{
			TableLayout tl = (TableLayout) V.findViewById(R.id.varTable);
			LayoutParams params = new TableRow.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f);
			tl.setColumnStretchable(0, true);
			tl.setColumnStretchable(1, true);

			TableRow rowA = createTableRow(V, 1);
			createTableText("", 1, params, V, rowA);
			tl.addView(rowA);

			TableRow row2 = createTableRow(V, 2);
			createTableText("Avogadro's Number", 0, params, V, row2);
			createTableText("6.022 * 10^23", 1, params, V, row2);
			tl.addView(row2);

			TableRow rowB = createTableRow(V, 1);
			createTableText("", 1, params, V, rowB);
			tl.addView(rowB);

			TableRow row3 = createTableRow(V, 2);
			createTableText("Planck's Constant", 0, params, V, row3);
			createTableText("6.63 * 10^-34 m^2 kg/s", 1, params, V, row3);
			tl.addView(row3);

			TableRow rowC = createTableRow(V, 1);
			createTableText("", 1, params, V, rowC);
			tl.addView(rowC);

			TableRow row4 = createTableRow(V, 2);
			createTableText("Speed of Light", 0, params, V, row4);
			createTableText("3 * 10^8 m/s", 1, params, V, row4);
			tl.addView(row4);

			TableRow rowD = createTableRow(V, 1);
			createTableText("", 1, params, V, rowD);
			tl.addView(rowD);

			TableRow row5 = createTableRow(V, 2);
			createTableText("Speed of Sound (in air at 0\u00B0C)", 0, params, V, row5);
			createTableText("(331 + 0.6 * \u00B0C) m/s", 1, params, V, row5);
			tl.addView(row5);
			
			return V;
		}

		public void createTableText(String s, int gravity, LayoutParams lp, View V, TableRow tr)
		{

			TextView tv = new TextView(V.getContext());
			tv.setText(s);
			tv.setTextColor(Color.WHITE);
			tv.setLayoutParams(lp);

			switch (gravity)
			{
			case 0:
				tv.setGravity(Gravity.LEFT);
				break;
			case 1:
				tv.setGravity(Gravity.CENTER);
				break;
			case 2:
				tv.setGravity(Gravity.RIGHT);
				break;
				default:
				break;
			}
			
			tr.addView(tv);
		}

		public TableRow createTableRow(View V, int columns)
		{
			TableRow tr = new TableRow(V.getContext());
			tr.setWeightSum(columns);
			tr.setGravity(Gravity.CENTER_HORIZONTAL);
			return tr;
		}
	}

	
		
	
	/*****************************************************************************************************************/
	public class EquationEvaluator
	{

	}
	/*****************************************************************************************************************/

}
/*********************************************************************************************************************/

