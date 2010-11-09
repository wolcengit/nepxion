package com.nepxion.swing.selector.color;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;

import com.nepxion.swing.dialog.JBasicDialog;

public class JColorSelector
	extends JBasicDialog
{
	private JColorPane colorPane;
	
	public JColorSelector(Frame owner)
	{
		super(owner, "颜色拾选器", new Dimension(165, 177));
		
		initComponents();
	}
	
	public JColorSelector(Dialog owner)
	{
		super(owner, "颜色拾选器", new Dimension(165, 177));
		
		initComponents();
	}
	
	private void initComponents()
	{
		colorPane = new JColorPane();
		getContentPane().add(colorPane);
	}
	
	public JColorPane getColorPane()
	{
		return colorPane;
	}
}