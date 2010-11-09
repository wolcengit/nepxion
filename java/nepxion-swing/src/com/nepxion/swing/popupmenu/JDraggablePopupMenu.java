package com.nepxion.swing.popupmenu;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Component;
import java.awt.Insets;

import javax.swing.UIManager;

import com.jidesoft.popup.JidePopup;

public class JDraggablePopupMenu
	extends JidePopup
{
	public JDraggablePopupMenu()
	{
		setResizable(true);
		setMovable(true);
		setBackground(UIManager.getColor("Panel.background"));
	}
	
	public void showPopup(Insets insets, Component owner)
	{
		setDefaultFocusComponent(getContentPane());
		
		super.showPopup(insets, owner);
	}
	
	public void updateUI()
	{
		super.updateUI();
		
		setBackground(UIManager.getColor("Panel.background"));
	}
}