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

public class AbstractOutlookTextureStyle
	extends AbstractTextureStyle implements IOutlookTextureStyle
{
	protected ImageIcon handlerImageIcon;
	protected ImageIcon SelectionHandlerImageIcon;
	
	protected Color borderColor;
	protected Color scrollBorderColor;

	public ImageIcon getHandlerImageIcon()
	{
		return handlerImageIcon;
	}
	
	public ImageIcon getSelectionHandlerImageIcon()
	{
		return SelectionHandlerImageIcon;
	}
	
	public Color getBorderColor()
	{
		return borderColor;
	}
	
	public Color getScrollBorderColor()
	{
		return scrollBorderColor;
	}
}