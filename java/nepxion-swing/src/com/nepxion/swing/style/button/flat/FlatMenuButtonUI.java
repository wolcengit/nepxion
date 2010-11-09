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

public class FlatMenuButtonUI
	extends FlatButtonUI
{
	public static final String ID = FlatMenuButtonUI.class.getName();
	
	public FlatMenuButtonUI()
	{
		this(new JFlatButtonStyle());
	}
	
	public FlatMenuButtonUI(IButtonStyle buttonStyle)
	{
		super(buttonStyle);
		
		setArrowPainted(true);
	}
	
	public void paintMenuDropDown(IButtonModel buttonModel, Graphics g, JComponent c)
	{
		paintPressed(buttonModel, g, c);
	}
	
	protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text)
	{
		textRect.x -= 4;
		
		super.paintText(g, c, textRect, text);
	}
	
	protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect)
	{
		iconRect.x -= 4;
		
		super.paintIcon(g, c, iconRect);
	}
}