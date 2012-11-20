package com.example.asb_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.SherlockListFragment;
import com.example.asb_test.EquationItemAdapter.ViewHolder;
import com.example.asb_test.EquationList.EqnMenuItem;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

/*********************************************************************************************************************/
public class FragmentLayoutSupport extends SherlockFragmentActivity
{
	private static EquationList _equationList;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		if(_equationList == null)
		{
			_equationList = new EquationList(); //generates vector with menu data
		}	

		setContentView(R.layout.fragment_layout_support);
	}

	// handler for smallish screen sizes
	public static class DetailsActivity extends SherlockFragmentActivity
	{

		@Override
		protected void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);

			if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
			{
				// If the screen is now in landscape mode, we can show the
				// dialog in-line with the list so we don't need this activity.
				finish();
				return;
			}

			if (savedInstanceState == null)
			{
				// During initial setup, plug in the details fragment.
				DetailsFragment details = new DetailsFragment();
				details.setArguments(getIntent().getExtras());
				getSupportFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
			}
		}
	}

	/*****************************************************************************************************************/
	// top-level fragment showing list of items
	public static class NoiseListFragment extends SherlockListFragment
	{
		boolean mDualPane;
		int mCurCheckPosition = 0;
		
		EquationItemAdapter eqn_adapter_noise;
		EquationItemAdapter eqn_adapter_heat;
		EquationItemAdapter eqn_adapter_vent;
		EquationItemAdapter eqn_adapter_expos;
		
		@Override
		public void onActivityCreated(Bundle savedInstanceState)
		{
			super.onActivityCreated(savedInstanceState);
			
			if(_equationList == null)
			{
				_equationList = new EquationList();
			}

			//stuff to get tab number
			int current_tab;
			SherlockFragmentActivity sherlockContext = getSherlockActivity();
			current_tab = sherlockContext.getSupportActionBar().getSelectedNavigationIndex();
			
			ArrayList<EqnMenuItem> list_noise = _equationList.getEqns(2);
			
			/***********************************************/
			//setListAdapter(new EquationItemAdapter(getActivity(), R.layout.menu_list_grid, list_temp) );
			// Populate list with our static array of titles.
			if(list_noise != null)
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
			
			if(mDualPane)
			{
				// In dual-pane mode, the list view highlights the selected item.
				//getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
				// Make sure our UI is in the correct state.
				//showDetails(mCurCheckPosition);
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
					details = DetailsFragment.newInstance(index);

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
				startActivity(intent);
			}
		}
	}

	public static class HeatListFragment extends SherlockListFragment
	{
		boolean mDualPane;
		int mCurCheckPosition = 0;
		
		EquationItemAdapter eqn_adapter_noise;
		EquationItemAdapter eqn_adapter_heat;
		EquationItemAdapter eqn_adapter_vent;
		EquationItemAdapter eqn_adapter_expos;
		
		@Override
		public void onActivityCreated(Bundle savedInstanceState)
		{
			super.onActivityCreated(savedInstanceState);
			
			if(_equationList == null)
			{
				_equationList = new EquationList();
			}

			//stuff to get tab number
			int current_tab;
			SherlockFragmentActivity sherlockContext = getSherlockActivity();
			current_tab = sherlockContext.getSupportActionBar().getSelectedNavigationIndex();
			

			ArrayList<EqnMenuItem> list_heat = _equationList.getEqns(3);
			
			/***********************************************/
			//setListAdapter(new EquationItemAdapter(getActivity(), R.layout.menu_list_grid, list_temp) );
			// Populate list with our static array of titles.

		
			if(list_heat != null)
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
			
			if(mDualPane)
			{
				// In dual-pane mode, the list view highlights the selected item.
				//getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
				// Make sure our UI is in the correct state.
				//showDetails(mCurCheckPosition);
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
					details = DetailsFragment.newInstance(index);

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
				startActivity(intent);
			}
		}
	}
	
	
	public static class VentListFragment extends SherlockListFragment
	{
		boolean mDualPane;
		int mCurCheckPosition = 0;
		
		EquationItemAdapter eqn_adapter_noise;
		EquationItemAdapter eqn_adapter_heat;
		EquationItemAdapter eqn_adapter_vent;
		EquationItemAdapter eqn_adapter_expos;
		
		@Override
		public void onActivityCreated(Bundle savedInstanceState)
		{
			super.onActivityCreated(savedInstanceState);
			
			if(_equationList == null)
			{
				_equationList = new EquationList();
			}

			//stuff to get tab number
			int current_tab;
			SherlockFragmentActivity sherlockContext = getSherlockActivity();
			current_tab = sherlockContext.getSupportActionBar().getSelectedNavigationIndex();
			

			ArrayList<EqnMenuItem> list_vent = _equationList.getEqns(4);
			
			/***********************************************/
			//setListAdapter(new EquationItemAdapter(getActivity(), R.layout.menu_list_grid, list_temp) );
			// Populate list with our static array of titles.

			
			if(list_vent != null)
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
			
			if(mDualPane)
			{
				// In dual-pane mode, the list view highlights the selected item.
				//getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
				// Make sure our UI is in the correct state.
				//showDetails(mCurCheckPosition);
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
					details = DetailsFragment.newInstance(index);

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
				startActivity(intent);
			}
		}
	}
	
	
	public static class ExposListFragment extends SherlockListFragment
	{
		boolean mDualPane;
		int mCurCheckPosition = 0;
		
		EquationItemAdapter eqn_adapter_noise;
		EquationItemAdapter eqn_adapter_heat;
		EquationItemAdapter eqn_adapter_vent;
		EquationItemAdapter eqn_adapter_expos;
		
		@Override
		public void onActivityCreated(Bundle savedInstanceState)
		{
			super.onActivityCreated(savedInstanceState);
			
			if(_equationList == null)
			{
				_equationList = new EquationList();
			}

			//stuff to get tab number
			int current_tab;
			SherlockFragmentActivity sherlockContext = getSherlockActivity();
			current_tab = sherlockContext.getSupportActionBar().getSelectedNavigationIndex();
			
			ArrayList<EqnMenuItem> list_expos = _equationList.getEqns(5);
			
			/***********************************************/
			//setListAdapter(new EquationItemAdapter(getActivity(), R.layout.menu_list_grid, list_temp) );
			// Populate list with our static array of titles.
			
			if(list_expos != null)
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
			
			if(mDualPane)
			{
				// In dual-pane mode, the list view highlights the selected item.
				//getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
				// Make sure our UI is in the correct state.
				//showDetails(mCurCheckPosition);
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
					details = DetailsFragment.newInstance(index);

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
				startActivity(intent);
			}
		}
	}
	/*****************************************************************************************************************/
	/**
	 * This is the secondary fragment, displaying the details of a particular
	 * item.
	 */

	public static class DetailsFragment extends SherlockFragment
	{
		/**
		 * Create a new instance of EquationFragment, initialized to show the
		 * text at 'index'.
		 */
		public static DetailsFragment newInstance(int index)
		{
			DetailsFragment f = new DetailsFragment();

			// Supply index input as an argument.
			Bundle args = new Bundle();
			args.putInt("index", index);
			f.setArguments(args);

			return f;
		}

		public int getShownIndex()
		{
			return getArguments().getInt("index", 0);
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
		{
			if (container == null)
			{
				// We have different layouts, and in one of them this
				// fragment's containing frame doesn't exist. The fragment
				// may still be created from its saved state, but there is
				// no reason to try to create its view hierarchy because it
				// won't be displayed. Note this is not needed -- we could
				// just run the code below, where we would create and return
				// the view hierarchy; it would just never be used.
				return null;
			}

			ScrollView scroller = new ScrollView(getActivity());
			TextView text = new TextView(getActivity());
			int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getActivity().getResources().getDisplayMetrics());
			 text.setPadding(padding, padding, padding, padding);
			 scroller.addView(text);
			 //text.setText(_equationList.getVect().elementAt(getShownIndex()).graphic_name); //temporary just to display *something*

			return scroller;
		}
	}

	/*****************************************************************************************************************/
	public class EquationEvaluator
	{

	}
	/*****************************************************************************************************************/

}
/*********************************************************************************************************************/

