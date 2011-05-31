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

import java.net.URL;

import javax.swing.SwingUtilities;

import com.nepxion.swing.context.DataContextInitializer;
import com.nepxion.swing.context.UIContextInitializer;
import com.nepxion.swing.framework.JFrameWorkApplet;

public class DemoRibbonApplet
	extends JFrameWorkApplet
{
	public void init()
	{
		super.init();		
		
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				DemoRibbonHierarchy hierarchy = new DemoRibbonHierarchy();
				setHierarchy(hierarchy);
			}
		}
		);		
	}
	
	public void initContext()
	{		
		URL codeBase = getCodeBase();
		
		new DataContextInitializer().initialize(codeBase);
		new UIContextInitializer().initialize(codeBase);
	}
}