package com.nepxion.swing.shrinkbar;

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

public class JShrinkBar
	extends BasicShrinkBar
{	
	private Component contentPane;
	
	public JShrinkBar(int placement)
	{
		this(placement, null);
	}
	
	public JShrinkBar(int placement, Component contentPane)
	{
		this(placement, CONTENT_PANE_TYPE_LABEL, contentPane);
	}
	
	public JShrinkBar(int placement, int contentPaneType)
	{
		this(placement, contentPaneType, null);
	}
	
	public JShrinkBar(int placement, int contentPaneType, Component contentPane)
	{
		super(placement, contentPaneType);
		
		this.contentPane = contentPane;
		
		if (contentPane != null)
		{
			setContentPane(contentPane);
		}
	}
	
	public Component getContentPane()
	{
		return contentPane;
	}
	
	public void setContentPane(Component contentPane)
	{
		this.contentPane = contentPane;
		
		add(contentPane, BorderLayout.CENTER);
	}
}