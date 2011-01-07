package com.nepxion.swing.icon.paint;

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
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class BlankIcon
	implements Icon
{
	private Color fillColor;
	private int size;
	
	public BlankIcon()
	{
		this(null, 8);
	}
	
	public BlankIcon(Color color, int size)
	{
		fillColor = color;
		
		this.size = size;
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		if (fillColor != null)
		{
			g.setColor(fillColor);
			g.drawRect(x, y, size - 1, size - 1);
		}
	}
	
	public int getIconWidth()
	{
		return size;
	}
	
	public int getIconHeight()
	{
		return size;
	}
}