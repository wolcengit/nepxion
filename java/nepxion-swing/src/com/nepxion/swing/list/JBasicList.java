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
import java.util.List;
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JBasicList
	extends JList implements ListSelectionListener, MouseListener
{
	private int selectedRow = -1;
	
	public JBasicList()
	{
		super();
		
		initComponents();
	}
	
	public JBasicList(ListModel dataModel)
	{
		super(dataModel);
		
		initComponents();
	}
	
	public JBasicList(Object[] listData)
	{
		super(listData);
		
		initComponents();
	}
	
	public JBasicList(Vector listData)
	{
		super(listData);
		
		initComponents();
	}
	
	private void initComponents()
	{
		ListManager.setPreferenceStyle(this);
		
		addListSelectionListener(this);
	}
	
	public List getListData()
	{
		Vector listData = new Vector();
		
		ListModel listModel = getModel();
		for (int i = 0; i < listModel.getSize(); i++)
		{
			Object element = listModel.getElementAt(i);
			listData.add(element);
		}
		
		return listData;
	}
	
	public void valueChanged(ListSelectionEvent e)
	{		
		boolean isAdjusting = e.getValueIsAdjusting();
		if (isAdjusting)
		{
			if (getSelectedIndex() == selectedRow)
			{
				return;
			}
			
			selectedRow = getSelectedIndex();
			
			executeSelection(selectedRow);
		}
	}
	
	public void executeSelection(int selectedRow)
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