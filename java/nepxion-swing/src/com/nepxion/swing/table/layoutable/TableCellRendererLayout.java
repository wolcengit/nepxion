package com.nepxion.swing.table.layoutable;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class TableCellRendererLayout
{
	// 自适应尺寸设置
	// 1. 当设置单元格的宽度时候，需比较表格单元格绘制器CellRenderer和表格头单元绘制器的宽度，取最大值，设置单元格的宽度
	// 2. 当设置单元格的高度时候，取表格单元格绘制器CellRenderer的高度，设置单元格的高度
	public static final int PREFERRED = -1;
	
	// 不进行尺寸设置
	public static final int IGNORE = -2;
	
	private JTable table;
	
	public TableCellRendererLayout(JTable table)
	{
		this.table = table;
	}
	
	public void doLayout()
	{
		doLayout((int[]) null);
	}
	
	public void doLayout(int[] gaps)
	{
		doLayout(null, null, gaps);
	}
	
	public void doLayout(int[][] sizes)
	{
		doLayout(sizes, (int[][]) null);
	}
	
	public void doLayout(int[][] sizes, int[][] range)
	{
		doLayout(sizes, range, null);
	}
	
	public void doLayout(int[][] range, int[] gaps)
	{
		doLayout(null, range, gaps);
	}	
	
	/*
	 * 1.参数：int[][] size 
	 *   说明：第一数组用来定义表格宽度的情况，第二数组用来定义表格高度的情况
	 *   举例：{{50, NONE, PREFERRED}, {PREFERRED, 50, NONE}}
	 *         表示第0列宽度为50，第1列不进行宽度设置（由表格来分配），第2列自适应宽度设置
	 *         表示第0行自适应高度设置，第1列高度为50，第2列不进行高度设置（由表格来分配）
	 *         
	 *   参数：int[] range
	 *   说明：第一数组用来定义表格宽度的最大最小区间，第二数组用来定义表格告度的最大最小区间。该情况只适用于自适配设置的情况
	 *   举例：{{50, 100}, {10, 50}}
	 *         表示当自适应设置时候，表格单元格宽度最小为50， 最大为100。如不设定最大或者最小值，则用-1来代替，{-1, 100}，表示最大为100，最小不限制
	 *         表示当自适应设置时候，表格单元格最小为10， 最大为50。如不设定最大或者最小值，则用-1来代替，{-1, 100}，表示最大为100，最小不限制
	 *   举例：{10, -5}
	 *         表示所有表格列加宽10个像素值，所有表格行减少5个像素值
	 *                                      
	 *   参数：int[] gaps
	 *   说明：第一数值为行缩进值，正数为加宽的像素值，负数为缩减的像素值 
	 *   举例：{10, -5}
	 *         表示所有表格列加宽10个像素值，所有表格行减少5个像素值
	 * 2.提示：
	 *   表格有优先分配先出现的列的宽度，假如表格有3列，设置最后一列的宽度为100，则是无效的，因为表格已经为前2列分配了默认的宽度，最后一列只能执行自适应的宽度                
	 */
	public void doLayout(int[][] sizes, int[][] range, int[] gaps)
	{
		int[] columnWidths = null;
		int[] rowHeights = null;
		if (sizes != null)
		{
			columnWidths = sizes[0];
			rowHeights = sizes[1];
		}
		
		int[] columnRangeWidths = null;
		int[] rowRangeHeights = null;
		if (range != null)
		{
			columnRangeWidths = range[0];
			rowRangeHeights = range[1];
		}
		
		int columnMinimumWidth = 0;
		int columnMaximumWidth = 0;
		if (columnRangeWidths != null)
		{
			columnMinimumWidth = columnRangeWidths[0];
			columnMaximumWidth = columnRangeWidths[1];
		}
		
		int rowMinimumHeight = 0;
		int rowMaximumHeight = 0;
		if (rowRangeHeights != null)
		{
			rowMinimumHeight = rowRangeHeights[0];
			rowMaximumHeight = rowRangeHeights[1];
		}
		
		int columnGap = 0;
		int rowGap = 0;
		if (gaps != null)
		{
			columnGap = gaps[0];
			rowGap = gaps[1];
		}
		
		int columnCount = table.getColumnCount();
		for (int columnIndex = 0; columnIndex < columnCount; columnIndex++)
		{
			int columnWidth = IGNORE;
			if (columnWidths == null)
			{
				columnWidth = PREFERRED;
			}
			else
			{
				if (columnIndex < columnWidths.length)
				{
					columnWidth = columnWidths[columnIndex];
				}
				else
				{
					break;
				}
			}
			doLayoutColumnWidth(columnIndex, columnWidth, columnMinimumWidth, columnMaximumWidth, columnGap);
		}
		
		int rowCount = table.getRowCount();
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++)
		{
			int rowHeight = IGNORE;
			if (rowHeights == null)
			{
				rowHeight = PREFERRED;
			}
			else
			{
				if (rowIndex < rowHeights.length)
				{
					rowHeight = rowHeights[rowIndex];
				}
				else
				{
					break;
				}
			}
			doLayoutRowHeight(rowIndex, rowHeight, rowMinimumHeight, rowMaximumHeight, rowGap);
		}
	}
	
	public void doLayoutColumnWidth(int columnIndex, int columnWidth, int columnMinimumWidth, int columnMaximumWidth, int columnGap)
	{
		JTableHeader header = table.getTableHeader();
		TableColumn column = table.getColumnModel().getColumn(columnIndex);
		header.setResizingColumn(column);
		
		if (columnWidth > 0)
		{
			column.setWidth(columnWidth + columnGap);
		}
		if (columnWidth == -1)
		{
			int rowCount = table.getRowCount();
			System.out.println(rowCount + " &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& ");
			Component headerCellRenderer = header.getDefaultRenderer().getTableCellRendererComponent(table, column.getIdentifier(), false, false, 0, columnIndex);
			int width = (int) headerCellRenderer.getPreferredSize().getWidth();
			
			for (int rowIndex = 0; rowIndex < rowCount; rowIndex++)
			{
				Component cellRenderer = table.getCellRenderer(rowIndex, columnIndex).getTableCellRendererComponent(table, table.getValueAt(rowIndex, columnIndex), false, false, rowIndex, columnIndex);
				
				int cellRendererWidth = (int) cellRenderer.getPreferredSize().getWidth();
				width = Math.max(cellRendererWidth, width);
			}
			
			if (columnMinimumWidth > 0 && columnMinimumWidth > width)
			{
				width = columnMinimumWidth;
			}
			else if (columnMaximumWidth > 0 && columnMaximumWidth < width)
			{
				width = columnMaximumWidth;
			}
			
			column.setWidth(width + columnGap);
		}
	}
	
	public void doLayoutRowHeight(int rowIndex, int rowHeight, int rowMinimumHeight, int rowMaximumHeight, int rowGap)
	{
		if (rowHeight > 0)
		{
			table.setRowHeight(rowIndex, rowHeight + rowGap);
		}
		if (rowHeight == -1)
		{
			int columnCount = table.getColumnCount();
			int height = 0;
			
			for (int columnIndex = 0; columnIndex < columnCount; columnIndex++)
			{
				Component cellRenderer = table.getCellRenderer(rowIndex, columnIndex).getTableCellRendererComponent(table, table.getValueAt(rowIndex, columnIndex), false, false, rowIndex, columnIndex);
				int cellRendererHeight = (int) cellRenderer.getPreferredSize().getHeight();
				if (height < cellRendererHeight)
				{
					height = cellRendererHeight;
				}
			}
			
			if (rowMinimumHeight > 0 && rowMinimumHeight > height)
			{
				height = rowMinimumHeight;
			}
			else if (rowMaximumHeight > 0 && rowMaximumHeight < height)
			{
				height = rowMaximumHeight;
			}
			
			if (height + rowGap > 0)
			{	
				table.setRowHeight(rowIndex, height + rowGap);
			}
		}
	}
}