package com.nepxion.cots.twaver.graph;

/**
 * <p>Title: Nepxion Cots For TWaver</p>
 * <p>Description: Nepxion Cots Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * <p>Announcement: It depends on the commercial software of TWaver, the repository only references the trial version.</p>
 * <p>If you want to use Nepxion Cots, please contact with Serva Corporation to buy the genuine version.</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import twaver.network.background.ColorBackground;

import com.nepxion.swing.font.FontContext;

public class TGraphBackground
	extends ColorBackground
{	
	public static final Color BLUE_STYLE_COLOR = new Color(172, 193, 212);
	public static final Color GREEN_STYLE_COLOR = new Color(170, 190, 160);
	
	public static final int TOP = 0;
	public static final int BOTTOM = 1;
	
	private String title;
	private int titleAlignment = TOP;
	private int titleVerticalGap = 15;
	private Color titleColor = Color.black;
	
	public TGraphBackground(Color color, Color gradientColor)
	{		
		setColor(color);
		setGradientColor(gradientColor);
		setGradient(true);	
	}
	
	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public int getTitleAlignment()
	{
		return titleAlignment;
	}

	public void setTitleAlignment(int titleAlignment)
	{
		this.titleAlignment = titleAlignment;
	}

	public int getTitleVerticalGap()
	{
		return titleVerticalGap;
	}

	public void setTitleVerticalGap(int titleVerticalGap)
	{
		this.titleVerticalGap = titleVerticalGap;
	}
	
	public Color getTitleColor()
	{
		return titleColor;
	}
	
	public void setTitleColor(Color titleColor)
	{
		this.titleColor = titleColor;
	}

	public void paintContent(Graphics2D g, double zoom, Rectangle viewportRect)
	{
		super.paintContent(g, zoom, viewportRect);
		
		if (title != null && !title.trim().equals(""))
		{	
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setColor(titleColor);
			g2d.setFont(FontContext.getChartTitleFont());
			
			FontMetrics fontMetrics = g2d.getFontMetrics();
			int fontWidth = fontMetrics.stringWidth(title);
			int fontHeight = fontMetrics.getHeight();

			int width = viewportRect.width;
			int height = viewportRect.height;
			
			int x = (width - fontWidth > 0 ? (width - fontWidth) / 2 : 0);
			int y = (titleAlignment == TOP ? fontHeight + titleVerticalGap : (height - titleVerticalGap > 0 ? height - titleVerticalGap : 0));
			
			g2d.drawString(title, x, y);
		}
	}
}