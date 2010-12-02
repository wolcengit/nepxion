package com.nepxion.swing.preference;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.Icon;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.panel.JPasswordPanel;

public class JUserPreference
	extends JPreference
{	
	private JPasswordPanel passwordPanel;
	
	public JUserPreference()
	{		
		passwordPanel = new JPasswordPanel();
		passwordPanel.setBorder(BorderManager.createComplexTitleBorder(SwingLocale.getString("modify_password")));

		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 5));
		add(passwordPanel);
	}
	
	public JPasswordPanel getPasswordPanel()
	{
		return passwordPanel;
	}
	
	public boolean verify()
	{
		return passwordPanel.verify();
	}
	
	public String getToggleName()
	{
		return SwingLocale.getString("user_toggle_name");
	}
	
	public void setToggleName(String toggleName)
	{
		
	}
	
	public Icon getToggleIcon()
	{
		return IconFactory.getSwingIcon("banner/user.png");
	}
	
	public void setToggleIcon(Icon toggleIcon)
	{
		
	}
	
	public Icon getToggleBannerIcon()
	{
		return IconFactory.getSwingIcon("banner/user.png");
	}
	
	public void setToggleBannerIcon(Icon toggleBannerIcon)
	{
		
	}
	
	public String getToggleDescription()
	{
		return SwingLocale.getString("user_toggle_description");
	}
	
	public void setToggleDescription(String toggleDescription)
	{
		
	}
}