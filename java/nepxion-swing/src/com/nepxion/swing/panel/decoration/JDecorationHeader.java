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
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.nepxion.swing.panel.JGradientPanel;
import com.nepxion.swing.style.framework.IStyle;
import com.nepxion.swing.style.framework.StyleManager;

public class JDecorationHeader
	extends JGradientPanel implements SwingConstants
{
	private JLabel label;
	private boolean selected;
	
	private IStyle style;
	
	public JDecorationHeader()
	{
		this("");
	}
	
	public JDecorationHeader(String title)
	{
		this(title, null, true, (IStyle) StyleManager.getStyle());
	}
	
	public JDecorationHeader(String title, boolean selected)
	{
		this(title, null, selected, (IStyle) StyleManager.getStyle());
	}
	
	public JDecorationHeader(String title, IStyle style)
	{
		this(title, null, true, style);
	}
	
	public JDecorationHeader(String title, boolean selected, IStyle style)
	{
		this(title, null, selected, style);
	}
	
	public JDecorationHeader(Icon icon)
	{
		this("", icon, true, (IStyle) StyleManager.getStyle());
	}
	
	public JDecorationHeader(Icon icon, boolean selected)
	{
		this("", icon, selected, (IStyle) StyleManager.getStyle());
	}
	
	public JDecorationHeader(Icon icon, IStyle style)
	{
		this("", icon, true, style);
	}
	
	public JDecorationHeader(Icon icon, boolean selected, IStyle style)
	{
		this("", icon, selected, style);
	}
	
	public JDecorationHeader(String title, Icon icon)
	{
		this(title, icon, true, (IStyle) StyleManager.getStyle());
	}
	
	public JDecorationHeader(String title, Icon icon, boolean selected)
	{
		this(title, icon, selected, (IStyle) StyleManager.getStyle());
	}
	
	public JDecorationHeader(String title, Icon icon, IStyle style)
	{
		this(title, icon, true, style);
	}
	
	public JDecorationHeader(String title, Icon icon, boolean selected, IStyle style)
	{
		super(new BorderLayout(), null, null);
		
		this.style = style;
		this.selected = selected;
		
		label = new JLabel(title, icon, LEADING);
		
		if (style.getLabelBorder() != null)
		{
			setBorder(style.getLabelBorder());
		}
		add(label, BorderLayout.WEST);
		
		updateHeader();
	}
	
	private void updateHeader()
	{
		label.setForeground(getTextForeground(selected));
		
		setGradientColor(getHeaderGradientColor(selected));
		setBackground(getHeaderBackground(selected));
	}
	
	public JLabel getLabel()
	{
		return label;
	}
	
	public String getTitle()
	{
		return label.getText();
	}
	
	public void setTitle(String newText)
	{
		String oldText = getTitle();
		label.setText(newText);
		firePropertyChange("title", oldText, newText);
	}
	
	public Icon getIcon()
	{
		return label.getIcon();
	}
	
	public void setIcon(Icon newIcon)
	{
		Icon oldIcon = getIcon();
		label.setIcon(newIcon);
		firePropertyChange("icon", oldIcon, newIcon);
	}
	
	public boolean isSelected()
	{
		return selected;
	}
	
	public void setSelected(boolean newValue)
	{
		boolean oldValue = isSelected();
		selected = newValue;
		updateHeader();
		firePropertyChange("selected", oldValue, newValue);
	}
	
	public Color getTextForeground(boolean selected)
	{
		if (selected)
		{
			return style.getSelectionForeground();
		}
		else
		{
			return style.getForeground();
		}
	}
	
	public Color getHeaderBackground(boolean selected)
	{
		if (selected)
		{
			return style.getSelectionBackground();
		}
		else
		{
			return style.getBackground();
		}
	}
	
	public Color getHeaderGradientColor(boolean selected)
	{
		if (selected)
		{
			return style.getSelectionGradientColor();
		}
		else
		{
			return style.getGradientColor();
		}
	}
}