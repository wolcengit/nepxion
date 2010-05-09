package com.nepxion.demo.component.tree;

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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultMutableTreeNode;

import com.nepxion.demo.common.DemoDataFactory;
import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.common.InstallData;
import com.nepxion.swing.renderer.tree.TreeDecorationCellRenderer;
import com.nepxion.swing.tree.JBasicTree;
import com.nepxion.swing.tree.TreeManager;

public class DemoDecorationTreePanel
	extends JPanel
{
	public DemoDecorationTreePanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new DecorationTreePanel());
	}
	
	public class DecorationTreePanel
		extends JPanel
	{
		public DecorationTreePanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Decoration Tree"));
			
			DefaultMutableTreeNode root = new DefaultMutableTreeNode(DemoDataFactory.getRootInstallData());
			for (Iterator iterator = DemoDataFactory.getComponentInstallDatas().iterator(); iterator.hasNext();)
			{
				InstallData installData = (InstallData) iterator.next();
				DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(installData);
				root.add(treeNode);
				if (installData.getChildren() != null)
				{
					for (Iterator childIterator = installData.getChildren().iterator(); childIterator.hasNext();)
					{
						InstallData childInstallData = (InstallData) childIterator.next();
						DefaultMutableTreeNode childTreeNode = new DefaultMutableTreeNode(childInstallData);
						treeNode.add(childTreeNode);
					}
				}
			}
			
			JBasicTree decorationTree = new JBasicTree(root);
			decorationTree.setCellRenderer(new TreeDecorationCellRenderer(20));
			TreeManager.expandAll(decorationTree);
			
			JScrollPane decorationTreeScrollPane = new JScrollPane();
			decorationTreeScrollPane.getViewport().add(decorationTree);
			add(decorationTreeScrollPane);			
		}
	}
}