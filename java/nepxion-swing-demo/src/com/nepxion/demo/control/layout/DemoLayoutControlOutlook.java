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

import com.nepxion.demo.common.DemoToggleActionButton;
import com.nepxion.demo.common.DemoToggleOutlook;
import com.nepxion.swing.button.ButtonManager;

public class DemoLayoutControlOutlook
	extends DemoToggleOutlook
{
	public DemoLayoutControlOutlook()
	{
		DemoToggleActionButton tableLayoutButton = new DemoToggleActionButton(new DemoTableLayoutTogglePanel());
        addButton(tableLayoutButton);
        
		DemoToggleActionButton filedLayoutButton = new DemoToggleActionButton(new DemoFiledLayoutTogglePanel());
        addButton(filedLayoutButton);
        
		DemoToggleActionButton ratioLayoutButton = new DemoToggleActionButton(new DemoRatioLayoutTogglePanel());
        addButton(ratioLayoutButton);        
        
		DemoToggleActionButton borderedLayoutButton = new DemoToggleActionButton(new DemoBorderLayoutTogglePanel());
        addButton(borderedLayoutButton); 
        
		DemoToggleActionButton boxedLayoutButton = new DemoToggleActionButton(new DemoBoxLayoutTogglePanel());
        addButton(boxedLayoutButton);      
        
        ButtonManager.updateUI(this, new Dimension(50, 70), VERTICAL);
	}
}