package com.example.android.sherlockdemo;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.provider.Contacts.People;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SearchViewCompat;
import android.support.v4.widget.SearchViewCompat.OnQueryTextListenerCompat;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

@SuppressWarnings("deprecation")
public class AccountListActivity extends SherlockFragmentActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		FragmentManager fm = getSupportFragmentManager();

		// Create the list fragment and add it as our sole content.
		if (fm.findFragmentById(android.R.id.content) == null)
		{
			AccountListFragment list = new AccountListFragment();
			fm.beginTransaction().add(android.R.id.content, list).commit();
		}
	}

	public static class AccountListFragment extends SherlockListFragment
	{

		// This is the Adapter being used to display the list's data.
		SimpleCursorAdapter mAdapter;
		String[] mAccts = null;

		// If non-null, this is the current filter the user has provided.
		String mCurFilter;

		@Override
		public void onActivityCreated(Bundle savedInstanceState)
		{
			super.onActivityCreated(savedInstanceState);

			// Give some text to display if there is no data. In a real
			// application this would come from a resource.
			setEmptyText("No accounts");

			// We have a menu item to show in action bar.
			setHasOptionsMenu(false);

			// Build list of accounts
			AccountManager am = (AccountManager) getActivity().getSystemService(Context.ACCOUNT_SERVICE);
			Account[] acs = am.getAccounts();
			mAccts = new String[acs.length];
			for (int i = 0; i < acs.length; i++)
			{
				mAccts[i] = acs[i].name;
			}

			// Create an empty adapter we will use to display the loaded data.
			// Populate list with our static array of titles.
			setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.simple_list_item_checkable_1,
					android.R.id.text1, mAccts));

			/*
			 * // Start out with a progress indicator. setListShown(false);
			 * 
			 * // Prepare the loader. Either re-connect with an existing one, //
			 * or start a new one. getLoaderManager().initLoader(0, null, this);
			 */
		}

		@Override
		public void onListItemClick(ListView l, View v, int position, long id)
		{
			// Insert desired behavior here.
			Log.i("FragmentComplexList", "Item clicked: " + id);
		}

		/*
		 * // These are the Contacts rows that we will retrieve. // TODO:
		 * Replace People.DISPLAY_NAME with Account static final String[]
		 * ACCOUNTS_SUMMARY_PROJECTION = new String[] { BaseColumns._ID,
		 * People.DISPLAY_NAME, };
		 */

		/*
		 * // TODO: Replace People ContentProvider with Account
		 * 
		 * @Override public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		 * // This is called when a new Loader needs to be created. This //
		 * sample only has one Loader, so we don't care about the ID. // First,
		 * pick the base URI to use depending on whether we are // currently
		 * filtering. Uri baseUri; if (mCurFilter != null) { baseUri =
		 * Uri.withAppendedPath(People.CONTENT_FILTER_URI,
		 * Uri.encode(mCurFilter)); } else { baseUri = People.CONTENT_URI; }
		 * 
		 * // Now create and return a CursorLoader that will take care of //
		 * creating a Cursor for the data being displayed. String select = "(("
		 * + People.DISPLAY_NAME + " NOTNULL) AND (" + People.DISPLAY_NAME +
		 * " != '' ))"; return new CursorLoader(getActivity(), baseUri,
		 * ACCOUNTS_SUMMARY_PROJECTION, select, null, People.DISPLAY_NAME +
		 * " COLLATE LOCALIZED ASC"); }
		 */

		/*
		 * @Override public void onLoadFinished(Loader<Cursor> loader, Cursor
		 * data) { // Swap the new cursor in. (The framework will take care of
		 * closing the // old cursor once we return.) mAdapter.swapCursor(data);
		 * 
		 * // The list should now be shown. if (isResumed()) {
		 * setListShown(true); } else { setListShownNoAnimation(true); } }
		 */

		/*
		 * @Override public void onLoaderReset(Loader<Cursor> loader) { // This
		 * is called when the last Cursor provided to onLoadFinished() // above
		 * is about to be closed. We need to make sure we are no // longer using
		 * it. mAdapter.swapCursor(null); }
		 */
	}
}
