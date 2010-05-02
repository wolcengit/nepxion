package com.nepxion.demo.control.bar;

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

import com.nepxion.demo.common.DemoToggleContentPanel;
import com.nepxion.demo.common.DemoToggleOutlook;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.panel.toggle.JToggleActionButton;

public class DemoBarControlOutlook
	extends DemoToggleOutlook
{
	public DemoBarControlOutlook()
	{
		JToggleActionButton taskBarButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoTaskBarTogglePanel());
        addButton(taskBarButton); 
        
		JToggleActionButton outlookBarButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoOutlookBarTogglePanel());
        addButton(outlookBarButton); 
        
		JToggleActionButton buttonBarButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoButtonBarTogglePanel());
        addButton(buttonBarButton);         
        
		JToggleActionButton statusBarButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoStatusBarTogglePanel());
        addButton(statusBarButton); 
                
        ButtonManager.updateUI(this, new Dimension(50, 70), VERTICAL);
	}
}