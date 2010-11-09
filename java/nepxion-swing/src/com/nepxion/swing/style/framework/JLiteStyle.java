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

import javax.swing.BorderFactory;
import javax.swing.UIManager;

import com.nepxion.swing.border.RaisedHeaderBorder;
import com.nepxion.swing.border.ShadowBorder;

public class JLiteStyle
	extends AbstractStyle
{
	public static final String ID = JLiteStyle.class.getName();
	
	public JLiteStyle()
	{
		gradientColor = UIManager.getColor("Panel.background");
		selectionGradientColor = UIManager.getColor("InternalFrame.activeTitleBackground") != null ? UIManager.getColor("InternalFrame.activeTitleBackground") : UIManager.getColor("Table.selectionBackground");
		
		foreground = Color.white;
		selectionForeground = Color.white;
		
		background = UIManager.getColor("Panel.background");
		selectionBackground = UIManager.getColor("Panel.background");
		
		tabbedPaneGradientColor = selectionGradientColor.darker();
		tabbedPaneBackground = new Color(selectionGradientColor.getRed(), selectionGradientColor.getGreen(), selectionGradientColor.getBlue(), 225);
		
		tabbedPaneForeground = Color.black;
		tabbedPaneSelectionForeground = Color.white;
		
		border = new ShadowBorder();
		headerBorder = new RaisedHeaderBorder();
		labelBorder = BorderFactory.createEmptyBorder(2, 4, 2, 1);
	}
	
	public void setSelectionGradientColor(Color color)
	{
		selectionGradientColor = color;
		tabbedPaneGradientColor = selectionGradientColor.darker();
		tabbedPaneBackground = new Color(selectionGradientColor.getRed(), selectionGradientColor.getGreen(), selectionGradientColor.getBlue(), 225);
	}
}