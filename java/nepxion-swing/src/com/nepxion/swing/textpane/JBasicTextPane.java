package com.nepxion.swing.textpane;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

import com.nepxion.swing.textcomponent.PopupMenuAdapter;

public class JBasicTextPane
	extends JTextPane
{
	private PopupMenuAdapter popupMenuAdapter;
	
	public JBasicTextPane()
	{
		super();
		
		popupMenuAdapter = new PopupMenuAdapter(this);
	}
	
	public JBasicTextPane(StyledDocument doc)
	{
		super(doc);
		
		popupMenuAdapter = new PopupMenuAdapter(this);
	}
	
	public PopupMenuAdapter getPopupMenuAdapter()
	{
		return popupMenuAdapter;
	}
	
	public void setEnabled(boolean enabled)
	{
		super.setEnabled(enabled);
		
		if (enabled)
		{
			addMouseListener(popupMenuAdapter);
		}
		else
		{
			removeMouseListener(popupMenuAdapter);
		}
	}	
}