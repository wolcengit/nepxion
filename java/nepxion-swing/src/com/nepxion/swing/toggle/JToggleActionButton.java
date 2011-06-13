package com.nepxion.swing.toggle;

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
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import com.nepxion.swing.button.JBasicToggleButton;

public class JToggleActionButton
	extends JBasicToggleButton implements SwingConstants
{
	/**
	 * The instance of JToggleContentPanel.
	 */
	private JToggleContentPanel toggleContentPanel;
	
	/**
	 * The instance of ITogglePanel.
	 */
	private ITogglePanel togglePanel;
	
	/**
	 * Constructs with the specified initial toggle content panel and toggle panel.
	 * @param toggleContentPanel the instance of JToggleContentPanel
	 * @param togglePanel the instance of ITogglePanel
	 */
	public JToggleActionButton(JToggleContentPanel toggleContentPanel, ITogglePanel togglePanel)
	{
		this.toggleContentPanel = toggleContentPanel;
		
		addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				toggle();
			}
		}
		);
		
		setTogglePanel(togglePanel);
		setEnabled(togglePanel.isEnabled());
	}
	
	/**
	 * Gets the toggle content panel.
	 * @return the instance of JToggleContentPanel
	 */
	public JToggleContentPanel getToggleContentPanel()
	{
		return toggleContentPanel;
	}
	
	/**
	 * Sets the toggle content panel.
	 * @param toggleContentPanel the instance of JToggleContentPanel
	 */
	public void setToggleContentPanel(JToggleContentPanel toggleContentPanel)
	{
		this.toggleContentPanel = toggleContentPanel;
	}
	
	/**
	 * Gets the toggle panel.
	 * @return the instance of ITogglePanel
	 */
	public ITogglePanel getTogglePanel()
	{
		return togglePanel;
	}
	
	/**
	 * Sets the toggle panel.
	 * @param togglePanel the instance of ITogglePanel
	 */
	public void setTogglePanel(ITogglePanel togglePanel)
	{
		this.togglePanel = togglePanel;
		
		setText(togglePanel.getToggleText());
		
		if (togglePanel.getToggleIcon() != null)
		{
			setIcon(togglePanel.getToggleIcon());
		}
		else if (togglePanel.getToggleBannerIcon() != null)
		{
			setIcon(togglePanel.getToggleBannerIcon());
		}
		
		setToolTipText(togglePanel.getToggleDescription());
	}
	
	/**
	 * Toggles.
	 */
	public void toggle()
	{
		toggleContentPanel.toggle(togglePanel);
	}
}