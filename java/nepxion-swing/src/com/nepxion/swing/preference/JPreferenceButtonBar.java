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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.button.ButtonManager;
import com.nepxion.swing.button.JBasicButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;

public class JPreferenceButtonBar
	extends JPanel
{	
	protected JBasicButton saveButton;
	protected JBasicButton refreshButton;
	
	public JPreferenceButtonBar()
	{
		saveButton = new JBasicButton(SwingLocale.getString("save"), IconFactory.getSwingIcon("solid/confirm_16.png"), SwingLocale.getString("save"));
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				save();
			}
		}
		);
		
		refreshButton = new JBasicButton(SwingLocale.getString("refresh"), IconFactory.getSwingIcon("solid/refresh_16.png"), SwingLocale.getString("refresh"));
		refreshButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				refresh();
			}
		}
		);
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(BorderFactory.createEmptyBorder(2, 2, 0, 2));
		add(saveButton);
		add(refreshButton);
		
		ButtonManager.updateUI(this);
	}
	
	public void save()
	{
		
	}
	
	public void refresh()
	{
		
	}
}