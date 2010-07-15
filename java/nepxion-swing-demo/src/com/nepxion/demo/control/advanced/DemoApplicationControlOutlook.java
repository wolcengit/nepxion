package com.nepxion.demo.control.application;

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

public class DemoApplicationControlOutlook
	extends DemoToggleOutlook
{
	public DemoApplicationControlOutlook()
	{        
		DemoToggleActionButton googleMapButton = new DemoToggleActionButton(new DemoGoogleMapTogglePanel());
        addButton(googleMapButton); 
        
		DemoToggleActionButton ipButton = new DemoToggleActionButton(new DemoIPTogglePanel());
        addButton(ipButton);           
        
		DemoToggleActionButton mobileButton = new DemoToggleActionButton(new DemoMobileTogglePanel());
        addButton(mobileButton); 
        
        ButtonManager.updateUI(this, new Dimension(50, 70), VERTICAL);
	}
}