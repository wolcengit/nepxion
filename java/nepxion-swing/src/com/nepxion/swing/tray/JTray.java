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

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.jeans.trayicon.TrayIconCallback;
import com.jeans.trayicon.TrayIconException;
import com.jeans.trayicon.WindowsTrayIcon;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.popupmenu.PopupMenuContext;
import com.nepxion.swing.topic.TopicContext;

public class JTray
{
	private WindowsTrayIcon trayIcon;
	private ITrayIconPopupMenu trayIconPopupMenu;
	
	private int showBalloonTimes = 0;
	private boolean alwaysShowBalloon = false;
	
	private JFrame frame;
	
	public JTray(JFrame frame)
	{
		this(frame, PopupMenuContext.getTitle());
	}
	
	public JTray(JFrame frame, String title)
	{
		this(frame, title, IconFactory.getSwingIcon("tray_java.png"), 16, 16);
	}
	
	public JTray(JFrame frame, ImageIcon imageIcon)
	{
		this(frame, PopupMenuContext.getTitle(), imageIcon);
	}
	
	public JTray(JFrame frame, String title, ImageIcon imageIcon)
	{
		this(frame, title, imageIcon, 16, 16);
	}
	
	public JTray(JFrame frame, ImageIcon imageIcon, int width, int height)
	{
		this(frame, PopupMenuContext.getTitle(), imageIcon, width, height);
	}
	
	public JTray(JFrame frame, String title, ImageIcon imageIcon, int width, int height)
	{
		this.frame = frame;
		this.frame.addWindowListener(new TrayWindowListener());
		
		WindowsTrayIcon.initTrayIcon(frame.getTitle());
		// WindowsTrayIcon.setWindowsMessageCallback(new TrayWindowsMessageCallback());
		// WindowsTrayIcon.sendWindowsMessage(frame.getTitle(), 1234);
		
		try
		{
			trayIcon = new WindowsTrayIcon(imageIcon.getImage(), width, height);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch (TrayIconException e)
		{
			e.printStackTrace();
		}
		trayIcon.setToolTipText(frame.getTitle());
		// trayIcon.addActionListener(new TrayIconActionListener());
		trayIcon.addMouseListener(new TrayIconMouseListener());
		// trayIcon.addBalloonListener(new TrayIconBalloonListener(this));
		
		if (System.getProperty("java.version").indexOf("1.6.0") > -1) // Swing TrayIcon PopupMenu can't fit for the JDK 1.6.0, should choose Awt TrayIcon PopupMenu
		{
			trayIconPopupMenu = new AwtTrayIconPopupMenu(this);
			trayIcon.setPopup((AwtTrayIconPopupMenu) trayIconPopupMenu);
		}
		else
		{
			trayIconPopupMenu = new SwingTrayIconPopupMenu(this, title);
			((SwingTrayIconPopupMenu) trayIconPopupMenu).setTrayIcon(trayIcon);
		}
	}
	
	public WindowsTrayIcon getTrayIcon()
	{
		return trayIcon;
	}
	
	public ITrayIconPopupMenu getTrayIconPopupMenu()
	{
		return trayIconPopupMenu;
	}
	
	public void setVisible(boolean visible)
	{
		trayIcon.setVisible(visible);
	}
	
	public void setAlwaysShowBalloon(boolean alwaysShowBalloon)
	{
		this.alwaysShowBalloon = alwaysShowBalloon;
	}
	
	public void showBalloon()
	{
		if (alwaysShowBalloon)
		{
			showBalloon(SwingLocale.getString("tray_title"), frame.getTitle());
		}
		else
		{
			if (showBalloonTimes == 0)
			{
				showBalloon(SwingLocale.getString("tray_title"), frame.getTitle());
				
				showBalloonTimes++;
			}
		}
	}
	
	public void showBalloon(String title, String message)
	{
		showBalloon(title, message, 10000, WindowsTrayIcon.BALLOON_INFO);
	}
	
	public void showBalloon(String message, String title, int timeout, int flag)
	{
		WindowsTrayIcon.enableUnicodeConversion(WindowsTrayIcon.UNICODE_CONV_BALLOON, true);
		try
		{
			trayIcon.showBalloon(title, message, timeout, flag);
		}
		catch (TrayIconException e)
		{
			e.printStackTrace();
		}
	}
	
	public void flash()
	{
		try
		{
			WindowsTrayIcon.flashWindow(frame);
		}
		catch (TrayIconException e)
		{
			e.printStackTrace();
		}
	}
	
	public void restore()
	{
		frame.setVisible(!frame.isVisible());
		/*if (frame.isVisible())
		{
			if (frame.getExtendedState() == JFrame.ICONIFIED)
			{
				frame.setExtendedState(JFrame.NORMAL);
			}
		}*/
		
		trayIconPopupMenu.restore(frame.isVisible());
		if (!frame.isVisible())
		{
			showBalloon();
		}
	}
	
	public void about()
	{
		Component topicComponent = TopicContext.getTopicComponent();
		if (topicComponent == null)
		{
			return;
		}
		
		topicComponent.setVisible(true);
	}
	
	public void exit()
	{
		WindowsTrayIcon.cleanUp();
		System.exit(0);
	}
	
	public class TrayIconActionListener
		implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			restore();
		}
	}
	
	public class TrayIconMouseListener
		extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{
			if (e.getModifiers() == MouseEvent.BUTTON1_MASK)
			{
				restore();
			}
		}
	}
	
	public class TrayWindowListener
		extends WindowAdapter
	{
		public void windowIconified(WindowEvent e)
		{
			restore();
		}
		
		public void windowClosing(WindowEvent e)
		{
			exit();
		}
	}
	
	public class TrayWindowsMessageCallback
		implements TrayIconCallback
	{
		public int callback(int param)
		{
			return 4321;
		}
	}
}