package com.nepxion.swing.dialog;

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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.nepxion.swing.button.JClassicButton;
import com.nepxion.swing.combobox.JBasicComboBox;
import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.exception.ExceptionTracer;
import com.nepxion.swing.font.FontContext;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.renderer.combobox.ElementComboBoxCellRenderer;
import com.nepxion.swing.separator.JBasicSeparator;
import com.nepxion.swing.textfield.JBasicPasswordField;
import com.nepxion.swing.textfield.JBasicTextField;
import com.nepxion.util.locale.LocaleConstants;
import com.nepxion.util.locale.LocaleContext;

public abstract class JLoginDialog
	extends JBasicDialog
{
	/**
	 * The font size value.
	 */
	public static final int FONT_SIZE = 12;
	
	/**
	 * The font style value.
	 */
	public static final int FONT_STYLE = Font.PLAIN;
	
	/**
	 * The etched border.
	 */
	public static final Border ETCHED_BORDER = BorderFactory.createEtchedBorder(Color.white, Color.gray);
	
	/**
	 * The image label.
	 */
	protected JLabel imageLabel;
	
	/**
	 * The account label.
	 */
	protected JLabel accountLabel;
	
	/**
	 * The account text field.
	 */
	protected JBasicTextField accountTextField;
	
	/**
	 * The password label.
	 */
	protected JLabel passwordLabel;
	
	/**
	 * The password filed.
	 */
	protected JBasicPasswordField passwordField;
	
	/**
	 * The locale label.
	 */
	protected JLabel localeLabel;
	
	/**
	 * The locale combo box.
	 */
	protected JBasicComboBox localeComboBox;
	
	/**
	 * The login button.
	 */
	protected JClassicButton loginButton;
	
	/**
	 * The reset button.
	 */
	protected JClassicButton resetButton;
	
	/**
	 * The exit button.
	 */
	protected JClassicButton exitButton;
	
	/**
	 * The content panel.
	 */
	protected JPanel contentPanel;
	
	/**
	 * The editor panel.
	 */
	protected JPanel editorPanel;
	
	/**
	 * The button panel.
	 */
	protected JPanel buttonPanel;
	
	/**
	 * The separator.
	 */
	protected JBasicSeparator separator;
	
	/**
	 * Constructs with the specified title and icon.
	 * @param title the title string
	 * @param icon the instance of Icon
	 */
	public JLoginDialog(String title, Icon icon)
	{
		super((Frame) null, title);
		
		accountLabel = new JLabel();
		accountLabel.setFont(new Font(FontContext.getFontName(), FONT_STYLE, FONT_SIZE));
		
		accountTextField = new JBasicTextField();
		
		passwordLabel = new JLabel();
		passwordLabel.setFont(new Font(FontContext.getFontName(), FONT_STYLE, FONT_SIZE));
		
		passwordField = new JBasicPasswordField();
		
		localeLabel = new JLabel();
		localeLabel.setFont(new Font(FontContext.getFontName(), FONT_STYLE, FONT_SIZE));
		
		localeComboBox = new JBasicComboBox();
		localeComboBox.setRenderer(new ElementComboBoxCellRenderer());
		localeComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int selectedIndex = localeComboBox.getSelectedIndex();
				Locale locale = getSelectedLocale();
				
				initLocale(locale);
				
				localeComboBox.setSelectedIndex(selectedIndex);
			}
		}
		);
		
		double[][] size = 
		{ 
			{80, 180}, 
			{TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}
		};
		
		TableLayout tableLayout = new TableLayout(size);
		tableLayout.setVGap(10);
		
		editorPanel = new JPanel();
		editorPanel.setLayout(tableLayout);
		editorPanel.add(accountLabel, "0, 0");
		editorPanel.add(accountTextField, "1, 0");
		editorPanel.add(passwordLabel, "0, 1");
		editorPanel.add(passwordField, "1, 1");
		editorPanel.add(localeLabel, "0, 2");
		editorPanel.add(localeComboBox, "1, 2");
		
		loginButton = new JClassicButton();
		loginButton.setFont(new Font(FontContext.getFontName(), FONT_STYLE, FONT_SIZE));
		loginButton.setPreferredSize(new Dimension(72, 32));
		loginButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String account = accountTextField.getText().trim();
				String password = passwordField.getPasswordText().trim();				
				Locale locale = getSelectedLocale();
				
				if (account.equals("") || password.equals(""))
				{
					JBasicOptionPane.showMessageDialog(JLoginDialog.this, SwingLocale.getString("login_not_null", locale), SwingLocale.getString("warning", locale), JBasicOptionPane.WARNING_MESSAGE);
					
					return;
				}
				
				boolean flag = true;
				try
				{
					flag = login(account, password, locale);
				}
				catch (Exception ex)
				{
					ExceptionTracer.traceException(JLoginDialog.this, SwingLocale.getString("login_failure_service", locale), ex);
					
					return;
				}
				
				if (flag)
				{
					setVisible(false);
				}	
				else
				{
					JBasicOptionPane.showMessageDialog(JLoginDialog.this, SwingLocale.getString("login_failure_validation", locale), SwingLocale.getString("warning", locale), JBasicOptionPane.WARNING_MESSAGE);
				}
			}
		}
		);
		getRootPane().setDefaultButton(loginButton);
		
		resetButton = new JClassicButton();
		resetButton.setFont(new Font(FontContext.getFontName(), FONT_STYLE, FONT_SIZE));
		resetButton.setPreferredSize(new Dimension(72, 32));
		resetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				accountTextField.setText("");
				passwordField.setText("");
			}
		}
		);
		
		exitButton = new JClassicButton();
		exitButton.setFont(new Font(FontContext.getFontName(), FONT_STYLE, FONT_SIZE));
		exitButton.setPreferredSize(new Dimension(72, 32));
		exitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		}
		);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(Box.createHorizontalGlue());
		buttonPanel.add(loginButton);
		buttonPanel.add(Box.createHorizontalStrut(5));
		buttonPanel.add(resetButton);
		buttonPanel.add(Box.createHorizontalStrut(5));
		buttonPanel.add(exitButton);
		buttonPanel.add(Box.createHorizontalGlue());
		
		separator = new JBasicSeparator(JBasicSeparator.HORIZONTAL, JBasicSeparator.LOWERED_STYLE, 280);
		//separator.setPreferredSize(new Dimension(280, separator.getPreferredSize().height));
		
		imageLabel = new JLabel(icon, JLabel.LEFT);
		imageLabel.setBorder(ETCHED_BORDER);
		
		initContentPanel();
		
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout(20, 0));
		container.setBorder(BorderFactory.createCompoundBorder(ETCHED_BORDER, BorderFactory.createEmptyBorder(20, 20, 20, 20)));
		container.add(imageLabel, BorderLayout.WEST);
		container.add(contentPanel, BorderLayout.CENTER);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(container, BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent winEvent)
			{
				System.exit(0);
			}
		}
		);
		setResizable(false);
		pack();
		
		initLocale(LocaleContext.getLocale());
	}
	
	/**
	 * Initializes the content panel.
	 */
	protected void initContentPanel()
	{
		int margin = (imageLabel.getPreferredSize().height - buttonPanel.getPreferredSize().height - separator.getPreferredSize().height - editorPanel.getPreferredSize().height) / 4;
		
		contentPanel = new JPanel();
		contentPanel.setBorder(BorderFactory.createCompoundBorder(ETCHED_BORDER, BorderFactory.createEmptyBorder(margin, 20, margin, 20)));
		contentPanel.setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.CENTER, margin));
		contentPanel.add(editorPanel);
		contentPanel.add(separator);
		contentPanel.add(buttonPanel);
		
		int indent = contentPanel.getPreferredSize().height - imageLabel.getPreferredSize().height;
		if (indent > 0)
		{	
			
			int totalFixedMargin = margin * 2 - indent;
			int fixedMargin = totalFixedMargin / 2;
			
			contentPanel.setBorder(BorderFactory.createCompoundBorder(ETCHED_BORDER, BorderFactory.createEmptyBorder(fixedMargin, 20, totalFixedMargin - fixedMargin, 20)));
		}
	}
	
	/**
	 * Initializes the locale.
	 * @param locale the instance of Locale
	 */
	protected void initLocale(Locale locale)
	{
		accountLabel.setText(SwingLocale.getString("account", locale) + SwingLocale.getString("colon", locale));
		passwordLabel.setText(SwingLocale.getString("password", locale) + SwingLocale.getString("colon", locale));
		localeLabel.setText(SwingLocale.getString("language", locale) + SwingLocale.getString("colon", locale));
		
		Locale[] locales = LocaleConstants.LOCALE_LIST;
		ElementNode[] elementNodes = new ElementNode[locales.length];
		for (int i = 0; i < locales.length; i++)
		{
			Locale localeEntity = locales[i];
			String localeName = localeEntity.toString().toLowerCase();			
			String text = SwingLocale.getString(localeName, locale);
			Icon icon = IconFactory.getSwingIcon("flag_" + localeName + ".png");
			elementNodes[i] = new ElementNode(text, icon, text, localeEntity);
		}
		localeComboBox.setModel(new DefaultComboBoxModel(elementNodes));
		
		loginButton.setText(SwingLocale.getString("login", locale));
		loginButton.setToolTipText(SwingLocale.getString("login", locale));
		resetButton.setText(SwingLocale.getString("reset", locale));
		resetButton.setToolTipText(SwingLocale.getString("reset", locale));
		exitButton.setText(SwingLocale.getString("exit", locale));
		exitButton.setToolTipText(SwingLocale.getString("exit", locale));
	}
	
	/**
	 * Gets the account.
	 * @return the account string
	 */
	public String getAccount()
	{
		return accountTextField.getText().trim();
	}
	
	/**
	 * Sets the account.
	 * @param account the account string
	 */
	public void setAccount(String account)
	{
		accountTextField.setText(account.trim());
	}
	
	/**
	 * Gets the password.
	 * @return the password string
	 */
	public String getPassword()
	{
		return passwordField.getPasswordText().trim();
	}
	
	/**
	 * Sets the password.
	 * @param password the password string
	 */
	public void setPassword(String password)
	{
		passwordField.setText(password.trim());
	}
	
	/**
	 * Sets the login focus.
	 */
	public void setLoginFocus()
	{
		loginButton.requestFocus();
	}
	
	/**
	 * Gets the the account text field.
	 * @return the instance of JBasicTextField
	 */
	public JBasicTextField getAccountTextField()
	{
		return accountTextField;
	}
	
	/**
	 * Gets the the password field.
	 * @return the instance of JBasicPasswordField
	 */
	public JBasicPasswordField getPasswordField()
	{
		return passwordField;
	}
	
	/**
	 * Gets the locale combo box.
	 * @return the instance of JBasicComboBox
	 */
	public JBasicComboBox getLocaleComboBox()
	{
		return localeComboBox;
	}
	
	/**
	 * Gets the selected locale.
	 * @return the instance of Locale
	 */
	public Locale getSelectedLocale()
	{
		ElementNode selectedElementNode = (ElementNode) localeComboBox.getSelectedItem();
		Locale locale = (Locale) selectedElementNode.getUserObject();
		
		return locale;
	}
	
	/**
	 * Gets the login button.
	 * @return the instance of JClassicButton
	 */
	public JClassicButton getLoginButton()
	{
		return loginButton;
	}
	
	/**
	 * Gets the reset button.
	 * @return the instance of JClassicButton
	 */
	public JClassicButton getResetButton()
	{
		return resetButton;
	}
	
	/**
	 * Gets the exit button.
	 * @return the instance of JClassicButton
	 */
	public JClassicButton getExitButton()
	{
		return exitButton;
	}
	
	/**
	 * Logins by an account, password and locale.
	 * @param account the account string
	 * @param password the password string
	 * @param locale the instance of Locale
	 * @return true if logining successfully
	 * @throws Exception
	 */
	public abstract boolean login(String account, String password, Locale locale)
		throws Exception;
}