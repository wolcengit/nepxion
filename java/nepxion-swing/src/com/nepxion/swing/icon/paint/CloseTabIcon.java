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

import com.nepxion.swing.lookandfeel.LookAndFeelManager;

public class CloseTabIcon
	implements Icon
{
	private int x;
	private int y;
	private int width;
	private int height;
	
	private boolean isHint = false;
	
	private CloseIcon closeIcon;
	private Icon icon;
	
	public CloseTabIcon(Icon icon)
	{
		this(icon, true, true, false);
	}
	
	public CloseTabIcon(Icon icon, boolean isDrawBorder, boolean isDrawCenter, boolean isHint)
	{
		this.icon = icon;
		this.closeIcon = new CloseIcon(isDrawBorder, isDrawCenter);
		this.isHint = isHint;
		
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			width = closeIcon.getIconWidth() + 4;
			height = closeIcon.getIconHeight();
		}
		else
		{
			width = closeIcon.getIconWidth() + 4;
			height = closeIcon.getIconHeight() + 2;
		}
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		this.x = x;
		this.y = y;
		
		if (closeIcon != null)
		{
			if (LookAndFeelManager.isNimbusLookAndFeel())
			{
				closeIcon.paintIcon(c, g, x + 4, y);
			}
			else
			{
				closeIcon.paintIcon(c, g, x, y);
			}
		}
		
		if (icon != null)
		{
			if (LookAndFeelManager.isNimbusLookAndFeel())
			{
				icon.paintIcon(c, g, x + width + 4, y);
			}
			else
			{
				icon.paintIcon(c, g, x + width, y);
			}
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
		if (LookAndFeelManager.isNimbusLookAndFeel())
		{
			return new Rectangle(x + 4, y, closeIcon.getIconWidth(), closeIcon.getIconHeight());
		}
		else
		{
			return new Rectangle(x, y, closeIcon.getIconWidth(), closeIcon.getIconHeight());
		}
	}
	
	public boolean isHint()
	{
		return isHint;
	}
	
	public void setHint(boolean isHint)
	{
		this.isHint = isHint;
	}
}