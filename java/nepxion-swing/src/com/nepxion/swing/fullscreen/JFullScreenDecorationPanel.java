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

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JPanel;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.panel.decoration.JDecorationPanel;
import com.nepxion.swing.style.framework.IStyle;

public class JFullScreenDecorationPanel
	extends JDecorationPanel
{
	private ToolBar toolBar;
	
	public JFullScreenDecorationPanel(String title, Icon icon)
	{
		this(title, icon, true);
	}
	
	public JFullScreenDecorationPanel(String title, Icon icon, boolean isSelected)
	{
		super(title, icon, isSelected);
		
		initComponents();
	}
	
	public JFullScreenDecorationPanel(String title, Icon icon, IStyle style)
	{
		this(title, icon, true, style);
	}
	
	public JFullScreenDecorationPanel(String title, Icon icon, boolean isSelected, IStyle style)
	{
		super(title, icon, isSelected, style);
		
		initComponents();
	}
	
	private void initComponents()
	{
		toolBar = new ToolBar();
		getHeader().add(toolBar, BorderLayout.EAST);
		
		FullScreenSupport fullScreenSupport = new FullScreenSupport(this);
		FullScreenRegister fullScreenRegister = new FullScreenRegister(fullScreenSupport);
		fullScreenRegister.register(getHeaderContainer());
		fullScreenRegister.register(getToolBar().getMaximizeButton());
	}
	
	public ToolBar getToolBar()
	{
		return toolBar;
	}
	
	public class ToolBar
		extends JPanel
	{
		private JBasicButton maximizeButton;
		
		public ToolBar()
		{
			maximizeButton = FullScreenConstants.createMaximizeButton(false);
			add(maximizeButton);
			
			add(Box.createHorizontalStrut(1));
			
			ButtonManager.updateUI(this, new Dimension(20, 20), true);
			
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			setOpaque(false);
		}
		
		public JBasicButton getMaximizeButton()
		{
			return maximizeButton;
		}
	}
}