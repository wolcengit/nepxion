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

import java.text.CollationKey;
import java.text.Collator;
import java.util.Date;

public class Sorter
{
	private SortableTableModel model;
	
	public Sorter(SortableTableModel model)
	{
		this.model = model;
	}
	
	public void sort(int column, boolean isAscent)
	{
		int n = model.getRowCount();
		int[] indexes = model.getIndexes();
		Class clazz = model.getColumnClass(column);

		for (int i = 0; i < n - 1; i++)
		{
			int k = i;
			for (int j = i + 1; j < n; j++)
			{
				if (isAscent)
				{
					if (compare(j, k, column, clazz) < 0)
					{
						k = j;
					}
				}
				else
				{
					if (compare(j, k, column, clazz) > 0)
					{
						k = j;
					}
				}
			}
			int index = indexes[i];
			indexes[i] = indexes[k];
			indexes[k] = index;
		}
	}
	
	public int compare(int row1, int row2, int column, Class clazz)
	{
		Object object1 = model.getValueAt(row1, column);
		Object object2 = model.getValueAt(row2, column);
		if (object1 == null && object2 == null)
		{
			return 0;
		}
		else if (object1 == null)
		{
			return -1;
		}
		else if (object2 == null)
		{
			return 1;
		}
		else
		{
			if (clazz.getSuperclass() == Number.class)
			{
				return compare((Number) object1, (Number) object2);
			}
			else if (clazz == String.class)
			{
				CollationKey key1 = Collator.getInstance().getCollationKey(object1.toString());
				CollationKey key2 = Collator.getInstance().getCollationKey(object2.toString());
				
				return (key1).compareTo(key2);
			}
			else if (clazz == Date.class)
			{
				return compare((Date) object1, (Date) object2);
			}
			else if (clazz == Boolean.class)
			{
				return compare((Boolean) object1, (Boolean) object2);
			}
			else
			{
				return (object1.toString()).compareTo(object2.toString());
			}
		}
	}
	
	public int compare(Number number1, Number number2)
	{
		double value1 = number1.doubleValue();
		double value2 = number2.doubleValue();
		if (value1 < value2)
		{
			return -1;
		}
		else if (value1 > value2)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	public int compare(Date date1, Date date2)
	{
		long value1 = date1.getTime();
		long value2 = date2.getTime();
		if (value1 < value2)
		{
			return -1;
		}
		else if (value1 > value2)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	public int compare(Boolean boolean1, Boolean boolean2)
	{
		boolean value1 = boolean1.booleanValue();
		boolean value2 = boolean2.booleanValue();
		if (value1 == value2)
		{
			return 0;
		}
		else if (value1)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
}