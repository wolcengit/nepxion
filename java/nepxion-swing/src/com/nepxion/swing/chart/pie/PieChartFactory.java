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

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;

import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.Rotation;

import com.nepxion.swing.chart.JChartFactory;
import com.nepxion.swing.locale.SwingLocale;

public class PieChartFactory
{
	public static PiePlot createPiePlot(PieDataset pieDataset, String toolTipText, String legendToolTipText)
	{
		PiePlot piePlot = createPiePlot(pieDataset, false, false, false);
		
		setPiePlotPreference(piePlot, toolTipText, legendToolTipText);
		
		return piePlot;
	}
	
	public static PiePlot createPiePlot(PieDataset pieDataset, boolean labels, boolean tooltips, boolean urls)
	{
		PiePlot piePlot = new PieChartPlot(pieDataset);
		
		if (labels)
		{
			piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator());
		}
		if (tooltips)
		{
			piePlot.setToolTipGenerator(new StandardPieToolTipGenerator());
		}
		if (urls)
		{
			piePlot.setURLGenerator(new StandardPieURLGenerator());
		}
		
		return piePlot;
	}
	
	public static PiePlot createPiePlot3D(PieDataset pieDataset, String toolTipText, String legendToolTipText)
	{
		PiePlot piePlot = createPiePlot3D(pieDataset, false, false, false);
		
		setPiePlotPreference(piePlot, toolTipText, legendToolTipText);
		
		return piePlot;
	}
	
	public static PiePlot createPiePlot3D(PieDataset pieDataset, boolean labels, boolean tooltips, boolean urls)
	{
		PiePlot piePlot = new PieChartPlot3D(pieDataset);

		if (labels)
		{
			piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator());
		}
		if (tooltips)
		{
			piePlot.setToolTipGenerator(new StandardPieToolTipGenerator());
		}
		if (urls)
		{
			piePlot.setURLGenerator(new StandardPieURLGenerator());
		}
		
		return piePlot;
	}
	
	public static void setPiePlotPreference(PiePlot piePlot, String toolTipText, String legendToolTipText)
	{
		piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} : {2}", NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));
		piePlot.setToolTipGenerator(new StandardPieToolTipGenerator("{0} : " + toolTipText + " [{1}], " + SwingLocale.getString("percent") + " [{2}], " + SwingLocale.getString("total") + " [{3}]", NumberFormat.getNumberInstance(), new DecimalFormat("0.00%")));
		piePlot.setLegendLabelToolTipGenerator(new StandardPieSectionLabelGenerator(legendToolTipText + " - {0}"));
		
		piePlot.setInsets(new RectangleInsets(4.0, 8.0, 0.0, 8.0)); // 4.0, 8.0, 4.0, 8.0
		piePlot.setDirection(Rotation.ANTICLOCKWISE);
		piePlot.setStartAngle(270D);
		piePlot.setForegroundAlpha(0.75F);
		piePlot.setSimpleLabels(false);
		piePlot.setBackgroundPaint(new GradientPaint(0.0F, 0.0F, new Color(128, 128, 128), 0.0F, 0.0F, new Color(251, 251, 251), true));
	}
	
	public static void setSectionPaint(PiePlot piePlot)
	{	
		int colorIndex = 0;
		
		for (Iterator iterator = piePlot.getDataset().getKeys().iterator(); iterator.hasNext();)
		{
			Comparable key = (Comparable) iterator.next();
			
			setSectionPaint(piePlot, key, colorIndex);
		
			colorIndex++;
		}	
	}
	
	public static void setSectionPaint(PiePlot piePlot, Comparable key, int colorIndex)
	{				
		Paint paint = JChartFactory.getPaint(colorIndex);

		piePlot.setSectionPaint(key, paint);
	}
}