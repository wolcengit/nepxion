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
import com.nepxion.swing.framework.dockable.JFrameWorkFrame;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tray.JTray;

public class DemoFrame
	extends JFrameWorkFrame
{
	public DemoFrame()
	{
		super("Nepxion Swing", IconFactory.getSwingIcon("tray_java.png")); // new Dimension(850, 650)
		
		DemoHierarchy hierarchy = new DemoHierarchy();
		setHierarchy(hierarchy);
	}
	
	public static void main(String[] args)
	{
		DemoContext context = new DemoContext();
		context.initialize();
		
		final DemoSplashWindow splashWindow = new DemoSplashWindow();
		splashWindow.setVisible(true);
			
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				DemoFrame frame = new DemoFrame();
				frame.setExtendedState(DemoFrame.MAXIMIZED_BOTH);
				
				JTray tray = new JTray(frame);
				
				splashWindow.setVisible(false);				
				tray.setVisible(true);
				frame.setVisible(true);
				frame.toFront();
			}
		}
		);								
	}
}