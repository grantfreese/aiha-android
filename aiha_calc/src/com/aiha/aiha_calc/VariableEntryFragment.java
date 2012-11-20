package com.aiha.aiha_calc;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;


public class VariableEntryFragment extends SherlockFragment{
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

	        View V = inflater.inflate(R.layout.var_test, container, false);
	        int numberOfFields = 3;
	        
	        TableLayout tl = (TableLayout)V.findViewById(R.id.varTable);
	        LayoutParams params = new TableRow.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f);
			
			for(int i=0; i < numberOfFields; i++){
				TableRow tr = new TableRow(V.getContext());
				tr.setWeightSum(3);
				tr.setGravity(Gravity.CENTER_HORIZONTAL);
				tr.setId(1000+i);
				
				TextView tv1 = new TextView(V.getContext());
				tl.setColumnStretchable(0, true);
				tv1.setId(100+i);
				tv1.setGravity(Gravity.RIGHT);
				tv1.setText("Variable " + (i+1) + " ");
				tv1.setLayoutParams(params);
				tr.addView(tv1);
			
				EditText textbox1 = new EditText(V.getContext());
				tl.setColumnStretchable(1, true);
				textbox1.setId(10+i);
				textbox1.setGravity(Gravity.RIGHT);
				textbox1.setLayoutParams(params);
				tr.addView(textbox1);
			
				TextView tv1f = new TextView(V.getContext());
				tl.setColumnStretchable(2, true);
				tv1f.setId(200+i);
				tv1f.setText(" Unit " + (i+1));
				tv1f.setLayoutParams(params);
				tr.addView(tv1f);
			
				tl.addView(tr);
				
			}
	        
	        return V;
		
		
		}

}//end class
