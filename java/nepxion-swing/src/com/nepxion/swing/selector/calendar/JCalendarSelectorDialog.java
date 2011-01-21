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

public abstract class JCalendarSelectorDialog
	extends JBasicDialog implements ICalendarSelectorComponent
{
	private OptionButtonPanel optionButtonPanel;
	private JCalendarSelector calendarSelector;
	private JPanel layoutPanel;
	
	public JCalendarSelectorDialog(Frame owner, JCalendarSelector calendarSelector)
	{
		this(owner, calendarSelector, true);		
	}
	
	public JCalendarSelectorDialog(Dialog owner, JCalendarSelector calendarSelector)
	{
		this(owner, calendarSelector, true);
	}
	
	public JCalendarSelectorDialog(Frame owner, JCalendarSelector calendarSelector, boolean modal)
	{
		this(owner, calendarSelector, modal, false);
	}
	
	public JCalendarSelectorDialog(Dialog owner, JCalendarSelector calendarSelector, boolean modal)
	{
		this(owner, calendarSelector, modal, false);
	}
	
	public JCalendarSelectorDialog(Frame owner, JCalendarSelector calendarSelector, boolean modal, boolean isHint)
	{
		super(owner, SwingLocale.getString("calendar_selector"), new Dimension(330, 290), modal, isHint, false);
		
		this.calendarSelector = calendarSelector;
		
		initComponents();
	}
	
	public JCalendarSelectorDialog(Dialog owner, JCalendarSelector calendarSelector, boolean modal, boolean isHint)
	{
		super(owner, SwingLocale.getString("calendar_selector"), new Dimension(330, 290), modal, isHint, false);
		
		this.calendarSelector = calendarSelector;
		
		initComponents();
	}
	
	private void initComponents()
	{		
		layoutPanel = new JPanel();
		layoutPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		layoutPanel.add(calendarSelector);
		
		optionButtonPanel = new OptionButtonPanel();
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(layoutPanel, BorderLayout.CENTER);
		getContentPane().add(optionButtonPanel, BorderLayout.SOUTH);
	}
	
	public JCalendarSelector getCalendarSelector()
	{
		return calendarSelector;
	}
	
	public void setCalendarSelector(JCalendarSelector calendarSelector)
	{
		this.calendarSelector = calendarSelector;
	
		layoutPanel.removeAll();
		layoutPanel.add(calendarSelector);
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
			return JCalendarSelectorDialog.this.confirm();
		}
		
		public boolean cancel()
		{
			return JCalendarSelectorDialog.this.cancel();
		}
	}
	
	public abstract boolean confirm();
	
	public abstract boolean cancel();
}