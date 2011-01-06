package com.nepxion.swing.fullscreen;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Color;

import javax.swing.Icon;

import com.nepxion.swing.applet.JBasicApplet;
import com.nepxion.swing.icon.IconFactory;

public class JFullScreenApplet
	extends JBasicApplet implements FullScreenConstants
{	
	private String windowTitle;
	private Icon windowIcon;
	
	private JFullScreenDecorationPanel decorationPanel;
	
	public void init()
	{
		super.init();
		
		initWindowTitle();		
		initWindowIcon();
		
		decorationPanel = new JFullScreenDecorationPanel(windowTitle, windowIcon);
		decorationPanel.setBackground(Color.white);
		
		getContentPane().add(decorationPanel);
	}
	
	private void initWindowTitle()
	{
		windowTitle = getParameter("windowTitle");
		if (windowTitle == null || windowTitle.equals(""))
		{
			windowTitle = WINDOW_TITLE;
		}
	}
	
	private void initWindowIcon()
	{
		String windowIconName = getParameter("windowIcon");
		if (windowIconName == null || windowIconName.equals(""))
		{
			windowIcon = IconFactory.getSwingIcon(WINDOW_ICON);
		}
		else
		{
			windowIcon = IconFactory.getContextIcon(windowIconName);
		}
	}
	
	public boolean isValid(String content)
	{
		return content != null && !content.trim().equals("");
	}
	
	public JFullScreenDecorationPanel getContainer()
	{
		return decorationPanel;
	}
}