package com.nepxion.swing.table;

import java.util.List;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

public abstract class AbstractTableAdapter
	implements ITableAdapter	        
{
	public AbstractTableAdapter()
	{
		
	}
	
	public boolean addRowPermitted()
	{
		return true;
	}
	
	public Object addRow()
	{
		return null;
	}
	
	
	public boolean modifyRowPermitted(int selectedRow)
	{
		return true;
	}
	
	public Object modifyRow(int selectedRow)
	{
		return null;
	}
	
	
	public boolean deleteRowPermitted(int selectedRow)
	{
		return true;
	}
	
	public boolean deleteRow(int selectedRow)
	{
		return true;
	}
	
	
	public boolean deleteRowsPermitted(int[] selectedRows)
	{
		return true;
	}
	
	public boolean deleteRows(int[] selectedRows)
	{
		return true;
	}
	
	
	public boolean refreshPermitted()
	{
		return true;
	}
	
	public List refresh()
	{
		return null;
	}
	
	
	public boolean clearPermitted()
	{
		return true;
	}
	
	public boolean clear()
	{
		return true;
	}
}