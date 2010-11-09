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

public class ArrowEtchedIcon
	implements Icon, SwingConstants
{	
	private int direction;
	
	public ArrowEtchedIcon(int direction)
	{
		this.direction = direction;
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		switch (direction)
		{
			case NORTH:
				g.setColor(Color.gray);
								
				g.drawLine(x, y + 5, x, y + 6);
				g.drawLine(x + 1, y + 3, x + 1, y + 5);
				g.drawLine(x + 2, y + 1, x + 2, y + 3);
				g.drawLine(x + 3, y, x + 3, y + 1);
				
				g.setColor(Color.white);
				
				g.drawLine(x + 4, y, x + 4, y + 1);
				g.drawLine(x + 5, y + 1, x + 5, y + 3);
				g.drawLine(x + 6, y + 3, x + 6, y + 5);
				g.drawLine(x + 7, y + 5, x + 7, y + 6);
				
				g.drawLine(x + 1, y + 6, x + 6, y + 6);
				
				break;
			case SOUTH:
				g.setColor(Color.gray);
				
				g.drawLine(x, y, x, y + 1);
				g.drawLine(x + 1, y + 1, x + 1, y + 3);
				g.drawLine(x + 2, y + 3, x + 2, y + 5);
				g.drawLine(x + 3, y + 5, x + 3, y + 6);
				
				g.drawLine(x + 1, y, x + 6, y);
				
				g.setColor(Color.white);
				
				g.drawLine(x + 4, y + 5, x + 4, y + 6);
				g.drawLine(x + 5, y + 3, x + 5, y + 5);
				g.drawLine(x + 6, y + 1, x + 6, y + 3);
				g.drawLine(x + 7, y, x + 7, y + 1);
								
				break;
		}
	}
	
	public int getIconWidth()
	{
		return 8;
	}
	
	public int getIconHeight()
	{
		return 7;
	}
}