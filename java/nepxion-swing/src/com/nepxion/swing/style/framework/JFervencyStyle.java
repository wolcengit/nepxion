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

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.border.RaisedHeaderBorder;

public class JFervencyStyle
	extends AbstractStyle
{
	public static final String ID = JFervencyStyle.class.getName();
	
	public JFervencyStyle()
	{
		gradientColor = new Color(76, 60, 24);
		selectionGradientColor = Color.black;
		
		foreground = Color.white;
		selectionForeground = Color.white;
		
		background = new Color(252, 198, 82);
		selectionBackground = new Color(252, 198, 82);
		
		tabbedPaneGradientColor = Color.black;
		tabbedPaneBackground = new Color(252, 198, 82).darker();
		
		tabbedPaneForeground = Color.black;
		tabbedPaneSelectionForeground = Color.white;
		
		
		border = BorderManager.createLineBorder(Color.gray, -1, 2, 2, 2); // 2, 2, 2, 2
		headerBorder = new RaisedHeaderBorder(Color.gray, Color.gray.brighter());
		labelBorder = BorderFactory.createEmptyBorder(2, 4, 2, 1);
	}
}