package com.radioelectronic.twocolorsbutton;

import com.radioelectronic.twocolorsbutton.widjet.TwoColorsButton;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;

/**
 * GUI for Main screen
 * 
 * @author Artyom Kiriliyk
 * 
 */
public class MainActivity extends Activity
{
	private TwoColorsButton twoColorsButton;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		twoColorsButton = (TwoColorsButton) findViewById(R.id.twoColorsButton);
		twoColorsButton.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
			}
		});
	}
}