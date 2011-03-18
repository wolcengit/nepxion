package com.nepxion.swing.framework;

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
import java.awt.event.ActionEvent;

public abstract class JFrameWorkThread
	extends Thread
{
	private Component component;
	
	private JFrameWorkHierarchy frameWorkHierarchy;
	
	public JFrameWorkThread(JFrameWorkHierarchy frameWorkHierarchy)
	{
		this.frameWorkHierarchy = frameWorkHierarchy;
	}
	
	public JFrameWorkThread(JFrameWorkHierarchy frameWorkHierarchy, Component component)
	{
		this.frameWorkHierarchy = frameWorkHierarchy;
		this.component = component;
	}
	
	public JFrameWorkThread(JFrameWorkHierarchy frameWorkHierarchy, ActionEvent actionEvent)
	{
		this.frameWorkHierarchy = frameWorkHierarchy;
		
		if (actionEvent != null)
		{
			Object object = actionEvent.getSource();
			if (object != null && object instanceof Component)
			{
				component = (Component) object;
			}
		}
	}
	
	public void run()
	{
		try
		{
			Thread.sleep(50);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		setComponentEnabled(false);
		setThreadStatus(true);
		
		execute();
		
		setThreadStatus(false);
		setComponentEnabled(true);
	}
	
	private void setComponentEnabled(boolean isEnabled)
	{
		if (component != null)
		{
			component.setEnabled(isEnabled);
		}
	}
	
	private void setThreadStatus(boolean isStarted)
	{
		if (frameWorkHierarchy == null)
		{
			return;
		}
		
		JFrameWorkStatusBar frameWorkStatusBar = frameWorkHierarchy.getStatusBar();
		if (frameWorkStatusBar == null)
		{
			return;
		}
		
		if (frameWorkStatusBar.isVisible())
		{
			if (isStarted)
			{
				frameWorkStatusBar.start();
			}
			else
			{
				frameWorkStatusBar.stop();
			}
		}
	}
	
	public abstract void execute();
}