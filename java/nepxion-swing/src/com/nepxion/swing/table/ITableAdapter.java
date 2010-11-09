package com.nepxion.swing.table;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

public interface ITableAdapter
{
	public boolean addRowPermitted();
	
	public Object addRow();
	
	
	public boolean modifyRowPermitted(int selectedRow);
	
	public Object modifyRow(int selectedRow);
	
	
	public boolean deleteRowPermitted(int selectedRow);
	
	public boolean deleteRow(int selectedRow);
	
	
	public boolean deleteRowsPermitted(int[] selectedRows);
	
	public boolean deleteRows(int[] selectedRows);
	
	
	public boolean clearPermitted();
	
	public boolean clear();
}