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

public class CombinatedIcon
	implements Icon
{
	private Icon samllIcon;
	private Icon largeIcon;
	
	public CombinatedIcon(Icon smallIcon, Icon largeIcon)
	{
		this.samllIcon = smallIcon;
		this.largeIcon = largeIcon;
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		largeIcon.paintIcon(c, g, x, y);
		samllIcon.paintIcon(c, g, x + getIconWidth() / 2 - samllIcon.getIconWidth() / 2, y + getIconHeight() / 2 - samllIcon.getIconHeight() / 2);
	}
	
	public int getIconWidth()
	{
		return largeIcon.getIconWidth();
	}
	
	public int getIconHeight()
	{
		return largeIcon.getIconHeight();
	}
}