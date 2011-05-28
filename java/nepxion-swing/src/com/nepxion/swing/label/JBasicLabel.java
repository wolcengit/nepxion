package com.nepxion.swing.label;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.plaf.UIResource;

public class JBasicLabel
	extends JLabel
	implements UIResource
{
	public JBasicLabel()
	{
		super();
	}
	
	public JBasicLabel(String text)
	{
		super(text);
	}
	
	public JBasicLabel(String text, String toolTipText)
	{
		super(text);
		
		setToolTipText(toolTipText);
	}
	
	public JBasicLabel(String text, int horizontalAlignment)
	{
		super(text, horizontalAlignment);
	}
	
	public JBasicLabel(String text, String toolTipText, int horizontalAlignment)
	{
		super(text, horizontalAlignment);
		
		setToolTipText(toolTipText);
	}
	
	public JBasicLabel(Icon image)
	{
		super(image);
	}
	
	public JBasicLabel(Icon image, String toolTipText)
	{
		super(image);
		
		setToolTipText(toolTipText);
	}
	
	public JBasicLabel(Icon image, int horizontalAlignment)
	{
		super(image, horizontalAlignment);
	}
	
	public JBasicLabel(Icon image, String toolTipText, int horizontalAlignment)
	{
		super(image, horizontalAlignment);
		
		setToolTipText(toolTipText);
	}
	
	public JBasicLabel(String text, Icon icon, int horizontalAlignment)
	{
		super(text, icon, horizontalAlignment);
	}
	
	public JBasicLabel(String text, Icon icon, String toolTipText)
	{
		super(text);
		
		setIcon(icon);
		setToolTipText(toolTipText);
	}
	
	public JBasicLabel(String text, Icon icon, String toolTipText, int horizontalAlignment)
	{
		super(text, icon, horizontalAlignment);
		
		setToolTipText(toolTipText);
	}
}