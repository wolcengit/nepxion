package com.nepxion.swing.textarea;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import javax.swing.JTextArea;
import javax.swing.text.Document;

import com.nepxion.swing.textcomponent.PopupMenuAdapter;

public class JBasicTextArea
	extends JTextArea
{
	private PopupMenuAdapter popupMenuAdapter;
	
	public JBasicTextArea()
	{
		super();
		
		popupMenuAdapter = new PopupMenuAdapter(this);
	}
	
	public JBasicTextArea(String text)
	{
		super(text);
		
		popupMenuAdapter = new PopupMenuAdapter(this);
	}
	
	public JBasicTextArea(int rows, int columns)
	{
		super(rows, columns);
		
		popupMenuAdapter = new PopupMenuAdapter(this);
	}
	
	public JBasicTextArea(String text, int rows, int columns)
	{
		super(text, rows, columns);
		
		popupMenuAdapter = new PopupMenuAdapter(this);
	}
	
	public JBasicTextArea(Document doc)
	{
		super(doc);
		
		popupMenuAdapter = new PopupMenuAdapter(this);
	}
	
	public JBasicTextArea(Document doc, String text, int rows, int columns)
	{
		super(doc, text, rows, columns);
		
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
	
	public void setLabelStyle()
	{
		TextAreaManager.setLabelStyle(this);
		
		removeMouseListener(popupMenuAdapter);
	}
}