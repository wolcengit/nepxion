package com.nepxion.swing.table.sortable;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.nepxion.swing.table.JBasicTable;

/**
 * A simple extension of JTable that supports the use of a SortableTableModel.
 */
public class JSortableTable
	extends JBasicTable
{
	private SortButtonRenderer sortButtonRenderer;
	
	/** A listener for sorting. */
	private SortableTableHeaderListener headerListener;
	
	public JSortableTable()
	{
		initComponents();
	}
	
	/**
	 * Standard constructor - builds a table for the specified model.
	 */
	public JSortableTable(TableModel tableModel)
	{		
		initComponents();
		
		setDataModel(tableModel);
	}
	
	private void initComponents()
	{
		sortButtonRenderer = new SortButtonRenderer();
		
		final JTableHeader header = getTableHeader();
		this.headerListener = new SortableTableHeaderListener(sortButtonRenderer);
		header.addMouseListener(this.headerListener);
		header.addMouseMotionListener(this.headerListener);	
	}
		
	public TableModel getDataModel()
	{
		TableModel tableModel = getModel();
		if (tableModel instanceof SortableTableModel)
		{
			SortableTableModel sortableTableModel = (SortableTableModel) tableModel;
			
			return sortableTableModel.getDataModel();
		}
		
		return null;
	}
	
	public void setDataModel(TableModel dataModel)
	{
		SortableTableModel sortableTableModel = new SortableTableModel(dataModel);
		setModel(sortableTableModel);
		
		headerListener.setTableModel(sortableTableModel);
		
		TableColumnModel tableColumnModel = getColumnModel();
		for (int i = 0; i < getColumnCount(); i++)
		{
			tableColumnModel.getColumn(i).setHeaderRenderer(sortButtonRenderer);
		}
		
		sortableTableModel.sort();
		// sortableTableModel.sort(0, true);
	}
}