package com.nepxion.swing.style.framework;

/**
 * <p>Description: Nepxion Swing Repository</p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: Nepxion</p>
 * @author Neptune
 * @email hj_ren@msn.com
 * @version 1.0
 */

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
	
	public static void setThemeDecorated(boolean isThemeDecorated)
	{
		if (isThemeDecorated)
		{
			LookAndFeelTheme.setTheme(LookAndFeelTheme.ECLIPSE3X_STYLE);
			
			UIDefaults uiDefaults = UIManager.getLookAndFeelDefaults();
			uiDefaults.put("DockableFrame.activeTitleBackground", style.getTabbedPaneGradientColor());
			uiDefaults.put("DockableFrame.activeTitleBackground2", style.getTabbedPaneBackground());
			uiDefaults.put("JideTabbedPane.background", UIManager.getColor("Panel.background"));
			uiDefaults.put("JideTabbedPane.selectedTabTextForeground", style.getTabbedPaneSelectionForeground());
			uiDefaults.put("JideTabbedPane.unselectedTabTextForeground", style.getTabbedPaneForeground());
		}
		else
		{
			LookAndFeelTheme.setTheme(LookAndFeelTheme.VSNET_STYLE_WITHOUT_MENU);
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
	
	public static void setTabbedPaneDecorated(boolean isTabbedPaneDecorated)
	{
		
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