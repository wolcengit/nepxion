package com.nepxion.demo;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.SwingUtilities;

import com.nepxion.demo.component.splash.DemoSplashWindow;
import com.nepxion.swing.context.DataContextInitializer;
import com.nepxion.swing.context.UIContextInitializer;
import com.nepxion.swing.framework.JFrameWorkFrame;
import com.nepxion.swing.framework.ribbon.RibbonContextInitializer;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tray.JTray;

public class DemoDockableFrame
	extends JFrameWorkFrame
{
	public DemoDockableFrame()
	{
		super("Nepxion Swing", IconFactory.getSwingIcon("tray_java.png")); // new Dimension(850, 650)
				
		DemoDockableHierarchy hierarchy = new DemoDockableHierarchy();
		setHierarchy(hierarchy);
	}
	
	public static void main(String[] args)
	{
		new DataContextInitializer().initialize();
		new UIContextInitializer().initialize();
		new RibbonContextInitializer().initialize();
		
		final DemoSplashWindow splashWindow = new DemoSplashWindow();
		splashWindow.setVisible(true);
		
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
			
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				DemoDockableFrame frame = new DemoDockableFrame();
				frame.setExtendedState(MAXIMIZED_BOTH);
				
				//JTray tray = new JTray(frame);
				
				splashWindow.setVisible(false);				
				//tray.setVisible(true);
				frame.setVisible(true);
				frame.toFront();
			}
		}
		);
	}
}