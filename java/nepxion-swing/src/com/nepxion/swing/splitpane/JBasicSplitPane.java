package com.nepxion.swing.splitpane;

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
import java.awt.Dimension;
import java.awt.event.HierarchyEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import com.jidesoft.swing.JideSplitPane;
import com.nepxion.swing.layout.box.XBoxLayout;
import com.nepxion.swing.listener.DisplayAbilityListener;

public class JBasicSplitPane
	extends JideSplitPane
{
	public static final String FIX = XBoxLayout.FIX;
	public static final String FLEXIBLE = XBoxLayout.FLEXIBLE;
	public static final String VARY = XBoxLayout.VARY;
	
	private Map dividerLocations;
	
	public JBasicSplitPane()
	{
		super();
		
		initComponents();
	}
	
	public JBasicSplitPane(int newOrientation)
	{
		super(newOrientation);
		
		initComponents();
	}
	
	private void initComponents()
	{
		dividerLocations = new HashMap();
		
		setDividerSize(5);
		addHierarchyListener(new DisplayAbilityListener()
		{
			public void displayAbilityChanged(HierarchyEvent e)
			{
				adaptDividerLocation();
				
				removeHierarchyListener(this);
			}
		}
		);
	}
	
	private void adaptDividerLocation()
	{
		if (dividerLocations != null)
		{
			for (Iterator iterator = dividerLocations.keySet().iterator(); iterator.hasNext();)
			{
				Object key = iterator.next();
				int index = ((Integer) key).intValue();
				int location = ((Integer) dividerLocations.get(key)).intValue();
				
				JBasicSplitPane.super.setDividerLocation(index, location);
				
				setComponentSize(index, location);
			}
			dividerLocations = null;
		}
	}
	
	public void setDividerLocation(int index, int location)
	{
		if (dividerLocations == null)
		{
			super.setDividerLocation(index, location);
		}
		else
		{
			dividerLocations.put(new Integer(index), new Integer(location));
		}
	}
	
	private void setComponentSize(final int index, final int size)
	{
		Component pane = getPaneAt(index);
		if (pane != null && pane instanceof JComponent)
		{
			int width = 0;
			int height = 0;
			if (getOrientation() == VERTICAL_SPLIT)
			{
				width = getPreferredSize().width;
				height = size;
			}
			else if (getOrientation() == HORIZONTAL_SPLIT)
			{
				width = size;
				height = getPreferredSize().height;
			}
			
			JComponent component = (JComponent) pane;
			Dimension dimension = new Dimension(width, height);
			
			component.setPreferredSize(dimension);
		}
	}
	
	public void updateUI()
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				JBasicSplitPane.super.updateUI();
			}
		}
		);
	}
}