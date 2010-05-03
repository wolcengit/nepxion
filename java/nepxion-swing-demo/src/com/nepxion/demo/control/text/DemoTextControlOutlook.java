package com.nepxion.demo.control.text;

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

public class DemoTextControlOutlook
	extends DemoToggleOutlook
{
	public DemoTextControlOutlook()
	{
		DemoToggleActionButton textFieldButton = new DemoToggleActionButton(new DemoTextFieldTogglePanel());
        addButton(textFieldButton); 
        
		DemoToggleActionButton textAreaButton = new DemoToggleActionButton(new DemoTextAreaTogglePanel());
        addButton(textAreaButton);  
        
        ButtonManager.updateUI(this, new Dimension(50, 70), VERTICAL);
	}
}