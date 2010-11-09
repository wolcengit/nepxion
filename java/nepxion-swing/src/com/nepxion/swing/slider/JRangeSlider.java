package com.nepxion.swing.slider;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.jidesoft.swing.RangeSlider;

public class JRangeSlider
	extends RangeSlider
{
	public JRangeSlider()
	{
		super();
	}
	
	public JRangeSlider(int orientation)
	{
		super(orientation);
	}
	
	public JRangeSlider(int min, int max)
	{
		super(min, max);
	}
	
	public JRangeSlider(int min, int max, int low, int high)
	{
		super(min, max, low, high);
	}
}