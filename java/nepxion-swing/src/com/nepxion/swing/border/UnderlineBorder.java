package com.nepxion.swing.border;

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
import java.awt.Insets;

import javax.swing.border.Border;

public class UnderlineBorder
	implements Border
{
	public UnderlineBorder()
	{
	}
	
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
	{
		g.setColor(Color.gray);
		g.drawLine(x, y + height - 3, x + width, y + height - 3);
	}
	
	public Insets getBorderInsets(Component c)
	{
		return new Insets(1, 3, 5, 3);
	}
	
	public boolean isBorderOpaque()
	{
		return true;
	}
}