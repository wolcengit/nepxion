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

public abstract class JDateTimeSelectorDialog
	extends JBasicDialog implements IDateTimeSelectorComponent
{
	private OptionButtonPanel optionButtonPanel;
	private JDateTimeSelector dateTimeSelector;
	private JPanel layoutPanel;
	
	public JDateTimeSelectorDialog(Frame owner, JDateTimeSelector dateTimeSelector)
	{
		this(owner, dateTimeSelector, true);
	}
	
	public JDateTimeSelectorDialog(Dialog owner, JDateTimeSelector dateTimeSelector)
	{
		this(owner, dateTimeSelector, true);
	}
	
	public JDateTimeSelectorDialog(Frame owner, JDateTimeSelector dateTimeSelector, boolean modal)
	{
		this(owner, dateTimeSelector, modal, false);
	}
	
	public JDateTimeSelectorDialog(Dialog owner, JDateTimeSelector dateTimeSelector, boolean modal)
	{
		this(owner, dateTimeSelector, modal, false);
	}
	
	public JDateTimeSelectorDialog(Frame owner, JDateTimeSelector dateTimeSelector, boolean modal, boolean isHint)
	{
		super(owner, SwingLocale.getString("date_time_selector"), new Dimension(200, 115), modal, isHint, false);
		
		this.dateTimeSelector = dateTimeSelector;
		
		initComponents();
	}
	
	public JDateTimeSelectorDialog(Dialog owner, JDateTimeSelector dateTimeSelector, boolean modal, boolean isHint)
	{
		super(owner, SwingLocale.getString("date_time_selector"), new Dimension(200, 115), modal, isHint, false);
		
		this.dateTimeSelector = dateTimeSelector;
		
		initComponents();
	}
	
	private void initComponents()
	{		
		layoutPanel = new JPanel();
		layoutPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(dateTimeSelector, BorderLayout.NORTH);
		
		optionButtonPanel = new OptionButtonPanel();
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(layoutPanel, BorderLayout.CENTER);
		getContentPane().add(optionButtonPanel, BorderLayout.SOUTH);
	}
	
	public JDateTimeSelector getDateTimeSelector()
	{
		return dateTimeSelector;
	}
	
	public void setDateTimeSelector(JDateTimeSelector dateTimeSelector)
	{
		this.dateTimeSelector = dateTimeSelector;
		
		layoutPanel.removeAll();
		layoutPanel.add(dateTimeSelector, BorderLayout.NORTH);
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
			return JDateTimeSelectorDialog.this.confirm();
		}
		
		public boolean cancel()
		{
			return JDateTimeSelectorDialog.this.cancel();
		}
	}
	
	public abstract boolean confirm();
	
	public abstract boolean cancel();
}