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

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.textfield.number.JNumberTextField;

public class JZoneSelectorPanel
	extends JPanel
{
	private JNumberTextField zoneTextField;
	private JZoneSelectorButton zoneSelectorButton;
	
	private int maximumLength = 12;
	
	public JZoneSelectorPanel()
	{
		this("");
	}
	
	public JZoneSelectorPanel(String value)
	{
		zoneTextField = new JNumberTextField(maximumLength, 0);
		
		zoneSelectorButton = new JZoneSelectorButton(zoneTextField);
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(zoneTextField);
		add(zoneSelectorButton);
		
		ButtonManager.updateUI(this, new Dimension(26, 22));
		
		setValue(value);
	}
	
	public String getValue()
	{
		return zoneTextField.getText();
	}
	
	public void setValue(String value)
	{
		if (value == null)
		{
			value = "";
		}
		
		value = value.trim();
		
		if (value.length() > maximumLength)
		{
			throw new IllegalArgumentException("Invalid value");
		}
		
		if (!value.equals(""))
		{
			boolean flag = value.matches("[0-9]+");
			if (!flag)
			{
				throw new IllegalArgumentException("Invalid value");
			}
		}
		zoneTextField.setText(value);
	}
	
	public void setEnabled(boolean enabled)
	{
		zoneTextField.setEditable(enabled);
		zoneSelectorButton.setEnabled(enabled);
	}
}