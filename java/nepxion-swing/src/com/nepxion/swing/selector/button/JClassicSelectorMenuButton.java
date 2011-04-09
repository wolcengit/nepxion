package com.nepxion.swing.selector.button;

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
import java.awt.Component;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JPanel;

import com.nepxion.swing.button.JClassicMenuButton;
import com.nepxion.swing.panel.option.JOptionButtonPanel;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;

public abstract class JClassicSelectorMenuButton
	extends JClassicMenuButton
{
	private JPanel container;
	private JOptionButtonPanel optionButtonPanel;
	
	public JClassicSelectorMenuButton()
	{
		super();
		
		initComponents();
	}
	
	public JClassicSelectorMenuButton(Action action)
	{
		super(action);
		
		initComponents();
	}
	
	public JClassicSelectorMenuButton(String text)
	{
		super(text);
		
		initComponents();
	}
	
	public JClassicSelectorMenuButton(Icon icon)
	{
		super(icon);
		
		initComponents();
	}
	
	public JClassicSelectorMenuButton(Icon icon, String toolTipText)
	{
		super(icon, toolTipText);
		
		initComponents();
	}
	
	public JClassicSelectorMenuButton(String text, String toolTipText)
	{
		super(text, toolTipText);
		
		initComponents();
	}
	
	public JClassicSelectorMenuButton(String text, Icon icon)
	{
		super(text, icon);
		
		initComponents();
	}
	
	public JClassicSelectorMenuButton(String text, Icon icon, String toolTipText)
	{
		super(text, icon, toolTipText);
		
		initComponents();
	}
	
	private void initComponents()
	{
		final JDecorationPopupMenu popupMenu = new JDecorationPopupMenu();
		setPopupMenu(popupMenu);
		
		optionButtonPanel = new JOptionButtonPanel(JOptionButtonPanel.YES_NO_OPTION)
		{
			public boolean confirm()
			{
				return JClassicSelectorMenuButton.this.doConfirm();
			}
			
			public boolean cancel()
			{
				return JClassicSelectorMenuButton.this.doCancel();
			}
		};
		
		container = new JPanel();
		container.setLayout(new BorderLayout());
		container.add(optionButtonPanel, BorderLayout.SOUTH);
		
		popupMenu.add(container);
	}
	
	public void setContentPane(Component component)
	{
		container.add(component, BorderLayout.CENTER);
	}
	
	public JOptionButtonPanel getOptionButtonPanel()
	{
		return optionButtonPanel;
	}
	
	public boolean doConfirm()
	{
		if (confirm())
		{
			popupMenu.setVisible(false);
		}
		
		return false;
	}
	
	public boolean doCancel()
	{
		if (cancel())
		{
			popupMenu.setVisible(false);
		}
		
		return false;
	}
	
	public abstract boolean confirm();
	
	public abstract boolean cancel();
}