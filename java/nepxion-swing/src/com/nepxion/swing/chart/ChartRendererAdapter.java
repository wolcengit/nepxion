package com.nepxion.swing.chart;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;

public class ChartRendererAdapter
{
	private int mouserOverRow = -1;
	private int mouseOverColumn = -1;
	
	private int mouseDowndRow = -1;
	private int mouseDownColumn = -1;
	
	private Paint mouseOverPaint = Color.green;
	private Paint mouseDownPaint = Color.yellow;
	
	public ChartRendererAdapter()
	{
		super();
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
		if (mouseDowndRow == row && mouseDownColumn == column)
		{
			return;
		}
		
		mouseDowndRow = row;
		mouseDownColumn = column;
	}
	
	public Stroke getItemOutlineStroke(int row, int column)
	{
		if (row == mouseDowndRow && column == mouseDownColumn)
		{
			return new BasicStroke(2);
		}
		
		if (row == mouserOverRow && column == mouseOverColumn)
		{
			return new BasicStroke(2);
		}
		
		return null;
	}
	
	public Paint getItemOutlinePaint(int row, int column)
	{
		if (row == mouseDowndRow && column == mouseDownColumn)
		{
			return mouseDownPaint;
		}
		
		if (row == mouserOverRow && column == mouseOverColumn)
		{
			return mouseOverPaint;
		}
		
		return null;
	}
	
	public int getSelectedRow()
	{
		return mouseDowndRow;
	}
	
	public int getSelectedColumn()
	{
		return mouseDownColumn;
	}
}