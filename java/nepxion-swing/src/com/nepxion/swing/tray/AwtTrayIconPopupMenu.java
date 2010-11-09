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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jeans.trayicon.TrayIconPopup;
import com.jeans.trayicon.TrayIconPopupSeparator;
import com.jeans.trayicon.TrayIconPopupSimpleItem;
import com.nepxion.swing.locale.SwingLocale;

public class AwtTrayIconPopupMenu
	extends TrayIconPopup implements ITrayIconPopupMenu
{
	private JTray tray;
	private TrayIconPopupSimpleItem restoreMenuItem;
	
	public AwtTrayIconPopupMenu(JTray tray)
	{
		this.tray = tray;
		
		initPopupMenu();
	}
	
	private void initPopupMenu()
	{
		restoreMenuItem = new TrayIconPopupSimpleItem(SwingLocale.getString("show_and_hide_window"));
		// restoreMenuItem.setDefault(true);
		restoreMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tray.restore();
			}
		}
		);
		addMenuItem(restoreMenuItem);
		
		addMenuItem(new TrayIconPopupSeparator());
		
		TrayIconPopupSimpleItem aboutMenuItem = new TrayIconPopupSimpleItem(SwingLocale.getString("about_system"));
		aboutMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tray.about();
			}
		}
		);
		addMenuItem(aboutMenuItem);
		
		addMenuItem(new TrayIconPopupSeparator());
		
		TrayIconPopupSimpleItem exitMenuItem = new TrayIconPopupSimpleItem(SwingLocale.getString("exit"));
		exitMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tray.exit();
			}
		}
		);
		addMenuItem(exitMenuItem);
	}
	
	public void restore(boolean flag)
	{
	}
}