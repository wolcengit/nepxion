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

import java.awt.Color;
import java.awt.RenderingHints;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.title.Title;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.UnitType;

import com.nepxion.swing.font.FontContext;

public class JChartFactory
{
	public static JFreeChart createChart(String title, String subTitle, Plot plot)
	{
		JFreeChart chart = new JFreeChart(plot);
		
		chart.setTitle(new TextTitle(title));
		chart.addSubtitle(new TextTitle(subTitle));
		
		setChartPreference(chart);
		
		return chart;
	}
	
	public static void setChartPreference(JFreeChart chart)
	{
		chart.setBackgroundPaint(Color.white);
		
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setBackgroundPaint(new Color(128, 128, 128, 30));
		legendTitle.setMargin(new RectangleInsets(UnitType.ABSOLUTE, 5.0D, 5D, 5.0D, 5D));
		legendTitle.setPosition(RectangleEdge.BOTTOM);
		
		// Font
		chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
		
		TextTitle textTitle = chart.getTitle();
		if (textTitle != null)
		{
			textTitle.setFont(FontContext.getChartTitleFont());
		}
		
		for (int i = 0; i < chart.getSubtitleCount(); i++)
		{
			Title subTitle = chart.getSubtitle(i);
			if (subTitle instanceof TextTitle)
			{
				TextTitle subTextTitle = (TextTitle) subTitle;
				subTextTitle.setFont(FontContext.getChartSubTitleFont());
			}
		}
		
		if (legendTitle != null)
		{
			legendTitle.setItemFont(FontContext.getChartLabelFont());
		}
		
		Plot plot = chart.getPlot();
		if (plot != null)
		{
			if (plot instanceof PiePlot)
			{
				PiePlot piePlot = (PiePlot) plot;
				piePlot.setLabelFont(FontContext.getChartLabelFont());
				piePlot.setNoDataMessageFont(FontContext.getChartLabelFont());
			}
			else if (plot instanceof CategoryPlot)
			{
				CategoryPlot categoryPlot = (CategoryPlot) plot;
				for (int i = 0; i < categoryPlot.getDomainAxisCount(); i++)
				{
					CategoryAxis domainAxis = categoryPlot.getDomainAxis(i);
					if (domainAxis != null)
					{
						domainAxis.setLabelFont(FontContext.getChartLabelFont());
						domainAxis.setTickLabelFont(FontContext.getChartTickLabelFont());
					}
				}
				
				for (int i = 0; i < categoryPlot.getRangeAxisCount(); i++)
				{
					ValueAxis rangeAxis = categoryPlot.getRangeAxis(i);
					if (rangeAxis != null)
					{
						rangeAxis.setLabelFont(FontContext.getChartLabelFont());
						rangeAxis.setTickLabelFont(FontContext.getChartTickLabelFont());
					}
				}
			}
			else if (plot instanceof XYPlot)
			{
				XYPlot xyPlot = (XYPlot) plot;
				for (int i = 0; i < xyPlot.getDomainAxisCount(); i++)
				{
					ValueAxis domainAxis = xyPlot.getDomainAxis(i);
					if (domainAxis != null)
					{
						domainAxis.setLabelFont(FontContext.getChartLabelFont());
						domainAxis.setTickLabelFont(FontContext.getChartTickLabelFont());
					}
				}
				
				for (int i = 0; i < xyPlot.getRangeAxisCount(); i++)
				{
					ValueAxis rangeAxis = xyPlot.getRangeAxis(i);
					if (rangeAxis != null)
					{
						rangeAxis.setLabelFont(FontContext.getChartLabelFont());
						rangeAxis.setTickLabelFont(FontContext.getChartTickLabelFont());
					}
				}
			}
		}
	}
}