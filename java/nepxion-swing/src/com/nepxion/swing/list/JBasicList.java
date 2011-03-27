package com.nepxion.swing.list;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListModel;

public class JBasicList
	extends JList
{
	public JBasicList()
	{
		super();
		
		initComponents();
	}
	
	public JBasicList(ListModel dataModel)
	{
		super(dataModel);
		
		initComponents();
	}
	
	public JBasicList(Object[] listData)
	{
		super(listData);
		
		initComponents();
	}
	
	public JBasicList(Vector listData)
	{
		super(listData);
		
		initComponents();
	}
	
	private void initComponents()
	{
		ListManager.setPreferenceStyle(this);
	}
}