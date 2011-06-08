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

public class JBasicPopupMenu
	extends JPopupMenu
{
	private PopupMenuPainter painter;
	
	public JBasicPopupMenu()
	{
		this(PopupMenuContext.getTitle());
	}
	
	public JBasicPopupMenu(PopupMenuPainter painter)
	{
		setPainter(painter);
	}
	
	public JBasicPopupMenu(String title)
	{
		setTitle(title);
	}
	
	public JBasicPopupMenu(IStyle style)
	{
		setStyle(style);
	}
	
	public PopupMenuPainter getPainter()
	{
		return painter;
	}
	
	public void setPainter(PopupMenuPainter painter)
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
		PopupMenuPainter painter = new PopupMenuPainter(title);
		setPainter(painter);
	}
	
	public void setStyle(IStyle style)
	{
		PopupMenuPainter painter = new PopupMenuPainter(style);
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