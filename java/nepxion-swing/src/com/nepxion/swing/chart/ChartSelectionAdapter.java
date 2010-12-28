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

import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;

public class ChartSelectionAdapter
	implements ChartMouseListener
{
	private IChartRenderer chartRenderer;
	
	public ChartSelectionAdapter()
	{
		
	}
	
	public void chartMouseClicked(ChartMouseEvent e)
	{
		adaptSelection(e, true);
	}
	
	public void chartMouseMoved(ChartMouseEvent e)
	{
		adaptSelection(e, false);
	}
	
	private void adaptSelection(ChartMouseEvent e, boolean isMouseDown)
	{
		JFreeChart chart = e.getChart();
		ChartEntity chartEntity = e.getEntity();
		
		if (chartEntity instanceof CategoryItemEntity)
		{
			CategoryItemEntity categoryItemEntity = (CategoryItemEntity) chartEntity;
			CategoryDataset categoryDataset = categoryItemEntity.getDataset();
			CategoryPlot categoryPlot = chart.getCategoryPlot();
			
			Comparable rowKey = categoryItemEntity.getRowKey();
			Comparable columnKey = categoryItemEntity.getColumnKey();
			
			int rowIndex = categoryDataset.getRowIndex(rowKey);
			int columnIndex = categoryDataset.getColumnIndex(columnKey);
			
			chartRenderer = (IChartRenderer) categoryPlot.getRenderer();
			if (isMouseDown)
			{
				chartRenderer.dispatchMouseDown(rowIndex, columnIndex);
			}
			else
			{
				chartRenderer.dispatchMouseOver(rowIndex, columnIndex);
			}
		}
		else if (chartEntity instanceof XYItemEntity)
		{
			// XYPlot xyPlot = chart.getXYPlot();
		}
		else
		{
			if (chartRenderer != null)
			{
				if (isMouseDown)
				{
					chartRenderer.dispatchMouseDown(-1, -1);
				}
				else
				{
					chartRenderer.dispatchMouseOver(-1, -1);
				}
			}
		}
	}
}