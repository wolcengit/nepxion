package com.nepxion.swing.searchable;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.Component;

import com.nepxion.swing.container.JContainer;

public class JSearchableContainer
	extends JContainer
{
	public JSearchableContainer()
	{
		setLayout(new BorderLayout());
	}
	
	public void show(Component component)
	{
		if (component != null)
		{
			add(component, BorderLayout.AFTER_LAST_LINE);
			update();
		}
	}
	
	public void hide(Component component)
	{
		if (component != null)
		{
			remove(component);
			update();
		}
	}
}