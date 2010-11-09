package com.nepxion.swing.searcher.ip.local;

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
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.layout.toolbar.ToolBarLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.scrollpane.JBasicScrollPane;
import com.nepxion.swing.textfield.JBasicTextField;
import com.nepxion.util.searcher.ip.local.IPConstants;

public class JAddressPanel
	extends JPanel
{
	private JBasicTextField addressTextField;
	
	private JAddressTable table;
	
	private JLabel versionDateLabel;
	private JLabel totalCountLabel;
	private JLabel countLabel;
	
	public JAddressPanel()
	{
		table = new JAddressTable();
		
		setLayout(new BorderLayout());
		add(new ToolBar(), BorderLayout.NORTH);
		add(new JBasicScrollPane(table), BorderLayout.CENTER);
		add(new InfoBar(), BorderLayout.SOUTH);
	}
	
	public class ToolBar
		extends JPanel
	{
		public ToolBar()
		{
			setLayout(new ToolBarLayout());
			setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
			
			addressTextField = new JBasicTextField();
			DimensionManager.setDimension(addressTextField, new Dimension(180, 23));
			
			JBasicButton searchButton = new JBasicButton(AddressController.getSearchAction(JAddressPanel.this));
			JBasicButton clearButton = new JBasicButton(AddressController.getClearAction(table));
			
			add(new JLabel(SwingLocale.getString("address")));
			add(addressTextField);
			
			add(searchButton);
			add(clearButton);
			
			add(Box.createHorizontalGlue());
			
			ButtonManager.updateUI(this);
		}
	}
	
	public class InfoBar
		extends JPanel
	{
		public InfoBar()
		{
			versionDateLabel = new JLabel(SwingLocale.getString("ip_database_version") + " " + IPConstants.VERSION_DATE);
			totalCountLabel = new JLabel(SwingLocale.getString("ip_database_capacity") + " " + IPConstants.TOTAL_COUNT);
			countLabel = new JLabel(SwingLocale.getString("ip_database_matched") + " " + IPConstants.INITIALIZED_COUNT);
			
			setLayout(new FlowLayout(FlowLayout.LEADING));
			setPreferredSize(new Dimension(getPreferredSize().width, 23));
			add(versionDateLabel);
			add(totalCountLabel);
			add(countLabel);
		}
	}
	
	public JAddressTable getIPTable()
	{
		return table;
	}
	
	public String getAddress()
	{
		return addressTextField.getText().trim();
	}
	
	public void setAddress(String address)
	{
		addressTextField.setText(address.trim());
	}
	
	public void setCount(int count)
	{
		countLabel.setText(SwingLocale.getString("ip_database_matched") + " " + count);
	}
}