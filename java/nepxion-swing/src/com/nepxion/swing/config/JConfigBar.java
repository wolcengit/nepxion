package com.nepxion.swing.config;

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
import java.awt.Container;
import java.awt.Dimension;
import java.util.Enumeration;

import javax.swing.JPanel;

import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.toggle.ITogglePanel;
import com.nepxion.swing.toggle.JToggleActionButton;

public class JConfigBar
	extends JPanel
{
	private JConfigButtonBar configButtonBar;
	private JConfigContentPanel configContentPanel;
	
	public JConfigBar()
	{
		configButtonBar = new JConfigButtonBar();
		configContentPanel = new JConfigContentPanel();
		
		setLayout(new BorderLayout(10, 0));
		add(new JBasicScrollPane(configButtonBar), BorderLayout.WEST);
		add(configContentPanel, BorderLayout.CENTER);
		
		setConfigButtonBarWidth(80);
		setConfigContentPanelWidth(480);
		setHeight(480);
	}
	
	public void setConfigButtonBarWidth(int configButtonBarWidth)
	{
		Container configButtonBarContainer = configButtonBar.getParent();
		configButtonBarContainer.setPreferredSize(new Dimension(configButtonBarWidth, configButtonBarContainer.getPreferredSize().height));
	}
	
	public void setConfigContentPanelWidth(int configContentPanelWidth)
	{
		configContentPanel.setPreferredSize(new Dimension(configContentPanelWidth, configContentPanel.getPreferredSize().height));
	}
	
	public void setHeight(int height)
	{
		setPreferredSize(new Dimension(getPreferredSize().width, height));
	}
	
	public JConfigButtonBar getConfigButtonBar()
	{
		return configButtonBar;
	}
	
	public JConfigContentPanel getConfigContentPanel()
	{
		return configContentPanel;
	}
	
	public ITogglePanel getTogglePanel(String toggleName)
	{
		for (Enumeration enumeration = configButtonBar.getButtonGroup().getElements(); enumeration.hasMoreElements();)
		{
			JToggleActionButton toggleActionButton = (JToggleActionButton) enumeration.nextElement();
			ITogglePanel togglePanel = toggleActionButton.getTogglePanel();
			if (togglePanel.getToggleName().equals(toggleName))
			{
				return togglePanel;
			}
		}
		
		return null;
	}
	
	public JToggleActionButton getToggleActionButton(ITogglePanel togglePanel)
	{
		for (Enumeration enumeration = configButtonBar.getButtonGroup().getElements(); enumeration.hasMoreElements();)
		{
			JToggleActionButton toggleActionButton = (JToggleActionButton) enumeration.nextElement();
			if (toggleActionButton.getTogglePanel() == togglePanel)
			{
				return toggleActionButton;
			}
		}
		
		return null;
	}
	
	public void addTogglePanel(ITogglePanel togglePanel)
	{
		JToggleActionButton toggleActionButton = new JToggleActionButton(configContentPanel, togglePanel);
		configButtonBar.addButton(toggleActionButton);
	}
	
	public void removeTogglePanel(ITogglePanel togglePanel)
	{
		JToggleActionButton toggleActionButton = getToggleActionButton(togglePanel);
		configButtonBar.removeButton(toggleActionButton);
	}
	
	public void setSelectionTogglePanel(ITogglePanel togglePanel)
	{
		for (Enumeration enumeration = configButtonBar.getButtonGroup().getElements(); enumeration.hasMoreElements();)
		{
			JToggleActionButton toggleActionButton = (JToggleActionButton) enumeration.nextElement();
			if (toggleActionButton.getTogglePanel() == togglePanel)
			{
				toggleActionButton.doClick();
				
				return;
			}
		}
	}
	
	public void setSelectionTogglePanel(int index)
	{
		if (index < 0 || index > configButtonBar.getButtonGroup().getButtonCount() - 1)
		{
			return;
		}
		
		int togglePanelIndex = 0;
		for (Enumeration enumeration = configButtonBar.getButtonGroup().getElements(); enumeration.hasMoreElements();)
		{
			JToggleActionButton toggleActionButton = (JToggleActionButton) enumeration.nextElement();
			if (togglePanelIndex == index)
			{
				toggleActionButton.doClick();
				
				return;
			}
			togglePanelIndex++;
		}
	}
}