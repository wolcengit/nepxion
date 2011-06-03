package com.nepxion.swing.tabbedpane;

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
import java.awt.Container;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

public interface ITabbedPane
	extends SwingConstants
{
	public int getTabPlacement();
	
	public void setTabPlacement(int tabPlacement);
	
	public void addTab(String title, Component component);
	
	public void addTab(String title, Component component, String toolTipText);
	
	public void addTab(String title, Icon icon, Component component);
	
	public void addTab(String title, Component component, boolean isClosable);
	
	public void addTab(String title, Component component, String toolTipText, boolean isClosable);
	
	public void addTab(String title, Icon icon, Component component, String toolTipText);
	
	public void addTab(String title, Icon icon, Component component, boolean isClosable);
	
	public void addTab(String title, Icon icon, Component component, String toolTipText, boolean isClosable);
	
	
	public int getTabCount();
	
	public int getSelectedIndex();
	
	public Component getComponentAt(int index);
	
	public void setSelectedComponent(Component component);
	
	public Container getParent();
	
	
	public String getSelectedTitle();
	
	public String getTitleAt(int index);
	
	public String getToolTipTextAt(int index);
	
	public Icon getIcon(int index);
	
	public boolean isTabClosableAt(int index);
	
	public void setTabClosableAt(int index, boolean isClosable);
	
	public Component getTabAt(String title);
	
	public List getClosableTabs();
	
	public void removeTabAt(int index);
	
	public void removeReverseTabsAt(int index);
	
	public void removeAllTabs();
	
	public void removeTabs(List components);
	
	public JPopupMenu getPopupMenu();
	
	public void setPopupMenu(JPopupMenu popupMenu, boolean isClosable);
}