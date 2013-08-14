package com.DevonaWard.project2;


import com.DevonaWard.theInfo.theJSON;
import com.DevonaWard.theLayout.theLayout;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.widget.TextView;



import android.widget.LinearLayout;


public class MainActivity extends Activity {
	Context context;
	String[] teamCity;
	RadioGroup cityOptions;
	TextView resultView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//City_Array count
		int teamNum = getResources().getStringArray(R.array.city_array).length;
		context = this;
		
		//City Array
		teamCity = getResources().getStringArray(R.array.city_array);
		
		LinearLayout linearLayout = new LinearLayout(this);
		LinearLayout mainLayout = theLayout.layoutWithButton(this, "Select from the list of "+ teamNum +" cities.", "Ok");
		LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		linearLayout.setLayoutParams(layoutParams);
		
		//Button created from theData class
		Button mainButton = (Button) mainLayout.findViewById(1);
		mainButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				/*This will get the ID of the selected radio button,
				 * and display the data from theJSON in the resultView.
				 */
				int id = cityOptions.getCheckedRadioButtonId();
				RadioButton selectedRadio = (RadioButton)findViewById(id);
				String selected = selectedRadio.getText().toString();
				resultView.setText(theJSON.readJSON(selected));
			}
			
		});

		//Populates radio buttons using teamCity.	
		cityOptions = theLayout.getOpions(this, teamCity);
		
		//Displays JSON results
		TextView resultView = new TextView(context);
				
		linearLayout.addView(mainLayout);
		mainLayout.addView(cityOptions);
		mainLayout.addView(resultView);

		
		setContentView(linearLayout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
