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

import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

public interface IList
{
	public static final int SINGLE_SELECTION = ListSelectionModel.SINGLE_SELECTION;
	public static final int SINGLE_INTERVAL_SELECTION = ListSelectionModel.SINGLE_INTERVAL_SELECTION;
	public static final int MULTIPLE_INTERVAL_SELECTION = ListSelectionModel.MULTIPLE_INTERVAL_SELECTION;
	
	public ListModel getModel();
	
	public void setModel(ListModel listModel);
	
	public int getSelectionMode();
	
	public void setSelectionMode(int mode);
	
	public int[] getSelectedIndexes();
	
	public Vector getListData();
	
	public void executeSelection(int oldSelectionRow, int newSelectionRow);
	
	public void executeClicked(int selectedRow);
	
	public void executeDoubleClicked(int selectedRow);
	
	public void executePopupMenu(int selectedRow, int x, int y);
	
	public void executePopupMenu(int x, int y);
}