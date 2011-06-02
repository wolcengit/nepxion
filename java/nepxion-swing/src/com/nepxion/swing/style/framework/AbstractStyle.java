package com.nepxion.swing.style.framework;

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

import javax.swing.UIManager;
import javax.swing.border.Border;

public abstract class AbstractStyle
	implements IStyle
{
	protected Color gradientColor;
	protected Color selectionGradientColor;
	
	protected Color foreground;
	protected Color selectionForeground;
	
	protected Color background;
	protected Color selectionBackground;
	
	protected Color tabbedPaneGradientColor;
	protected Color tabbedPaneBackground;
	
	protected Color tabbedPaneForeground;
	protected Color tabbedPaneSelectionForeground;
	
	protected Color tabbedPaneNoDecoratedBackground;
	
	protected Color tabbedPaneBorderLineColor;
	
	protected Border border;
	protected Border headerBorder;
	protected Border labelBorder;
	
	public AbstractStyle()
	{
		tabbedPaneNoDecoratedBackground = UIManager.getColor("Panel.background");
	}
	
	public Color getGradientColor()
	{
		return gradientColor;
	}
	
	public Color getSelectionGradientColor()
	{
		return selectionGradientColor;
	}
	
	public Color getForeground()
	{
		return foreground;
	}
	
	public Color getSelectionForeground()
	{
		return selectionForeground;
	}
	
	public Color getBackground()
	{
		return background;
	}
	
	public Color getSelectionBackground()
	{
		return selectionBackground;
	}
	
	public Color getTabbedPaneGradientColor()
	{
		return tabbedPaneGradientColor;
	}
	
	public Color getTabbedPaneForeground()
	{
		return tabbedPaneForeground;
	}
	
	public Color getTabbedPaneBackground()
	{
		if (StyleContext.isTabbedPaneDecorated())
		{
			return tabbedPaneBackground;
		}
		
		return tabbedPaneNoDecoratedBackground;
	}
	
	public Color getTabbedPaneSelectionForeground()
	{
		return tabbedPaneSelectionForeground;
	}
	
	public Color getTabbedPaneBorderLineColor()
	{
		return tabbedPaneBorderLineColor;
	}
	
	public Border getBorder()
	{
		return border;
	}
	
	public Border getHeaderBorder()
	{
		return headerBorder;
	}
	
	public Border getLabelBorder()
	{
		return labelBorder;
	}
}