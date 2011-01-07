package com.nepxion.swing.selector.radiobutton;

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
import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListModel;

import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.renderer.list.ListRadioButtonCellRenderer;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.util.data.CollectionUtil;

public class JRadioButtonPanel
	extends JBasicScrollPane
{
	private JList selectionList;
	
	private IElementNode selectedElementNode;
	private Object selectedUserObject;
	
	public JRadioButtonPanel()
	{
		this(null);
	}
	
	public JRadioButtonPanel(List allElementNodes)
	{
		if (allElementNodes == null)
		{
			selectionList = new JList();
		}
		else
		{
			if (allElementNodes instanceof Vector)
			{
				selectionList = new JList((Vector) allElementNodes);
			}
			else
			{
				selectionList = new JList(CollectionUtil.parseVector(allElementNodes));
			}
		}
		selectionList.setCellRenderer(new ListRadioButtonCellRenderer(selectionList, 22));
		getViewport().add(selectionList);
	}
	
	public JList getList()
	{
		return selectionList;
	}
	
	public void setSelection()
	{
		ListModel listModel = selectionList.getModel();
		for (int i = 0; i < listModel.getSize(); i++)
		{
			IElementNode elementNode = (IElementNode) listModel.getElementAt(i);
			if (elementNode.isSelected())
			{
				selectedElementNode = elementNode;
				selectedUserObject = elementNode.getUserObject();
				
				return;
			}
		}
	}
	
	public IElementNode getSelection()
	{
		setSelection();
		
		return selectedElementNode;
	}
	
	public Object getSelectedUserObject()
	{
		setSelection();
		
		return selectedUserObject;
	}
}