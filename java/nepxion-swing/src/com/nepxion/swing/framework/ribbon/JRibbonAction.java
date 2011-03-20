package com.nepxion.swing.framework.ribbon;

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
	
	public JRibbonAction(String name)
	{
		super(name);
	}
	
	public JRibbonAction(String name, Icon icon)
	{
		super(name, icon);
	}
	
	public JRibbonAction(String name, String toolTipText)
	{
		super(name, toolTipText);
	}
	
	public JRibbonAction(String name, Icon icon, String toolTipText)
	{
		super(name, icon, toolTipText);
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