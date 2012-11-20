package com.aiha.aiha_calc;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.ActionBar;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

public class MainActivity extends SherlockFragmentActivity
{
	
	ViewPager mViewPager;
	TabsAdapter mTabsAdapter;
	public static int THEME = R.style.Theme_Aiha_Light;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		setTheme(THEME);

		super.onCreate(savedInstanceState);

		ActionBar bar = getSupportActionBar();
		setContentView(R.layout.activity_main);
		mViewPager = (ViewPager) findViewById(R.id.pager);

		// configure actionbar to hide logo and use tabs
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		bar.setDisplayUseLogoEnabled(false);
		bar.setDisplayShowTitleEnabled(false);
		bar.setDisplayShowHomeEnabled(false);
		bar.setDisplayHomeAsUpEnabled(false);
		
		mTabsAdapter = new TabsAdapter(this, mViewPager);

		// create tabs for actionbar		
		mTabsAdapter.addTab("aiha", "AIHA",					MainPageFragment.class, null);
		mTabsAdapter.addTab("convert", "Convert",			MainPageFragment.class, null);
		mTabsAdapter.addTab("noise", "Noise",				FragmentLayoutSupport.NoiseListFragment.class, null);
		mTabsAdapter.addTab("heat", "Heat",					FragmentLayoutSupport.HeatListFragment.class, null);
		mTabsAdapter.addTab("ventilation", "Ventilation",	FragmentLayoutSupport.VentListFragment.class, null);
		mTabsAdapter.addTab("exposure", "Exposure",			FragmentLayoutSupport.ExposListFragment.class, null);

		//display AIHA SVG image
		//ImageView imageView = new ImageView(this);
		// imageView.setBackgroundColor(Color.RED); // Set the background color
		//SVG svg = SVGParser.getSVGFromResource(getResources(), R.raw.aiha_tag_white);
		//imageView.setImageDrawable(svg.createPictureDrawable());
		//setContentView(imageView);
	}


	public static class TabsAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener,
			ActionBar.TabListener
	{
		private final SherlockFragmentActivity mContext;
		private final ViewPager mViewPager;
		private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();

		static final class TabInfo
		{
			@SuppressWarnings("unused")
			private final String tag;
			private final Class<?> clss;
			private final Bundle args;

			TabInfo(String _tag, Class<?> _class, Bundle _args)
			{
				tag = _tag;
				clss = _class;
				args = _args;
			}
		}

		static class DummyTabFactory implements TabHost.TabContentFactory
		{
			private final Context mContext;

			public DummyTabFactory(Context context)
			{
				mContext = context;
			}

			@Override
			public View createTabContent(String tag)
			{
				View v = new View(mContext);
				v.setMinimumWidth(0);
				v.setMinimumHeight(0);
				return v;
			}
		}

		public TabsAdapter(SherlockFragmentActivity activity, ViewPager pager)
		{
			super(activity.getSupportFragmentManager());
			mContext = activity;
			mViewPager = pager;
			mViewPager.setAdapter(this);
			mViewPager.setOnPageChangeListener(this);
		}

		public void addTab(String tag, CharSequence label, Class<?> clss, Bundle args)
		{
			ActionBar.Tab tab = mContext.getSupportActionBar().newTab();
			tab.setText(label);
			tab.setTabListener(this);
			mContext.getSupportActionBar().addTab(tab);
			TabInfo info = new TabInfo(tag, clss, args);
			mTabs.add(info);
			notifyDataSetChanged();
		}

		@Override
		public int getCount()
		{
			return mTabs.size();
		}

		@Override
		public Fragment getItem(int position)
		{
			TabInfo info = mTabs.get(position);
			return Fragment.instantiate(mContext, info.clss.getName(), info.args);
		}

		@Override
		public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
		{
		}

		@Override
		public void onPageSelected(int position)
		{
			mContext.getSupportActionBar().setSelectedNavigationItem(position);
		}

		@Override
		public void onPageScrollStateChanged(int state)
		{
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.actionbarsherlock.app.ActionBar.TabListener#onTabSelected(com
		 * .actionbarsherlock.app.ActionBar.Tab,
		 * android.support.v4.app.FragmentTransaction)
		 */
		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft)
		{
			mViewPager.setCurrentItem(mContext.getSupportActionBar().getSelectedNavigationIndex());
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.actionbarsherlock.app.ActionBar.TabListener#onTabUnselected(com
		 * .actionbarsherlock.app.ActionBar.Tab,
		 * android.support.v4.app.FragmentTransaction)
		 */
		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft)
		{
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * com.actionbarsherlock.app.ActionBar.TabListener#onTabReselected(com
		 * .actionbarsherlock.app.ActionBar.Tab,
		 * android.support.v4.app.FragmentTransaction)
		 */
		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft)
		{
		}
	}

}
