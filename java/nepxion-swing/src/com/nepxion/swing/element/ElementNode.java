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

import javax.swing.Icon;
import javax.swing.tree.DefaultMutableTreeNode;

import com.nepxion.util.data.CloneUtil;

public class ElementNode
	extends DefaultMutableTreeNode implements IElementNode
{
	private static final long serialVersionUID = -8432382270356530085L;

	private int index = -1;
	private String name;
	private String text;
	private Icon icon;
	private String toolTipText;	
	private int selectedIndex = 0;
	private boolean selected = false;
	private boolean enabled = true;
	private boolean animation = false;	
	
	public ElementNode()
	{
		this(null, null, null);
	}
	
	
	public ElementNode(String text, Icon icon, String toolTipText)
	{
		this(null, text, icon, toolTipText);
	}	
	
	
	public ElementNode(String text, Icon icon, String toolTipText, boolean selected)
	{
		this(-1, text, icon, toolTipText, selected);
	}		
	
	public ElementNode(String text, Icon icon, String toolTipText, Object userObject)
	{
		this(-1, text, icon, toolTipText, userObject);
	}	

	public ElementNode(int index, String text, Icon icon, String toolTipText)
	{
		this(index, text, icon, toolTipText, null);
	}	

	public ElementNode(String name, String text, Icon icon, String toolTipText)
	{
		this(-1, name, text, icon, toolTipText);
	}
	
		
	public ElementNode(String text, Icon icon, String toolTipText, boolean selected, boolean enabled)
	{
		this(-1, text, icon, toolTipText, selected, enabled);
	}			

	public ElementNode(String text, Icon icon, String toolTipText, Object userObject, boolean selected)
	{
		this(-1, text, icon, toolTipText, userObject, selected);
	}		

	public ElementNode(String name, String text, Icon icon, String toolTipText, boolean selected)
	{
		this(-1, name, text, icon, toolTipText, selected);
	}	
	
	public ElementNode(int index, String text, Icon icon, String toolTipText, boolean selected)
	{
		this(index, null, text, icon, toolTipText, selected);
	}		
	
	public ElementNode(String name, String text, Icon icon, String toolTipText, Object userObject)
	{
		this(-1, name, text, icon, toolTipText, userObject);
	}

	public ElementNode(int index, String text, Icon icon, String toolTipText, Object userObject)
	{
		this(index, null, text, icon, toolTipText, userObject);
	}	

	public ElementNode(int index, String name, String text, Icon icon, String toolTipText)
	{
		this(index, name, text, icon, toolTipText, null);
	}	
	

	public ElementNode(String text, Icon icon, String toolTipText, Object userObject, boolean selected, boolean enabled)
	{
		this(-1, text, icon, toolTipText, userObject, selected, enabled);
	}
	
	public ElementNode(String name, String text, Icon icon, String toolTipText, boolean selected, boolean enabled)
	{
		this(-1, name, text, icon, toolTipText, selected, enabled);
	}	
	
	public ElementNode(int index, String text, Icon icon, String toolTipText, boolean selected, boolean enabled)
	{
		this(index, null, text, icon, toolTipText, selected, enabled);
	}	
	
	public ElementNode(String name, String text, Icon icon, String toolTipText, Object userObject, boolean selected)
	{
		this(-1, name, text, icon, toolTipText, userObject, selected);
	}	
	
	public ElementNode(int index, String text, Icon icon, String toolTipText, Object userObject, boolean selected)
	{
		this(index, null, text, icon, toolTipText, userObject, selected);
	}	
	
	public ElementNode(int index, String name, String text, Icon icon, String toolTipText, boolean selected)
	{
		this(index, name, text, icon, toolTipText, null, selected);
	}	
	
	public ElementNode(int index, String name, String text, Icon icon, String toolTipText, Object userObject)
	{
		this(index, name, text, icon, toolTipText, userObject, false);
	}
	
	
	public ElementNode(String name, String text, Icon icon, String toolTipText, Object userObject, boolean selected, boolean enabled)
	{
		this(-1, name, text, icon, toolTipText, userObject, selected, enabled);
	}
	
	public ElementNode(int index, String text, Icon icon, String toolTipText, Object userObject, boolean selected, boolean enabled)
	{
		this(index, null, text, icon, toolTipText, userObject, selected, enabled);
	}
	
	public ElementNode(int index, String name, String text, Icon icon, String toolTipText, boolean selected, boolean enabled)
	{
		this(index, name, text, icon, toolTipText, null, selected, enabled);
	}
	
	public ElementNode(int index, String name, String text, Icon icon, String toolTipText, Object userObject, boolean selected)
	{
		this(index, name, text, icon, toolTipText, userObject, selected, true);
	}
	
	
	public ElementNode(int index, String name, String text, Icon icon, String toolTipText, Object userObject, boolean selected, boolean enabled)
	{
		this(userObject);
		
		this.index = index;
		this.name = name;
		this.text = text;
		this.icon = icon;
		this.toolTipText = toolTipText;
		this.selected = selected;
		this.enabled = enabled;
	}	
	
	
	public ElementNode(Object userObject)
	{
		super(userObject);
	}
	
	public ElementNode(Object userObject, boolean allowsChildren)
	{
		super(userObject, allowsChildren);
	}	
	
	public int getIndex()
	{
		return index;
	}
	
	public void setIndex(int index)
	{
		this.index = index;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getText()
	{
		return text;
	}
	
	public void setText(String text)
	{
		this.text = text;
	}
	
	public Icon getIcon()
	{
		return icon;
	}
	
	public void setIcon(Icon icon)
	{
		this.icon = icon;
	}
	
	public String getToolTipText()
	{
		return toolTipText;
	}
	
	public void setToolTipText(String toolTipText)
	{
		this.toolTipText = toolTipText;
	}	
	
	public boolean isSelected()
	{
		return selected;
	}
	
	public void setSelected(boolean selected)
	{
		this.selected = selected;
	}
	
	public int getSelectedIndex()
	{
		return selectedIndex;
	}
	
	public void setSelectedIndex(int selectedIndex)
	{
		this.selectedIndex = selectedIndex;
	}
	
	public boolean isEnabled()
	{
		return enabled;
	}
	
	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}	
	
	public boolean isAnimation()
	{
		return animation;
	}
	
	public void setAnimation(boolean animation)
	{
		this.animation = animation;
	}	
	
	public String toString()
	{
		return text;
	}
	
	public ElementNode deepClone()
	{
		return (ElementNode) CloneUtil.deepClone(this);
	}
}