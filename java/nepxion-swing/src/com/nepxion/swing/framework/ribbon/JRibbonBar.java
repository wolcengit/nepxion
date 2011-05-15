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

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.scrollpane.JAutoRollScrollPane;

public class JRibbonBar
	extends JAutoRollScrollPane	implements SwingConstants
{
	private JRibbonContainer ribbonContainer;
	private JPanel ribbonView;
	
	public JRibbonBar(JRibbonContainer ribbonContainer)
	{
		this.ribbonContainer = ribbonContainer;
		
		ribbonView = new JPanel();
		ribbonView.setLayout(new FiledLayout(FiledLayout.ROW, FiledLayout.FULL, 0));
		ribbonView.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
		setViewportView(ribbonView);
	}
	
	public List getRibbons()
	{
		List ribbons = new ArrayList();
		
		for (int i = 0; i < ribbonView.getComponentCount(); i++)
		{
			Component component = ribbonView.getComponent(i);
			
			if(component instanceof JRibbon)
			{
				ribbons.add(component);
			}	
		}
		
		return ribbons;
	}
	
	public JRibbonContainer getRibbonContainer()
	{
		return ribbonContainer;
	}
	
	public JPanel getRibbonView()
	{
		return ribbonView;
	}
}