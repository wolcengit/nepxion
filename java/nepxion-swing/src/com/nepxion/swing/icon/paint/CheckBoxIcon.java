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

public class CheckBoxIcon
	implements Icon
{
	private Icon backgroundIcon;
	private Color checkColor;
	private Color focusColor;
	private boolean selected;
	private boolean focused;
	
	public CheckBoxIcon(Icon backgroundIcon, Color checkColor, Color focusColor, boolean selected, boolean focused)
	{
		this.backgroundIcon = backgroundIcon;
		this.checkColor = checkColor;
		this.focusColor = focusColor;
		this.selected = selected;
		this.focused = focused;
	}
	
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		if (backgroundIcon != null)
		{
			backgroundIcon.paintIcon(c, g, x, y);
		}
		
		if (selected)
		{
			g.setColor(checkColor);
			
			g.drawLine(x + 4, y + 6, x + 4, y + 8);
			g.drawLine(x + 5, y + 7, x + 5, y + 9);
			g.drawLine(x + 6, y + 8, x + 6, y + 10);
			g.drawLine(x + 7, y + 7, x + 7, y + 9);
			g.drawLine(x + 8, y + 6, x + 8, y + 8);
			g.drawLine(x + 9, y + 5, x + 9, y + 7);
			g.drawLine(x + 10, y + 4, x + 10, y + 6);
		}
		
		if (focused)
		{
			g.setColor(focusColor);
			g.drawRect(x + 2, y + 2, 10, 10);
		}
	}
	
	public Icon getBackgroundIcon()
	{
		return backgroundIcon;
	}
	
	public Color getCheckColor()
	{
		return checkColor;
	}
	
	public Color getFocusColor()
	{
		return focusColor;
	}
	
	public boolean isSelected()
	{
		return selected;
	}
	
	public boolean isFocused()
	{
		return focused;
	}
	
	public int getIconWidth()
	{
		return backgroundIcon.getIconWidth();
	}
	
	public int getIconHeight()
	{
		return backgroundIcon.getIconHeight();
	}
}