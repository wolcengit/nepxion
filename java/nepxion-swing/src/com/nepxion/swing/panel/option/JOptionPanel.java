package com.nepxion.swing.panel.option;

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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JOptionPanel
	extends JPanel
{
	private JLabel label;
	
	public JOptionPanel()
	{
		label = new JLabel();
		
		JPanel iconPanel = new JPanel();
		iconPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
		iconPanel.setLayout(new BorderLayout());
		iconPanel.add(label, BorderLayout.NORTH);
		iconPanel.add(Box.createVerticalGlue(), BorderLayout.CENTER);
		
		setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
		setLayout(new BorderLayout());
		add(iconPanel, BorderLayout.WEST);		
	}
	
	public void setIcon(Icon icon)
	{
		label.setIcon(icon);
	}
	
	public void setComponent(Component component)
	{
		add(component, BorderLayout.CENTER);
	}
}