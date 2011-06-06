package com.nepxion.swing.style.framework;

/**
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

import com.nepxion.swing.lookandfeel.LookAndFeelTheme;

public class StyleManager
{
	private static IStyle style;
	
	public static void setStyle(String styleClass)
	{
		try
		{
			style = (IStyle) Class.forName(styleClass).newInstance();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void setThemeDecorated()
	{		
		LookAndFeelTheme.setTheme(LookAndFeelTheme.ECLIPSE3X_STYLE);
		
		UIDefaults uiDefaults = UIManager.getLookAndFeelDefaults();
		
		Color tabbedPaneGradientColor = style.getTabbedPaneGradientColor();
		if (tabbedPaneGradientColor != null)
		{	
			uiDefaults.put("DockableFrame.activeTitleBackground", tabbedPaneGradientColor);
		}
		
		Color tabbedPaneBackground = style.getTabbedPaneBackground();
		if (tabbedPaneBackground != null)
		{	
			uiDefaults.put("DockableFrame.activeTitleBackground2", tabbedPaneBackground);
		}
		
		Color background = UIManager.getColor("Panel.background");
		if (background != null)
		{	
			uiDefaults.put("JideTabbedPane.background", background);
		}
		
		Color tabbedPaneSelectionForeground = style.getTabbedPaneSelectionForeground();
		if (tabbedPaneSelectionForeground != null)
		{	
			uiDefaults.put("JideTabbedPane.selectedTabTextForeground", tabbedPaneSelectionForeground);
		}
		
		Color tabbedPaneForeground = style.getTabbedPaneForeground();
		if (tabbedPaneForeground != null)
		{	
			uiDefaults.put("JideTabbedPane.unselectedTabTextForeground", tabbedPaneForeground);
		}
		
		Color tabbedPaneBorderLineColor = style.getTabbedPaneBorderLineColor();
		if (tabbedPaneBorderLineColor != null)
		{	
			uiDefaults.put("JideTabbedPane.shadow", tabbedPaneBorderLineColor);
		}
	}
	
	public static void setFrameDecorated(boolean isFrameDecorated)
	{
		JFrame.setDefaultLookAndFeelDecorated(isFrameDecorated);
	}
	
	public static void setDialogDecorated(boolean isDialogDecorated)
	{
		JDialog.setDefaultLookAndFeelDecorated(isDialogDecorated);
	}
	
	public static IStyle getStyle()
	{
		if (style == null)
		{
			style = new JLiteStyle();
		}
		
		return style;
	}
}