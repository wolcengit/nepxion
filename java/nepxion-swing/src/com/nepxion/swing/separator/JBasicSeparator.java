package com.nepxion.swing.separator;

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

import javax.swing.JComponent;
import javax.swing.SwingConstants;

import com.nepxion.swing.dimension.DimensionManager;

public class JBasicSeparator
	extends JComponent implements SwingConstants
{
	public static final String RAISED_STYLE = "RaisedStyle";
	public static final String LOWERED_STYLE = "LoweredStyle";
	
	public static final int DEFAULT_THICKNESS = 10;
	
	private int orientation;
	private String style;
	private int length;
	
	public JBasicSeparator()
	{
		this(22);
	}
	
	public JBasicSeparator(int length)
	{
		this(LOWERED_STYLE, length);
	}
	
	public JBasicSeparator(String style, int length)
	{
		this(VERTICAL, style, length);
	}
	
	public JBasicSeparator(int orientation, String style, int length)
	{
		this.orientation = orientation;
		this.style = style;
		
		setLength(length);
	}
	
	public int getOrientation()
	{
		return orientation;
	}
	
	public void setOrientation(int orientation)
	{
		this.orientation = orientation;
		repaint();
	}
	
	public int getLength()
	{
		return length;
	}
	
	public void setLength(int length)
	{
		this.length = length;
		Dimension dimension = new Dimension();
		if (orientation == VERTICAL)
		{
			dimension.width = DEFAULT_THICKNESS;
			dimension.height = length;
		}
		else if (orientation == HORIZONTAL)
		{
			dimension.width = length;
			dimension.height = DEFAULT_THICKNESS;
		}
		DimensionManager.setDimension(this, dimension);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		int w = getWidth();
		int h = getHeight();
		
		if (style.equals(RAISED_STYLE))
		{
			g.setColor(Color.white);
		}
		else if (style.equals(LOWERED_STYLE))
		{
			g.setColor(new Color(128, 128, 128));
		}
		if (orientation == VERTICAL)
		{
			g.drawLine(w / 2 - 1, 0, w / 2 - 1, h);
		}
		else if (orientation == HORIZONTAL)
		{
			g.drawLine(0, h / 2 - 1, w, h / 2 - 1);
		}
		
		if (style.equals(LOWERED_STYLE))
		{
			g.setColor(Color.white);
		}
		else if (style.equals(RAISED_STYLE))
		{
			g.setColor(new Color(128, 128, 128));
		}
		if (orientation == VERTICAL)
		{
			g.drawLine(w / 2, 0, w / 2, h);
		}
		else if (orientation == HORIZONTAL)
		{
			g.drawLine(0, h / 2, w, h / 2);
		}
	}
}