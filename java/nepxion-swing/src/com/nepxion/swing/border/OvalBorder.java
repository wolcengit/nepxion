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

public class OvalBorder
	implements Border
{
	private int width = 6;
	private int height = 6;
	private Color topColor = Color.white;
	private Color bottomColor = Color.gray;
	
	public OvalBorder()
	{
		this.width = 6;
		this.height = 6;
	}
	
	public OvalBorder(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
	public OvalBorder(int width, int height, Color topColor, Color bottomColor)
	{
		this.width = width;
		this.height = height;
		this.topColor = topColor;
		this.bottomColor = bottomColor;
	}
	
	public Insets getBorderInsets(Component c)
	{
		return new Insets(height, width, height, width);
	}
	
	public boolean isBorderOpaque()
	{
		return true;
	}
	
	public void paintBorder(Component c, Graphics g, int x, int y, int w, int h)
	{
		w--;
		h--;
		g.setColor(topColor);
		g.drawLine(x, y + h - height, x, y + height);
		g.drawArc(x, y, 2 * width, 2 * height, 180, -90);
		g.drawLine(x + width, y, x + w - width, y);
		g.drawArc(x + w - 2 * width, y, 2 * width, 2 * height, 90, -90);
		
		g.setColor(bottomColor);
		g.drawLine(x + w, y + height, x + w, y + h - height);
		g.drawArc(x + w - 2 * width, y + h - 2 * height, 2 * width, 2 * height, 0, -90);
		g.drawLine(x + width, y + h, x + w - width, y + h);
		g.drawArc(x, y + h - 2 * height, 2 * width, 2 * height, -90, -90);
	}
}