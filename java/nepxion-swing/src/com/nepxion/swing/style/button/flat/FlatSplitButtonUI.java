package com.nepxion.swing.style.button.flat;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

import com.nepxion.swing.button.IButtonModel;
import com.nepxion.swing.style.button.IButtonStyle;

public class FlatSplitButtonUI
	extends FlatMenuButtonUI
{
	public static final String ID = FlatSplitButtonUI.class.getName();
	
	public FlatSplitButtonUI()
	{
		this(new JFlatButtonStyle());
	}
	
	public FlatSplitButtonUI(IButtonStyle buttonStyle)
	{
		super(buttonStyle);
	}
	
	public void paintMenuDropDown(IButtonModel buttonModel, Graphics g, JComponent c)
	{
		g.setColor(brightColor);
		g.drawLine(0, 0, c.getWidth() - 12, 0); // top
		g.drawLine(0, 0, 0, c.getHeight() - 1); // left
		g.drawLine(c.getWidth() - 12, c.getHeight() - 1, c.getWidth() - 1, c.getHeight() - 1); // bottom
		g.drawLine(c.getWidth() - 1, 0, c.getWidth() - 1, c.getHeight() - 1); // right
		
		g.setColor(darkColor);
		g.drawLine(0, c.getHeight() - 1, c.getWidth() - 12, c.getHeight() - 1); // bottom
		g.drawLine(c.getWidth() - 12, -1, c.getWidth() - 12, c.getHeight() - 2); // center
		g.drawLine(c.getWidth() - 12, 0, c.getWidth() - 2, 0); // top
		g.drawLine(c.getWidth() - 11, -1, c.getWidth() - 11, c.getHeight() - 2); // center
	}
	
	public void paintPressed(IButtonModel buttonModel, Graphics g, JComponent c)
	{
		g.setColor(darkColor);
		g.drawLine(0, 0, c.getWidth() - 1, 0); // top
		g.drawLine(0, 0, 0, c.getHeight() - 1); // left
		g.drawLine(c.getWidth() - 11, -1, c.getWidth() - 11, c.getHeight() - 2); // center
		
		g.setColor(brightColor);
		g.drawLine(0, c.getHeight() - 1, c.getWidth() - 1, c.getHeight() - 1); // bottom
		g.drawLine(c.getWidth() - 1, 0, c.getWidth() - 1, c.getHeight() - 1); // right
		g.drawLine(c.getWidth() - 12, -1, c.getWidth() - 12, c.getHeight() - 2); // center
	}
	
	public void paintSelected(IButtonModel buttonModel, Graphics g, JComponent c)
	{
		paintPressed(buttonModel, g, c);
	}
	
	public void paintRollover(IButtonModel buttonModel, Graphics g, JComponent c)
	{
		g.setColor(brightColor);
		g.drawLine(0, 0, c.getWidth() - 1, 0); // top
		g.drawLine(0, 0, 0, c.getHeight() - 1); // left
		g.drawLine(c.getWidth() - 11, -1, c.getWidth() - 11, c.getHeight() - 2); // center
		
		g.setColor(darkColor);
		g.drawLine(0, c.getHeight() - 1, c.getWidth() - 1, c.getHeight() - 1); // bottom
		g.drawLine(c.getWidth() - 1, 0, c.getWidth() - 1, c.getHeight() - 1); // right
		g.drawLine(c.getWidth() - 12, -1, c.getWidth() - 12, c.getHeight() - 2); // center
	}
	
	protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text)
	{
		textRect.x -= 1;
		
		super.paintText(g, c, textRect, text);
	}
	
	protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect)
	{
		iconRect.x -= 1;
		
		super.paintIcon(g, c, iconRect);
	}
}