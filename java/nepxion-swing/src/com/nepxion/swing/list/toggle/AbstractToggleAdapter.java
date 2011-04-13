package com.nepxion.swing.list.toggle;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import com.nepxion.swing.element.IElementNode;
import com.nepxion.swing.toggle.ITogglePanel;
import com.nepxion.swing.toggle.JThreadTogglePanel;
import com.nepxion.swing.toggle.JToggleContentPanel;

public abstract class AbstractToggleAdapter
	implements IToggleAdapter
{
	private IToggleList toggleList;
	
	public AbstractToggleAdapter(IToggleList toggleList)
	{
		this.toggleList = toggleList;
		this.toggleList.setToggleAdapter(this);
	}
	
	public void invoke(int oldSelectedRow, int newSelectedRow)
	{
		if (newSelectedRow == -1)
		{
			return;
		}
		
		JToggleContentPanel toggleContentPanel = toggleList.getToggleContentPanel();
		if (toggleContentPanel == null)
		{
			return;
		}
		
		IElementNode elementNode = (IElementNode) toggleList.getModel().getElementAt(newSelectedRow);
		
		ITogglePanel togglePanel = getTogglePanel(elementNode);
		if (togglePanel == null)
		{
			return;
		}
		
		String text = elementNode.toString();
		
		if (togglePanel.getToggleName() == null)
		{
			togglePanel.setToggleName(text);
		}
		
		if (togglePanel.getToggleDescription() == null)
		{
			togglePanel.setToggleDescription(text);
		}
		
		toggleContentPanel.toggle(togglePanel);
		
		if (togglePanel instanceof JThreadTogglePanel)
		{
			JThreadTogglePanel threadTogglePanel = (JThreadTogglePanel) togglePanel;
			threadTogglePanel.execute();
		}
	}
	
	public IToggleList getToggleList()
	{
		return toggleList;
	}
	
	public abstract ITogglePanel getTogglePanel(IElementNode elementNode);
}