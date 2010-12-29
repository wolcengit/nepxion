package com.nepxion.swing.chart.bar;

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

public class BarRendererAdapter
	implements ChartConstants
{
	private int mouserOverRow = -1;
	private int mouseOverColumn = -1;
	
	private int mouseDownRow = -1;
	private int mouseDownColumn = -1;
	
	public BarRendererAdapter()
	{

	}
	
	public void dispatchMouseOver(int row, int column)
	{
		if (mouserOverRow == row && mouseOverColumn == column)
		{
			return;
		}
		
		mouserOverRow = row;
		mouseOverColumn = column;		
	}
	
	public void dispatchMouseDown(int row, int column)
	{
		if (mouseDownRow == row && mouseDownColumn == column)
		{
			return;
		}
		
		mouseDownRow = row;
		mouseDownColumn = column;
	}
	
	public Stroke getItemOutlineStroke(int row, int column)
	{
		if (row == mouseDownRow && column == mouseDownColumn)
		{
			return MOUSE_DOWN_STROKE;
		}
		
		if (row == mouserOverRow && column == mouseOverColumn)
		{
			return MOUSE_OVER_STROKE;
		}
		
		return null;
	}
	
	public Paint getItemOutlinePaint(int row, int column)
	{
		if (row == mouseDownRow && column == mouseDownColumn)
		{
			return MOUSE_DOWN_PAINT;
		}
		
		if (row == mouserOverRow && column == mouseOverColumn)
		{
			return MOUSE_OVER_PAINT;
		}
		
		return null;
	}
	
	public int getSelectedRow()
	{
		return mouseDownRow;
	}
	
	public int getSelectedColumn()
	{
		return mouseDownColumn;
	}
}