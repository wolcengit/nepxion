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

import java.awt.Color;
import java.awt.Component;

import com.jidesoft.swing.JideScrollPane;
import com.nepxion.swing.border.BorderManager;

public class JCornerScrollPane
	extends JideScrollPane
{
	public JCornerScrollPane(Component view, int vsbPolicy, int hsbPolicy)
	{
		super(view, vsbPolicy, hsbPolicy);
		
		initComponents();
	}
	
	public JCornerScrollPane(Component view)
	{
		super(view);
		
		initComponents();
	}
	
	public JCornerScrollPane(int vsbPolicy, int hsbPolicy)
	{
		super(vsbPolicy, hsbPolicy);
		
		initComponents();
	}
	
	public JCornerScrollPane()
	{
		super();
		
		initComponents();
	}
	
	private void initComponents()
	{
		setBorder(BorderManager.createLineBorder(Color.gray, 0, 0, 0, 0));
		
		ScrollPaneManager.setPreferenceStyle(this);
	}
	
	public void setLabelStyle()
	{
		ScrollPaneManager.setLabelStyle(this);
	}
}