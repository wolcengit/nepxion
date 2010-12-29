package com.nepxion.swing.chart.bar;

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
import java.awt.GradientPaint;
import java.awt.Paint;
import java.text.NumberFormat;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.CategoryTextAnnotation;
import org.jfree.chart.axis.CategoryAnchor;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategorySeriesLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.Layer;
import org.jfree.ui.TextAnchor;
import org.jfree.util.SortOrder;

import com.nepxion.swing.chart.JChartFactory;
import com.nepxion.swing.chart.JChartPanel;
import com.nepxion.swing.font.FontContext;

public class RectangleBarChartFactory
{
	public static CategoryPlot createCategoryPlot(CategoryDataset categoryDataset, PlotOrientation orientation, String categoryAxisLabel, String valueAxisLabel, String toolTipText, String legendToolTipText, boolean isCategoryLabelRotated)
	{
		CategoryPlot categoryPlot = createCategoryPlot(categoryDataset, orientation, categoryAxisLabel, valueAxisLabel, true, true, false);
		
		setCategoryPlotPreference(categoryPlot, orientation, toolTipText, legendToolTipText, isCategoryLabelRotated, 1.0F);
		
		return categoryPlot;
	}
	
	public static CategoryPlot createCategoryPlot(CategoryDataset dataset, PlotOrientation orientation, String categoryAxisLabel, String valueAxisLabel, boolean labels, boolean tooltips, boolean urls)
	{
		if (orientation == null)
		{
			throw new IllegalArgumentException("Null 'orientation' argument.");
		}
		
		CategoryAxis categoryAxis = new CategoryAxis(categoryAxisLabel);
		ValueAxis valueAxis = new NumberAxis(valueAxisLabel);
		
		RectangleBarRenderer barRenderer = new RectangleBarRenderer();
		if (orientation == PlotOrientation.HORIZONTAL)
		{
			barRenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.CENTER_LEFT));
			barRenderer.setBaseNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE9, TextAnchor.CENTER_RIGHT));
		}
		else if (orientation == PlotOrientation.VERTICAL)
		{
			barRenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
			barRenderer.setBaseNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_CENTER));
		}
		
		if (labels)
		{
			barRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		}	
		if (tooltips)
		{
			barRenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
		}
		if (urls)
		{
			barRenderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
		}
		
		CategoryPlot categoryPlot = new CategoryPlot(dataset, categoryAxis, valueAxis, barRenderer);
		categoryPlot.setOrientation(orientation);
		
		return categoryPlot;
	}
	
	public static CategoryPlot createCategoryPlot3D(CategoryDataset categoryDataset, PlotOrientation orientation, String categoryAxisLabel, String valueAxisLabel, String toolTipText, String legendToolTipText, boolean isCategoryLabelRotated)
	{	
		CategoryPlot categoryPlot = createCategoryPlot3D(categoryDataset, orientation, categoryAxisLabel, valueAxisLabel, true, true, false);
	
		setCategoryPlotPreference(categoryPlot, orientation, toolTipText, legendToolTipText, isCategoryLabelRotated, 0.75F);
		
		return categoryPlot;
	}
	
	public static CategoryPlot createCategoryPlot3D(CategoryDataset categoryDataset, PlotOrientation orientation, String categoryAxisLabel, String valueAxisLabel, boolean labels, boolean tooltips, boolean urls)
	{
		if (orientation == null)
		{
			throw new IllegalArgumentException("Null 'orientation' argument.");
		}
		CategoryAxis categoryAxis = new CategoryAxis3D(categoryAxisLabel);
		ValueAxis valueAxis = new NumberAxis3D(valueAxisLabel);
		
		RectangleBarRenderer3D barRenderer3D = new RectangleBarRenderer3D();
		if (orientation == PlotOrientation.HORIZONTAL)
		{
			barRenderer3D.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.BOTTOM_LEFT));
			barRenderer3D.setBaseNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE9, TextAnchor.CENTER_LEFT));
			barRenderer3D.setItemLabelAnchorOffset(20D);
		}
		else if (orientation == PlotOrientation.VERTICAL)
		{
			barRenderer3D.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
			barRenderer3D.setBaseNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.BASELINE_CENTER));
			barRenderer3D.setItemLabelAnchorOffset(12D);
		}
		
		if (labels)
		{
			barRenderer3D.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		}	
		if (tooltips)
		{
			barRenderer3D.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
		}
		if (urls)
		{
			barRenderer3D.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
		}
		
		CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis, valueAxis, barRenderer3D);
		categoryPlot.setOrientation(orientation);
		
		return categoryPlot;
	}
	
	public static void setCategoryPlotPreference(CategoryPlot categoryPlot, PlotOrientation orientation, String toolTipText, String legendToolTipText, boolean isCategoryLabelRotated, float foregroundAlpha)
	{
		// CategoryAxis categoryAxis = (CategoryAxis) categoryPlot.getDomainAxis();
		// CategoryLabelPositions categoryLabelPositions = categoryAxis.getCategoryLabelPositions();
		// CategoryLabelPosition categorylabelposition = new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.CENTER_LEFT, TextAnchor.CENTER_LEFT, 0.0D, CategoryLabelWidthType.RANGE, 0.3F);
		// categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.replaceLeftPosition(categoryLabelPositions, categorylabelposition));
		// categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.4D));
		// categoryAxis.setCategoryMargin(0.0D);
		
		BarRenderer barRenderer = (BarRenderer) categoryPlot.getRenderer();
		
		barRenderer.setBaseItemLabelsVisible(true);
		barRenderer.setMaximumBarWidth(0.05D);
		barRenderer.setDrawBarOutline(true);
		// barRenderer3D.setBaseOutlineStroke(new BasicStroke(0.3F));
		barRenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());		
		barRenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator("{1} : " + toolTipText + " [{2}]", NumberFormat.getNumberInstance()));
		barRenderer.setLegendItemToolTipGenerator(new StandardCategorySeriesLabelGenerator(legendToolTipText + " - {0}"));
		
		// if (orientation == PlotOrientation.HORIZONTAL)
		// {
		categoryPlot.setRowRenderingOrder(SortOrder.DESCENDING);
		categoryPlot.setColumnRenderingOrder(SortOrder.DESCENDING);
		//}		

		// NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();
		// numberAxis.setUpperMargin(0.1D);
		// numberAxis.setNumberFormatOverride(NumberFormat.getPercentInstance());

		if (isCategoryLabelRotated)
		{	
			categoryPlot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.toRadians(30D)));
		}
		categoryPlot.getDomainAxis().setUpperMargin(0.03D);
		categoryPlot.getDomainAxis().setLowerMargin(0.03D);
		categoryPlot.getRangeAxis().setUpperMargin(0.10000000000000001D);
		categoryPlot.setForegroundAlpha(foregroundAlpha);
		categoryPlot.setRangePannable(true);
		categoryPlot.setDomainGridlinesVisible(true);
		categoryPlot.setBackgroundPaint(new Color(128, 128, 128, 30));
	}
	
	public static void setSectionPaint(CategoryPlot categoryPlot, boolean is3D)
	{	
		for (int i = 0; i < categoryPlot.getDataset().getRowCount(); i++)
		{
			setSectionPaint(categoryPlot, is3D, i, i);
		}	
	}
	
	public static void setSectionPaint(CategoryPlot categoryPlot, boolean is3D, int seriesIndex, int colorIndex)
	{				
		Paint paint = null;
		if (is3D)
		{	
			paint = JChartFactory.getPaint(colorIndex);
		}
		else
		{
			paint = JChartFactory.getGradientPaint(colorIndex);
		}
		setSectionPaint(categoryPlot, seriesIndex, paint);
	}
		
	public static Paint getSectionPaint(CategoryPlot categoryPlot, int index)
	{
		BarRenderer barRenderer = (BarRenderer) categoryPlot.getRenderer();
		return barRenderer.getSeriesPaint(index);
	}
	
	public static void setSectionPaint(CategoryPlot categoryPlot, int index, Paint paint)
	{
		BarRenderer barRenderer = (BarRenderer) categoryPlot.getRenderer();
		barRenderer.setSeriesPaint(index, paint);
	}
	
	public static void setSectionPaint(CategoryPlot categoryPlot, int index, Color color1, Color color2)
	{
		BarRenderer barRenderer = (BarRenderer) categoryPlot.getRenderer();
		barRenderer.setSeriesPaint(index, new GradientPaint(0.0F, 0.0F, color1, 0.0F, 0.0F, color2));
	}
	
	public static void setValueMarker(CategoryPlot categoryPlot, Comparable category, String text, double value)
	{
		setValueMarker(categoryPlot, category, text, value, new Color(221, 221, 221));
	}
	
	public static void setValueMarker(CategoryPlot categoryPlot, Comparable category, String text, double value, Paint paint)
	{
		setValueMarker(categoryPlot, category, text, value, paint, new Color(128, 128, 128));
	}
	
	public static void setValueMarker(CategoryPlot categoryPlot, Comparable category, String text, double value, Paint paint, Paint outlinePaint)
	{
		ValueMarker valueMarker = new ValueMarker(value, paint, new BasicStroke(1.0F), outlinePaint, new BasicStroke(1.0F), 0.75F);
		categoryPlot.addRangeMarker(valueMarker, Layer.BACKGROUND);
		
		CategoryTextAnnotation categoryTextAnnotation = new CategoryTextAnnotation(text, category, value + 0.01D);
		categoryTextAnnotation.setCategoryAnchor(CategoryAnchor.START);
		categoryTextAnnotation.setFont(FontContext.getChartLabelFont());
		categoryTextAnnotation.setTextAnchor(TextAnchor.BOTTOM_LEFT);
		categoryPlot.addAnnotation(categoryTextAnnotation);
	}
	
	public static int[] getCategoryPlotSelectionIndexes(JChartPanel chartPanel)
	{
		JFreeChart chart = chartPanel.getChart();	
	
		return getCategoryPlotSelectionIndexes(chart);
	}
	
	public static int[] getCategoryPlotSelectionIndexes(JFreeChart chart)
	{
		CategoryItemRenderer itemRenderer = chart.getCategoryPlot().getRenderer();
		
		if (itemRenderer instanceof IBarRenderer)
		{
			IBarRenderer chartRenderer = (IBarRenderer) itemRenderer;
			
			int selectedRow = chartRenderer.getSelectedRow();
			int selectedColumn = chartRenderer.getSelectedColumn();
			
			return new int[] {selectedRow, selectedColumn};
		}	
		
		return null;
	}	
}