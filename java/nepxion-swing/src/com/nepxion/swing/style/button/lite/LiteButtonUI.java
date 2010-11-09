package com.nepxion.swing.style.button.lite;

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

public class LiteButtonUI
	extends AbstractButtonUI
{
	public static final String ID = LiteButtonUI.class.getName();
	
	protected Color rolloverBackground;
	protected Color rolloverBorderColor;
	
	protected Color selectionBackground;
	protected Color selectionBorderColor;
	
	protected ILiteButtonStyle buttonStyle;
	
	public LiteButtonUI(IButtonStyle buttonStyle)
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
		this.buttonStyle = (ILiteButtonStyle) buttonStyle;
		
		this.rolloverBackground = this.buttonStyle.getRolloverBackground();
		this.rolloverBorderColor = this.buttonStyle.getRolloverBorderColor();
		this.selectionBackground = this.buttonStyle.getSelectionBackground();
		this.selectionBorderColor = this.buttonStyle.getSelectionBorderColor();
	}
	
	public void paintMenuDropDown(IButtonModel buttonModel, Graphics g, JComponent c)
	{
	}
	
	public void paintPressed(IButtonModel buttonModel, Graphics g, JComponent c)
	{
		g.setColor(selectionBackground);
		g.fillRect(0, 0, c.getWidth() - 1, c.getHeight() - 1);
		
		g.setColor(selectionBorderColor);
		g.drawRect(0, 0, c.getWidth() - 1, c.getHeight() - 1);
	}
	
	public void paintSelected(IButtonModel buttonModel, Graphics g, JComponent c)
	{
		paintPressed(buttonModel, g, c);
	}
	
	public void paintRollover(IButtonModel buttonModel, Graphics g, JComponent c)
	{
		g.setColor(rolloverBackground);
		g.fillRect(0, 0, c.getWidth() - 1, c.getHeight() - 1);
		
		g.setColor(rolloverBorderColor);
		g.drawRect(0, 0, c.getWidth() - 1, c.getHeight() - 1);
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