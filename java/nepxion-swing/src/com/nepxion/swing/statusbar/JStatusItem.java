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
	/**
	 * The index value.
	 */
	private int index = -1;
	
	/**
	 * Constructs with the specified initial component.
	 * @param component the instance of JComponent
	 */
	public JStatusItem(JComponent component)
	{
		this();
		
		add(component);
	}
	
	/**
	 * Initializes the components.
	 */
	public JStatusItem()
	{
		// setLayout(new FiledLayout(FiledLayout.ROW, FiledLayout.CENTER, 0));
		setBorder(BorderFactory.createEmptyBorder());
	}
	
	/**
	 * Gets the index.
	 * @return the index value
	 */
	protected int getIndex()
	{
		return index;
	}
	
	/**
	 * Sets the index.
	 * @param index the index value
	 */
	protected void setIndex(int index)
	{
		this.index = index;
	}
}