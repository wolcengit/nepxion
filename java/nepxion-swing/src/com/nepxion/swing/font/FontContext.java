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
	
	private static Font font;
	
	private static Font chartTitleFont;
	
	private static Font chartSubTitleFont;
	
	private static Font chartLabelFont;
	
	private static Font chartTickLabelFont;
	
	public static void registerFont(String customFontName, int customFontStyle, int customFontSize)
	{
		fontName = customFontName;
		fontStyle = customFontStyle;
		fontSize = customFontSize;
	}
	
	public static void registerChartTitleFont(String customChartTitleFontName, int customChartTitleFontStyle, int customChartTitleFontSize)
	{
		chartTitleFontName = customChartTitleFontName;
		chartTitleFontStyle = customChartTitleFontStyle;
		chartTitleFontSize = customChartTitleFontSize;
	}
	
	public static void registerChartSubTitleFont(String customChartSubTitleFontName, int customChartSubTitleFontStyle, int customChartSubTitleFontSize)
	{
		chartSubTitleFontName = customChartSubTitleFontName;
		chartSubTitleFontStyle = customChartSubTitleFontStyle;
		chartSubTitleFontSize = customChartSubTitleFontSize;
	}
	
	public static void registerChartLabelFont(String customChartLabelFontName, int customChartLabelFontStyle, int customChartLabelFontSize)
	{
		chartLabelFontName = customChartLabelFontName;
		chartLabelFontStyle = customChartLabelFontStyle;
		chartLabelFontSize = customChartLabelFontSize;
	}
	
	public static void registerChartTickLabelFont(String customChartTickLabelFontName, int customChartTickLabelFontStyle, int customChartTickLabelFontSize)
	{
		chartTickLabelFontName = customChartTickLabelFontName;
		chartTickLabelFontStyle = customChartTickLabelFontStyle;
		chartTickLabelFontSize = customChartTickLabelFontSize;
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
		if (font == null)
		{
			font = new Font(fontName, fontStyle, fontSize);
		}
		return font;
	}
	
	public static Font getChartTitleFont()
	{
		if (chartTitleFont == null)
		{
			chartTitleFont = new Font(chartTitleFontName, chartTitleFontStyle, chartTitleFontSize);
		}
		return chartTitleFont;
	}
	
	public static Font getChartSubTitleFont()
	{
		if (chartSubTitleFont == null)
		{
			chartSubTitleFont = new Font(chartSubTitleFontName, chartSubTitleFontStyle, chartSubTitleFontSize);
		}
		return chartSubTitleFont;
	}
	
	public static Font getChartLabelFont()
	{
		if (chartLabelFont == null)
		{
			chartLabelFont = new Font(chartLabelFontName, chartLabelFontStyle, chartLabelFontSize);
		}
		return chartLabelFont;
	}
	
	public static Font getChartTickLabelFont()
	{
		if (chartTickLabelFont == null)
		{
			chartTickLabelFont = new Font(chartTickLabelFontName, chartTickLabelFontStyle, chartTickLabelFontSize);
		}
		return chartTickLabelFont;
	}
}