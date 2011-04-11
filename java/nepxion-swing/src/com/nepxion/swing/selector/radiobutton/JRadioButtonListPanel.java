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

import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.ListModel;

import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.renderer.list.ListRadioButtonCellRenderer;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.util.data.CollectionUtil;

public class JRadioButtonListPanel
	extends JBasicScrollPane
{
	private JList selectionList;
	
	private IElementNode selectedElementNode;
	private Object selectedUserObject;
	
	public JRadioButtonListPanel()
	{
		this(null);
	}
	
	public JRadioButtonListPanel(List allElementNodes)
	{
		if (allElementNodes == null)
		{
			selectionList = new JList();
		}
		else
		{
			selectionList = new JList(CollectionUtil.parseVector(allElementNodes));
		}
		selectionList.setCellRenderer(new ListRadioButtonCellRenderer(selectionList, 22));
		getViewport().add(selectionList);
	}
	
	private void adapterSelection()
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
	
	public JList getList()
	{
		return selectionList;
	}
	
	public List getAllElementNodes()
	{
		List allElementNodes = new ArrayList();
		ListModel listModel = selectionList.getModel();
		for (int i = 0; i < listModel.getSize(); i++)
		{
			Object elementNode = listModel.getElementAt(i);
			allElementNodes.add(elementNode);
		}
		
		return allElementNodes;
	}
	
	public void setAllElementNodes(List allElementNodes)
	{
		selectionList.setListData(CollectionUtil.parseVector(allElementNodes));	
	}
	
	public IElementNode getSelectedElementNode()
	{
		adapterSelection();
		
		return selectedElementNode;
	}
	
	public Object getSelectedUserObject()
	{
		adapterSelection();
		
		return selectedUserObject;
	}
	
	public void updateSelection()
	{
		selectionList.repaint();
	}
}