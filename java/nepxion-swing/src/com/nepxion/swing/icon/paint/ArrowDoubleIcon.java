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
import javax.swing.SwingConstants;

public class ArrowDoubleIcon
	implements Icon, SwingConstants
{
	private ArrowIcon arrowIcon1;
	private ArrowIcon arrowIcon2;
	private int singleSize;
	private int direction;
	
	public ArrowDoubleIcon(int singleSize, int direction)
	{
		this.singleSize = singleSize;
		
		arrowIcon1 = new ArrowIcon(singleSize, direction);
		arrowIcon2 = new ArrowIcon(singleSize, direction);
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		if (arrowIcon1 != null)
		{
			arrowIcon1.paintIcon(c, g, x, y);
		}
		if (arrowIcon2 != null)
		{
			if (direction == NORTH || direction == SOUTH)
			{
				arrowIcon2.paintIcon(c, g, x, y + singleSize);
			}
			else
			{
				arrowIcon2.paintIcon(c, g, x + singleSize, y);
			}
		}
	}
	
	public int getIconWidth()
	{
		if (direction == NORTH || direction == SOUTH)
		{
			return singleSize;
		}
		else
		{
			return singleSize * 2;
		}
	}
	
	public int getIconHeight()
	{
		if (direction == NORTH || direction == SOUTH)
		{
			return singleSize * 2;
		}
		else
		{
			return singleSize;
		}
	}
}