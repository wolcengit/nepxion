package com.nepxion.swing.list.toggle;

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

import com.nepxion.swing.list.BasicListModel;
import com.nepxion.swing.list.JBasicList;
import com.nepxion.swing.toggle.JToggleContentPanel;

public class JToggleList
	extends JBasicList implements IToggleList
{
	private int invokeMode = INVOKE_MODE_SELECTED;
	
	private JToggleContentPanel toggleContentPanel;
	
	private IToggleAdapter toggleAdapter;
	
	public JToggleList()
	{
		super();
		
		initComponents();
	}
	
	public JToggleList(BasicListModel listModel)
	{
		super(listModel);
		
		initComponents();
	}
	
	public JToggleList(Object[] listData)
	{
		setListData(listData);
		
		initComponents();
	}
	
	public JToggleList(Vector listData)
	{
		setListData(listData);
		
		initComponents();
	}
	
	private void initComponents()
	{

	}
	
	public int getInvokeMode()
	{
		return invokeMode;
	}
	
	public void setInvokeMode(int invokeMode)
	{
		this.invokeMode = invokeMode;
	}
	
	public JToggleContentPanel getToggleContentPanel()
	{
		return toggleContentPanel;
	}
	
	public void setToggleContentPanel(JToggleContentPanel toggleContentPanel)
	{
		this.toggleContentPanel = toggleContentPanel;
	}
	
	public IToggleAdapter getToggleAdapter()
	{
		return toggleAdapter;
	}
	
	public void setToggleAdapter(IToggleAdapter toggleAdapter)
	{
		this.toggleAdapter = toggleAdapter;
	}
	
	public void executeSelection(int oldSelectedRow, int newSelectedRow)
	{
		if (invokeMode == INVOKE_MODE_SELECTED)
		{
			toggleAdapter.invoke(oldSelectedRow, newSelectedRow);
		}
	}
	
	public void executeClicked(int selectedRow)
	{
		if (invokeMode == INVOKE_MODE_CLICKED)
		{
			toggleAdapter.invoke(-1, selectedRow);
		}
	}
	
	public void executeDoubleClicked(int selectedRow)
	{
		if (invokeMode == INVOKE_MODE_DOUBLE_CLICKED)
		{
			toggleAdapter.invoke(-1, selectedRow);
		}
	}
}