package com.nepxion.swing.framework.ribbon;

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
import javax.swing.JPanel;

import com.nepxion.swing.layout.filed.FiledLayout;

public class JRibbonBar
	extends JPanel
{
	public JRibbonBar()
	{
		setLayout(new FiledLayout(FiledLayout.ROW, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
	}
	
	public void addRibbon(JRibbon ribbon)
	{
		add(ribbon);
	}
}