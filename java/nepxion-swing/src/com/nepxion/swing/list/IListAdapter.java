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

import java.util.List;

public interface IListAdapter
{
	public boolean addRowPermitted();
	
	public Object addRow() throws Exception;
	
	
	public boolean modifyRowPermitted(int selectedRow);
	
	public Object modifyRow(int selectedRow) throws Exception;
	
	
	public boolean deleteRowPermitted(int selectedRow);
	
	public boolean deleteRow(int selectedRow) throws Exception;
	
	
	public boolean deleteRowsPermitted(int[] selectedRows);
	
	public boolean deleteRows(int[] selectedRows) throws Exception;
	
	
	public boolean refreshPermitted();
	
	public List refresh() throws Exception;
	
	
	public boolean clearPermitted();
	
	public boolean clear() throws Exception;
	
	
	public boolean savePermitted();
	
	public List save() throws Exception;
}