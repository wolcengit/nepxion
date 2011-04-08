package com.nepxion.swing.table;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;


public class MapTableModel
	extends BasicTableModel
{
	public MapTableModel(List rowDatas, String[] columnNames)
	{
		super(rowDatas, columnNames);
	}
	
	public Object getValueAt(int row, int column)
	{
		LinkedHashMap map = (LinkedHashMap) getRow(row);
		
		int index = 0;
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
		{
			Object key = iterator.next();
			if (index == column)
			{
				return map.get(key);
			}
			index++;
		}
		
		return null;
	}
	
	public void setValueAt(Object value, int row, int column)
	{
		LinkedHashMap map = (LinkedHashMap) getRow(row);
		
		int index = 0;
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
		{
			Object key = iterator.next();
			if (index == column)
			{
				map.put(key, value);
				break;
			}
			index++;
		}
		
		fireTableDataChanged();
	}
}