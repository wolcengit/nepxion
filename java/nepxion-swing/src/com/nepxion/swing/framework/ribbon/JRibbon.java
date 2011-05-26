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
import javax.swing.UIManager;

import com.nepxion.swing.action.JAction;
import com.nepxion.swing.border.ShadowBorder;
import com.nepxion.swing.gradient.JGradientPainter;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.toolbar.JBasicToolBar;

public class JRibbon
	extends JPanel
{
	/**
	 * The border background.
	 */
	private Color borderBackground = new Color(108, 111, 117); // new Color(170, 191, 211);
	
	/**
	 * The container background.
	 */
	private Color containerBackground = new Color(220, 231, 244);
	
	/**
	 * The container gradient start background.
	 */
	private Color containerGradientStartBackground = new Color(246, 248, 250);
	
	/**
	 * The container gradient end background.
	 */
	private Color containerGradientEndBackground = new Color(172, 193, 212);
	
	/**
	 * The label background.
	 */
	private Color labelBackground = new Color(193, 216, 241);
	
	/**
	 * The corner background.
	 */
	private Color cornerBackground = new Color(0, 0, 18); // new Color(102, 142, 175);
	
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
			public void paint(Graphics g)
			{
				// Draw Background
				// g.setColor(toolBarBackground);
				// g.fillRect(0, 0, getWidth(), getHeight());
				
				Graphics2D g2d = (Graphics2D) g;
				Rectangle rectangle = new Rectangle(0, 0, getWidth(), getHeight());
				JGradientPainter.fastFill(g2d, rectangle, containerGradientStartBackground, containerGradientEndBackground, true);
				
				super.paint(g);
			}
		};
		
		label = new JLabel(title, icon, JLabel.CENTER)
		{
			public void paint(Graphics g)
			{
				if (LookAndFeelManager.isNimbusLookAndFeel())
				{	
					// Draw Background
					// g.setColor(labelBackground);
					// g.fillRect(0, 0, getWidth(), getHeight());
									
					Graphics2D g2d = (Graphics2D) g;
					Rectangle rectangle = new Rectangle(0, 0, getWidth(), getHeight());
					JGradientPainter.fastFill(g2d, rectangle, containerGradientStartBackground, containerGradientEndBackground, true);
				}
				else
				{
					// Draw Background
					// g.setColor(labelBackground);
					// g.fillRect(0, 0, getWidth(), getHeight());
									
					Graphics2D g2d = (Graphics2D) g;
					Rectangle rectangle = new Rectangle(0, 0, getWidth(), getHeight());
					JGradientPainter.fastFill(g2d, rectangle, new Color(255, 255, 255, 150), UIManager.getColor("Label.background"), true);
				}
				
				// Draw Corner
				g.setColor(cornerBackground);
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
				
				super.paint(g);
			}
		};
		label.setToolTipText(toolTipText);
		label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 23));
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1), new ShadowBorder(borderBackground)));
		
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
	 * Gets the border background.
	 * @return the instance of Color
	 */
	public Color getBorderBackground()
	{
		return borderBackground;
	}

	/**
	 * Sets the border background.
	 * @param borderBackground the instance of Color
	 */
	public void setBorderBackground(Color borderBackground)
	{
		this.borderBackground = borderBackground;
	}

	/**
	 * Gets the container background.
	 * @return the instance of Color
	 */
	public Color getContainerBackground()
	{
		return containerBackground;
	}

	/**
	 * Sets the container background.
	 * @param containerBackground the instance of Color
	 */
	public void setContainerBackground(Color containerBackground)
	{
		this.containerBackground = containerBackground;
	}

	/**
	 * Gets the container gradient start background.
	 * @return the instance of Color
	 */
	public Color getContainerGradientStartBackground()
	{
		return containerGradientStartBackground;
	}

	/**
	 * Sets the container gradient start background. 
	 * @param containerGradientStartBackground the instance of Color
	 */
	public void setContainerGradientStartBackground(Color containerGradientStartBackground)
	{
		this.containerGradientStartBackground = containerGradientStartBackground;
	}

	/**
	 * Gets the container gradient end background.
	 * @return the instance of Color
	 */
	public Color getContianerGradientEndBackground()
	{
		return containerGradientEndBackground;
	}

	/**
	 * Sets the container gradient end background. 
	 * @param containerGradientStartBackground the instance of Color
	 */
	public void setContainerGradientEndBackground(Color containerGradientEndBackground)
	{
		this.containerGradientEndBackground = containerGradientEndBackground;
	}

	/**
	 * Gets the label background.
	 * @return the instance of Color
	 */
	public Color getLabelBackground()
	{
		return labelBackground;
	}

	/**
	 * Sets the label background.
	 * @param labelBackground the instance of Color
	 */
	public void setLabelBackground(Color labelBackground)
	{
		this.labelBackground = labelBackground;
	}

	/**
	 * Gets the corner background.
	 * @return the instance of Color
	 */
	public Color getCornerBackground()
	{
		return cornerBackground;
	}

	/**
	 * Sets the corner background.
	 * @param cornerBackground the instance of Color
	 */
	public void setCornerBackground(Color cornerBackground)
	{
		this.cornerBackground = cornerBackground;
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