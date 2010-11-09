package com.nepxion.swing.listener;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SelectionListener
	implements ItemListener
{
	public void itemStateChanged(ItemEvent e)
	{
		if (e.getStateChange() == ItemEvent.SELECTED)
		{
			itemSelectionStateChanged(e);
		}
		else if (e.getStateChange() == ItemEvent.DESELECTED)
		{
			itemDeselectionStateChanged(e);
		}
	}
	
	public void itemSelectionStateChanged(ItemEvent e)
	{
		
	}
	
	public void itemDeselectionStateChanged(ItemEvent e)
	{
		
	}
}