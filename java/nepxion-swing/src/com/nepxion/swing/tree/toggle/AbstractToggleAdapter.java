package com.nepxion.swing.tree.toggle;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.tree.TreeNode;

import com.nepxion.swing.toggle.ITogglePanel;
import com.nepxion.swing.toggle.JThreadTogglePanel;
import com.nepxion.swing.toggle.JToggleContentPanel;

public abstract class AbstractToggleAdapter
	implements IToggleAdapter
{
	private IToggleTree toggleTree;
	
	public AbstractToggleAdapter(IToggleTree toggleTree)
	{
		this.toggleTree = toggleTree;
		this.toggleTree.setToggleAdapter(this);
	}
	
	public void invoke(TreeNode oldSelectionTreeNode, TreeNode newSelectionTreeNode)
	{
		if (newSelectionTreeNode == null)
		{
			return;
		}
		
		JToggleContentPanel toggleContentPanel = toggleTree.getToggleContentPanel();
		if (toggleContentPanel == null)
		{
			return;
		}
		
		ITogglePanel togglePanel = getTogglePanel(newSelectionTreeNode);
		if (togglePanel == null)
		{
			return;
		}
		
		if (togglePanel.getToggleName() == null)
		{
			String name = newSelectionTreeNode.toString();
			togglePanel.setToggleName(name);
		}
		
		if (togglePanel.getToggleDescription() == null)
		{
			String description = toggleTree.getTreeNavigator().getURL(newSelectionTreeNode);
			togglePanel.setToggleDescription(description);
		}
		
		toggleContentPanel.toggle(togglePanel);
		
		if (togglePanel instanceof JThreadTogglePanel)
		{
			JThreadTogglePanel threadTogglePanel = (JThreadTogglePanel) togglePanel;
			threadTogglePanel.execute();
		}
	}
	
	public IToggleTree getToggleTree()
	{
		return toggleTree;
	}
	
	public abstract ITogglePanel getTogglePanel(TreeNode treeNode);
}