package com.radioelectronic.twocolorsbutton.widjet;

import com.radioelectronic.twocolorsbutton.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Class which implements custom button with two different backgrounds and texts
 * for left and right parts
 * 
 * @author Artyom Kiriliyk
 * 
 */
public class TwoColorsButton extends LinearLayout
{
	private final static int DEFAULT_LEFT_COLOR = Color.rgb(218, 20, 50);
	private final static int DEFAULT_RIGHT_COLOR = Color.rgb(235, 132, 135);
	private final static int DEFAULT_TEXT_COLOR = Color.WHITE;
	private final static int DEFAULT_TEXT_SIZE = 14;
	private final static int MARGIN = 2;

	private String leftText = "";
	private String rightText = "";
	private int leftColor;
	private int rightColor;
	private int textColor;
	private float textSize;

	private TextView textViewLeft, textViewRight;

	public TwoColorsButton(Context context, AttributeSet attrs)
	{
		super(context, attrs);

		textViewLeft = new TextView(context);
		textViewRight = new TextView(context);

		int dp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				MARGIN, context.getResources().getDisplayMetrics());
		LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		llp.setMargins(dp, 0, dp, 0);
		float sp = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
				DEFAULT_TEXT_SIZE, context.getResources().getDisplayMetrics());

		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.TwoColorsButton);
		leftColor = a.getColor(R.styleable.TwoColorsButton_left_color,
				DEFAULT_LEFT_COLOR);
		rightColor = a.getColor(R.styleable.TwoColorsButton_right_color,
				DEFAULT_RIGHT_COLOR);
		textColor = a.getColor(R.styleable.TwoColorsButton_text_color,
				DEFAULT_TEXT_COLOR);
		leftText = a.getString(R.styleable.TwoColorsButton_left_text);
		rightText = a.getString(R.styleable.TwoColorsButton_right_text);
		textSize = a.getDimension(R.styleable.TwoColorsButton_text_size, sp);
		a.recycle();

		this.setOrientation(LinearLayout.HORIZONTAL);
		this.setGravity(Gravity.CENTER);
		this.setBackgroundColor(rightColor);

		textViewLeft.setText(leftText);
		textViewLeft.setBackgroundColor(leftColor);
		textViewLeft.setTextColor(textColor);
		textViewLeft.setPadding(dp, 0, dp, 0);
		textViewLeft.setTextSize(textSize);

		textViewRight.setText(rightText);
		textViewRight.setBackgroundColor(rightColor);
		textViewRight.setTextColor(textColor);
		textViewRight.setLayoutParams(llp);
		textViewRight.setTextSize(textSize);

		this.addView(textViewLeft);
		this.addView(textViewRight);
	}

	/**
	 * Set left color of button
	 * 
	 * @param leftColor
	 *            Left color
	 */
	public void setLeftColor(int leftColor)
	{
		this.leftColor = leftColor;
		textViewLeft.setBackgroundColor(leftColor);
	}

	/**
	 * Set right color of button
	 * 
	 * @param rightColor
	 *            Right color
	 */
	public void setRightColor(int rightColor)
	{
		this.rightColor = rightColor;
		this.setBackgroundColor(rightColor);
		textViewRight.setBackgroundColor(rightColor);
	}

	/**
	 * Set text color of button
	 * 
	 * @param textColor
	 *            Text color
	 */
	public void setTextColor(int textColor)
	{
		this.textColor = textColor;
		textViewLeft.setTextColor(textColor);
		textViewRight.setTextColor(textColor);
	}

	/**
	 * Set left text of button
	 * 
	 * @param leftText
	 *            Left text
	 */
	public void setLeftText(String leftText)
	{
		this.leftText = leftText;
		textViewLeft.setText(leftText);
	}

	/**
	 * Set right text of button
	 * 
	 * @param rightText
	 *            Right text
	 */
	public void setRightText(String rightText)
	{
		this.rightText = rightText;
		textViewRight.setText(rightText);
	}

	/**
	 * Set text size of button
	 * 
	 * @param textSize
	 *            Text size
	 */
	public void setTextSize(float textSize)
	{
		this.textSize = textSize;
		textViewLeft.setTextSize(textSize);
		textViewRight.setTextSize(textSize);
	}

	@Override
	protected void drawableStateChanged()
	{
		if (isPressed())
		{
			textViewRight.setBackgroundColor(leftColor);
			textViewLeft.setBackgroundColor(rightColor);
			setBackgroundColor(leftColor);
		}
		else
		{
			textViewRight.setBackgroundColor(rightColor);
			textViewLeft.setBackgroundColor(leftColor);
			setBackgroundColor(rightColor);
		}

		super.drawableStateChanged();
	}
}