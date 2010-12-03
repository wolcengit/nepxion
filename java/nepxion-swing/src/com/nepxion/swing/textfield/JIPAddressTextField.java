package com.nepxion.swing.textfield;

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

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.textfield.number.JNumberTextField;

public class JIPAddressTextField
	extends JBasicTextField
{
	private JNumberTextField ipAddressTextField1;
	private JNumberTextField ipAddressTextField2;
	private JNumberTextField ipAddressTextField3;
	private JNumberTextField ipAddressTextField4;
	
	public JIPAddressTextField()
	{
		this(null);
	}
	
	public JIPAddressTextField(String ipAddress)
	{
		super();
		
		ipAddressTextField1 = createTextField();
		ipAddressTextField2 = createTextField();
		ipAddressTextField3 = createTextField();
		ipAddressTextField4 = createTextField();
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		// setLayout(new GridLayout(1, 9, 0, 0));
		setFocusable(false);
		setRequestFocusEnabled(false);
		add(Box.createHorizontalStrut(20));
		add(ipAddressTextField1);
		add(createDot());
		add(ipAddressTextField2);
		add(createDot());
		add(ipAddressTextField3);
		add(createDot());
		add(ipAddressTextField4);
		add(Box.createHorizontalStrut(20));
		
		removeMouseListener(getPopupMenuAdapter());
		
		setIPAddress(ipAddress);
	}
	
	private JNumberTextField createTextField()
	{
		JNumberTextField ipAddressTextField = new JNumberTextField(3, 0, 0, 255);
		ipAddressTextField.setPreferredSize(new Dimension(20, 20));
		ipAddressTextField.setHorizontalAlignment(RIGHT);
		ipAddressTextField.setBorder(null);
		ipAddressTextField.supportSelectionAll(true);
		
		return ipAddressTextField;
	}
	
	private JLabel createDot()
	{
		JLabel label = new JLabel(".");
		label.setPreferredSize(new Dimension(2, 20));
		return label;
	}
	
	public void setEnabled(boolean enabled)
	{
		super.setEnabled(enabled);
		
		if (ipAddressTextField1 != null && ipAddressTextField2 != null && ipAddressTextField3 != null && ipAddressTextField4 != null)
		{	
			ipAddressTextField1.setEnabled(enabled);
			ipAddressTextField2.setEnabled(enabled);
			ipAddressTextField3.setEnabled(enabled);
			ipAddressTextField4.setEnabled(enabled);
		}
	}
	
	public void setEditable(boolean editable)
	{
		super.setEditable(editable);
		
		if (ipAddressTextField1 != null && ipAddressTextField2 != null && ipAddressTextField3 != null && ipAddressTextField4 != null)
		{
			ipAddressTextField1.setEditable(editable);
			ipAddressTextField2.setEditable(editable);
			ipAddressTextField3.setEditable(editable);
			ipAddressTextField4.setEditable(editable);
		}
	}
	
	public void setIPAddress(String ipAddress)
	{
		if (ipAddress == null || ipAddress.equals(""))
		{
			ipAddressTextField1.setText("");
			ipAddressTextField2.setText("");
			ipAddressTextField3.setText("");
			ipAddressTextField4.setText("");
		}
		else
		{
			if ((ipAddress.indexOf(".") == -1) || (ipAddress.split("\\.").length != 4))
			{
				throw new IllegalArgumentException(SwingLocale.getString("invalid_ip_address") + " : " + ipAddress);
			}
			String ipAddresses[] = ipAddress.split("\\.");
			
			try
			{
				int number1 = Integer.parseInt(ipAddresses[0]);
				int number2 = Integer.parseInt(ipAddresses[1]);
				int number3 = Integer.parseInt(ipAddresses[2]);
				int number4 = Integer.parseInt(ipAddresses[3]);
				
				if (number1 < 0 || number1 > 255 || number2 < 0 || number2 > 255 || number3 < 0 || number3 > 255 || number4 < 0 || number4 > 255)
				{
					throw new IllegalArgumentException(SwingLocale.getString("invalid_ip_address") + " : " + ipAddress);
				}
			}
			catch (NumberFormatException e)
			{
				throw new IllegalArgumentException(SwingLocale.getString("invalid_ip_address") + " : " + ipAddress);
			}
			
			ipAddressTextField1.setText(ipAddresses[0]);
			ipAddressTextField2.setText(ipAddresses[1]);
			ipAddressTextField3.setText(ipAddresses[2]);
			ipAddressTextField4.setText(ipAddresses[3]);
		}
	}
	
	public String getIPAddress()
	{
		String ipAddress1 = ipAddressTextField1.getText().trim();
		String ipAddress2 = ipAddressTextField2.getText().trim();
		String ipAddress3 = ipAddressTextField3.getText().trim();
		String ipAddress4 = ipAddressTextField4.getText().trim();
		if (ipAddress1.equals("") && ipAddress2.equals("") && ipAddress3.equals("") && ipAddress4.equals(""))
		{
			return "";
		}
		return (ipAddress1.equals("") ? "0" : ipAddress1) + "." + (ipAddress2.equals("") ? "0" : ipAddress2) + "." + (ipAddress3.equals("") ? "0" : ipAddress3) + "." + (ipAddress4.equals("") ? "0" : ipAddress4);
	}
	
	public void setText(String text)
	{
		setIPAddress(text);
	}
	
	public String getText()
	{
		return getIPAddress();
	}
}