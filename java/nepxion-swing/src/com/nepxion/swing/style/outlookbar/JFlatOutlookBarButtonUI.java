package com.nepxion.swing.style.outlookbar;

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
import javax.swing.plaf.basic.BasicButtonUI;

public class JFlatOutlookBarButtonUI
	extends BasicButtonUI
{
	private int indent = 0;
	
	public JFlatOutlookBarButtonUI()
	{
		
	}
	
	public int getIndent()
	{
		return indent;
	}
	
	public void setIndent(int indent)
	{
		this.indent = indent;
	}
	
	protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text)
	{
		Rectangle rect = new Rectangle(textRect.x + indent, textRect.y, textRect.width, textRect.height);
		
		super.paintText(g, c, rect, text);
	}
	
	protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect)
	{
		Rectangle rect = new Rectangle(iconRect.x + indent, iconRect.y, iconRect.width, iconRect.height);
		
		super.paintIcon(g, c, rect);
	}
}