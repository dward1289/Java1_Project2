package com.DevonaWard.theLayout;


import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class theLayout {

	
	//Linear Layout
	public static LinearLayout layoutWithButton(Context context, String txtViewText,String buttonTxt){
		LinearLayout linearLayout = new LinearLayout(context);
		LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		linearLayout.setLayoutParams(layoutParams);
		
		//TextView created
		TextView txtView = new TextView(context);
		txtView.setText(txtViewText);
		
		
		//Main button created
		Button button = new Button(context);
		button.setText(buttonTxt);
		button.setId(1);

		linearLayout.addView(txtView);
		linearLayout.addView(button);

		return linearLayout;
	}
	
	//Create radio buttons
	public static RadioGroup getOpions(Context context, String[] options){
		RadioGroup boxes = new RadioGroup(context);
		
		for(int i=0; i<options.length; i++){
			RadioButton radioBtn = new RadioButton(context);
			radioBtn.setText(options[i]);
			radioBtn.setId(i+1);
			boxes.addView(radioBtn);
		}
		
		return boxes;
	}
}
