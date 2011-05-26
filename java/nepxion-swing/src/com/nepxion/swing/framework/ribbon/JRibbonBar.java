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
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.scrollpane.JAutoRollScrollPane;

public class JRibbonBar
	extends JAutoRollScrollPane	implements SwingConstants
{
	/**
	 * The ribbon container;
	 */
	private JRibbonContainer ribbonContainer;
	
	/**
	 * The ribbon view.
	 */
	private JPanel ribbonView;
	
	/**
	 * Constructs with the specified initial ribbon container.
	 * @param ribbonContainer the instance of JRibbonContainer
	 */
	public JRibbonBar(JRibbonContainer ribbonContainer)
	{
		this.ribbonContainer = ribbonContainer;
		
		ribbonView = new JPanel();
		ribbonView.setLayout(new FiledLayout(FiledLayout.ROW, FiledLayout.FULL, 0));
		ribbonView.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
		setViewportView(ribbonView);
	}
	
	/**
	 * Gets the ribbon list.
	 * @return the instance of List
	 */
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
		
	/**
	 * Gets the ribbon container.
	 * @return the instance of JRibbonContainer
	 */
	public JRibbonContainer getRibbonContainer()
	{
		return ribbonContainer;
	}
	
	/**
	 * Gets the ribbon view.
	 * @return the instance of JPanel
	 */
	public JPanel getRibbonView()
	{
		return ribbonView;
	}
	
	/**
	 * Toggles the facade by a show type and show value.
	 * The show type values are "text" and "icon".
	 * The show value values are SHOW_SMALL, SHOW_LARGE and SHOW_NO. (See JAction definition).
	 * For example, if the showType is "icon" and the showValue is SHOW_LARGE, the component will display the icon as a large style.
	 * @param showType the show type
	 * @param showValue the show value
	 */
	public void toggleFacade(String showType, int showValue)
	{
		List ribbons = getRibbons();
		for (Iterator iterator = ribbons.iterator(); iterator.hasNext();)
		{
			JRibbon ribbon = (JRibbon) iterator.next();
			
			ribbon.toggleFacade(showType, showValue);
		}
	}
}