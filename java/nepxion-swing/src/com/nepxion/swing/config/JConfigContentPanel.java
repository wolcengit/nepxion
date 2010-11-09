package com.nepxion.swing.config;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.BorderFactory;

import com.nepxion.swing.toggle.JToggleContentPanel;

public class JConfigContentPanel
	extends JToggleContentPanel
{
	public JConfigContentPanel()
	{
		super(true);
		
		getHeader().setBorder(BorderFactory.createEmptyBorder(4, 0, 4, 2));
	}
}