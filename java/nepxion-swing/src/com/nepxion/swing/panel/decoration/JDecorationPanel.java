package com.nepxion.swing.panel.decoration;

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
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JPanel;

import com.nepxion.swing.style.framework.IStyle;
import com.nepxion.swing.style.framework.StyleManager;

public class JDecorationPanel
	extends JPanel
{
	private JDecorationHeader header;
	private JPanel headContainer;
	
	public JDecorationPanel()
	{
		this("");
	}
	
	public JDecorationPanel(String title)
	{
		this(title, null, true, null, (IStyle) StyleManager.getStyle());
	}
	
	public JDecorationPanel(String title, boolean selected)
	{
		this(title, null, selected, null, (IStyle) StyleManager.getStyle());
	}
	
	public JDecorationPanel(String title, IStyle style)
	{
		this(title, null, true, null, style);
	}
	
	public JDecorationPanel(String title, boolean selected, IStyle style)
	{
		this(title, null, selected, null, style);
	}
	
	public JDecorationPanel(Icon icon)
	{
		this("", icon, true, null, (IStyle) StyleManager.getStyle());
	}
	
	public JDecorationPanel(Icon icon, boolean selected)
	{
		this("", icon, selected, null, (IStyle) StyleManager.getStyle());
	}
	
	public JDecorationPanel(Icon icon, IStyle style)
	{
		this("", icon, true, null, style);
	}
	
	public JDecorationPanel(Icon icon, boolean selected, IStyle style)
	{
		this("", icon, selected, null, style);
	}
	
	public JDecorationPanel(String title, Icon icon)
	{
		this(title, icon, true, null, (IStyle) StyleManager.getStyle());
	}
	
	public JDecorationPanel(String title, Icon icon, boolean selected)
	{
		this(title, icon, selected, null, (IStyle) StyleManager.getStyle());
	}
	
	public JDecorationPanel(String title, Icon icon, IStyle style)
	{
		this(title, icon, true, null, style);
	}
	
	public JDecorationPanel(String title, Icon icon, boolean selected, IStyle style)
	{
		this(title, icon, selected, null, style);
	}
	
	public JDecorationPanel(String title, Icon icon, JComponent content)
	{
		this(title, icon, true, content, (IStyle) StyleManager.getStyle());
	}
	
	public JDecorationPanel(String title, Icon icon, JComponent content, IStyle style)
	{
		this(title, icon, true, content, style);
	}
	
	public JDecorationPanel(String title, Icon icon, boolean selected, JComponent content)
	{
		this(title, icon, selected, content, (IStyle) StyleManager.getStyle());
	}
	
	public JDecorationPanel(String title, Icon icon, boolean selected, JComponent content, IStyle style)
	{
		header = new JDecorationHeader(title, icon, selected, style);
		
		headContainer = new JPanel(new BorderLayout());
		headContainer.setOpaque(false);
		headContainer.add(header, BorderLayout.CENTER);
		if (style.getHeaderBorder() != null)
		{
			headContainer.setBorder(style.getHeaderBorder());
		}
		
		Dimension minSize = new Dimension(headContainer.getMinimumSize());
		minSize.height += 3;
		setMinimumSize(minSize);
		if (style.getBorder() != null)
		{
			setBorder(style.getBorder());
		}
		
		setLayout(new BorderLayout());
		add(headContainer, BorderLayout.NORTH);
		
		if (content != null)
		{
			setContentPane(content);
		}
	}
	
	public void addHeaderMouseListener(MouseListener listener)
	{
		header.addMouseListener(listener);
	}
	
	public JPanel getHeaderContainer()
	{
		return headContainer;
	}
	
	public JDecorationHeader getHeader()
	{
		return header;
	}
	
	public Component getContentPane()
	{
		return getComponentCount() > 1 ? getComponent(1) : null;
	}
	
	public void setContentPane(Component contentPane)
	{
		Component oldContentPane = getContentPane();
		if (getComponentCount() > 1)
		{
			remove(oldContentPane);
		}
		add(contentPane, BorderLayout.CENTER);
		firePropertyChange("contentPane", oldContentPane, contentPane);
	}
	
	public String getTitle()
	{
		return header.getTitle();
	}
	
	public void setTitle(String title)
	{
		header.setTitle(title);
	}
	
	public Icon getIcon()
	{
		return header.getIcon();
	}
	
	public void setIcon(Icon icon)
	{
		header.setIcon(icon);
	}
	
	public boolean isSelected()
	{
		return header.isSelected();
	}
	
	public void setSelected(boolean selected)
	{
		header.setSelected(selected);
	}
}