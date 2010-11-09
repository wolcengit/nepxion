package com.nepxion.swing.button;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.JButton;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class ButtonAncestorListener
	implements AncestorListener
{
	public void ancestorAdded(AncestorEvent e)
	{
		JButton defaultButton = (JButton) e.getComponent();
		JRootPane rootPane = SwingUtilities.getRootPane(defaultButton);
		if (rootPane != null)
		{
			rootPane.setDefaultButton(defaultButton);
		}
	}
	
	public void ancestorRemoved(AncestorEvent event)
	{
	}
	
	public void ancestorMoved(AncestorEvent event)
	{
	}
}