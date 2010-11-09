package com.nepxion.swing.swingworker;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.jdesktop.swingworker.SwingWorker;

public class PropertyChangeAdapter
	implements PropertyChangeListener
{
	public void propertyChange(PropertyChangeEvent e)
	{
		if (e.getPropertyName().equals("state"))
		{
			Object newValue = e.getNewValue();
			if (newValue == SwingWorker.StateValue.PENDING) // SwingWorker创建但还没执行doInBackground()，属于PENDING状态
			{
				firePendingStatusChanged();
			}
			else if (newValue == SwingWorker.StateValue.STARTED) // SwingWorker执行doInBackground()中，属于STARTED状态
			{
				fireStartedStatusChanged();
			}
			else if (newValue == SwingWorker.StateValue.DONE) // SwingWorker执行done()中， 属于DONE状态
			{
				fireDoneStatusChanged();
			}
		}
		else if (e.getPropertyName().equals("progress")) // SwingWorker执行的进度条显示
		{
			Object value = e.getNewValue();
			fireProgressValueChanged(value);
		}
	}
	
	public void firePendingStatusChanged()
	{
		
	}
	
	public void fireStartedStatusChanged()
	{
		
	}
	
	public void fireDoneStatusChanged()
	{
		
	}
	
	public void fireProgressValueChanged(Object value)
	{
		
	}
}