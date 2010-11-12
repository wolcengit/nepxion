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
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.nepxion.swing.border.BorderManager;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.layout.filed.FiledLayout;
import com.nepxion.swing.layout.table.TableLayout;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.IValidation;
import com.nepxion.swing.textfield.JBasicPasswordField;
import com.nepxion.swing.toggle.ITogglePanel;

public class JUserPreference
	extends JPanel implements ITogglePanel, IValidation
{	
	private JBasicPasswordField oldPasswordTextField;
	private JBasicPasswordField newPasswordTextField;
	private JBasicPasswordField newPasswordConfirmTextField;
	
	public JUserPreference()
	{		
		oldPasswordTextField = new JBasicPasswordField();
		newPasswordTextField = new JBasicPasswordField();
		newPasswordConfirmTextField = new JBasicPasswordField();
		
		double[][] size = 
		{ 
			{TableLayout.PREFERRED, 160}, 
			{22, 22, 22}
		};
		
		TableLayout tableLayout = new TableLayout(size);
		tableLayout.setVGap(10);
		tableLayout.setHGap(10);
		
		JPanel passwordPanel = new JPanel();
		passwordPanel.setLayout(tableLayout);
		passwordPanel.add(new JLabel(SwingLocale.getString("old_password")), "0, 0");
		passwordPanel.add(oldPasswordTextField, "1, 0");
		passwordPanel.add(new JLabel(SwingLocale.getString("new_password")), "0, 1");
		passwordPanel.add(newPasswordTextField, "1, 1");
		passwordPanel.add(new JLabel(SwingLocale.getString("new_password_confirm")), "0, 2");
		passwordPanel.add(newPasswordConfirmTextField, "1, 2");
		
		JPanel userPanel = new JPanel();
		userPanel.setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.LEFT, 5));
		userPanel.setBorder(BorderManager.createComplexTitleBorder(SwingLocale.getString("modify_password")));
		userPanel.add(passwordPanel);

		setLayout(new FiledLayout(FiledLayout.COLUMN, FiledLayout.FULL, 5));
		add(userPanel);
	}
	
	public boolean verify()
	{
		return true;
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