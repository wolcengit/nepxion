package com.nepxion.swing.outlookbar;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.l2fprod.common.swing.JOutlookBar;
import com.l2fprod.common.swing.plaf.OutlookBarUI;
import com.nepxion.swing.style.outlookbar.JFlatOutlookBarUI;

public class JFlatOutlookBar
	extends JOutlookBar implements SwingConstants
{
	public JFlatOutlookBar()
	{
		super();
		
		initComponents();
	}
	
	public JFlatOutlookBar(int tabPlacement)
	{
		super(tabPlacement);
		
		initComponents();
	}
	
	private void initComponents()
	{
		JFlatOutlookBarUI outlookBarUI = new JFlatOutlookBarUI();
		setUI((OutlookBarUI) outlookBarUI);
		setBackground(UIManager.getColor("Panel.background"));
		setAnimated(false);
	}
	
	public JScrollPane makeScrollPane(Component component)
	{
		JScrollPane scrollPane = super.makeScrollPane(component);
				
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		FlatOutlookBarManager.setPreferenceStyle(scrollPane);
		
		return scrollPane;
	}
	
	public void setAllTabsAlignment(int alignment)
	{
		setAllTabsAlignment(alignment, 10);
	}
	
	public void setAllTabsAlignment(int alignment, int indent)
	{
		JFlatOutlookBarUI outlookBarUI = (JFlatOutlookBarUI) getUI();
		switch (alignment)
		{
			case LEFT:
				break;
			case CENTER:
				indent = 0;
				break;
			case RIGHT:
				indent = -indent;
				break;
		}
		outlookBarUI.getButtonUI().setIndent(indent);
		
		super.setAllTabsAlignment(alignment);
	}
	
	public String getSelectedTitle()
	{
		int index = getSelectedIndex();
		if (index == -1)
		{
			return null;
		}
		
		return getTitleAt(index);
	}
	
	public Component getTabAt(String title)
	{
		for (int i = 0; i < getTabCount(); i++)
		{
			if (getTitleAt(i).equals(title))
			{
				return getComponentAt(i);
			}
		}
		
		return null;
	}
	
	public void removeTabAt(String title)
	{
		for (int i = 0; i < getTabCount(); i++)
		{
			if (getTitleAt(i).equals(title))
			{
				removeTabAt(i);
				break;
			}
		}
	}
	
	public void removeTabs(List closedComponents)
	{
		for (int i = 0; i < closedComponents.size(); i++)
		{
			Component closedComponent = (Component) closedComponents.get(i);
			
			super.removeTabAt(indexOfComponent(closedComponent));
		}
	}
	
	public void removeReverseTabsAt(int index)
	{
		List closedComponents = new ArrayList();
		for (int i = 0; i < getTabCount(); i++)
		{
			if (i != index)
			{
				Component component = getComponentAt(i);
				closedComponents.add(component);
			}
		}
		removeTabs(closedComponents);
	}
	
	public void removeAllTabs()
	{
		List components = new ArrayList();
		for (int i = 0; i < getTabCount(); i++)
		{
			Component component = getComponentAt(i);
			components.add(component);
		}
		removeTabs(components);
	}
}