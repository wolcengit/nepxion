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
import javax.swing.border.Border;

public class ButtonBorder
	implements Border
{
	public static final int BORDER_RAISED = 0;
	public static final int BORDER_LOWERED = 1;
	
	private Color brighter = UIManager.getColor("Button.background").brighter();
	private Color darker = UIManager.getColor("Button.background").darker();
	
	private Color top;
	private Color left;
	private Color bottom;
	private Color right;
	
	public ButtonBorder(int borderType)
	{
		switch (borderType)
		{
			case BORDER_RAISED:
				top = brighter;
				left = brighter;
				bottom = darker;
				right = darker;
				break;
			case BORDER_LOWERED:
				top = darker;
				left = darker;
				bottom = brighter;
				right = brighter;
				break;
		}
	}
	
	public ButtonBorder(Color top, Color left, Color bottom, Color right)
	{
		this.top = top;
		this.left = left;
		this.bottom = bottom;
		this.right = right;
	}
	
	public Insets getBorderInsets(Component c)
	{
		return new Insets(top == null ? 0 : 1, left == null ? 0 : 1, bottom == null ? 0 : 1, right == null ? 0 : 1);
	}
	
	public boolean isBorderOpaque()
	{
		return true;
	}
	
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
	{
		if (bottom != null)
		{
			g.setColor(bottom);
			g.drawLine(x, y + height - 1, x + width - 1, y + height - 1);
		}
		
		if (right != null)
		{
			g.setColor(right);
			g.drawLine(x + width - 1, y, x + width - 1, y + height - 1);
		}
		
		if (top != null)
		{
			g.setColor(top);
			g.drawLine(x, y, x + width - 1, y);
		}
		
		if (left != null)
		{
			g.setColor(left);
			g.drawLine(x, y, x, y + height - 1);
		}
	}
}