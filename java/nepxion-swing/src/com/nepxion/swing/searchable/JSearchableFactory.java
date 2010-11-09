package com.nepxion.swing.searchable;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.text.JTextComponent;

import com.jidesoft.swing.Searchable;
import com.jidesoft.swing.SearchableBar;

public class JSearchableFactory
{
	public static JTreeSearchable installSearchable(JTree tree)
	{
		JTreeSearchable treeSearchable = new JTreeSearchable(tree);
		treeSearchable.setRepeats(true);
		treeSearchable.setRecursive(true);
		return treeSearchable;
	}
	
	public static JTableSearchable installSearchable(JTable table)
	{
		JTableSearchable tableSearchable = new JTableSearchable(table);
		tableSearchable.setRepeats(true);
		return tableSearchable;
	}
	
	public static JListSearchable installSearchable(JList list)
	{
		JListSearchable listSearchable = new JListSearchable(list);
		listSearchable.setRepeats(true);
		return listSearchable;
	}
	
	public static JComboBoxSearchable installSearchable(JComboBox comboBox)
	{
		JComboBoxSearchable comboBoxSearchable = new JComboBoxSearchable(comboBox);
		comboBoxSearchable.setRepeats(true);
		return comboBoxSearchable;
	}
	
	public static JTextComponentSearchable installSearchable(JTextComponent textComponent)
	{
		JTextComponentSearchable textComponentSearchable = new JTextComponentSearchable(textComponent);
		textComponentSearchable.setRepeats(true);
		return textComponentSearchable;
	}
	
	public static void uninstallSearchable(Searchable searchable)
	{
		searchable.uninstallListeners();
	}
	
	public static void installSearchableBar(JComponent component, final JSearchableContainer searchableContainer)
	{
		Searchable searchable = null;
		if (component instanceof JTree)
		{
			searchable = installSearchable((JTree) component);
		}
		else if (component instanceof JTable)
		{
			searchable = installSearchable((JTable) component);
		}
		else if (component instanceof JList)
		{
			searchable = installSearchable((JList) component);
		}
		else if (component instanceof JComboBox)
		{
			searchable = installSearchable((JComboBox) component);
		}
		else if (component instanceof JTextComponent)
		{
			searchable = installSearchable((JTextComponent) component);
		}
		
		if (searchable == null)
		{
			return;
		}
		
		searchable.setRepeats(true);
		SearchableBar searchableBar = SearchableBar.install(searchable, KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_MASK), new SearchableBar.Installer()
		{
			public void openSearchBar(SearchableBar searchableBar)
			{
				searchableContainer.show(searchableBar);
			}
			
			public void closeSearchBar(SearchableBar searchableBar)
			{
				searchableContainer.hide(searchableBar);
			}
		}
		);
	}
}