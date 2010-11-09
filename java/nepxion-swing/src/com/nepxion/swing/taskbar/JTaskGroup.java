package com.nepxion.swing.taskbar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.border.Border;

import com.l2fprod.common.swing.JTaskPaneGroup;
import com.nepxion.swing.font.FontContext;

public class JTaskGroup
	extends JTaskPaneGroup
{
	public JTaskGroup()
	{
	}
	
	public JTaskGroup(String title)
	{
		this(title, (String) null);
	}
	
	public JTaskGroup(String title, String toolTipText)
	{
		this(title, null, toolTipText);
	}
	
	public JTaskGroup(String title, Icon icon)
	{
		this(title, icon, null);
	}
	
	public JTaskGroup(String title, Icon icon, String toolTipText)
	{
		this(title, icon, toolTipText, FontContext.getFont());
	}
	
	public JTaskGroup(String title, Icon icon, String toolTipText, Font font)
	{
		if (title != null)
		{
			setTitle(title);
		}
		
		if (icon != null)
		{
			setIcon(icon);
		}
		
		if (toolTipText != null)
		{
			setToolTipText(toolTipText);
		}
		
		if (font != null)
		{
			setFont(font);
		}
	}
	
	public void setContentPaneBorder(Border border)
	{
		JComponent component = (JComponent) getContentPane();
		component.setBorder(BorderFactory.createCompoundBorder(component.getBorder(), border));
	}
}