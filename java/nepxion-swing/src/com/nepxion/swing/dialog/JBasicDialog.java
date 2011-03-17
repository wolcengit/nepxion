package com.nepxion.swing.dialog;

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
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.HierarchyEvent;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;

import com.nepxion.swing.listener.DisplayAbilityListener;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.window.WindowManager;

public class JBasicDialog
	extends JDialog
{
	private boolean isAdaptable = false;
	private boolean isHint = false;
	
	private Dimension dimension;
	private Dimension minimumDimension;
	private Dimension maximumDimension;
	
	private DialogResizer resizer;
	
	public JBasicDialog(Frame owner, String title)
	{
		this(owner, title, null);
	}
	
	public JBasicDialog(Dialog owner, String title)
	{
		this(owner, title, null);
	}	
	
	public JBasicDialog(Frame owner, String title, Dimension dimension)
	{
		this(owner, title, dimension, true);
	}
	
	public JBasicDialog(Dialog owner, String title, Dimension dimension)
	{
		this(owner, title, dimension, true);
	}
	
	public JBasicDialog(Frame owner, String title, boolean modal)
	{
		this(owner, title, null, modal, false);
	}
	
	public JBasicDialog(Dialog owner, String title, boolean modal)
	{
		this(owner, title, null, modal, false);
	}	
	
	public JBasicDialog(Frame owner, String title, Dimension dimension, boolean modal)
	{
		this(owner, title, dimension, modal, false);
	}
	
	public JBasicDialog(Dialog owner, String title, Dimension dimension, boolean modal)
	{
		this(owner, title, dimension, modal, false);
	}
	
	public JBasicDialog(Frame owner, String title, boolean modal, boolean isHint)
	{
		this(owner, title, null, modal, isHint, false);
	}
	
	public JBasicDialog(Dialog owner, String title, boolean modal, boolean isHint)
	{
		this(owner, title, null, modal, isHint, false);
	}	
	
	public JBasicDialog(Frame owner, String title, Dimension dimension, boolean modal, boolean isHint)
	{
		this(owner, title, dimension, modal, isHint, false);
	}
	
	public JBasicDialog(Dialog owner, String title, Dimension dimension, boolean modal, boolean isHint)
	{
		this(owner, title, dimension, modal, isHint, false);
	}
	
	public JBasicDialog(Frame owner, String title, boolean modal, boolean isHint, boolean isAdaptable)
	{
		this(owner, title, null, modal, isHint, false);
	}
	
	public JBasicDialog(Dialog owner, String title, boolean modal, boolean isHint, boolean isAdaptable)
	{
		this(owner, title, null, modal, isHint, false);
	}	
	
	public JBasicDialog(Frame owner, String title, Dimension dimension, boolean modal, boolean isHint, boolean isAdaptable)
	{
		super(owner, title, modal);
		
		this.dimension = dimension;
		this.isHint = isHint;
		this.isAdaptable = isAdaptable;
		
		initComponents();
	}
	
	public JBasicDialog(Dialog owner, String title, Dimension dimension, boolean modal, boolean isHint, boolean isAdaptable)
	{
		super(owner, title, modal);
		
		this.dimension = dimension;
		this.isHint = isHint;
		this.isAdaptable = isAdaptable;
		
		initComponents();
	}
	
	private void initComponents()
	{
		resizer = new DialogResizer();		
		
		if (dimension != null)
		{	
			setDimension(dimension);
		}
		else
		{
			addHierarchyListener(new DisplayAbilityListener()
			{
				public void displayAbilityChanged(HierarchyEvent e)
				{
					setDimension(getContentPane().getPreferredSize());
					removeHierarchyListener(this);
				}
			}
			);
		}
		setAdaptable(isAdaptable);
		setResizable(true);
	}
	
	public void setAdaptable(boolean isAdaptable)
	{
		this.isAdaptable = isAdaptable;
		
		if (isAdaptable)
		{
			if (minimumDimension == null)
			{
				setMinimumDimension(dimension);
			}
			addComponentListener(resizer);
		}
		else
		{
			removeComponentListener(resizer);
		}
	}
	
	public boolean isAdaptable()
	{
		return isAdaptable;
	}
	
	public boolean isHint()
	{
		return isHint;
	}
	
	public void setHint(boolean isHint)
	{
		this.isHint = isHint;
	}
	
	public int getDecoratedMargin()
	{
		return JDialog.isDefaultLookAndFeelDecorated() ? 27 : 0;
	}
	
	public Dimension getDimension()
	{
		return dimension;
	}
	
	public void setDimension(Dimension dimension)
	{
		this.dimension = dimension;
		
		WindowManager.setCenter(this, dimension);
		resizer.setDimension(dimension);
	}
	
	public Dimension getMinimumDimension()
	{
		return minimumDimension;
	}
	
	public void setMinimumDimension(Dimension minimumDimension)
	{
		this.minimumDimension = minimumDimension;
		
		resizer.setMinimumDimension(minimumDimension);
	}
	
	public Dimension getMaximumDimension()
	{
		return maximumDimension;
	}
	
	public void setMaximumDimension(Dimension maximumDimension)
	{
		this.maximumDimension = maximumDimension;
		
		resizer.setMaximumDimension(maximumDimension);
	}
	
	protected void processWindowEvent(WindowEvent e)
	{
		if (isHint)
		{
			if (e.getID() == WindowEvent.WINDOW_CLOSING)
			{
				int selectedValue = JBasicOptionPane.showConfirmDialog(getParent(), SwingLocale.getString("confirm_to_exit"), SwingLocale.getString("confirm"), JBasicOptionPane.YES_NO_OPTION);
				if (selectedValue != JBasicOptionPane.YES_OPTION)
				{
					return;
				}
			}
		}
		
		super.processWindowEvent(e);
	}
}