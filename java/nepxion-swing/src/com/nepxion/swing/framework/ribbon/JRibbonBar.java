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
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.nepxion.swing.layout.filed.FiledLayout;

public class JRibbonBar
	extends JPanel implements SwingConstants
{
	private JRibbonContainer ribbonContainer;
	
	public JRibbonBar(JRibbonContainer ribbonContainer)
	{
		this.ribbonContainer = ribbonContainer;
		
		setLayout(new FiledLayout(FiledLayout.ROW, FiledLayout.FULL, 0));
		setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
	}
	
	public void addRibbon(JRibbon ribbon)
	{
		add(ribbon);
	}
	
	public JRibbonAction createRibbonAction(String text, Icon icon, String toolTipText, Class componentClass)
	{
		JRibbonAction action = new JRibbonAction(text, icon, toolTipText);
		action.setRibbonTitle(toolTipText);
		action.setRibbonToolTipText(toolTipText);
		action.setRibbonComponentClass(componentClass);
		action.setRibbonContainer(ribbonContainer);
		
		return action;
	}
}