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

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.nepxion.util.data.CollectionUtil;

public class JBasicList
	extends JList implements IList, ListSelectionListener, MouseListener
{
	private int selectedIndex = -1;
	
	public JBasicList()
	{
		super();
		
		initComponents();
	}
	
	public JBasicList(BasicListModel listModel)
	{
		super(listModel);
		
		initComponents();
	}
	
	public JBasicList(Object[] listData)
	{
		setListData(listData);
		
		initComponents();
	}
	
	public JBasicList(Vector listData)
	{
		setListData(listData);
		
		initComponents();
	}
	
	private void initComponents()
	{
		ListManager.setPreferenceStyle(this);
		
		addListSelectionListener(this);
	}
	
	public int[] getSelectedIndexes()
	{
		BasicListModel listModel = (BasicListModel) getModel();
		
		Object[] selectedValues = getSelectedValues();
		int[] selectedIndexes = new int[selectedValues.length];
		
		for (int i = 0; i < selectedValues.length; i++)
		{
			Object object = selectedValues[i];
			
			int index = listModel.indexOf(object);
			
			selectedIndexes[i] = index;
		}
		
		return selectedIndexes;
	}
	
	public Vector getListData()
	{
		BasicListModel listModel = (BasicListModel) getModel();
		
		return listModel.getRowDatas();
	}
	
	public void setListData(Object[] listData)
	{
		Vector rowDatas = CollectionUtil.parseVector(listData);
		setListData(rowDatas);
	}
	
	public void setListData(Vector listData)
	{
		ListModel model = getModel();
		if (model instanceof BasicListModel)
		{
			BasicListModel listModel = (BasicListModel) model;
			listModel.setRowDatas(listData);
		}
		else
		{
			BasicListModel listModel = new BasicListModel(listData);
			setModel(listModel);
		}
	}
	
	public void moveUp(int index)
	{		
		BasicListModel listModel = (BasicListModel) getModel();
		
		if (index > 0)
		{		
			listModel.moveUp(index);
			
			setSelectedIndex(index - 1);
		}
	}
	
	public void moveDown(int index)
	{		
		BasicListModel listModel = (BasicListModel) getModel();
		
		if (index > -1 && index < listModel.size() - 1)
		{
			listModel.moveDown(index);
			
			setSelectedIndex(index + 1);
		}
	}
	
	public void valueChanged(ListSelectionEvent e)
	{
		int[] selectedRows = getSelectedIndexes();
		
		if (selectedRows.length == 0)
		{
			boolean isAdjusting = e.getValueIsAdjusting();
			if (isAdjusting)
			{
				int oldSelectedRow = selectedIndex;
				int newSelectedRow = -1;
				selectedIndex = -1;
				
				executeSelection(oldSelectedRow, newSelectedRow);
			}
		}
		else if (selectedRows.length == 1)
		{
			if (getSelectedIndex() == selectedIndex)
			{
				return;
			}
						
			selectedIndex = getSelectedIndex();
			
			int oldSelectedRow = -1;
			int newSelectedRow = -1;
			
			int firstIndex = e.getFirstIndex();
			int lastIndex = e.getLastIndex();
			
			if (e.getFirstIndex() == e.getLastIndex())
			{
				newSelectedRow = selectedIndex;
			}
			else if (e.getFirstIndex() == selectedIndex)
			{
				oldSelectedRow = lastIndex;
				newSelectedRow = firstIndex;
			}
			else if (e.getLastIndex() == selectedIndex)
			{
				oldSelectedRow = firstIndex;
				newSelectedRow = lastIndex;
			}
			else
			{
				oldSelectedRow = -1;
				newSelectedRow = selectedIndex;
			}
			
			executeSelection(oldSelectedRow, newSelectedRow);
		}
	}
	
	public void executeSelection(int oldSelectedRow, int newSelectedRow)
	{

	}
	
	public void mouseClicked(MouseEvent e)
	{
		int selectedRow = getSelectedIndex();
		
		executeClicked(selectedRow, e);
	}
	
	public void executeClicked(int selectedRow, MouseEvent e)
	{
		if (e.getClickCount() > 1)
		{
			executeDoubleClicked(selectedRow);
		}
		else
		{
			executeClicked(selectedRow);
		}
	}
	
	public void executeClicked(int selectedRow)
	{
		
	}
	
	public void executeDoubleClicked(int selectedRow)
	{
		
	}
	
	public void mouseEntered(MouseEvent e)
	{
		
	}
	
	public void mouseExited(MouseEvent e)
	{
		
	}
	
	public void mousePressed(MouseEvent e)
	{
		
	}
	
	public void mouseReleased(MouseEvent e)
	{
		if (!e.isPopupTrigger())
		{
			return;
		}
		
		int x = e.getX();
		int y = e.getY();
		
		int selectedRow = getSelectedIndex();
		if (selectedRow > -1)
		{
			executePopupMenu(selectedRow, x, y);
		}
		else
		{
			executePopupMenu(x, y);
		}
	}
	
	public void executePopupMenu(int selectedRow, int x, int y)
	{
		
	}
	
	public void executePopupMenu(int x, int y)
	{
		
	}
}