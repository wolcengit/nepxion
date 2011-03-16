package com.nepxion.swing.popupmenu;

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
import java.awt.Insets;

import javax.swing.JPopupMenu;

import com.nepxion.swing.container.ContainerManager;
import com.nepxion.swing.style.framework.IStyle;

public class JDecorationPopupMenu
	extends JPopupMenu
{
	private JDecorationPopupMenuPainter painter;
	
	public JDecorationPopupMenu()
	{
		this(PopupMenuContext.getTitle());
	}
	
	public JDecorationPopupMenu(JDecorationPopupMenuPainter painter)
	{
		setPainter(painter);
	}
	
	public JDecorationPopupMenu(String title)
	{
		setTitle(title);
	}
	
	public JDecorationPopupMenu(IStyle style)
	{
		setStyle(style);
	}
	
	public JDecorationPopupMenuPainter getPainter()
	{
		return painter;
	}
	
	public void setPainter(JDecorationPopupMenuPainter painter)
	{
		this.painter = painter;
		this.painter.setPopupMenu(this);
		
		PopupMenuManager.setPreferenceStyle(this);
		
		ContainerManager.update(this);
	}
	
	public String getTitle()
	{
		return painter.getTitle();
	}
	
	public void setTitle(String title)
	{
		JDecorationPopupMenuPainter painter = new JDecorationPopupMenuPainter(title);
		setPainter(painter);
	}
	
	public void setStyle(IStyle style)
	{
		JDecorationPopupMenuPainter painter = new JDecorationPopupMenuPainter(style);
		setPainter(painter);
	}
	
	public Insets getInsets()
	{
		Insets insets = super.getInsets();
		
		if (painter != null)
		{
			return painter.getInsets((Insets) insets.clone());
		}
		else
		{
			return insets;
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if (painter != null)
		{
			painter.paintComponent(g);
		}
	}
}