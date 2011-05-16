package com.nepxion.swing.font;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class FontContext
	implements FontConstants
{	
	private static String fontName = DEFAULT_FONT_NAME;
	private static int fontStyle = DEFAULT_FONT_STYLE;
	private static int fontSize = DEFAULT_FONT_SIZE;
	
	private static String chartTitleFontName = DEFAULT_CHART_TITLE_FONT_NAME;
	private static int chartTitleFontStyle = DEFAULT_CHART_TITLE_FONT_STYLE;
	private static int chartTitleFontSize = DEFAULT_CHART_TITLE_FONT_SIZE;
	
	private static String chartSubTitleFontName = DEFAULT_CHART_SUB_TITLE_FONT_NAME;
	private static int chartSubTitleFontStyle = DEFAULT_CHART_SUB_TITLE_FONT_STYLE;
	private static int chartSubTitleFontSize = DEFAULT_CHART_SUB_TITLE_FONT_SIZE;
	
	private static String chartLabelFontName = DEFAULT_CHART_LABEL_FONT_NAME;
	private static int chartLabelFontStyle = DEFAULT_CHART_LABEL_FONT_STYLE;
	private static int chartLabelFontSize = DEFAULT_CHART_LABEL_FONT_SIZE;
	
	private static String chartTickLabelFontName = DEFAULT_CHART_TICK_LABEL_FONT_NAME;
	private static int chartTickLabelFontStyle = DEFAULT_CHART_TICK_LABEL_FONT_STYLE;
	private static int chartTickLabelFontSize = DEFAULT_CHART_TICK_LABEL_FONT_SIZE;
	
	private static Font font = new Font(fontName, fontStyle, fontSize);
	
	private static Font chartTitleFont = new Font(chartTitleFontName, chartTitleFontStyle, chartTitleFontSize);
	
	private static Font chartSubTitleFont = new Font(chartSubTitleFontName, chartSubTitleFontStyle, chartSubTitleFontSize);
	
	private static Font chartLabelFont = new Font(chartLabelFontName, chartLabelFontStyle, chartLabelFontSize);
	
	private static Font chartTickLabelFont = new Font(chartTickLabelFontName, chartTickLabelFontStyle, chartTickLabelFontSize);
	
	public static void registerFont(String fontName, int fontStyle, int fontSize)
	{
		boolean isRetrieved = retrieveFont(fontName);
		if (isRetrieved)
		{
			FontContext.fontName = fontName;
			FontContext.fontStyle = fontStyle;
			FontContext.fontSize = fontSize;
			
			font = new Font(fontName, fontStyle, fontSize);
		}
	}
	
	public static void registerChartTitleFont(String chartTitleFontName, int chartTitleFontStyle, int chartTitleFontSize)
	{
		boolean isRetrieved = retrieveFont(chartTitleFontName);
		if (isRetrieved)
		{
			FontContext.chartTitleFontName = chartTitleFontName;
			FontContext.chartTitleFontStyle = chartTitleFontStyle;
			FontContext.chartTitleFontSize = chartTitleFontSize;
			
			chartTitleFont = new Font(chartTitleFontName, chartTitleFontStyle, chartTitleFontSize);
		}		
	}
	
	public static void registerChartSubTitleFont(String chartSubTitleFontName, int chartSubTitleFontStyle, int chartSubTitleFontSize)
	{
		boolean isRetrieved = retrieveFont(chartSubTitleFontName);
		if (isRetrieved)
		{
			FontContext.chartSubTitleFontName = chartSubTitleFontName;
			FontContext.chartSubTitleFontStyle = chartSubTitleFontStyle;
			FontContext.chartSubTitleFontSize = chartSubTitleFontSize;
			
			chartSubTitleFont = new Font(chartSubTitleFontName, chartSubTitleFontStyle, chartSubTitleFontSize);			
		}
	}
	
	public static void registerChartLabelFont(String chartLabelFontName, int chartLabelFontStyle, int chartLabelFontSize)
	{
		boolean isRetrieved = retrieveFont(chartLabelFontName);
		if (isRetrieved)
		{
			FontContext.chartLabelFontName = chartLabelFontName;
			FontContext.chartLabelFontStyle = chartLabelFontStyle;
			FontContext.chartLabelFontSize = chartLabelFontSize;
			
			chartLabelFont = new Font(chartLabelFontName, chartLabelFontStyle, chartLabelFontSize);			
		}
	}
	
	public static void registerChartTickLabelFont(String chartTickLabelFontName, int chartTickLabelFontStyle, int chartTickLabelFontSize)
	{
		boolean isRetrieved = retrieveFont(chartTickLabelFontName);
		if (isRetrieved)
		{
			FontContext.chartTickLabelFontName = chartTickLabelFontName;
			FontContext.chartTickLabelFontStyle = chartTickLabelFontStyle;
			FontContext.chartTickLabelFontSize = chartTickLabelFontSize;
			
			chartTickLabelFont = new Font(chartTickLabelFontName, chartTickLabelFontStyle, chartTickLabelFontSize);			
		}
	}
	
	public static String getFontName()
	{
		return fontName;
	}
	
	public static int getFontStyle()
	{
		return fontStyle;
	}
	
	public static int getFontSize()
	{
		return fontSize;
	}
	
	public static String getChartTitleFontName()
	{
		return chartTitleFontName;
	}
	
	public static int getChartTitleFontStyle()
	{
		return chartTitleFontStyle;
	}
	
	public static int getChartTitleFontSize()
	{
		return chartTitleFontSize;
	}
	
	public static String getChartSubTitleFontName()
	{
		return chartSubTitleFontName;
	}
	
	public static int getChartSubTitleFontStyle()
	{
		return chartSubTitleFontStyle;
	}
	
	public static int getChartSubTitleFontSize()
	{
		return chartSubTitleFontSize;
	}
	
	public static String getChartLabelFontName()
	{
		return chartLabelFontName;
	}
	
	public static int getChartLabelFontStyle()
	{
		return chartLabelFontStyle;
	}
	
	public static int getChartLabelFontSize()
	{
		return chartLabelFontSize;
	}
	
	public static String getChartTickLabelFontName()
	{
		return chartTickLabelFontName;
	}
	
	public static int getChartTickLabelFontStyle()
	{
		return chartTickLabelFontStyle;
	}
	
	public static int getChartTickLabelFontSize()
	{
		return chartTickLabelFontSize;
	}
		
	public static Font getFont()
	{		
		return font;
	}
	
	public static Font getChartTitleFont()
	{		
		return chartTitleFont;
	}
	
	public static Font getChartSubTitleFont()
	{		
		return chartSubTitleFont;
	}
	
	public static Font getChartLabelFont()
	{
		return chartLabelFont;
	}
	
	public static Font getChartTickLabelFont()
	{		
		return chartTickLabelFont;
	}
	
	public static boolean retrieveFont(String fontName)
	{
		String[] availableFontFamilyNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for (int i = 0; i < availableFontFamilyNames.length; i++)
		{
			if (availableFontFamilyNames[i].equals(fontName))
			{
				return true;
			}	
		}	
		
		return false;
	}	
}