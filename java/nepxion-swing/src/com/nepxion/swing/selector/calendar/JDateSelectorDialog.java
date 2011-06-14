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
	/**
	 * The instance of OptionButtonPanel.
	 */
	private OptionButtonPanel optionButtonPanel;
	
	/**
	 * The instance of JDateSelector.
	 */
	private JDateSelector dateSelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial frame and date selector.
	 * @param owner the instance of Frame
	 * @param dateSelector the instance of JDateSelector
	 */
	public JDateSelectorDialog(Frame owner, JDateSelector dateSelector)
	{
		this(owner, dateSelector, true);
	}
	
	/**
	 * Constructs with the specified initial dialog and date selector.
	 * @param owner the instance of Dialog
	 * @param dateSelector the instance of JDateSelector
	 */
	public JDateSelectorDialog(Dialog owner, JDateSelector dateSelector)
	{
		this(owner, dateSelector, true);
	}
	
	/**
	 * Constructs with the specified initial frame, date selector and modal.
	 * @param owner the instance of Frame
	 * @param dateSelector the instance of JDateSelector
	 * @param modal the boolean value of modal
	 */
	public JDateSelectorDialog(Frame owner, JDateSelector dateSelector, boolean modal)
	{
		this(owner, dateSelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial dialog, date selector and modal.
	 * @param owner the instance of Dialog
	 * @param dateSelector the instance of JDateSelector
	 * @param modal the boolean value of modal
	 */
	public JDateSelectorDialog(Dialog owner, JDateSelector dateSelector, boolean modal)
	{
		this(owner, dateSelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial frame, date selector, modal and hint.
	 * @param owner the instance of Frame
	 * @param dateSelector the instance of JDateSelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JDateSelectorDialog(Frame owner, JDateSelector dateSelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("date_selector"), new Dimension(200, 115), modal, hint, false);
		
		this.dateSelector = dateSelector;
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial dialog, date selector, modal and hint.
	 * @param owner the instance of Dialog
	 * @param dateSelector the instance of JDateSelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JDateSelectorDialog(Dialog owner, JDateSelector dateSelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("date_selector"), new Dimension(200, 115), modal, hint, false);
		
		this.dateSelector = dateSelector;
		
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
		layoutPanel.add(dateSelector, BorderLayout.NORTH);
		
		optionButtonPanel = new OptionButtonPanel();
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(layoutPanel, BorderLayout.CENTER);
		getContentPane().add(optionButtonPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Gets the date selector.
	 * @return the instance of JDateSelector
	 */
	public JDateSelector getDateSelector()
	{
		return dateSelector;
	}
	
	/**
	 * Sets the date selector.
	 * @param dateSelector the instance of JDateSelector
	 */
	public void setDateSelector(JDateSelector dateSelector)
	{
		this.dateSelector = dateSelector;
		
		layoutPanel.removeAll();
		layoutPanel.add(dateSelector, BorderLayout.NORTH);
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
			return JDateSelectorDialog.this.confirm();
		}
		
		/**
		 * Returns true if it is cancelled.
		 * @return true if it is cancelled.
		 */
		public boolean cancel()
		{
			return JDateSelectorDialog.this.cancel();
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