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
import javax.swing.JSeparator;
import javax.swing.border.Border;

import com.nepxion.swing.button.JClassicButton;
import com.nepxion.swing.combobox.JBasicComboBox;
import com.nepxion.swing.element.ElementNode;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.renderer.combobox.ComboBoxElementCellRenderer;
import com.nepxion.swing.textfield.JBasicPasswordField;
import com.nepxion.swing.textfield.JBasicTextField;
import com.nepxion.util.locale.LocaleConstants;
import com.nepxion.util.locale.LocaleContext;

public abstract class JLoginDialog
	extends JBasicDialog
{
	public static final Border ETCHED_BORDER = BorderFactory.createEtchedBorder(Color.white, new Color(148, 145, 140));
	
	protected JLabel accountLabel;
	protected JBasicTextField accountTextField;
	
	protected JLabel passwordLabel;
	protected JBasicPasswordField passwordField;
	
	protected JLabel localeLabel;
	protected JBasicComboBox localeComboBox;
	
	protected JClassicButton loginButton;
	protected JClassicButton resetButton;
	protected JClassicButton exitButton;
	
	protected JPanel contentPanel;
	protected JPanel editorPanel;
	protected JPanel buttonPanel;
	
	protected JSeparator separator;
	
	public JLoginDialog(String title, Icon banner)
	{
		super((Frame) null, title);
		
		accountLabel = new JLabel();
		accountLabel.setFont(new Font("Dialog", 0, 14));
		
		accountTextField = new JBasicTextField();
		
		passwordLabel = new JLabel();
		passwordLabel.setFont(new Font("Dialog", 0, 14));
		
		passwordField = new JBasicPasswordField();
		
		localeLabel = new JLabel();
		localeLabel.setFont(new Font("Dialog", 0, 14));
		
		localeComboBox = new JBasicComboBox();
		localeComboBox.setRenderer(new ComboBoxElementCellRenderer());
		localeComboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int selectedIndex = localeComboBox.getSelectedIndex();
				ElementNode selectedElementNode = (ElementNode) localeComboBox.getSelectedItem();
				Locale locale = (Locale) selectedElementNode.getUserObject();
				
				LocaleContext.registerLocale(locale);
				
				initLocale();
				
				localeComboBox.setSelectedIndex(selectedIndex);
			}
		}
		);
		
		double[][] size = 
		{ 
			{80, 180}, 
			{25, 25, 25}
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
		loginButton.setFont(new Font("Dialog", 0, 14));
		loginButton.setPreferredSize(new Dimension(72, 32));
		getRootPane().setDefaultButton(loginButton);
		loginButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String account = accountTextField.getText().trim();
				String password = passwordField.getPasswordText().trim();
				
				ElementNode selectedElementNode = (ElementNode) localeComboBox.getSelectedItem();
				Locale locale = (Locale) selectedElementNode.getUserObject();
				
				if (account.equals("") || password.equals(""))
				{
					JBasicOptionPane.showMessageDialog(JLoginDialog.this, SwingLocale.getString("login_not_null"), SwingLocale.getString("error"), JBasicOptionPane.ERROR_MESSAGE);
					return;
				}
				
				boolean flag = true;
				try
				{
					flag = login(account, password, locale);
				}
				catch (Exception ex)
				{
					JExceptionDialog.traceException(JLoginDialog.this, SwingLocale.getString("login_failure_service"), ex);
					return;
				}
				
				if (flag)
				{
					setVisible(false);
				}	
				else
				{
					JBasicOptionPane.showMessageDialog(JLoginDialog.this, SwingLocale.getString("login_failure_validation"), SwingLocale.getString("error"), JBasicOptionPane.ERROR_MESSAGE);
				}
			}
		}
		);
		
		resetButton = new JClassicButton();
		resetButton.setFont(new Font("Dialog", 0, 14));
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
		exitButton.setFont(new Font("Dialog", 0, 14));
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
		
		separator = new JSeparator();
		separator.setPreferredSize(new Dimension(280, separator.getPreferredSize().height));
		
		contentPanel = new JPanel();
		contentPanel.setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.CENTER, 0));
		
		initContentPanel();
		
		JLabel imageLabel = new JLabel(banner, JLabel.LEFT);
		imageLabel.setBorder(ETCHED_BORDER);
		
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
		container.setBorder(BorderFactory.createCompoundBorder(ETCHED_BORDER, BorderFactory.createEmptyBorder(20, 20, 20, 20)));
		container.add(imageLabel);
		container.add(Box.createHorizontalStrut(20));
		container.add(contentPanel);
		
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
		
		initLocale();
	}
	
	protected void initContentPanel()
	{
		contentPanel.setBorder(BorderFactory.createCompoundBorder(ETCHED_BORDER, BorderFactory.createEmptyBorder(25, 20, 25, 20))); // 30, 20, 30, 20
		contentPanel.add(editorPanel);
		contentPanel.add(Box.createVerticalStrut(25)); // 37
		contentPanel.add(separator);
		contentPanel.add(Box.createVerticalStrut(25)); // 37
		contentPanel.add(buttonPanel);
	}
	
	protected void initLocale()
	{
		accountLabel.setText(SwingLocale.getString("account") + SwingLocale.getString("colon"));
		passwordLabel.setText(SwingLocale.getString("password") + SwingLocale.getString("colon"));
		localeLabel.setText(SwingLocale.getString("locale") + SwingLocale.getString("colon"));
		
		Locale[] locales = LocaleConstants.LOCALE_LIST;
		ElementNode[] elementNodes = new ElementNode[locales.length];
		for (int i = 0; i < locales.length; i++)
		{
			Locale locale = locales[i];
			String text = SwingLocale.getString(locale.toString().toLowerCase());
			elementNodes[i] = new ElementNode(text, null, text, locale);
		}
		localeComboBox.setModel(new DefaultComboBoxModel(elementNodes));
		
		loginButton.setText(SwingLocale.getString("login"));
		loginButton.setToolTipText(SwingLocale.getString("login"));
		resetButton.setText(SwingLocale.getString("reset"));
		resetButton.setToolTipText(SwingLocale.getString("reset"));
		exitButton.setText(SwingLocale.getString("exit"));
		exitButton.setToolTipText(SwingLocale.getString("exit"));
	}
	
	public String getAccount()
	{
		return accountTextField.getText().trim();
	}
	
	public void setAccount(String account)
	{
		accountTextField.setText(account.trim());
	}
	
	public String getPassword()
	{
		return passwordField.getPasswordText().trim();
	}
	
	public void setPassword(String password)
	{
		passwordField.setText(password.trim());
	}
	
	public void setLoginFoucus()
	{
		loginButton.requestFocus();
	}
	
	public JBasicTextField getAccountTextField()
	{
		return accountTextField;
	}
	
	public JBasicPasswordField getPasswordField()
	{
		return passwordField;
	}
	
	public JClassicButton getLoginButton()
	{
		return loginButton;
	}
	
	public JClassicButton getResetButton()
	{
		return resetButton;
	}
	
	public JClassicButton getExitButton()
	{
		return exitButton;
	}
	
	public abstract boolean login(String account, String password, Locale locale)
		throws Exception;
}