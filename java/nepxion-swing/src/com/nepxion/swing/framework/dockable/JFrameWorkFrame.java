package com.nepxion.swing.framework.dockable;

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

import javax.swing.ImageIcon;

import com.nepxion.swing.frame.JBasicFrame;

public class JFrameWorkFrame
	extends JBasicFrame implements JFrameWorkWindow
{
	private JFrameWorkHierarchy frameWorkHierarchy;
	
	public JFrameWorkFrame()
	{
		super();
	}
	
	public JFrameWorkFrame(String title)
	{
		super(title);
	}
	
	public JFrameWorkFrame(String title, ImageIcon imageIcon)
	{
		super(title, imageIcon);
	}
	
	public JFrameWorkFrame(String title, Dimension dimension)
	{
		super(title, dimension);
	}
	
	public JFrameWorkFrame(String title, boolean isDestroy)
	{
		super(title, isDestroy);
	}
	
	public JFrameWorkFrame(String title, ImageIcon imageIcon, Dimension dimension)
	{
		super(title, imageIcon, dimension);
	}
	
	public JFrameWorkFrame(String title, ImageIcon imageIcon, boolean isDestroy)
	{
		super(title, imageIcon, isDestroy);
	}
	
	public JFrameWorkFrame(String title, Dimension dimension, boolean isDestroy)
	{
		super(title, dimension, isDestroy);
	}
	
	public JFrameWorkFrame(String title, boolean isHint, boolean isDestroy)
	{
		super(title, isHint, isDestroy);
	}
	
	public JFrameWorkFrame(String title, ImageIcon imageIcon, Dimension dimension, boolean isDestroy)
	{
		super(title, imageIcon, dimension, isDestroy);
	}
	
	public JFrameWorkFrame(String title, ImageIcon imageIcon, boolean isHint, boolean isDestroy)
	{
		super(title, imageIcon, isHint, isDestroy);
	}
	
	public JFrameWorkFrame(String title, Dimension dimension, boolean isHint, boolean isDestroy)
	{
		super(title, dimension, isHint, isDestroy);
	}
	
	public JFrameWorkFrame(String title, ImageIcon imageIcon, Dimension dimension, boolean isHint, boolean isDestroy)
	{
		super(title, imageIcon, dimension, isHint, isDestroy);
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