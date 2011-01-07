package com.nepxion.swing.taskbar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.l2fprod.common.swing.JTaskPane;

public class JTaskBar
	extends JTaskPane
{
	public JTaskBar()
	{
		super();
	}
	
	public JTaskGroup getTaskGroup(String title)
	{
		for (int i = 0; i < getComponentCount(); i++)
		{
			JTaskGroup taskGroup = (JTaskGroup) getComponent(i);
			if (taskGroup.getTitle().trim().equals(title.trim()))
			{
				return taskGroup;
			}
		}
		
		return null;
	}
	
	public JTaskGroup getTaskGroup(int index)
	{
		return (JTaskGroup) getComponent(index);
	}
}