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

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.locale.SwingLocale;

public class MultiRadioButtonCellRendererPanel
	extends JPanel
{
	private JRadioButton ignoredRadioButton;
	private JRadioButton containedRadioButton;
	private JRadioButton notContainedRadioButton;
	private CellRendererLabel label;
	
	public MultiRadioButtonCellRendererPanel()
	{
		this(SwingLocale.getString("select_ignored"), SwingLocale.getString("select_contained"), SwingLocale.getString("select_not_contained"));
	}
	
	public MultiRadioButtonCellRendererPanel(String ignoredText, String containedText, String notContainedText)
	{
		ignoredRadioButton = new JRadioButton(ignoredText);
		containedRadioButton = new JRadioButton(containedText);
		notContainedRadioButton = new JRadioButton(notContainedText);
		label = new CellRendererLabel();
		
		ignoredRadioButton.setBackground(UIManager.getColor("Tree.textBackground"));
		containedRadioButton.setBackground(UIManager.getColor("Tree.textBackground"));
		notContainedRadioButton.setBackground(UIManager.getColor("Tree.textBackground"));
		label.setForeground(UIManager.getColor("Tree.textForeground"));
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(ignoredRadioButton);
		buttonGroup.add(containedRadioButton);
		buttonGroup.add(notContainedRadioButton);
		
		add(ignoredRadioButton);
		add(containedRadioButton);
		add(notContainedRadioButton);
		add(label);
		
		setBackground(Color.white);
	}
	
	public JRadioButton getIgnoredRadioButton()
	{
		return ignoredRadioButton;
	}
	
	public JRadioButton getContainedRadioButton()
	{
		return containedRadioButton;
	}
	
	public JRadioButton getNotContainedRadioButton()
	{
		return notContainedRadioButton;
	}
	
	public CellRendererLabel getLabel()
	{
		return label;
	}
	
	public Dimension getPreferredSize()
	{
		Dimension ignoredRadioDimension = ignoredRadioButton.getPreferredSize();
		Dimension containedRadioDimension = containedRadioButton.getPreferredSize();
		Dimension notContainedRadioDimension = notContainedRadioButton.getPreferredSize();
		Dimension lableDimension = label.getPreferredSize();
		
		return new Dimension(ignoredRadioDimension.width + containedRadioDimension.width + notContainedRadioDimension.width + lableDimension.width, (ignoredRadioDimension.height < lableDimension.height ? lableDimension.height : ignoredRadioDimension.height));
	}
	
	public int getSelectedRadioIndex(int x)
	{
		if (x >= ignoredRadioButton.getBounds().x && x <= ignoredRadioButton.getBounds().x + ignoredRadioButton.getBounds().width)
		{
			return IElementNode.SELECTION_INDEX_IGNORED;
		}
		else if (x >= containedRadioButton.getBounds().x && x <= containedRadioButton.getBounds().x + containedRadioButton.getBounds().width)
		{
			return IElementNode.SELECTION_INDEX_CONTAINED;
		}
		else if (x >= notContainedRadioButton.getBounds().x && x <= notContainedRadioButton.getBounds().x + notContainedRadioButton.getBounds().width)
		{
			return IElementNode.SELECTION_INDEX_NOT_CONTAINED;
		}
		
		return -1;
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
		Dimension ignoredRadioDimension = ignoredRadioButton.getPreferredSize();
		Dimension containedRadioDimension = containedRadioButton.getPreferredSize();
		Dimension notContainedRadioDimension = notContainedRadioButton.getPreferredSize();
		Dimension lableDimension = label.getPreferredSize();
		int radioHeight = 0;
		int labelHeight = 0;
		if (ignoredRadioDimension.height < lableDimension.height)
		{
			radioHeight = (lableDimension.height - ignoredRadioDimension.height) / 2;
		}
		else
		{
			labelHeight = (ignoredRadioDimension.height - lableDimension.height) / 2;
		}
		ignoredRadioButton.setBounds(2, radioHeight, ignoredRadioDimension.width, ignoredRadioDimension.height);
		containedRadioButton.setBounds(ignoredRadioDimension.width + 2, radioHeight, containedRadioDimension.width, containedRadioDimension.height);
		notContainedRadioButton.setBounds(ignoredRadioDimension.width + containedRadioDimension.width + 2, radioHeight, notContainedRadioDimension.width, notContainedRadioDimension.height);
		label.setBounds(ignoredRadioDimension.width + containedRadioDimension.width + notContainedRadioDimension.width + 12, labelHeight, lableDimension.width, lableDimension.height);
	}
}