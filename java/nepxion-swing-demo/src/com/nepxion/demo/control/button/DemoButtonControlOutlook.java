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

import com.nepxion.demo.common.DemoToggleActionButton;
import com.nepxion.demo.common.DemoToggleOutlook;
import com.nepxion.swing.button.ButtonManager;

public class DemoButtonControlOutlook
	extends DemoToggleOutlook
{
	public DemoButtonControlOutlook()
	{
		DemoToggleActionButton buttonButton = new DemoToggleActionButton(new DemoButtonTogglePanel());
        addButton(buttonButton);
        
        DemoToggleActionButton checkBoxButton = new DemoToggleActionButton(new DemoCheckBoxTogglePanel());
        addButton(checkBoxButton);  
        
        DemoToggleActionButton radioButtonButton = new DemoToggleActionButton(new DemoRadioButtonTogglePanel());
        addButton(radioButtonButton);        
        
        DemoToggleActionButton comboBoxButton = new DemoToggleActionButton(new DemoComboBoxTogglePanel());
        addButton(comboBoxButton);   
        
        ButtonManager.updateUI(this, new Dimension(50, 70), VERTICAL);
        
        buttonButton.doClick();
	}
}