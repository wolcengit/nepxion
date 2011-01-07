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
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.border.Border;

public class HoverBorder
	implements Border
{
	private Dimension lastComponentSize;
	private int thickness;
	private Insets insets;
	private Color color;
	private Color color2;
	
	public HoverBorder(Color color, int thickness)
	{
		this.color = color;
		if (color == null)
		{
			this.color = color = Color.gray;
		}
		color2 = new Color(210, 210, 210, 0);
		this.thickness = thickness;
	}
	
	public Insets getBorderInsets(Component c)
	{
		Dimension currentComponent = c.getSize();
		
		if (currentComponent.equals(lastComponentSize))
		{
			return insets;
		}
		
		insets = new Insets(thickness, thickness, thickness, thickness);
		lastComponentSize = currentComponent;
		
		return insets;
	}
	
	public boolean isBorderOpaque()
	{
		return true;
	}
	
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
	{
		Graphics2D g2d = (Graphics2D) g.create();
		// »­ÉÏ±ßÔµ
		GradientPaint gp = new GradientPaint(x, y, color, x, y + thickness, color2);
		g2d.setPaint(gp);
		g2d.fillRect(x, y, width, thickness);
		// »­ÏÂ±ßÔµ
		gp = new GradientPaint(x, y + height - thickness - 1, color2, x, y + height, color);
		g2d.setPaint(gp);
		g2d.fillRect(x, y + height - thickness - 1, width, thickness);
		// »­×ó±ßÔµ
		gp = new GradientPaint(x, y, color, x + thickness, y, color2);
		g2d.setPaint(gp);
		g2d.fillRect(x, y, thickness, height);
		// »­ÓÒ±ßÔµ
		gp = new GradientPaint(x + width - thickness - 1, y, color2, x + width, y, color);
		g2d.setPaint(gp);
		g2d.fillRect(x + width - thickness - 1, y, thickness, height);
		// »­Íâ¿ò
		g2d.setPaint(color);
		g2d.drawRect(x, y, width - 1, height - 1);
		g2d.dispose();
	}
}