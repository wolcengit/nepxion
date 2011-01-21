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

public abstract class JDaySelectorDialog
	extends JBasicDialog implements IDaySelectorComponent
{
	private OptionButtonPanel optionButtonPanel;
	private JDaySelector daySelector;
	private JPanel layoutPanel;
	
	public JDaySelectorDialog(Frame owner, JDaySelector daySelector)
	{
		this(owner, daySelector, true);
	}
	
	public JDaySelectorDialog(Dialog owner, JDaySelector daySelector)
	{
		this(owner, daySelector, true);
	}
	
	public JDaySelectorDialog(Frame owner, JDaySelector daySelector, boolean modal)
	{
		this(owner, daySelector, modal, false);
	}
	
	public JDaySelectorDialog(Dialog owner, JDaySelector daySelector, boolean modal)
	{
		this(owner, daySelector, modal, false);
	}
	
	public JDaySelectorDialog(Frame owner, JDaySelector daySelector, boolean modal, boolean isHint)
	{
		super(owner, SwingLocale.getString("day_selector"), new Dimension(330, 244), modal, isHint, false);
		
		this.daySelector = daySelector;
		
		initComponents();
	}
	
	public JDaySelectorDialog(Dialog owner, JDaySelector daySelector, boolean modal, boolean isHint)
	{
		super(owner, SwingLocale.getString("day_selector"), new Dimension(330, 244), modal, isHint, false);
		
		this.daySelector = daySelector;
		
		initComponents();
	}
	
	private void initComponents()
	{		
		layoutPanel = new JPanel();
		layoutPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(daySelector, BorderLayout.NORTH);
		
		optionButtonPanel = new OptionButtonPanel();
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(layoutPanel, BorderLayout.CENTER);
		getContentPane().add(optionButtonPanel, BorderLayout.SOUTH);
	}
	
	public JDaySelector getDaySelector()
	{
		return daySelector;
	}
	
	public void setDaySelector(JDaySelector daySelector)
	{
		this.daySelector = daySelector;
		
		layoutPanel.removeAll();
		layoutPanel.add(daySelector, BorderLayout.NORTH);
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
			return JDaySelectorDialog.this.confirm();
		}
		
		public boolean cancel()
		{
			return JDaySelectorDialog.this.cancel();
		}
	}
	
	public abstract boolean confirm();
	
	public abstract boolean cancel();
}