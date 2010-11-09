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

public class JPlasticStyle
	extends AbstractStyle
{
	public static final String ID = JPlasticStyle.class.getName();
	
	public JPlasticStyle()
	{
		gradientColor = new Color(166, 202, 240);
		selectionGradientColor = new Color(10, 36, 106);
		
		foreground = Color.white;
		selectionForeground = Color.white;
		
		background = UIManager.getColor("Panel.background");
		selectionBackground = new Color(166, 202, 240);
		
		tabbedPaneGradientColor = new Color(10, 36, 106);
		tabbedPaneBackground = new Color(166, 202, 240);
		
		tabbedPaneForeground = Color.black;
		tabbedPaneSelectionForeground = Color.white;
		
		border = new ShadowBorder();
		headerBorder = new RaisedHeaderBorder();
		labelBorder = BorderFactory.createEmptyBorder(2, 4, 2, 1);
	}
}