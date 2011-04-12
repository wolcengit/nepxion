package com.nepxion.swing.renderer.list;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class CheckBoxCellRendererPanel
	extends JPanel
{
	private JCheckBox checkBox;
	private CellRendererLabel label;
	
	public CheckBoxCellRendererPanel()
	{
		checkBox = new JCheckBox();
		label = new CellRendererLabel();
		
		checkBox.setBackground(UIManager.getColor("Tree.textBackground"));
		label.setForeground(UIManager.getColor("Tree.textForeground"));
		
		add(checkBox);
		add(label);
		
		setBackground(Color.white);
	}
	
	public JCheckBox getCheckBox()
	{
		return checkBox;
	}
	
	public CellRendererLabel getLabel()
	{
		return label;
	}
	
	public Dimension getPreferredSize()
	{
		Dimension checkBoxDimension = checkBox.getPreferredSize();
		Dimension labelDimension = label.getPreferredSize();
		
		return new Dimension(checkBoxDimension.width + labelDimension.width, (checkBoxDimension.height < labelDimension.height ? labelDimension.height : checkBoxDimension.height));
	}
	
	public void setBackground(Color color)
	{
		if (color instanceof ColorUIResource)
		{
			color = null;
		}
		
		super.setBackground(color);
	}
	
	public void doLayout()
	{
		Dimension checkBoxDimension = checkBox.getPreferredSize();
		Dimension labelDimension = label.getPreferredSize();
		int checkBoxHeight = 0;
		int labelHeight = 0;
		if (checkBoxDimension.height < labelDimension.height)
		{
			checkBoxHeight = (labelDimension.height - checkBoxDimension.height) / 2;
		}
		else
		{
			labelHeight = (checkBoxDimension.height - labelDimension.height) / 2;
		}
		checkBox.setBounds(2, checkBoxHeight, checkBoxDimension.width, checkBoxDimension.height);
		label.setBounds(checkBoxDimension.width + 4, labelHeight, labelDimension.width, labelDimension.height);
	}
}