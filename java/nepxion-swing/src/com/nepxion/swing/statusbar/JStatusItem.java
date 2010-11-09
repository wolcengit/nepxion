package com.nepxion.swing.statusbar;

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
import javax.swing.JPanel;

import com.nepxion.swing.layout.filed.FiledLayout;

public class JStatusItem
	extends JPanel
{
	private int index = -1;
	
	public JStatusItem(JComponent component)
	{
		this();
		
		add(component);
	}
	
	public JStatusItem()
	{
		setLayout(new FiledLayout(FiledLayout.ROW, FiledLayout.LEFT, 0));
	}
	
	protected int getIndex()
	{
		return index;
	}
	
	protected void setIndex(int index)
	{
		this.index = index;
	}
}