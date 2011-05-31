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

public class CombinationIcon
	implements Icon
{
	private Icon smallIcon;
	private Icon largeIcon;
	
	/**
	 * 
	 * @param smallIcon
	 * @param largeIcon
	 */
	public CombinationIcon(Icon smallIcon, Icon largeIcon)
	{
		this.smallIcon = smallIcon;
		this.largeIcon = largeIcon;
	}
	
	public Icon getSmallIcon()
	{
		return smallIcon;
	}

	public void setSmallIcon(Icon smallIcon)
	{
		this.smallIcon = smallIcon;
	}

	public Icon getLargeIcon()
	{
		return largeIcon;
	}

	public void setLargeIcon(Icon largeIcon)
	{
		this.largeIcon = largeIcon;
	}
		
	public int getIconWidth()
	{
		return largeIcon.getIconWidth();
	}
	
	public int getIconHeight()
	{
		return largeIcon.getIconHeight();
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		largeIcon.paintIcon(c, g, x, y);
		smallIcon.paintIcon(c, g, x + getIconWidth() / 2 - smallIcon.getIconWidth() / 2, y + getIconHeight() / 2 - smallIcon.getIconHeight() / 2);
	}
}