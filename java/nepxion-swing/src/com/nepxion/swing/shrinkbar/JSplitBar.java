package com.nepxion.swing.shrinkbar;

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
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.Box.Filler;
import javax.swing.border.Border;

public class JSplitBar
	extends Filler implements ShrinkContants
{
	public JSplitBar(JShrinkHeader shrinkHeader, int width)
	{
		super(new Dimension(width, 0), new Dimension(width, 0), new Dimension(width, Short.MAX_VALUE));
		
		SplitListener splitListener = new SplitListener(shrinkHeader);
		
		setOpaque(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
		addMouseListener(splitListener);
		addMouseMotionListener(splitListener);
	}
	
	protected void setPlacement(final int placement)
	{
		setBorder(new Border()
		{
			public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
			{
				g.setColor(SPLIT_COLOR);
				
				if (placement == PLACEMENT_EAST)
				{
					g.drawLine(x, y, x, y + height);
				}
				else if (placement == PLACEMENT_WEST)
				{
					g.drawLine(x + width - 1, y, x + width - 1, y + height);
				}
			}
			
			public Insets getBorderInsets(Component c)
			{
				return new Insets(0, 1, 0, 1);
			}
			
			public boolean isBorderOpaque()
			{
				return true;
			}
		}
		);
	}
	
	protected void setShrinked(boolean shrinked)
	{
		if (shrinked)
		{
			setCursor(Cursor.getDefaultCursor());
		}
		else
		{
			setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
		}
	}
}