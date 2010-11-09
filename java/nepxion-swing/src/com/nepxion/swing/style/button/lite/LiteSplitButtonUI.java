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

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;

import com.nepxion.swing.button.IButtonModel;
import com.nepxion.swing.style.button.IButtonStyle;

public class LiteSplitButtonUI
	extends LiteMenuButtonUI
{
	public static final String ID = LiteSplitButtonUI.class.getName();
	
	public LiteSplitButtonUI(IButtonStyle buttonStyle)
	{
		super(buttonStyle);
	}
	
	public void paintMenuDropDown(IButtonModel buttonModel, Graphics g, JComponent c)
	{
		g.setColor(selectionBackground);
		g.fillRect(c.getWidth() - 11, 0, c.getWidth() - 1, c.getHeight() - 1);
		
		g.setColor(rolloverBackground);
		g.fillRect(0, 0, c.getWidth() - 11, c.getHeight() - 1);
		
		g.setColor(selectionBorderColor);
		
		g.drawRect(0, 0, c.getWidth() - 1, c.getHeight() - 1);
		g.drawLine(c.getWidth() - 11, 0, c.getWidth() - 11, c.getHeight() - 1);
	}
	
	public void paintPressed(IButtonModel buttonModel, Graphics g, JComponent c)
	{
		g.setColor(selectionBackground);
		g.fillRect(0, 0, c.getWidth() - 1, c.getHeight() - 1);
		
		g.setColor(selectionBorderColor);
		g.drawRect(0, 0, c.getWidth() - 1, c.getHeight() - 1);
		g.drawLine(c.getWidth() - 11, 0, c.getWidth() - 11, c.getHeight() - 1);
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
		g.drawLine(c.getWidth() - 11, 0, c.getWidth() - 11, c.getHeight() - 1);
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