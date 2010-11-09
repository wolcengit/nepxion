package com.nepxion.swing.style.uidefaults;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.Iterator;
import java.util.Map;

import javax.swing.tree.TreeSelectionModel;

import com.nepxion.swing.tree.JBasicTree;

public class UIDefaultsTree
	extends JBasicTree
{
	private UIDefaultsTreeModel treeModel;
	
	public UIDefaultsTree()
	{
		UIDefaultsTreeNode allTreeNode = new UIDefaultsTreeNode(UIDefaultsConstants.ALL_NAME, UIDefaultsParser.parseAllMap());
		
		UIDefaultsTreeNode componentTreeNode = new UIDefaultsTreeNode(UIDefaultsConstants.COMPONENT_NAME);
		parseComponent(componentTreeNode, UIDefaultsParser.parseComponentMap());
		
		UIDefaultsTreeNode typeTreeNode = new UIDefaultsTreeNode(UIDefaultsConstants.TYPE_NAME);
		parseType(typeTreeNode, UIDefaultsParser.parseTypeMap());
		
		UIDefaultsTreeNode rootTreeNode = new UIDefaultsTreeNode(UIDefaultsConstants.ROOT_NAME);
		rootTreeNode.add(allTreeNode);
		rootTreeNode.add(componentTreeNode);
		rootTreeNode.add(typeTreeNode);
		
		treeModel = new UIDefaultsTreeModel(rootTreeNode);
		
		setModel(treeModel);
		setCellRenderer(new UIDefaultsTreeCellRenderer());
		addTreeSelectionListener(new UIDefaultsTreeSelectionListener());
		getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		putClientProperty("JTree.lineStyle", "Angled");
	}
	
	private void parseComponent(UIDefaultsTreeNode parentTreeNode, Map map)
	{
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
		{
			Object key = iterator.next();
			Object value = (Map) map.get(key);
			UIDefaultsTreeNode treeNode = new UIDefaultsTreeNode(key, value);
			parentTreeNode.add(treeNode);
		}
	}
	
	private void parseType(UIDefaultsTreeNode parentTreeNode, Map map)
	{
		for (int i = 0; i < UIDefaultsConstants.CLASS_TYPE_NAMES.length; i++)
		{
			String key = UIDefaultsConstants.CLASS_TYPE_NAMES[i];
			Object value = map.get(key);
			UIDefaultsTreeNode treeNode = new UIDefaultsTreeNode(key, value);
			parentTreeNode.add(treeNode);
		}
	}
}