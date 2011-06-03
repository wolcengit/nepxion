package com.nepxion.demo.component.ribbon;

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

import com.nepxion.swing.action.JSecurityAction;
import com.nepxion.swing.optionpane.JBasicOptionPane;

public class DemoCornerAction
	extends JSecurityAction
{
	public void execute(ActionEvent e)
	{
		JBasicOptionPane.showMessageDialog(null, "Corner Action Text : " + getText());		
	}
}