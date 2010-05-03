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

import java.awt.event.ActionEvent;

import com.nepxion.swing.action.JAuthorityAction;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.splash.ISplashWindow;
import com.nepxion.swing.splash.SplashContext;

public class DemoHierarchyController
{
    public static JAuthorityAction getAboutAction()
    {
    	JAuthorityAction action = new JAuthorityAction("About", IconFactory.getSwingIcon("about.png"), "About Nepxion Swing 1.0")
        {
            public void execute(ActionEvent e)
            {
            	ISplashWindow splashWindow = SplashContext.getSplashWindow();
            	if (splashWindow == null)
            	{
            		return;
            	}	
            	splashWindow.setVisible(true);
            }
        };
        return action;
    }	
}