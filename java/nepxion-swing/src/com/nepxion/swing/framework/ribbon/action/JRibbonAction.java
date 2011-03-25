package com.nepxion.swing.framework.ribbon.action;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.JComponent;

import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.framework.ribbon.JRibbonContainer;

public class JRibbonAction
	extends JSecurityAction
{
	private JRibbonContainer ribbonContainer;
	
	private String ribbonTitle;
	private String ribbonToolTipText;
	
	private Class ribbonComponentClass;
	private JComponent ribbonComponent;
	
	public JRibbonAction()
	{
		super();
	}
	
	public JRibbonAction(String text)
	{
		super(text);
	}
	
	public JRibbonAction(Icon icon)
	{
		super(icon);
	}
	
	public JRibbonAction(Icon icon, String toolTipText)
	{
		super(icon, toolTipText);
	}
	
	public JRibbonAction(String text, String toolTipText)
	{
		super(text, toolTipText);
	}
	
	public JRibbonAction(String text, Icon icon)
	{
		super(text, icon);
	}

	public JRibbonAction(String text, Icon icon, String toolTipText)
	{
		super(text, icon, toolTipText);
	}
	
	public JRibbonAction(String name, String text, String toolTipText)
	{
		super(name, text, toolTipText);
	}
	
	public JRibbonAction(String name, String text, Icon icon, String toolTipText)
	{
		super(name, text, icon, toolTipText);
	}
	
	public JRibbonContainer getRibbonContainer()
	{
		return ribbonContainer;
	}
	
	public void setRibbonContainer(JRibbonContainer ribbonContainer)
	{
		this.ribbonContainer = ribbonContainer;
	}
	
	public String getRibbonTitle()
	{
		return ribbonTitle;
	}
	
	public void setRibbonTitle(String ribbonTitle)
	{
		this.ribbonTitle = ribbonTitle;
	}
	
	public String getRibbonToolTipText()
	{
		return ribbonToolTipText;
	}
	
	public void setRibbonToolTipText(String ribbonToolTipText)
	{
		this.ribbonToolTipText = ribbonToolTipText;
	}
	
	public Class getRibbonComponentClass()
	{
		return ribbonComponentClass;
	}
	
	public void setRibbonComponentClass(Class ribbonComponentClass)
	{
		this.ribbonComponentClass = ribbonComponentClass;
	}
	
	public JComponent getRibbonComponent()
	{
		return ribbonComponent;
	}
	
	public void setRibbonComponent(JComponent ribbonComponent)
	{
		this.ribbonComponent = ribbonComponent;
	}
	
	public void execute(ActionEvent e)
	{
		if (ribbonComponent == null)
		{
			try
			{
				ribbonComponent = (JComponent) ribbonComponentClass.newInstance();
			}
			catch (InstantiationException ex)
			{
				ex.printStackTrace();
			}
			catch (IllegalAccessException ex)
			{
				ex.printStackTrace();
			}
		}
		
		ribbonContainer.addRibbonComponent(ribbonTitle, ribbonToolTipText, ribbonComponent);
	}
}