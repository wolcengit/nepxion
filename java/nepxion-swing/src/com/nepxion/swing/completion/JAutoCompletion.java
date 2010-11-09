package com.nepxion.swing.completion;

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

import javax.swing.JComboBox;
import javax.swing.text.JTextComponent;

import com.jidesoft.swing.AutoCompletion;
import com.jidesoft.swing.Searchable;

public class JAutoCompletion
	extends AutoCompletion
{
	public JAutoCompletion(JComboBox comboBox)
	{
		super(comboBox);
	}
	
	public JAutoCompletion(JComboBox comboBox, Searchable searchable)
	{
		super(comboBox, searchable);
	}
	
	public JAutoCompletion(JTextComponent textComponent, Searchable searchable)
	{
		super(textComponent, searchable);
	}
	
	public JAutoCompletion(JTextComponent textComponent, List list)
	{
		super(textComponent, list);
	}
	
	public JAutoCompletion(JTextComponent textComponent, Object[] array)
	{
		super(textComponent, array);
	}
}