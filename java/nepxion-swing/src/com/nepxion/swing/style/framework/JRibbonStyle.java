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

public class JRibbonStyle
	extends AbstractStyle
{
	public static final String ID = JRibbonStyle.class.getName();
	
	public JRibbonStyle()
	{
		gradientColor = new Color(115, 164, 209);
		selectionGradientColor = new Color(57, 105, 138);
		
		foreground = Color.white;
		selectionForeground = Color.white;
		
		background = UIManager.getColor("Panel.background");
		selectionBackground = UIManager.getColor("Panel.background");
		
		tabbedPaneGradientColor = Color.white; // new Color(255, 239, 191);
		tabbedPaneBackground = new Color(231, 239, 248);
		
		tabbedPaneForeground = Color.black;
		tabbedPaneSelectionForeground = Color.black;
		
		border = new ShadowBorder(new Color(167, 172, 180));
		headerBorder = new RaisedHeaderBorder(Color.white, new Color(182, 186, 194)); // new Color(167, 172, 180)
		labelBorder = BorderFactory.createEmptyBorder(2, 4, 2, 1);
	}
}