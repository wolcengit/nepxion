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

public interface IChartRenderer
{
	public void dispatchMouseOver(int row, int column);
	
	public void dispatchMouseDown(int row, int column);
	
	public int getSelectedRow();
	
	public int getSelectedColumn();
	
	public ChartRendererAdapter getAdapter();
}