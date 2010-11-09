package com.nepxion.swing.element;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.io.Serializable;

import javax.swing.Icon;

public interface IElementNode
	extends Serializable
{
	public int getIndex();
	
	public void setIndex(int index);
	
	public String getName();

	public void setName(String name);
	
	public String getText();

	public void setText(String text);
	
	public Icon getIcon();
	
	public void setIcon(Icon icon);
	
	public String getToolTipText();
	
	public void setToolTipText(String toolTipText);	
		
	public boolean isSelected();
	
	public void setSelected(boolean selected);
	
	public boolean isEnabled();
	
	public void setEnabled(boolean enabled);	
	
	public boolean isAnimation();
	
	public void setAnimation(boolean animation);
	
	public Object getUserObject();
	
	public void setUserObject(Object userObject);
	
	public String toString();
}