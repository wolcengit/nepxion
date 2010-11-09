package com.nepxion.swing.style.uidefaults;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.tree.DefaultMutableTreeNode;

public class UIDefaultsTreeNode
	extends DefaultMutableTreeNode
{
	private Object value;
	
	public UIDefaultsTreeNode(Object key)
	{
		this(key, null);
	}
	
	public UIDefaultsTreeNode(Object key, Object value)
	{
		super(key);
		
		this.value = value;
	}
	
	public Object getKey()
	{
		return getUserObject();
	}
	
	public Object getValue()
	{
		return value;
	}
}