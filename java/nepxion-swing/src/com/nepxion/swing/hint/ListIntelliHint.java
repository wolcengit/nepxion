package com.nepxion.swing.hint;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.util.List;

import javax.swing.text.JTextComponent;

import com.jidesoft.hints.ListDataIntelliHints;

public class ListIntelliHint
	extends ListDataIntelliHints
{
	public ListIntelliHint(JTextComponent textComponent, List list)
	{
		super(textComponent, list);
	}
	
	public ListIntelliHint(JTextComponent textComponent, String[] stringArray)
	{
		super(textComponent, stringArray);
	}
}