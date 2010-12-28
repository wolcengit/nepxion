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

import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.renderer.category.BarRenderer;

import com.nepxion.swing.chart.ChartRendererAdapter;
import com.nepxion.swing.chart.IChartRenderer;

public class RectangleBarRenderer
	extends BarRenderer implements IChartRenderer
{	
	private ChartRendererAdapter adapter;
	
	public RectangleBarRenderer()
	{
		super();
		
		adapter = new ChartRendererAdapter();
	}
	
	public void dispatchMouseOver(int row, int column)
	{	
		adapter.dispatchMouseOver(row, column);
		
		notifyListeners(new RendererChangeEvent(this));
	}
	
	public void dispatchMouseDown(int row, int column)
	{		
		adapter.dispatchMouseDown(row, column);
		
		notifyListeners(new RendererChangeEvent(this));
	}
	
	public Stroke getItemOutlineStroke(int row, int column)
	{
		Stroke stroke = adapter.getItemOutlineStroke(row, column);		
		if (stroke != null)
		{	
			return stroke;
		}
		
		return super.getItemOutlineStroke(row, column);
	}
	
	public Paint getItemOutlinePaint(int row, int column)
	{
		Paint paint = adapter.getItemOutlinePaint(row, column);		
		if (paint != null)
		{	
			return paint;
		}
		
		return super.getItemOutlinePaint(row, column);
	}
	
	public int getSelectedRow()
	{
		return adapter.getSelectedRow();
	}
	
	public int getSelectedColumn()
	{
		return adapter.getSelectedColumn();
	}
	
	public ChartRendererAdapter getAdapter()
	{
		return adapter;
	}
}