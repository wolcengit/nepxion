package com.nepxion.swing.shrinkbar;

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
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.nepxion.swing.toolbar.JBasicToolBar;

public class JShrinkBar
	extends JPanel implements ShrinkContants
{
	private JShrinkHeader shrinkHeader;
	
	private JComponent split;
	
	private Component contentPane;
	
	public JShrinkBar()
	{
		this(null);
	}
	
	public JShrinkBar(Component contentPane)
	{
		this(PLACEMENT_WEST, contentPane);
	}
	
	public JShrinkBar(int placement)
	{
		this(placement, null);
	}
	
	public JShrinkBar(int placement, Component contentPane)
	{
		this(placement, CONTENT_PANE_TYPE_LABEL, contentPane);
	}
	
	public JShrinkBar(int placement, int contentPaneType)
	{
		this(placement, contentPaneType, null);
	}
	
	public JShrinkBar(int placement, int contentPaneType, Component contentPane)
	{
		this.contentPane = contentPane;
		
		shrinkHeader = new JShrinkHeader(placement, contentPaneType)
		{
			public void setShrinked(boolean shrinked)
			{
				super.setShrinked(shrinked);
				
				if (shrinked)
				{
					split.setCursor(Cursor.getDefaultCursor());
				}
				else
				{
					split.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
				}
			}
		};
		SplitListener splitListener = new SplitListener(shrinkHeader);
		
		split = (JComponent) Box.createHorizontalStrut(3);
		split.setOpaque(true);
		split.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
		split.addMouseListener(splitListener);
		split.addMouseMotionListener(splitListener);
		
		setLayout(new BorderLayout());
		add(shrinkHeader, BorderLayout.NORTH);
		
		togglePlacement();
		
		if (contentPane != null)
		{
			setContentPane(contentPane);
		}
	}
	
	protected void togglePlacement()
	{
		final int placement = shrinkHeader.getPlacement();
		
		if (placement == PLACEMENT_EAST)
		{
			add(split, BorderLayout.WEST);
		}
		else if (placement == PLACEMENT_WEST)
		{
			add(split, BorderLayout.EAST);
		}
		
		split.setBorder(new Border()
		{
			public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
			{
				g.setColor(new Color(76, 84, 91));
				if (placement == PLACEMENT_EAST)
				{
					g.drawLine(x, y, x, y + height);
				}
				else if (placement == PLACEMENT_WEST)
				{
					g.drawLine(x + width - 1, y, x + width -1, y + height);
				}
			}
			
			public Insets getBorderInsets(Component c)
			{
				return new Insets(0, 1, 0, 1);
			}
			
			public boolean isBorderOpaque()
			{
				return true;
			}
		}
		);
	}
	
	public Component getContentPane()
	{
		return contentPane;
	}
	
	public void setContentPane(Component contentPane)
	{
		this.contentPane = contentPane;
		
		add(contentPane, BorderLayout.CENTER);
	}
	
	public JShrinkHeader getShrinkHeader()
	{
		return shrinkHeader;
	}
	
	public JLabel getShrinkLabel()
	{
		return shrinkHeader.getLabel();
	}
	
	public JBasicToolBar getShrinkToolBar()
	{
		return shrinkHeader.getToolBar();
	}
	
	public String getTitle()
	{
		if (shrinkHeader.getLabel() == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		return shrinkHeader.getLabel().getText();
	}
	
	public void setTitle(String title)
	{
		if (shrinkHeader.getLabel() == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		shrinkHeader.getLabel().setText(title);
	}
	
	public Color getTitleColor()
	{
		if (shrinkHeader.getLabel() == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		return shrinkHeader.getLabel().getForeground();
	}
	
	public void setTitleColor(Color color)
	{
		if (shrinkHeader.getLabel() == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		shrinkHeader.getLabel().setForeground(color);
	}
	
	public Font getTitleFont()
	{
		if (shrinkHeader.getLabel() == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		return shrinkHeader.getLabel().getFont();
	}
	
	public void setTitleFont(Font font)
	{
		if (shrinkHeader.getLabel() == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		shrinkHeader.getLabel().setFont(font);
	}
	
	public Icon getIcon()
	{
		if (shrinkHeader.getLabel() == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		return shrinkHeader.getLabel().getIcon();
	}
	
	public void setIcon(Icon icon)
	{
		if (shrinkHeader.getLabel() == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		shrinkHeader.getLabel().setIcon(icon);
	}
	
	public int getPlacement()
	{
		return shrinkHeader.getPlacement();
	}
	
	public void setPlacement(int placement)
	{
		shrinkHeader.setPlacement(placement);
		
		togglePlacement();
	}
	
	public int getContentPaneType()
	{
		return shrinkHeader.getContentPaneType();
	}
	
	public void setContentPaneType(int contentPaneType)
	{
		shrinkHeader.setContentPaneType(contentPaneType);
	}
	
	public boolean isShrinked()
	{
		return shrinkHeader.isShrinked();
	}
	
	public void setShrinked(boolean shrinked)
	{
		shrinkHeader.setShrinked(shrinked);
	}
	
	public int getShrinkedWidth()
	{
		return shrinkHeader.getShrinkedWidth();
	}
	
	public void setShrinkedWidth(int shrinkedWidth)
	{
		shrinkHeader.setShrinkedWidth(shrinkedWidth);
	}
}