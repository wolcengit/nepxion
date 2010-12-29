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

public interface IPieChartPlot
{
	public void dispatchMouseOver(Comparable key);
	
	public void dispatchMouseDown(Comparable key);
	
	public Comparable getSelectedKey();
	
	public PieChartPlotAdapter getAdapter();
}