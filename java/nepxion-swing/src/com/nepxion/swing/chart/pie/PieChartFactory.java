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
import java.text.NumberFormat;

import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.util.Rotation;

import com.nepxion.swing.locale.SwingLocale;

public class PieChartFactory
{
	public static PiePlot createPiePlot(PieDataset pieDataset, boolean is3D, String toolTipTextKeyLabel, String toolTipTextValueLabel, String legendToolTipText)
	{
		PiePlot piePlot = createPiePlot(pieDataset, is3D, false, false, false);
		
		setPiePlotPreference(piePlot, toolTipTextKeyLabel, toolTipTextValueLabel, legendToolTipText);
		
		return piePlot;
	}
	
	public static PiePlot createPiePlot(PieDataset pieDataset, boolean is3D, boolean labels, boolean tooltips, boolean urls)
	{
		PiePlot piePlot = null;
		if (is3D)
		{
			piePlot = new PiePlot3D(pieDataset);
		}
		else
		{
			piePlot = new PiePlot(pieDataset);
		}
		
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
	
	public static void setPiePlotPreference(PiePlot piePlot, String toolTipTextKeyLabel, String toolTipTextValueLabel, String legendToolTipText)
	{
		piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} : {2}", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance()));
		piePlot.setToolTipGenerator(new StandardPieToolTipGenerator("{0} : " + toolTipTextValueLabel + " [{1}], " + SwingLocale.getString("percent") + " [{2}], " + SwingLocale.getString("total") + " [{3}]"));
		piePlot.setLegendLabelToolTipGenerator(new StandardPieSectionLabelGenerator(legendToolTipText + " - {0}"));
				
		piePlot.setInsets(new RectangleInsets(4.0, 8.0, 0.0, 8.0)); // 4.0, 8.0, 4.0, 8.0
		piePlot.setDirection(Rotation.ANTICLOCKWISE);
		piePlot.setStartAngle(270D);
		piePlot.setForegroundAlpha(0.75F);
		piePlot.setSimpleLabels(false);
		piePlot.setBackgroundPaint(new GradientPaint(0.0F, 0.0F, new Color(128, 128, 128), 0.0F, 0.0F, new Color(251, 251, 251), true));
	}
}