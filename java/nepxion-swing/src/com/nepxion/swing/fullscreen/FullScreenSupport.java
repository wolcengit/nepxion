package com.nepxion.swing.fullscreen;

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
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JWindow;
import javax.swing.KeyStroke;

import com.nepxion.swing.handle.HandleManager;
import com.nepxion.swing.keystroke.KeyStrokeManager;

public class FullScreenSupport
{
	private JWindow fullScreenWindow;
	private Container container;
	
	private Component fullScreenComponent;
	private Object layoutConstraints;
	
	public FullScreenSupport(Component fullScreenComponent)
	{
		this(fullScreenComponent, null, null);
	}
	
	public FullScreenSupport(Component fullScreenComponent, Object layoutConstraints)
	{
		this(fullScreenComponent, layoutConstraints, null);
	}
	
	public FullScreenSupport(Component fullScreenComponent, KeyStroke toggleFullScreenKeyStroke)
	{
		this(fullScreenComponent, null, toggleFullScreenKeyStroke);
	}
	
	public FullScreenSupport(Component fullScreenComponent, Object layoutConstraints, KeyStroke toggleFullScreenKeyStroke)
	{
		this.fullScreenComponent = fullScreenComponent;
		this.layoutConstraints = layoutConstraints;
		if (fullScreenComponent instanceof JComponent)
		{
			JComponent component = (JComponent) fullScreenComponent;
			if (toggleFullScreenKeyStroke != null)
			{
				ActionListener toggleFullScreenActionListener = new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						toggleFullScreen();
					}
				};
				KeyStrokeManager.registerComponent(component, toggleFullScreenActionListener, toggleFullScreenKeyStroke);
			}
			ActionListener exitFullScreenActionListener = new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					exitFullScreen();
				}
				
			};
			KeyStrokeManager.registerComponentToEscapeKey(component, exitFullScreenActionListener);
		}
	}
	
	public void toggleFullScreen()
	{
		if (isFullScreen())
		{
			exitFullScreen();
		}
		else
		{
			showFullScreen();
		}
	}
	
	public void showFullScreen()
	{
		if (fullScreenWindow != null || fullScreenComponent == null)
		{
			return;
		}
		
		Window parentWindow = HandleManager.getWindow(fullScreenComponent);
		if (parentWindow == null)
		{
			fullScreenWindow = new JWindow();
		}
		else
		{
			fullScreenWindow = new JWindow(parentWindow, parentWindow.getGraphicsConfiguration());
		}
		
		container = fullScreenComponent.getParent();
		if (container != null)
		{
			container.remove(fullScreenComponent);
			if (container instanceof JComponent)
			{
				((JComponent) container).revalidate();
			}
			else
			{
				container.invalidate();
			}
		}
		
		fullScreenWindow.getContentPane().setLayout(new BorderLayout());
		fullScreenWindow.getContentPane().add(fullScreenComponent, BorderLayout.CENTER);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		GraphicsConfiguration graphicsconfiguration = fullScreenWindow.getGraphicsConfiguration();
		Insets insets = toolkit.getScreenInsets(graphicsconfiguration);
		dimension.width -= insets.left + insets.right;
		dimension.height -= insets.top + insets.bottom;
		fullScreenWindow.setSize(dimension);
		fullScreenWindow.setLocation(insets.left, insets.top);
		
		fullScreenWindow.setVisible(true);
		fullScreenWindow.validate();
		fullScreenComponent.requestFocus();
	}
	
	public void exitFullScreen()
	{
		if (fullScreenWindow == null)
		{
			return;
		}
		
		fullScreenWindow.getContentPane().removeAll();
		fullScreenWindow.setVisible(false);
		fullScreenWindow.dispose();
		fullScreenWindow = null;
		if (container != null)
		{
			if (layoutConstraints == null)
			{
				container.add(fullScreenComponent);
			}
			else
			{
				container.add(fullScreenComponent, layoutConstraints);
			}
			if (container instanceof JComponent)
			{
				((JComponent) container).revalidate();
			}
			else
			{
				container.invalidate();
			}
		}
		fullScreenComponent.requestFocus();
	}
	
	public boolean isFullScreen()
	{
		return fullScreenWindow != null;
	}
}