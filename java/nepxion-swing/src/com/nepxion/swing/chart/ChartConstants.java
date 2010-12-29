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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;

public interface ChartConstants
{
	public final static String CHART_TYPE_BAR = "BarChart";
	public final static String CHART_TYPE_PIE = "PieChart";
	public final static String CHART_TYPE_LINE = "LineChart";
	
	public static final String DEFAULT_CHART_PDF_AUTHOR = "Haojun Ren";
	public static final String DEFAULT_CHART_PDF_SUBJECT = "Nepxion";
	
	public static final Paint MOUSE_OVER_PAINT = Color.green;
	public static final Paint MOUSE_DOWN_PAINT = Color.yellow;
	
	public static final Stroke MOUSE_OVER_STROKE = new BasicStroke(2.00F);
	public static final Stroke MOUSE_DOWN_STROKE = new BasicStroke(2.00F);
	
	public static final Double MOUSE_OVER_EXPLODE_PERCENT = Double.valueOf(0.00D);
	public static final Double MOUSE_DOWN_EXPLODE_PERCENT = Double.valueOf(0.05D);
}