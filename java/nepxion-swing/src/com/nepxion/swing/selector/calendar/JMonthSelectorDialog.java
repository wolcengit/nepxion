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
	/**
	 * The instance of OptionButtonPanel.
	 */
	private OptionButtonPanel optionButtonPanel;
	
	/**
	 * The instance of JMonthSelector.
	 */
	private JMonthSelector monthSelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial frame and time selector.
	 * @param owner the instance of Frame
	 * @param monthSelector the instance of JMonthSelector
	 */
	public JMonthSelectorDialog(Frame owner, JMonthSelector monthSelector)
	{
		this(owner, monthSelector, true);
	}
	
	/**
	 * Constructs with the specified initial dialog and time selector.
	 * @param owner the instance of Dialog
	 * @param monthSelector the instance of JMonthSelector
	 */
	public JMonthSelectorDialog(Dialog owner, JMonthSelector monthSelector)
	{
		this(owner, monthSelector, true);
	}
	
	/**
	 * Constructs with the specified initial frame, time selector and modal.
	 * @param owner the instance of Frame
	 * @param monthSelector the instance of JMonthSelector
	 * @param modal the boolean value of modal
	 */
	public JMonthSelectorDialog(Frame owner, JMonthSelector monthSelector, boolean modal)
	{
		this(owner, monthSelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial dialog, time selector and modal.
	 * @param owner the instance of Dialog
	 * @param monthSelector the instance of JMonthSelector
	 * @param modal the boolean value of modal
	 */
	public JMonthSelectorDialog(Dialog owner, JMonthSelector monthSelector, boolean modal)
	{
		this(owner, monthSelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial frame, time selector, modal and hint.
	 * @param owner the instance of Frame
	 * @param monthSelector the instance of JMonthSelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JMonthSelectorDialog(Frame owner, JMonthSelector monthSelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("month_selector"), new Dimension(200, 115), modal, hint, false);
		
		this.monthSelector = monthSelector;
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial dialog, time selector, modal and hint.
	 * @param owner the instance of Dialog
	 * @param monthSelector the instance of JMonthSelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JMonthSelectorDialog(Dialog owner, JMonthSelector monthSelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("month_selector"), new Dimension(200, 115), modal, hint, false);
		
		this.monthSelector = monthSelector;
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
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
	
	/**
	 * Gets the month selector.
	 * @return the instance of JMonthSelector
	 */
	public JMonthSelector getMonthSelector()
	{
		return monthSelector;
	}
	
	/**
	 * Sets the month selector.
	 * @param monthSelector the instance of JMonthSelector
	 */
	public void setMonthSelector(JMonthSelector monthSelector)
	{
		this.monthSelector = monthSelector;
		
		layoutPanel.removeAll();
		layoutPanel.add(monthSelector, BorderLayout.NORTH);
	}
	
	public class OptionButtonPanel
		extends JOptionButtonPanel
	{
		/**
		 * Constructs with the default.
		 */
		public OptionButtonPanel()
		{
			super(YES_NO_OPTION);
			
			setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		}
		
		/**
		 * Returns true if it is confirmed.
		 * @return true if it is confirmed
		 */
		public boolean confirm()
		{
			return JMonthSelectorDialog.this.confirm();
		}
		
		/**
		 * Returns true if it is cancelled.
		 * @return true if it is cancelled.
		 */
		public boolean cancel()
		{
			return JMonthSelectorDialog.this.cancel();
		}
	}
	
	/**
	 * Returns true if it is confirmed.
	 * @return true if it is confirmed
	 */
	public abstract boolean confirm();
	
	/**
	 * Returns true if it is cancelled.
	 * @return true if it is cancelled.
	 */
	public abstract boolean cancel();
}