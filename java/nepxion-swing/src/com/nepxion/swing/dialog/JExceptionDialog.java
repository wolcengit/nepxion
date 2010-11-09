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
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.button.JClassicButton;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.keystroke.KeyStrokeManager;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.textarea.JBasicTextArea;
import com.nepxion.swing.textfield.JBasicTextField;
import com.nepxion.util.exception.ExceptionUtil;

public class JExceptionDialog
	extends JBasicDialog
{
	private static JExceptionDialog exceptionDialog;
	
	private JBasicTextField hintTextField;
	private JBasicTextField toggleTextField;
	
	private JClassicButton closeButton;
	private JClassicButton detailButton;
	
	private JBasicTextArea detailTextArea;
	private JPanel bottomPanel;
	
	private boolean open = false;
	
	public static void traceException(Component owner, String hint, Exception e)
	{
		traceException(owner, hint, SwingLocale.getString("exception_detail"), e);
	}
	
	public static void traceException(Component owner, String hint, String summary, Exception e)
	{
		if (exceptionDialog == null)
		{
			if (owner instanceof Dialog)
			{
				exceptionDialog = new JExceptionDialog((Dialog) owner);
			}
			else if (owner instanceof Frame)
			{
				exceptionDialog = new JExceptionDialog((Frame) owner);
			}
		}
		if (!exceptionDialog.isVisible())
		{
			exceptionDialog.setException(hint, summary, e);
			exceptionDialog.setVisible(true);
		}
		else
		{
			exceptionDialog.addException(e);
		}
	}
	
	public JExceptionDialog(Dialog owner)
	{
		super(owner, SwingLocale.getString("exception"), new Dimension(430, 110));
		
		initComponents();
	}
	
	public JExceptionDialog(Frame owner)
	{
		super(owner, SwingLocale.getString("exception"), new Dimension(430, 110));
		
		initComponents();
	}
	
	private void initComponents()
	{
		JLabel iconLabel = new JLabel(IconFactory.getSwingIcon("warning.png"));
		
		hintTextField = new JBasicTextField(SwingLocale.getString("exception_none"));
		hintTextField.setPreferredSize(new Dimension(250, hintTextField.getPreferredSize().height));
		hintTextField.setLabelStyle();
		
		toggleTextField = new JBasicTextField(SwingLocale.getString("exception_view_description"));
		toggleTextField.setPreferredSize(new Dimension(250, toggleTextField.getPreferredSize().height));
		toggleTextField.setLabelStyle();
		
		closeButton = new JClassicButton(SwingLocale.getString("exception_close"), IconFactory.getSwingIcon("solid/close_16.png"), SwingLocale.getString("exception_close_tooltip"));
		DimensionManager.setDimension(closeButton, new Dimension(91, 29));
		ActionListener closeActionListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
			}
		};
		closeButton.addActionListener(closeActionListener);
		KeyStrokeManager.registerButtonToEscapeKey(closeButton, closeActionListener);
		KeyStrokeManager.registerButtonToEnterKey(closeButton, closeActionListener);
		
		detailButton = new JClassicButton(SwingLocale.getString("exception_view"), IconFactory.getSwingIcon("solid/info_16.png"), SwingLocale.getString("exception_view_tooltip"));
		DimensionManager.setDimension(detailButton, new Dimension(91, 29));
		ActionListener detailActionListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (open)
				{
					bottomPanel.setVisible(false);
					detailButton.setText(SwingLocale.getString("exception_view"));
					detailButton.setToolTipText(SwingLocale.getString("exception_view_tooltip"));
					toggleTextField.setText(SwingLocale.getString("exception_view_description"));
					setSize(430, 110);
				}
				else
				{
					bottomPanel.setVisible(true);
					detailButton.setText(SwingLocale.getString("exception_hide"));
					detailButton.setToolTipText(SwingLocale.getString("exception_hide_tooltip"));
					toggleTextField.setText(SwingLocale.getString("exception_hide_description"));
					setSize(430, 270);
				}
				open = !open;
			}
		};
		detailButton.addActionListener(detailActionListener);		
		
		JPanel messagePanel = new JPanel();
		messagePanel.setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.LEFT, 0));
		messagePanel.add(Box.createVerticalStrut(7));
		messagePanel.add(hintTextField);
		messagePanel.add(Box.createVerticalStrut(2));
		messagePanel.add(toggleTextField);
		
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.X_AXIS));
		labelPanel.add(iconLabel);
		labelPanel.add(Box.createHorizontalStrut(10));
		labelPanel.add(messagePanel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.add(closeButton);
		buttonPanel.add(Box.createVerticalStrut(5));
		buttonPanel.add(detailButton);
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
		topPanel.add(labelPanel, BorderLayout.WEST);
		topPanel.add(buttonPanel, BorderLayout.EAST);
		
		detailTextArea = new JBasicTextArea(SwingLocale.getString("exception_detail_none"));
		JBasicScrollPane detailScrollPane = new JBasicScrollPane();
		detailScrollPane.setPreferredSize(new Dimension(395, 150));
		detailScrollPane.setVerticalScrollBarPolicy(JBasicScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		detailScrollPane.getViewport().add(detailTextArea);
		
		bottomPanel = new JPanel();
		bottomPanel.add(detailScrollPane);
		bottomPanel.setVisible(false);
		
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		container.add(topPanel, BorderLayout.NORTH);
		container.add(bottomPanel, BorderLayout.CENTER);
		
		setResizable(false);
		// WindowManager.setAlwaysOnTop(this, true);
		for (int i = 0; i < getComponentListeners().length; i++)
		{
			ComponentListener componentListener = getComponentListeners()[i];
			if (componentListener instanceof DialogResizer)
			{
				removeComponentListener(componentListener);
				break;
			}
		}
	}
	
	public void setException(String hint, String summary, Exception e)
	{
		summary = (summary == null ? "" : summary + "\n");
		hintTextField.setText(hint);
		
		String exceptionText = ExceptionUtil.getText(e);
		detailTextArea.setText(summary + exceptionText + "\n");
		detailTextArea.setCaretPosition(0);
	}
	
	public void addException(Exception e)
	{
		String exceptionText = ExceptionUtil.getText(e);
		detailTextArea.setText(detailTextArea.getText() + exceptionText + "\n");
		detailTextArea.setCaretPosition(0);
	}
	
	public String getExceptionText()
	{
		return detailTextArea.getText();
	}
}