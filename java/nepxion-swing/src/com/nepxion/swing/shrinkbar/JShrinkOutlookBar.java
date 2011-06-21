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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;

import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.style.texture.shrink.IHeaderTextureStyle;
import com.nepxion.swing.style.texture.shrink.IOutlookTextureStyle;

public class JShrinkOutlookBar
	extends BasicShrinkBar
{
	private TableLayout tableLayout;
	private Map tableLayoutMap;
	
	private JComponent contentPane;
	private JComponent outlookContentPane;
	private JComponent fillContentPane;
	
	private IOutlookTextureStyle outlookTextureStyle;
	
	public JShrinkOutlookBar(int placement)
	{
		this(placement, DEFAULT_CONTENT_PANE_TYPE);
	}
	
	public JShrinkOutlookBar(int placement, IHeaderTextureStyle headerTextureStyle, IOutlookTextureStyle outlookTextureStyle)
	{
		this(placement, DEFAULT_CONTENT_PANE_TYPE, headerTextureStyle, outlookTextureStyle);
	}
	
	public JShrinkOutlookBar(int placement, int contentPaneType)
	{
		this(placement, contentPaneType, DEFAULT_HEADER_TEXTURE_STYLE, DEFAULT_OUTLOOK_TEXTURE_STYLE);
	}
	
	public JShrinkOutlookBar(int placement, int contentPaneType, IHeaderTextureStyle headerTextureStyle, IOutlookTextureStyle outlookTextureStyle)
	{
		super(placement, contentPaneType, headerTextureStyle);
		
		this.outlookTextureStyle = outlookTextureStyle;
		
		initComponents();
	}
	
	private void initComponents()
	{
		tableLayout = new TableLayout();
		tableLayout.insertColumn(0, TableLayout.FILL);
		
		tableLayoutMap = new Hashtable();
		
		outlookContentPane = new JPanel();
		outlookContentPane.setLayout(tableLayout);
				
		fillContentPane = new JPanel();
		fillContentPane.setLayout(new BorderLayout());
		
		fillContentPane.setBackground(UIManager.getColor("Panel.background"));
		fillContentPane.setPreferredSize(new Dimension(0, 0));
		fillContentPane.setBorder(new Border()
		{
			public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
			{
				g.setColor(outlookTextureStyle.getBorderColor());
				g.drawLine(0, 0, width, 0);
			}
			
			public Insets getBorderInsets(Component c)
			{
				return new Insets(1, 0, 0, 0);
			}
			
			public boolean isBorderOpaque()
			{
				return true;
			}
		}
		);
		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.setBorder(BorderFactory.createLineBorder(outlookTextureStyle.getBorderColor()));
		contentPane.add(outlookContentPane, BorderLayout.NORTH);
		contentPane.add(fillContentPane, BorderLayout.CENTER);
		
		shrinkContentPane.add(contentPane, BorderLayout.CENTER);
	}
	
	public IOutlookTextureStyle getOutlookTextureStyle()
	{
		return outlookTextureStyle;
	}
	
	public JShrinkOutlook addOutlook(String title, Icon icon, Component contentPane)
	{
		return addOutlook(title, icon, icon, contentPane);
	}
	
	public JShrinkOutlook addOutlook(String title, Icon icon, Icon selectedIcon, Component contentPane)
	{
		JShrinkOutlook outlook = new JShrinkOutlook(this);
		outlook.setTitle(title);
		outlook.setIcon(icon);
		outlook.setSelectedIcon(selectedIcon);
		outlook.setSelected(false);
		if (contentPane != null)
		{	
			outlook.setContentPane(contentPane);
		}
		
		int rowCount = tableLayout.getRow().length;
		
		tableLayout.insertRow(rowCount, TableLayout.PREFERRED);
		outlookContentPane.add(outlook, "0, " + rowCount);
		tableLayoutMap.put(outlook, rowCount);
		rowCount++;
		
		tableLayout.insertRow(rowCount, TableLayout.MINIMUM);
		outlookContentPane.add(outlook.getScrollPane(), "0," + rowCount);
		tableLayoutMap.put(outlook.getScrollPane(), rowCount);
		
		return outlook;
	}
	
	protected void updateLayoutConstraint(Component component, boolean selected)
	{
		Integer rowIndexValue = (Integer) tableLayoutMap.get(component);
		int rowIndex = rowIndexValue.intValue();
		
		double constraint = TableLayout.FILL;
		if (!selected)
		{
			constraint = TableLayout.MINIMUM;
		}
		
		tableLayout.setRow(rowIndex, constraint);
	}

	protected void setFillContentPaneVisible(boolean visible)
	{
		contentPane.remove(outlookContentPane);
		contentPane.remove(fillContentPane);
		
		if (visible)
		{
			contentPane.add(outlookContentPane, BorderLayout.NORTH);
			contentPane.add(fillContentPane, BorderLayout.CENTER);
		}
		else
		{
			contentPane.add(outlookContentPane, BorderLayout.CENTER);
		}
	}
	
	private void shrinkChanged(boolean shrinked)
	{
		// inform all bar list to update cell renderer.
//		for (int i = 0; i < barPane.getComponentCount(); i++)
//		{
//			Component c = barPane.getComponent(i);
//			if (c instanceof JShrinkOutlookBar)
//			{
//				JShrinkOutlookBar bar = (JShrinkOutlookBar) c;
//				bar.headerShrinkChanged(shrinked);
////				FreeOutlookList list = bar.getList();
////				// fire this property change to cheat the UI to revalidate
////				// and recalculate prefered size, so the cell renderer
////				// will be displayed in center.
////				list.firePropertyChange("layoutOrientation", true, false);
//			}
//		}
	}
	
	public JComponent getFillContentPane()
	{
		return fillContentPane;
	}
	
	public void closeAllOutlooks()
	{
		for (int i = 0; i < outlookContentPane.getComponentCount(); i++)
		{
			Component component = outlookContentPane.getComponent(i);
			if (component instanceof JShrinkOutlook)
			{
				JShrinkOutlook shrinkOutlook = (JShrinkOutlook) component;
				if (shrinkOutlook.isSelected())
				{
					shrinkOutlook.setSelected(false);
				}
			}
		}
	}
	
	public JShrinkOutlook getSelectedOutlook()
	{
		for (int i = 0; i < outlookContentPane.getComponentCount(); i++)
		{
			Component component = outlookContentPane.getComponent(i);
			if (component instanceof JShrinkOutlook)
			{
				JShrinkOutlook shrinkOutlook = (JShrinkOutlook) component;
				
				if (shrinkOutlook.isSelected())
				{
					return shrinkOutlook;
				}
			}
		}
		
		return null;
	}
	
	public JShrinkOutlook getOutlook(int index)
	{
		Component component = outlookContentPane.getComponent(index);
		if (component instanceof JShrinkOutlook)
		{
			JShrinkOutlook shrinkOutlook = (JShrinkOutlook) component;
			
			return shrinkOutlook;
		}
		
		return null;
	}
	
	public JShrinkOutlook getOutlook(String title)
	{
		for (int i = 0; i < outlookContentPane.getComponentCount(); i++)
		{
			Component component = outlookContentPane.getComponent(i);
			if (component instanceof JShrinkOutlook)
			{
				JShrinkOutlook shrinkOutlook = (JShrinkOutlook) component;
				
				if (shrinkOutlook.getTitle().equals(title))
				{
					return shrinkOutlook;
				}
			}
		}
		
		return null;
	}
}