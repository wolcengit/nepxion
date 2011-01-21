package com.nepxion.swing.selector.calendar;

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

public abstract class JMonthSelectorDialog
	extends JBasicDialog implements IMonthSelectorComponent
{
	private OptionButtonPanel optionButtonPanel;
	private JMonthSelector monthSelector;
	private JPanel layoutPanel;
	
	public JMonthSelectorDialog(Frame owner, JMonthSelector monthSelector)
	{
		this(owner, monthSelector, true);
	}
	
	public JMonthSelectorDialog(Dialog owner, JMonthSelector monthSelector)
	{
		this(owner, monthSelector, true);
	}
	
	public JMonthSelectorDialog(Frame owner, JMonthSelector monthSelector, boolean modal)
	{
		this(owner, monthSelector, modal, false);
	}
	
	public JMonthSelectorDialog(Dialog owner, JMonthSelector monthSelector, boolean modal)
	{
		this(owner, monthSelector, modal, false);
	}
	
	public JMonthSelectorDialog(Frame owner, JMonthSelector monthSelector, boolean modal, boolean isHint)
	{
		super(owner, SwingLocale.getString("month_selector"), new Dimension(198, 108), modal, isHint, false);
		
		this.monthSelector = monthSelector;
		
		initComponents();
	}
	
	public JMonthSelectorDialog(Dialog owner, JMonthSelector monthSelector, boolean modal, boolean isHint)
	{
		super(owner, SwingLocale.getString("month_selector"), new Dimension(198, 108), modal, isHint, false);
		
		this.monthSelector = monthSelector;
		
		initComponents();
	}
	
	private void initComponents()
	{
		layoutPanel = new JPanel();
		layoutPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(monthSelector, BorderLayout.NORTH);
		
		optionButtonPanel = new OptionButtonPanel();
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(layoutPanel, BorderLayout.CENTER);
		getContentPane().add(optionButtonPanel, BorderLayout.SOUTH);
	}
	
	public JMonthSelector getMonthSelector()
	{
		return monthSelector;
	}
	
	public void setMonthSelector(JMonthSelector monthSelector)
	{
		this.monthSelector = monthSelector;
		
		layoutPanel.removeAll();
		layoutPanel.add(monthSelector, BorderLayout.NORTH);
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
			return JMonthSelectorDialog.this.confirm();
		}
		
		public boolean cancel()
		{
			return JMonthSelectorDialog.this.cancel();
		}
	}
	
	public abstract boolean confirm();
	
	public abstract boolean cancel();
}