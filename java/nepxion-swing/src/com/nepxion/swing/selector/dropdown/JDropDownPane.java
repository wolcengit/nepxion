package com.nepxion.swing.selector.dropdown;

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

import com.nepxion.swing.panel.option.JOptionButtonPanel;

public abstract class JDropDownPane
	extends JAbstractDropDownPane
{
	private Component contentPane;
	private OptionButtonPanel optionButtonPanel;
	
	public JDropDownPane(final IDropDownPopupMenu popupMenu, Component contentPane)
	{
		super(popupMenu);
		
		optionButtonPanel = new OptionButtonPanel();
		
		setLayout(new BorderLayout());
		add(contentPane, BorderLayout.CENTER);
		add(optionButtonPanel, BorderLayout.SOUTH);
	}
	
	public Component getContentPane()
	{
		return contentPane;
	}
	
	public OptionButtonPanel getOptionButtonPanel()
	{
		return optionButtonPanel;
	}
	
	public void showPopupMenu()
	{
		getPopupMenu().showPopupMenu();
	}
	
	public void hidePopupMenu()
	{
		getPopupMenu().hidePopupMenu();
	}
	
	public class OptionButtonPanel
		extends JOptionButtonPanel
	{
		public OptionButtonPanel()
		{
			super(YES_NO_OPTION);
		}
		
		public void doConfirm()
		{
			if (confirm())
			{
				getPopupMenu().adaptVisibility();
			}
		}
		
		public void doCancel()
		{
			if (cancel())
			{
				getPopupMenu().adaptVisibility();
			}
		}
		
		public boolean confirm()
		{
			return JDropDownPane.this.confirm();
		}
		
		public boolean cancel()
		{
			return JDropDownPane.this.cancel();
		}
	}
	
	public abstract boolean confirm();
	
	public abstract boolean cancel();
}