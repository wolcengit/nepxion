package com.nepxion.swing.toolbar;

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
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JToolBar;

public class JBasicToolBar
	extends JToolBar
{
	private boolean isBorderVisible;
	
	public JBasicToolBar()
	{
		super();
		
		setFloatable(false);
		setBorderVisible(false);
	}
	
	public void setBorderVisible(boolean isBorderVisible)
	{
		this.isBorderVisible = isBorderVisible;
		
		if (isBorderVisible)
		{
			setBorder(BorderFactory.createEmptyBorder(0, 5, 1, 0));
		}
		else
		{
			setBorder(BorderFactory.createEmptyBorder(0, 0, 1, 0));
		}
		
		repaint();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		if (isBorderVisible)
		{
			int h = getHeight();
			g.setColor(Color.white);
			g.drawLine(1, 2, 1, h - 3);
			g.setColor(new Color(128, 128, 128));
			g.drawLine(2, 2, 2, h - 3);
		}
	}
}