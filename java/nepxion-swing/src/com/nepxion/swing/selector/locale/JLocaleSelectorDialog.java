package com.nepxion.swing.selector.locale;

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
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.nepxion.swing.dialog.JBasicDialog;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.panel.option.JOptionButtonPanel;

public abstract class JLocaleSelectorDialog
	extends JBasicDialog implements ILocaleSelectorComponent
{
	private OptionButtonPanel optionButtonPanel;
	private JLocaleSelector localeSelector;
	private JPanel layoutPanel;
	
	public JLocaleSelectorDialog(Frame owner, JLocaleSelector localeSelector)
	{
		this(owner, localeSelector, true);
	}
	
	public JLocaleSelectorDialog(Dialog owner, JLocaleSelector localeSelector)
	{
		this(owner, localeSelector, true);
	}
	
	public JLocaleSelectorDialog(Frame owner, JLocaleSelector localeSelector, boolean modal)
	{
		this(owner, localeSelector, modal, false);
	}
	
	public JLocaleSelectorDialog(Dialog owner, JLocaleSelector localeSelector, boolean modal)
	{
		this(owner, localeSelector, modal, false);
	}
	
	public JLocaleSelectorDialog(Frame owner, JLocaleSelector localeSelector, boolean modal, boolean isHint)
	{
		super(owner, SwingLocale.getString("locale_selector"), new Dimension(238, 108), modal, isHint, false);
		
		this.localeSelector = localeSelector;
		
		initComponents();
	}
	
	public JLocaleSelectorDialog(Dialog owner, JLocaleSelector localeSelector, boolean modal, boolean isHint)
	{
		super(owner, SwingLocale.getString("locale_selector"), new Dimension(238, 108), modal, isHint, false);
		
		this.localeSelector = localeSelector;
		
		initComponents();
	}
	
	private void initComponents()
	{		
		layoutPanel = new JPanel();
		layoutPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(localeSelector, BorderLayout.NORTH);
		
		optionButtonPanel = new OptionButtonPanel();
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(layoutPanel, BorderLayout.CENTER);
		getContentPane().add(optionButtonPanel, BorderLayout.SOUTH);
	}
	
	public JLocaleSelector getLocaleSelector()
	{
		return localeSelector;
	}
	
	public void setLocaleSelector(JLocaleSelector localeSelector)
	{
		this.localeSelector = localeSelector;
		
		layoutPanel.removeAll();
		layoutPanel.add(localeSelector, BorderLayout.NORTH);
	}
	
	public class OptionButtonPanel
		extends JOptionButtonPanel
	{
		public OptionButtonPanel()
		{
			super(YES_NO_OPTION);
			
			setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		}
		
		public boolean confirm()
		{
			return JLocaleSelectorDialog.this.confirm();
		}
		
		public boolean cancel()
		{
			return JLocaleSelectorDialog.this.cancel();
		}
	}
	
	public abstract boolean confirm();
	
	public abstract boolean cancel();
}