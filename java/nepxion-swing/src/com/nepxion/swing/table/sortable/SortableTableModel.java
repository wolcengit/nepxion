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

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 * The base class for a sortable table model.
 */
public class SortableTableModel
	extends AbstractTableModel
{
	/** The column on which the data is sorted (-1 for no sorting). */
	private int sortingColumn;
	
	/** Indicates ascending (true) or descending (false) order. */
	private boolean ascending;
	
	private int[] indexes;
	private Sorter sorter;
	
	private TableModel dataModel;
	
	/**
	 * Constructs a sortable table model.
	 */
	public SortableTableModel(TableModel dataModel)
	{
		this.dataModel = dataModel;
		this.dataModel.addTableModelListener(new TableModelListener()
		{
			public void tableChanged(TableModelEvent e)
			{
				if (sortingColumn != -1)
				{	
					sort();
				}
				else
				{
					fireTableDataChanged();
				}
			}
		}
		);
		
		this.sortingColumn = -1;
		this.ascending = true;
		
		getIndexes();
	}
	
	public int getRowCount()
	{
		return dataModel.getRowCount();
	}
	
	public int getColumnCount()
	{
		return dataModel.getColumnCount();
	}
	
	public String getColumnName(int column)
	{
		return dataModel.getColumnName(column);
	}
	
	public Class getColumnClass(int column)
	{
		return dataModel.getColumnClass(column);
	}
	
	public boolean isCellEditable(int row, int column)
	{
		return dataModel.isCellEditable(getIndexes()[row], column);
	}
	
	public Object getValueAt(int row, int column)
	{
		return dataModel.getValueAt(getIndexes()[row], column);
	}
	
	public void setValueAt(Object value, int row, int column)
	{
		dataModel.setValueAt(value, getIndexes()[row], column);
	}
	
	public TableModel getDataModel()
	{
		return dataModel;
	}
	
	/**
	 * Returns the index of the sorting column, or -1 if the data is not sorted
	 * on any column.
	 * @return the column used for sorting.
	 */
	public int getSortingColumn()
	{
		return this.sortingColumn;
	}
	
	/**
	 * Returns <code>true</code> if the data is sorted in ascending order, and
	 * <code>false</code> otherwise.
	 * @return <code>true</code> if the data is sorted in ascending order, and
	 *         <code>false</code> otherwise.
	 */
	public boolean isAscending()
	{
		return this.ascending;
	}
	
	/**
	 * Sets the flag that determines whether the sort order is ascending or
	 * descending.
	 * @param flag the flag.
	 */
	public void setAscending(final boolean flag)
	{
		this.ascending = flag;
	}
	
	/**
	 * Returns a flag indicating whether or not a column is sortable.
	 * @param column the column (zero-based index).
	 * @return boolean.
	 */
	public boolean isSortable(final int sortingColumn)
	{
		return true;
	}
	
	public void sort()
	{
		sort(sortingColumn, ascending);
	}
	
	/**
	 * Sorts the table.
	 * @param column the column to sort on (zero-based index).
	 * @param ascending a flag to indicate ascending order or descending order.
	 */
	public void sort(final int sortingColumn, final boolean ascending)
	{
		if (isSortable(sortingColumn))
		{
			this.sortingColumn = sortingColumn;
			
			if (sortingColumn != -1)
			{
				if (sorter == null)
				{
					sorter = new Sorter(this);
				}
				this.sortingColumn = sortingColumn;
				this.ascending = ascending;
				sorter.sort(sortingColumn, ascending);
				fireTableDataChanged();
			}
		}
	}
	
	public int[] getIndexes()
	{
		int rowCount = getRowCount();
		if (indexes != null)
		{
			if (indexes.length == rowCount)
			{
				return indexes;
			}
		}
		indexes = new int[rowCount];
		for (int i = 0; i < rowCount; i++)
		{
			indexes[i] = i;
		}
		
		return indexes;
	}
	
	public int getRowIndex(int row)
	{				
		return getIndexes()[row];
	}
	
	public int[] getRowIndexes(int[] rows)
	{
		int[] rowIndexes = new int[rows.length];
		for (int i = 0; i < rows.length; i++)
		{
			int rowIndex = getRowIndex(rows[i]);
			rowIndexes[i] = rowIndex;
		}
		
		return rowIndexes;
	}	
}