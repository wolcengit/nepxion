package com.nepxion.demo.control.button;

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

public class DemoButtonControlOutlook
	extends DemoToggleOutlook
{
	public DemoButtonControlOutlook()
	{
		JToggleActionButton buttonButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoButtonTogglePanel());
        addButton(buttonButton);
        
        JToggleActionButton checkBoxButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoCheckBoxTogglePanel());
        addButton(checkBoxButton);  
        
        JToggleActionButton radioButtonButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoRadioButtonTogglePanel());
        addButton(radioButtonButton);        
        
        JToggleActionButton comboBoxButton = new JToggleActionButton(DemoToggleContentPanel.getInstance(), new DemoComboBoxTogglePanel());
        addButton(comboBoxButton);   
        
        ButtonManager.updateUI(this, new Dimension(50, 70), VERTICAL);
        
        buttonButton.doClick();
	}
}