package com.nepxion.swing.renderer.tree;

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

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.tree.animation.AnimationImageObserver;

public class TreeElementCellRenderer
	extends DefaultTreeCellRenderer
{
	public static final String CLASSIC_STYLE = "theme/tree/classic/";
	public static final String PLASTIC_STYLE = "theme/tree/plastic/";
	public static final String LUNIX_STYLE = "theme/tree/lunix/";
	public static final String WINDOWS_STYLE = "theme/tree/windows/";
	public static final String NIMBUS_STYLE = "theme/tree/nimbus/";
	
	public static final String HELP_STYLE = "theme/tree/help/";
	
	private String style;
	private int rowHeight;
	
	public TreeElementCellRenderer()
	{
		this(-1);
	}
	
	public TreeElementCellRenderer(int rowHeight)
	{
		this(PLASTIC_STYLE, rowHeight);
	}
	
	public TreeElementCellRenderer(String style)
	{
		this(style, -1);
	}
	
	public TreeElementCellRenderer(String style, int rowHeight)
	{
		this.style = style;
		this.rowHeight = rowHeight;
	}
	
	public String getStyle()
	{
		return style;
	}
	
	public void setStyle(String style)
	{
		this.style = style;
	}
	
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row, boolean hasFocus)
	{
		super.getTreeCellRendererComponent(tree, value, isSelected, expanded, leaf, row, hasFocus);
		
		if (rowHeight > 0 && tree.getRowHeight() != rowHeight)
		{
			tree.setRowHeight(rowHeight);
		}
		DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) value;
		if (treeNode instanceof IElementNode)
		{
			IElementNode element = (IElementNode) treeNode;
			setUI(tree, element, treeNode, expanded);
		}
		else
		{
			adaptIcon(treeNode, expanded);
		}
		return this;
	}
	
	private void setUI(JTree tree, IElementNode element, DefaultMutableTreeNode treeNode, boolean expanded)
	{
		setText(element.getText());
		setToolTipText(element.getToolTipText());
		// tree.setToolTipText(element.getToolTipText());
		
		if (element.getIcon() != null)
		{
			if (element.getIcon() instanceof ImageIcon && element.isAnimation())
			{
				ImageIcon imageIcon = (ImageIcon) element.getIcon();
				imageIcon.setImageObserver(new AnimationImageObserver(tree, treeNode));
			}
			setIcon(element.getIcon());
		}
		else
		{
			adaptIcon(treeNode, expanded);
		}
	}
	
	private void adaptIcon(DefaultMutableTreeNode treeNode, boolean expanded)
	{
		String iconName = null;
		if (treeNode.isRoot())
		{
			iconName = style + "tree_root.png";
		}
		else if (treeNode.isLeaf())
		{
			iconName = style + "tree_leaf.png";
		}
		else
		{
			if (expanded)
			{
				iconName = style + "tree_open.png";
			}
			else
			{
				iconName = style + "tree_closed.png";
			}
		}
		setIcon(IconFactory.getSwingIcon(iconName));
	}
}