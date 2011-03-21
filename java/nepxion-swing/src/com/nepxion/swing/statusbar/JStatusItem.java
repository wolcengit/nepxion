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

import javax.swing.BorderFactory;
import javax.swing.JComponent;

import com.nepxion.swing.toolbar.JBasicToolBar;

public class JStatusItem
	extends JBasicToolBar
{
	private int index = -1;
	
	public JStatusItem(JComponent component)
	{
		this();
		
		add(component);
	}
	
	public JStatusItem()
	{
		// setLayout(new FiledLayout(FiledLayout.ROW, FiledLayout.CENTER, 0));
		setBorder(BorderFactory.createEmptyBorder());
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