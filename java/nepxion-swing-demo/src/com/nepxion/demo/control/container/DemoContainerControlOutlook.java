package com.nepxion.demo.control.container;

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

public class DemoContainerControlOutlook
	extends DemoToggleOutlook
{
	public DemoContainerControlOutlook()
	{
		JToggleActionButton panelButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoPanelTogglePanel());
        addButton(panelButton);
        
		JToggleActionButton tabbedPaneButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoTabbedPaneTogglePanel());
        addButton(tabbedPaneButton);
        
        ButtonManager.updateUI(this, new Dimension(50, 70), SwingConstants.VERTICAL);
	}
}
