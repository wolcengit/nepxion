package com.nepxion.swing.query.condition;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.nepxion.swing.button.JClassicButton;
import com.nepxion.swing.icon.IconFactory;
import com.nepxion.swing.locale.SwingLocale;

public class JQueryButtonBar
	extends JPanel
{
	private JClassicButton queryButton;
	private JClassicButton resetButton;
	
	public JQueryButtonBar()
	{
		queryButton = new JClassicButton(SwingLocale.getString("query"), IconFactory.getSwingIcon("query.png"), SwingLocale.getString("query"));
		resetButton = new JClassicButton(SwingLocale.getString("reset"), IconFactory.getSwingIcon("edit.png"), SwingLocale.getString("reset"));
		
		setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(Box.createHorizontalGlue());
		add(resetButton);
		add(Box.createHorizontalStrut(10));
		add(queryButton);
		add(Box.createHorizontalGlue());
	}
	
	public JClassicButton getQueryButton()
	{
		return queryButton;
	}
	
	public JClassicButton getResetButton()
	{
		return resetButton;
	}
}