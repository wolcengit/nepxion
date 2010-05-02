package com.nepxion.demo.control.selector;

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

public class DemoSelectorControlOutlook
	extends DemoToggleOutlook
{
	public DemoSelectorControlOutlook()
	{
		JToggleActionButton calendarSelectorButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoCalendarSelectorTogglePanel());
        addButton(calendarSelectorButton);  

		JToggleActionButton localeSelectorButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoLocaleSelectorTogglePanel());
        addButton(localeSelectorButton);  
        
		JToggleActionButton fileSelectorButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoFileSelectorTogglePanel());
        addButton(fileSelectorButton);    
        
		JToggleActionButton colorSelectorButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoColorSelectorTogglePanel());
        addButton(colorSelectorButton); 
        
		JToggleActionButton dropDownSelectorButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoDropDownSelectorTogglePanel());
        addButton(dropDownSelectorButton);
        
		JToggleActionButton checkBoxSelectorButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoCheckBoxSelectorTogglePanel());
        addButton(checkBoxSelectorButton);
        
		JToggleActionButton radioButtonSelectorButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoRadioButtonSelectorTogglePanel());
        addButton(radioButtonSelectorButton);        
        
        ButtonManager.updateUI(this, new Dimension(50, 70), VERTICAL);
	}
}