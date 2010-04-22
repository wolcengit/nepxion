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

import java.awt.Dimension;

import com.nepxion.demo.component.splash.DemoCaptionSplashWindow;
import com.nepxion.swing.framework.dockable.JFrameWorkFrame;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tray.JTray;

public class DemoFrame
	extends JFrameWorkFrame
{	
	public DemoFrame()
	{
		super("Nepxion Swing", IconFactory.getSwingIcon("tray_java.png"), new Dimension(850, 650));
		
		DemoHierarchy hierarchy = new DemoHierarchy();
		setHierarchy(hierarchy);
	}
	
	public static void main(String[] args)
	{				
		DemoContext context = new DemoContext();
		context.initialize();
		
		final DemoCaptionSplashWindow splashWindow = DemoCaptionSplashWindow.getInstance();
		splashWindow.setVisible(true);
		
		DemoFrame frame = new DemoFrame();
		frame.setExtendedState(DemoFrame.MAXIMIZED_BOTH);
		
		JTray tray = new JTray(frame)
		{
			public void about()
			{
				splashWindow.setVisible(true);
			}			
		};

		splashWindow.setVisible(false);		
		
		frame.setVisible(true);
		
		tray.setVisible(true);				
	}
}