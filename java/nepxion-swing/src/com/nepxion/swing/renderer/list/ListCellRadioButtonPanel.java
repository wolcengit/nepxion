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

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class ListCellRadioButtonPanel
	extends JPanel
{
	private JRadioButton radioButton;
	private ListCellLabel label;
	
	public ListCellRadioButtonPanel()
	{
		radioButton = new JRadioButton();
		label = new ListCellLabel();
		
		radioButton.setBackground(UIManager.getColor("Tree.textBackground"));
		label.setForeground(UIManager.getColor("Tree.textForeground"));
		
		add(radioButton);
		add(label);
	}
	
	public JRadioButton getRadioButton()
	{
		return radioButton;
	}
	
	public ListCellLabel getLabel()
	{
		return label;
	}
	
	public Dimension getPreferredSize()
	{
		Dimension radioDimension = radioButton.getPreferredSize();
		Dimension lableDimension = label.getPreferredSize();
		
		return new Dimension(radioDimension.width + lableDimension.width, (radioDimension.height < lableDimension.height ? lableDimension.height : radioDimension.height));
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
		Dimension radioDimension = radioButton.getPreferredSize();
		Dimension lableDimension = label.getPreferredSize();
		int radioHeight = 0;
		int labelHeight = 0;
		if (radioDimension.height < lableDimension.height)
		{
			radioHeight = (lableDimension.height - radioDimension.height) / 2;
		}
		else
		{
			labelHeight = (radioDimension.height - lableDimension.height) / 2;
		}
		radioButton.setBounds(2, radioHeight, radioDimension.width, radioDimension.height);
		label.setBounds(radioDimension.width + 4, labelHeight, lableDimension.width, lableDimension.height);
	}
}