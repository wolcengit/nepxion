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

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.StandardGradientPaintTransformer;
import org.jfree.ui.TextAnchor;

public class CylinderBarChartFactory
	extends RectangleBarChartFactory
{
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
		
		CylinderRenderer cylinderRenderer = new CylinderRenderer();
		if (orientation == PlotOrientation.HORIZONTAL)
		{
			cylinderRenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.CENTER));
			cylinderRenderer.setBaseNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE9, TextAnchor.CENTER_LEFT));
			cylinderRenderer.setItemLabelAnchorOffset(20D);
		}
		else if (orientation == PlotOrientation.VERTICAL)
		{
			cylinderRenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
			cylinderRenderer.setBaseNegativeItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_CENTER));
			cylinderRenderer.setItemLabelAnchorOffset(5D);
		}
		
		if (labels)
		{
			cylinderRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		}
		if (tooltips)
		{
			cylinderRenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
		}
		if (urls)
		{
			cylinderRenderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator());
		}
		cylinderRenderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(orientation == PlotOrientation.VERTICAL ? GradientPaintTransformType.CENTER_HORIZONTAL : GradientPaintTransformType.CENTER_VERTICAL));
		
		CategoryPlot categoryPlot = new CategoryPlot(categoryDataset, categoryAxis, valueAxis, cylinderRenderer);
		categoryPlot.setOrientation(orientation);
		
		return categoryPlot;
	}
	
	public static class CylinderRenderer
		extends BarRenderer3D
	{
		public CylinderRenderer()
		{
		}
		
		public CylinderRenderer(double d, double d1)
		{
			super(d, d1);
		}
		
		public void drawItem(Graphics2D graphics2d, CategoryItemRendererState categoryitemrendererstate, Rectangle2D rectangle2d, CategoryPlot categoryplot, CategoryAxis categoryaxis, ValueAxis valueaxis, CategoryDataset categorydataset, int i, int j, int k)
		{
			Number number = categorydataset.getValue(i, j);
			if (number == null)
			{
				return;
			}
			double d = number.doubleValue();
			Rectangle2D.Double double1 = new Rectangle2D.Double(rectangle2d.getX(), rectangle2d.getY() + getYOffset(), rectangle2d.getWidth() - getXOffset(), rectangle2d.getHeight() - getYOffset());
			PlotOrientation plotorientation = categoryplot.getOrientation();
			double d1 = calculateBarW0(categoryplot, plotorientation, double1, categoryaxis, categoryitemrendererstate, i, j);
			double ad[] = calculateBarL0L1(d);
			if (ad == null)
			{
				return;
			}
			RectangleEdge rectangleedge = categoryplot.getRangeAxisEdge();
			float f = (float) valueaxis.valueToJava2D(ad[0], double1, rectangleedge);
			float f1 = (float) valueaxis.valueToJava2D(ad[1], double1, rectangleedge);
			float f2 = Math.min(f, f1);
			float f3 = Math.abs(f1 - f);
			GeneralPath generalpath = new GeneralPath();
			Ellipse2D.Double double2 = null;
			if (plotorientation == PlotOrientation.HORIZONTAL)
			{
				generalpath.moveTo((float) ((double) f2 + getXOffset() / 2D), (float) d1);
				generalpath.lineTo((float) ((double) (f2 + f3) + getXOffset() / 2D), (float) d1);
				Arc2D.Double double3 = new Arc2D.Double(f2 + f3, d1, getXOffset(), categoryitemrendererstate.getBarWidth(), 90D, 180D, 0);
				generalpath.append(double3, true);
				generalpath.lineTo((float) ((double) f2 + getXOffset() / 2D), (float) (d1 + categoryitemrendererstate.getBarWidth()));
				double3 = new Arc2D.Double(f2, d1, getXOffset(), categoryitemrendererstate.getBarWidth(), 270D, -180D, 0);
				generalpath.append(double3, true);
				generalpath.closePath();
				double2 = new Ellipse2D.Double(f2 + f3, d1, getXOffset(), categoryitemrendererstate.getBarWidth());
			}
			else
			{
				generalpath.moveTo((float) d1, (float) ((double) f2 - getYOffset() / 2D));
				generalpath.lineTo((float) d1, (float) ((double) (f2 + f3) - getYOffset() / 2D));
				Arc2D.Double double4 = new Arc2D.Double(d1, (double) (f2 + f3) - getYOffset(), categoryitemrendererstate.getBarWidth(), getYOffset(), 180D, 180D, 0);
				generalpath.append(double4, true);
				generalpath.lineTo((float) (d1 + categoryitemrendererstate.getBarWidth()), (float) ((double) f2 - getYOffset() / 2D));
				double4 = new Arc2D.Double(d1, (double) f2 - getYOffset(), categoryitemrendererstate.getBarWidth(), getYOffset(), 0.0D, -180D, 0);
				generalpath.append(double4, true);
				generalpath.closePath();
				double2 = new Ellipse2D.Double(d1, (double) f2 - getYOffset(), categoryitemrendererstate.getBarWidth(), getYOffset());
			}
			Object obj = getItemPaint(i, j);
			if (getGradientPaintTransformer() != null && (obj instanceof GradientPaint))
			{
				GradientPaint gradientpaint = (GradientPaint) obj;
				obj = getGradientPaintTransformer().transform(gradientpaint, generalpath);
			}
			graphics2d.setPaint((Paint) obj);
			graphics2d.fill(generalpath);
			if (obj instanceof GradientPaint)
			{
				graphics2d.setPaint(((GradientPaint) obj).getColor2());
			}
			if (double2 != null)
			{
				graphics2d.fill(double2);
			}
			if (isDrawBarOutline() && categoryitemrendererstate.getBarWidth() > 3D)
			{
				graphics2d.setStroke(getItemOutlineStroke(i, j));
				graphics2d.setPaint(getItemOutlinePaint(i, j));
				graphics2d.draw(generalpath);
				if (double2 != null)
				{
					graphics2d.draw(double2);
				}
			}
			CategoryItemLabelGenerator categoryitemlabelgenerator = getItemLabelGenerator(i, j);
			if (categoryitemlabelgenerator != null && isItemLabelVisible(i, j))
			{
				drawItemLabel(graphics2d, categorydataset, i, j, categoryplot, categoryitemlabelgenerator, generalpath.getBounds2D(), d < 0.0D);
			}
			if (categoryitemrendererstate.getInfo() != null)
			{
				EntityCollection entitycollection = categoryitemrendererstate.getEntityCollection();
				if (entitycollection != null)
				{
					String s = null;
					CategoryToolTipGenerator categorytooltipgenerator = getToolTipGenerator(i, j);
					if (categorytooltipgenerator != null)
					{
						s = categorytooltipgenerator.generateToolTip(categorydataset, i, j);
					}
					String s1 = null;
					if (getItemURLGenerator(i, j) != null)
					{
						s1 = getItemURLGenerator(i, j).generateURL(categorydataset, i, j);
					}
					CategoryItemEntity categoryitementity = new CategoryItemEntity(generalpath.getBounds2D(), s, s1, categorydataset, categorydataset.getRowKey(i), categorydataset.getColumnKey(j));
					entitycollection.add(categoryitementity);
				}
			}
		}
	}
}