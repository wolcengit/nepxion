package com.nepxion.demo.control.layout;
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

public class DemoLayoutControlOutlook
	extends DemoToggleOutlook
{
	public DemoLayoutControlOutlook()
	{
		JToggleActionButton tableLayoutButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoTableLayoutTogglePanel());
        addButton(tableLayoutButton);
        
		JToggleActionButton filedLayoutButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoFiledLayoutTogglePanel());
        addButton(filedLayoutButton);
        
		JToggleActionButton ratioLayoutButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoRatioLayoutTogglePanel());
        addButton(ratioLayoutButton);        
        
		JToggleActionButton borderedLayoutButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoBorderLayoutTogglePanel());
        addButton(borderedLayoutButton); 
        
		JToggleActionButton boxedLayoutButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoBoxLayoutTogglePanel());
        addButton(boxedLayoutButton);      
        
        ButtonManager.updateUI(this, new Dimension(50, 70), VERTICAL);
	}
}