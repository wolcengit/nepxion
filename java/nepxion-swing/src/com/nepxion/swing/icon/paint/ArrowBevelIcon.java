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
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class ArrowBevelIcon
	implements Icon, SwingConstants
{	
	private static final int DEFAULT_SIZE = 11;
	
	private Color edge1;
	private Color edge2;
	private Color fill;
	private int size;
	private int direction;
	
	/**
	 * 
	 * @param direction
	 * @param isRaisedView
	 * @param isPressedView
	 */
	public ArrowBevelIcon(int direction, boolean isRaisedView, boolean isPressedView)
	{
		// init(UIManager.getColor("controlDkShadow"), UIManager.getColor("controlLtHighlight"), UIManager.getColor("controlShadow"), DEFAULT_SIZE, direction);
		
		if (isRaisedView)
		{
			if (isPressedView)
			{
				init(UIManager.getColor("controlLtHighlight"), UIManager.getColor("controlDkShadow"), UIManager.getColor("controlShadow"), DEFAULT_SIZE, direction);
			}
			else
			{
				init(UIManager.getColor("controlHighlight"), UIManager.getColor("controlShadow"), UIManager.getColor("control"), DEFAULT_SIZE, direction);
			}
		}
		else
		{
			if (isPressedView)
			{
				init(UIManager.getColor("controlDkShadow"), UIManager.getColor("controlLtHighlight"), UIManager.getColor("controlShadow"), DEFAULT_SIZE, direction);
			}
			else
			{
				init(UIManager.getColor("controlShadow"), UIManager.getColor("controlHighlight"), UIManager.getColor("control"), DEFAULT_SIZE, direction);
			}
		}
	}
	
	/**
	 * 
	 * @param edge1
	 * @param edge2
	 * @param fill
	 * @param size
	 * @param direction
	 */
	public ArrowBevelIcon(Color edge1, Color edge2, Color fill, int size, int direction)
	{
		init(edge1, edge2, fill, size, direction);
	}
	
	/**
	 * 
	 * @param edge1
	 * @param edge2
	 * @param fill
	 * @param size
	 * @param direction
	 */
	private void init(Color edge1, Color edge2, Color fill, int size, int direction)
	{
		this.edge1 = edge1;
		this.edge2 = edge2;
		this.fill = fill;
		this.size = size;
		this.direction = direction;
	}
		
	/**
	 * 
	 * @param g
	 * @param xo
	 * @param yo
	 */
	private void paintUpArrow(Graphics g, int xo, int yo)
	{
		g.setColor(edge1);
		int x = xo + (size / 2);
		g.drawLine(x, yo, x, yo);
		x--;
		int y = yo + 1;
		int dx = 0;
		while (y + 3 < yo + size)
		{
			g.setColor(edge1);
			g.drawLine(x, y, x + 1, y);
			g.drawLine(x, y + 1, x + 1, y + 1);
			if (0 < dx)
			{
				g.setColor(fill);
				g.drawLine(x + 2, y, x + 1 + dx, y);
				g.drawLine(x + 2, y + 1, x + 1 + dx, y + 1);
			}
			g.setColor(edge2);
			g.drawLine(x + dx + 2, y, x + dx + 3, y);
			g.drawLine(x + dx + 2, y + 1, x + dx + 3, y + 1);
			x -= 1;
			y += 2;
			dx += 2;
		}
		g.setColor(edge1);
		g.drawLine(xo, yo + size - 3, xo + 1, yo + size - 3);
		g.setColor(edge2);
		g.drawLine(xo + 2, yo + size - 2, xo + size - 1, yo + size - 2);
		g.drawLine(xo, yo + size - 1, xo + size, yo + size - 1);
	}
	
	/**
	 * 
	 * @param g
	 * @param xo
	 * @param yo
	 */
	private void paintDownArrow(Graphics g, int xo, int yo)
	{
		g.setColor(edge1);
		g.drawLine(xo, yo, xo + size - 1, yo);
		g.drawLine(xo, yo + 1, xo + size - 3, yo + 1);
		g.setColor(edge2);
		g.drawLine(xo + size - 2, yo + 1, xo + size - 1, yo + 1);
		int x = xo + 1;
		int y = yo + 2;
		int dx = size - 6;
		while (y + 1 < yo + size)
		{
			g.setColor(edge1);
			g.drawLine(x, y, x + 1, y);
			g.drawLine(x, y + 1, x + 1, y + 1);
			if (0 < dx)
			{
				g.setColor(fill);
				g.drawLine(x + 2, y, x + 1 + dx, y);
				g.drawLine(x + 2, y + 1, x + 1 + dx, y + 1);
			}
			g.setColor(edge2);
			g.drawLine(x + dx + 2, y, x + dx + 3, y);
			g.drawLine(x + dx + 2, y + 1, x + dx + 3, y + 1);
			x += 1;
			y += 2;
			dx -= 2;
		}
		g.setColor(edge1);
		g.drawLine(xo + (size / 2), yo + size - 1, xo + (size / 2), yo + size - 1);
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
		switch (direction)
		{
			case NORTH:
				paintUpArrow(g, x, y);
				break;
			case SOUTH:
				paintDownArrow(g, x, y);
				break;
		}
	}
}