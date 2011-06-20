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

import com.nepxion.swing.style.texture.AbstractTextureStyle;

public class AbstractHeaderTextureStyle
	extends AbstractTextureStyle implements IHeaderTextureStyle
{
	protected ImageIcon resizeHandlerImageIcon;
	protected ImageIcon shrinkHandlerLeftImageIcon;
	protected ImageIcon shrinkHandlerRightImageIcon;
	
	protected Color borderColor;
	
	public ImageIcon getResizeHandlerImageIcon()
	{
		return resizeHandlerImageIcon;
	}
	
	public ImageIcon getShrinkHandlerLeftImageIcon()
	{
		return shrinkHandlerLeftImageIcon;
	}
	
	public ImageIcon getShrinkHandlerRightImageIcon()
	{
		return shrinkHandlerRightImageIcon;
	}
	
	public Color getBorderColor()
	{
		return borderColor;
	}
}