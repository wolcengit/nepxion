package com.nepxion.swing.framework.ribbon;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.scrollpane.JAutoRollScrollPane;

public class JRibbonBar
	extends JAutoRollScrollPane	implements SwingConstants
{
	private JRibbonContainer ribbonContainer;
	private JPanel panel;
	
	public JRibbonBar(JRibbonContainer ribbonContainer)
	{
		this.ribbonContainer = ribbonContainer;
		
		panel = new JPanel();
		panel.setLayout(new FiledLayout(FiledLayout.ROW, FiledLayout.FULL, 0));
		panel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
		setViewportView(panel);
	}
	
	public JRibbonContainer getRibbonContainer()
	{
		return ribbonContainer;
	}
	
	public JPanel getRibbonView()
	{
		return panel;
	}
}