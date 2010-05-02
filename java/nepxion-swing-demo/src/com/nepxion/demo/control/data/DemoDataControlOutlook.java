package com.nepxion.demo.control.data;

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

public class DemoDataControlOutlook
	extends DemoToggleOutlook
{
	public DemoDataControlOutlook()
	{
		JToggleActionButton treeButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoTreeTogglePanel());
        addButton(treeButton);
        
		JToggleActionButton tableButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoTableTogglePanel());
        addButton(tableButton);
        
		JToggleActionButton listButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoListTogglePanel());
        addButton(listButton);        
        
        ButtonManager.updateUI(this, new Dimension(50, 70), VERTICAL);
	}
}