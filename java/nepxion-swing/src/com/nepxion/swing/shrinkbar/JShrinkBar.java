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

import com.nepxion.swing.style.texture.shrink.IHeaderTextureStyle;

public class JShrinkBar
	extends BasicShrinkBar
{
	private Component contentPane;
	
	public JShrinkBar(int placement)
	{
		this(placement, DEFAULT_CONTENT_PANE_TYPE);
	}
	
	public JShrinkBar(int placement, IHeaderTextureStyle headerTextureStyle)
	{
		this(placement, DEFAULT_CONTENT_PANE_TYPE, headerTextureStyle);
	}
	
	public JShrinkBar(int placement, int contentPaneType)
	{
		this(placement, contentPaneType, DEFAULT_HEADER_TEXTURE_STYLE);
	}
	
	public JShrinkBar(int placement, int contentPaneType, IHeaderTextureStyle headerTextureStyle)
	{
		super(placement, contentPaneType, headerTextureStyle);
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