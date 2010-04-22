package com.nepxion.demo.control.framework;

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

import javax.swing.SwingConstants;

import com.nepxion.demo.common.DemoToggleContentPanel;
import com.nepxion.demo.common.DemoToggleOutlook;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.panel.toggle.JToggleActionButton;

public class DemoFrameWorkControlOutlook
	extends DemoToggleOutlook
{
	public DemoFrameWorkControlOutlook()
	{
		JToggleActionButton frameFrameWorkButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoDockableFrameWorkTogglePanel());
        addButton(frameFrameWorkButton);
        
		JToggleActionButton dialogFrameWorkButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoVLDockingFrameWorkTogglePanel());
        addButton(dialogFrameWorkButton);      
        
        ButtonManager.updateUI(this, new Dimension(50, 70), SwingConstants.VERTICAL);
	}
}