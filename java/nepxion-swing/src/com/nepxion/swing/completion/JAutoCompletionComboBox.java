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

import java.util.Vector;

import javax.swing.ComboBoxModel;

import com.jidesoft.swing.AutoCompletionComboBox;

public class JAutoCompletionComboBox
	extends AutoCompletionComboBox
{
	public JAutoCompletionComboBox()
	{
		super();
	}
	
	public JAutoCompletionComboBox(Vector items)
	{
		super(items);
	}
	
	public JAutoCompletionComboBox(final Object items[])
	{
		super(items);
	}
	
	public JAutoCompletionComboBox(ComboBoxModel aModel)
	{
		super(aModel);
	}
}