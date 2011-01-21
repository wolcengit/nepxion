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

public abstract class JYearSelectorDialog
	extends JBasicDialog implements IYearSelectorComponent
{
	private OptionButtonPanel optionButtonPanel;
	private JYearSelector yearSelector;
	private JPanel layoutPanel;
	
	public JYearSelectorDialog(Frame owner, JYearSelector yearSelector)
	{
		this(owner, yearSelector, true);
	}
	
	public JYearSelectorDialog(Dialog owner, JYearSelector yearSelector)
	{
		this(owner, yearSelector, true);
	}
	
	public JYearSelectorDialog(Frame owner, JYearSelector yearSelector, boolean modal)
	{
		this(owner, yearSelector, modal, false);
	}
	
	public JYearSelectorDialog(Dialog owner, JYearSelector yearSelector, boolean modal)
	{
		this(owner, yearSelector, modal, false);
	}
	
	public JYearSelectorDialog(Frame owner, JYearSelector yearSelector, boolean modal, boolean isHint)
	{
		super(owner, SwingLocale.getString("year_selector"), new Dimension(200, 110), modal, isHint, false);
		
		this.yearSelector = yearSelector;
		
		initComponents();
	}
	
	public JYearSelectorDialog(Dialog owner, JYearSelector yearSelector, boolean modal, boolean isHint)
	{
		super(owner, SwingLocale.getString("year_selector"), new Dimension(200, 110), modal, isHint, false);
		
		this.yearSelector = yearSelector;
		
		initComponents();
	}
	
	private void initComponents()
	{
		layoutPanel = new JPanel();
		layoutPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(yearSelector, BorderLayout.NORTH);
		
		optionButtonPanel = new OptionButtonPanel();
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(layoutPanel, BorderLayout.CENTER);
		getContentPane().add(optionButtonPanel, BorderLayout.SOUTH);
	}
	
	public JYearSelector getYearSelector()
	{
		return yearSelector;
	}
	
	public void setYearSelector(JYearSelector yearSelector)
	{
		this.yearSelector = yearSelector;
		
		layoutPanel.removeAll();
		layoutPanel.add(yearSelector, BorderLayout.NORTH);
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
			return JYearSelectorDialog.this.confirm();
		}
		
		public boolean cancel()
		{
			return JYearSelectorDialog.this.cancel();
		}
	}
	
	public abstract boolean confirm();
	
	public abstract boolean cancel();
}