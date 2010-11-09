package com.nepxion.swing.thread.dialog;

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
		AbstractThreadDialog threadDialog = (AbstractThreadDialog) getComponent();
		if (delayTime > 0)
		{
			threadDialog.start(delayTime);
		}
		else
		{
			threadDialog.start();
		}
		
		Object data = super.doInBackground();
		
		threadDialog.finish();
		return data;
	}
	
	public void firePendingStatusChanged()
	{
		
	}
	
	public void fireStartedStatusChanged()
	{
		
	}
	
	public void fireDoneStatusChanged()
	{
		AbstractThreadDialog threadDialog = (AbstractThreadDialog) getComponent();
		threadDialog.stop();
		threadDialog.dispose();
	}
	
	public void fireProgressValueChanged(Object value)
	{
		
	}
	
	public void fireCancelledStatusChanged()
	{
		AbstractThreadDialog threadDialog = (AbstractThreadDialog) getComponent();
		threadDialog.stop();
		threadDialog.dispose();
	}
	
	public void fireForegroundException(Exception e)
	{
		AbstractThreadDialog threadWorkerDialog = (AbstractThreadDialog) getComponent();
		threadWorkerDialog.stop();
		threadWorkerDialog.dispose();
	}
	
	public void fireBackgroundException(Exception e)
	{
		
	}
}