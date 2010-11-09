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

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.nepxion.swing.container.JContainer;
import com.nepxion.swing.panel.decoration.JDecorationHeader;

public class JToggleContentPanel
	extends JPanel
{
	private JContainer container;
	private JDecorationHeader header;
	private JPanel bannerPanel;
	
	public JToggleContentPanel()
	{
		this(false);
	}
	
	public JToggleContentPanel(boolean isHeaderDecorated)
	{
		header = new JDecorationHeader();
		if (!isHeaderDecorated)
		{	
			header.setGradientColor(UIManager.getColor("Panel.background"));
			header.setBackground(UIManager.getColor("Panel.background"));
			header.getLabel().setForeground(Color.black);
		}
		
		bannerPanel = new JPanel();
		bannerPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		bannerPanel.setLayout(new BorderLayout());
		bannerPanel.add(header, BorderLayout.CENTER);
		
		container = new JContainer();
		container.setLayout(new BorderLayout());
		
		setLayout(new BorderLayout());
		add(bannerPanel, BorderLayout.NORTH);
		add(container, BorderLayout.CENTER);
	}
	
	public JContainer getContainer()
	{
		return container;
	}
	
	public JDecorationHeader getHeader()
	{
		return header;
	}
	
	public JPanel getBannerPanel()
	{
		return bannerPanel;
	}
	
	public void toggle(String title)
	{
		header.setTitle(title);
	}
	
	public void toggle(Icon icon)
	{
		header.setIcon(icon);
	}
	
	public void toggle(String title, Icon icon)
	{
		toggle(title);
		toggle(icon);
	}
	
	public void toggle(ITogglePanel togglePanel)
	{
		toggle(togglePanel.getToggleDescription(), togglePanel.getToggleBannerIcon());
		
		container.addComponent((JPanel) togglePanel, BorderLayout.CENTER);
	}
}