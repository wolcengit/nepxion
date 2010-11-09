package com.nepxion.swing.window;

/**
 * <p>Title: Nepxion Swing</p>
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Window;

public class WindowManager
{
	public static void setCenter(Window window)
	{
		setCenter(window, null);
	}
	
	public static void setCenter(Window window, Dimension windowDimension)
	{
		Rectangle screenBounds = getPreferredBounds(window);
		if (windowDimension == null)
		{
			windowDimension = new Dimension(screenBounds.width, screenBounds.height);
		}
		setCenter(window, screenBounds, windowDimension);
	}
	
	public static void setCenter(Window window, Rectangle screenBounds, Dimension windowDimension)
	{
		window.setSize(windowDimension);
		window.setLocation((int) (screenBounds.width - windowDimension.width) / 2 + screenBounds.x, (int) (screenBounds.height - windowDimension.height) / 2 + screenBounds.y);
	}
	
	public static void setAlwaysOnTop(Window window, boolean isAlwaysOnTop)
	{
		window.setAlwaysOnTop(isAlwaysOnTop);
		// NativeSkin.getInstance().setAlwaysOnTop(window, isAlwaysOnTop);
	}
	
	public static Rectangle getPreferredBounds(Window window)
	{
		GraphicsConfiguration configuration = window.getGraphicsConfiguration();
		Rectangle bounds = configuration.getBounds();
		Insets screenInsets = window.getToolkit().getScreenInsets(configuration);
		bounds = new Rectangle(screenInsets.left, screenInsets.top, bounds.width - screenInsets.right - screenInsets.left, bounds.height - screenInsets.bottom - screenInsets.top);
		return bounds;
	}
}