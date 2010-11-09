package com.nepxion.swing.layout.box;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Container;

import com.jidesoft.swing.JideBoxLayout;

public class XBoxLayout
	extends JideBoxLayout
{
	public XBoxLayout(Container target)
	{
		super(target);
	}
	
	public XBoxLayout(Container target, int axis)
	{
		super(target, axis);
	}
	
	public XBoxLayout(Container target, int axis, int gap)
	{
		super(target, axis, gap);
	}
}