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

import java.awt.Dialog;
import java.awt.Frame;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import com.nepxion.swing.dialog.JExceptionDialog;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.util.exception.ExceptionUtil;

public abstract class JThreadDialog
	extends AbstractThreadDialog
{
	private SwingWorker swingWorker;
	private int delayTime = 200;

	public JThreadDialog(Frame owner, String title)
	{
		this(owner, title, SwingLocale.getString("transact_and_wait"));
	}
	
	public JThreadDialog(Dialog owner, String title)
	{
		this(owner, title, SwingLocale.getString("transact_and_wait"));
	}
	
	public JThreadDialog(Frame owner, String title, String information)
	{
		this(owner, title, new JLabel(IconFactory.getSwingIcon("thread/progress.gif")), information);
	}
	
	public JThreadDialog(Dialog owner, String title, String information)
	{
		this(owner, title, new JLabel(IconFactory.getSwingIcon("thread/progress.gif")), information);
	}
	
	public JThreadDialog(Frame owner, String title, JLabel animationLabel, String information)
	{
		super(owner, title, animationLabel, information);
	}
	
	public JThreadDialog(Dialog owner, String title, JLabel animationLabel, String information)
	{
		super(owner, title, animationLabel, information);
	}
	
	public void execute()
	{
		swingWorker = new SwingWorker();
		swingWorker.execute();
		
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				setVisible(true);
			}
		}
		);
	}
	
	protected void fireHidden()
	{
		dispose();
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
	
	public class SwingWorker
		extends AbstractSwingWorker
	{		
		public SwingWorker()
		{
			super(JThreadDialog.this, delayTime);
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
						JThreadDialog.this.loadForeground(data);
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
						
						JExceptionDialog.traceException(HandleManager.getFrame(SwingWorker.this.getComponent()), ExceptionUtil.subString(e), exception);
						
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
			return JThreadDialog.this.loadBackground();
		}
	}
	
	protected abstract void loadForeground(Object data)
		throws Exception;
	
	protected abstract Object loadBackground()
		throws Exception;
}