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
import java.awt.event.HierarchyEvent;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JToggleButton;
import javax.swing.plaf.ButtonUI;

import com.nepxion.swing.dimension.DimensionManager;
import com.nepxion.swing.listener.DisplayAbilityListener;

public class JBasicToggleButton
	extends JToggleButton implements IButton
{
	protected int widthInset = ButtonContext.getButtonWidthInset();
	protected int heightInset = ButtonContext.getButtonHeightInset();
	protected boolean isDimensionAdaptive = true;
	
	public JBasicToggleButton()
	{
		super();
		
		initComponents();
	}
	
	public JBasicToggleButton(Action action)
	{
		super(action);
		
		initComponents();
	}
	
	public JBasicToggleButton(Icon icon)
	{
		super(icon);
		
		initComponents();
	}
	
	public JBasicToggleButton(String text)
	{
		super(text);
		
		initComponents();
	}
	
	public JBasicToggleButton(Icon icon, String toolTipText)
	{
		super(icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JBasicToggleButton(Icon icon, boolean selected)
	{
		super(icon);
		
		initComponents();
		
		setSelected(selected);
	}
	
	public JBasicToggleButton(String text, String toolTipText)
	{
		super(text);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JBasicToggleButton(String text, boolean selected)
	{
		super(text);
		
		initComponents();
		
		setSelected(selected);
	}
	
	public JBasicToggleButton(String text, Icon icon)
	{
		super(text, icon);
		
		initComponents();
	}
	
	public JBasicToggleButton(Icon icon, String toolTipText, boolean selected)
	{
		super(icon);
		
		initComponents();
		
		setSelected(selected);
		setToolTipText(toolTipText);
	}
	
	public JBasicToggleButton(String text, String toolTipText, boolean selected)
	{
		super(text);
		
		initComponents();
		
		setSelected(selected);
		setToolTipText(toolTipText);
	}
	
	public JBasicToggleButton(String text, Icon icon, String toolTipText)
	{
		super(text, icon);
		
		initComponents();
		
		setToolTipText(toolTipText);
	}
	
	public JBasicToggleButton(String text, Icon icon, boolean selected)
	{
		super(text, icon);
		
		initComponents();
		
		setSelected(selected);
	}
	
	public JBasicToggleButton(String text, Icon icon, String toolTipText, boolean selected)
	{
		super(text, icon);
		
		initComponents();
		
		setSelected(selected);
		setToolTipText(toolTipText);
	}
	
	private void initComponents()
	{
		setModel(new BasicToggleButtonModel());
		
		addHierarchyListener(new DisplayAbilityListener()
		{
			public void displayAbilityChanged(HierarchyEvent e)
			{
				adaptDimension();
				
				removeHierarchyListener(this);
			}
		}
		);
	}
	
	private void adaptDimension()
	{
		if (isDimensionAdaptive)
		{
			Dimension dimension = getPreferredSize();
			
			int width = dimension.width;
			if (width % 2 != 0)
			{
				width += widthInset;
			}
			else
			{
				width += widthInset + 1;
			}
			dimension.width = width;
			
			int height = dimension.height;
			if (height % 2 != 0)
			{
				height += heightInset;
			}
			else
			{
				height += heightInset + 1;
			}
			dimension.height = height;
			
			setDimension(dimension);
		}
	}
	
	public int getWidthInset()
	{
		return widthInset;
	}
	
	public void setWidthInset(int widthInset)
	{
		this.widthInset = widthInset;
	}
	
	public int getHeightInset()
	{
		return heightInset;
	}
	
	public void setHeightInset(int heightInset)
	{
		this.heightInset = heightInset;
	}
	
	public void setDimension(Dimension dimension)
	{
		DimensionManager.setDimension(this, dimension);
		
		isDimensionAdaptive = false;
	}
	
	public void setUI(ButtonUI buttonUI)
	{
		super.setUI(buttonUI);
		
		setOpaque(false);
	}
	
	public void updateUI()
	{
		setUI(getUI());
	}
}