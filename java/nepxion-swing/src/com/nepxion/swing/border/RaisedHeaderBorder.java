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

import javax.swing.UIManager;
import javax.swing.border.AbstractBorder;

public class RaisedHeaderBorder
	extends AbstractBorder
{
	private static final Insets INSETS = new Insets(1, 1, 1, 0);
	
	private Color highlightColor;
	private Color shadowColor;
	
	public RaisedHeaderBorder()
	{
		this(null);
	}
	
	public RaisedHeaderBorder(Color highlightColor)
	{
		this(highlightColor, null);
	}
	
	public RaisedHeaderBorder(Color highlightColor, Color shadowColor)
	{
		this.highlightColor = highlightColor;
		this.shadowColor = shadowColor;
	}
	
	public Insets getBorderInsets(Component c)
	{
		return INSETS;
	}
	
	public void paintBorder(Component c, Graphics g, int x, int y, int w, int h)
	{
		if (highlightColor == null)
		{
			highlightColor = UIManager.getColor("controlLtHighlight");
		}
		if (shadowColor == null)
		{
			shadowColor = UIManager.getColor("controlShadow");
		}
		
		g.translate(x, y);
		g.setColor(highlightColor);
		g.fillRect(0, 0, w, 1);
		g.fillRect(0, 1, 1, h - 1);
		g.setColor(shadowColor);
		g.fillRect(0, h - 1, w, 1);
		g.translate(-x, -y);
	}
}