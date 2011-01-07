package com.nepxion.swing.thread.container;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Component;

import com.nepxion.swing.swingworker.JSwingWorker;

public abstract class AbstractSwingWorker
	extends JSwingWorker
{
	private int delayTime = 0;
	
	public AbstractSwingWorker(Component component, int delayTime)
	{
		super(component);
		
		this.delayTime = delayTime;
	}
	
	public int getDelayTime()
	{
		return delayTime;
	}
	
	public void setDelayTime(int delayTime)
	{
		this.delayTime = delayTime;
	}
	
	protected Object doInBackground()
		throws Exception
	{
		AbstractThreadContainer threadContainer = (AbstractThreadContainer) getComponent();
		if (delayTime > 0)
		{
			threadContainer.start(delayTime);
		}
		else
		{
			threadContainer.start();
		}
		
		Object data = super.doInBackground();
		
		threadContainer.finish();
		
		return data;
	}
	
	public void firePendingStatusChanged()
	{
		
	}
	
	public void fireStartedStatusChanged()
	{
		AbstractThreadContainer threadContainer = (AbstractThreadContainer) getComponent();
		threadContainer.showThread();
	}
	
	public void fireDoneStatusChanged()
	{
		AbstractThreadContainer threadContainer = (AbstractThreadContainer) getComponent();
		threadContainer.stop();
	}
	
	public void fireProgressValueChanged(Object value)
	{
		
	}
	
	public void fireCancelledStatusChanged()
	{
		AbstractThreadContainer threadContainer = (AbstractThreadContainer) getComponent();
		threadContainer.stop();
		threadContainer.showInformation();
	}
	
	public void fireForegroundException(Exception e)
	{
		AbstractThreadContainer threadContainer = (AbstractThreadContainer) getComponent();
		threadContainer.stop();
		threadContainer.showError();
	}
	
	public void fireBackgroundException(Exception e)
	{
		
	}
}