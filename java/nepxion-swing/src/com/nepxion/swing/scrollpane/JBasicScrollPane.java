package com.nepxion.swing.scrollpane;

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

import javax.swing.JScrollPane;

public class JBasicScrollPane
	extends JScrollPane
{
	public JBasicScrollPane()
	{
		super();
		
		initComponents();
	}
	
	public JBasicScrollPane(int vsbPolicy, int hsbPolicy)
	{
		super(vsbPolicy, hsbPolicy);
		
		initComponents();
	}
	
	public JBasicScrollPane(Component view)
	{
		super(view);
		
		initComponents();
	}
	
	public JBasicScrollPane(Component view, int vsbPolicy, int hsbPolicy)
	{
		super(view, vsbPolicy, hsbPolicy);
		
		initComponents();
	}
	
	private void initComponents()
	{
		ScrollPaneManager.setPreferenceStyle(this);
	}
	
	public void setLabelStyle()
	{
		ScrollPaneManager.setLabelStyle(this);
	}
}