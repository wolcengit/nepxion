package com.nepxion.swing.frame;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.window.WindowManager;

public class JBasicFrame
	extends JFrame
{
	private boolean isHint = true;
	private boolean isDestroy = true;
	
	public JBasicFrame()
	{
		this("");
	}
	
	public JBasicFrame(String title)
	{
		this(title, true);
	}
	
	public JBasicFrame(String title, ImageIcon imageIcon)
	{
		this(title, imageIcon, true);
	}
	
	public JBasicFrame(String title, Dimension dimension)
	{
		this(title, null, dimension);
	}
	
	public JBasicFrame(String title, boolean isDestroy)
	{
		this(title, (Dimension) null, isDestroy);
	}
	
	public JBasicFrame(String title, ImageIcon imageIcon, Dimension dimension)
	{
		this(title, imageIcon, dimension, true);
	}
	
	public JBasicFrame(String title, ImageIcon imageIcon, boolean isDestroy)
	{
		this(title, imageIcon, true, isDestroy);
	}
	
	public JBasicFrame(String title, Dimension dimension, boolean isDestroy)
	{
		this(title, dimension, true, isDestroy);
	}
	
	public JBasicFrame(String title, boolean isHint, boolean isDestroy)
	{
		this(title, (Dimension) null, isHint, isDestroy);
	}
	
	public JBasicFrame(String title, ImageIcon imageIcon, Dimension dimension, boolean isDestroy)
	{
		this(title, imageIcon, dimension, true, isDestroy);
	}
	
	public JBasicFrame(String title, ImageIcon imageIcon, boolean isHint, boolean isDestroy)
	{
		this(title, imageIcon, null, isHint, isDestroy);
	}
	
	public JBasicFrame(String title, Dimension dimension, boolean isHint, boolean isDestroy)
	{
		this(title, null, dimension, isHint, isDestroy);
	}
	
	public JBasicFrame(String title, ImageIcon imageIcon, Dimension dimension, boolean isHint, boolean isDestroy)
	{
		super(title);
		
		this.isHint = isHint;
		this.isDestroy = isDestroy;
		
		WindowManager.setCenter(this, dimension);
		if (imageIcon != null)
		{
			setIconImage(imageIcon.getImage());
		}
	}
	
	public boolean isHint()
	{
		return isHint;
	}
	
	public void setHint(boolean isHint)
	{
		this.isHint = isHint;
	}
	
	public boolean isDestroy()
	{
		return isDestroy;
	}
	
	public void setDestroy(boolean isDestroy)
	{
		this.isDestroy = isDestroy;
	}
	
	protected void processWindowEvent(WindowEvent e)
	{
		if (isHint)
		{
			if (e.getID() == WindowEvent.WINDOW_CLOSING)
			{
				int selectedValue = JBasicOptionPane.showConfirmDialog(this, SwingLocale.getString("confirm_to_exit"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
				if (selectedValue != JBasicOptionPane.YES_OPTION)
				{
					return;
				}
			}
		}
		super.processWindowEvent(e);
		if (isDestroy)
		{
			if (e.getID() == WindowEvent.WINDOW_CLOSING)
			{
				System.exit(0);
			}
		}
	}
	
    public void setExtendedState(int state)
	{
		if ((state & MAXIMIZED_BOTH) == MAXIMIZED_BOTH)
		{
			Rectangle bounds = getGraphicsConfiguration().getBounds();
			Rectangle maxBounds = null;
			if (bounds.x == 0 && bounds.y == 0)
			{
				Insets screenInsets = getToolkit().getScreenInsets(getGraphicsConfiguration());
				maxBounds = new Rectangle(screenInsets.left, screenInsets.top, bounds.width - screenInsets.right - screenInsets.left, bounds.height - screenInsets.bottom - screenInsets.top);
			}
			else
			{
				maxBounds = null;
			}
			super.setMaximizedBounds(maxBounds);
		}
		super.setExtendedState(state);
	}
}