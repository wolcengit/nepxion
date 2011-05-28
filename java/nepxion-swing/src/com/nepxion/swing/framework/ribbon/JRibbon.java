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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.action.JAction;
import com.nepxion.swing.gradient.JGradientPainter;
import com.nepxion.swing.toolbar.JBasicToolBar;

public class JRibbon
	extends JPanel
{
	/**
	 * The instance of JBasicToolBar.
	 */
	private JBasicToolBar toolBar;
	
	/**
	 * The instance of JLabel.
	 */
	private JLabel label;
	
	/**
	 * Constructs with the default.
	 */
	public JRibbon()
	{
		this(null, null);
	}
	
	/**
	 * Constructs with the specified initial title and tooltip text.
	 * @param title the title string
	 * @param toolTipText the tooltip text string
	 */
	public JRibbon(String title, String toolTipText)
	{
		this(title, null, toolTipText);
	}
	
	/**
	 * Constructs with the specified initial title, icon and tooltip text.
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text string
	 */
	public JRibbon(String title, Icon icon, String toolTipText)
	{
		toolBar = new JBasicToolBar()
		{
			public void paintComponent(Graphics g)
			{
				Graphics2D g2d = (Graphics2D) g;
				
				// JGradientPainter.fastFill(g2d, new Rectangle(0, 0, getWidth(), 14), new Color(222, 232, 245), new Color(210, 224, 241), true);
				// JGradientPainter.fastFill(g2d, new Rectangle(0, 14, getWidth(), getHeight() - 14), new Color(199, 216, 237), new Color(216, 232, 245), true);
				
				JGradientPainter.fastFill(g2d, new Rectangle(0, 0, getWidth(), 14), new Color(222, 235, 247), new Color(210, 224, 241), true);
				JGradientPainter.fastFill(g2d, new Rectangle(0, 14, getWidth(), getHeight() - 14), new Color(199, 216, 237), new Color(231, 242, 255), true);
				
				super.paintComponent(g);
			}
		};
		
		label = new JLabel(title, icon, JLabel.CENTER)
		{
			public void paintComponent(Graphics g)
			{
				Graphics2D g2d = (Graphics2D) g;
				
				Rectangle rectangle = new Rectangle(0, 0, getWidth(), getHeight());
				JGradientPainter.fastFill(g2d, rectangle, new Color(194, 216, 241), new Color(192, 216, 240), true);
				
				// Draw Corner
				g.setColor(new Color(102, 142, 175));
				g.drawLine(getWidth() - 12, getHeight() - 12, getWidth() - 7, getHeight() - 12);
				g.drawLine(getWidth() - 12, getHeight() - 12, getWidth() - 12, getHeight() - 7);
				
				g.drawLine(getWidth() - 9, getHeight() - 9, getWidth() - 9, getHeight() - 9);
				g.drawLine(getWidth() - 8, getHeight() - 8, getWidth() - 6, getHeight() - 8);
				g.drawLine(getWidth() - 8, getHeight() - 7, getWidth() - 6, getHeight() - 7);
				g.drawLine(getWidth() - 9, getHeight() - 6, getWidth() - 6, getHeight() - 6);
				g.drawLine(getWidth() - 6, getHeight() - 9, getWidth() - 6, getHeight() - 6);
				
				g.setColor(Color.white);
				g.drawLine(getWidth() - 11, getHeight() - 11, getWidth() - 7, getHeight() - 11);
				g.drawLine(getWidth() - 11, getHeight() - 11, getWidth() - 11, getHeight() - 7);
				
				g.drawLine(getWidth() - 8, getHeight() - 9, getWidth() - 8, getHeight() - 9);
				g.drawLine(getWidth() - 8, getHeight() - 5, getWidth() - 6, getHeight() - 5);
				g.drawLine(getWidth() - 5, getHeight() - 9, getWidth() - 5, getHeight() - 5);
				
				super.paintComponent(g);
			}
		};
		label.setToolTipText(toolTipText);
		label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 23));
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1), BorderFactory.createEtchedBorder()));
		
		add(toolBar, BorderLayout.CENTER);
		add(label, BorderLayout.SOUTH);
	}
	
	/**
	 * Gets the tool bar.
	 * @return the instance of JBasicToolBar
	 */
	public JBasicToolBar getToolBar()
	{
		return toolBar;
	}
	
	/**
	 * Gets the label.
	 * @return the instance of JLabel
	 */
	public JLabel getLabel()
	{
		return label;
	}
	
	/**
	 * Gets the title.
	 * @return the title string
	 */
	public String getTitle()
	{
		return label.getText();
	}
	
	/**
	 * Sets the title.
	 * @param title the title string
	 */
	public void setTitle(String title)
	{
		label.setText(title);
	}
	
	/**
	 * Gets the icon.
	 * @return the instance of Icon
	 */
	public Icon getIcon()
	{
		return label.getIcon();
	}
	
	/**
	 * Sets the icon.
	 * @param icon the instance of Icon
	 */
	public void setIcon(Icon icon)
	{
		label.setIcon(icon);
	}
	
	/**
	 * Gets the tooltip text.
	 * @return the tooltip text string
	 */
	public String getToolTipText()
	{
		return label.getToolTipText();
	}
	
	/**
	 * Sets the tooltip text.
	 * @param toolTipText the tooltip text string
	 */
	public void setToolTipText(String toolTipText)
	{
		label.setToolTipText(toolTipText);
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
		for (int i = 0; i < toolBar.getComponentCount(); i++)
		{
			Component ribbonComponent = toolBar.getComponent(i);
			if (ribbonComponent instanceof AbstractButton)
			{
				AbstractButton button = (AbstractButton) ribbonComponent;
				
				Action action = button.getAction();
				if (action instanceof JAction)
				{
					if (showType.equals(JAction.TEXT))
					{
						((JAction) action).showText(showValue);
					}
					else if (showType.equals(JAction.ICON))
					{
						((JAction) action).showIcon(showValue);
					}
				}
			}
		}
	}
}