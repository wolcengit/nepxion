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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.nepxion.swing.border.ShadowBorder;
import com.nepxion.swing.gradient.JGradientPainter;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.toolbar.JBasicToolBar;

public class JRibbon
	extends JPanel
{
	private Color borderBackground = new Color(108, 111, 117); // new Color(170, 191, 211);
	private Color containerBackground = new Color(220, 231, 244);
	private Color containerGradientStartBackground = new Color(246, 248, 250);
	private Color containerGradientEndBackground = new Color(172, 193, 212);
	private Color labelBackground = new Color(193, 216, 241);
	private Color cornerBackground = new Color(0, 0, 18); // new Color(102, 142, 175);
	
	private JBasicToolBar container;
	private JLabel label;
	
	public JRibbon()
	{
		this(null, null);
	}
	
	public JRibbon(String title, String toolTipText)
	{
		this(title, null, toolTipText);
	}
	
	public JRibbon(String title, Icon icon, String toolTipText)
	{
		container = new JBasicToolBar()
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
		
		add(container, BorderLayout.CENTER);
		add(label, BorderLayout.SOUTH);
	}
	
	public JBasicToolBar getContainer()
	{
		return container;
	}
	
	public JLabel getLabel()
	{
		return label;
	}
	
	public String getTitle()
	{
		return label.getText();
	}
	
	public void setTitle(String title)
	{
		label.setText(title);
	}
	
	public Icon getIcon()
	{
		return label.getIcon();
	}
	
	public void setIcon(Icon icon)
	{
		label.setIcon(icon);
	}
	
	public String getToolTipText()
	{
		return label.getToolTipText();
	}
	
	public void setToolTipText(String toolTipText)
	{
		label.setToolTipText(toolTipText);
	}
	
	public Color getBorderBackground()
	{
		return borderBackground;
	}

	public void setBorderBackground(Color borderBackground)
	{
		this.borderBackground = borderBackground;
	}

	public Color getContainerBackground()
	{
		return containerBackground;
	}

	public void setContainerBackground(Color containerBackground)
	{
		this.containerBackground = containerBackground;
	}

	public Color getContainerGradientStartBackground()
	{
		return containerGradientStartBackground;
	}

	public void setContainerGradientStartBackground(Color containerGradientStartBackground)
	{
		this.containerGradientStartBackground = containerGradientStartBackground;
	}

	public Color getContianerGradientEndBackground()
	{
		return containerGradientEndBackground;
	}

	public void setContainerGradientEndBackground(Color containerGradientEndBackground)
	{
		this.containerGradientEndBackground = containerGradientEndBackground;
	}

	public Color getLabelBackground()
	{
		return labelBackground;
	}

	public void setLabelBackground(Color labelBackground)
	{
		this.labelBackground = labelBackground;
	}

	public Color getCornerBackground()
	{
		return cornerBackground;
	}

	public void setCornerBackground(Color cornerBackground)
	{
		this.cornerBackground = cornerBackground;
	}	
}