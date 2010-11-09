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

public class JBlueStyle
	extends JLiteStyle
{
	public static final String ID = JBlueStyle.class.getName();
	
	public JBlueStyle()
	{
		setSelectionGradientColor(new Color(193, 210, 238));
	}
}