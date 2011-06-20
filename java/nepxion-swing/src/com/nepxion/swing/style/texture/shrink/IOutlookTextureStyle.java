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

import javax.swing.ImageIcon;

import com.nepxion.swing.style.texture.ITextureStyle;

public interface IOutlookTextureStyle
	extends ITextureStyle
{
	public ImageIcon getHandlerImageIcon();
	
	public ImageIcon getSelectionHandlerImageIcon();
	
	public Color getBorderColor();
	
	public Color getScrollBorderColor();
}