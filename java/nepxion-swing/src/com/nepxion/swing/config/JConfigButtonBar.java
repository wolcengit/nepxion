package com.nepxion.swing.config;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.ButtonGroup;

import com.nepxion.swing.buttonbar.JBasicButtonBar;
import com.nepxion.swing.toggle.JToggleActionButton;

public class JConfigButtonBar
	extends JBasicButtonBar
{
	private ButtonGroup buttonGroup;
	
	public JConfigButtonBar()
	{
		super(VERTICAL);
		
		buttonGroup = new ButtonGroup();
	}
	
	public ButtonGroup getButtonGroup()
	{
		return buttonGroup;
	}
	
	public void addButton(JToggleActionButton toggleActionButton)
	{
		add(toggleActionButton);
		buttonGroup.add(toggleActionButton);
	}
	
	public void removeButton(JToggleActionButton toggleActionButton)
	{
		remove(toggleActionButton);
		buttonGroup.remove(toggleActionButton);
	}
}