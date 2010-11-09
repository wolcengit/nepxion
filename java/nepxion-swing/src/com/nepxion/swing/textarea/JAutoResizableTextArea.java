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

import javax.swing.text.Document;

import com.jidesoft.swing.AutoResizingTextArea;
import com.nepxion.swing.textcomponent.PopupMenuAdapter;

public class JAutoResizableTextArea
	extends AutoResizingTextArea
{
	private PopupMenuAdapter popupMenuAdapter;
	
	public JAutoResizableTextArea()
	{
		super();
		
		popupMenuAdapter = new PopupMenuAdapter(this);
	}
	
	public JAutoResizableTextArea(int minimumRows)
	{
		super(minimumRows);
		
		popupMenuAdapter = new PopupMenuAdapter(this);
	}
	
	public JAutoResizableTextArea(int minimumRows, int maximumRows)
	{
		super(minimumRows, maximumRows);
		
		popupMenuAdapter = new PopupMenuAdapter(this);
	}
	
	public JAutoResizableTextArea(String text)
	{
		super(text);
		
		popupMenuAdapter = new PopupMenuAdapter(this);
	}
	
	public JAutoResizableTextArea(int minimumRows, int maximumRows, int columns)
	{
		super(minimumRows, maximumRows, columns);
		
		popupMenuAdapter = new PopupMenuAdapter(this);
	}
	
	public JAutoResizableTextArea(String text, int minimumRows, int maximumRows, int columns)
	{
		super(text, minimumRows, maximumRows, columns);
		
		popupMenuAdapter = new PopupMenuAdapter(this);
	}
	
	public JAutoResizableTextArea(Document doc)
	{
		super(doc);
		
		popupMenuAdapter = new PopupMenuAdapter(this);
	}
	
	public JAutoResizableTextArea(Document doc, String text, int minimumRows, int maximumRows, int columns)
	{
		super(doc, text, minimumRows, maximumRows, columns);
		
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