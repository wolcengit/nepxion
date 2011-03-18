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

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;

import com.nepxion.swing.dialog.JBasicDialog;

public class JFrameWorkDialog
	extends JBasicDialog implements JFrameWorkWindow
{
	private JFrameWorkHierarchy frameWorkHierarchy;
	
	public JFrameWorkDialog(Frame owner, String title)
	{
		super(owner, title);
	}
	
	public JFrameWorkDialog(Dialog owner, String title)
	{
		super(owner, title);
	}	
	
	public JFrameWorkDialog(Frame owner, String title, Dimension dimension)
	{
		super(owner, title, dimension);
	}
	
	public JFrameWorkDialog(Dialog owner, String title, Dimension dimension)
	{
		super(owner, title, dimension);
	}
	
	public JFrameWorkDialog(Frame owner, String title, boolean modal)
	{
		super(owner, title, modal);
	}
	
	public JFrameWorkDialog(Dialog owner, String title, boolean modal)
	{
		super(owner, title, modal);
	}	
	
	public JFrameWorkDialog(Frame owner, String title, Dimension dimension, boolean modal)
	{
		super(owner, title, dimension, modal);
	}
	
	public JFrameWorkDialog(Dialog owner, String title, Dimension dimension, boolean modal)
	{
		super(owner, title, dimension, modal);
	}
	
	public JFrameWorkDialog(Frame owner, String title, boolean modal, boolean isHint)
	{
		super(owner, title, modal, isHint);
	}
	
	public JFrameWorkDialog(Dialog owner, String title, boolean modal, boolean isHint)
	{
		super(owner, title, modal, isHint);
	}	
	
	public JFrameWorkDialog(Frame owner, String title, Dimension dimension, boolean modal, boolean isHint)
	{
		super(owner, title, dimension, modal, isHint);
	}
	
	public JFrameWorkDialog(Dialog owner, String title, Dimension dimension, boolean modal, boolean isHint)
	{
		super(owner, title, dimension, modal, isHint);
	}
	
	public JFrameWorkDialog(Frame owner, String title, boolean modal, boolean isHint, boolean isAdaptable)
	{
		super(owner, title, modal, isHint, isAdaptable);
	}
	
	public JFrameWorkDialog(Dialog owner, String title, boolean modal, boolean isHint, boolean isAdaptable)
	{
		super(owner, title, modal, isHint, isAdaptable);
	}	
	
	public JFrameWorkDialog(Frame owner, String title, Dimension dimension, boolean modal, boolean isHint, boolean isAdaptable)
	{
		super(owner, title, dimension, modal, isHint, isAdaptable);
	}
	
	public JFrameWorkDialog(Dialog owner, String title, Dimension dimension, boolean modal, boolean isHint, boolean isAdaptable)
	{
		super(owner, title, dimension, modal, isHint, isAdaptable);
	}
	
	public void setHierarchy(JFrameWorkHierarchy frameWorkHierarchy)
	{
		this.frameWorkHierarchy = frameWorkHierarchy;
		
		if (getContentPane().getComponentCount() > 0)
		{
			getContentPane().removeAll();
		}
		getContentPane().add(frameWorkHierarchy);
	}
	
	public JFrameWorkHierarchy getHierarchy()
	{
		return frameWorkHierarchy;
	}
}