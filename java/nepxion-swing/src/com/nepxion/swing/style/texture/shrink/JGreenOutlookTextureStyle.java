package com.nepxion.swing.style.texture.shrink;

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

import com.nepxion.swing.style.texture.basic.JGreenTextureStyle;

public class JGreenOutlookTextureStyle
	extends JBasicOutlookTextureStyle
{
	public static final String STYLE_PATH = "skin/outlook/green/";
	
	public JGreenOutlookTextureStyle()
	{
		super(JGreenTextureStyle.STYLE_PATH, STYLE_PATH);
		
		foreground = new Color(120, 120, 125);
		selectionForeground = Color.white;
		
		borderColor = new Color(146, 151, 161);
		scrollBorderColor = new Color(233, 223, 207);
	}
}