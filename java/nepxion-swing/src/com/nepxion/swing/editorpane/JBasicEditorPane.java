package com.nepxion.swing.editorpane;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.io.IOException;
import java.net.URL;

import javax.swing.JEditorPane;

import com.nepxion.swing.textcomponent.PopupMenuAdapter;

public class JBasicEditorPane
	extends JEditorPane
{
	private PopupMenuAdapter popupMenuAdapter;
	
	public JBasicEditorPane()
	{
		super();
		
		popupMenuAdapter = new PopupMenuAdapter(this);
	}
	
	public JBasicEditorPane(URL initialPage)
		throws IOException
	{
		super(initialPage);
		
		popupMenuAdapter = new PopupMenuAdapter(this);
	}
	
	public JBasicEditorPane(String url)
		throws IOException
	{
		super(url);
		
		popupMenuAdapter = new PopupMenuAdapter(this);
	}
	
	public JBasicEditorPane(String type, String text)
	{
		super(type, text);
		
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