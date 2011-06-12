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
	/**
	 * Constructs with the default.
	 */
	public JCornerScrollPane()
	{
		super();
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial vertical scroll bar policy and horizontal scroll bar policy.
	 * @param vsbPolicy the vertical scroll bar policy value
	 * @param hsbPolicy the horizontal scroll bar policy value
	 */
	public JCornerScrollPane(int vsbPolicy, int hsbPolicy)
	{
		super(vsbPolicy, hsbPolicy);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial view.
	 * @param view the instance of Component
	 */
	public JCornerScrollPane(Component view)
	{
		super(view);
		
		initComponents();
	}
	
	/**
	 * Constructs with the specified initial view, vertical scroll bar policy and horizontal scroll bar policy.
	 * @param view the instance of Component
	 * @param vsbPolicy the vertical scroll bar policy value
	 * @param hsbPolicy the horizontal scroll bar policy value
	 */
	public JCornerScrollPane(Component view, int vsbPolicy, int hsbPolicy)
	{
		super(view, vsbPolicy, hsbPolicy);
		
		initComponents();
	}
	
	/**
	 * Initializes the components.
	 */
	private void initComponents()
	{
		setBorder(BorderManager.createLineBorder(Color.gray, 0, 0, 0, 0));
		
		ScrollPaneManager.setPreferenceStyle(this);
	}
	
	/**
	 * Sets the label style.
	 */
	public void setLabelStyle()
	{
		ScrollPaneManager.setLabelStyle(this);
	}
}