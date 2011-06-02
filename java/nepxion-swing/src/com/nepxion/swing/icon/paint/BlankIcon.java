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
	/**
	 * The instance of Color.
	 */
	private Color color;
	
	/**
	 * The size value.
	 */
	private int size;
	
	/**
	 * Constructs with the default.
	 */
	public BlankIcon()
	{
		this(null, 8);
	}
	
	/**
	 * Constructs with the specified initial color and size.
	 * @param color
	 * @param size
	 */
	public BlankIcon(Color color, int size)
	{
		this.color = color;
		this.size = size;
	}
	
	/**
	 * Gets the icon width.
	 * @return the icon width value.
	 */
	public int getIconWidth()
	{
		return size;
	}
	
	/**
	 * Gets the icon height.
	 * @return the icon height value.
	 */
	public int getIconHeight()
	{
		return size;
	}
	
	/**
	 * Paints the icon.
	 * @param c the instance of Component
	 * @param g the instance of Graphics
	 * @param x the x value
	 * @param y the y value
	 */
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		if (color != null)
		{
			g.setColor(color);
			g.drawRect(x, y, size - 1, size - 1);
		}
	}
}