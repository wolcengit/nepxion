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
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.toolbar.JBasicToolBar;

public class JShrinkHeader
	extends JPanel implements ShrinkContants
{
	private int placement = PLACEMENT_WEST;
	private int contentPaneType = CONTENT_PANE_TYPE_LABEL;
	
	private boolean shrinked = false;
	
	private JLabel resizeHandlerLabel;
	private JLabel shrinkHandlerLabel;
	
	private JLabel label;
	private JBasicToolBar toolBar;
	
	private int shrinkedWidth = SHRINKED_WIDTH;
	private int preferredWidth = 0;
		
	public JShrinkHeader()
	{
		this(PLACEMENT_WEST);
	}
	
	public JShrinkHeader(int placement)
	{
		this(placement, CONTENT_PANE_TYPE_LABEL);
	}
	
	public JShrinkHeader(int placement, int contentPaneType)
	{
		this.placement = placement;
		this.contentPaneType = contentPaneType;
		
		initComponents();
	}
	
	private void initComponents()
	{
		SplitListener splitListener = new SplitListener(this);
		ShrinkListener shrinkListener = new ShrinkListener(this);
		
		resizeHandlerLabel = new JLabel(HEADER_RESIZE_HANDLER_IMAGE_ICON);
		resizeHandlerLabel.addMouseListener(splitListener);
		resizeHandlerLabel.addMouseMotionListener(splitListener);
		resizeHandlerLabel.setBorder(BorderFactory.createEmptyBorder(2, 6, 2, 6));
		
		shrinkHandlerLabel = new JLabel();
		shrinkHandlerLabel.addMouseListener(shrinkListener);
		shrinkHandlerLabel.setBorder(BorderFactory.createEmptyBorder(2, 6, 2, 6));
		
		setOpaque(false);
		setLayout(new BorderLayout());
				
		togglePlacement();
		toggleContentPaneType();
		updateShrinkIcon();
		updateCursor();
	}
	
	public JLabel getLabel()
	{
		return label;
	}
	
	public JBasicToolBar getToolBar()
	{
		return toolBar;
	}
	
	public String getTitle()
	{
		if (label == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		return label.getText();
	}
	
	public void setTitle(String title)
	{
		if (label == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		label.setText(title);
	}
	
	public Color getTitleColor()
	{
		if (label == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		return label.getForeground();
	}
	
	public void setTitleColor(Color color)
	{
		if (label == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		label.setForeground(color);
	}
	
	public Font getTitleFont()
	{
		if (label == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		return label.getFont();
	}
	
	public void setTitleFont(Font font)
	{
		if (label == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		label.setFont(font);
	}
	
	public Icon getIcon()
	{
		if (label == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		return label.getIcon();
	}
	
	public void setIcon(Icon icon)
	{
		if (label == null)
		{
			throw new IllegalArgumentException("It should be set content pane type with CONTENT_PANE_TYPE_LABEL");
		}
		
		label.setIcon(icon);
	}
	
	public int getPlacement()
	{
		return placement;
	}
	
	public void setPlacement(int placement)
	{
		this.placement = placement;
		
		togglePlacement();
	}
	
	protected void togglePlacement()
	{
		if (placement == PLACEMENT_EAST)
		{
			add(shrinkHandlerLabel, BorderLayout.EAST);
			add(resizeHandlerLabel, BorderLayout.WEST);
		}
		else if (placement == PLACEMENT_WEST)
		{
			add(resizeHandlerLabel, BorderLayout.EAST);
			add(shrinkHandlerLabel, BorderLayout.WEST);
		}
	}
	
	public int getContentPaneType()
	{
		return contentPaneType;
	}
	
	public void setContentPaneType(int contentPaneType)
	{
		this.contentPaneType = contentPaneType;
		
		toggleContentPaneType();
	}
	
	protected void toggleContentPaneType()
	{
		if (contentPaneType == CONTENT_PANE_TYPE_LABEL)
		{	
			if (label == null)
			{
				label = new JLabel();
				label.setForeground(TITLE_COLOR);
			}
			
			add(label, BorderLayout.CENTER);
		}
		else if (contentPaneType == CONTENT_PANE_TYPE_TOOLBAR)
		{
			if (toolBar == null)
			{
				toolBar = new JBasicToolBar();
			}
			
			add(toolBar, BorderLayout.CENTER);
		}	
	}
	
	public boolean isShrinked()
	{
		return shrinked;
	}
	
	public void setShrinked(boolean shrinked)
	{
		if (this.shrinked == shrinked)
		{
			return;
		}
		
		Container parent = getParent();
		Dimension size = parent.getPreferredSize();
		if (shrinked)
		{
			preferredWidth = size.width;
			size = new Dimension(shrinkedWidth, size.height);
		}
		else
		{
			int width = preferredWidth;
			int height = parent.getPreferredSize().height;
			size = new Dimension(width, height);
		}
		parent.setPreferredSize(size);
			
		this.shrinked = shrinked;
		
		resizeHandlerLabel.setVisible(!shrinked);
		
		if (label != null)
		{	
			label.setVisible(!shrinked);
		}
		if (toolBar != null)
		{
			toolBar.setVisible(!shrinked);
		}	
		
		revalidateParent();
		updateShrinkIcon();
		updateCursor();
	}
	
	protected void toggleShrinked()
	{
		boolean shrinked = isShrinked();
		
		setShrinked(!shrinked);
	}
	
	public int getShrinkedWidth()
	{
		return shrinkedWidth;
	}
	
	public void setShrinkedWidth(int shrinkedWidth)
	{
		this.shrinkedWidth = shrinkedWidth;
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(super.getPreferredSize().width, HEADER_BACKGROUND_IMAGE_ICON.getIconHeight());
	}
	
	protected void revalidateParent()
	{
		Container container = getParent();
		if (container instanceof JComponent)
		{
			JComponent component = (JComponent) container;
			component.revalidate();
		}
	}
	
    protected void updateShrinkIcon()
	{
    	Icon shrinkIcon = null;
    	
		if (shrinked)
		{
			if (placement == PLACEMENT_EAST)
			{
				shrinkIcon = HEADER_SHRINK_HANDLER_LEFT_IMAGE_ICON;
			}
			else if (placement == PLACEMENT_WEST)
			{
				shrinkIcon = HEADER_SHRINK_HANDLER_RIGHT_IMAGE_ICON;
			}
		}
		else
		{
			if (placement == PLACEMENT_EAST)
			{
				shrinkIcon = HEADER_SHRINK_HANDLER_RIGHT_IMAGE_ICON;				
			}
			else if (placement == PLACEMENT_WEST)
			{
				shrinkIcon = HEADER_SHRINK_HANDLER_LEFT_IMAGE_ICON;
			}
		}
		
		shrinkHandlerLabel.setIcon(shrinkIcon);
	}
    
	protected void updateCursor()
	{
		if (shrinked)
		{
			resizeHandlerLabel.setCursor(Cursor.getDefaultCursor());
		}
		else
		{
			resizeHandlerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
		}
	}
	
	protected void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		
		int width = getWidth();
		int height = getHeight();
		
		g2d.setPaint(HEADER_TEXTURE_PAINT);
		g2d.fillRect(0, 0, width, height);
		
		g2d.drawImage(HEADER_BACKGROUND_LEFT_IMAGE_ICON.getImage(), 0, 0, null);
		
		int x = width - HEADER_BACKGROUND_RIGHT_IMAGE_ICON.getImage().getWidth(null);
		int y = 0;
		g2d.drawImage(HEADER_BACKGROUND_RIGHT_IMAGE_ICON.getImage(), x, y, null);
	}
}