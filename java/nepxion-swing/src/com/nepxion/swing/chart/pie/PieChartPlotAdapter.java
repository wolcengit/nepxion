package com.nepxion.swing.chart.pie;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Paint;
import java.awt.Stroke;

import com.nepxion.swing.chart.ChartConstants;

public class PieChartPlotAdapter
	implements ChartConstants
{
	private Comparable mouserOverKey;
	private Comparable mouseDownKey;
		
	public PieChartPlotAdapter()
	{

	}
	
	public void dispatchMouseOver(Comparable key)
	{
		if (mouserOverKey != null && mouserOverKey.equals(key))
		{
			return;
		}
		
		mouserOverKey = key;
	}
	
	public void dispatchMouseDown(Comparable key)
	{
		if (mouseDownKey != null && mouseDownKey.equals(key))
		{
			return;
		}
		
		mouseDownKey = key;
	}
	
	public Stroke getSectionOutlineStroke(Comparable key)
	{
		if (mouseDownKey != null && mouseDownKey.equals(key))
		{
			return MOUSE_DOWN_STROKE;
		}
		
		if (mouserOverKey != null && mouserOverKey.equals(key))
		{
			return MOUSE_OVER_STROKE;
		}
		
		return null;
	}
	
	public Paint getSectionOutlinePaint(Comparable key)
	{
		if (mouseDownKey != null && mouseDownKey.equals(key))
		{
			return MOUSE_DOWN_PAINT;
		}
		
		if (mouserOverKey != null && mouserOverKey.equals(key))
		{
			return MOUSE_OVER_PAINT;
		}
		
		return null;
	}
	
	public Comparable getSelectedKey()
	{
		return mouseDownKey;
	}
}