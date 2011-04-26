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

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractListModel;

public class BasicListModel
	extends AbstractListModel
{
	private Vector rowDatas;
	
	public BasicListModel()
	{
		this(null);
	}
	
	public BasicListModel(Vector rowDatas)
	{
		if (rowDatas != null)
		{
			this.rowDatas = rowDatas;
		}
		else
		{
			this.rowDatas = new Vector();
		}
	}
	
	public Vector getRowDatas()
	{
		return rowDatas;
	}
	
	public void setRowDatas(Vector rowDatas)
	{
		int size = this.rowDatas.size();
		
		this.rowDatas = rowDatas;
		
		fireContentsChanged(this, 0, size);
	}
	
	public int getSize()
	{
		return rowDatas.size();
	}
	
	public Object getElementAt(int index)
	{
		return rowDatas.elementAt(index);
	}
	
	public void copyInto(Object[] array)
	{
		rowDatas.copyInto(array);
	}
	
	public void trimToSize()
	{
		rowDatas.trimToSize();
	}
	
	public void ensureCapacity(int minCapacity)
	{
		rowDatas.ensureCapacity(minCapacity);
	}
	
	public void setSize(int newSize)
	{
		int oldSize = rowDatas.size();
		rowDatas.setSize(newSize);
		
		if (oldSize > newSize)
		{
			fireIntervalRemoved(this, newSize, oldSize - 1);
		}
		else if (oldSize < newSize)
		{
			fireIntervalAdded(this, oldSize, newSize - 1);
		}
	}
	
	public int capacity()
	{
		return rowDatas.capacity();
	}
	
	public int size()
	{
		return rowDatas.size();
	}
	
	public boolean isEmpty()
	{
		return rowDatas.isEmpty();
	}
	
	public Enumeration elements()
	{
		return rowDatas.elements();
	}
	
	public boolean contains(Object element)
	{
		return rowDatas.contains(element);
	}
	
	public int indexOf(Object element)
	{
		return rowDatas.indexOf(element);
	}
	
	public int indexOf(Object element, int index)
	{
		return rowDatas.indexOf(element, index);
	}
	
	public int lastIndexOf(Object element)
	{
		return rowDatas.lastIndexOf(element);
	}
	
	public int lastIndexOf(Object element, int index)
	{
		return rowDatas.lastIndexOf(element, index);
	}
	
	public Object elementAt(int index)
	{
		return rowDatas.elementAt(index);
	}
	
	public Object firstElement()
	{
		return rowDatas.firstElement();
	}
	
	public Object lastElement()
	{
		return rowDatas.lastElement();
	}
	
	public void setElementAt(Object object, int index)
	{
		rowDatas.setElementAt(object, index);
		
		fireContentsChanged(this, index, index);
	}
	
	public void removeElementAt(int index)
	{
		rowDatas.removeElementAt(index);
		
		fireIntervalRemoved(this, index, index);
	}
	
	public void insertElementAt(Object object, int index)
	{
		rowDatas.insertElementAt(object, index);
		
		fireIntervalAdded(this, index, index);
	}
	
	public void addElement(Object object)
	{
		int index = rowDatas.size();
		rowDatas.addElement(object);
		
		fireIntervalAdded(this, index, index);
	}
	
	public void addElements(List objects)
	{
		int index = rowDatas.size();
		rowDatas.addAll(objects);
		
		fireIntervalAdded(this, index, index);
	}
	
	public void addElements(List objects, int index)
	{
		rowDatas.addAll(index, objects);
		
		fireIntervalAdded(this, index, index);
	}
	
	public boolean removeElement(Object object)
	{
		int index = indexOf(object);
		boolean value = rowDatas.removeElement(object);
		
		if (index >= 0)
		{
			fireIntervalRemoved(this, index, index);
		}
		
		return value;
	}
		
	public void removeAllElements()
	{
		int index = rowDatas.size() - 1;
		rowDatas.removeAllElements();
		
		if (index >= 0)
		{
			fireIntervalRemoved(this, 0, index);
		}
	}
	
	public void limitElements(int limitedElementCount, boolean isFromTop)
	{
		int rowCount = rowDatas.size();
		if (rowCount > limitedElementCount)
		{
			int deletedCount = rowCount - limitedElementCount;
			int[] deletedRows = new int[deletedCount];
			for (int i = 0; i < deletedCount; i++)
			{
				if (isFromTop)
				{
					deletedRows[i] = i;
				}
				else
				{
					deletedRows[i] = rowCount - i - 1;
				}
			}
			removeElements(deletedRows);
		}
	}
	
	public String toString()
	{
		return rowDatas.toString();
	}
	
	public Object[] toArray()
	{
		Object[] array = new Object[rowDatas.size()];
		rowDatas.copyInto(array);
		
		return array;
	}
	
	public Object get(int index)
	{
		return rowDatas.elementAt(index);
	}
	
	public Object set(int index, Object element)
	{
		Object object = rowDatas.elementAt(index);
		rowDatas.setElementAt(element, index);
		
		fireContentsChanged(this, index, index);
		
		return object;
	}
	
	public void add(int index, Object element)
	{
		rowDatas.insertElementAt(element, index);
		
		fireIntervalAdded(this, index, index);
	}
	
	public Object remove(int index)
	{
		Object object = rowDatas.elementAt(index);
		rowDatas.removeElementAt(index);
		
		fireIntervalRemoved(this, index, index);
		
		return object;
	}
	
	public void removeElements(int[] indexes)
	{
		List elements = new ArrayList();
		for (int i = 0; i < indexes.length; i++)
		{
			int row = indexes[i];
			Object element = rowDatas.elementAt(row);
			elements.add(element);
		}
		removeElements(elements);
	}
	
	public void removeElements(List elements)
	{
		int index = rowDatas.size() - 1;
		
		rowDatas.removeAll(elements);
		
		if (index >= 0)
		{
			fireIntervalRemoved(this, 0, index);
		}
	}
	
	public void clear()
	{
		int index = rowDatas.size() - 1;
		rowDatas.removeAllElements();
		
		if (index >= 0)
		{
			fireIntervalRemoved(this, 0, index);
		}
	}
	
	public void removeRange(int fromIndex, int toIndex)
	{
		if (fromIndex > toIndex)
		{
			throw new IllegalArgumentException("fromIndex must be <= toIndex");
		}
		for (int i = toIndex; i >= fromIndex; i--)
		{
			rowDatas.removeElementAt(i);
		}
		
		fireIntervalRemoved(this, fromIndex, toIndex);
	}
	
	public void moveUp(int index)
	{
		if (index <= 0)
		{
			return;
		}	
		
		Object object = rowDatas.elementAt(index);
		
		rowDatas.remove(index);
		rowDatas.add(index - 1, object);
		
		fireContentsChanged(this, index - 1, index);
	}
	
	public void moveDown(int index)
	{
		if (index >= rowDatas.size() - 1)
		{
			return;
		}	
		
		Object object = rowDatas.elementAt(index);
		
		rowDatas.remove(index);
		rowDatas.add(index + 1, object);
		
		fireContentsChanged(this, index, index + 1);
	}	
}