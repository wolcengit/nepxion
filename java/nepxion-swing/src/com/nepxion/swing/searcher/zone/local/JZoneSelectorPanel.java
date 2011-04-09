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

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.tree.TreeNode;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.selector.button.ISelectorMenuButton;
import com.nepxion.swing.selector.button.JBasicSelectorMenuButton;
import com.nepxion.swing.selector.button.JClassicSelectorMenuButton;
import com.nepxion.swing.textfield.JBasicTextField;
import com.nepxion.swing.textfield.number.JNumberTextField;

public class JZoneSelectorPanel
	extends JPanel
{
	private JNumberTextField textField;
	private ISelectorMenuButton menuButton;
	private JZoneTree tree;
	
	private int maximumLength = 12;
	
	public JZoneSelectorPanel()
	{
		this(false);
	}
	
	public JZoneSelectorPanel(boolean isClassicStyle)
	{
		this("", isClassicStyle);
	}
	
	public JZoneSelectorPanel(String value)
	{
		this(value, false);
	}
	
	public JZoneSelectorPanel(String value, boolean isClassicStyle)
	{
		this(value, 12, isClassicStyle);
	}
	
	public JZoneSelectorPanel(int maximumLength)
	{
		this(maximumLength, false);
	}
	
	public JZoneSelectorPanel(int maximumLength, boolean isClassicStyle)
	{
		this("", maximumLength, isClassicStyle);
	}
	
	public JZoneSelectorPanel(String value, int maximumLength)
	{
		this(value, maximumLength, false);
	}
	
	public JZoneSelectorPanel(String value, int maximumLength, boolean isClassicStyle)
	{
		textField = new JNumberTextField(maximumLength, 0);
		
		tree = new JZoneTree();
		
		JBasicScrollPane scrollPane = new JBasicScrollPane(tree);
		scrollPane.setPreferredSize(new Dimension(300, 300));
		
		if (isClassicStyle)
		{
			menuButton = new JClassicSelectorMenuButton(IconFactory.getSwingIcon("property.png"), SwingLocale.getString("select_province_city_code"))
			{
				public boolean confirm()
				{
					return JZoneSelectorPanel.this.confirm();
				}
				
				public boolean cancel()
				{
					return true;
				}
			};
		}
		else
		{
			menuButton = new JBasicSelectorMenuButton(IconFactory.getSwingIcon("property.png"), SwingLocale.getString("select_province_city_code"))
			{
				public boolean confirm()
				{
					return JZoneSelectorPanel.this.confirm();
				}
				
				public boolean cancel()
				{
					return true;
				}
			};
		}
		menuButton.setContentPane(scrollPane);
		
		setLayout(new BorderLayout());
		add(textField, BorderLayout.CENTER);
		add((Component) menuButton, BorderLayout.EAST);
		
		ButtonManager.updateUI(this, new Dimension(26, 26));
		
		setValue(value);
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
	
	public JBasicTextField getTextField()
	{
		return textField;
	}
	
	public ISelectorMenuButton getMenuButton()
	{
		return menuButton;
	}
	
	public JZoneTree getTree()
	{
		return tree;
	}
	
	public void setEnabled(boolean enabled)
	{
		textField.setEditable(enabled);
		((Component) menuButton).setEnabled(enabled);
	}
	
	public Object getValue()
	{
		return textField.getText();
	}
	
	public void setValue(Object value)
	{
		String text = null;
		
		if (value == null)
		{
			text = "";
		}
		
		text = value.toString().trim();
		
		if (text.length() > maximumLength)
		{
			throw new IllegalArgumentException("Invalid value");
		}
		
		if (!text.equals(""))
		{
			boolean flag = text.matches("[0-9]+");
			if (!flag)
			{
				throw new IllegalArgumentException("Invalid value");
			}
		}
		
		textField.setText(text);
	}
}