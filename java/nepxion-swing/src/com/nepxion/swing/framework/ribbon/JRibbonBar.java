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

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.nepxion.swing.gradient.JGradientPainter;
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
		
		ribbonView = new JPanel()
		{
			public void paintComponent(Graphics g)
			{				
				Graphics2D g2d = (Graphics2D) g;

				JGradientPainter.fastFill(g2d, new Rectangle(0, 0, getWidth(), 1), new Color(231, 239, 248), new Color(231, 239, 248), true);
				JGradientPainter.fastFill(g2d, new Rectangle(0, 1, getWidth(), 16), new Color(222, 235, 247), new Color(210, 224, 241), true);
				JGradientPainter.fastFill(g2d, new Rectangle(0, 17, getWidth(), getHeight() - 18), new Color(199, 216, 237), new Color(231, 242, 255), true);
				JGradientPainter.fastFill(g2d, new Rectangle(0, getHeight() - 1, getWidth(), 1), new Color(192, 249, 255), new Color(192, 249, 255), true);
				
				JGradientPainter.fastFill(g2d, new Rectangle(0, 1, 1, 16), new Color(231, 239, 248), new Color(214, 235, 247), true);
				JGradientPainter.fastFill(g2d, new Rectangle(0, 17, 1, getHeight() - 1), new Color(204, 232, 245), new Color(192, 249, 255), true);
				
				JGradientPainter.fastFill(g2d, new Rectangle(getWidth() - 1, 1, 1, 16), new Color(231, 239, 248), new Color(214, 235, 247), true);
				JGradientPainter.fastFill(g2d, new Rectangle(getWidth() - 1, 17, 1, getHeight() - 1), new Color(204, 232, 245), new Color(192, 249, 255), true);

			}
		};
		ribbonView.setLayout(new FiledLayout(FiledLayout.ROW, FiledLayout.FULL, 0));
		// ribbonView.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
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