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

import com.nepxion.swing.style.texture.basic.JGrayTextureStyle;

public class JGrayHeaderTextureStyle
	extends JBasicHeaderTextureStyle
{
	public static final String STYLE_PATH = "skin/shrink/gray/";
	
	public JGrayHeaderTextureStyle()
	{
		super(JGrayTextureStyle.STYLE_PATH, STYLE_PATH);
		
		foreground = new Color(215, 215, 216);
		selectionForeground = new Color(215, 215, 216);
		
		borderColor = new Color(146, 151, 161);
	}
}