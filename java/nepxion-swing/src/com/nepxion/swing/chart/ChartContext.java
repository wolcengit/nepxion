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

public class ChartContext
	implements ChartConstants
{	
	private static String chartPDFAuthor = DEFAULT_CHART_PDF_AUTHOR;
	private static String chartPDFSubject = DEFAULT_CHART_PDF_SUBJECT;
	
	public static void registerChartPDFAuthor(String chartPDFAuthor)
	{
		ChartContext.chartPDFAuthor = chartPDFAuthor;
	}
	
	public static String getChartPDFAuthor()
	{
		return chartPDFAuthor;
	}
	
	public static void registerChartPDFSubject(String chartPDFSubject)
	{
		ChartContext.chartPDFSubject = chartPDFSubject;
	}
	
	public static String getChartPDFSubject()
	{
		return chartPDFSubject;
	}
}