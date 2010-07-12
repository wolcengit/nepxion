package com.nepxion.demo.component.button;

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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import org.dom4j.DocumentException;

import com.nepxion.swing.border.ComplexEtchedBorder;
import com.nepxion.swing.border.ComplexSide;
import com.nepxion.swing.border.ComplexTitleBorder;
import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicSelectorMenuButton;
import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.renderer.tree.TreeElementCellRenderer;
import com.nepxion.swing.textfield.JBasicTextField;
import com.nepxion.swing.textfield.number.JNumberTextField;
import com.nepxion.swing.tree.JBasicTree;
import com.nepxion.swing.tree.xml.Dom4JTreeParser;
import com.nepxion.util.io.FileUtil;

public class DemoSelectorMenuButtonPanel
	extends JPanel
{
	public DemoSelectorMenuButtonPanel()
	{
		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		add(new SelectorMenuButtonPanel());
	}
	
	public class SelectorMenuButtonPanel
		extends JPanel
	{
		public SelectorMenuButtonPanel()
		{
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setBorder(new ComplexTitleBorder(new ComplexEtchedBorder(ComplexEtchedBorder.LOWERED, ComplexSide.NORTH), "Flat ButtonUI"));
			
			JNumberTextField textField = new JNumberTextField(12, 0);
			SelectorMenuButton selectorButton = new SelectorMenuButton(textField);
			
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			panel.add(textField);
			panel.add(selectorButton);
			ButtonManager.updateUI(panel, new Dimension(26, 22));			
			add(panel);
		}
	}
	
	public class SelectorMenuButton
		extends JBasicSelectorMenuButton
	{
		private JBasicTextField textField;
		private JBasicTree tree;
		
		public SelectorMenuButton(JBasicTextField textField)
		{
			super(IconFactory.getSwingIcon("property.png"), "Province & City Code Selector");
			
			this.textField = textField;
			
			tree = new JBasicTree()
			{
				public void executeDoubleClicked(TreeNode treeNode)
				{
					if (treeNode.isLeaf())
					{
						doConfirm();
					}
				}
			};
						
			String text = FileUtil.readString("zone.properties", true);
			
			ElementNode root = null;		
			try
			{			
				Dom4JTreeParser parser = new Dom4JTreeParser();
				parser.setNameTag("code");
				parser.setTextTag("name");
				root = parser.parse(text);
			}
			catch (DocumentException e)
			{
				e.printStackTrace();
			}
			
			DefaultTreeModel treeModel = new DefaultTreeModel(root);
			tree.setModel(treeModel);			
			tree.setCellRenderer(new TreeElementCellRenderer(TreeElementCellRenderer.NIMBUS_STYLE, 20));
			tree.setSelectionMode(JBasicTree.SINGLE_TREE_SELECTION);			
			// tree.expandAll();
			
			JScrollPane scrollPane = new JScrollPane(tree);
			scrollPane.setPreferredSize(new Dimension(300, 300));
			
			setContentPane(scrollPane);
		}
		
		public boolean confirm()
		{
			TreeNode treeNode = tree.getSelectionTreeNode();
			if (treeNode == null || !treeNode.isLeaf())
			{
				JBasicOptionPane.showMessageDialog(HandleManager.getFrame(this), "Please select city code", "Message", JBasicOptionPane.WARNING_MESSAGE);
				return false;
			}
			
			ElementNode cityTreeNode = (ElementNode) treeNode;
			ElementNode provinceTreeNode = (ElementNode) treeNode.getParent();
			String text = provinceTreeNode.getName() + cityTreeNode.getName();
			textField.setText(text);
			
			return true;
		}
		
		public boolean cancel()
		{
			return true;
		}
	}
}