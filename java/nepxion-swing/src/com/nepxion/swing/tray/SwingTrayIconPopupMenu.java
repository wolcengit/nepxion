package com.nepxion.swing.tray;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;

import com.jeans.trayicon.SwingTrayPopup;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.menuitem.JBasicMenuItem;
import com.nepxion.swing.popupmenu.PopupMenuPainter;

public class SwingTrayIconPopupMenu
	extends SwingTrayPopup implements ITrayIconPopupMenu
{
	private JTray tray;
	private JBasicMenuItem restoreMenuItem;
	
	public PopupMenuPainter painter;
	
	private String title;
	
	public SwingTrayIconPopupMenu(JTray tray, String title)
	{
		this.tray = tray;
		this.title = title;
		
		initPopupMenu();
	}
	
	public PopupMenuPainter getPainter()
	{
		return painter;
	}
	
	public void setPainter(PopupMenuPainter painter)
	{
		this.painter = painter;
		this.painter.setPopupMenu(this);
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
	
	private void initPopupMenu()
	{
		restoreMenuItem = new JBasicMenuItem(SwingLocale.getString("hide_window"), IconFactory.getSwingIcon("tray_hidden.png"), SwingLocale.getString("hide_window"));
		restoreMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tray.restore();
			}
		}
		);
		add(restoreMenuItem);
		
		add(new JSeparator());
		
		JBasicMenuItem aboutMenuItem = new JBasicMenuItem(SwingLocale.getString("about_system"), IconFactory.getSwingIcon("about.png"), SwingLocale.getString("about_system"));
		aboutMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tray.about();
			}
		}
		);
		add(aboutMenuItem);
		
		add(new JSeparator());
		
		JBasicMenuItem exitMenuItem = new JBasicMenuItem(SwingLocale.getString("exit"), IconFactory.getBlankIcon(), SwingLocale.getString("exit"));
		exitMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tray.exit();
			}
		}
		);
		add(exitMenuItem);
		
		PopupMenuPainter painter = new PopupMenuPainter(title);
		setPainter(painter);
	}
	
	public void restore(boolean flag)
	{
		String text = SwingLocale.getString("hide_window");
		String icon = "tray_hidden.png";
		if (!flag)
		{
			text = SwingLocale.getString("show_window");
			icon = "tray_show.png";
		}
		restoreMenuItem.setText(text);
		restoreMenuItem.setIcon(IconFactory.getSwingIcon(icon));
	}
}