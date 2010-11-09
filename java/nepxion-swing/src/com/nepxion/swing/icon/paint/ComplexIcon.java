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

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class ComplexIcon
	implements Icon
{
	private Icon icon1;
	private Icon icon2;
	
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int width;
	private int height;
	
	public ComplexIcon(Icon icon1, Icon icon2, int x2, int y2, int width, int height)
	{
		this(icon1, icon2, 0, 0, x2, y2, width, height);
	}
	
	public ComplexIcon(Icon icon1, Icon icon2, int x1, int y1, int x2, int y2, int width, int height)
	{
		this.icon1 = icon1;
		this.icon2 = icon2;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.width = width;
		this.height = height;
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		if (icon1 != null)
		{
			icon1.paintIcon(c, g, x + x1, y + y1);
		}
		if (icon2 != null)
		{
			icon2.paintIcon(c, g, x + x2, y + y2);
		}
	}
	
	public int getIconWidth()
	{
		return width;
	}
	
	public int getIconHeight()
	{
		return height;
	}
}