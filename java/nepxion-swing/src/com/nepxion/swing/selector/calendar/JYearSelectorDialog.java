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
	/**
	 * The instance of OptionButtonPanel.
	 */
	private OptionButtonPanel optionButtonPanel;
	
	/**
	 * The instance of JYearSelector.
	 */
	private JYearSelector yearSelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial frame and year selector.
	 * @param owner the instance of Frame
	 * @param yearSelector the instance of JYearSelector
	 */
	public JYearSelectorDialog(Frame owner, JYearSelector yearSelector)
	{
		this(owner, yearSelector, true);
	}
	
	/**
	 * Constructs with the specified initial dialog and year selector.
	 * @param owner the instance of Dialog
	 * @param yearSelector the instance of JYearSelector
	 */
	public JYearSelectorDialog(Dialog owner, JYearSelector yearSelector)
	{
		this(owner, yearSelector, true);
	}
	
	/**
	 * Constructs with the specified initial frame, year selector and modal.
	 * @param owner the instance of Frame
	 * @param yearSelector the instance of JYearSelector
	 * @param modal the boolean value of modal
	 */
	public JYearSelectorDialog(Frame owner, JYearSelector yearSelector, boolean modal)
	{
		this(owner, yearSelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial dialog, year selector and modal.
	 * @param owner the instance of Dialog
	 * @param yearSelector the instance of JYearSelector
	 * @param modal the boolean value of modal
	 */
	public JYearSelectorDialog(Dialog owner, JYearSelector yearSelector, boolean modal)
	{
		this(owner, yearSelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial frame, year selector, modal and hint.
	 * @param owner the instance of Frame
	 * @param yearSelector the instance of JYearSelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JYearSelectorDialog(Frame owner, JYearSelector yearSelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("year_selector"), new Dimension(200, 115), modal, hint, false);
		
		this.yearSelector = yearSelector;
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial dialog, year selector, modal and hint.
	 * @param owner the instance of Dialog
	 * @param yearSelector the instance of JYearSelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JYearSelectorDialog(Dialog owner, JYearSelector yearSelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("year_selector"), new Dimension(200, 115), modal, hint, false);
		
		this.yearSelector = yearSelector;
		
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
		layoutPanel.add(yearSelector, BorderLayout.NORTH);
		
		optionButtonPanel = new OptionButtonPanel();
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(layoutPanel, BorderLayout.CENTER);
		getContentPane().add(optionButtonPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Gets the year selector.
	 * @return the instance of JYearSelector
	 */
	public JYearSelector getYearSelector()
	{
		return yearSelector;
	}
	
	/**
	 * Sets the year selector.
	 * @param yearSelector the instance of JYearSelector
	 */
	public void setYearSelector(JYearSelector yearSelector)
	{
		this.yearSelector = yearSelector;
		
		layoutPanel.removeAll();
		layoutPanel.add(yearSelector, BorderLayout.NORTH);
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
			return JYearSelectorDialog.this.confirm();
		}
		
		/**
		 * Returns true if it is cancelled.
		 * @return true if it is cancelled.
		 */
		public boolean cancel()
		{
			return JYearSelectorDialog.this.cancel();
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