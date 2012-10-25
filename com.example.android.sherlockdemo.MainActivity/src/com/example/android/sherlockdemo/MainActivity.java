package com.example.android.sherlockdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.actionbarsherlock.app.SherlockActivity;

public class MainActivity extends SherlockActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    }

    public void onClickFragmentLayout(View v) {
        Intent intent = new Intent(this, FragmentLayoutSupport.class);
        startActivity(intent);
    }
    public void onClickFragmentTabsPager(View v) {
        Intent intent = new Intent(this, FragmentTabsPager.class);
        startActivity(intent);
    }
}