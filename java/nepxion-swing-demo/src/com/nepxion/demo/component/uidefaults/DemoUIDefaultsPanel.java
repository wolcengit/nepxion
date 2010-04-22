package com.nepxion.demo.component.uidefaults;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.style.uidefaults.UIDefaultsHierarchy;

public class DemoUIDefaultsPanel
	extends JPanel
{
	public DemoUIDefaultsPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new UIDefaultsExplorerPanel());
	}
	
	public class UIDefaultsExplorerPanel
		extends JPanel
	{
		public UIDefaultsExplorerPanel()
		{			
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			add(new UIDefaultsHierarchy());
		}
	}
}