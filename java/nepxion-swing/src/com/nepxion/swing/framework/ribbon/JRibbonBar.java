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
	
	public JRibbonAction createRibbonAction(String text, Icon icon, String toolTipText, Class componentClass)
	{		
		return RibbonManager.createRibbonAction(text, icon, toolTipText, ribbonContainer, componentClass);
	}
	
	public JRibbonAction createRibbonAction(String name, String text, Icon icon, String toolTipText, Class componentClass)
	{		
		return RibbonManager.createRibbonAction(name, text, icon, toolTipText, ribbonContainer, componentClass);
	}
}