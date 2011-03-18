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

import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import com.nepxion.swing.container.JContainer;
import com.nepxion.swing.tabbedpane.ITabbedPane;

public class JRibbonContainer
	extends JContainer
{
	private JDesktopPane desktopPane;
	private ITabbedPane tabbedPane;
	
	private boolean isInternalFrame = true;
	
	public JRibbonContainer()
	{
		desktopPane = new JDesktopPane();
		
		setLayout(new BorderLayout());
		addComponent(desktopPane, BorderLayout.CENTER);
	}
	
	public void addRibbon(String title, String toolTipText, JComponent component)
	{
		JComponent handler = retrieveRobbin(component);
		
		if (isInternalFrame)
		{
			JInternalFrame internalFrame = null;
			
			if (handler == null)
			{
				internalFrame = new JInternalFrame(title, true, true, true, true);
				internalFrame.setToolTipText(toolTipText);
				internalFrame.setContentPane(component);
				internalFrame.setSize(640, 480);
				internalFrame.setLocation(0, 0);
				internalFrame.setVisible(true);
				
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
				tabbedPane.addTab(title, component, toolTipText, true);
			}
			
			tabbedPane.setSelectedComponent(component);
		}
	}
	
	public JComponent retrieveRobbin(JComponent component)
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
	
	public boolean isInternalFrame()
	{
		return isInternalFrame;
	}
	
	public void setInternalFrame(boolean isInternalFrame)
	{
		this.isInternalFrame = isInternalFrame;
	}
	
	public JDesktopPane getDesktopPane()
	{
		return desktopPane;
	}
	
	public ITabbedPane getTabbedPane()
	{
		return tabbedPane;
	}
	
	public void setTabbedPane(final ITabbedPane tabbedPane)
	{
		this.tabbedPane = tabbedPane;
		
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