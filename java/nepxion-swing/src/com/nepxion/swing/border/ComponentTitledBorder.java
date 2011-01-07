package com.nepxion.swing.border;

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
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class ComponentTitledBorder
	extends TitledBorder
{
	private JComponent component;
	
	public ComponentTitledBorder(JComponent component)
	{
		this(null, component, LEFT, TOP);
	}
	
	public ComponentTitledBorder(Border border)
	{
		this(border, null, LEFT, TOP);
	}
	
	public ComponentTitledBorder(Border border, JComponent component)
	{
		this(border, component, LEFT, TOP);
	}
	
	public ComponentTitledBorder(Border border, JComponent component, int titleJustification, int titlePosition)
	{
		super(border, null, titleJustification, titlePosition, null, null);
		
		this.component = component;
		
		if (border == null)
		{
			this.border = super.getBorder();
		}
	}
	
	public JComponent getComponent()
	{
		return component;
	}
	
	public void setComponent(JComponent component)
	{
		this.component = component;
	}
	
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
	{
		Rectangle borderRectangle = new Rectangle(x + EDGE_SPACING, y + EDGE_SPACING, width - (EDGE_SPACING * 2), height - (EDGE_SPACING * 2));
		Insets borderInsets;
		if (border != null)
		{
			borderInsets = border.getBorderInsets(c);
		}
		else
		{
			borderInsets = new Insets(0, 0, 0, 0);
		}
		
		Rectangle rectangle = new Rectangle(x, y, width, height);
		Insets insets = getBorderInsets(c);
		Rectangle componentRectangle = getComponentRectangle(rectangle, insets);
		int diff;
		switch (titlePosition)
		{
			case ABOVE_TOP:
				diff = componentRectangle.height + TEXT_SPACING;
				borderRectangle.y += diff;
				borderRectangle.height -= diff;
				break;
			case TOP:
			case DEFAULT_POSITION:
				diff = insets.top / 2 - borderInsets.top - EDGE_SPACING;
				borderRectangle.y += diff;
				borderRectangle.height -= diff;
				break;
			case BELOW_TOP:
			case ABOVE_BOTTOM:
				break;
			case BOTTOM:
				diff = insets.bottom / 2 - borderInsets.bottom - EDGE_SPACING;
				borderRectangle.height -= diff;
				break;
			case BELOW_BOTTOM:
				diff = componentRectangle.height + TEXT_SPACING;
				borderRectangle.height -= diff;
				break;
		}
		border.paintBorder(c, g, borderRectangle.x, borderRectangle.y, borderRectangle.width, borderRectangle.height);
		Color color = g.getColor();
		g.setColor(c.getBackground());
		g.fillRect(componentRectangle.x, componentRectangle.y, componentRectangle.width, componentRectangle.height);
		g.setColor(color);
		component.repaint();
	}
	
	public Insets getBorderInsets(Component c, Insets insets)
	{
		Insets borderInsets;
		if (border != null)
		{
			borderInsets = border.getBorderInsets(c);
		}
		else
		{
			borderInsets = new Insets(0, 0, 0, 0);
		}
		insets.top = EDGE_SPACING + TEXT_SPACING + borderInsets.top;
		insets.right = EDGE_SPACING + TEXT_SPACING + borderInsets.right;
		insets.bottom = EDGE_SPACING + TEXT_SPACING + borderInsets.bottom;
		insets.left = EDGE_SPACING + TEXT_SPACING + borderInsets.left;
		
		if (c == null || component == null)
		{
			return insets;
		}
		
		int height = 0;
		if (component != null)
		{
			height = component.getPreferredSize().height;
		}
		
		switch (titlePosition)
		{
			case ABOVE_TOP:
				insets.top += height + TEXT_SPACING;
				break;
			case TOP:
			case DEFAULT_POSITION:
				insets.top += Math.max(height, borderInsets.top) - borderInsets.top;
				break;
			case BELOW_TOP:
				insets.top += height + TEXT_SPACING;
				break;
			case ABOVE_BOTTOM:
				insets.bottom += height + TEXT_SPACING;
				break;
			case BOTTOM:
				insets.bottom += Math.max(height, borderInsets.bottom) - borderInsets.bottom;
				break;
			case BELOW_BOTTOM:
				insets.bottom += height + TEXT_SPACING;
				break;
		}
		
		return insets;
	}
	
	public Rectangle getComponentRectangle(Rectangle rect, Insets borderInsets)
	{
		Dimension dimension = component.getPreferredSize();
		Rectangle rectangle = new Rectangle(0, 0, dimension.width, dimension.height);
		switch (titlePosition)
		{
			case ABOVE_TOP:
				rectangle.y = EDGE_SPACING;
				break;
			case TOP:
			case DEFAULT_POSITION:
				rectangle.y = EDGE_SPACING + (borderInsets.top - EDGE_SPACING - TEXT_SPACING - dimension.height) / 2;
				break;
			case BELOW_TOP:
				rectangle.y = borderInsets.top - dimension.height - TEXT_SPACING;
				break;
			case ABOVE_BOTTOM:
				rectangle.y = rect.height - borderInsets.bottom + TEXT_SPACING;
				break;
			case BOTTOM:
				rectangle.y = rect.height - borderInsets.bottom + TEXT_SPACING + (borderInsets.bottom - EDGE_SPACING - TEXT_SPACING - dimension.height) / 2;
				break;
			case BELOW_BOTTOM:
				rectangle.y = rect.height - dimension.height - EDGE_SPACING;
				break;
		}
		switch (titleJustification)
		{
			case LEFT:
			case DEFAULT_JUSTIFICATION:
				rectangle.x = TEXT_INSET_H + borderInsets.left;
				break;
			case RIGHT:
				rectangle.x = rect.width - borderInsets.right - TEXT_INSET_H - rectangle.width;
				break;
			case CENTER:
				rectangle.x = (rect.width - rectangle.width) / 2;
				break;
		}
		
		return rectangle;
	}
}