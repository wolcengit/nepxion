package com.nepxion.swing.renderer.list;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.StringTokenizer;

import javax.swing.DefaultListCellRenderer;

public class ListTabbedCellRenderer
	extends DefaultListCellRenderer
{
	private int width = 0;
	private String delimiter = "\t";
	private int[] tabs = null;
	private int defaultTab = 50;
	
	public ListTabbedCellRenderer()
	{
		this("\t");
	}
	
	public ListTabbedCellRenderer(int[] tabs)
	{
		this(tabs, 50);
	}
	
	public ListTabbedCellRenderer(String delimiter)
	{
		this(delimiter, null);
	}
	
	public ListTabbedCellRenderer(int width)
	{
		this(width, 50);
	}
	
	public ListTabbedCellRenderer(int[] tabs, int defaultTab)
	{
		this("\t", tabs, defaultTab);
	}
	
	public ListTabbedCellRenderer(String delimiter, int defaultTab)
	{
		this(delimiter, null, defaultTab);
	}
	
	public ListTabbedCellRenderer(String delimiter, int[] tabs)
	{
		this(delimiter, tabs, 50);
	}
	
	public ListTabbedCellRenderer(int width, int defaultTab)
	{
		this(width, (String) null, defaultTab);
	}
	
	public ListTabbedCellRenderer(int width, int[] tabs)
	{
		this(width, tabs, 50);
	}
	
	public ListTabbedCellRenderer(int width, String delimiter)
	{
		this(width, delimiter, 50);
	}
	
	public ListTabbedCellRenderer(String delimiter, int[] tabs, int defaultTab)
	{
		this(-1, delimiter, tabs, defaultTab);
	}
	
	public ListTabbedCellRenderer(int width, int[] tabs, int defaultTab)
	{
		this(width, "\t", tabs, defaultTab);
	}
	
	public ListTabbedCellRenderer(int width, String delimiter, int defaultTab)
	{
		this(width, delimiter, null, defaultTab);
	}
	
	public ListTabbedCellRenderer(int width, String delimiter, int[] tabs)
	{
		this(width, delimiter, tabs, 50);
	}
	
	public ListTabbedCellRenderer(int width, String delimiter, int[] tabs, int defaultTab)
	{
		this.width = width;
		this.delimiter = delimiter;
		this.tabs = tabs;
		this.defaultTab = defaultTab;
	}
	
	public String getTabKey()
	{
		return delimiter;
	}
	
	public void setTabKey(String delimiter)
	{
		this.delimiter = delimiter;
	}
	
	public int[] getTabs()
	{
		return tabs;
	}
	
	public void setTabs(int[] tabs)
	{
		this.tabs = tabs;
	}
	
	public int getDefaultTab()
	{
		return defaultTab;
	}
	
	public void setDefaultTab(int defaultTab)
	{
		this.defaultTab = defaultTab;
	}
	
	public int getTab(int index)
	{
		if (tabs == null)
		{
			return defaultTab * index;
		}
		
		int length = tabs.length;
		if (index >= 0 && index < length)
		{
			return tabs[index];
		}
		
		return tabs[length - 1] + defaultTab * (index - length + 1);
	}
	
	public Dimension getPreferredSize()
	{
		Dimension preferredSize = super.getPreferredSize();
		
		return new Dimension(width > 0 ? width : preferredSize.width, preferredSize.height);
	}
	
	public void paint(Graphics g)
	{
		FontMetrics fontMetrics = g.getFontMetrics();
		
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		getBorder().paintBorder(this, g, 0, 0, getWidth(), getHeight());
		
		g.setColor(getForeground());
		g.setFont(getFont());
		
		Insets insets = getInsets();
		int x = insets.left;
		int y = insets.top + fontMetrics.getAscent();
		
		StringTokenizer stringTokenizer = new StringTokenizer(getText(), delimiter);
		while (stringTokenizer.hasMoreTokens())
		{
			String next = stringTokenizer.nextToken();
			g.drawString(next, x, y);
			
			// x += fontMetrics.stringWidth(next);
			
			if (!stringTokenizer.hasMoreTokens())
			{
				break;
			}
			
			int index = 0;
			while (x >= getTab(index))
			{
				index++;
			}
			x = getTab(index);
		}
	}
}