package com.nepxion.swing.renderer.list;

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
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class ListCellLabel
	extends JLabel
{
	private boolean isSelected;
	private boolean hasFocus;
	
	public ListCellLabel()
	{
	}
	
	public Dimension getPreferredSize()
	{
		Dimension dimension = super.getPreferredSize();
		
		if (dimension != null)
		{
			dimension.width += 2;
		}
		
		return dimension;
	}
	
	public void setSelected(boolean isSelected)
	{
		this.isSelected = isSelected;
	}
	
	public void setFocus(boolean hasFocus)
	{
		this.hasFocus = hasFocus;
	}
	
	public void setBackground(Color color)
	{
		if (color instanceof ColorUIResource)
		{
			color = null;
		}
		
		super.setBackground(color);
	}
	
	public void paint(Graphics g)
	{
		String text = getText();
		if (text != null)
		{
			if (text.length() > 0)
			{
				if (isSelected)
				{
					g.setColor(UIManager.getColor("Tree.selectionBackground"));
				}
				else
				{
					g.setColor(UIManager.getColor("Tree.textBackground"));
				}
				Dimension d = getPreferredSize();
				int imageOffset = 0;
				Icon icon = getIcon();
				if (icon != null)
				{
					imageOffset = icon.getIconWidth() + Math.max(0, getIconTextGap() - 1);
				}
				g.fillRect(imageOffset, 0, d.width - 1 - imageOffset, d.height);
				if (hasFocus)
				{
					g.setColor(UIManager.getColor("Tree.selectionBorderColor"));
					g.drawRect(imageOffset, 0, d.width - 1 - imageOffset, d.height - 1);
				}
			}
		}
		
		super.paint(g);
	}
}