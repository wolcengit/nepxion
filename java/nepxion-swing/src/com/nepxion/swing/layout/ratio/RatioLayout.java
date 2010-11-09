package com.nepxion.swing.layout.ratio;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.l2fprod.common.swing.PercentLayout;

public class RatioLayout
	extends PercentLayout
{
	public RatioLayout()
	{
		this(HORIZONTAL);
	}
	
	public RatioLayout(int orientation)
	{
		this(orientation, 0);
	}
	
	public RatioLayout(int orientation, int gap)
	{
		super(orientation, gap);
	}
}