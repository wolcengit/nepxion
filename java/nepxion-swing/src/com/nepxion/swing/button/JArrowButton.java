package com.nepxion.swing.button;

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

import javax.swing.JButton;

import com.nepxion.swing.icon.paint.ArrowIcon;

public class JArrowButton
	extends JButton
{
	public JArrowButton()
	{
		super(new ArrowIcon(5, ArrowIcon.SOUTH));
		
		setPreferredSize(new Dimension(17, getPreferredSize().height));
		setFocusPainted(false);
	}
}