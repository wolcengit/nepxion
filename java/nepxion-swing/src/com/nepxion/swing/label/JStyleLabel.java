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

import com.jidesoft.swing.StyledLabel;

public class JStyleLabel
	extends StyledLabel
{
	public JStyleLabel()
	{
	}
	
	public JStyleLabel(Icon image)
	{
		super(image);
	}
	
	public JStyleLabel(Icon image, int horizontalAlignment)
	{
		super(image, horizontalAlignment);
	}
	
	public JStyleLabel(String text)
	{
		super(text);
	}
	
	public JStyleLabel(String text, int horizontalAlignment)
	{
		super(text, horizontalAlignment);
	}
	
	public JStyleLabel(String text, Icon icon, int horizontalAlignment)
	{
		super(text, icon, horizontalAlignment);
	}
}