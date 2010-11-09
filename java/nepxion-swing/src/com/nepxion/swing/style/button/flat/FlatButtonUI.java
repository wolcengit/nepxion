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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

import com.nepxion.swing.button.IButtonModel;
import com.nepxion.swing.style.button.AbstractButtonUI;
import com.nepxion.swing.style.button.IButtonStyle;

public class FlatButtonUI
	extends AbstractButtonUI
{
	public static final String ID = FlatButtonUI.class.getName();
	
	protected Color brightColor;
	protected Color darkColor;
	
	protected IFlatButtonStyle buttonStyle;
	
	public FlatButtonUI()
	{
		this(new JFlatButtonStyle());
	}
	
	public FlatButtonUI(IButtonStyle buttonStyle)
	{
		setButtonStyle(buttonStyle);
		setArrowPainted(false);
	}
	
	public IButtonStyle getButtonStyle()
	{
		return buttonStyle;
	}
	
	public void setButtonStyle(IButtonStyle buttonStyle)
	{
		this.buttonStyle = (IFlatButtonStyle) buttonStyle;
		
		brightColor = this.buttonStyle.getBrightColor();
		darkColor = this.buttonStyle.getDarkColor();
	}
	
	public void paintMenuDropDown(IButtonModel buttonModel, Graphics g, JComponent c)
	{
	}
	
	public void paintPressed(IButtonModel buttonModel, Graphics g, JComponent c)
	{
		g.setColor(darkColor);
		g.drawLine(0, 0, c.getWidth() - 1, 0); // top
		g.drawLine(0, 0, 0, c.getHeight() - 1); // left
		
		g.setColor(brightColor);
		g.drawLine(0, c.getHeight() - 1, c.getWidth() - 1, c.getHeight() - 1); // bottom
		g.drawLine(c.getWidth() - 1, 0, c.getWidth() - 1, c.getHeight() - 1); // right
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
		
		g.setColor(darkColor);
		g.drawLine(0, c.getHeight() - 1, c.getWidth() - 1, c.getHeight() - 1); // bottom
		g.drawLine(c.getWidth() - 1, 0, c.getWidth() - 1, c.getHeight() - 1); // right
	}
	
	protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text)
	{
		if (c.getWidth() % 2 != 0)
		{
			textRect.x += 1;
		}
		if (c.getHeight() % 2 != 0)
		{
			textRect.y += 1;
		}
		
		super.paintText(g, c, textRect, text);
	}
	
	protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect)
	{
		if (c.getWidth() % 2 != 0)
		{
			iconRect.x += 1;
		}
		if (c.getHeight() % 2 != 0)
		{
			iconRect.y += 1;
		}
		
		super.paintIcon(g, c, iconRect);
	}
}