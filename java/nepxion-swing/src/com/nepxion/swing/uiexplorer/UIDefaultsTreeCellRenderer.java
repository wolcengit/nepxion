package com.nepxion.swing.uiexplorer;

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

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import com.nepxion.swing.icon.IconFactory;

public class UIDefaultsTreeCellRenderer
	extends DefaultTreeCellRenderer
{
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row, boolean hasFocus)
	{
		super.getTreeCellRendererComponent(tree, value, isSelected, expanded, leaf, row, hasFocus);
		
		UIDefaultsTreeNode treeNode = (UIDefaultsTreeNode) value;
		String treeNodeName = treeNode.getKey().toString();
		String iconName = null;
		if (treeNodeName.equals(UIDefaultsConstants.ROOT_NAME))
		{
			iconName = "theme/uidefaults/tree_root.png";
		}
		else if (treeNodeName.equals(UIDefaultsConstants.ALL_NAME))
		{
			if (expanded)
			{
				iconName = "theme/uidefaults/catalog_all_tree_open.png";
			}
			else
			{
				iconName = "theme/uidefaults/catalog_all_tree_closed.png";
			}
		}
		else if (treeNodeName.equals(UIDefaultsConstants.COMPONENT_NAME))
		{
			if (expanded)
			{
				iconName = "theme/uidefaults/catalog_component_tree_open.png";
			}
			else
			{
				iconName = "theme/uidefaults/catalog_component_tree_closed.png";
			}
		}
		else if (treeNodeName.equals(UIDefaultsConstants.TYPE_NAME))
		{
			if (expanded)
			{
				iconName = "theme/uidefaults/catalog_type_tree_open.png";
			}
			else
			{
				iconName = "theme/uidefaults/catalog_type_tree_closed.png";
			}
		}
		else
		{
			String parentTreeNodeName = treeNode.getParent().toString();
			if (parentTreeNodeName.equals(UIDefaultsConstants.ALL_NAME))
			{
				iconName = "theme/uidefaults/catalog_all_tree_leaf.png";
			}
			else if (parentTreeNodeName.equals(UIDefaultsConstants.COMPONENT_NAME))
			{
				iconName = "theme/uidefaults/catalog_component_tree_leaf.png";
			}
			else if (parentTreeNodeName.equals(UIDefaultsConstants.TYPE_NAME))
			{
				iconName = "theme/uidefaults/catalog_type_tree_leaf.png";
			}
		}
		
		setIcon(IconFactory.getSwingIcon(iconName));
		tree.setRowHeight(20);
		
		return this;
	}
}