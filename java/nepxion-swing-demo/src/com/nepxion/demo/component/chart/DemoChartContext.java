package com.nepxion.demo.component.chart;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

public class DemoChartContext
{
	private static DemoPieChartPanel pieChartPanel;
	private static DemoLineChartPanel lineChartPanel;
	
	public static void registerPieChartPanel(DemoPieChartPanel custmoPieChartPanel)
	{
		pieChartPanel = custmoPieChartPanel;
	}
	
	public static void registerLineChartPanel(DemoLineChartPanel custmoLineChartPanel)
	{
		lineChartPanel = custmoLineChartPanel;
	}

	public static DemoPieChartPanel getPieChartPanel()
	{
		return pieChartPanel;
	}
	
	public static DemoLineChartPanel getLineChartPanel()
	{
		return lineChartPanel;
	}
}