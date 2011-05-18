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
	/**
	 * Fires the ancestor added event.
	 * @param e the instance of AncestorEvent
	 */
	public void ancestorAdded(AncestorEvent e)
	{
		JButton defaultButton = (JButton) e.getComponent();
		JRootPane rootPane = SwingUtilities.getRootPane(defaultButton);
		if (rootPane != null)
		{
			rootPane.setDefaultButton(defaultButton);
		}
	}
	
	/**
	 * Fires the ancestor removed event.
	 * @param e the instance of AncestorEvent
	 */
	public void ancestorRemoved(AncestorEvent event)
	{
	}
	
	/**
	 * Fires the ancestor moved event.
	 * @param e the instance of AncestorEvent
	 */
	public void ancestorMoved(AncestorEvent event)
	{
	}
}