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
	private JToggleContentPanel toggleContentPanel;
	private ITogglePanel togglePanel;
	
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
	
	public JToggleContentPanel getToggleContentPanel()
	{
		return toggleContentPanel;
	}
	
	public void setToggleContentPanel(JToggleContentPanel toggleContentPanel)
	{
		this.toggleContentPanel = toggleContentPanel;
	}
	
	public ITogglePanel getTogglePanel()
	{
		return togglePanel;
	}
	
	public void setTogglePanel(ITogglePanel togglePanel)
	{
		this.togglePanel = togglePanel;
		
		setText(togglePanel.getToggleName());
		
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
	
	public void toggle()
	{
		toggleContentPanel.toggle(togglePanel);
	}
}