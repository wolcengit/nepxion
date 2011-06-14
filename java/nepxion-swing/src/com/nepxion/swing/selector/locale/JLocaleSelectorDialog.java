package com.nepxion.swing.selector.locale;

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

public abstract class JLocaleSelectorDialog
	extends JBasicDialog implements ILocaleSelectorComponent
{
	/**
	 * The instance of OptionButtonPanel.
	 */
	private OptionButtonPanel optionButtonPanel;
	
	/**
	 * The instance of JLocaleSelector.
	 */
	private JLocaleSelector localeSelector;
	
	/**
	 * The layout panel.
	 */
	private JPanel layoutPanel;
	
	/**
	 * Constructs with the specified initial frame and locale selector.
	 * @param owner the instance of Frame
	 * @param localeSelector the instance of JLocaleSelector
	 */
	public JLocaleSelectorDialog(Frame owner, JLocaleSelector localeSelector)
	{
		this(owner, localeSelector, true);
	}
	
	/**
	 * Constructs with the specified initial dialog and locale selector.
	 * @param owner the instance of Dialog
	 * @param localeSelector the instance of JLocaleSelector
	 */
	public JLocaleSelectorDialog(Dialog owner, JLocaleSelector localeSelector)
	{
		this(owner, localeSelector, true);
	}
	
	/**
	 * Constructs with the specified initial frame, locale selector and modal.
	 * @param owner the instance of Frame
	 * @param localeSelector the instance of JLocaleSelector
	 * @param modal the boolean value of modal
	 */
	public JLocaleSelectorDialog(Frame owner, JLocaleSelector localeSelector, boolean modal)
	{
		this(owner, localeSelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial dialog, locale selector and modal.
	 * @param owner the instance of Dialog
	 * @param localeSelector the instance of JLocaleSelector
	 * @param modal the boolean value of modal
	 */
	public JLocaleSelectorDialog(Dialog owner, JLocaleSelector localeSelector, boolean modal)
	{
		this(owner, localeSelector, modal, false);
	}
	
	/**
	 * Constructs with the specified initial frame, locale selector, modal and hint.
	 * @param owner the instance of Frame
	 * @param localeSelector the instance of JLocaleSelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JLocaleSelectorDialog(Frame owner, JLocaleSelector localeSelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("locale_selector"), new Dimension(240, 115), modal, hint, false);
		
		this.localeSelector = localeSelector;
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial dialog, locale selector, modal and hint.
	 * @param owner the instance of Dialog
	 * @param localeSelector the instance of JLocaleSelector
	 * @param modal the boolean value of modal
	 * @param hint the boolean value of hint
	 */
	public JLocaleSelectorDialog(Dialog owner, JLocaleSelector localeSelector, boolean modal, boolean hint)
	{
		super(owner, SwingLocale.getString("locale_selector"), new Dimension(240, 115), modal, hint, false);
		
		this.localeSelector = localeSelector;
		
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
		layoutPanel.add(localeSelector, BorderLayout.NORTH);
		
		optionButtonPanel = new OptionButtonPanel();
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(layoutPanel, BorderLayout.CENTER);
		getContentPane().add(optionButtonPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Gets the locale selector.
	 * @return the instance of JLocaleSelector
	 */
	public JLocaleSelector getLocaleSelector()
	{
		return localeSelector;
	}
	
	/**
	 * Sets the locale selector.
	 * @param localeSelector the instance of JLocaleSelector
	 */
	public void setLocaleSelector(JLocaleSelector localeSelector)
	{
		this.localeSelector = localeSelector;
		
		layoutPanel.removeAll();
		layoutPanel.add(localeSelector, BorderLayout.NORTH);
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
			return JLocaleSelectorDialog.this.confirm();
		}
		
		/**
		 * Returns true if it is cancelled.
		 * @return true if it is cancelled.
		 */
		public boolean cancel()
		{
			return JLocaleSelectorDialog.this.cancel();
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