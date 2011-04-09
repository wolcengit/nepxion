package com.nepxion.swing.searcher.zone.local;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Dimension;

import javax.swing.tree.TreeNode;

import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.selector.button.JBasicSelectorMenuButton;
import com.nepxion.swing.textfield.JBasicTextField;

public class JZoneSelectorButton
	extends JBasicSelectorMenuButton
{
	private JBasicTextField textField;
	private JZoneTree tree;
	
	public JZoneSelectorButton(JBasicTextField textField)
	{
		super(IconFactory.getSwingIcon("property.png"), SwingLocale.getString("select_province_city_code"));
		
		this.textField = textField;
		
		tree = new JZoneTree()
		{
			/*public void executeDoubleClicked(TreeNode treeNode)
			{
				if (treeNode.isLeaf())
				{
					doConfirm();
				}
			}*/
		};
		
		JBasicScrollPane scrollPane = new JBasicScrollPane(tree);
		scrollPane.setPreferredSize(new Dimension(300, 300));
		
		setContentPane(scrollPane);
	}
	
	public boolean confirm()
	{
		TreeNode treeNode = tree.getSelectionTreeNode();
		if (treeNode == null || !treeNode.isLeaf())
		{
			JBasicOptionPane.showMessageDialog(HandleManager.getFrame(this), SwingLocale.getString("select_city_node"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);		
			
			return false;
		}
		
		IElementNode cityTreeNode = (IElementNode) treeNode;
		IElementNode provinceTreeNode = (IElementNode) treeNode.getParent();
		String text = provinceTreeNode.getName() + cityTreeNode.getName();
		textField.setText(text);
		
		return true;
	}
	
	public boolean cancel()
	{
		return true;
	}
}