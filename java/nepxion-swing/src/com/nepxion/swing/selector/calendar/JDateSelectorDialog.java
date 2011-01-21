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

public abstract class JDateSelectorDialog
	extends JBasicDialog implements IDateSelectorComponent
{
	private OptionButtonPanel optionButtonPanel;
	private JDateSelector dateSelector;
	private JPanel layoutPanel;
	
	public JDateSelectorDialog(Frame owner, JDateSelector dateSelector)
	{
		this(owner, dateSelector, true);
	}
	
	public JDateSelectorDialog(Dialog owner, JDateSelector dateSelector)
	{
		this(owner, dateSelector, true);
	}
	
	public JDateSelectorDialog(Frame owner, JDateSelector dateSelector, boolean modal)
	{
		this(owner, dateSelector, modal, false);
	}
	
	public JDateSelectorDialog(Dialog owner, JDateSelector dateSelector, boolean modal)
	{
		this(owner, dateSelector, modal, false);
	}
	
	public JDateSelectorDialog(Frame owner, JDateSelector dateSelector, boolean modal, boolean isHint)
	{
		super(owner, SwingLocale.getString("date_selector"), new Dimension(200, 110), modal, isHint, false);
		
		this.dateSelector = dateSelector;
		
		initComponents();
	}
	
	public JDateSelectorDialog(Dialog owner, JDateSelector dateSelector, boolean modal, boolean isHint)
	{
		super(owner, SwingLocale.getString("date_selector"), new Dimension(200, 110), modal, isHint, false);
		
		this.dateSelector = dateSelector;
		
		initComponents();
	}
	
	private void initComponents()
	{		
		layoutPanel = new JPanel();
		layoutPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		layoutPanel.setLayout(new BorderLayout());
		layoutPanel.add(dateSelector, BorderLayout.NORTH);
		
		optionButtonPanel = new OptionButtonPanel();
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(layoutPanel, BorderLayout.CENTER);
		getContentPane().add(optionButtonPanel, BorderLayout.SOUTH);
	}
	
	public JDateSelector getDateSelector()
	{
		return dateSelector;
	}
	
	public void setDateSelector(JDateSelector dateSelector)
	{
		this.dateSelector = dateSelector;
		
		layoutPanel.removeAll();
		layoutPanel.add(dateSelector, BorderLayout.NORTH);
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
			return JDateSelectorDialog.this.confirm();
		}
		
		public boolean cancel()
		{
			return JDateSelectorDialog.this.cancel();
		}
	}
	
	public abstract boolean confirm();
	
	public abstract boolean cancel();
}