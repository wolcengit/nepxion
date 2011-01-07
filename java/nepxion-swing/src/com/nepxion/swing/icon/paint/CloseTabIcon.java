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
import java.awt.Rectangle;

import javax.swing.Icon;

public class CloseTabIcon
	implements Icon
{
	private int x;
	private int y;
	private int width;
	private int height;
	private int gap = 0;
	
	private boolean isHint = false;
	
	private CloseIcon closeIcon;
	private Icon icon;
	
	public CloseTabIcon(Icon icon)
	{
		this(icon, true, true, false, 0);
	}
	
	public CloseTabIcon(Icon icon, boolean isDrawBorder, boolean isDrawCenter, boolean isHint, int gap)
	{
		this.icon = icon;
		this.closeIcon = new CloseIcon(isDrawBorder, isDrawCenter);
		this.isHint = isHint;
		this.gap = gap;
		
		width = closeIcon.getIconWidth() + 2;
		height = closeIcon.getIconHeight() + 2;
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		this.x = x;
		this.y = y;
		
		if (closeIcon != null)
		{
			closeIcon.paintIcon(c, g, x - gap, y);
		}
		if (icon != null)
		{
			icon.paintIcon(c, g, x + width, y);
		}
	}
	
	public CloseIcon getCloseIcon()
	{
		return closeIcon;
	}
	
	public Icon getIcon()
	{
		return icon;
	}
	
	public int getIconWidth()
	{
		return width + (icon != null ? icon.getIconWidth() : 0);
	}
	
	public int getIconHeight()
	{
		return height;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x - gap, y, width, height);
	}
	
	public boolean isHint()
	{
		return isHint;
	}
	
	public void setHint(boolean isHint)
	{
		this.isHint = isHint;
	}
	
	public int getGap()
	{
		return gap;
	}
	
	public void setGap(int gap)
	{
		this.gap = gap;
	}
}