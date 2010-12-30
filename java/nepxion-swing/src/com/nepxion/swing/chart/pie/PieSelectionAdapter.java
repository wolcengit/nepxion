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

import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.PieSectionEntity;

import com.nepxion.swing.chart.ChartConstants;

public class PieSelectionAdapter
	implements ChartMouseListener, ChartConstants
{		
	private IPieChartPlot piePlot;
	
	public PieSelectionAdapter()
	{

	}
	
	public void chartMouseMoved(ChartMouseEvent e)
	{
		adaptSelection(e, true);
	}
	
	public void chartMouseClicked(ChartMouseEvent e)
	{
		adaptSelection(e, false);
	}
	
	private void adaptSelection(ChartMouseEvent e, boolean isMouseOver)
	{
		JFreeChart chart = e.getChart();
		ChartEntity chartEntity = e.getEntity();
		
		if (chartEntity instanceof PieSectionEntity)
		{
			piePlot = (IPieChartPlot) chart.getPlot();
			
			PieSectionEntity pieSectionEntity = (PieSectionEntity) chartEntity;
			
			Comparable key = pieSectionEntity.getSectionKey();
			
			if (isMouseOver)
			{
				piePlot.dispatchMouseOver(key);
			}
			else
			{
				piePlot.dispatchMouseDown(key);
			}
		}
		else
		{
			if (piePlot != null)
			{	
				if (isMouseOver)
				{
					piePlot.dispatchMouseOver(null);
				}
				else
				{
					piePlot.dispatchMouseDown(null);
				}
			}
		}
	}
}