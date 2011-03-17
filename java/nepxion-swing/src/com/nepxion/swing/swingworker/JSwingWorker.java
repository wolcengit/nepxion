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

import java.awt.Component;

import org.jdesktop.swingworker.SwingWorker;

import com.nepxion.swing.exception.ExceptionTracer;
import com.nepxion.swing.handle.HandleManager;

public abstract class JSwingWorker
	extends SwingWorker
{
	private Component component;
	
	public JSwingWorker()
	{
		this(null);
	}
	
	public JSwingWorker(Component component)
	{
		this.component = component;
		
		addPropertyChangeListener(new PropertyChangeAdapter()
		{
			public void firePendingStatusChanged()
			{
				JSwingWorker.this.firePendingStatusChanged();
			}
			
			public void fireStartedStatusChanged()
			{
				JSwingWorker.this.fireStartedStatusChanged();
			}
			
			public void fireDoneStatusChanged()
			{
				JSwingWorker.this.fireDoneStatusChanged();
			}
			
			public void fireProgressValueChanged(Object value)
			{
				JSwingWorker.this.fireProgressValueChanged(value);
			}
		}
		);
	}
	
	public Component getComponent()
	{
		return component;
	}
	
	public void setComponent(Component component)
	{
		this.component = component;
	}
	
	protected void done()
	{
		if (isCancelled())
		{
			fireCancelledStatusChanged();
			
			return;
		}
		
		Object data = null;
		try
		{
			data = get();
		}
		catch (Exception e)
		{
			data = e;
		}
		
		if (data instanceof Exception)
		{
			Exception e = (Exception) data;
			fireForegroundException(e);
			if (component != null)
			{
				ExceptionTracer.traceException(HandleManager.getFrame(component), e);
			}
		}	
		
		try
		{
			loadForeground(data);
		}
		catch (Exception e)
		{
			fireForegroundException(e);
			if (component != null)
			{
				ExceptionTracer.traceException(HandleManager.getFrame(component), e);
			}
		}
	}
	
	protected Object doInBackground()
		throws Exception
	{
		Object data = null;
		try
		{
			data = loadBackground();
		}
		catch (Exception e)
		{
			if (!isCancelled())
			{
				fireBackgroundException(e);
				
				throw e;
			}
		}
		
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
		
	}
	
	public void fireProgressValueChanged(Object value)
	{
		
	}
	
	public void fireCancelledStatusChanged()
	{
		
	}
	
	public void fireForegroundException(Exception e)
	{
		
	}
	
	public void fireBackgroundException(Exception e)
	{
		
	}
	
	protected abstract void loadForeground(Object data)
		throws Exception;
	
	protected abstract Object loadBackground()
		throws Exception;
}