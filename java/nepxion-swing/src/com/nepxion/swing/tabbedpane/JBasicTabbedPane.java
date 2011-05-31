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
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import com.nepxion.swing.icon.paint.CloseIcon;
import com.nepxion.swing.icon.paint.CloseTabIcon;

public class JBasicTabbedPane
	extends JTabbedPane implements ITabbedPane, MouseListener
{
	private JPopupMenu popupMenu;
	private PopupMenuAdapter popupMenuAdapter;
	
	private CloseIcon closeIcon;
	
	private boolean isDrawBorder = true;
	private boolean isDrawCenter = true;
	private boolean isHint = false;
	
	public JBasicTabbedPane()
	{
		super();
		
		initComponents();
	}
	
	public JBasicTabbedPane(int tabPlacement)
	{
		super(tabPlacement);
		
		initComponents();
	}
	
	public JBasicTabbedPane(int tabPlacement, int tabLayoutPolicy)
	{
		super(tabPlacement, tabLayoutPolicy);
		
		initComponents();
	}
	
	private void initComponents()
	{
		TabbedPaneManager.setPreferenceStyle(this);
		
		addMouseListener(this);
	}
	
	public void addTab(String title, Component component)
	{
		addTab(title, component, null);
	}
	
	public void addTab(String title, Component component, String toolTipText)
	{
		addTab(title, null, component, toolTipText);
	}
	
	public void addTab(String title, Icon icon, Component component)
	{
		addTab(title, icon, component, null);
	}
	
	public void addTab(String title, Component component, boolean isClosable)
	{
		addTab(title, null, component, isClosable);
	}
	
	public void addTab(String title, Component component, String toolTipText, boolean isClosable)
	{
		addTab(title, null, component, toolTipText, isClosable);
	}
	
	public void addTab(String title, Icon icon, Component component, String toolTipText)
	{
		addTab(title, icon, component, toolTipText, false);
	}
	
	public void addTab(String title, Icon icon, Component component, boolean isClosable)
	{
		addTab(title, icon, component, null, isClosable);
	}
	
	public void addTab(String title, Icon icon, Component component, String toolTipText, boolean isClosable)
	{
		if (isClosable)
		{
			super.addTab(title, new CloseTabIcon(icon, isDrawBorder, isDrawCenter, isHint), component, toolTipText);
		}
		else
		{
			super.addTab(title, icon, component, toolTipText);
		}
	}
	
	public CloseIcon getCloseIcon(int index)
	{
		CloseTabIcon closeTabIcon = getCloseTabIcon(index);
		if (closeTabIcon != null)
		{
			return closeTabIcon.getCloseIcon();
		}
		
		return null;
	}
	
	public CloseTabIcon getCloseTabIcon(int index)
	{
		Icon icon = getIconAt(index);
		if (icon instanceof CloseTabIcon)
		{
			return ((CloseTabIcon) icon);
		}
		
		return null;
	}
	
	public boolean isDrawBorder()
	{		
		return isDrawBorder;
	}
	
	public void setDrawBorder( boolean isDrawBorder)
	{
		this.isDrawBorder = isDrawBorder;
	}
	
	public boolean isDrawBorder(int index)
	{
		CloseIcon closeIcon = getCloseIcon(index);
		if (closeIcon != null)
		{
			return closeIcon.isDrawBorder();
		}
		
		return false;
	}
	
	public void setDrawBorder(int index, boolean isDrawBorder)
	{
		CloseIcon closeIcon = getCloseIcon(index);
		if (closeIcon != null)
		{
			closeIcon.setDrawBorder(isDrawBorder);
			repaint();
		}
	}
	
	public boolean isDrawCenter()
	{
		return isDrawCenter;
	}
	
	public void setDrawCenter(boolean isDrawCenter)
	{
		this.isDrawCenter = isDrawCenter;
	}
	
	public boolean isDrawCenter(int index)
	{
		CloseIcon closeIcon = getCloseIcon(index);
		if (closeIcon != null)
		{
			return closeIcon.isDrawCenter();
		}
		
		return false;
	}
	
	public void setDrawCenter(int index, boolean isDrawCenter)
	{
		CloseIcon closeIcon = getCloseIcon(index);
		if (closeIcon != null)
		{
			closeIcon.setDrawCenter(isDrawCenter);
			repaint();
		}
	}
	
	public boolean isHint()
	{		
		return isHint;
	}
	
	public void setHint(boolean isHint)
	{
		this.isHint = isHint;
	}
	
	public boolean isHint(int index)
	{
		CloseTabIcon closeTabIcon = getCloseTabIcon(index);
		if (closeTabIcon != null)
		{
			return closeTabIcon.isHint();
		}
		
		return false;
	}
	
	public void setHint(int index, boolean isHint)
	{
		CloseTabIcon closeTabIcon = getCloseTabIcon(index);
		if (closeTabIcon != null)
		{
			closeTabIcon.setHint(isHint);
			repaint();
		}
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
	
	public Icon getIcon(int index)
	{
		CloseTabIcon closeTabIcon = getCloseTabIcon(index);
		if (closeTabIcon != null)
		{
			return closeTabIcon.getIcon();
		}
		else
		{
			return getIconAt(index);
		}
	}
	
	public boolean isTabClosableAt(int index)
	{
		CloseIcon closeIcon = getCloseIcon(index);
		
		return closeIcon != null;
	}
	
	public void setTabClosableAt(int index, boolean isClosable)
	{
		if (isClosable)
		{
			CloseTabIcon closeTabIcon = getCloseTabIcon(index);
			if (closeTabIcon == null)
			{
				setIconAt(index, new CloseTabIcon(getIconAt(index), isDrawBorder, isDrawCenter, isHint));
			}
		}
		else
		{
			CloseTabIcon closeTabIcon = getCloseTabIcon(index);
			if (closeTabIcon != null)
			{
				setIconAt(index, closeTabIcon.getIcon());
			}
		}
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
	
	public List getClosableTabs()
	{
		List components = new ArrayList();
		for (int i = 0; i < getTabCount(); i++)
		{
			if (isTabClosableAt(i))
			{
				Component component = getComponentAt(i);
				components.add(component);
			}
		}
		
		return components;
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
			if (i != index && isTabClosableAt(i))
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
			if (isTabClosableAt(i))
			{
				Component component = getComponentAt(i);
				components.add(component);
			}
		}
		removeTabs(components);
	}
	
	public JPopupMenu getPopupMenu()
	{
		return popupMenu;
	}
	
	public void setPopupMenu(JPopupMenu popupMenu, boolean isClosable)
	{
		this.popupMenu = popupMenu;
		
		if (isClosable)
		{
			popupMenuAdapter = new PopupMenuAdapter(this, popupMenu);
		}
	}
	
	public void mouseClicked(MouseEvent e)
	{
		if (!SwingUtilities.isLeftMouseButton(e))
		{
			return;
		}
		
		int index = indexAtLocation(e.getX(), e.getY());
		if (index < 0)
		{
			return;
		}
		
		CloseTabIcon closeTabIcon = getCloseTabIcon(index);
		if (closeTabIcon != null)
		{
			Rectangle rect = closeTabIcon.getBounds();
			if (rect.contains(e.getX(), e.getY()))
			{
				removeTabAt(index);
			}
		}
	}
	
	public void mouseEntered(MouseEvent e)
	{
	}
	
	public void mouseExited(MouseEvent e)
	{
	}
	
	public void mousePressed(MouseEvent e)
	{
		if (!SwingUtilities.isLeftMouseButton(e))
		{
			return;
		}
		
		int index = indexAtLocation(e.getX(), e.getY());
		if (index < 0)
		{
			return;
		}
		
		CloseTabIcon closeTabIcon = getCloseTabIcon(index);
		if (closeTabIcon != null)
		{
			Rectangle rect = closeTabIcon.getBounds();
			if (rect.contains(e.getX(), e.getY()))
			{
				closeIcon = closeTabIcon.getCloseIcon();
				closeIcon.setPressed(true);
				repaint();
			}
		}
	}
	
	public void mouseReleased(MouseEvent e)
	{
		if (closeIcon != null)
		{
			if (!SwingUtilities.isLeftMouseButton(e))
			{
				return;
			}
			
			closeIcon.setPressed(false);
			repaint();
			
			closeIcon = null;
		}
		
		if (popupMenu != null)
		{
			int index = indexAtLocation(e.getX(), e.getY());
			if (index < 0)
			{
				return;
			}
			
			if (!e.isPopupTrigger())
			{
				return;
			}
			
			setSelectedIndex(index);
			
			if (popupMenuAdapter != null)
			{
				popupMenuAdapter.adaptClosableItem(index);
			}			
			
			popupMenu.show(e.getComponent(), e.getX(), e.getY());
		}
	}
}