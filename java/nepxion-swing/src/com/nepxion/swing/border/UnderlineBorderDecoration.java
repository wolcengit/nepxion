package com.nepxion.swing.border;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.JComponent;

public class UnderlineBorderDecoration
{
	public UnderlineBorderDecoration(JComponent component)
	{
		component.setBorder(new UnderlineBorder());
		component.setBackground(null);
	}
}