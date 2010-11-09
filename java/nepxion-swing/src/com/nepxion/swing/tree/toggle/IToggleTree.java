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

import com.nepxion.swing.toggle.JToggleContentPanel;
import com.nepxion.swing.tree.ITree;
import com.nepxion.swing.tree.TreeNavigator;

public interface IToggleTree
	extends ITree
{
	public static final int INVOKE_MODE_SELECTED = 0;
	public static final int INVOKE_MODE_CLICKED = 1;
	public static final int INVOKE_MODE_DOUBLE_CLICKED = 2;
	
	public int getInvokeMode();
	
	public void setInvokeMode(int invokeMode);
	
	public TreeNavigator getTreeNavigator();
	
	public void setTreeNavigator(TreeNavigator treeNavigator);
	
	public JToggleContentPanel getToggleContentPanel();
	
	public void setToggleContentPanel(JToggleContentPanel toggleContentPanel);
	
	public IToggleAdapter getToggleAdapter();
	
	public void setToggleAdapter(IToggleAdapter toggleAdapter);
	
	public void executeSelection(TreeNode treeNode);
	
	public void executeClicked(TreeNode treeNode);
	
	public void executeDoubleClicked(TreeNode treeNode);
}