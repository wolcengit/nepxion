package com.nepxion.swing.popupmenu;

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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;

import javax.swing.JPopupMenu;

import com.nepxion.swing.gradient.JGradientPainter;
import com.nepxion.swing.lookandfeel.LookAndFeelManager;
import com.nepxion.swing.style.framework.IStyle;
import com.nepxion.swing.style.framework.StyleManager;

public class JDecorationPopupMenuPainter
{
	private JPopupMenu popupMenu;
	private String title;
	private int width;
	private Font font;
	private Color gradientColor;
	private Color foreground;
	private Color background;
	
	public JDecorationPopupMenuPainter(String title)
	{
		this(title, StyleManager.getStyle());
	}
	
	public JDecorationPopupMenuPainter(IStyle style)
	{
		this("", style);
	}
	
	public JDecorationPopupMenuPainter(String title, IStyle style)
	{
		this(title, 25, new Font("Verdana", Font.BOLD, 9), style.getSelectionGradientColor(), style.getSelectionForeground(), style.getSelectionBackground());
	}
	
	public JDecorationPopupMenuPainter(String title, int width, Font font, Color gradientColor, Color foreground, Color background)
	{
		this.font = font;
		this.title = title;
		this.width = width;
		this.font = font;
		this.gradientColor = gradientColor;
		this.foreground = foreground;
		this.background = background;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public Font getFont()
	{
		return font;
	}
	
	public void setFont(Font font)
	{
		this.font = font;
	}
	
	public Color getGradientColor()
	{
		return foreground;
	}
	
	public void setGradientColor(Color gradientColor)
	{
		this.gradientColor = gradientColor;
	}
	
	public Color getForeground()
	{
		return foreground;
	}
	
	public void setForeground(Color foreground)
	{
		this.foreground = foreground;
	}
	
	public Color getBackground()
	{
		return background;
	}
	
	public void setBackground(Color background)
	{
		this.background = background;
	}
	
	public void setPopupMenu(JPopupMenu popupMenu)
	{
		this.popupMenu = popupMenu;
	}
	
	public Insets getInsets(Insets insets)
	{
		// Insets insets = (Insets) super.getInsets().clone();
		insets.left += width;
		
		return insets;
	}
	
	public void paintComponent(Graphics g)
	{
		// super.paintComponent(g);
		// Dimension size = getSize();
		Dimension size = popupMenu.getSize();
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle rectangle = new Rectangle(0, 0, width, LookAndFeelManager.isNimbusLookAndFeel() ? size.height - 1 : size.height - 2);
		JGradientPainter.fastFill((Graphics2D) g, rectangle, background, gradientColor, true);
		
		// GradientPaint gp = new GradientPaint(0.0F, 0.0F, background, 0.0F,
		// size.height, gradientColor, false);
		// g2.setPaint(gp);
		// g2.fillRect(0, 0, width, size.height - 2);
		
		if (title != null && font != null)
		{
			g2.setColor(foreground);
			g2.setFont(font);
			Dimension textSize = getTextSize(title, font, g2);
			int y = (size.height + textSize.width) / 2;
			int xOffset = getTextOffset(title, font, g2);
			
			if (size.height - textSize.width > 5)
			{
				drawString(title, g2, (width - textSize.height) / 2 + xOffset, y, -1.5707963267948966D);
			}
		}
	}
	
	protected Dimension getTextSize(String text, Font font, Graphics2D graphics2D)
	{
		Font graphics2DFont = graphics2D.getFont();
		graphics2D.setFont(font);
		FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
		int i = (int) font.getStringBounds(text, fontRenderContext).getWidth();
		int j = (int) font.getStringBounds(text, fontRenderContext).getHeight();
		graphics2D.setFont(graphics2DFont);
		
		return new Dimension(i, j);
	}
	
	protected int getTextOffset(String text, Font font, Graphics2D graphics2D)
	{
		Font graphics2DFont = graphics2D.getFont();
		graphics2D.setFont(font);
		FontRenderContext fontRenderContext = graphics2D.getFontRenderContext();
		int i = (int) font.getStringBounds(text, fontRenderContext).getHeight();
		LineMetrics linemetrics = font.getLineMetrics(text, fontRenderContext);
		int j = (int) linemetrics.getDescent();
		graphics2D.setFont(graphics2DFont);
		
		return i - j;
	}
	
	protected void drawString(String title, Graphics2D graphics2D, double x, double y, double angle)
	{
		graphics2D.translate(x, y);
		graphics2D.rotate(angle);
		graphics2D.drawString(title, 0, 0);
		graphics2D.rotate(-angle);
		graphics2D.translate(-x, -y);
	}
}