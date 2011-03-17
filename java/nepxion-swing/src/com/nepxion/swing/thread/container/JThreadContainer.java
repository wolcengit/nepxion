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

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import com.nepxion.swing.exception.ExceptionTracer;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.timer.JTimerLabel;

public abstract class JThreadContainer
	extends AbstractThreadContainer
{
	private SwingWorker swingWorker;
	private int delayTime = 200;
	
	private boolean isLoadCache = false;
	
	public JThreadContainer()
	{
		this(SwingLocale.getString("transact_and_wait"));
	}
	
	public JThreadContainer(String information)
	{
		this(new JTimerLabel(JTimerLabel.MAGNIFIER_ICON), information);
	}
	
	public JThreadContainer(JLabel animationLabel, String information)
	{
		super(animationLabel, information);
	}
	
	public void execute()
	{
		if (!isLoadCache())
		{
			if (swingWorker == null)
			{
				swingWorker = new SwingWorker();
				swingWorker.execute();
			}
			else
			{
				if (swingWorker.isDone())
				{
					swingWorker = new SwingWorker();
					swingWorker.execute();
				}
			}
		}
		else
		{
			fireHidden();
		}
	}
	
	protected void fireHidden()
	{
		Component contentPane = getContentPane();
		if (contentPane != null)
		{	
			addComponent(contentPane, BorderLayout.CENTER);
		}
	}
	
	protected void fireCancelled()
	{
		if (swingWorker != null)
		{
			swingWorker.cancel(true);
		}
	}
	
	public int getDelayTime()
	{
		return delayTime;
	}
	
	public void setDelayTime(int delayTime)
	{
		this.delayTime = delayTime;
	}
	
	public boolean isLoadCache()
	{
		return isLoadCache;
	}
	
	public void setLoadCache(boolean isLoadCache)
	{
		this.isLoadCache = isLoadCache;
	}
	
	public class SwingWorker
		extends AbstractSwingWorker
	{			
		public SwingWorker()
		{
			super(JThreadContainer.this, delayTime);
		}
		
		protected void loadForeground(final Object data)
			throws Exception
		{
			SwingUtilities.invokeLater(new Runnable()
			{
				public void run()
				{
					if (data instanceof Exception)
					{
						return;
					}
					
					try
					{
						JThreadContainer.this.loadForeground(data);
					}
					catch (Exception e)
					{
						e.printStackTrace();
						
						fireForegroundException(e);
						
						Exception exception = null;
						if (e.getCause() != null && e.getCause() instanceof Exception)
						{
							exception = (Exception) e.getCause();
						}
						else
						{
							exception = e;
						}
						
						ExceptionTracer.traceException(HandleManager.getFrame(SwingWorker.this.getComponent()), exception);
						
						return;
					}
					
					fireHidden();
				}
			}
			);
		}
		
		protected Object loadBackground()
			throws Exception
		{
			return JThreadContainer.this.loadBackground();
		}
	}
	
	public abstract Component getContentPane();
	
	protected abstract void loadForeground(Object data)
		throws Exception;
	
	protected abstract Object loadBackground()
		throws Exception;
}