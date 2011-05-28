package com.nepxion.swing.framework.ribbon;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import com.nepxion.swing.container.JContainer;
import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.internalframe.InternalFrameManager;
import com.nepxion.swing.locale.SwingLocale;
import com.nepxion.swing.optionpane.JBasicOptionPane;
import com.nepxion.swing.popupmenu.JDecorationPopupMenu;
import com.nepxion.swing.selector.checkbox.JCheckBoxSelector;
import com.nepxion.swing.tabbedpane.ITabbedPane;
import com.nepxion.swing.tabbedpane.TabbedPaneManager;

public class JRibbonContainer
	extends JContainer
{
	/**
	 * The instance of JDesktopPane.
	 */
	private JDesktopPane desktopPane;
	
	/**
	 * The instance of ITabbedPane.
	 */
	private ITabbedPane tabbedPane;
	
	/**
	 * The instance of JCheckBoxSelector.
	 */
	private JCheckBoxSelector checkBoxSelector;
	
	/**
	 * The boolean value of isInternalFrame.
	 * The ribbon components in the JDesktopPane can display for two styles : InternalFrame Style and TabbedPane Style.
	 * If isInternalFrame is true, it will display as InternalFrame style, otherwise as TabbedPane.
	 */
	private boolean isInternalFrame = true;
	
	/**
	 * The maximum count.
	 * It is limited the count of ribbon components.
	 * If the count of ribbon components >= the maximum count, a warning dialog will show and it can't open more ribbon components.
	 */
	private int maximumCount = 8;
	
	/**
	 * Constructs with the default.
	 */
	public JRibbonContainer()
	{
		desktopPane = new JDesktopPane();
		desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

		setLayout(new BorderLayout());
		addComponent(desktopPane, BorderLayout.CENTER);
	}
	
	/**
	 * Adds the ribbon component to the ribbon container.
	 * If the name is as the handle of ribbon component, it should be exclusive.
	 * @param name the name string
	 * @param title the title string
	 * @param icon the instance of Icon
	 * @param toolTipText the tooltip text
	 * @param component the instance of IRibbonComponent and it also is the instanceof JComponent
	 */
	public void addRibbonComponent(String name, String title, Icon icon, String toolTipText, IRibbonComponent component)
	{
		JComponent ribbonComponent = (JComponent) component;
		JComponent handler = retrieveRibbonComponent(ribbonComponent);
		
		if (isInternalFrame)
		{
			JInternalFrame internalFrame = null;
			
			if (handler == null)
			{
				JInternalFrame[] internalFrames = desktopPane.getAllFrames();
				
				if (internalFrames.length >= maximumCount)
				{
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame(this), SwingLocale.getString("open_panel_count_limited") + " " + maximumCount + " " + SwingLocale.getString("open_panel_suffix"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
					
					return;
				}	
				
				int x = 0;
				int y = 0;
				
				if (internalFrames.length != 0)
				{	
					x = (6 + 10) * internalFrames.length;
					y = (25 + 10) * internalFrames.length;
				}
				
				int width = ribbonComponent.getSize().width;
				int height = ribbonComponent.getSize().height;
				
				internalFrame = new JInternalFrame(title, true, true, true, true);
				internalFrame.setName(name);
				internalFrame.setFrameIcon(icon);
				internalFrame.setToolTipText(toolTipText);
				internalFrame.setContentPane(ribbonComponent);
				internalFrame.setSize(width != 0 ? width  + 50 : 640, height != 0 ? height + 50 : 480);
				internalFrame.setLocation(x, y);
				internalFrame.setVisible(true);
				ribbonComponent.setName(name);
				
				desktopPane.add(internalFrame);
			}
			else
			{
				internalFrame = (JInternalFrame) handler;
			}
			
			try
			{
				internalFrame.setSelected(true);
			}
			catch (PropertyVetoException e)
			{
				e.printStackTrace();
			}
		}
		else
		{			
			JComponent tabbedComponent = (JComponent) tabbedPane;
			if (tabbedComponent.getParent() == null)
			{
				addComponent(tabbedComponent, BorderLayout.CENTER);
			}
			
			if (handler == null)
			{
				if (tabbedPane.getTabCount() >= maximumCount)
				{
					JBasicOptionPane.showMessageDialog(HandleManager.getFrame(this), SwingLocale.getString("open_panel_count_limited") + " " + maximumCount + " " + SwingLocale.getString("open_panel_suffix"), SwingLocale.getString("warning"), JBasicOptionPane.WARNING_MESSAGE);
					
					return;
				}	
				
				tabbedPane.addTab(title, icon, ribbonComponent, toolTipText, true);
				tabbedPane.setSelectedComponent(ribbonComponent);
				
				ribbonComponent.setName(name);
			}
			else
			{
				tabbedPane.setSelectedComponent(handler);
			}
		}
	}
	
	/**
	 * Closes the ribbon components by a check box selector.
	 */
	public void closeRibbonComponent()
	{
		if (isInternalFrame)
		{
			InternalFrameManager.showCloseDialog(desktopPane, checkBoxSelector);
		}
		else if (tabbedPane != null && tabbedPane.getParent() != null)
		{
			TabbedPaneManager.showCloseDialog(tabbedPane, checkBoxSelector);
		}
	}
	
	/**
	 * Retrieves the ribbon component.
	 * If a given component is existed in the ribbon container, it will return the component, otherwise return null.
	 * @param component the instance of JComponent
	 * @return the instance of JComponent
	 */
	private JComponent retrieveRibbonComponent(JComponent component)
	{
		if (isInternalFrame)
		{
			JInternalFrame[] internalFrames = desktopPane.getAllFrames();
			
			for (int i = 0; i < internalFrames.length; i++)
			{
				JInternalFrame internalFrame = internalFrames[i];
				
				JComponent c = (JComponent) internalFrame.getContentPane();
				
				if (c == component)
				{
					return internalFrame;
				}
			}
			
			return null;
		}
		else
		{
			for (int i = 0; i < tabbedPane.getTabCount(); i++)
			{
				JComponent c = (JComponent) tabbedPane.getComponentAt(i);
				
				if (c == component)
				{
					return component;
				}
			}
			
			return null;
		}
	}
	
	/**
	 * Returns true if it is InternalFrame style.
	 * @return the boolean value of isInternalFrame
	 */
	public boolean isInternalFrame()
	{
		return isInternalFrame;
	}
	
	/**
	 * Sets the InternalFrame style or not.
	 * @param isInternalFrame the boolean value of isInternalFrame
	 */
	public void setInternalFrame(boolean isInternalFrame)
	{
		this.isInternalFrame = isInternalFrame;
	}
	
	/**
	 * Gets the maximum count.
	 * @return the maximum count value
	 */
	public int getMaximumCount()
	{
		return maximumCount;
	}
	
	/**
	 * Sets the maximum count.
	 * @param maximumCount the maximum count value
	 */
	public void setMaximumCount(int maximumCount)
	{
		this.maximumCount = maximumCount;
	}
	
	/**
	 * Gets the desktop pane.
	 * @return the instance of JDesktopPane
	 */
	public JDesktopPane getDesktopPane()
	{
		return desktopPane;
	}
	
	/**
	 * Gets the tabbed pane.
	 * @return the instance of ITabbedPane
	 */
	public ITabbedPane getTabbedPane()
	{
		return tabbedPane;
	}
	
	/**
	 * Sets the tabbed pane.
	 * @param tabbedPane the instance of ITabbedPane
	 */
	public void setTabbedPane(final ITabbedPane tabbedPane)
	{
		this.tabbedPane = tabbedPane;
		
		tabbedPane.setPopupMenu(new JDecorationPopupMenu(), true);
		
		JComponent tabbedComponent = (JComponent) tabbedPane;
		tabbedComponent.addPropertyChangeListener(new PropertyChangeListener()
		{
			public void propertyChange(PropertyChangeEvent e)
			{
				if (e.getPropertyName().equals("__index_to_remove__"))
				{
					if (tabbedPane.getTabCount() == 0)
					{
						addComponent(desktopPane, BorderLayout.CENTER);
					}
				}
			}
		}
		);
	}
}