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
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Icon;

public class GeoCellIcon
	implements Icon
{
	public static final int POINT = 0;
	public static final int LINE = 1;
	public static final int POLYGON = 2;
	
	private int iconIndex;
	private Color color;
	private Dimension size;
	
	public GeoCellIcon(int iconIndex, Color color)
	{
		this.iconIndex = iconIndex;
		this.color = color;
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		size = c.getSize();
		switch (iconIndex)
		{
			case POINT:
				drawPoint(x, y, g);
				break;
			case LINE:
				drawLine(x, y, g);
				break;
			case POLYGON:
				drawPolygon(x, y, g);
				break;
		}
	}
	
	public int getIconWidth()
	{
		switch (iconIndex)
		{
			case POINT:
				return 4;
			case LINE:
				return 10;
			case POLYGON:
				return 10;
		}
		return 0;
	}
	
	public int getIconHeight()
	{
		switch (iconIndex)
		{
			case POINT:
				return 4;
			case LINE:
				return 10;
			case POLYGON:
				return 10;
		}
		return 0;
	}
	
	private void drawPoint(int i, int j, Graphics g)
	{
		int x = (int) size.getWidth() / 2;
		int y = (int) size.getHeight() / 2;
		g.setColor(color);
		g.fillRect(x - 2, y - 2, 4, 4);
		
		g.setColor(Color.black);
		g.drawLine(x - 2, y - 2, x + 2, y - 2);
		g.drawLine(x - 2, y + 2, x + 2, y + 2);
		g.drawLine(x - 2, y - 2, x - 2, y + 2);
		g.drawLine(x + 2, y - 2, x + 2, y + 2);
	}
	
	private void drawLine(int i, int j, Graphics g)
	{
		int x = (int) size.getWidth() / 2;
		int y = (int) size.getHeight() / 2;
		g.setColor(color);
		
		g.drawLine(x - 2, y - 2, x + 1, y + 1);
		g.drawLine(x - 2, y - 2, x - 5, y + 5);
		g.drawLine(x + 1, y + 1, x + 4, y - 6);
	}
	
	private void drawPolygon(int i, int j, Graphics g)
	{
		int x = (int) size.getWidth() / 2;
		int y = (int) size.getHeight() / 2;
		g.setColor(color);
		g.fillRect(x - 5, y - 5, 10, 10);
		
		g.setColor(Color.black);
		g.drawLine(x - 5, y - 5, x + 5, y - 5);
		g.drawLine(x - 5, y + 5, x + 5, y + 5);
		g.drawLine(x - 5, y - 5, x - 5, y + 5);
		g.drawLine(x + 5, y - 5, x + 5, y + 5);
	}
}