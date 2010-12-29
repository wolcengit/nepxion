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

import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.PieDataset;

import com.nepxion.swing.chart.ChartConstants;

public class PieChartPlot
	extends PiePlot implements IPieChartPlot, ChartConstants
{
	private PieChartPlotAdapter adapter;
	
    public PieChartPlot()
    {
        super();
        
        adapter = new PieChartPlotAdapter();
    }

    public PieChartPlot(PieDataset dataset)
    {
    	super(dataset);
    	
    	adapter = new PieChartPlotAdapter();
    }

	public void dispatchMouseOver(Comparable key)
	{
		adapter.dispatchMouseOver(key);
	}
	
	public void dispatchMouseDown(Comparable key)
	{
		adapter.dispatchMouseDown(key);
	}
	
	public Stroke getSectionOutlineStroke(Comparable key)
	{
		Stroke stroke = adapter.getSectionOutlineStroke(key);		
		if (stroke != null)
		{	
			return stroke;
		}
		
		return super.getSectionOutlineStroke(key);
	}
	
	public Paint getSectionOutlinePaint(Comparable key)
	{
		Paint paint = adapter.getSectionOutlinePaint(key);		
		if (paint != null)
		{	
			return paint;
		}
		
		return super.getSectionOutlinePaint(key);
	}

	public Comparable getSelectedKey()
	{
		return adapter.getSelectedKey();
	}
	
	public PieChartPlotAdapter getAdapter()
	{
		return adapter;
	}
}