package com.nepxion.cots.twaver.element;

/**
 * <p>Title: Nepxion Cots For TWaver</p>
 * <p>Description: Nepxion Cots Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * <p>Announcement: It depends on the commercial software of TWaver, the repository only references the trial version.</p>
 * <p>If you want to use Nepxion Cots, please contact with Serva Corporation to buy the genuine version.</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import twaver.DataBoxSelectionModel;
import twaver.Element;
import twaver.TDataBox;

public class TElementManager
{
	// 根据名称获取Node对象
	public static TNode getNode(TDataBox dataBox, String name)
	{
		for (Iterator iterator = dataBox.getAllElements().iterator(); iterator.hasNext();)
		{
			Element element = (Element) iterator.next();
			
			if (element instanceof TNode)
			{
				if (element.getName().equals(name))
				{
					return (TNode) element;
				}
			}
		}
		
		return null;
	}
	
	// 根据名称获取Group对象
	public static TGroup getGroup(TDataBox dataBox, String name)
	{
		for (Iterator iterator = dataBox.getAllElements().iterator(); iterator.hasNext();)
		{
			Element element = (Element) iterator.next();
			
			if (element instanceof TGroup)
			{
				if (element.getName().equals(name))
				{
					return (TGroup) element;
				}
			}
		}
		
		return null;
	}
	
	// 根据名称获取Link对象
	public static TLink getLink(TDataBox dataBox, String name)
	{
		for (Iterator iterator = dataBox.getAllElements().iterator(); iterator.hasNext();)
		{
			Element element = (Element) iterator.next();
			
			if (element instanceof TLink)
			{
				if (element.getName().equals(name))
				{
					return (TLink) element;
				}
			}
		}
		
		return null;
	}
	
	// 获得选中的一个Element
	public static TElement getSelectedElement(TDataBox dataBox)
	{
		DataBoxSelectionModel selectionModel = dataBox.getSelectionModel();
		if (selectionModel == null || selectionModel.getAllSelectedElement().size() != 1 || !(selectionModel.lastElement() instanceof TElement))
		{
			return null;
		}
		
		return (TElement) selectionModel.lastElement();
	}
	
	// 获得选中的一个或多个的Node
	public static List getSelectedNodes(TDataBox dataBox)
	{
		DataBoxSelectionModel selectionModel = dataBox.getSelectionModel();
		if (selectionModel == null || selectionModel.getAllSelectedElement().isEmpty())
		{
			return null;
		}
		
		List selectedNodes = new ArrayList();
		for (Iterator iterator = selectionModel.getAllSelectedElement().iterator(); iterator.hasNext();)
		{
			Object object = iterator.next();
			
			if (object instanceof TNode)
			{
				selectedNodes.add(object);
			}
		}
		
		return selectedNodes;
	}
	
	// 获得选中的一个Node
	public static TNode getSelectedNode(TDataBox dataBox)
	{
		DataBoxSelectionModel selectionModel = dataBox.getSelectionModel();
		if (selectionModel == null || selectionModel.getAllSelectedElement().size() != 1 || !(selectionModel.lastElement() instanceof TNode))
		{
			return null;
		}
		
		return (TNode) selectionModel.lastElement();
	}
	
	// 获得选中的一个或多个的Group
	public static List getSelectedGroups(TDataBox dataBox)
	{
		DataBoxSelectionModel selectionModel = dataBox.getSelectionModel();
		if (selectionModel == null || selectionModel.getAllSelectedElement().isEmpty())
		{
			return null;
		}
		
		List selectedGroups = new ArrayList();
		for (Iterator iterator = selectionModel.getAllSelectedElement().iterator(); iterator.hasNext();)
		{
			Object object = iterator.next();
			
			if (object instanceof TGroup)
			{
				selectedGroups.add(object);
			}
		}
		
		return selectedGroups;
	}
	
	// 获得选中的一个Group
	public static TGroup getSelectedGroup(TDataBox dataBox)
	{
		DataBoxSelectionModel selectionModel = dataBox.getSelectionModel();
		if (selectionModel == null || selectionModel.getAllSelectedElement().size() != 1 || !(selectionModel.lastElement() instanceof TGroup))
		{
			return null;
		}
		
		return (TGroup) selectionModel.lastElement();
	}
	
	// 获得选中的一个或多个的Link
	public static List getSelectedLinks(TDataBox dataBox)
	{
		DataBoxSelectionModel selectionModel = dataBox.getSelectionModel();
		if (selectionModel == null || selectionModel.getAllSelectedElement().isEmpty())
		{
			return null;
		}
		
		List selectedLinks = new ArrayList();
		for (Iterator iterator = selectionModel.getAllSelectedElement().iterator(); iterator.hasNext();)
		{
			Object object = iterator.next();
			
			if (object instanceof TNode)
			{
				selectedLinks.add(object);
			}
		}
		
		return selectedLinks;
	}
	
	// 获得选中的一个Link
	public static TLink getSelectedLink(TDataBox dataBox)
	{
		DataBoxSelectionModel selectionModel = dataBox.getSelectionModel();
		if (selectionModel == null || selectionModel.getAllSelectedElement().size() != 1 || !(selectionModel.lastElement() instanceof TLink))
		{
			return null;
		}
		
		return (TLink) selectionModel.lastElement();
	}
}