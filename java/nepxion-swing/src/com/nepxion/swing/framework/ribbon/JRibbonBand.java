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
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.border.ShadowBorder;
import com.nepxion.swing.gradient.JGradientPainter;
import com.nepxion.swing.toolbar.JBasicToolBar;

public class JRibbonBand
	extends JPanel
{
	private Color bandBorderBackground = new Color(108, 111, 117); // new Color(170, 191, 211);
	private Color toolBarBackground = new Color(220, 231, 244);
	private Color toolBarGradientStartBackground = new Color(246, 248, 250);
	private Color toolBarGradientEndBackground = new Color(172, 193, 212);
	private Color labelBackground = new Color(193, 216, 241);
	private Color cornerBackground = new Color(0, 0, 18); // new Color(102, 142, 175);
	
	private JBasicToolBar toolBar;
	private JLabel label;
	
	public JRibbonBand()
	{
		this("");
	}
	
	public JRibbonBand(String title)
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
				JGradientPainter.fastFill(g2d, rectangle, toolBarGradientStartBackground, toolBarGradientEndBackground, true);
				
				super.paint(g);
			}
		};
		
		label = new JLabel(title, JLabel.CENTER)
		{
			public void paint(Graphics g)
			{
				// Draw Background
				g.setColor(labelBackground);
				g.fillRect(0, 0, getWidth(), getHeight());
				
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
		label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 23));
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1), new ShadowBorder(bandBorderBackground)));
		
		add(toolBar, BorderLayout.CENTER);
		add(label, BorderLayout.SOUTH);
	}
	
	public JBasicToolBar getToolBar()
	{
		return toolBar;
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
	
	public Color getBandBorderBackground()
	{
		return bandBorderBackground;
	}

	public void setBandBorderBackground(Color bandBorderBackground)
	{
		this.bandBorderBackground = bandBorderBackground;
	}

	public Color getToolBarBackground()
	{
		return toolBarBackground;
	}

	public void setToolBarBackground(Color toolBarBackground)
	{
		this.toolBarBackground = toolBarBackground;
	}

	public Color getToolBarGradientStartBackground()
	{
		return toolBarGradientStartBackground;
	}

	public void setToolBarGradientStartBackground(Color toolBarGradientStartBackground)
	{
		this.toolBarGradientStartBackground = toolBarGradientStartBackground;
	}

	public Color getToolBarGradientEndBackground()
	{
		return toolBarGradientEndBackground;
	}

	public void setToolBarGradientEndBackground(Color toolBarGradientEndBackground)
	{
		this.toolBarGradientEndBackground = toolBarGradientEndBackground;
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