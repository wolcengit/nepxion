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

public abstract class JTimeSelectorDialog
	extends JBasicDialog implements ITimeSelectorComponent
{
	private OptionButtonPanel optionButtonPanel;
	private JTimeSelector timeSelector;
	private JPanel layoutPanel;
	
	public JTimeSelectorDialog(Frame owner, JTimeSelector timeSelector)
	{
		this(owner, timeSelector, true);
	}
	
	public JTimeSelectorDialog(Dialog owner, JTimeSelector timeSelector)
	{
		this(owner, timeSelector, true);
	}
	
	public JTimeSelectorDialog(Frame owner, JTimeSelector timeSelector, boolean modal)
	{
		this(owner, timeSelector, modal, false);
	}
	
	public JTimeSelectorDialog(Dialog owner, JTimeSelector timeSelector, boolean modal)
	{
		this(owner, timeSelector, modal, false);
	}
	
	public JTimeSelectorDialog(Frame owner, JTimeSelector timeSelector, boolean modal, boolean isHint)
	{
		super(owner, SwingLocale.getString("time_selector"), new Dimension(200, 115), modal, isHint, false);
		
		this.timeSelector = timeSelector;
		
		initComponents();
	}
	
	public JTimeSelectorDialog(Dialog owner, JTimeSelector timeSelector, boolean modal, boolean isHint)
	{
		super(owner, SwingLocale.getString("time_selector"), new Dimension(200, 115), modal, isHint, false);
		
		this.timeSelector = timeSelector;
		
		initComponents();
	}
	
	private void initComponents()
	{		
		layoutPanel = new JPanel();
		layoutPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(timeSelector, BorderLayout.NORTH);
		
		optionButtonPanel = new OptionButtonPanel();
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(layoutPanel, BorderLayout.CENTER);
		getContentPane().add(optionButtonPanel, BorderLayout.SOUTH);
	}
	
	public JTimeSelector getTimeSelector()
	{
		return timeSelector;
	}
	
	public void setTimeSelector(JTimeSelector timeSelector)
	{
		this.timeSelector = timeSelector;
		
		layoutPanel.removeAll();
		layoutPanel.add(timeSelector, BorderLayout.NORTH);
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
			return JTimeSelectorDialog.this.confirm();
		}
		
		public boolean cancel()
		{
			return JTimeSelectorDialog.this.cancel();
		}
	}
	
	public abstract boolean confirm();
	
	public abstract boolean cancel();
}