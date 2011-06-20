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
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.style.texture.shrink.IHeaderTextureStyle;
import com.nepxion.swing.toolbar.JBasicToolBar;

public class BasicShrinkBar
	extends JPanel implements ShrinkContants
{
	private JShrinkHeader shrinkHeader;
	
	private JSplitBar splitBar;
	
	public BasicShrinkBar(int placement)
	{
		this(placement, DEFAULT_CONTENT_PANE_TYPE);
	}
	
	public BasicShrinkBar(int placement, IHeaderTextureStyle headerTextureStyle)
	{
		this(placement, DEFAULT_CONTENT_PANE_TYPE, headerTextureStyle);
	}
	
	public BasicShrinkBar(int placement, int contentPaneType)
	{
		this(placement, contentPaneType, DEFAULT_HEADER_TEXTURE_STYLE);
	}
	
	public BasicShrinkBar(int placement, int contentPaneType, IHeaderTextureStyle headerTextureStyle)
	{
		shrinkHeader = new JShrinkHeader(placement, contentPaneType, headerTextureStyle)
		{
			public void setShrinked(boolean shrinked)
			{
				super.setShrinked(shrinked);
				
				splitBar.setShrinked(shrinked);
			}
		};
		splitBar = new JSplitBar(shrinkHeader, 3);
		
		setLayout(new BorderLayout());
		add(shrinkHeader, BorderLayout.NORTH);
		
		togglePlacement();
	}
	
	protected void togglePlacement()
	{
		if (!isShrinkable())
		{
			throw new IllegalArgumentException("The shrinking is disabled");
		}
		
		int placement = getPlacement();
		
		splitBar.setPlacement(placement);
		
		if (placement == PLACEMENT_EAST)
		{
			add(splitBar, BorderLayout.WEST);
		}
		else if (placement == PLACEMENT_WEST)
		{
			add(splitBar, BorderLayout.EAST);
		}
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
	
	public boolean isShrinkable()
	{
		return shrinkHeader.isShrinkable();
	}
	
	public void setShrinkable(boolean shrinkable)
	{
		shrinkHeader.setShrinkable(shrinkable);
		
		if (shrinkable)
		{
			togglePlacement();
		}
		else
		{
			if (retrieveComponent(splitBar))
			{	
				remove(splitBar);
			}
		}
	}
	
	private boolean retrieveComponent(Component component)
	{
		for (int i = 0; i < getComponentCount(); i++)
		{
			Component c = getComponent(i);
			
			if (c == component)
			{
				return true;
			}	
		}
		
		return false;
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