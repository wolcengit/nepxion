package com.nepxion.swing.searcher.zone.local;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Dimension;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.textfield.number.JNumberTextField;

public class JZoneSelectorPanel
	extends JPanel
{
	private JNumberTextField textField;
	private JZoneSelectorButton button;
	
	private int maximumLength = 12;
	
	public JZoneSelectorPanel()
	{
		this("");
	}
	
	public JZoneSelectorPanel(String value)
	{
		this(value, 12);
	}
	
	public JZoneSelectorPanel(int maximumLength)
	{
		this("", maximumLength);
	}
	
	public JZoneSelectorPanel(String value, int maximumLength)
	{
		textField = new JNumberTextField(maximumLength, 0);
		
		button = new JZoneSelectorButton(textField);
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(textField);
		add(button);
		
		ButtonManager.updateUI(this, new Dimension(26, 22));
		
		setValue(value);
	}
	
	public JTextField getTextField()
	{
		return textField;
	}
	
	public AbstractButton getButton()
	{
		return button;
	}
	
	public Object getValue()
	{
		return textField.getText();
	}
	
	public void setValue(Object value)
	{
		String text = null;
		
		if (value == null)
		{
			text = "";
		}
		
		text = value.toString().trim();
		
		if (text.length() > maximumLength)
		{
			throw new IllegalArgumentException("Invalid value");
		}
		
		if (!text.equals(""))
		{
			boolean flag = text.matches("[0-9]+");
			if (!flag)
			{
				throw new IllegalArgumentException("Invalid value");
			}
		}
		
		textField.setText(text);
	}
	
	public void setEnabled(boolean enabled)
	{
		textField.setEditable(enabled);
		button.setEnabled(enabled);
	}
}